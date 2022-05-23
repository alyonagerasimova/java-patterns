package transport.models;

import transport.exeption.DuplicateModelNameException;
import transport.exeption.NoSuchModelNameException;

import java.io.Serializable;

public interface Transport extends Serializable {

    String getBrand();

    void setBrand(String carModel);

    void setModelNameByName(String name, String newName) throws NoSuchModelNameException, DuplicateModelNameException;

    String[] getModelsName();

    double getPriceByNameModel(String name) throws NoSuchModelNameException;

    void setPriceByNameModel(String name, double price) throws NoSuchModelNameException;

    double[] getModelsPrices();

    void addModel(String name, double price) throws DuplicateModelNameException;

    void removeModel(String name) throws NoSuchModelNameException;

    int getSizeOfModels();

    int getSizeOfNotNullModels();

    Object clone() throws CloneNotSupportedException;
}
