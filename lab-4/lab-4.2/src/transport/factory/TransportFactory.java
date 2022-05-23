package transport.factory;

import transport.models.Transport;

public interface TransportFactory {
    Transport createInstance(String brand, int size);
}
