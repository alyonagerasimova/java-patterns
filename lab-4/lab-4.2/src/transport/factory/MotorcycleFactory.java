package transport.factory;

import transport.models.Motorcycle;
import transport.models.Transport;

public class MotorcycleFactory implements TransportFactory {
    @Override
    public Transport createInstance(String brand, int size) {
        return new Motorcycle(brand, size);
    }
}
