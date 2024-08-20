package model;

import java.util.ArrayList;

public class DBManager {     

    public ArrayList<ArrayList<String>> getAnimalClasses(){
        CSVmanager cm = new CSVmanager("animal_classes.csv");
        return cm.getValueArray();
    }

    public ArrayList<ArrayList<String>> getAnimalTypesList(String key) {
        CSVmanager cm = new CSVmanager(key);
        return cm.getValueArray();
    }

    public void saveTable(String tablePath, ArrayList<Animal> list) {
        CSVmanager cm = new CSVmanager(tablePath);
        cm.save(list);
    }

    public void append(String tablePath, String value) {
        CSVmanager cm = new CSVmanager(tablePath);
        cm.append(value);
    }

}
