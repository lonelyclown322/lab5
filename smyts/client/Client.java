package smyts.client;

import Entities.Route;
import commands.*;
import tools.*;

import java.util.*;

public final class Client {
    private Client() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }

    public static void main(String[] args)  {
        String path = "";
        if (args.length == 1) {
            path = args[0];
        }
        RouteList routeList = new RouteList();
        DataReader reader = new DataReader(path);
        FIleManager fIleManager = new FIleManager(reader, routeList.getRll(), new RouteMaker());
        fIleManager.start();
        Route.setIdGenerator(fIleManager.getMaxId());




        Scanner sc = new Scanner(System.in);
        ArrayList<Command> commands = new ArrayList<>();
        CommandExecutor commandExecutor = new CommandExecutor(commands, routeList);
        commands.add(new ClearCommand("clear", routeList));
        commands.add(new SaveCommand("save", routeList, path));
        commands.add(new HelpCommand("help", commands));
        commands.add(new InfoCommand("info", routeList));
        commands.add(new ShowCommand("show", routeList));
        commands.add(new ExecuteScriptCommand("execute_script", commandExecutor, reader));
        commands.add(new AddCommand("add", routeList, reader));
        commands.add(new UpdateIdCommand("update_id", routeList, reader));
        commands.add(new RemoveByIdCommand("remove_by_id", routeList));
        commands.add(new RemoveLastCommand("remove_last", routeList));
        commands.add(new RemoveGreaterCommand("remove_greater", routeList));
        commands.add(new HistoryCommand("history", routeList));
        commands.add(new AverageOfDistanceCommand("average_of_distance", routeList));
        commands.add(new FilterLessThanDistanceCommand("filter_less_than_distance", routeList));
        commands.add(new PrintUniqueDistanceCommand("print_unique_distance", routeList));


        System.out.println("введите help чтобы увидеть список доступных команд \nвведите exit чтобы завершить работу");
        while (true) {

            String commandName = sc.nextLine();

            if (commandName.equals("exit")) {
                break;
            }

            commandExecutor.execute(commandName);


        }

    }


}
