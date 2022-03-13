package commands;

import tools.RouteList;

import java.util.LinkedList;

/**
 *
 * class to clear the collection
 */

public class ClearCommand extends Command {

    private LinkedList ll;

    public ClearCommand(String name, RouteList rl) {
        super(name);
        this.ll = rl.getRll();
    }

    /**
     *
     *  method to execute the command
     */

    @Override
    public void execute() {
        ll.clear();
    }

    @Override
    public void getDescription() {
        System.out.println("Команда clear очищает коллекцию.");
    }


}
