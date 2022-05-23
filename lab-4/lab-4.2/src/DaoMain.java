import dao.factory.DaoFactory;
import dao.factory.TransportDaoByteFileFactory;
import dao.factory.TransportDaoTextFileFactory;
import transport.models.Auto;
import transport.models.Motorcycle;
import transport.models.TransportUtilitiesMethods;

public class DaoMain {
    private static final DaoFactory byteFileDaoFactory = new TransportDaoByteFileFactory();
    private static final DaoFactory textFileDaoFactory = new TransportDaoTextFileFactory();

    public static void main(String[] args) throws Exception {
        var path1 = "lab-4/lab-4.2/src/path1.txt";
        var path2 = "lab-4/lab-4.2/src/path2.b";
        testDao(path1, path2);
//        createFiles(path1, path2);
    }

    private static void testDao(String path1, String path2) throws Exception {
        var textDao = textFileDaoFactory.createInstance(path1);
        var byteDao = byteFileDaoFactory.createInstance(path2);
        var firstTransport = textDao.readTransport();
        var secondTransport = byteDao.readTransport();
        TransportUtilitiesMethods.displayNameModelWithPrices(firstTransport);
        TransportUtilitiesMethods.displayNameModelWithPrices(secondTransport);
    }

    private static void createFiles(String path1, String path2) throws Exception {
        var car = new Auto("car", 5);
        car.addModel("Mini Paceman", 1100);
        car.addModel("Honda", 123);
        car.addModel("BMW", 13532);
        car.addModel("AUDI", 111.9);
        car.addModel("Toyota", 391.92);

        var moto = new Motorcycle("Moto", 2);
        moto.addModel("Yamaha", 9878);
        moto.addModel("YZ85", 1100);

        var textDao = textFileDaoFactory.createInstance(path1);
        var byteDao = byteFileDaoFactory.createInstance(path2);

        byteDao.writeTransport(moto);
        textDao.writeTransport(car);
    }
}
