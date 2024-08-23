package model;

import java.time.LocalDate;

public class Horse extends PackAnimal{

    public Horse(String name){
        super(name);
    }
    public Horse(String name, LocalDate birthDay, Gender sex){
        this(name);
        super.setBirthDate(birthDay);
        super.setGender(sex);
    }   
    
    public String toString() {
        String string = "";
        switch (super.getGender()){
            case Gender.Male:
                string = "Конь";
                break;
            case Gender.Female:
                string = "Лошадь";
                break;
        }
        string = string + " " + super.getName();
        return string;
    }    
}
