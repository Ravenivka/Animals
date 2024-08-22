package model;

import java.time.LocalDate;

public abstract class Animal implements MainInterface{
    public abstract void setBirthDate(LocalDate value);

    public abstract void setGender (Gender gender);
}
