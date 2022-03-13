package commands;

import tools.RouteList;

import java.util.LinkedList;

/**
 *
 *  class removing the last element of the collection
 */

public class RemoveLastCommand extends Command {

    private LinkedList ll;

    public RemoveLastCommand(String name, RouteList rl) {
        super(name);
        this.ll = rl.getRll();
    }

    /**
     *
     *  method to execute the command
     */

    @Override
    public void execute() {
        if (this.ll.size() == 0) {
            if (isInteractiveStatus()) {
                System.out.println("коллекция уже пустая!");
            }
        } else {
            ll.remove(ll.size() - 1);
        }
    }

    @Override
    public void getDescription() {
        System.out.println("Команда remove_last удаляет последний элемент из коллекции");
    }
}
