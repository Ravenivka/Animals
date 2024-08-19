



public class Program {

    public static void main(String[] args) {       
    //    View view = new View();
    //    view.start();
        Presenter presenter = new Presenter();
        System.out.println(presenter.showClassList());
        System.out.println("Select: 2");
        presenter.setAnimClassIndex("2");
        System.out.println(presenter.showAnimTypeList());

    }
}
