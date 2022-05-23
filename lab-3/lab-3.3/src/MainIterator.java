import factory_method.exeption.DuplicateModelNameException;
import models.Auto;

public class MainIterator {
    public static void main(String[] args) throws DuplicateModelNameException {
        var car = new Auto("Auto", 5);
        car.addModel("Mini Paceman", 1100);
        car.addModel("Honda", 123);
        car.addModel("BMW", 13532);
        car.addModel("AUDI", 111.9);
        car.addModel("Toyota", 391.92);

        var carIterator = car.iterator();
        while (carIterator.hasNext()) {
            System.out.println(carIterator.next());
        }
    }
}
