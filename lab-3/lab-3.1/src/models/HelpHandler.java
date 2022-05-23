package models;

import factory_method.models.Transport;

import java.io.IOException;

public interface HelpHandler {
    void write(Transport transport) throws IOException;

    void setHandler(HelpHandler handler);
}
