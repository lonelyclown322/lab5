package commands;

import Entities.Route;
import tools.RouteList;

/**
 *
 * class for counting the average distance of the collection
 */

public class AverageOfDistanceCommand extends Command {

    private RouteList routeList;

    public AverageOfDistanceCommand(String name, RouteList routeList) {
        super(name);
        this.routeList = routeList;
    }

    /**
     *
     *  method to execute the command
     */

    @Override
    public void execute() {
        double sum = 0;
        for (Route rl : routeList.getRll()) {
            sum += rl.getDistance();
        }
        System.out.println(routeList.getRll().size() == 0 ? "в коллекции нет элементов"
                : sum / routeList.getRll().size());
    }

    @Override
    public void getDescription() {
        System.out.println("Команда average_of_distance выводит среднее значение поля distance всех элементов коллекции");
    }
}
