import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Task {
    private String title;
    private LocalDateTime localDateTime;
    private String description;


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
        // использовать метод для получения LocalDateTime из DateUtils.java
        this.localDateTime = null;
        this.description = taskFields[2];
    }

    @Override
    public String toString() {
        return " " + localDateTime + " " + title + description;
    }


    //метод для записи Таска в Файл уже написан в FileUtils (writeFile) принимает Лист и его прописывает а файл
    //метод преобразования из String в List
    public static List<String> taskList(String string) {
        List<String> list = new ArrayList<>();
        try {
            list = Arrays.asList(string.split("\\s*;\\s*"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    //мейн черновик для проверки
    public static void main(String[] args) {
        String string = "12.12.12;Title;Description";
        String[] strings = string.split(";");
        System.out.println(strings[0]);
        System.out.println(strings[1]);
        System.out.println(strings[2]);

        Task task = new Task(string);
        System.out.println(task);

        System.out.println(taskList("12.12.12;Title;Description"));

    }

}
