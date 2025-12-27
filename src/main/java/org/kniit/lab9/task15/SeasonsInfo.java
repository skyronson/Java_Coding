package org.kniit.lab9.task15;

public class SeasonsInfo {
    public static void main(String[] args) {
        System.out.println("\nИнформация о временах года:");
        
        for (Season season : Season.values()) {
            System.out.println(season.getRussianName() + ": " + 
            season.getTemperature() + 
            ", типичный праздник - " + 
            season.getTypicalHoliday());
        }
    }
}
