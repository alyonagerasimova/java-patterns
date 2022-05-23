import models.Auto;

public class MainMemento {
    public static void main(String[] args) throws Exception {
        var car = new Auto("Auto", 5);
        car.addModel("Mini Paceman", 1100);
        car.addModel("Honda", 123);
        car.addModel("BMW", 13532);
        car.addModel("AUDI", 111.9);
        car.addModel("Toyota", 391.92);
        System.out.println("Auto before create memento");
        System.out.println(car);

        Auto.Memento memento = car.createMemento();
        car.addModel("Lada", 343);
        car.setPriceByNameModel("AUDI", 9999);
        System.out.println("Auto after create memento");
        System.out.println(car);

        car.setMemento(memento);
        System.out.println("Auto after apply memento");
        System.out.println(car);
    }
}
