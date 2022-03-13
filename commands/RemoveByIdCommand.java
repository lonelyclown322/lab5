package commands;

import Entities.Route;
import tools.RouteList;

import java.util.LinkedList;

/**
 * class removing objects of the collection by id
 */

public class RemoveByIdCommand extends Command {

    private LinkedList<Route> ll;

    public RemoveByIdCommand(String name, RouteList rl) {
        super(name);
        this.ll = rl.getRll();
    }

    /**
     *
     *  method to execute the command
     */

    @Override
    public void execute() {
        try {
            int id = Integer.parseInt(this.arguments.split(" ")[1]);
            boolean isDeleted = false;
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).getId() == id) {
                    ll.remove(ll.get(i));
                    isDeleted = true;
                }
            }
            if (!isDeleted) {
                if (isInteractiveStatus()) {
                    System.out.println("Route с таким id не существует");
                }
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            if (isInteractiveStatus()) {
                System.out.println("команда должна содержать в качестве аргумента id");
            }
        }

    }

    @Override
    public void getDescription() {
        System.out.println("Команда remove_by_id удаляет из коллекции элемент id которого равен заданному");
    }
}
