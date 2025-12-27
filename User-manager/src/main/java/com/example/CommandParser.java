package com.example;

import java.util.ArrayList;
import java.util.List;


public class CommandParser {

    public static List<String> parseCommandLine(String line) {
        List<String> tokens = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;
        boolean escaped = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (escaped) {
                current.append(c);
                escaped = false;
                continue;
            }

            if (c == '\\') {
                escaped = true;
                continue;
            }

            if (c == '"') {
                inQuotes = !inQuotes;
                continue;
            }

            if (Character.isWhitespace(c) && !inQuotes) {
                if (current.length() > 0) {
                    tokens.add(current.toString());
                    current.setLength(0); // очистить
                }
                continue;
            }

            current.append(c);
        }

        // Добавить последний токен, если есть
        if (current.length() > 0) {
            tokens.add(current.toString());
        }

        return tokens;
    }
}
