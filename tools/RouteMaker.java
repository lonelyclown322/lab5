package tools;

import Entities.Coordinates;
import Entities.Location;
import Entities.Route;
import tools.exceptions.NotCorrectArgumentException;
import tools.interfaces.ObjectMaker;

import java.time.format.DateTimeParseException;

/**
 * class for making the routes from the file
 */

public class RouteMaker implements ObjectMaker<Route> {

    @Override
    public Route makeObject(String[] splittedString) throws NotCorrectArgumentException {

        Route route = new Route();

        int i = 0;
        try {
            route.setId(Integer.parseInt(splittedString[i++]));
            route.setName(splittedString[i++]);

            Coordinates coordinates = new Coordinates();
            coordinates.setX(Double.parseDouble(splittedString[i++]));
            coordinates.setY(Long.parseLong(splittedString[i++]));
            route.setCoordinates(coordinates);

            route.setCreationDate(splittedString[i++]);

            for (int j = 0; j < 2; j++) {
                Location location = new Location();
                location.setX(Float.parseFloat(splittedString[i++]));
                location.setY(Long.parseLong(splittedString[i++]));
                location.setZ(Double.parseDouble(splittedString[i++]));
                location.setName(splittedString[i++]);
                if (j == 0) route.setFrom(location);
                else route.setTo(location);
            }

            route.setDistance(Float.parseFloat(splittedString[i++]));
        } catch (IllegalArgumentException e) {
            throw new NotCorrectArgumentException(++i);
        }

        return route;
    }
}
