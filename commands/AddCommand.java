package commands;

import Entities.Route;
import tools.*;
import tools.exceptions.EndOfFileException;

import java.util.LinkedList;

/**
 * command for adding element to the collection
 *
 */

public class AddCommand extends Command {



    private LinkedList ll;
    private CommonFieldsGetter fieldsGetter;

    /**
     *
     *
     * @param name name of the command
     * @param rl wrapper of the list
     * @param reader reader of the file
     */
    public AddCommand(String name, RouteList rl, DataReader  reader) {

        super(name);
        this.ll = rl.getRll();
        this.fieldsGetter = new CommonFieldsGetter(new ScannerFieldsGetter(reader.getScanner()), new ReaderFieldsGetter(reader));

    }

    /**
     *
     *  method to execute the command
     */

    @Override
    public void execute() {
        if (this.isInteractiveStatus()) {

            if (this.arguments.split(" ").length == 2) {

                try {

                    Route route = fieldsGetter.start(true);
                    route.setName(this.arguments.split(" ")[1]);
                    ll.add(route);

                } catch (EndOfFileException ignored) {
                }
            } else {

                System.out.println("Команда add должна содержать имя");

            }
        } else {

            if (this.arguments.split(" ").length == 2) {

                try {

                    Route route = fieldsGetter.start(false);
                    route.setName(this.arguments.split(" ")[1]);
                    ll.add(route);

                } catch (EndOfFileException e) {
                }

            }

        }


    }


    @Override
        public void getDescription() {
            System.out.println("Команда add *name* активирует форму для добавления в коллекцию нового элемента.");
        }
}
