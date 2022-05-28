import utils.FileUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utils.DateUtils.format;
import static utils.DateUtils.getLocalDateTime;

public class App {

    static List<Task> tasks = new ArrayList<>();
    static List<Task> deletedTasks = new ArrayList<>();
    static final String taskFile = "Task.txt";
    static final String deletedFile = "Archive.txt";

    static void runPrecondition() {
        // Call method createIfNotExists
        FileUtils.createIfNotExists(taskFile);
        FileUtils.createIfNotExists(deletedFile);

        for (String taskString : FileUtils.readFile(taskFile)) {
            Task task = new Task(taskString);
            tasks.add(task);
        }

        for (String taskString : FileUtils.readFile(deletedFile)) {
            Task task = new Task(taskString);
            deletedTasks.add(task);
        }
        System.out.println("[Organizer] is designed to schedule of user activity. " +
                "\nThe program allows you to create, edit, view, delete and restore tasks." +
                "\nThe program has a console implementation." +
                "\nTo control the application, select a number from the menu and then follow the prompts." +
                "\nThe program was created by the team KH-JAVA-067-QA-01." +
                "\nThe team is the copyright holder of this program.");
    }

    static void run() {
        Scanner scanner = new Scanner(System.in);
        int userChoice = -1;
        while (userChoice != 0) {
            String[] mainMenu = new String[]{"MAIN MENU", "Add task", "Edit task", "Show task", "Delete task", "Quit"};
            outputMenu(mainMenu);
            userChoice = getUserIntChoice(4);
            switch (userChoice) {
                //Add task menu
                case 1: {
                    while (userChoice != 0) {
                        String[] addMenu = new String[]{"ADD TASK", "By steps", "By pattern", "Back"};
                        outputMenu(addMenu);
                        userChoice = getUserIntChoice(2);
                        switch (userChoice) {
                            //Add task by steps menu
                            case 1: {
                                String[] byStepMenu = new String[]{"BY STEPS", "Continue", "Cancel"};
                                outputMenu(byStepMenu);
                                userChoice = getUserIntChoice(1);
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
                                userChoice = getUserIntChoice(1);
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
                        userChoice = getUserIntChoice(2);
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
                                String[] binMenu = new String[]{"RECYCLE BIN", "Back"};
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
                        String[] showingMenu = new String[]{"SHOWING","All tasks","By filter","Deleted tasks","Back"};
                        outputMenu(showingMenu);
                        userChoice = getUserIntChoice(3);
                        switch (userChoice) {
                            //All tasks
                            case 1: {
                                String[] allMenu = new String[]{"ALL TASK","Back"};
                                outputMenu(allMenu);
                                showTask(tasks);
                                userChoice = getUserIntChoice(0);
                                break;
                            }
                            //By filter
                            case 2: {
                                String[] byFilterMenu = new String[]{"BY FILTER","Back"};
                                outputMenu(byFilterMenu);

                                List<Task> temp = new ArrayList<>();
                                System.out.println("Enter please data from period in format:" + format);
                                LocalDateTime dataFrom = getLocalDateTime(scanner.nextLine(), format);
                                System.out.println("Enter please data to period in format:" + format);
                                LocalDateTime dataTo = getLocalDateTime(scanner.nextLine(), format);

                                for (Task task : tasks) {
                                    if ((task.getLocalDateTime().isAfter(dataFrom)) &&
                                            (task.getLocalDateTime().isBefore(dataTo))) {
                                        temp.add(task);
                                    }
                                }
                                showTask(temp);
                                userChoice = getUserIntChoice(0);
                                break;
                            }
                            //Deleted tasks
                            case 3: {
                                String[] deletedMenu = new String[]{"DELETED TACKS", "Back"};
                                outputMenu(deletedMenu);
                                showTask(deletedTasks);
                                userChoice = getUserIntChoice(0);
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
                        userChoice = getUserIntChoice(2);
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

    public static int getUserIntChoice(int maxChoice) {
        Scanner scanner = new Scanner(System.in);
        int userChoice = -1;
        boolean isInputNumber;
        do {
            isInputNumber = scanner.hasNextInt();
            if (!isInputNumber) {
                System.out.println("Please enter a number");
                scanner.next();
            } else {
                userChoice = scanner.nextInt();
                if (userChoice < 0) {
                    System.out.println("You entered an negative number");
                } else if (userChoice > maxChoice) {
                    System.out.println("You entered an incorrect number");
                }
            }

        } while (!isInputNumber || userChoice > maxChoice || userChoice < 0);
        return userChoice;
    }

    private static void showTask(List<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.format("%d %s %s %s\n", i, tasks.get(i).getTitle(), tasks.get(i).getLocalDateTime(),
                    tasks.get(i).getDescription());
        }

    }

    private static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void outputMenu(String[] menu) {
        List<String> listMenu = Arrays.asList(menu);
        for (int i = 0; i < listMenu.size(); i++) {
            if (i == 0) {
                System.out.format("%-20s %n", listMenu.get(0));
            } else if (i < listMenu.size() - 1) {
                System.out.format("%-20s [" + i + "]%n", listMenu.get(i));
            } else {
                System.out.format("%-20s [0]%n", listMenu.get(i));
            }
        }
    }

    public static void writeTasks(String filePath, List<Task> tasks) {
        List<String> stringList = new ArrayList<>();
        for (Task task : tasks) {
            stringList.add(task.getStringForFile());
        }
        FileUtils.writeFile(filePath, stringList);
    }

}
