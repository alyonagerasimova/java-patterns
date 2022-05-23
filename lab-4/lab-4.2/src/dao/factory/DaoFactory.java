package dao.factory;

import dao.TransportDao;

public interface DaoFactory {
    TransportDao createInstance(String pathToFile);
}
