package model;

import java.time.LocalDate;

public class Dog extends Pet{

    

    public Dog(String name){
        super(name);
    }
    public Dog(String name, LocalDate birthDay, Gender sex){
        this(name);
        super.setBirthDate(birthDay);
        super.setGender(sex);
    }   
   
    public String toString() {
        String string = "";
        switch (super.getGender()){
            case Gender.Male:
                string = "Кобель";
                break;
            case Gender.Female:
                string = "Сука";
                break;
        }
        string = string + " " + super.getName();
        return string;
    }

}
