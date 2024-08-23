package model;

import java.io.IOException;
import java.util.ArrayList;

public class DBManager {  
    

    public ArrayList<ArrayList<String>> getAnimalList(String key) {
        CSVmanager cm = new CSVmanager(key);
        return cm.getValueArray();
    }

    public void saveTable(String tablePath, ArrayList<String> list) throws IOException {
        CSVmanager cm = new CSVmanager(tablePath);
        cm.save(list);
    }

    public void append(String tablePath, String value) throws IOException {
        CSVmanager cm = new CSVmanager(tablePath);
        cm.append(value);
    }
    
}
