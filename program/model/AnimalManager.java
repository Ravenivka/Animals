package model;

import java.util.HashMap;

public class AnimalManager {

    private HashMap<String, String> animalClasses;
    private DBManager dbManager;
    private String classIndex;
    private String typeIndex;
    private Animal animal;

    public AnimalManager(){
        this.dbManager = new DBManager();
        this.animalClasses = dbManager.getAnimalClasses();
    }

    public HashMap<String, String> getAnimalClasses() {
        return this.animalClasses;
    }

    public void setActiveClass(String value){
        this.classIndex = value;        
    }

    public HashMap<String, String> getAnimalTypes() {
        return this.dbManager.getAnimalTypesList(classIndex);
    }
    

}
