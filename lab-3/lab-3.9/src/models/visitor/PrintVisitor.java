package models.visitor;

import factory_method.exeption.NoSuchModelNameException;
import models.transport.Auto;
import models.transport.Motorcycle;
import models.transport.Transport;

public class PrintVisitor implements Visitor {

    @Override
    public void visit(Motorcycle motorcycle) {
        System.out.println(this.writeToColumn(motorcycle));
    }

    @Override
    public void visit(Auto auto) {
        System.out.println(this.writeToString(auto));
    }

    private String writeToColumn(Transport transport) {
        StringBuilder builder = new StringBuilder();
        builder.append("Transport brand: ").append(transport.getBrand()).append("\n");
        var modelsNames = transport.getModelsName();
        builder.append("Transport models: \n");
        for (String name : modelsNames) {
            builder.append(" name: ").append(name);
            try {
                var price = transport.getPriceByNameModel(name);
                builder.append(", price: ").append(price);
            } catch (NoSuchModelNameException e) {
                e.printStackTrace();
            }
            builder.append(" \n");
        };
        builder.append("\n");
        return builder.toString();
    }

    private String writeToString(Transport transport) {
        StringBuilder builder = new StringBuilder();
        builder.append("Transport brand: ").append(transport.getBrand()).append("; ");
        var modelsNames = transport.getModelsName();
        for (String name : modelsNames) {
            builder.append("modelName: ").append(name).append(", ");
            try {
                var price = transport.getPriceByNameModel(name);
                builder.append(" price: ").append(price).append("; ");
            } catch (NoSuchModelNameException e) {
                e.printStackTrace();
            }
        };
        builder.append("\n");
        return builder.toString();
    }
}
