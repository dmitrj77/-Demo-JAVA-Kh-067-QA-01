import utils.FileUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
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
        System.out.println("[Organizer] is designed to schedule user's activity. "
                + "It was created by KH-JAVA-067-QA-01 team."
                + "\nIt has a console implementation and allows you to create, edit, view, delete and restore tasks."
                + "\nTo use the application please choose a number from the menu and follow the prompts."
                + "\nEnjoy :)");
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
                                Task task = TaskCreator.addTaskBySteps();
                                if (task != null) {
                                    tasks.add(task);
                                    writeTasks(taskFile, tasks);
                                    System.out.println("Task created successfully");
                                    System.out.println(tasks.get(tasks.size() - 1).toString());
                                    String[] byStepMenu = new String[]{"Choose from the menus bellow", "Add task", "Main Menu"};
                                    outputMenu(byStepMenu);
                                    userChoice = getUserIntChoice(1);
                                }
                                break;
                            }

                            //Add task by pattern
                            case 2: {
                                Task task = TaskCreator.addTaskByPattern();
                                if (task != null) {
                                    tasks.add(task);
                                    writeTasks(taskFile, tasks);
                                    System.out.println("Task created successfully");
                                    System.out.println(tasks.get(tasks.size() - 1).toString());
                                    String[] byStepMenu = new String[]{"Choose from the menus bellow", "Add task", "Main Menu"};
                                    outputMenu(byStepMenu);
                                    userChoice = getUserIntChoice(1);
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
                        String[] editMenu = new String[]{"EDIT TASK", "Existing ", "Restore task", "Back"};
                        outputMenu(editMenu);
                        userChoice = getUserIntChoice(2);
                        switch (userChoice) {
                            //Existing task menu
                            case 1: {
                                showTasks(tasks);
                                System.out.println("Please enter Id: ");
                                int userChoiceId = getUserIntChoice(tasks.size() - 1);
                                while (userChoice != -1) {
                                    System.out.println(tasks.get(userChoiceId));
                                    String[] editTask = new String[]{"EXISTING", "Title ", "Date", "Description", "Back"};
                                    outputMenu(editTask);
                                    userChoice = getUserIntChoice(3);
                                    switch (userChoice) {
                                        case 1: {
                                            System.out.println("Please enter new Title: ");
                                            String newTitle = getInputString();
                                            tasks.get(userChoiceId).setTitle(newTitle);
                                            System.out.format("You have successfully changed Title:\n");
                                            break;
                                        }
                                        case 2: {
                                            System.out.println("Please enter new Date in format " + format);
                                            LocalDateTime newDate = getCorrectData();
                                            tasks.get(userChoiceId).setLocalDateTime(newDate);
                                            System.out.format("You have successfully changed Date:\n");
                                            break;
                                        }
                                        case 3: {
                                            System.out.println("Please enter new Description: ");
                                            String newDescription = getInputString();
                                            tasks.get(userChoiceId).setDescription(newDescription);
                                            System.out.format("You have successfully changed Description:\n");
                                            break;
                                        }
                                        case 0: {
                                            userChoice = -1;
                                            break;
                                        }
                                    }
                                }
                            }
                            break;
                            //Recycle bin menu
                            case 2: {
                                String[] binMenu = new String[]{"RESTORE TASK"};
                                outputMenu(binMenu);
                                showTasks(deletedTasks);
                                System.out.println("Please enter Id: ");
                                int userChoiceId = getUserIntChoice(deletedTasks.size() - 1);
                                System.out.println(deletedTasks.get(userChoiceId));
                                System.out.println("Please enter new Date in format " + format);
                                LocalDateTime newDate = getCorrectData();
                                deletedTasks.get(userChoiceId).setLocalDateTime(newDate);
                                tasks.add(deletedTasks.remove(userChoiceId));
                                writeTasks(deletedFile, deletedTasks);
                                writeTasks(taskFile, tasks);
                                System.out.format("You have successfully changed Date:\n");
                                System.out.println(tasks.get(tasks.size() - 1).toString());
                                break;
                            }
                            //Back menu
                            case 0: {
                                userChoice = 0;
                                break;
                            }
                        }
                    }
                    userChoice = -1;
                    break;
                }


                //Showing tasks
                case 3: {
                    while (userChoice != 0) {
                        String[] showingMenu = new String[]{"SHOW TASK", "All tasks", "By period", "Deleted tasks", "Back"};
                        outputMenu(showingMenu);
                        userChoice = getUserIntChoice(3);
                        switch (userChoice) {
                            //All tasks
                            case 1: {
                                String[] allMenu = new String[]{"ALL TASKS"};
                                outputMenu(allMenu);
                                showTasks(tasks);
                                String[] menu = new String[]{"Choose from the menus bellow", "Show Task", "Main Menu"};
                                outputMenu(menu);
                                userChoice = getUserIntChoice(1);
                                break;
                            }
                            //By filter
                            case 2: {
                                String[] byFilterMenu = new String[]{"BY PERIOD"};
                                outputMenu(byFilterMenu);

                                List<Task> temp = new ArrayList<>();
                                System.out.println("Format of data: " + format);
                                System.out.println("From:");
                                LocalDateTime dataFrom = getCorrectData();
                                System.out.println("To:");
                                LocalDateTime dataTo = getCorrectData();

                                for (Task task : tasks) {
                                    boolean isTimeRange = task.getLocalDateTime().isEqual(dataFrom)
                                            || task.getLocalDateTime().isEqual(dataTo)
                                            || (task.getLocalDateTime().isAfter(dataFrom) && task.getLocalDateTime().isBefore(dataTo));
                                    if (isTimeRange) {
                                        temp.add(task);
                                    }
                                }
                                showTasks(temp);
                                String[] menu = new String[]{"Choose from the menus bellow", "Show Task", "Main Menu"};
                                outputMenu(menu);
                                userChoice = getUserIntChoice(1);
                                break;
                            }
                            //Deleted tasks
                            case 3: {
                                String[] deletedMenu = new String[]{"DELETED TACKS"};
                                outputMenu(deletedMenu);
                                showTasks(deletedTasks);
                                String[] menu = new String[]{"Choose from the menus bellow", "Show Task", "Main Menu"};
                                outputMenu(menu);
                                userChoice = getUserIntChoice(1);
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
                        String[] deleteMenu = new String[]{"DELETE TASK", "By Id", "By period", "Back"};
                        outputMenu(deleteMenu);
                        userChoice = getUserIntChoice(2);
                        switch (userChoice) {
                            case 1: {
                                String[] byIdMenu = new String[]{"BY ID", "Back"};
                                outputMenu(byIdMenu);
                                showTasks(tasks);
                                System.out.println("Input ID:");
                                int id = getUserIntChoice(tasks.size() - 1);
                                deletedTasks.add(tasks.remove(id));
                                writeTasks(deletedFile, deletedTasks);
                                writeTasks(taskFile, tasks);
                                System.out.println("You have successfully deleted task");
                                String[] menu = new String[]{"Choose from the menus bellow", "Menu Delete", "Main Menu"};
                                outputMenu(menu);
                                userChoice = getUserIntChoice(1);
                                break;
                            }
                            case 2: {
                                String[] byPeriodMenu = new String[]{"BY PERIOD", "Back"};
                                outputMenu(byPeriodMenu);
                                showTasks(tasks);
                                System.out.println("Input period");
                                System.out.println("Format of data: " + format);
                                System.out.println("From:");
                                LocalDateTime dataFrom = getCorrectData();
                                System.out.println("To:");
                                List<Task> tasksToDelete = new ArrayList<>();
                                LocalDateTime dataTo = getCorrectData();
                                for (int i = 0; i < tasks.size(); i++) {
                                    boolean isTimeRange = tasks.get(i).getLocalDateTime().isEqual(dataFrom) ||
                                            tasks.get(i).getLocalDateTime().isEqual(dataTo) ||
                                            (tasks.get(i).getLocalDateTime().isAfter(dataFrom) && tasks.get(i).getLocalDateTime().isBefore(dataTo));
                                    if (isTimeRange) {
                                        tasksToDelete.add(tasks.get(i));
                                    }
                                }
                                for (Task task : tasksToDelete) {
                                    if (tasks.remove(task)) {
                                        deletedTasks.add(task);
                                    }
                                }
                                writeTasks(deletedFile, deletedTasks);
                                writeTasks(taskFile, tasks);
                                System.out.println("You have successfully deleted tasks");
                                String[] menu = new String[]{"Choose from the menus bellow", "Menu Delete", "Main Menu"};
                                outputMenu(menu);
                                userChoice = getUserIntChoice(1);
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
                    System.out.println("You entered an negative number. Please try again");
                } else if (userChoice > maxChoice) {
                    System.out.println("You entered an incorrect number. Please try again");
                }
            }

        } while (!isInputNumber || userChoice > maxChoice || userChoice < 0);
        return userChoice;
    }


    public static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Parameter can not be empty. Please try again");
            } else {
                return input;
            }
        }
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

    public static LocalDateTime getCorrectData() {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        LocalDateTime localDateTime;
        while (true) {
            try {
                localDateTime = getLocalDateTime(data, format);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect format of data. Please try again. " + "Correct format " + format);
            }
            data = scanner.nextLine();
        }
        return localDateTime;
    }

    public static void showTasks(List<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.format("ID: %d %s\n", i, tasks.get(i).toString());
        }
    }

}
