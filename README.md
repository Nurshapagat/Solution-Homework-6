## Homework 6
# 🛠️ Tech Support & Smart Home Control
- **Part 1:** Chain of Responsibility
- **Part 2:** Command Pattern


### Purpose
This project models two real-world scenarios based on Behavioral Design Patterns:
- *Part 1* — Tech Support Request Handler (Chain of Responsibility):
  User technical requests are processed through different levels of support.
- *Part 2* — Smart Home Remote Control (Command Pattern):
  A smart home remote control system — each device action is executed as a separate command.

---

## Part 1: Chain of Responsibility — Tech Support Request Handler

### 🔗 Review
The user request is first passed to the FAQBot, then to the Junior and then to the Senior Specialist. Each can process the request or pass it to the next one.

- Bonus tasks completed.
###  Sample Execution

```
апр. 13, 2025 3:19:07 PM com.example.part_1.FAQBotHandler handle
INFO: FAQBot received issue: password_reset
апр. 13, 2025 3:19:07 PM com.example.part_1.FAQBotHandler handle
INFO: FAQBot received issue: refund_request
апр. 13, 2025 3:19:07 PM com.example.part_1.JuniorSupportHandler handle
INFO: JuniorSupport received issue: refund_request
апр. 13, 2025 3:19:07 PM com.example.part_1.FAQBotHandler handle
INFO: FAQBot received issue: account_ban
апр. 13, 2025 3:19:07 PM com.example.part_1.JuniorSupportHandler handle
INFO: JuniorSupport received issue: account_ban
апр. 13, 2025 3:19:07 PM com.example.part_1.SeniorSupportHandler handle
INFO: SeniorSupport received issue: account_ban
апр. 13, 2025 3:19:07 PM com.example.part_1.FAQBotHandler handle
INFO: FAQBot received issue: unknown_bug
апр. 13, 2025 3:19:07 PM com.example.part_1.JuniorSupportHandler handle
INFO: JuniorSupport received issue: unknown_bug
апр. 13, 2025 3:19:07 PM com.example.part_1.SeniorSupportHandler handle
INFO: SeniorSupport received issue: unknown_bug
```
---

```
[FAQBot] Handled password_reset
[JuniorSupport] Handled refund_request
[SeniorSupport] Handled account_ban
[SeniorSupport] Cannot handle unknown_bug — escalate manually
```
### Components

- **SupportHandler:** Abstract class with setNext() and handle() methods.

- **FAQBotHandler, JuniorSupportHandler, SeniorSupportHandler:** Concrete handlers.

- **SupportChainBuilder:** Helps automatically build the chain.

---

## Part 2: Smart Home Remote Control — Command Pattern

### 🔗 Review
This system processes the behavior of each device (turning on the light, setting the temperature, etc.) in the form of Command. In addition, there are undo/redo and macro command features.

- Bonus tasks completed.


### Structure

- `Command:` interface (execute (), undo (), redo ())
- `Light, Thermostat:` devices.
- `TurnOnLightCommand, SetThermostatCommand:` specific commands.
- `MacroCommand:` executes multiple commands simultaneously.
- `SmartHomeRemoteControl:` the logic of executing/canceling/returning commands.

###  Sample Execution

#### CLI interface:
```
=== Smart Home CLI ===
Commands: light_on, set_temp, goodnight, undo, redo, exit
> light_on
[Light] Turning ON
> set_temp
[Thermostat] Setting temperature to 22°C
> undo
[Thermostat] Reverting to previous temperature
> redo
[Thermostat] Setting temperature to 22°C
```

---

# Bonus Tasks

- ✅ Log in via **Logger**
- ✅ **UnsolvedIssueException** for unresolved problem
- ✅ **MacroCommand**: “Goodnight mode”
- ✅ **Undo and Redo** through the stack
- ✅ User commands through the **CLI menu**.

---

### Used Patterns

- *Chain of Responsibility*: The problem is handled by handlers that are one after the other.
- *Command Pattern*: Each device action is given as a separate command.
- *Macro Command*: Group multiple commands and execute them simultaneously.
- *Undo/Redo Stack*: Mechanisms for returning and reusing commands. 

