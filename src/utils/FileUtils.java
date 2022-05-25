package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    public static boolean createIfNotExists(String filePath) {
        try {
            File file = new File(filePath);
            //Создаём файл, если его нет. Возвращаем false - если он есть
            return (file.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<String> readFile(String filePath) {
        List<String> list = new ArrayList<>();
        try {
            //Начинаем считывать файл. Делиметр - переход на новую строку
            Scanner s = new Scanner(new File(filePath));
            while (s.hasNext()) {
                list.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void writeFile(String filePath, List<String> list) {
        try {
            //Открываем файл для записи
            FileWriter writer = new FileWriter(filePath);
            for (String line : list) {
                writer.write(line);
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
