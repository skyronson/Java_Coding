package org.kniit.lab9.task15;

public enum Season {
        WINTER("Холодно", "Новый год"),
        SPRING("Тепло", "Пасха"),
        SUMMER("Жарко", "День независимости"),
        AUTUMN("Прохладно", "День учителя");
        
        private final String temperature;
        private final String typicalHoliday;
        
        Season(String temperature, String typicalHoliday) {
            this.temperature = temperature;
            this.typicalHoliday = typicalHoliday;
        }
        
        public String getTemperature() {
            return temperature;
        }
        
        public String getTypicalHoliday() {
            return typicalHoliday;
        }
        
        public String getRussianName() {
            switch(this) {
                case WINTER: return "Зима";
                case SPRING: return "Весна";
                case SUMMER: return "Лето";
                case AUTUMN: return "Осень";
                default: return this.toString();
            }
        }
    }
