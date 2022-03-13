package commands;

import tools.RouteList;

/**
 *
 * class printing last 6 commands
 */

public class HistoryCommand extends Command{

    private RouteList rl;

    public HistoryCommand(String name, RouteList rl) {
        super(name);
        this.rl = rl;
    }

    /**
     *
     *  method to execute the command
     */

    @Override
    public void execute() {
        if (rl.getCommandsHistory().size() < 6) {
            for (int i = 0; i < rl.getCommandsHistory().size() - 1; i++) {
                System.out.println(rl.getCommandsHistory().get(i));
            }
        } else {
            for (int i = 0; i < 6; i++) {
                System.out.println(rl.getCommandsHistory().get(i));
            }
        }
    }

    @Override
    public void getDescription() {
        System.out.println("Команда history выводит последние 6 команд");
    }
}
