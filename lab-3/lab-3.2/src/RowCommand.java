import factory_method.exeption.NoSuchModelNameException;
import factory_method.models.Transport;

import java.util.Arrays;

public class RowCommand implements Command{

    private final Auto auto;

    public RowCommand(Auto auto) {
        this.auto = auto;
    }

    @Override
    public void printToFile() {
        var writer = auto.getWriter();
        try {
            writer.write("\n");
            writer.write(writeToString(auto));
            writer.flush();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private String writeToString(Transport transport) {
        StringBuilder builder = new StringBuilder();
        builder.append("Transport brand: ").append(transport.getBrand()).append("; ");
        var modelsNames = transport.getModelsName();
        Arrays.stream(modelsNames).forEachOrdered(name -> {
            builder.append("modelName: ").append(name).append(", ");
            try {
                var price = transport.getPriceByNameModel(name);
                builder.append(" price: ").append(price).append("; ");
            } catch (NoSuchModelNameException e) {
                e.printStackTrace();
            }
        });
        builder.append("\n");
        return builder.toString();
    }
}
