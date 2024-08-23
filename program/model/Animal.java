package model;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Animal implements MainInterface{
    public abstract void setBirthDate(LocalDate value);
    public abstract String toString();
    public abstract void setGender (Gender gender);
    public abstract Gender getGender();
    public abstract String getCommandsString();
    public abstract ArrayList<String> getCommandList();
    public abstract LocalDate getBirthDate();
}
