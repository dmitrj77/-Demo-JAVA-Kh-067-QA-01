import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    //Have to change <String> on <Task> when created Task class
    static List<String> tasks = new ArrayList<>();
    static List<String> deletedTasks = new ArrayList<>();

    static void runPrecondition() {
        // Call method createIfNotExists

        // Call method readFile from tasks

        // Call method readFile from deletedTasks


        System.out.println("[Organizer] is designed to schedule of user activity. " +
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
        int userChoice = -1;
        while (userChoice != 0) {
            String[] mainMenu = new String[]{"MAIN MENU", "Add task", "Edit task", "Show task", "Delete task", "Quit"};
            outputMenu(mainMenu);
            userChoice = maximumPossibleChoice(4);
            switch (userChoice) {
                //Add task n menu
                case 1: {
                    while (userChoice != 0) {
                        String[] addMenu = new String[]{"ADD TASK", "By steps", "By pattern", "Back"};
                        outputMenu(addMenu);
                        userChoice = maximumPossibleChoice(2);
                        switch (userChoice) {
                            //Add task by steps menu
                            case 1: {
                                String[] byStepMenu = new String[]{"BY STEPS", "Continue", "Cancel"};
                                outputMenu(byStepMenu);
                                userChoice = maximumPossibleChoice(1);
                                if (userChoice == 1) {
                                    //Call method writeFile with 2 parameters " +
                                    // "(filePath and List<String> to write)
                                    System.out.println("Call method writeFile with 2 parameters " +
                                            "(filePath and List<String> to write)  ");
                                } else {
                                    userChoice = -1;
                                    break;
                                }
                                break;
                            }

                            //Add task by pattern
                            case 2: {
                                String[] byPatternMenu = new String[]{"BY PATTERN", "Continue", "Cancel"};
                                outputMenu(byPatternMenu);
                                userChoice = maximumPossibleChoice(1);
                                if (userChoice == 1) {
                                    //Call method writeFile with 2 parameters " +
                                    // "(filePath and List<String> to write)
                                    System.out.println("Call method writeFile with 2 parameters " +
                                            "(filePath and List<String> to write)  ");
                                } else {
                                    userChoice = -1;
                                    break;
                                }
                                break;
                            }

                            //Cancel
                            case 0: {
                                userChoice = 0;
                                break;
                            }
                            default: {
                                System.out.println("Please make your choice");
                                break;
                            }
                        }
                    }
                    userChoice = -1;
                    break;
                }

                //Edit task menu
                case 2: {
                    while (userChoice != 0) {
                        String[] editMenu = new String[]{"EDIT TASK", "Existing ", "Recycle Bin", "Back"};
                        outputMenu(editMenu);
                        userChoice = maximumPossibleChoice(2);
                        switch (userChoice) {
                            //Existing task menu
                            case 1: {
                                String[] existingMenu = new String[]{"EXISTING"};
                                outputMenu(existingMenu);
                                //Call method readFile from List<Task> tasks = new ArrayList<>();
                                System.out.println("Call method readFile from List<Task> " +
                                        "tasks = new ArrayList<>()");
                                System.out.println("Call method writeFile with 2 parameters " +
                                        "(filePath and List<String> to write)  ");
                                break;
                            }
                            //Recycle bin menu
                            case 2: {
                                String[] binMenu = new String[]{"RECYCLE BIN"};
                                outputMenu(binMenu);
                                //Call method readFile from List<Task> deletedTasks = new ArrayList<>();
                                System.out.println("Call method readFile from List<Task> " +
                                        "deletedTasks = new ArrayList<>();");
                                System.out.println("Call method writeFile with 2 parameters " +
                                        "(filePath and List<String> to write)  ");
                                break;
                            }
                            //Back menu
                            case 0: {
                                userChoice = 0;
                                break;
                            }

                            default: {
                                System.out.println("Please make your choice");
                            }
                        }
                    }
                    userChoice = -1;
                    break;
                }

                //Showing tasks
                case 3: {
                    while (userChoice != 0) {
                        String[] showingMenu = new String[]{"SHOWING", "All tasks", "By filter", "Deleted tasks", "Back"};
                        outputMenu(showingMenu);
                        userChoice = maximumPossibleChoice(3);
                        switch (userChoice) {
                            //All tasks
                            case 1: {
                                String[] allMenu = new String[]{"ALL TASK"};
                                outputMenu(allMenu);
                                System.out.println("Call method readFile from List<Task> " +
                                        "tasks = new ArrayList<>()");
                                break;
                            }

                            //By filter
                            case 2: {
                                String[] byFilterMenu = new String[]{"BY FILTER"};
                                outputMenu(byFilterMenu);
                                System.out.println("Call method readFileByFilter from List<Task> " +
                                        "tasks = new ArrayList<>()");
                                break;
                            }
                            //Deleted tasks
                            case 3: {
                                String[] deletedMenu = new String[]{"DELETED TACKS"};
                                outputMenu(deletedMenu);
                                //Call method readFile from List<Task> deletedTasks = new ArrayList<>();
                                System.out.println("Call method readFile from List<Task> " +
                                        "deletedTasks = new ArrayList<>();");
                                break;
                            }
                            //Back from showing
                            case 0: {
                                userChoice = 0;
                                break;
                            }
                            default: {
                                System.out.println("Please make your choice");
                                break;
                            }
                        }
                    }
                    userChoice = -1;
                    break;
                }
                //Delete menu
                case 4: {
                    while (userChoice != 0) {
                        String[] deleteMenu = new String[]{"DELETE", "By Id", "By period", "Back"};
                        outputMenu(deleteMenu);
                        userChoice = maximumPossibleChoice(2);
                        switch (userChoice) {
                            case 1: {
                                String[] byIdMenu = new String[]{"BY ID"};
                                outputMenu(byIdMenu);
                                System.out.println("Call method readFile from List<Task> " +
                                        "tasks = new ArrayList<>()");
                                System.out.println("Call method deletedTaskById from List<Task> " +
                                        "tasks = new ArrayList<>()");
                                break;
                            }
                            case 2: {
                                String[] byPeriodMenu = new String[]{"BY PERIOD"};
                                outputMenu(byPeriodMenu);
                                System.out.println("Call method readFile from List<Task> " +
                                        "tasks = new ArrayList<>()");
                                System.out.println("Call method deletedTaskByPeriod from List<Task> " +
                                        "tasks = new ArrayList<>()");
                                break;
                            }
                            case 0: {
                                userChoice = 0;
                                break;
                            }
                        }
                    }
                    userChoice = -1;
                    break;
                }
                default: {
                    System.out.println("Please make your choice");
                    break;
                }
                case 0: {
                    userChoice = 0;
                    break;
                }
            }
        }
    }

    // Method of validation maximum possible choice
    public static int maximumPossibleChoice(int points) {
        Scanner scanner = new Scanner(System.in);
        int userChoice = 0;
        boolean isInputNumber;
        do {
            isInputNumber = scanner.hasNextInt();
            if (!isInputNumber) {
                System.out.println("Please enter a number");
                scanner.next();
            } else {
                userChoice = scanner.nextInt();
                if (userChoice > points) {
                    System.out.println("You entered an incorrect number");
                } else {
                    break;
                }
            }
        }
        while (!isInputNumber || userChoice > points);
        return userChoice;
    }

    //ToDo to add method to maximumPossibleChoice
    private static String getStringNotEmpty() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        boolean isStringEmpty;
        do {
            isStringEmpty = name.isEmpty();
            if (isStringEmpty) {
                System.out.println("String cannot be Empty.Please string!\n");
                name = scanner.nextLine();
            } else {
                break;
            }
        }
        while (isStringEmpty);
        return name;
    }

    public static void outputMenu(String[] menu) {
        List<String> listBooks = Arrays.asList(menu);
        int i = 0;
        for (i = 0; i < listBooks.size(); i++) {
            if (i == 0) {
                System.out.format("%-20s %n", listBooks.get(0));
            } else if (i < listBooks.size() - 1) {
                System.out.format("%-20s [" + i + "]%n", listBooks.get(i));
            } else if (i < listBooks.size()) {
                System.out.format("%-20s [0]%n", listBooks.get(i));
            }
        }
    }
}



