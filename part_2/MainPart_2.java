package com.example.part_2;

import java.util.*;
import java.util.Scanner;


public class MainPart_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartHomeRemoteControl remote = new SmartHomeRemoteControl();

        Light light = new Light();
        Thermostat thermostat = new Thermostat();

        Command lightOn = new TurnOnLightCommand(light);
        Command thermostat22 = new SetThermostatCommand(thermostat, 22);
        Command goodnight = new MacroCommand(List.of(lightOn, thermostat22));

        remote.setCommand("light_on", lightOn);
        remote.setCommand("set_temp", thermostat22);
        remote.setCommand("goodnight", goodnight);

        String input;
        System.out.println("=== Smart Home CLI ===");
        System.out.println("Commands: light_on, set_temp, goodnight, undo, redo, exit");

        while (true) {
            System.out.print("> ");
            input = scanner.nextLine();
            if (input.equals("exit")) break;
            else if (input.equals("undo")) remote.undoButton();
            else if (input.equals("redo")) remote.redoButton();
            else remote.pressButton(input);
        }

        System.out.println("Exiting Smart Home Remote Control.");
        scanner.close();
    }
}
