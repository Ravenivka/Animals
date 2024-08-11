

import java.util.ArrayList;

import model.CSVmanager;

public class Program {

    public static void main(String[] args) {       
        CSVmanager manager = new CSVmanager("cats.csv");
        ArrayList<String> l = manager.getTitles();
        System.out.println(l.get(0));
       
        System.out.println(l.get(3));
    }
}
