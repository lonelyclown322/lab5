package commands;

import Entities.Route;
import tools.RouteList;

import java.util.LinkedList;

/**
 *
 *  class removing all the elements greater than given
 */

public class RemoveGreaterCommand extends Command {

    private LinkedList<Route> ll;

    public RemoveGreaterCommand(String name, RouteList rl) {
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
            float distance = Float.parseFloat(this.arguments.split(" ")[1]);
            if (distance <= 1) {
                throw new NumberFormatException();
            }
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).getDistance() > distance) {
                    ll.remove(ll.get(i));
                    i--;
                }
            }
        } catch (NumberFormatException e) {
            if (isInteractiveStatus()) {
                System.out.println("Введенное число должно быть больше 1 ");
            }
        }
    }

    @Override
    public void getDescription() {
        System.out.println("Команда remove_greater удаляет из коллекции элементы значение distance которых превыщает заданное");
    }
}
