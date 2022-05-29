
import utils.DateUtils;
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
            date = getValue("Enter date in format \"dd.MM.yyyy HH:mm\" or enter 0 to cancel");
            if (date == null)
                return null;  
            try {
                localDate = DateUtils.getLocalDateTime(date, DateUtils.format);
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
        
        while(true) {
            String pattern = getValue("Enter title, date (in format \"dd.MM.yyyy HH:mm\") and description using delimiter ';' or enter 0 to cancel");
            if (pattern == null) {
                return null;
            }
            if (isStringValid(pattern)) {
                return new Task(pattern);
            }
        }
    }
    
    private static String getValue(String message) {
        System.out.println(message);
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if ("0".equals(input))
            return null;
        return input;
    }
    
    private static boolean isStringValid(String pattern) {
        
        String[] taskFields = pattern.split(";");
        if (taskFields.length < 3) {
            System.out.println("Error! Incorrect pattern.");
            return false;
        }
        try {
            DateUtils.getLocalDateTime(taskFields[1], DateUtils.format);
        }
        catch (DateTimeParseException ex) {
            System.out.println("Error! Incorrect pattern.");
            return false;
        }
        return true;
    }
}