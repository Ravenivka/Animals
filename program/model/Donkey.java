package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Donkey extends PackAnimal{

    private String name;
    private LocalDate birthDay;
    private Gender sex;
    private ArrayList<String> list;

    public Donkey(String name){
        this.name = name;
        this.list = new ArrayList<>();
    }
    public Donkey(String name, LocalDate birthDay, Gender sex){
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
                string = "Осёл";
                break;
            case Gender.Female:
                string = "Ослиха";
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

}
