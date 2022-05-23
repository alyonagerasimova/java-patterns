import factory_method.exeption.NoSuchModelNameException;
import factory_method.models.Transport;

import java.util.Arrays;

public class ColumnCommand implements Command{

    private final Auto auto;
    public ColumnCommand(Auto auto) {
        this.auto = auto;
    }

    @Override
    public void printToFile() {
        var writer = auto.getWriter();
        try {
            writer.write("\n");
            writer.write(writeToColumn(auto));
            writer.flush();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private String writeToColumn(Transport transport) {
        StringBuilder builder = new StringBuilder();
        builder.append("Transport brand: ").append(transport.getBrand()).append("\n");
        var modelsNames = transport.getModelsName();
        builder.append("Transport models: \n");
        Arrays.stream(modelsNames).forEachOrdered(name -> {
            builder.append(" name: ").append(name);
            try {
                var price = transport.getPriceByNameModel(name);
                builder.append(", price: ").append(price);
            } catch (NoSuchModelNameException e) {
                e.printStackTrace();
            }
            builder.append(" \n");
        });
        builder.append("\n");
        return builder.toString();
    }
}
