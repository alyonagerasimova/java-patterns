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
        int size = transport.getSizeOfModels();
        for (int i = 0; i < size; i++) {
            double modelsPrice = transport.getModelsPrices()[i];
            sum += modelsPrice;
        }
        return sum / size;
    }

    public static void displayAllModels(Transport transport) {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < transport.getSizeOfModels(); i++) {
            name.append(transport.getModelsName()[i]);
        }
        System.out.println("Все модели для" + transport.getBrand() + name + ", ");
    }

    public static void displayAllPrices(Transport transport) {
        StringBuilder prices = new StringBuilder();
        for (int i = 0; i < transport.getSizeOfModels(); i++) {
            prices.append(transport.getModelsPrices()[i]);
        }
        System.out.println("Все модели для" + transport.getBrand() + "стоимостью" + prices + ", ");
    }

    public static void displayNameModelWithPrices(Transport transport) {
        StringBuilder namesWithPrices = new StringBuilder();
        String[] names = transport.getModelsName();
        double[] prices = transport.getModelsPrices();
        for (int i = 0; i < transport.getSizeOfModels(); i++) {
            namesWithPrices.append(names[i]).append(" - ").append(prices[i]);
        }
        System.out.println(namesWithPrices + ", ");
    }
}
