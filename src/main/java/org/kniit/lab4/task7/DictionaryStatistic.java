package org.kniit.lab4.task7;

import java.util.*;

class DictionaryStatistic {
    private String[] words;
    private int dictionarySize; // Количество слов 
    private int palindrom; // Количество слов палиндромов
    private int maxWordLength; // маскимальная длина слова в словаре
    private int minWordLength; // минимальная длина слова в словаре
    private char[] alphabet; // буквы алфавита
    private int[] frequency; //частота букв в словаре (в кадой ячейке хранит частоту букв, а индрес - это позиция буквы в alpabet)
    private Map<Character, Integer> mostFrequentLetter;

    public DictionaryStatistic(String[] words, char[] alphabet) {
        this.words = words;
        this.alphabet = alphabet;
        getStatistics();
    }

    public void getStatistics() {
        dictionarySize = words.length;
        palindrom = 0;
        maxWordLength = 0;
        minWordLength = Integer.MAX_VALUE;
        frequency = new int[alphabet.length];
        Arrays.fill(frequency, 0);

        for (String word : words) {

            if (isPalindrome(word)) {
                palindrom++;
            }

            int length = word.length();
            if (length > maxWordLength) {
                maxWordLength = length;
            }
            if (length < minWordLength) {
                minWordLength = length;
            }
            
            // Частота букв
            for (char c : word.toCharArray()) {
                int index = getCharIndex(c);
                if (index != -1) {
                    frequency[index]++;
                }
            }
        }
        mostFrequentLetter = getMostFrequentLetter();
    }


    private int getCharIndex(char c) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == c) {
                return i;
            }
        }
        return -1;
    }

    
    // получить случайное слово из словаря
    public String getRandomWord() {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }


    public void printSymbolsStat() {
       System.out.println("Статистика букв в словаре");
       for (int i = 0; i < alphabet.length; i++) {
        System.out.println(alphabet[i] + " - " + frequency[i]);
       }
    }


    private boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public int getDictionarySize() {
        return dictionarySize;
    }

    public int getPolindromCount() {
        return palindrom;
    }

    public int getMaxWordLength() {
        return maxWordLength;
    }

    public int getMinWordLength() {
        return minWordLength;
    }

    public String[] getWords() {
        return words;
    }

    public Map<Character, Integer> getMostFrequentLetter() {
        Map<Character, Integer> result = new HashMap<>();
        
        char mostFrequentLetter = ' ';
        int maxFrequency = 0;
        
        for (int i = 0; i < alphabet.length; i++) {
            if (frequency[i] > maxFrequency) {
                maxFrequency = frequency[i];
                mostFrequentLetter = alphabet[i];
            }
        }
        
        result.put(mostFrequentLetter, maxFrequency);
        return result;
    }
}
