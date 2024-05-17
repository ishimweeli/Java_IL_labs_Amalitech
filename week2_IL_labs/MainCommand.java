import java.util.ArrayList;
import java.util.List;

// Command interface
interface Command {
    void execute();
}

// Concrete command: Turn on command
class TurnOnCommand implements Command {
    private Light light;

    public TurnOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete command: Turn off command
class TurnOffCommand implements Command {
    private Light light;

    public TurnOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Receiver
class Light {
    public void turnOn() {
        System.out.println("Light is turned on");
    }

    public void turnOff() {
        System.out.println("Light is turned off");
    }
}

// Invoker
class RemoteControl {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void executeCommands() {
        for (Command command : commands) {
            command.execute();
        }
        commands.clear();
    }
}

public class MainCommand {
    public static void main(String[] args) {
        // Receiver
        Light light = new Light();

        // Concrete commands
        Command turnOnCommand = new TurnOnCommand(light);
        Command turnOffCommand = new TurnOffCommand(light);

        // Invoker
        RemoteControl remoteControl = new RemoteControl();

        // Add commands to the remote control
        remoteControl.addCommand(turnOnCommand);
        remoteControl.addCommand(turnOffCommand);

        // Execute the commands
        remoteControl.executeCommands();
    }
}
