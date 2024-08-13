import java.util.Scanner;

public class View {

    private Presenter presenter;
    private Scanner scanner;

    public View(){
        this.presenter = new Presenter(); 
        this.scanner = new Scanner(System.in)   ;
    }

    public void start(){
        System.out.println("""
            Добро пожаловать в систему учёта животных.\n
            Для просмотра списка комманд наберите 'help'
        """);

        boolean flag = true;
        while (flag) {
            String comm = scanner.nextLine();
            switch (comm) {
                case "help":
                    showHelp();
                    break;
                case "q":
                    exit();
                    break;
                case "add":
                    doAdd();
                    break;
                case "select":
                    doselect();
                    break;
                case "del":
                    remove();
                    break;
                case "com":
                    showCommands();
                    break;
                case "ac":
                    addCommand();
                    break;
                case "rc":
                    removeCommand();
                    break;
                case "list":
                    showList();
                    break;
                default:
                    break;
            }
        }

    }   

    private void showList() {
        System.out.println("Выбор условия:");
        System.out.println("1 - без сортировки");
        System.out.println("2 - сортировка по имени");
        System.out.println("3 - сортировка по возрасту");
        System.out.println("Введите номер");
        String number = scanner.nextLine();
        
    }

    private void showHelp() {
        System.out.println("""
            Срисок комманд:\n
            \thelp - просмотр списка комманд,\n
            \tq - выход из программы,\n
            \tadd - добавить новое животное,\n
            \tselect - выбрать животное,\n
            \tdel - удалить животное,\n
            \tcom - посмотреть список комманд животного,\n
            \tac - добавить комманду в список,\n
            \trc - удалить комманду из списка,\n
            \tlist - посмотреть список животных,\n

        """);
    }







    private void exit(){
        System.out.println("Good bye");
        scanner.close();
        System.exit(0);
    }
    
    private void doList() {
        System.out.println(presenter.showList());
    }

    private void doAdd() {
        System.out.println("Введите имя");
        String animalName = scanner.nextLine();
        System.out.println("Выберите тип животного");
        System.out.println(presenter.showType());
        System.out.println("Введите номер");
        String typeNumber = scanner.nextLine();
        System.out.println("Выберите дату рождения животного (ГГГГ-ММ-ДД)");
        String birthDate = scanner.nextLine();
        System.out.println("Введите список комманд животного (через запятую)");
        String comList = scanner.nextLine();
        System.out.println(presenter.createAnimal(animalName, typeNumber, birthDate,  comList));
    }
   
    private void doselect() { //назначить активное животное
        System.out.println(presenter.showList());
        System.out.println("Введите номер");
        String number = scanner.nextLine();
        System.out.println(presenter.setActive(number));        
    }

    private void remove() { //удаляет активное животное
        System.out.println(presenter.remove()); 
    }

    private void showCommands() { //для активного животного
        System.out.println(presenter.showCommands());
    }

    private void removeCommand() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeCommand'");
    }

    private void addCommand() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addCommand'");
    }
}
