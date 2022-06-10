import exeption.DuplicateModelNameException;
import models.OutputInColumn;
import models.OutputInRow;
import models.WriteHandler;
import transport.Auto;
import transport.Motorcycle;
import transport.Transport;

import java.io.FileWriter;
import java.io.IOException;

public class ChainOfResponsibilityMain {

    public static void main(String[] args) throws IOException, DuplicateModelNameException {
        WriteHandler firsHandler;
        var writer = new FileWriter("src/transport.txt");
        firsHandler = new OutputInRow(writer);
        firsHandler.setNext(new OutputInColumn(writer));
        Transport car = new Auto("car", 4);
        Transport motorcycle = new Motorcycle("motorcycle", 2);

        car.addModel("Model 1", 23);
        car.addModel("Model 2", 543);
        car.addModel("Model 3", 73);
        car.addModel("Model 4", 981);

        motorcycle.addModel("Model 1", 23);
        motorcycle.addModel("Model 2", 543);
        firsHandler.write(car);
        firsHandler.write(motorcycle);
    }
}
