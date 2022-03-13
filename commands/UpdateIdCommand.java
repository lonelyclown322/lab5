package commands;

import Entities.Route;
import tools.*;
import tools.exceptions.EndOfFileException;

/**
 *
 *  class updating the element by id
 */


public class UpdateIdCommand extends Command {

    private RouteList rl;
    private CommonFieldsGetter fieldsGetter;
    private DataReader reader;

    public UpdateIdCommand(String name, RouteList rl, DataReader dataReader) {
        super(name);
        this.rl = rl;
        this.reader = dataReader;
        this.fieldsGetter = new CommonFieldsGetter(new ScannerFieldsGetter(reader.getScanner()), new ReaderFieldsGetter(reader));
    }

    /**
     *
     *  method to execute the command
     */
    @Override
    public void execute() {
        if (isInteractiveStatus()) {
            try {
                int id = Integer.parseInt(this.arguments.split(" ")[1]);
                Route route = rl.getRouteById(id);
                if (route == null) {
                    System.out.println("Route с таким id не существует");
                } else {
                    rl.getRll().remove(route);
                    Route newRoute = fieldsGetter.start(true);
                    newRoute.setId(id);
                    newRoute.setName(fieldsGetter.getScanner().getName());
                    rl.getRll().add(newRoute);
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException | EndOfFileException e) {
                System.out.println("Команда updateId должна содержать id > 0 в качестве второго аргумента");
            }
        } else {
            try {
                int id = Integer.parseInt(this.arguments.split(" ")[1]);
                Route route = rl.getRouteById(id);
                if (route != null) {
                    Route newRoute = fieldsGetter.start(false);
                    newRoute.setId(id);
                    newRoute.setName(fieldsGetter.getReader().getName());
                    rl.getRll().add(newRoute);
                    rl.getRll().remove(route);
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException | EndOfFileException e) {}
        }
    }

    @Override
    public void getDescription() {
        System.out.println("Команда update_id обновляет значение элемента id которого равен заданному");
    }
}
