package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Camel extends PackAnimal{

    private String name;   
    private ArrayList<String> list;

    public Camel(String name){
        this.name = name;
        this.list = new ArrayList<>();
    }    
    
    public Camel(String name, LocalDate birthDay, Gender sex){
        this(name);
        super.setBirthDate(birthDay);
        super.setGender(sex);
    }

    @Override
    public String getName() {
        return this.name;
    }

   

    public String toString() {
        String string = "";
        switch (super.getGender()){
            case Gender.Male:
                string = "Верблюд: Самец";
                break;
            case Gender.Female:
                string = "Верблюд: Самка";
                break;
        }
        string = string + " " + this.name;
        return string;
    }

   

   
    public ArrayList<String> getCommands() {
       return this.list;
    }

    @Override
    public String setCommand(String value) {
        try{
            list.add(value);
            return String.format("Комманда %s добавлена", value);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @Override
    public String showCommands() {
        if (this.list.isEmpty()){
            return "Список комманд пуст\n";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Список комманд:\n");
        for (String string : list) {
            sb.append(string);
            sb.append("\n");
        }
        return sb.toString();
    }

    

    @Override
    public ArrayList<String> getCommandList() {
        return this.list;
    }

}
