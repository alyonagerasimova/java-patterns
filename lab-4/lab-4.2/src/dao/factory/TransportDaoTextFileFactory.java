package dao.factory;

import dao.TransportDao;
import dao.TransportDaoTextFile;

public class TransportDaoTextFileFactory implements DaoFactory {

    @Override
    public TransportDao createInstance(String pathToFile) {
        return new TransportDaoTextFile(pathToFile);
    }
}