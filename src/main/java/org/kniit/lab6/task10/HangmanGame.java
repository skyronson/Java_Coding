package org.kniit.lab6.task10;

import java.util.*;

public class HangmanGame {
    private static final List<String> WORDS = Arrays.asList(
        // Технологии и IT
        "компьютер", "программа", "алгоритм", "интерфейс", "переменная",
        "функция", "объект", "класс", "библиотека", "разработка",
        "среда", "компилятор", "инструкция", "выполнение", "обработка",
        "система", "приложение", "база", "данных", "соединение",
        "сервер", "клиент", "браузер", "вебсайт", "интернет",
        "сеть", "протокол", "адрес", "пароль", "пользователь",
        
        // Природа
        "солнце", "луна", "звезда", "планета", "галактика",
        "океан", "море", "река", "озеро", "водопад",
        "гора", "вулкан", "долина", "пещера", "остров",
        "лес", "дерево", "цветок", "трава", "лист",
        "животное", "птица", "рыба", "насекомое", "бабочка",
        
        // Искусство
        "картина", "скульптура", "музыка", "театр", "кино",
        "литература", "поэзия", "проза", "роман", "повесть",
        "художник", "композитор", "писатель", "актер", "режиссер",
        "оркестр", "хор", "балет", "опера", "спектакль",
        
        // Спорт
        "футбол", "баскетбол", "волейбол", "теннис", "хоккей",
        "плавание", "бег", "прыжки", "метание", "гимнастика",
        "чемпион", "соревнование", "тренировка", "стадион", "арена",
        "команда", "игрок", "тренер", "судья", "победа",
        
        // Еда и напитки
        "ресторан", "кухня", "повар", "блюдо", "салат",
        "суп", "гарнир", "десерт", "напиток", "кофе",
        "чай", "сок", "хлеб", "сыр", "колбаса",
        "овощи", "фрукты", "ягоды", "специи", "приправы",
        
        // Транспорт
        "автомобиль", "самолет", "поезд", "корабль", "велосипед",
        "мотоцикл", "автобус", "трамвай", "метро", "такси",
        "двигатель", "колесо", "руль", "тормоз", "акселератор",
        "аэропорт", "вокзал", "порт", "станция", "остановка",
        
        // Одежда
        "рубашка", "блузка", "костюм", "платье", "юбка",
        "брюки", "джинсы", "футболка", "свитер", "куртка",
        "пальто", "шуба", "плащ", "обувь", "туфли",
        "сапоги", "кроссовки", "ботинки", "носок", "галстук",
        
        // География
        "столица", "город", "деревня", "поселок", "улица",
        "площадь", "проспект", "бульвар", "переулок", "набережная",
        "континент", "страна", "область", "район", "граница"
        
    );
    
    private static final int MAX_ATTEMPTS = 6;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Cp866");
        boolean playAgain = true;
        
        System.out.println("\nИГРА 'ВИСЕЛИЦА'");
        System.out.println("Угадайте слово по буквам. У вас " + MAX_ATTEMPTS + " попыток.");
        
        while (playAgain) {
            playGame(scanner);
            
            System.out.print("\nХотите сыграть еще раз? (да/нет): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            playAgain = answer.equals("да") || answer.equals("д") || answer.equals("yes") || answer.equals("y");
            
            if (playAgain) {
                System.out.println("\n" + "-".repeat(40));
                System.out.println("НАЧИНАЕМ НОВУЮ ИГРУ!");
                System.out.println("-".repeat(40));
            }
        }
        scanner.close();
    }
    
    private static void playGame(Scanner scanner) {
        // Выбор случайного слова
        Random random = new Random();
        String secretWord = WORDS.get(random.nextInt(WORDS.size())).toLowerCase();
        
        List<Character> guessedWord = new ArrayList<>();
        Set<Character> guessedLetters = new HashSet<>();
        Set<Character> incorrectLetters = new HashSet<>();
        
        for (int i = 0; i < secretWord.length(); i++) {
            guessedWord.add('_');
        }
        
        int attemptsLeft = MAX_ATTEMPTS;
        boolean wordGuessed = false;
        boolean gameOver = false;
        
        System.out.println("\nЗагаданное слово состоит из " + secretWord.length() + " букв");
        
        // Основной игровой цикл
        while (!gameOver) {

            if (attemptsLeft <= 0) {
                gameOver = true;
                break;
            }
            
            if (wordGuessed) {
                gameOver = true;
                break;
            }
            
            displayGameState(guessedWord, attemptsLeft, incorrectLetters);
            
            // Ввод буквы
            char letter = getValidLetter(scanner, guessedLetters);
            guessedLetters.add(letter);
            
            // Проверка наличия буквы в слове
            if (secretWord.contains(String.valueOf(letter))) {
                // Открываем букву на всех позициях
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == letter) {
                        guessedWord.set(i, letter);
                    }
                }
                System.out.println("Верно! Буква '" + letter + "' есть в слове.");
            } else {
                attemptsLeft--;
                incorrectLetters.add(letter);
                System.out.println("Неверно! Буквы '" + letter + "' нет в слове.");
                System.out.println("Осталось попыток: " + attemptsLeft);
                
            }
            
            // Проверка, угадано ли все слово
            wordGuessed = !guessedWord.contains('_');
        }
        
        // Вывод результата игры
        displayResult(wordGuessed, secretWord);
    }
    
    private static void displayGameState(List<Character> guessedWord, int attemptsLeft, Set<Character> incorrectLetters) {
        System.out.println("\n" + "-".repeat(40));
        
        // Отображение текущего состояния слова
        System.out.print("Слово: ");
        for (char c : guessedWord) {
            System.out.print(c + " ");
        }
        System.out.println();
        
        // Отображение ошибочных букв
        if (!incorrectLetters.isEmpty()) {
            System.out.print("Ошибочные буквы: ");
            for (char c : incorrectLetters) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        
        System.out.println("Осталось попыток: " + attemptsLeft);
        System.out.println("-".repeat(40));
    }
    
    private static char getValidLetter(Scanner scanner, Set<Character> guessedLetters) {
        while (true) {
            System.out.print("Введите букву: ");
            String input = scanner.nextLine().trim().toLowerCase();
            
            if (input.isEmpty()) {
                System.out.println("Ошибка: Вы не ввели букву. Попробуйте снова.");
                continue;
            }
            
            if (input.length() != 1) {
                System.out.println("Ошибка: Пожалуйста, введите только одну букву.");
                continue;
            }
            
            char letter = input.charAt(0);
            
            // Проверка на букву
            if (!Character.isLetter(letter)) {
                System.out.println("Ошибка: Пожалуйста, введите букву.");
                continue;
            }
            
            if (guessedLetters.contains(letter)) {
                System.out.println("Ошибка: Вы уже вводили букву '" + letter + "'. Попробуйте другую.");
                continue;
            }
            
            return letter;
        }
    }
    
    private static void displayResult(boolean wordGuessed, String secretWord) {
        System.out.println("\n" + "=".repeat(40));
        
        if (wordGuessed) {
            System.out.println("ПОЗДРАВЛЯЕМ! Вы угадали слово!");
            System.out.println("Загаданное слово: " + secretWord.toUpperCase());
            System.out.println("ВЫ ПОБЕДИЛИ!");
        } else {
            System.out.println("К сожалению, вы проиграли.");
            System.out.println("Загаданное слово было: " + secretWord.toUpperCase());
            System.out.println("ИГРА ОКОНЧЕНА");
        }
        
        System.out.println("=".repeat(40));
    }
}