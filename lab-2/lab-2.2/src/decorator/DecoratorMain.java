package decorator;

import decorator.exeption.DuplicateModelNameException;
import decorator.exeption.ModelPriceOutOfBoundsException;
import decorator.exeption.NoSuchModelNameException;
import decorator.factory.MotorcycleFactory;
import decorator.models.Transport;
import decorator.models.TransportUtilitiesMethods;

public class DecoratorMain {
    public static void main(String[] args) {
        try {
            Transport car = TransportUtilitiesMethods.createInstance("AutoBrand", 2);
            TransportUtilitiesMethods.setTransportFactory(new MotorcycleFactory());
            Transport motorcycle = TransportUtilitiesMethods.createInstance("MotoBrand", 2);
            car.setBrand("Auto");
            car.addModel("Mini Paceman", 1100);
            car.addModel("Honda", 123);
            car.addModel("BMW", 13532);
            car.addModel("AUDI", 111.9);
            car.addModel("Toyota", 391.92);
            car.removeModel("Honda");
            motorcycle.addModel("Yamaha", 9878);
            motorcycle.addModel("YZ85", 1100);

            System.out.println("Synchronized Vehicle: ");
            var synchronizedTransport = TransportUtilitiesMethods.synchronizedTransport(car);
            TransportUtilitiesMethods.displayNameModelWithPrices(synchronizedTransport);

        } catch (NoSuchModelNameException | DuplicateModelNameException | ModelPriceOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
