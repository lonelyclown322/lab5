//package commands;
//
//import collection.Coordinates;
//import collection.Location;
//import collection.Route;
//import tools.DataReader;
//
//import java.io.FileNotFoundException;
//import java.io.UnsupportedEncodingException;
//import java.time.ZonedDateTime;
//import java.util.LinkedList;
//import java.util.Scanner;
//
//public class AddCommand extends Command {
//    //команда которая добавляет в коллекцию маршрут
//
//    LinkedList<Route> ll;
//    DataReader reader;
//
//    public AddCommand(String name, LinkedList<Route> ll, DataReader reader) {
//        super(name);
//        this.ll = ll;
//        this.reader = reader;
//    }
//
//    @Override
//    public void execute() {
//
//        if (this.arguments.split(" ").length == 1) {
//
//            System.out.println("Ошибка! Имя должно быть введено в одной строке с командой");
//
//        } else {
//            Route route = new Route();
//
//
//            route.setName(arguments.split(" ")[1]);
//
//
//            System.out.println("Пожалуйста, введите координаты x и y");
//
//
//            boolean isCorrectCoordinates = false;
//
//
//            while (!isCorrectCoordinates) {
//                String line = reader.readline();
//                if (line.equals("EOF")) {
//                    break;
//                }
//                try {
//                    var coordinates = line.split(" ");
//                    route.setCoordinates(new Coordinates(Double.parseDouble(coordinates[0]), Long.parseLong(coordinates[1])));
//                    isCorrectCoordinates = true;
//                   // System.out.println(line);
//                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
//                    System.out.println("Неверный формат ввода координат!");
//                }
//            }
//
//
//            System.out.println("Введите координаты x y z  и имя начала");
//
//
//            boolean isCorrectLocation = false;
//
//
//            while (!isCorrectLocation) {
//                String line = reader.readline();
//                if (line.equals("EOF")) {
//                    break;
//                }
//                try {
//                    var location = line.split(" ");
//                    route.setFrom(new Location(Float.parseFloat(location[0]),
//                            Long.parseLong(location[1]),
//                            Double.parseDouble(location[2]),
//                            location[3]));
//                    isCorrectLocation = true;
//                } catch (NumberFormatException | ArrayIndexOutOfBoundsException a) {
//                    System.out.println("Неверный формат ввода координат1!");
//                }
//            }
//
//
//            isCorrectLocation = false;
//            System.out.println("Введите координаты x y z и имя конца ");
//
//
//            while (!isCorrectLocation) {
//                String line = reader.readline();
//                if (line.equals("EOF")) {
//                    break;
//                }
//                try {
//                    var location = line.split(" ");
//                    route.setTo(new Location(Float.parseFloat(location[0]),
//                            Long.parseLong(location[1]),
//                            Double.parseDouble(location[2]),
//                            location[3]));
//                    isCorrectLocation = true;
//                } catch (NumberFormatException | ArrayIndexOutOfBoundsException a) {
//                    System.out.println("Неверный формат ввода координат2!");
//                }
//            }
//
//
//            boolean isCorrectDistance = false;
//            System.out.println("Пожалуйста введите длину дистанции");
//
//
//            while (!isCorrectDistance) {
//                String line = reader.readline();
//                if (line.equals("EOF")) {
//                    break;
//                }
//                try {
//                    var distance = line;
//                    route.setDistance(Float.parseFloat(distance));
//                    isCorrectDistance = true;
//                } catch (NumberFormatException e) {
//                    System.out.println("Неверный формат ввода дистанции!");
//                }
//            }
//
//            route.setId();
//            route.setCreationDate(ZonedDateTime.now().toString());
//            ll.add(route);
//
//
//        }
//
//    }
//
//    @Override
//    public void getDescription() {
//        System.out.println("Команда add *name* активирует форму для добавления в коллекцию нового элемента.");
//    }
//}