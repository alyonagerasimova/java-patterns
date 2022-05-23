package dao;

import transport.models.Transport;
import java.io.*;

public class TransportDaoByteFile extends AccessToData {

    public TransportDaoByteFile(String pathToFile) {
        super(pathToFile);
    }

    @Override
    public void writeTransport(Transport transport) {
        try (var stream = new ObjectOutputStream(new FileOutputStream(pathToFile))) {
            stream.writeObject(transport);
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Transport readTransport() {
        try (var stream = new ObjectInputStream(new FileInputStream(pathToFile))) {
            return (Transport) stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
