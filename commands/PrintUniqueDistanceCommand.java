package commands;

import Entities.Route;
import tools.RouteList;

import java.util.HashSet;

/**
 *
 *  class finding the unique distance
 */

public class PrintUniqueDistanceCommand extends Command {

    private RouteList routeList;

    public PrintUniqueDistanceCommand(String name, RouteList routeList) {
        super(name);
        this.routeList = routeList;
    }

    /**
     *
     *  method to execute the command
     */

    @Override
    public void execute() {
        HashSet<Float> hs = new HashSet<>();
        for (Route route : routeList.getRll()) {
            hs.add(route.getDistance());
        }
        for (Float a : hs) {
            System.out.println(a);
        }
    }

    @Override
    public void getDescription() {
        System.out.println("Команда print_unique_distance выводит уникальные значения поля distance среди всех элементов");
    }
}
