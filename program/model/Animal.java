package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public abstract class Animal implements MainInterface{
    private String name;   
    private ArrayList<String> list;
    private LocalDate birthDay;
    private Gender sex;

    public Animal(String name){
        this.name = name;
        this.list = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    
    public abstract String toString();  
    
    public ArrayList<String> getCommandList() {
                return this.list;
    }   

    public String getCommandsString(){
        ArrayList<String> array = this.getCommandList();
        String listString = "\"" + String.join(", ", array) + "\"" ;
        return listString;
    }

    public void setBirthDate(LocalDate value){
        this.birthDay = value;
    }

    public void setGender (Gender gender) {
        this.sex = gender;
    }

    public Gender getGender() {
        return this.sex;
    }

    
    public LocalDate getBirthDate() {
        return this.birthDay;
    }

     @Override
    public String getAge() {
        Period period = Period.between(LocalDate.now(), birthDay);
        return String.format("%d", period.getYears());
    }
    public String getAgeInMonths() {
        Period period = Period.between(LocalDate.now(), birthDay);
        return String.format("%d", period.getMonths());
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.toString());
        sb.append("\n");
        sb.append(this.getAge());
        sb.append("\n");
        sb.append(this.showCommands());
        return sb.toString();
    }

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
    public String setCommand(String value) {
        try{
            list.add(value);
            return String.format("Комманда %s добавлена", value);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
