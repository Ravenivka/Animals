import java.util.Scanner;

public class View {

    private Presenter presenter;
    private Scanner scanner;
    private String choiceString = """
            1 - Верблюды,
            2 - Ослы,
            3 - Лошади,
            4 - Кошки,
            5 - Хомяки,
            6 - Собаки,
            7 - Вьючные животные,
            8 - Домашние животные,
            9 - полный список
            Ваш выбор:    
                """;

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
                case "info":
                    showinfo();
                    break;
                case "count":
                    showCount();
                    break;
                default:
                    break;
            }
        }

    }   

    private void showCount() {
        // Чистый экран _________________________________
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
        //_______________________________________________
        System.out.println("Количество каких животных Вы желаете узнать?");
        System.out.println(this.choiceString);
        try{
            String s = choosenTable(scanner.nextLine());
            System.out.println(presenter.showCount(s));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void showinfo() {
        // Чистый экран _________________________________
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
        //_______________________________________________
        try{
            System.out.println(presenter.showInfo());
        } catch (Exception a) {
            System.out.println(a);
        }
    }

    private void showSelectionType() {
        System.out.println("Выбор условия:");
        System.out.println("1 - без сортировки");
        System.out.println("2 - сортировка по имени");
        System.out.println("3 - сортировка по возрасту");
        System.out.println("Введите номер");
        String number = scanner.nextLine();  
        if (number.equals("q")) {
            exit();
        }      
        doList(number);        
    }

    private void showHelp() {
        System.out.println("""
            Срисок комманд:
            \thelp - просмотр списка комманд,
            \tq - выход из программы,
            \tadd - добавить новое животное,
            \tselect - выбрать животное,
            \tdel - удалить животное,
            \tcom - посмотреть список комманд животного,
            \tac - добавить комманду в список,
            \trc - удалить комманду из списка,
            \tinfo - посмотреть информацию о животном,
            \tlist - посмотреть список животных,
            \tcount - посмотреть количество животных
        """);
    }

    private void exit(){
        System.out.println("Good bye");
        scanner.close();
        System.exit(0);
    }
    
    private void doList(String index) {
        // Чистый экран _________________________________
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
        //_______________________________________________
        System.out.println("Условия поиска:");
        System.out.println(choiceString);
        String choice = choosenTable(this.scanner.nextLine());
        if (choice.equals("q")){
            exit();
        }
        try{
            System.out.println(this.presenter.showSortedList(index, choice));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private String choosenTable(String nextLine) {
        if (nextLine.equals("q")) {
            exit();
        } 
        switch (nextLine) {
            case "1":                
                return "camels.csv";
            case "2":                
                return "donkeys.csv";
            case "3":                
                return "horses.csv";
            case "4":
                return "cats.csv";                
            case "5":                
                return "hamsters.csv";
            case "6":                
                return "dogs.csv";
            case "7":                
                return "Вьючные животные";
            case "8":                
                return "Домашние животные";
            case "9":                
                return "Полный список" ;      
            default:
                return "Вне диапазона";
        }        
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
