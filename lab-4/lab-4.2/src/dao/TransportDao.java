package dao;

import transport.models.Transport;

public interface TransportDao {
    void writeTransport(Transport transport) throws Exception;

    Transport readTransport() throws Exception;
}
