package commands;

import tools.RouteList;

import java.util.LinkedList;

/**
 *
 *  class printing the collection
 */

public class ShowCommand extends Command {

    String name;
    LinkedList ll;

    public ShowCommand(String name, RouteList rl) {
        super(name);
        this.ll = rl.getRll();
    }

    /**
     *
     *  method to execute the command
     */

    @Override
    public void execute() {
        for (int i = 0; i < ll.size(); i++) {
            System.out.println("Route " + (i + 1));
            System.out.println(ll.get(i).toString());
        }

    }

    @Override
    public void getDescription() {
        System.out.println("Команда show выводит в стандартный поток вывода все элементы коллекции в строковом представлении");
    }
}
