import java.util.HashMap;
import model.AnimalManager;

public class Presenter {

    private AnimalManager animalManager;
    private HashMap<Integer, String> animClassList;
    private Integer animClassIndex;   
    

    public Presenter() {
        this.animalManager = new AnimalManager();
        animClassList = new HashMap<>();
        HashMap<String, String> map = this.animalManager.getAnimalClasses();
        Integer i = 1;
        for (String iterable_element : map.keySet()) {
            animClassList.put(i, iterable_element);
            i = i + 1;
        }
    }

    
   

    public String showType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showType'");
    }

	public String createAnimal(String animalName, String typeNumber, String birthDate, String comList) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'createAnimal'");
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



    public String showClassList() {       
        StringBuilder sb = new StringBuilder();
        sb.append("В приюте есть животные:\n");
        for (int i = 1; i < this.animClassList.size() + 1; i++) {
            sb.append(i);
            sb.append(" - ");
            sb.append(animClassList.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    public void setAnimClassIndex(String index) {
        this.animClassIndex = Integer.parseInt(index); 
        this.animalManager.setActiveClass(this.animClassList.get(animClassIndex))  ;     
    }

    public Integer getAnimClassIndex() {
        return this.animClassIndex;
    }

    public String getAnimClass() {
        return this.animClassList.get(this.animClassIndex);
    }

    public String showAnimTypeList() {
        HashMap<Integer, String> animTypeList = new HashMap<>();
        HashMap<String, String> map = this.animalManager.getAnimalTypes();
        Integer J = 1;
        for (String iterable_element : map.keySet()) {
            animTypeList.put(J, iterable_element);
            J = J + 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < animTypeList.size(); i++){
            sb.append(i+1);
            sb.append(" - ");
            sb.append(animTypeList.get(i+1));
            sb.append("\n");
        }
        return sb.toString();
    }



    

	
    


}
