package org.kniit.lab6.task10;

public class Display {

    public static void displayHangman(int wrongAttempts) {

    String[] hangmanStages = {
            // 0 ошибок
            "  _______\n" +
            "  |     |\n" +
            "  |\n" +
            "  |\n" +
            "  |\n" +
            "  |\n" +
            "__|__",
            
            // 1 ошибка
            "  _______\n" +
            "  |     |\n" +
            "  |     O\n" +
            "  |\n" +
            "  |\n" +
            "  |\n" +
            "__|__",
            
            // 2 ошибки
            "  _______\n" +
            "  |     |\n" +
            "  |     O\n" +
            "  |     |\n" +
            "  |\n" +
            "  |\n" +
            "__|__",
            
            // 3 ошибки
            "  _______\n" +
            "  |     |\n" +
            "  |     O\n" +
            "  |    /|\n" +
            "  |\n" +
            "  |\n" +
            "__|__",
            
            // 4 ошибки
            "  _______\n" +
            "  |     |\n" +
            "  |     O\n" +
            "  |    /|\\\n" +
            "  |\n" +
            "  |\n" +
            "__|__",
            
            // 5 ошибок
            "  _______\n" +
            "  |     |\n" +
            "  |     O\n" +
            "  |    /|\\\n" +
            "  |    /\n" +
            "  |\n" +
            "__|__",
            
            // 6 ошибок
            "  _______\n" +
            "  |     |\n" +
            "  |     O\n" +
            "  |    /|\\\n" +
            "  |    / \\\n" +
            "  |\n" +
            "__|__"
        };
        
        if (wrongAttempts >= 0 && wrongAttempts < hangmanStages.length) {
            System.out.println("\nТекущее состояние виселицы:");
            System.out.println(hangmanStages[wrongAttempts]);
        }
    }

}
