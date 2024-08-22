import model.AnimalManager;

public class Presenter {

    private AnimalManager animalManager;  
    

    public Presenter() {
        this.animalManager = new AnimalManager();       
    }    

	

    public char[] setActive(String number) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setActive'");
    }

    public char[] remove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    public char[] showCommands() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showCommands'");
    }

    public String showList(String index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showList'");
    }



    public String createAnimal(String animalName, String gender, String choice, String birthDate, String comList) {
        try{
            this.animalManager.addAnimal(animalName, gender, comList, birthDate, choice);
            return "Добавлено 1 животное";
        } catch (Exception e) {
            return e.getMessage();
        }
    }



  
    

   

   



    

	
    


}
