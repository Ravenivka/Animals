import model.AnimalManager;

public class Presenter {

    private AnimalManager animalManager;  
    

    public Presenter() {
        this.animalManager = new AnimalManager();       
    }    

	

    public String setActive(String number) {
        try{
            this.animalManager.setSelected(Integer.parseInt(number));   
            return String.format("Выбран номер %s", number);     
        } catch (Exception e) {
            return e.getMessage();
        }
        
    }

    public char[] remove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    public char[] showCommands() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showCommands'");
    }
    



    public String createAnimal(String animalName, String gender, String choice, String birthDate, String comList) {
        try{
            this.animalManager.addAnimal(animalName, gender, comList, birthDate, choice);
            return "Добавлено 1 животное";
        } catch (Exception e) {
            return e.getMessage();
        }
    }



    public String showList(String choice) {
        return this.animalManager.showList(choice);
    }



    



  
    

   

   



    

	
    


}
