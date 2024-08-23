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

    public String remove() {
        boolean boo = this.animalManager.remove();
        if (boo) {
            return "Удалено";
        } else {
            return "Ошибка удаления";
        }
    }

    public String showCommands() {
        return this.animalManager.getSelected().showCommands();
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

    public String addCommand(String nextLine) throws Exception {
        return this.animalManager.addCommand(nextLine);
    }

    public String showEnumeratedCommands() {
        return this.animalManager.showEnumeratedCommands();
    }

    public String removeCommand(int int1) {
        boolean boo = this.animalManager.removeCommand(int1);
        if (boo) {
            return "Удалено";
        } else {
            return "Ошибка удаления";
        }
    }

}
