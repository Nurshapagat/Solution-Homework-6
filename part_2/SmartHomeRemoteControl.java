package com.example.part_2;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SmartHomeRemoteControl {
    private Map<String, Command> slots = new HashMap<>();
    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    public void setCommand(String name, Command command) {
        slots.put(name, command);
    }

    public void pressButton(String name) {
        Command command = slots.get(name);
        if (command != null) {
            command.execute();
            undoStack.push(command);
            redoStack.clear();
        } else {
            System.out.println("[Remote] No command found for " + name);
        }
    }

    public void undoButton() {
        if (!undoStack.isEmpty()) {
            Command cmd = undoStack.pop();
            cmd.undo();
            redoStack.push(cmd);
        } else {
            System.out.println("[Remote] Nothing to undo.");
        }
    }

    public void redoButton() {
        if (!redoStack.isEmpty()) {
            Command cmd = redoStack.pop();
            cmd.execute();
            undoStack.push(cmd);
        } else {
            System.out.println("[Remote] Nothing to redo.");
        }
    }
}
