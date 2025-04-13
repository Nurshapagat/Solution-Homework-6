package com.example.part_2;

public class Thermostat {
    private int temperature = 20;
    private int prevTemp = 20;

    public void setTemperature(int temp) {
        prevTemp = temperature;
        temperature = temp;
        System.out.println("[Thermostat] Setting temperature to " + temp + "°C");
    }

    public void revertTemperature() {
        System.out.println("[Thermostat] Reverting to previous temperature: " + prevTemp + "°C");
        int temp = temperature;
        temperature = prevTemp;
        prevTemp = temp;
    }
}
