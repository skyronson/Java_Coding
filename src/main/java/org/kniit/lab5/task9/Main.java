// package lab5.task9;

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         // Показывает текущую рабочую директорию
//         System.out.println("Текущая рабочая директория: " + System.getProperty("user.dir"));
        
//         // Показывает где Java ищет файлы
//         File currentDir = new File("."); 
//         System.out.println("Абсолютный путь текущей директории: " + currentDir.getAbsolutePath());
        
//         try {
//             List<String> words = Keyboard.getWords("dictionary.txt");
//             // ... остальной код
//         } catch (FileNotFoundException e) {
//             System.out.println("Файл не найден. Проверьте расположение файла.");
//         }
//     }
// }
