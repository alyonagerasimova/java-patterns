package factory_method.factory;

import factory_method.models.Transport;

public interface TransportFactory {
    Transport createInstance(String brand, int size);
}
