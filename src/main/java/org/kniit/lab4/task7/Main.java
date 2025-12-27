package org.kniit.lab4.task7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("\n");
            System.setOut(new PrintStream(System.out, true, "Cp866"));

            List<String> wordsList = getWords("Java_Coding/misc/dictionary.txt");
            String[] words = wordsList.toArray(new String[wordsList.size()]);
            char[] alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();

            DictionaryStatistic statistic = new DictionaryStatistic(words, alphabet);

            System.out.println("Статистика словаря:");
            System.out.println("Количество слов: " + statistic.getDictionarySize());
            System.out.println("Количество палиндромов: " + statistic.getPolindromCount());
            System.out.println("Максимальная длина слова: " + statistic.getMaxWordLength());
            System.out.println("Минимальная длина слова: " + statistic.getMinWordLength());
            System.out.println("Наиболее часто встречающаяся буква: " + statistic.getMostFrequentLetter());
            System.out.println();
            
            // Вывод статистики букв
            statistic.printSymbolsStat();


        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл со словами не найден!");
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }



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