package models;
import transport.Transport;

import java.io.IOException;

public interface WriteHandler {
    void write(Transport transport) throws IOException;

    void setNext(WriteHandler handler);
}
