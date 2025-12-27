package org.kniit.lab9.task14;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведите текущий сигнал светофора (RED, YELLOW, GREEN): ");
        String light = scanner.nextLine().toUpperCase().trim();

        TrafficLight currentLight = TrafficLight.valueOf(light);
        TrafficLight nextLight = currentLight.getNextLight();

        System.out.print("Следующий сигнал: " + nextLight);
    }
}
