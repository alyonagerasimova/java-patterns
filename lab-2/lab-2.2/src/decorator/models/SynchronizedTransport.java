package decorator.models;

import decorator.exeption.DuplicateModelNameException;
import decorator.exeption.NoSuchModelNameException;

public class SynchronizedTransport implements Transport {

    private final Transport transport;

    public SynchronizedTransport(Transport transport) {
        this.transport = transport;
    }

    @Override
    public String getBrand() {
        return this.transport.getBrand();
    }

    @Override
    public synchronized void setBrand(String carModel) {
        this.transport.setBrand(carModel);
    }

    @Override
    public synchronized void setModelNameByName(String name, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        this.transport.setModelNameByName(name, newName);
    }

    @Override
    public String[] getModelsName() {
        return this.transport.getModelsName();
    }

    @Override
    public double getPriceByNameModel(String name) throws NoSuchModelNameException {
        return this.transport.getPriceByNameModel(name);
    }

    @Override
    public synchronized void setPriceByNameModel(String name, double price) throws NoSuchModelNameException {
        this.transport.setPriceByNameModel(name, price);
    }

    @Override
    public double[] getModelsPrices() {
        return this.transport.getModelsPrices();
    }

    @Override
    public synchronized void addModel(String name, double price) throws DuplicateModelNameException {
        this.transport.addModel(name, price);
    }

    @Override
    public synchronized void removeModel(String name) throws NoSuchModelNameException {
        this.transport.removeModel(name);
    }

    @Override
    public int getSizeOfModels() {
        return this.transport.getSizeOfModels();
    }

    @Override
    public int getSizeOfNotNullModels() {
        return this.transport.getSizeOfNotNullModels();
    }

    @Override
    public synchronized Object clone() throws CloneNotSupportedException {
        return new SynchronizedTransport((Transport) this.transport.clone());
    }
}
