package models;

import factory_method.exeption.NoSuchModelNameException;
import factory_method.models.Transport;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

public class OutputInRow implements HelpHandler {

    private HelpHandler handler;
    private final Writer writer;

    public OutputInRow(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void write(Transport transport) throws IOException {
        if (transport.getSizeOfModels() <= 3) {
            this.writer.write(writeToString(transport));
            this.writer.flush();
        } else if (handler != null) {
            this.handler.write(transport);
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

    @Override
    public void setHandler(HelpHandler handler) {
        this.handler = handler;
    }
}
