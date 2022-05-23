import factory_method.exeption.DuplicateModelNameException;

import java.io.FileWriter;

public class CommandMain {
    public static void main(String[] args) throws DuplicateModelNameException {
        var auto = new Auto("Brand 1", 3);
        auto.addModel("Model 1", 23);
        auto.addModel("Model 2", 543);
        auto.addModel("Model 3", 73);

        var rowCommand = new RowCommand(auto);
        var columnCommand = new ColumnCommand(auto);

//        System.out.println("Test rowCommand");
//        auto.setPrintCommand(rowCommand);
//        test(auto);

        System.out.println("Test columnCommand");
        auto.setPrintCommand(columnCommand);
        test(auto);
    }

    private static void test(Auto auto) {
        try (var writer = new FileWriter("lab-3/lab-3.2/command.txt", true)) {
            auto.print(writer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
