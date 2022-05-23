package transport.factory;

import transport.models.Auto;
import transport.models.Transport;

public class AutoFactory implements TransportFactory {
    @Override
    public Transport createInstance(String brand, int size) {
        return new Auto(brand, size);
    }
}
