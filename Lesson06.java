import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Lesson06 {
    /*
     * 1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
     * 2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
     * */
    private static int filecat(String destination, String append) {
        int linesWritten = 0;
        PrintStream dest;
        Scanner ap;
        try {
            dest = new PrintStream(new FileOutputStream(destination, true), true, "UTF-8");
            ap = new Scanner(new FileInputStream(append), "UTF-8");
            while (ap.hasNextLine()) {
                String s = ap.nextLine();
                dest.println(s);
                linesWritten++;
            }
            dest.close();
            ap.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return linesWritten;
    }

    // вспомогательный метод, выделяющий текстовые файлы из всех файлов в директории
    // с "динамическим массивом", т.к. ArrayList<String> еще не учили :)
    private static File[] getTextFiles(File[] files) {
        int i = 0;
        File[] result = new File[0];
        for (File file : files) {
            if (file.getName().endsWith(".txt")) {
                result = Arrays.copyOf(result, result.length + 1);
                result[i] = file;
                i++;
            }
        }
        return result;
    }

    /*
     * 3. Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле (работаем только с латиницей).
     * */
    private static boolean searchInFile(String w, File f) {
        try {
            Scanner fin = new Scanner(f, "UTF-8");
            while (fin.hasNext()) {
                if (w.equalsIgnoreCase(fin.next()))
                    return true;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /*
     * 4. Написать метод, проверяющий, есть ли указанное слово в папке
     * */
    private static boolean searchInFiles(String w, File[] files) {
        for (File file : files) {
            if (searchInFile(w, file))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // конкатенируем два тестовых файла
        filecat("test01.txt", "test02.txt");
        // готовимся к поиску слова
        Scanner in = new Scanner(System.in);
        // получаем список файлов в директории и выделяем из них текстовые
        File path = new File(".");
        File[] list = path.listFiles();
        File[] textFiles = getTextFiles(list);
        // печатем меню для выбоа фала/файлов для поиска
        System.out.println("Found following text files to search in:");
        int i;
        for (i = 0; i < textFiles.length; i++) {
            System.out.printf("%d: %s%n", i + 1, textFiles[i].getName());
        }
        System.out.println("Which file do you want to search?");
        System.out.printf("%d - %d for file or %d to search in all files ", 1, i, i + 1);
        int fileNumber = in.nextInt();
        // получаем слово, которое будем искать
        System.out.print("What word do you want to search: ");
        String word = in.next();
        // сканнер больше не нужен
        in.close();
        boolean found = false;
        if (fileNumber >= 1 && fileNumber <= i) {   // ищем в выбранном файле
            found = searchInFile(word, textFiles[fileNumber - 1]);
        } else if (fileNumber == i + 1) {           // ищем во всех файлах в директории
            found = searchInFiles(word, textFiles);
        } else {                                    // сообщаем пользователю, что он(а) не прав(а)
            System.out.println("You entered invalid file number!");
        }
        // сообщаем, что слово (не) найдено
        System.out.print("The word " + word + " ");
        System.out.printf("%s%n", (found ? "is found." : "is not found."));
    }
}
