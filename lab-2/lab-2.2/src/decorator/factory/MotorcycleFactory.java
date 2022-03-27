package decorator.factory;

import decorator.models.Motorcycle;
import decorator.models.Transport;

public class MotorcycleFactory implements TransportFactory{
    @Override
    public Transport createInstance(String brand, int size) {
        return new Motorcycle(brand, size);
    }
}
