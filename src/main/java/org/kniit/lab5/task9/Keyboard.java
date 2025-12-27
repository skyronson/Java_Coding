package org.kniit.lab5.task9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Keyboard {

    public static void main(String[] args) {
        try {

            System.setOut(new PrintStream(System.out, true, "Cp866"));

            List<String> words = getWords("Java_Coding/misc/dictionary.txt");
            
            int totalWords = 0;
            int correctWords = 0;
            int totalCharacters = 0;
            
            Random random = new Random();
            
            // Время начала отсчета
            long startTime = System.currentTimeMillis();
            // Длительность отсчета
            long duration = 60;
            // Время окончания отсчета
            long endTime = startTime + (duration * 1000);
            
            System.out.println("\nУ вас есть 1 минута. Вводите слова, которые появляются на экране.");
            System.out.println("Нажмите Enter, чтобы начать...");
            
            // Ждем, пока пользователь нажмет Enter
            new Scanner(System.in).nextLine();
            
            long currentTime = System.currentTimeMillis();
            Scanner inputScanner = new Scanner(System.in, "Cp866");
            
            while (currentTime < endTime) {
                // Выбираем случайное слово
                String randomWord = words.get(random.nextInt(words.size()));
                System.out.print("Введите слово: " + randomWord + " -> ");
                
                // Ввод пользователя
                String userInput = inputScanner.nextLine();
                
                // Обновление текущего времени
                currentTime = System.currentTimeMillis();
                
                if (currentTime < endTime) {
                    totalWords++;
                    totalCharacters += userInput.length();
                    
                    if (userInput.equalsIgnoreCase(randomWord)) {
                        correctWords++;
                        System.out.println("Верно!");
                    } else {
                        System.out.println("Неверно. Правильно: " + randomWord);
                    }
                    
                    System.out.println();
                } else {
                    System.out.println("Время вышло! Последнее слово не учитывается.");
                }
            }
            
            inputScanner.close();
            
            // Подводим итоги
            double charactersPerSecond = (double) totalCharacters / duration;
            
            System.out.println("Всего слов показано: " + totalWords);
            System.out.println("Правильных слов: " + correctWords);
            System.out.println("Всего введено символов: " + totalCharacters);
            System.out.printf("Скорость печати: %.1f символов в секунду\n", charactersPerSecond);
            
            if (totalWords > 0) {
                double accuracy = (double) correctWords / totalWords * 100;
                System.out.printf("Точность: %.1f%%\n", accuracy);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл со словами не найден!");
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }

    // Возвращает список слов из файла
    public static List<String> getWords(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        List<String> words = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine().trim();

            word = word.replaceAll("[^а-яА-ЯЁё]", "");
            if (!word.isEmpty()) {
                words.add(word);
            }
        }
        scanner.close();
        return words;
    }
}