package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class AnimalManager {    
    private DBManager dbManager;
    private DateTimeFormatter formatter; 
    private Animal selected;
    private ArrayList<Animal> selectedAnimals;
    private int Genus_id;
    private String selectedTable;

    public AnimalManager(){
        this.dbManager = new DBManager();        
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }  

    public void setSelected(int index) throws Exception {
        if (this.selectedAnimals == null || this.selectedAnimals.size() == 0){
            this.selected = null;
            throw new RuntimeException("Список пуст");
        }
        if (index >= this.selectedAnimals.size() || index < 0) {
            this.selected = null;
            throw new RuntimeException("Выбор вне области значений");
        }
        this.selected = this.selectedAnimals.get(index);
    }
    public Animal getSelected() {
        return this.selected;
    }
    private void setSelectedAnimals (String key) {
        this.selectedAnimals = new ArrayList<>();
        switch(key){
            case ("Вьючные животные"):
                this.selectedAnimals.addAll(selectAnimals("camels.csv"));
                this.selectedAnimals.addAll(selectAnimals("donkeys.csv"));
                this.selectedAnimals.addAll(selectAnimals("horses.csv"));
                break;
            case ("Домашние животные"):
                this.selectedAnimals.addAll(selectAnimals("cats.csv"));
                this.selectedAnimals.addAll(selectAnimals("hamsters.csv"));
                this.selectedAnimals.addAll(selectAnimals("dogs.csv"));
                break;
            case ("Полный список"):
                this.selectedAnimals.addAll(selectAnimals("camels.csv"));
                this.selectedAnimals.addAll(selectAnimals("donkeys.csv"));
                this.selectedAnimals.addAll(selectAnimals("horses.csv"));
                this.selectedAnimals.addAll(selectAnimals("cats.csv"));
                this.selectedAnimals.addAll(selectAnimals("hamsters.csv"));
                this.selectedAnimals.addAll(selectAnimals("dogs.csv"));
                break;
            default:
                this.selectedAnimals = selectAnimals(key);
                this.selectedTable = key;
                break;
        }

    }

    private ArrayList<Animal> selectAnimals (String key) {
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<ArrayList<String>> list = this.dbManager.getAnimalList(key);
        for (ArrayList<String> arrayList : list) {
            Gender gender;
            if (arrayList.get(2).equals("\"м\"")) {
                gender = Gender.Male;
            } else {
                gender = Gender.Female;
            }
            LocalDate day = LocalDate.parse(clear(arrayList.get(3)));
            Animal item = createAnimal(clear(arrayList.get(1)), gender, clear(arrayList.get(4)) , day, key);
            animals.add(item);
            this.Genus_id = Integer.parseInt(arrayList.get(5));
        }
       return animals;
    }
  
    
    private Animal createAnimal(String name, Gender gender, String commands, LocalDate birhdate,  String key) throws RuntimeException{
        Animal animal;
        switch (key) {
            case "camels.csv":
                animal = new Camel(name);
                break;
            case "cats.csv":
                animal = new Cat(name);
                break;
            case "dogs.csv":
                animal = new Dog(name);
                break;
            case "donkeys.csv":
                animal = new Donkey(name);
                break;
            case "hamsters.csv":
                animal = new Hamster(name);
                break;
            case "horses.csv":
                animal = new Horse(name);
                break;        
            default:                
                throw new RuntimeException("Незарегистрированный класс животного");                
        }
        animal.setGender(gender);
        animal.setBirthDate(birhdate);        
        writeCommands(animal, commands);
        return animal;
    }

    /* */

    private void writeCommands(Animal animal, String clear) { //Забавно сработало автосоздание метода ;)
        String[] array = clear.split(",");
        for (String string : array) {
            animal.setCommand(string.trim());
        }
    }

    public String clear(String string) {
        String s = string.replaceAll("^\"|\"$", "").trim();
        return s;
    }   

    private void saveTable(String tablePath, ArrayList<Animal> list) throws Exception {
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Animal item = list.get(i);
            String gender;
            if (item.getGender().equals(Gender.Female)){
                gender = "\"ж\"";
            } else {
                gender = "\"м\"";
            }
            String s = String.format("%d;\"%s\";%s;\"%s\";%s;%d\n" , i, item.getName(), gender, item.getBirthDate().format(this.formatter), item.getCommandsString(), this.Genus_id);
            array.add(s);            
        }
        this.dbManager.saveTable(tablePath, array);
    }

    private void append(String tablePath, String name, String sex, String commands, String birhdate, int index) throws Exception {
        int i = this.Genus_id;
        this.selectedTable = tablePath;
        String value = String.format("%d;\"%s\";\"%s\";\"%s\";\"%s\";%d", index + 1, name, sex, birhdate, commands, i);
        this.dbManager.append(tablePath, value);
    }

   public void addAnimal (String name, String sex, String commands, String birhdate,  String key) throws Exception {
        setSelectedAnimals(key);
        Gender gender;
            if (sex.equals("м")) {  
                gender = Gender.Male;
            } else {
                gender = Gender.Female;
            }
        LocalDate day = LocalDate.parse(birhdate, this.formatter);  
        append(key, name, sex, commands, birhdate, this.selectedAnimals.size());
        this.selected = createAnimal(name, gender, commands, day, key)  ;
        this.selectedAnimals.add(selected);
   }

public String showList(String choice) {
    setSelectedAnimals(choice)    ;
    if (this.selectedAnimals.isEmpty()){
        return "Список пуст";
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < this.selectedAnimals.size() ; i++) {
        sb.append(i);
        sb.append(" - ");
        sb.append(this.selectedAnimals.get(i).toString());
        sb.append("\n");
    }
    return sb.toString();
}

public boolean remove() throws RuntimeException {
    if (this.selected == null) {
        throw new RuntimeException("Животное отсутствует в списке");
    }
    try{
        this.selectedAnimals.remove(this.selected);
        this.selected = null;
        saveTable(this.selectedTable, selectedAnimals);
        return true;
    } catch (Exception e) {
        return false;
    }
}

public String addCommand(String nextLine) throws Exception {  
    try{
       String s = this.selected.setCommand(nextLine);
       saveTable(this.selectedTable, selectedAnimals);
       return s;
    } catch (Exception e) {
        return e.getMessage();
    }
     
   
}

public String showEnumeratedCommands(){
    ArrayList<String> array = this.selected.getCommandList();
    if(array.isEmpty()){
        return "";
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < array.size(); i++){
        sb.append(i);
        sb.append(" - ");
        sb.append(array.get(i));
        sb.append("\n");
    }
    return sb.toString();
}

public boolean removeCommand(int int1) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'removeCommand'");
}
   


}
