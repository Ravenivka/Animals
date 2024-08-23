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
                showSelectionType();
                    break;
                default:
                    break;
            }
        }

    }   

    private void showSelectionType() {
        System.out.println("Выбор условия:");
        System.out.println("1 - без сортировки");
        System.out.println("2 - сортировка по имени");
        System.out.println("3 - сортировка по возрасту");
        System.out.println("Введите номер");
        String number = scanner.nextLine();        
        doList(number);
        
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
    
    private void doList(String index) {
        System.out.println(presenter.showList(index));
    }

    private void doAdd() {
        // Чистый экран _________________________________
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
        //_______________________________________________
        //redone
        try {
            System.out.println("Введите имя");
            String animalName = scanner.nextLine();        
            System.out.println("Введите пол (м/ж)");
            String gender = scanner.nextLine();        
            String choice = showClassList();           
            System.out.println("Введите дату рождения животного (ГГГГ-ММ-ДД)");
            String birthDate = scanner.nextLine();
            System.out.println("Введите список комманд животного (через запятую)");
            String comList = scanner.nextLine();
            System.out.println(presenter.createAnimal(animalName, gender, choice, birthDate,  comList));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
    }
   
    private String showClassList() {
        String string = "1 - Вьючные животные\n2 - Домашние животные\nВаш выбор:\n";
        System.out.println(string);
        String choice = this.scanner.nextLine();
        if (!(choice.equals("1") || choice.equals("2") || choice.equals("q"))){
            return "Выбор вне области допустимых значений";
        } else if (choice.equals("1")) {
            return showPackedAnimals();
        } else {
            return showPetAnimals() ;
        }        
    }

    private String showPetAnimals() {
        String string = "1 - Кошки\n2 - Хомяки\n3 - Собаки\nВаш выбор:\n";
        System.out.println(string);
        String choice = this.scanner.nextLine();
        switch (choice) {
            case "1":
                return "cats.csv";
            case "2":
                return "hamsters.csv";
            case "3":
                return "dogs.csv";
            case "q":
                exit();
                break;
            default:
                return "Выбор вне области допустимых значений";            
        }
        return "";      
    }

    private String showPackedAnimals() {
        String string = "1 - Ослы\n2 - Верблюды\n3 - Лошади\nВаш выбор:\n";
        System.out.println(string);
        String choice = this.scanner.nextLine();
        switch (choice) {
            case "1":
                return "donkeys.csv";
            case "2":
                return "camels.csv";
            case "3":
                return "horses.csv";
            case "q":
                exit();
                break;
            default:
                return "Выбор вне области допустимых значений";            
        }
        return "";
    }

    private void doselect() { //назначить активное животное
        // Чистый экран _________________________________
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
        //_______________________________________________
        String choice = showClassList();
        System.out.println(presenter.showList(choice));
        System.out.println("Введите номер");
        String number = scanner.nextLine();
        System.out.println(presenter.setActive(number));        
    }

    private void remove() { //удаляет активное животное
        try{
            System.out.println(presenter.remove()); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    private void showCommands() { //для активного животного
        System.out.println(presenter.showCommands());
    }

    private void removeCommand() {
        System.out.println("Выбор комманды");
        System.out.println(this.presenter.showEnumeratedCommands());
        System.out.println(this.presenter.removeCommand(Integer.parseInt(this.scanner.nextLine())));

    }

    private void addCommand() {
        System.out.println("Введите комманду");
        try {
            System.out.println(this.presenter.addCommand(this.scanner.nextLine()));
        } catch (Exception e) {
            System.out.println(e);
        }
       
    }
}
