import factory_method.exeption.DuplicateModelNameException;
import factory_method.models.TransportUtilitiesMethods;
import models.*;
import java.io.FileWriter;
import java.io.*;

public class MainApp {
    public static HelpHandler firsHandler;

    public static void main(String[] args) throws IOException, DuplicateModelNameException {
        initializeChain();
        testHandlers();
    }

    private static void initializeChain() throws IOException {
        var writer = new FileWriter("lab-3/lab-3.1/src/transport.txt");
        firsHandler = new OutputInRow(writer);
        firsHandler.setHandler(new OutputInColumn(writer));
    }

    private static void testHandlers() throws DuplicateModelNameException, IOException {
        var transport = TransportUtilitiesMethods.createInstance("Brand 1", 3);
        if (transport == null) {
            return;
        }
        transport.addModel("Model 1", 23);
        transport.addModel("Model 2", 543);
        transport.addModel("Model 3", 73);
        transport.addModel("Model 4", 981);
        firsHandler.write(transport);
    }
}
