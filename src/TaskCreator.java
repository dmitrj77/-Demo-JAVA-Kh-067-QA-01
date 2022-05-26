package organizer;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TaskCreator {
           
    public static Task addTaskBySteps() {
        
        String title = getValue("Enter title or enter 0 to cancel");
        if (title == null)
            return null;
                
        String date;
        LocalDateTime localDate;
        
        while(true) {
            date = getValue("Enter date in format yyyy-MM-ddTHH:mm:ss or enter 0 to cancel");
            if (date == null)
                return null;  
            try {
                localDate = LocalDateTime.parse(date);
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
    
    
    public static Task addTaskByPattern() {
        System.out.println("Enter title, date (in format yyyy-MM-ddTHH:mm:ss) and description using delimiter ';' or enter 0 to cancel");
        Scanner in = new Scanner(System.in);
        String input = in.next();
        if ("0".equals(input))
            return null;
        return new Task(input);
    }
    
    private static String getValue(String message) {
        System.out.println(message);
        Scanner in = new Scanner(System.in);
        String input = in.next();
        if ("0".equals(input))
            return null;
        return input;
    }
}