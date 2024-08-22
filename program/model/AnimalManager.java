package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class AnimalManager {
    
    private ArrayList<ArrayList<String>> animalTypes;
    private ArrayList<ArrayList<String>> animals; 
    private String activeTable  ; 
    private DBManager dbManager;
    private DateTimeFormatter formatter;    
    private Animal animal;
    private ArrayList<Animal> animalCollection;
    private String cName ;

    public AnimalManager(){
        this.dbManager = new DBManager();
        this.animalClasses = dbManager.getAnimalClasses();
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    public void setActiveClass(String value){ 
        try{            
            int index = outerIndex(value, animalClasses);
            ArrayList<String> list = animalClasses.get(index)  ;
            String s = clear(list.get(2));
            this.animalTypes = dbManager.getAnimalTypesList(s)  ;  
        } catch (Exception e) {           
            this.animalTypes = null;
        }                        
    }
    

    private int outerIndex(String value, ArrayList<ArrayList<String>> list) {
        ArrayList<String> item;
        for(int i = 0; i < list.size(); i++) {
            item = list.get(i);
            if (value.equals(item.get(0))){
                return i;
            }            
        }
        int i = -1;
            return i;
    }

    public ArrayList<ArrayList<String>> getAnimalClasses() {
        return this.animalClasses;
    }

    public ArrayList<ArrayList<String>> getAnimalTypes() {
        return this.animalTypes ;
    }
    
    
    public String clear(String string) {
        String s = string.replaceAll("^\"|\"$", "").trim();
        return s;
    }

    public String createAnimal(String animalName, String gender, String typeNumber, String birthDate, String comList) {
        boolean valid = true;
        try {
            valid = check(animalName, gender, typeNumber, birthDate);
        } catch (Exception e) {
            return e.getMessage();
        }

        if (valid == false) {
            return "Неожиданная ошибка";
        }
        
        int id = this.animals.size();
        String addon = String.format("%d;\"%s\";\"%s\";\"%s\";\"%s\";%s", id, animalName, gender, birthDate, comList, typeNumber);
        try{
            append(this.activeTable, addon);
            return "OK";
        } catch (Exception e) {
            return (e.getMessage());
        }
    }

    public void setAnimTypeIndex(String typeNumber) {
        try{            
            int index = outerIndex(typeNumber, animalTypes);
            ArrayList<String> list = this.animalTypes.get(index)  ;
            String s = clear(list.get(3));
            this.animals = dbManager.getAnimalTypesList(s)  ; 
            this.activeTable = s;
            this.cName = clear(list.get(4));
        } catch (Exception e) {            
            this.animals = null;
            this.cName = null;
        }
    }

    private void saveTable(String tablePath, ArrayList<Animal> list) {
        this.dbManager.saveTable(tablePath, list);
    }
    private void append(String tablePath, String value) {
        this.dbManager.append(tablePath, value);
    }

    private boolean check(String animalName, String gender, String typeNumber, String birthDate) throws Exception {
        boolean boo = true;
        if (animalName.equals("")){
            boo = false;
            throw new RuntimeException("Нет имени");            
        }
        if (!(gender.equals("м") || gender.equals("ж"))) {
            boo = false;
            throw new RuntimeException("Пол не определён"); 
        }
        try{
            Integer.parseInt(typeNumber);
        } catch (Exception e) {
            boo = false;
            throw new RuntimeException("Должен быть номер");
        }
        try{
            LocalDate.parse(birthDate, this.formatter);
        } catch (Exception e) {
            boo = false;
            throw new RuntimeException("Неверный формат даты");
        }
        return boo;
    }

    public ArrayList<Animal> getCollection(String table) {
        ArrayList<Animal> listik = new ArrayList<>();
        Animal item = null;
        Gender gender;
        CSVmanager csv = new CSVmanager(table);
        ArrayList<ArrayList<String>> arrayList = csv.getValueArray();
        for (ArrayList<String> arrayList2 : arrayList) {
            String itemName = arrayList2.get(1);
            itemName = clear(itemName);
            String bd = clear(arrayList2.get(3));
            LocalDate birthdate = LocalDate.parse(bd, this.formatter);
            if (clear(arrayList2.get(2)).equals("м")) {
                gender = Gender.Male;
            } else {
                gender = Gender.Female;
            }
            switch (table){
                case "camels.csv":
                    item = new Camel(itemName, birthdate, gender);
                    break;
                case "cats.csv":
                    item = new Cat(itemName, birthdate, gender);
                    break;
                case "dogs.csv":
                    item = new Dog(itemName, birthdate, gender);
                    break;
                case "donkeys.csv":
                    item = new Donkey(itemName, birthdate, gender);
                    break;
                case "hamsters.csv":
                    item = new Hamster(itemName, birthdate, gender);
                    break;
                case "horses.csv":
                    item = new Horse(itemName, birthdate, gender);
                    break;
            }
            item = doList(arrayList2.get(4), item);
            listik.add(item);
        }
        return listik;
    }

    private Animal doList(String actionString, Animal animal2) {        
        String[] array = clear(actionString).split(",");
        
        for (String string : array) {
            animal2.setCommand(string);
        }
        return animal2;
    }


}
