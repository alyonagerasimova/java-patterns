package models;

import factory_method.exeption.DuplicateModelNameException;
import models.transport.Auto;
import models.transport.Motorcycle;
import models.visitor.PrintVisitor;

public class VisitorMain {
    public static void main(String[] args) throws DuplicateModelNameException {
        var visitor = new PrintVisitor();
        var car = new Auto("AutoBrand", 5);
        var motorcycle = new Motorcycle("MotoBrand", 2);
        car.addModel("Mini Paceman", 1100);
        car.addModel("Honda", 123);
        car.addModel("BMW", 13532);
        car.addModel("AUDI", 111.9);
        car.addModel("Toyota", 391.92);
        motorcycle.addModel("Yamaha", 9878);
        motorcycle.addModel("YZ85", 1100);

        System.out.println("Test for auto: ");
        car.accept(visitor);

        System.out.println("Test for motorcycle: ");
        motorcycle.accept(visitor);
    }
}
