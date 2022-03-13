package commands;

import Entities.Route;
import tools.RouteList;

import java.io.*;
import java.util.LinkedList;

/**
 *
 *  class saving the collection to the file
 */

public class SaveCommand extends Command {

    LinkedList ll;
    String path;

    public SaveCommand(String name, RouteList rl, String path) {
        super(name);
        this.ll = rl.getRll();
        this.path = path;
    }

    /**
     *
     *  method to execute the command
     */

    @Override
    public void execute() {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            for (int i = 0; i < ll.size(); i++) {
                Route route = (Route) ll.get(i);
                String line = "";
                line += route.getId() + ",";
                line += route.getName() + ",";
                line += route.getCoordinates().getX() + ",";
                line += route.getCoordinates().getY() + ",";
                line += route.getCreationDate() + ",";
                line += route.getFrom().getX() + ",";
                line += route.getFrom().getY() + ",";
                line += route.getFrom().getZ() + ",";
                line += route.getFrom().getName() + ",";
                line += route.getTo().getX() + ",";
                line += route.getTo().getY() + ",";
                line += route.getTo().getZ() + ",";
                line += route.getTo().getName() + ",";
                line += route.getDistance();
                line += "\n";
                osw.write(line);
            }
            osw.close();
        } catch (FileNotFoundException e) {
            System.out.println("файл не найден");
        } catch (UnsupportedEncodingException e) {
            System.out.println("утф ошибка");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getDescription() {
        System.out.println("Команда save сохранет коллекцию в файл.");
    }
}


