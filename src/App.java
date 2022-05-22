import javafx.concurrent.Task;

import java.util.*;

public class App {
    static void runPrecondition() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nOrganizer is designed to schedule and schedule user activity. " +
                "\nThe program allows you to create, edit, view, delete and restore tasks." +
                "\nThe program has a console implementation." +
                "\nThe program was created by the team KH-JAVA-067-QA-01." +
                "\nThe team is the copyright holder of this program.");
        System.out.println("");

    }

    static void run() {
        Scanner sc = new Scanner(System.in);
        final String taskFile = null;
        final String deletedFile = null;

        // Call method createIfNotExists
        // Call method readFile from tasks
        // Call method readFile from deletedTasks
        List<Task> tasks = new ArrayList<>();
        List<Task> deletedTasks = new ArrayList<>();
        String operator;

        String command = "";
        while (!command.equals("0")) {
            System.out.println("===ORGANIZER===");
            System.out.println("---Main menu---");
            System.out.println("Add task    [1]");
            System.out.println("Edit task   [2]");
            System.out.println("Show task   [3]");
            System.out.println("Delete task [4]");
            System.out.println("Quit        [0]");
            try {
                String[]chars=new String[]{"1","2","3","4","0"};
                operator = getOperator(chars);
            } catch (NotSupportedOperationException e) {
                System.out.println("Exception:" + e);
                operator = sc.next();
            }
            switch (operator) {
                case "1": {
                    String command1 = "";
                    while (!command1.equals("0")) {
                        System.out.println("---Add task---");
                        System.out.println("By steps   [1]");
                        System.out.println("By pattern [2]");
                        System.out.println("Back       [0]");
                        try {
                            String[]chars=new String[]{"1","2","0"};
                            operator = getOperator(chars);
                        } catch (NotSupportedOperationException e) {
                            System.out.println("Exception:" + e);
                            operator = sc.next();
                        }
                        switch (operator) {
                            case "1": {
                                System.out.println("---By steps---");
                                System.out.println("Continue   [1]");
                                System.out.println("Cancel     [0]");
                                try {
                                    String[]chars=new String[]{"1","0"};
                                    operator = getOperator(chars);
                                } catch (NotSupportedOperationException e) {
                                    System.out.println("Exception:" + e);
                                    operator = sc.next();
                                }
                                if (operator.equals("1")) {
                                    //Call method writeFile with 2 parameters " +
                                    // "(filePath and List<String> to write)
                                    System.out.println("Call method writeFile with 2 parameters " +
                                            "(filePath and List<String> to write)  ");
                                } else
                                    break;
                            }
                            break;
                            case "2": {
                                System.out.println("--By pattern--");
                                System.out.println("Continue   [1]");
                                System.out.println("Cancel     [0]");
                                try {
                                    String[]chars=new String[]{"1","0"};
                                    operator = getOperator(chars);
                                } catch (NotSupportedOperationException e) {
                                    System.out.println("Exception:" + e);
                                    operator = sc.next();
                                }
                                if (operator.equals("1")) {
                                    //Call method writeFile with 2 parameters " +
                                    // "(filePath and List<String> to write)
                                    System.out.println("Call method writeFile with 2 parameters " +
                                            "(filePath and List<String> to write)  ");
                                } else
                                    break;
                            }
                            break;
                            case "0": {
                                command1 = "0";
                                break;
                            }
                        }
                    }
                }
                break;
                case "2": {
                    String command2 = "";
                    while (!command2.equals("0")) {
                        System.out.println("---Edit task---");
                        System.out.println("Existing    [1]");
                        System.out.println("Recycle Bin [2]");
                        System.out.println("Back        [0]");
                        try {
                            String[]chars=new String[]{"1","2","0"};
                            operator = getOperator(chars);
                        } catch (NotSupportedOperationException e) {
                            System.out.println("Exception:" + e);
                            operator = sc.next();
                        }
                        switch (operator) {
                            case "1": {
                                System.out.println("--Existing--");
                                //Call method readFile from List<Task> tasks = new ArrayList<>();
                                System.out.println("Call method readFile from List<Task> " +
                                        "tasks = new ArrayList<>()");
                                System.out.println("Call method writeFile with 2 parameters " +
                                        "(filePath and List<String> to write)  ");
                                break;
                            }
                            case "2": {
                                System.out.println("-Recycle Bin-");
                                //Call method readFile from List<Task> deletedTasks = new ArrayList<>();
                                System.out.println("Call method readFile from List<Task> " +
                                        "deletedTasks = new ArrayList<>();");
                                System.out.println("Call method writeFile with 2 parameters " +
                                        "(filePath and List<String> to write)  ");
                                break;
                            }
                            case "0": {
                                command2 = "0";
                                break;
                            }
                        }
                    }
                }
                break;
                case "3": {
                    String command3 = "";
                    while (!command3.equals("0")) {
                        System.out.println("----Showing----");
                        System.out.println("All tasks   [1]");
                        System.out.println("By filter   [2]");
                        System.out.println("Deleted     [3]");
                        System.out.println("Back        [0]");
                        try {
                            String[]chars=new String[]{"1","2","3","0"};
                            operator = getOperator(chars);
                        } catch (NotSupportedOperationException e) {
                            System.out.println("Exception:" + e);
                            operator = sc.next();
                        }
                        switch (operator) {
                            case "1": {
                                System.out.println("--All tasks--");
                                System.out.println("Call method readFile from List<Task> " +
                                        "tasks = new ArrayList<>()");
                                break;
                            }
                            case "2": {
                                System.out.println("--By filter--");
                                System.out.println("Call method readFileByFilter from List<Task> " +
                                        "tasks = new ArrayList<>()");
                                break;
                            }
                            case "3": {
                                System.out.println("---Deleted---");
                                //Call method readFile from List<Task> deletedTasks = new ArrayList<>();
                                System.out.println("Call method readFile from List<Task> " +
                                        "deletedTasks = new ArrayList<>();");
                                break;
                            }
                            case "0": {
                                command3 = "0";
                                break;
                            }
                        }
                    }
                }
                break;
                case "4": {
                    String command4 = "";
                    while (!command4.equals("0")) {
                        System.out.println("----Delete----");
                        System.out.println("By Id      [1]");
                        System.out.println("By period  [2]");
                        System.out.println("Back       [0]");
                        try {
                            String[]chars=new String[]{"1","2","0"};
                            operator = getOperator(chars);
                        } catch (NotSupportedOperationException e) {
                            System.out.println("Exception:" + e);
                            operator = sc.next();
                        }
                        switch (operator) {
                            case "1": {
                                System.out.println("----By Id----");
                                System.out.println("Call method readFile from List<Task> " +
                                        "tasks = new ArrayList<>()");
                                System.out.println("Call method deletedTaskById from List<Task> " +
                                        "tasks = new ArrayList<>()");
                                break;
                            }
                            case "2": {
                                System.out.println("--By period--");
                                System.out.println("Call method readFile from List<Task> " +
                                        "tasks = new ArrayList<>()");
                                System.out.println("Call method deletedTaskByPeriod from List<Task> " +
                                        "tasks = new ArrayList<>()");
                                break;
                            }
                            case "0": {
                                command4 = "0";
                                break;
                            }
                        }
                    }
                }
                break;
                case "0": {
                    command = "0";
                    break;
                }
            }
        }
    }

    // Method of validation inputting number
    public static int setIntNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Input number");
        int number = 0;
        boolean validation = false;
        do {
            try {
                validation = sc.hasNextInt();
                number = sc.nextInt();

            } catch (InputMismatchException e) {
                System.out.println(e);
                sc.nextLine();
            }
        } while (!validation);
        return number;
    }

    //Method of validation inputting operator to String[] chars1 send number of menu items
    public static String getOperator(String[] chars1) throws NotSupportedOperationException {
        Scanner sc = new Scanner(System.in);
        String operator = sc.next();
        List<String> chars = Arrays.asList(chars1);
        boolean validation;

        do {
            if (validation = chars.contains(operator)) {
                break;
            } else {
                throw new NotSupportedOperationException();
            }
        } while (!validation);
        return operator;
    }

    static class NotSupportedOperationException extends Exception {

        public String toString() {
            return "NotSupportedOperationException";
        }
    }
}



