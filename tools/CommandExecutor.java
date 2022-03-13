package tools;

import commands.Command;

import java.util.ArrayList;

/**
 *
 *  invoker class
 */

public class CommandExecutor {

    ArrayList<Command> commands;
    private boolean isInteractiveStatus = true;
    private RouteList rl;

    public CommandExecutor(ArrayList<Command> commands, RouteList rl) {
        this.commands = commands;
        this.rl = rl;
    }

    /**
     *
     * @param commandNameAndArguments name of the command
     */

    public void execute(String commandNameAndArguments) {
        String commandName;
        if (commandNameAndArguments.split(" ").length == 0 || commandNameAndArguments.equals("")) {
            return;
        }
        commandName = commandNameAndArguments.split(" ")[0];

        boolean noSuchCommand = true;

        for (Command command : commands) {

            if (command.getName().equals(commandName)) {
                if (isInteractiveStatus) {
                    command.setInteractiveStatus(true);
                } else command.setInteractiveStatus(false);

                command.setArguments(commandNameAndArguments);
                command.execute();
                rl.addCommandName(command.getName());

                noSuchCommand = false;
            }

        }
        if (noSuchCommand) {
            System.out.println("Ошибка! Команды с таким именем не существует");
        }

    }

    public boolean isInteractiveStatus() {
        return isInteractiveStatus;
    }

    /**
     *
     * @param interactiveStatus
     */

    public void setInteractiveStatus(boolean interactiveStatus) {
        isInteractiveStatus = interactiveStatus;
    }

}
