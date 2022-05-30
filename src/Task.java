import utils.DateUtils;

import java.time.LocalDateTime;

public class Task {
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

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
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
        this.title = taskFields[0];
        this.localDateTime = DateUtils.getLocalDateTime(taskFields[1], DateUtils.format);
        this.description = taskFields[2];
    }

    @Override
    public String toString() {
        String date = DateUtils.getStringFormat(localDateTime, DateUtils.format);
        return String.format("Title:%s. Date:%s. Description:%s.", title, date, description);
    }

    //метод для передачи строки для записи в файл
    public String getStringForFile() {
        String date = DateUtils.getStringFormat(localDateTime, DateUtils.format);
        return String.format("%s;%s;%s", title, date, description);
    }

}
