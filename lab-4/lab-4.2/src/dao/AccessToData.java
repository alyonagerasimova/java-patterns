package dao;

import transport.models.Transport;

public abstract class AccessToData implements TransportDao{

    protected String pathToFile;

    public AccessToData(String path) {
        pathToFile = path;
    }

    public abstract void writeTransport(Transport transport) throws Exception;

    public abstract Transport readTransport() throws Exception;
}
