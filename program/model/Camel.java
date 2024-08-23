package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Camel extends PackAnimal{

    private String name;
    private LocalDate birthDay;
    private Gender sex;
    private ArrayList<String> list;

    public Camel(String name){
        this.name = name;
        this.list = new ArrayList<>();
    }

    public void setBirthDate(LocalDate value){
        this.birthDay = value;
    }

    public void setGender (Gender gender) {
        this.sex = gender;
    }
    
    public Camel(String name, LocalDate birthDay, Gender sex){
        this(name);
        this.birthDay = birthDay;
        this.sex = sex;
    }

    @Override
    public String getName() {
        return this.name;
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

    public String toString() {
        String string = "";
        switch (this.sex){
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

    public Gender getGender() {
        return this.sex;
    }

    @Override
    public ArrayList<String> getCommandList() {
        return this.list;
    }

    @Override
    public LocalDate getBirthDate() {
        return this.birthDay;
    }


}
