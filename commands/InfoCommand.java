package commands;

import tools.RouteList;

/**
 *
 * class printing the information of the collection
 */

public class InfoCommand extends Command{

    RouteList routeList;
    public InfoCommand(String name, RouteList routeList) {
        super(name);
        this.routeList = routeList;
    }

    /**
     *
     *  method to execute the command
     */

    @Override
    public void execute() {
        System.out.println(this.routeList.getRll().getClass());
        System.out.println(this.routeList.getCreationDatetime());
        System.out.println(this.routeList.getRll().size());
    }

    @Override
    public void getDescription() {
        System.out.println("Команда info выводит в стандартный поток вывода информацию о коллекции");
    }
}
