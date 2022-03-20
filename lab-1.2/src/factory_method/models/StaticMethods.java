package factory_method.models;

import factory_method.factory.AutoFactory;
import factory_method.factory.TransportFactory;

public class StaticMethods {

    private static TransportFactory factory = new AutoFactory();

    public static Transport createInstance(String brand, int size) {
        return factory != null ? factory.createInstance(brand, size) : null;
    }

    public static void setTransportFactory(TransportFactory transportFactory) {
        StaticMethods.factory = transportFactory;
    }

    public static double getAvgPrice(Transport transport) {
        double sum = 0;
        int size = transport.getSizeOfNotNullModels();
        for (int i = 0; i < size; i++) {
            double modelsPrice = transport.getModelsPrices()[i];
            sum += modelsPrice;
        }
        return sum / size;
    }

    public static void displayAllModels(Transport transport) {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < transport.getSizeOfNotNullModels(); i++) {
            name.append(transport.getModelsName()[i]);
        }
        System.out.println("Все модели марки " + transport.getBrand() + ": " + name);
    }

    public static void displayAllPrices(Transport transport) {
        StringBuilder prices = new StringBuilder();
        for (int i = 0; i < transport.getSizeOfNotNullModels(); i++) {
            prices.append(transport.getModelsPrices()[i]);
        }
        System.out.println("Стоимость моделей марки" + transport.getBrand() + ": " + prices);
    }

    public static void displayNameModelWithPrices(Transport transport) {
        StringBuilder namesWithPrices = new StringBuilder();
        String[] names = transport.getModelsName();
        double[] prices = transport.getModelsPrices();
        for (int i = 0; i < transport.getSizeOfNotNullModels(); i++) {
            namesWithPrices.append(i + 1).append(". Name model: ").append(names[i]).append(", ").append("price: ").append(prices[i]);
        }
        System.out.println(namesWithPrices + ", ");
    }
}
