package dao.factory;

import dao.TransportDao;
import dao.TransportDaoByteFile;

public class TransportDaoByteFileFactory implements DaoFactory {

    @Override
    public TransportDao createInstance(String pathToFile) {
        return new TransportDaoByteFile(pathToFile);
    }
}