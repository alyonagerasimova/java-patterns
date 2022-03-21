package factory_method.models;

import factory_method.factory.AutoFactory;
import factory_method.factory.TransportFactory;

public class StaticMethods {

    private static TransportFactory factory = new AutoFactory();

    public static Transport createInstance(String brand, int size) {
        return factory.createInstance(brand, size);
    }

    public static void setTransportFactory(TransportFactory transportFactory) {
        StaticMethods.factory = transportFactory;
    }

    public static void getAvgPrice(Transport transport) {
        double sum = 0;
        int size = transport.getSizeOfNotNullModels();
        double[] prices = transport.getModelsPrices();
        for (int i = 0; i < size; i++) {
            double modelsPrice = prices[i];
            sum += modelsPrice;
        }
        System.out.println("Среднее арифметическое цен моделей для " + transport.getBrand() + ": " + sum / size + "; \n");
    }

    public static void displayAllModels(Transport transport) {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < transport.getSizeOfNotNullModels(); i++) {
            name.append(transport.getModelsName()[i]).append(", ");
        }
        System.out.println("Все модели марки " + transport.getBrand() + ": " + name + "; \n");
    }

    public static void displayAllPrices(Transport transport) {
        StringBuilder pricesBuilder = new StringBuilder();
        double[] prices = transport.getModelsPrices();
        for (int i = 0; i < transport.getSizeOfNotNullModels(); i++) {
            pricesBuilder.append(prices[i]).append(", ");
        }
        System.out.println("Стоимость моделей марки " + transport.getBrand() + ": " + pricesBuilder + "; \n");
    }

    public static void displayNameModelWithPrices(Transport transport) {
        StringBuilder namesWithPrices = new StringBuilder();
        String[] names = transport.getModelsName();
        double[] prices = transport.getModelsPrices();
        for (int i = 0; i < transport.getSizeOfNotNullModels(); i++) {
            namesWithPrices.append(i + 1).append(". Name model: ").append(names[i]).append(", ").append("price: ").append(prices[i]).append("; \n");
        }
        System.out.println(namesWithPrices);
    }
}
