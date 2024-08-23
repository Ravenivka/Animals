package model;

import java.util.ArrayList;

public abstract class PackAnimal extends Animal{
    public String getCommandsString(){
        ArrayList<String> array = this.getCommandList();
        String listString = "\"" + String.join(", ", array) + "\"" ;
        return listString;
    }
}
