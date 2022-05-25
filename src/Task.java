import utils.DateUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Task extends DateUtils {
    private String title;
    private LocalDateTime localDateTime;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // constructor
    public Task(String title, LocalDateTime localDateTime, String description) {
        this.title = title;
        this.localDateTime = localDateTime;
        this.description = description;
    }

    // constructor для получения всех 3-х параметров из одной строки
    public Task(String string) {
        String[] taskFields = string.split(";");
        String format = "dd.MM.yyyy HH:mm";//добавить время
        this.title = taskFields[0];
        this.localDateTime = getLocalDateTime(taskFields[1], format);//метод для получения даты и Utils
        this.description = taskFields[2];
    }

    @Override
    public String toString() {
        return "Date:" + localDateTime + ". Title:" + title + ". Description:" + description + ".";
    }

    //метод для записи полей в Файл
    public static void toStringForFile(String string) {
        try {
            FileWriter writer = new FileWriter("Tasks");
            writer.write(string);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
