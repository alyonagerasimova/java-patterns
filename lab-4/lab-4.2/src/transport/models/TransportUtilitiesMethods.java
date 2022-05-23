package transport.models;

import transport.factory.AutoFactory;
import transport.factory.TransportFactory;

public class TransportUtilitiesMethods {

    private static TransportFactory factory = new AutoFactory();

    public static Transport createInstance(String brand, int size) {
        return factory.createInstance(brand, size);
    }

    public static void setTransportFactory(TransportFactory transportFactory) {
        TransportUtilitiesMethods.factory = transportFactory;
    }

    public static double getAvgPrice(Transport transport) {
        double sum = 0;
        int size = transport.getSizeOfNotNullModels();
        double[] prices = transport.getModelsPrices();
        for (int i = 0; i < size; i++) {
            sum += prices[i];
        }
        return sum / size;
    }

    public static void displayAllModels(Transport transport) {
        StringBuilder name = new StringBuilder();
        int size = transport.getSizeOfNotNullModels();
        String[] names = transport.getModelsName();
        for (int i = 0; i < size; i++) {
            name.append(names[i]).append(", ");
        }
        System.out.println("Все модели марки " + transport.getBrand() + ": " + name + "; \n");
    }

    public static void displayAllPrices(Transport transport) {
        StringBuilder pricesBuilder = new StringBuilder();
        int size = transport.getSizeOfNotNullModels();
        double[] prices = transport.getModelsPrices();
        for (int i = 0; i < size; i++) {
            pricesBuilder.append(prices[i]).append(", ");
        }
        System.out.println("Стоимость моделей марки " + transport.getBrand() + ": " + pricesBuilder + "; \n");
    }

    public static void displayNameModelWithPrices(Transport transport) {
        StringBuilder namesWithPrices = new StringBuilder();
        int size = transport.getSizeOfNotNullModels();
        String[] names = transport.getModelsName();
        double[] prices = transport.getModelsPrices();
        for (int i = 0; i < size; i++) {
            namesWithPrices.append(i + 1).append(". Name model: ").append(names[i]).append(", ").append("price: ")
                    .append(prices[i]).append("; \n");
        }
        System.out.println(namesWithPrices);
    }
}
