package model;

import java.util.ArrayList;

public abstract class Pet extends Animal{

    public String getCommandsString(){
        ArrayList<String> array = this.getCommandList();
        String listString = "\"" + String.join(", ", array) + "\"" ;
        return listString;
    }
}
