import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    public boolean createIfNotExists(String filePath) throws IOException {
        try {
            File file = new File(filePath);
            //Создаём файл, если его нет. Возвращаем false - если он есть
            return (file.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> readFile(String filePath) throws FileNotFoundException {
        try {
            List<String> List = new ArrayList<>();
            //Начинаем считывать файл. Делиметр - переход на новую строку
            Scanner s = new Scanner(new File(filePath)).useDelimiter("\\s*\n\\s*");
            while (s.hasNext()) {
                List.add(s.next());
            }
            return List;
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    public void writeFile(String filePath, List<String> List) throws IOException {
        try {
            //Проверяем, есть ли файл
            if (Files.exists(Paths.get(filePath))) {
                //Открываем файл для записи
                FileWriter writer = new FileWriter(filePath, true);
                for (String line : List) {
                    writer.write(line);
                    writer.write("\n");
                }
                writer.close();
            } else {
                throw new IOException();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
