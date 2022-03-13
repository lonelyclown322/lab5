package commands;

import Entities.Route;
import tools.RouteList;

/**
 * class filtering the collection by distance
 */

public class FilterLessThanDistanceCommand extends Command {

    private RouteList routeList;

    public FilterLessThanDistanceCommand(String name, RouteList routeList) {
        super(name);
        this.routeList = routeList;
    }

    /**
     *
     *  method to execute the command
     */
    @Override
    public void execute() {
        try {
            Double distance = Double.parseDouble(this.arguments.split(" ")[1]);
            for (Route route : routeList.getRll()) {
                if (route.getDistance() < distance) {
                    System.out.println(route.toString());
                }
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Неверный формат ввода данных!");
        }

    }

    @Override
    public void getDescription() {
        System.out.println("Команда filter_less_than_distance выводит элементы коллекции поле distance которых меньше заданного");
    }
}
