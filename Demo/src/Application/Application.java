package Application;

import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Application {
    Scanner sc = new Scanner(System.in);
    private final String taskFile = null;
    private final String deletedFile = null;
    public List<Task> tasks = new ArrayList<>();
    public List<Task> deletedTasks = new ArrayList<>();
    String command = "";
    while(!command.equals("0")){
        System.out.println("===ORGANIZER===");
        System.out.println("---Main menu---");
        System.out.println("Add task    [1]");
        System.out.println("Edit task   [2]");
        System.out.println("Show task   [3]");
        System.out.println("Delete task [4]");
        System.out.println("Quit        [0]");
        String operator = sc.next();
        switch (operator) {
            case "1": {
                String command = "";
                while (!command.equals("0")) {
                    System.out.println("---Add task---");
                    System.out.println("By steps   [1]");
                    System.out.println("By pattern [2]");
                    System.out.println("Back       [0]");
                    operator = sc.next();
                    switch (operator) {
                        case "1": {
                            System.out.println("---By steps---");
                            System.out.println("Continue   [1]");
                            System.out.println("Cancel     [0]");
                            String stp = sc.next();
                            if (!stp.equals("0")) {
                                System.out.println("Enter title");


                            }else {
                                break;
                            }

                            break;
                        }
                        case "2": {
                            break;
                        }
                        case "0": {
                            command = "0";
                            break;
                        }
                    }
                }
                break;
            }
            case "2": {
                String command = "";
                while (!command.equals("0")) {
                    System.out.println("---Edit task---");
                    System.out.println("Existing    [1]");
                    System.out.println("Recycle Bin [2]");
                    System.out.println("Back        [0]");
                    operator = sc.next();
                    switch (operator) {
                        case "1": {
                            break;
                        }
                        case "2": {
                            break;
                        }
                        case "0": {
                            command = "0";
                            break;
                        }
                    }
                }
                break;
            }
            case "3": {
                String command = "";
                while (!command.equals("0")) {
                    System.out.println("----Showing----");
                    System.out.println("All tasks   [1]");
                    System.out.println("By filter   [2]");
                    System.out.println("Deleted     [3]");
                    System.out.println("Back        [0]");
                    operator = sc.next();
                    switch (operator) {
                        case "1": {
                            break;
                        }
                        case "2": {
                            break;
                        }
                        case "3": {
                            break;
                        }
                        case "0": {
                            command = "0";
                            break;
                        }
                    }
                }
                break;
            }
            case "4": {
                String command = "";
                while (!command.equals("0")) {
                    System.out.println("----Delete----");
                    System.out.println("By Id      [1]");
                    System.out.println("By period  [2]");
                    System.out.println("Back       [0]");
                    operator = sc.next();
                    switch (operator) {
                        case "1": {
                            break;
                        }
                        case "2": {
                            break;
                        }
                        case "0": {
                            command = "0";
                            break;
                        }
                    }
                }
                break;
            }
            case "0": {
                command = "0";
                break;
            }
        }

    }
}
}
