package commands;

import java.util.ArrayList;

/**
 * class printing all of the commands
 */

public class HelpCommand extends Command {

    ArrayList<Command> commands;

    public HelpCommand(String name, ArrayList<Command> commands) {
        super(name);
        this.commands = commands;
    }

    /**
     *
     *  method to execute the command
     */

    @Override
    public void execute() {
        for (Command command : commands) {
            command.getDescription();
        }
    }

    @Override
    public void getDescription() {
        System.out.println("Команда help выводит справку по доступным командам.");
    }
}
