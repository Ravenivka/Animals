package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public abstract class PackAnimal extends Animal{
    
    private LocalDate birthDay;
    private Gender sex;

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

    @Override
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
}
