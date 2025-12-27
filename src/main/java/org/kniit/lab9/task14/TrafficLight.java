package org.kniit.lab9.task14;

public enum TrafficLight {
    RED, YELLOW, GREEN;

    public TrafficLight getNextLight() {
        return switch (this) {
            case RED -> GREEN;
            case YELLOW -> RED;
            case GREEN -> YELLOW;
        };
    }
}

