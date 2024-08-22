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
            animal.setCommand(string);
        }
    }

    public String clear(String string) {
        String s = string.replaceAll("^\"|\"$", "").trim();
        return s;
    }   

    private void saveTable(String tablePath, ArrayList<Animal> list) {
        this.dbManager.saveTable(tablePath, list);
    }
    private void append(String tablePath, String name, String sex, String commands, String birhdate, int index) {
        int i = this.Genus_id;
        String value = String.format("%d;\"%s\";\"%s\";\"%s\";\"%s\";%d", index + 1, name, sex, birhdate, commands, i);
        this.dbManager.append(tablePath, value);
    }

   public void addAnimal (String name, String sex, String commands, String birhdate,  String key) {
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

   


}
