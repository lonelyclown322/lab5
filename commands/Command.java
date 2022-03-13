package commands;

/**
 *
 * abstract class for the commands
 */

public abstract class Command implements CommandInterface {

    private final String name;
    String arguments;
    private boolean interactiveStatus = true;

    public Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }

    public boolean isInteractiveStatus() {
        return interactiveStatus;
    }

    public void setInteractiveStatus(boolean interactiveStatus) {
        this.interactiveStatus = interactiveStatus;
    }
}
