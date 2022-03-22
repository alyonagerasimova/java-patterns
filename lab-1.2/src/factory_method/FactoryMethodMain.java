package factory_method;

import factory_method.exeption.*;
import factory_method.factory.MotorcycleFactory;
import factory_method.models.*;

public class FactoryMethodMain {
    public static void main(String[] args) {
        try {
            Transport car = TransportUtilitiesMethods.createInstance("AutoBrand", 2);

            TransportUtilitiesMethods.setTransportFactory(new MotorcycleFactory());
            Transport motorcycle = TransportUtilitiesMethods.createInstance("MotoBrand", 2);

            System.out.println("Current class for motorcycle = " + motorcycle.getClass().getName());
            System.out.println("Current class for car = " + car.getClass().getName());

            car.setBrand("Auto");
            car.addModel("Mini Paceman", 1100);
            car.addModel("Honda", 123);
            car.addModel("BMW", 13532);
            car.addModel("AUDI", 111.9);
            car.addModel("Toyota", 391.92);
            motorcycle.addModel("Yamaha", 9878);
            motorcycle.addModel("YZ85", 1100);

            car.setModelNameByName("Mini Paceman", "Mini Cooper");
            car.setPriceByNameModel("Mini Cooper", 35900);

            TransportUtilitiesMethods.displayAllModels(car);
            printSizeModels(car);
            TransportUtilitiesMethods.displayNameModelWithPrices(car);
            TransportUtilitiesMethods.displayAllPrices(car);
            System.out.println("Среднее арифметическое цен моделей для " + car.getBrand() + ": " + TransportUtilitiesMethods.getAvgPrice(car) + "; \n");

            car.removeModel("Honda");
            motorcycle.setModelNameByName("YZ85", "YBR125");
            motorcycle.setPriceByNameModel("YBR125", 1800);

            TransportUtilitiesMethods.displayAllModels(motorcycle);
            printSizeModels(motorcycle);
            TransportUtilitiesMethods.displayNameModelWithPrices(motorcycle);
            TransportUtilitiesMethods.displayAllPrices(motorcycle);
            System.out.println("Среднее арифметическое цен моделей для " + motorcycle.getBrand() + ": " + TransportUtilitiesMethods.getAvgPrice(car) + "; \n");

            var carClone = (Transport) car.clone();
            car.setPriceByNameModel("Mini Cooper", 41500);

            var motorcycleClone = (Transport) motorcycle.clone();
            motorcycle.setPriceByNameModel("YBR125", 1000);
            motorcycleClone.setPriceByNameModel("YBR125", 999);

            System.out.println("Transport car: ");
            TransportUtilitiesMethods.displayNameModelWithPrices(car);
            System.out.println("Transport car cloned: ");
            TransportUtilitiesMethods.displayNameModelWithPrices(carClone);

            System.out.println("Transport motorcycle: ");
            TransportUtilitiesMethods.displayNameModelWithPrices(motorcycle);
            System.out.println("Transport motorcycle cloned: ");
            TransportUtilitiesMethods.displayNameModelWithPrices(motorcycleClone);

        } catch (DuplicateModelNameException | ModelPriceOutOfBoundsException | NoSuchModelNameException | CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printSizeModels(Transport transport) {
        System.out.println("Размер массива без пустых моделей: " + transport.getSizeOfNotNullModels() + "\n");
    }
}
