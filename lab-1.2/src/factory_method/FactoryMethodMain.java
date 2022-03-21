package factory_method;

import factory_method.exeption.*;
import factory_method.factory.MotorcycleFactory;
import factory_method.models.*;

public class FactoryMethodMain {
    public static void main(String[] args) {
        try {
            Transport car = StaticMethods.createInstance("AutoBrand", 2);

            StaticMethods.setTransportFactory(new MotorcycleFactory());
            Transport motorcycle = StaticMethods.createInstance("MotoBrand", 2);

            System.out.println("Current class for motorcycle = " + motorcycle.getClass().getName());
            System.out.println("Current class for car = " + car.getClass().getName());


            car.addModel("Mini Paceman", 1100);
            car.addModel("Honda", 123);
            car.addModel("BMW", 13532);
            car.addModel("AUDI", 111.9);
            car.addModel("Toyota", 391.92);
            motorcycle.addModel("Yamaha", 9878);
            motorcycle.addModel("YZ85", 1100);

            car.setModelNameByName("Mini Paceman", "Mini Cooper");
            car.setPriceByNameModel("Mini Cooper", 35900);

            StaticMethods.displayAllModels(car);
            StaticMethods.displayNameModelWithPrices(car);
            StaticMethods.getAvgPrice(car);
            StaticMethods.displayAllPrices(car);

            motorcycle.setModelNameByName("YZ85", "YBR125");
            motorcycle.setPriceByNameModel("YBR125", 1800);

            StaticMethods.displayAllModels(motorcycle);
            StaticMethods.displayNameModelWithPrices(motorcycle);
            StaticMethods.getAvgPrice(motorcycle);
            StaticMethods.displayAllPrices(motorcycle);

            var carClone = (Transport)car.clone();
            car.setPriceByNameModel("Mini Cooper", 37900);

            var motorcycleClone = (Transport)motorcycle.clone();
            motorcycleClone.setPriceByNameModel("YBR125", 999);
            motorcycle.setPriceByNameModel("YBR125", 1000);

            System.out.println("Transport car: ");
            printTransport(car);
            System.out.println("Transport car cloned: ");
            printTransport(carClone);

            System.out.println("Transport motorcycle: ");
            printTransport(motorcycle);
            System.out.println("Transport motorcycle cloned: ");
            printTransport(motorcycleClone);

        } catch (DuplicateModelNameException | ModelPriceOutOfBoundsException | NoSuchModelNameException | CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printTransport(Transport transport) {
        System.out.println("Transport Brand: " + transport.getBrand());
        System.out.println("Model names: ");
        printNames(transport);
        System.out.println("Prices:");
        printPrices(transport);
        System.out.println("Models Size:");
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
