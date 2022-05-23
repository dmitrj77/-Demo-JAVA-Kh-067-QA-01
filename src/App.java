import javafx.concurrent.Task;

import java.util.*;

public class App {
    static void runPrecondition() {
        // Call method createIfNotExists
        // Call method readFile from tasks
        // Call method readFile from deletedTasks
        List<Task> tasks = new ArrayList<>();
        List<Task> deletedTasks = new ArrayList<>();
        System.out.println("\n[Organizer] is designed to schedule and schedule user activity. " +
                "\nThe program allows you to create, edit, view, delete and restore tasks." +
                "\nThe program has a console implementation." +
                "\nTo control the application, select a number from the menu and then follow the prompts." +
                "\nThe program was created by the team KH-JAVA-067-QA-01." +
                "\nThe team is the copyright holder of this program.");
    }

    static void run() {
        Scanner scanner = new Scanner(System.in);
        final String taskFile = null;
        final String deletedFile = null;
        int userChoice;
        String comm = "";
        String command = "";
        while (comm != "exit") {
            String[] menu = new String[]{"MAIN MENU","Add task","Edit task","Show task","Delete task","Quit"};
            getMenu(menu);
            userChoice = getUserChoice(4);
            switch (userChoice) {
                case 1: {
                    command = "";
                    while (command != "exit") {
                        menu = new String[]{"ADD TASK","By steps","By pattern","Back"};
                        getMenu(menu);
                        userChoice = getUserChoice(2);
                        switch (userChoice) {
                            case 1: {
                                menu = new String[]{"BY STEPS","Continue","Cancel"};
                                getMenu(menu);
                                userChoice = getUserChoice(1);
                                if (userChoice == 1) {
                                    //Call method writeFile with 2 parameters " +
                                    // "(filePath and List<String> to write)
                                    System.out.println("Call method writeFile with 2 parameters " +
                                            "(filePath and List<String> to write)  ");
                                } else
                                    break;
                            }
                            break;
                            case 2: {
                                menu = new String[]{"BY PATTERN","Continue","Cancel"};
                                getMenu(menu);
                                userChoice = getUserChoice(1);
                                if (userChoice == 1) {
                                    //Call method writeFile with 2 parameters " +
                                    // "(filePath and List<String> to write)
                                    System.out.println("Call method writeFile with 2 parameters " +
                                            "(filePath and List<String> to write)  ");
                                } else
                                    break;
                            }
                            break;
                            case 0: {
                                command = "exit";
                                break;
                            }
                            default: {
                                System.out.println("Please make your choice");
                            }
                            break;
                        }
                    }
                }
                break;
                case 2: {
                    command = "";
                    while (command != "exit") {
                        menu = new String[]{"EDIT TASK","Existing ","Recycle Bin","Back"};
                        getMenu(menu);
                        userChoice = getUserChoice(2);
                        switch (userChoice) {
                            case 1: {
                                menu = new String[]{"EXISTING"};
                                getMenu(menu);
                                //Call method readFile from List<Task> tasks = new ArrayList<>();
                                System.out.println("Call method readFile from List<Task> " +
                                        "tasks = new ArrayList<>()");
                                System.out.println("Call method writeFile with 2 parameters " +
                                        "(filePath and List<String> to write)  ");

                            }
                            break;
                            case 2: {
                                menu = new String[]{"RECYCLE BIN"};
                                getMenu(menu);
                                //Call method readFile from List<Task> deletedTasks = new ArrayList<>();
                                System.out.println("Call method readFile from List<Task> " +
                                        "deletedTasks = new ArrayList<>();");
                                System.out.println("Call method writeFile with 2 parameters " +
                                        "(filePath and List<String> to write)  ");
                            }
                            break;
                            case 0: {
                                command = "exit";
                            }
                            break;
                            default: {
                                System.out.println("Please make your choice");
                            }
                        }
                    }
                }
                break;
                case 3: {
                    command = "";
                    while (command != "exit") {
                        menu = new String[]{"SHOWING","All tasks", "By filter", "Deleted", "Back"};
                        getMenu(menu);
                        userChoice = getUserChoice(3);
                        switch (userChoice) {
                            case 1: {
                                menu = new String[]{"ALL TASK"};
                                getMenu(menu);
                                System.out.println("Call method readFile from List<Task> " +
                                        "tasks = new ArrayList<>()");
                            }
                            break;
                            case 2: {
                                menu = new String[]{"BY FILTER"};
                                getMenu(menu);
                                System.out.println("Call method readFileByFilter from List<Task> " +
                                        "tasks = new ArrayList<>()");
                            }
                            break;
                            case 3: {
                                menu = new String[]{"DELETE"};
                                getMenu(menu);
                                //Call method readFile from List<Task> deletedTasks = new ArrayList<>();
                                System.out.println("Call method readFile from List<Task> " +
                                        "deletedTasks = new ArrayList<>();");
                            }
                            break;

                            case 0: {
                                command = "exit";

                            }
                            break;
                            default: {
                                System.out.println("Please make your choice");
                            }
                        }
                    }
                }
                break;
                case 4: {
                    command = "";
                    while (command != "exit") {
                        menu = new String[]{"DELETE","By Id","By period","Back"};
                        getMenu(menu);
                        userChoice = getUserChoice(2);
                        switch (userChoice) {
                            case 1: {
                                menu = new String[]{"BY ID"};
                                getMenu(menu);
                                System.out.println("Call method readFile from List<Task> " +
                                        "tasks = new ArrayList<>()");
                                System.out.println("Call method deletedTaskById from List<Task> " +
                                        "tasks = new ArrayList<>()");
                                break;
                            }
                            case 2: {
                                menu = new String[]{"BY PERIOD"};
                                getMenu(menu);
                                System.out.println("Call method readFile from List<Task> " +
                                        "tasks = new ArrayList<>()");
                                System.out.println("Call method deletedTaskByPeriod from List<Task> " +
                                        "tasks = new ArrayList<>()");
                                break;
                            }

                            case 0: {
                                command = "exit";
                                break;
                            }
                        }
                    }
                }
                break;

                default: {
                    System.out.println("Please make your choice");
                }
                break;
                case 0: {
                    comm = "exit";
                }
                break;

            }

        }
    }

    // Method of validation inputting number
    public static int getUserChoice(int choice) {
        Scanner sc = new Scanner(System.in);
        int userChoice = 0;
        boolean validation;
        do {
            validation = sc.hasNextInt();
            if (!validation) {
                System.out.println("Number Pls!");
                sc.nextLine();
            } else {
                userChoice = sc.nextInt();
                if (userChoice <= choice) {

                } else {
                    System.out.println("You entered incorrect number");
                    //userChoice = sc.nextInt();
                }
            }
        }
        while (!validation || userChoice > choice);
        return userChoice;
    }

    private static String getStringNotEmpty() {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        boolean validation;
        do {
            validation = name.isEmpty();
            if (validation) {
                System.out.println("String cannot be Empty.Please string!\n");
                name = sc.nextLine();
            } else {

                break;
            }
        }
        while (validation);
        return name;
    }

    public static void getMenu(String[] menu) {
        List<String> listBook = Arrays.asList(menu);
        int i = 0;
        for (String book : listBook) {
            if (i == 0) {
                System.out.format("%-20s %n", book);
            } else if (i < listBook.size()-1 ) {
                System.out.format("%-20s [" + i + "]%n", book);
            } else if (i <listBook.size()) {
                System.out.format("%-20s [0]%n", book);
            }
            i++;
        }
    }


}



