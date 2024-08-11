package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CSVmanager {
    private String filename ;
    private ArrayList<String> titles;

    public  CSVmanager(String path){
    //_______________________________________________________________________________-не самый удачный путь, лучше решать через конфиг или .pom файл    
        String resDir;
        File resFile;
        File tmpf = new File("notes3.txt");
        try(FileWriter writer = new FileWriter(tmpf, false))
        {
           // запись всей строки
            String text = "Hello Gold!";
            writer.write(text);           
            writer.flush();
            Path dir = Paths.get(tmpf.getAbsolutePath());
            String rootdir = dir.getParent().getFileName().toString();
            //System.out.println(rootdir);

            switch(rootdir){
                case ("Animals"):
                    resFile = new File(new File(new File(dir.getParent().toString(), "program"), "model"), "resources");
                    resDir = resFile.getAbsolutePath();
                    break;
                case ("program"):
                    resFile = new File(new File(dir.getParent().toString(), "model"), "resources");
                    resDir = resFile.getAbsolutePath();
                    break;
                default:
                    resDir = ""; // "F:\\MyFolder\\Doc\\Учеба\\Animals\\program\\model\\resources"; //Задать вручную
                    break;
           }
           this.filename = new File(resDir, path).getAbsolutePath();
        }
        catch(IOException ex){             
            System.out.println(ex.getMessage());
        } 
    //____________________________________________________________________________________________________________________________________________конец блока вычисления пути к файлам CSV
    ArrayList<String> list = listing();
    this.titles = StringToList(list.get(0));
       
    } 
    
    private ArrayList<String> StringToList(String input){
        String[] array = input.split(";");
        ArrayList<String> aList = new ArrayList<>();
        for (String string : array) {
            String result = string.replaceAll("^\"+|\"+$", "").trim();
            aList.add(result) ;
        }
        return aList;
    }

    private ArrayList<String> listing(){
        ArrayList<String> list = new ArrayList<>();
       try {
            FileReader fr = new FileReader(this.filename);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        return list;
    }
/* 
    public ArrayList<ArrayList<String>> load(){
       
    }
  */ 
    public void setTitles(ArrayList<String> value){
        this.titles = value;
    }
    public ArrayList<String> getTitles(){
        return this.titles;
    }


}
