package factory_method;

import factory_method.exeption.*;
import factory_method.factory.MotorcycleFactory;
import factory_method.models.*;

public class FactoryMethodMain {
    public static void main(String[] args) {
        try {
            Transport car = StaticMethods.createInstance("Mini", 2);
            StaticMethods.setTransportFactory(new MotorcycleFactory());
            Transport motorcycle = StaticMethods.createInstance("Yamaha", 4);
            System.out.println("Current class = " + motorcycle.getClass().getName());

            System.out.println("Current class = " + car.getClass().getName());
            car.addModel("Mini Paceman", 1100);
            car.setModelNameByName("Mini Paceman", "Mini Cooper");
            car.setPriceByNameModel("Mini Cooper", 3590000);
            StaticMethods.displayAllModels(car);
            StaticMethods.displayNameModelWithPrices(car);

            motorcycle.addModel("YZ85", 110000);
//            motorcycle.setModelNameByName("YZ85", "YBR125");
//            motorcycle.setPriceByNameModel("YBR125", 180000);
//            StaticMethods.displayAllModels(motorcycle);
//            StaticMethods.displayNameModelWithPrices(motorcycle);

            var carClone = (Transport)car.clone();
            carClone.setPriceByNameModel("Mini Cooper", 999);
            var motorcycleClone = (Transport)motorcycle.clone();
            motorcycleClone.setPriceByNameModel("YZ85", 999);

            System.out.println("Transport car: ");
            printVehicle(car);
            System.out.println("Transport car cloned: ");
            printVehicle(carClone);

            System.out.println("Transport motorcycle: ");
            printVehicle(motorcycle);
            System.out.println("Transport motorcycle cloned: ");
            printVehicle(motorcycleClone);

        } catch (DuplicateModelNameException | ModelPriceOutOfBoundsException | NoSuchModelNameException | CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printVehicle(Transport transport) {
        System.out.println("Transport: " + transport.getBrand());
        System.out.println("Transport Names:");
        printNames(transport);
        System.out.println("Transport Prices:");
        printPrices(transport);
        System.out.println("Transport Models Size:");
        printSizeModels(transport);
    }

    private static void printNames(Transport transport) {
        for (String name : transport.getModelsName()) {
            System.out.println(name);
        }
    }

    private static void printPrices(Transport transport) {
        for (double price : transport.getModelsPrices()) {
            System.out.println(price);
        }
    }

    public static void printSizeModels(Transport transport) {
        System.out.println(transport.getSizeOfModels());
    }
}
