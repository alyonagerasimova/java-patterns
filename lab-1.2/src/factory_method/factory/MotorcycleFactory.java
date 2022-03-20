package factory_method.factory;

import factory_method.models.*;

public class MotorcycleFactory implements TransportFactory{
    @Override
    public Transport createInstance(String brand, int size) {
        return new Motorcycle(brand, size);
    }
}
