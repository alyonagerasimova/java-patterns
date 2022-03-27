package decorator.factory;

import decorator.models.Auto;
import decorator.models.Transport;

public class AutoFactory implements TransportFactory{
    @Override
    public Transport createInstance(String brand, int size) {
        return new Auto(brand, size);
    }
}
