package tools.interfaces;

import Entities.Coordinates;
import Entities.Location;
import tools.exceptions.EndOfFileException;

public interface FieldsGetterInterface {
    Coordinates getCoordinates() throws EndOfFileException;
    Location getLocation() throws EndOfFileException;
    float getDistance() throws EndOfFileException;
    String getName() throws EndOfFileException;
}
