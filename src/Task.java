import utils.DateUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
        return title;
    }

    public void setDescription(String description) {
        this.title = title;
    }

    // constrictor
    public Task(String title, LocalDateTime localDateTime, String description) {
        this.title = title;
        this.localDateTime = localDateTime;
        this.description = description;
    }

    // constructor для получения всех 3-х параметров из одной строки
    public Task(String string) {
        String[] taskFields = string.split(";");
        this.title = taskFields[0];
        this.localDateTime = getLocalDateTime(taskFields[1]);// метод не хочет работать не пойму в чем проблема
        this.description = taskFields[2];
    }

    @Override
    public String toString() {
        return "Date:" + localDateTime + ". Title:" + title + ". Description:" + description + ".";
    }
    //метод для записи Таска в Файл уже написан в FileUtils (writeFile) принимает Лист и его прописывает а файл
}
