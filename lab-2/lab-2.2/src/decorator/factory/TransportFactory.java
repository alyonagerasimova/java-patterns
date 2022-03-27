package decorator.factory;

import decorator.models.Transport;

public interface TransportFactory {
    Transport createInstance(String brand, int size);
}
