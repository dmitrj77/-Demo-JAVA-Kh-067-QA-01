package organizer;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TaskCreator {
    
    public Task createTask() {
        
        Task task = null;
        
        while (task == null) {
            String choise = printAddMenu();
            
            switch (choise) {
                case "1":
                    task = addByStep();
                    break;
                case "2":
                    task = addByPattern();
                    break;
                case "0":
                    return null;
                default:
                    System.out.println("Invalid input. Please try again");
                    break;
            }
        }
        
        return task;
    }
    
    private String printAddMenu() {
        
        System.out.println("Add task\n" +
                           "By steps [1]\n" +
                           "By pattern [2]\n" +
                           "Back [0]");
        
        Scanner in = new Scanner(System.in);
        return in.next();
    }
    
    private Task addByStep() {
        
        String title = getValue("Enter title or enter 0 to cancel");
        if (title == null)
            return null;
                
        String date;
        LocalDate localDate;
        
        while(true) {
            date = getValue("Enter date in format yyyy-MM-dd or enter 0 to cancel");
            if (date == null)
                return null;  
            try {
                localDate = LocalDate.parse(date);
                break;
            }
            catch (DateTimeParseException ex) {
                System.out.println("Invalid date format. Please, try again");
            }
        }
        
        String description = getValue("Enter description or enter 0 to cancel");
        if (description == null)
            return null;
        
        return new Task(title, localDate, description);
    }
    
    private String getValue(String message) {
        System.out.println(message);
        Scanner in = new Scanner(System.in);
        String input = in.next();
        if ("0".equals(input))
            return null;
        return input;
    }
    
    private Task addByPattern() {
        System.out.println("Enter title, date and description using delimiter ';' or enter 0 to cancel");
        Scanner in = new Scanner(System.in);
        String input = in.next();
        if ("0".equals(input))
            return null;
        return new Task(input);
    }
}