import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    public boolean createIfNotExists(String filePath) throws IOException {
        File file = new File(filePath);
        return(file.createNewFile());//Создаём файл, если его нет. Возвращаем false - если он есть
    }

    public List<String> readFile(String filePath) throws FileNotFoundException {
        List<String> List = new ArrayList<>();
        Scanner s = new Scanner(new File(filePath)).useDelimiter("\\s*\n\\s*");//Начинаем считывать файл. Делиметр - переход на новую строку
        while (s.hasNext()) {
            List.add(s.next());
        }
        return List;
    }

    public void writeFile(String filePath, List<String> List) throws IOException {
        if (Files.exists(Paths.get(filePath))) {//Проверяем, есть ли файл
            FileWriter writer = new FileWriter(filePath, true);//Открываем файл для записи
            for (String line : List) {
                writer.write(line);
                writer.write("\n");
            }
            writer.close();
        }
        else{
            throw new IOException();
        }
    }
}
