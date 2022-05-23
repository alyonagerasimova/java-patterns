package models;

import factory_method.exeption.NoSuchModelNameException;
import factory_method.models.Transport;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

public class OutputInColumn implements HelpHandler{

    private HelpHandler handler;
    private final Writer writer;

    public OutputInColumn(Writer writer) {
        this.writer = writer;

    }
    @Override
    public void write(Transport transport) throws IOException {
        if (transport.getSizeOfModels() > 3) {
            this.writer.write("\n");
            this.writer.write(writeToColumn(transport));
            this.writer.flush();
        } else if (handler != null) {
            handler.write(transport);
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

    @Override
    public void setHandler(HelpHandler handler) {
        this.handler = handler;
    }
}
