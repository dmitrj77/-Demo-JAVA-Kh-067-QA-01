import utils.DateUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import static utils.DateUtils.format;

public class TaskCreator {

    public static Task addTaskBySteps() {
        System.out.println("Enter title ");
        String title = App.getInputString();
        LocalDateTime localDate;
        System.out.println(("Enter date in format " + format));
        localDate = App.getCorrectData();
        System.out.println("Enter description ");
        String description = App.getInputString();
        return new Task(title, localDate, description);
    }

    public static Task addTaskByPattern() {
        while (true) {
            System.out.println("Enter title, date (in format " + format + ") and description using delimiter ';'");
            String pattern = App.getInputString();
            if (isStringValid(pattern)) {
                return new Task(pattern);
            }
        }
    }

    private static boolean isStringValid(String pattern) {
        String[] taskFields = pattern.split(";");
        if (taskFields.length < 3) {
            System.out.println("Error! Incorrect pattern.");
            return false;
        }
        try {
            DateUtils.getLocalDateTime(taskFields[1], format);
        } catch (DateTimeParseException ex) {
            System.out.println("Error! Incorrect pattern.");
            return false;
        }
        return true;
    }

}
