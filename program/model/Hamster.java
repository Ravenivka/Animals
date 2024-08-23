package model;

import java.time.LocalDate;

public class Hamster extends Pet{

   

    public Hamster(String name){
        super(name);
    }
    public Hamster(String name, LocalDate birthDay, Gender sex){
        this(name);
        super.setBirthDate(birthDay);
        super.setGender(sex);
    }   

    public String toString() {
        String string = "";
        switch (super.getGender()){
            case Gender.Male:
                string = "Хомяк: Самец";
                break;
            case Gender.Female:
                string = "Хомяк: Самка";
                break;
        }
        string = string + " " + super.getName();
        return string;
    }

}
