package tools;

import Entities.Coordinates;
import Entities.Location;
import tools.exceptions.EndOfFileException;
import tools.interfaces.FieldsGetterInterface;

/**
 * class for getting the fields from the file
 */

public class ReaderFieldsGetter implements FieldsGetterInterface {

    private DataReader reader;

    public ReaderFieldsGetter(DataReader reader) {
        this.reader = reader;
    }

    @Override
    public Coordinates getCoordinates() throws EndOfFileException {
        while (true) {
            try {
                String[] splittedCoordinates = reader.readline().split(" ");
                if (splittedCoordinates.length == 1 && splittedCoordinates[0].equals("EOF")) {
                    throw new EndOfFileException();
                }
                if (splittedCoordinates.length == 2) {
                    return new Coordinates(Double.parseDouble(splittedCoordinates[0]), Long.parseLong(splittedCoordinates[1]));
                } else throw new NumberFormatException();
            } catch (NumberFormatException e) {
            }
        }
    }

    @Override
    public Location getLocation() throws EndOfFileException {
        while (true) {
            try {
                String[] splittedLocation = reader.readline().split(" ");
                if (splittedLocation.length == 1 && splittedLocation[0].equals("EOF")) {
                    throw new EndOfFileException();
                }
                if (splittedLocation.length == 4) {
                    Float.parseFloat(splittedLocation[0]);
                    Long.parseLong(splittedLocation[1]);
                    Double.parseDouble(splittedLocation[2]);
                    return new Location(Float.parseFloat(splittedLocation[0]), Long.parseLong(splittedLocation[1]),
                            Double.parseDouble(splittedLocation[2]), splittedLocation[3]);
                }
            } catch (NumberFormatException e) {
            }
        }
    }

    @Override
    public float getDistance() throws EndOfFileException {
        while (true) {
            try {
                String[] splittedDistance = reader.readline().split(" ");
                if (splittedDistance.length == 1 && splittedDistance[0].equals("EOF")) {
                    throw new EndOfFileException();
                }
                if (splittedDistance.length == 1) {
                    if (Float.parseFloat(splittedDistance[0]) > 1) {
                        return Float.parseFloat(splittedDistance[0]);
                    } else throw new NumberFormatException();
                } else throw new NumberFormatException();
            } catch (NumberFormatException e) {
            }
        }
    }

    @Override
    public String getName() throws EndOfFileException {
        while (true) {
            try {
                String name = reader.readline();
                if (name.equals("EOF")) {
                    throw new EndOfFileException();
                }
                if (!name.equals("") && !name.equals("\\s+")) {
                    return name;
                }
            } catch (NumberFormatException e) {
            }
        }
    }
}
