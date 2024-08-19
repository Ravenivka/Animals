package model;

import java.util.ArrayList;
import java.util.HashMap;

public class DBManager {    

    private HashMap<String, String> animalClasses;


    public DBManager() {
        CSVmanager csVmanager = new CSVmanager("animal_classes.csv");
        this.animalClasses = new HashMap<>();
        ArrayList<ArrayList<String>> getValueArray = csVmanager.getValueArray();
        for (ArrayList<String> arrayList : getValueArray) {
            String key = cleaString(arrayList.get(1));
            String value = cleaString(arrayList.get(2));
            this.animalClasses.put(key, value);
        }

    }

    private String cleaString(String value) {
        String result = value.replaceAll("^\"+|\"+$", "").trim();
        return result;
    }

    public HashMap<String, String> getAnimalClasses(){
        return this.animalClasses;
    }

    public HashMap<String, String> getAnimalTypesList(String key) {
        String path = this.animalClasses.get(key);
        CSVmanager csVmanager = new CSVmanager(path);
        ArrayList<ArrayList<String>> getValueArray = csVmanager.getValueArray();
        HashMap<String, String> map = new HashMap<>();
        for (ArrayList<String> arrayList : getValueArray) {
            String index = arrayList.get(1);
            String value = arrayList.get(3);
            map.put(index, value);
        }
        return map;
    }

}
