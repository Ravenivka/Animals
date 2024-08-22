import java.util.ArrayList;
import model.AnimalManager;

public class Presenter {

    private AnimalManager animalManager;  
    

    public Presenter() {
        this.animalManager = new AnimalManager();       
    }    

	public String createAnimal(String animalName, String sex, String typeNumber, String birthDate, String comList) {
		return this.animalManager.createAnimal(animalName, sex, typeNumber, birthDate, comList);
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



    

    public void setAnimClassIndex(String index) {
        this.animalManager.setActiveClass(index)  ;          
    }  
    

    public String showAnimTypeList() {        
        ArrayList<ArrayList<String>> animTypeList = this.animalManager.getAnimalTypes() ;
        StringBuilder sb = new StringBuilder();
            for (int i = 0; i < animTypeList.size(); i ++){                
                ArrayList<String> list = animTypeList.get(i);
                sb.append(String.format("%s - ", list.get(0)));
                sb.append(this.animalManager.clear(list.get(1)));
                sb.append("\n");
            }
        return sb.toString();        
    }

    public void setAnimTypeIndex(String typeNumber) {
        this.animalManager.setAnimTypeIndex(typeNumber) ;
    }



    

	
    


}
