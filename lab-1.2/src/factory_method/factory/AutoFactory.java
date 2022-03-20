package factory_method.factory;

import factory_method.models.*;

public class AutoFactory implements TransportFactory{
    @Override
    public Transport createInstance(String brand, int size) {
        return new Auto(brand, size);
    }
}
