package model;

import java.time.LocalDate;

public class Donkey extends PackAnimal{    

    public Donkey(String name){
        super(name);
    }
    public Donkey(String name, LocalDate birthDay, Gender sex){
        this(name);
        super.setBirthDate(birthDay);
        super.setGender(sex);
    }   
    
    public String toString() {
        String string = "";
        switch (super.getGender()){
            case Gender.Male:
                string = "Осёл";
                break;
            case Gender.Female:
                string = "Ослиха";
                break;
        }
        string = string + " " + super.getName();
        return string;
    }  

}
