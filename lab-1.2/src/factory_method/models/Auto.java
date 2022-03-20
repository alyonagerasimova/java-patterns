package factory_method.models;

import factory_method.exeption.DuplicateModelNameException;
import factory_method.exeption.ModelPriceOutOfBoundsException;
import factory_method.exeption.NoSuchModelNameException;

import java.util.*;

public class Auto implements Transport {

    private String brand;
    private Model[] models;

    public Auto(String brand, int sizeOfModels) {
        this.brand = brand;
        this.models = new Model[sizeOfModels];
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String newBrand) {
        this.brand = newBrand;
    }

    public String[] getModelsName() {
        String[] modelsName = new String[models.length];
        for (int i = 0; i < models.length; i++) {
            modelsName[i] = models[i].name;
        }
        return modelsName;
    }

    public void setModelsName(String oldName, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        int i = 0;
        int j = 0;
        while (i < models.length) {
            if (models[i].name.equals(oldName)) {
                j = i;
            } else if (models[i].name.equals(newName)) {
                throw new DuplicateModelNameException("Model with name " + newName + " already exists.");
            }
            i++;
        }
        if (j < models.length) {
            models[j].name = newName;
        } else {
            throw new NoSuchModelNameException("Model with name " + oldName + " does not exist.");
        }
    }

    private Model getModelByName(String name) throws NoSuchModelNameException {
        for (Model model : models) {
            if (Objects.equals(model.name, name)) {
                return model;
            }
        }
        throw new NoSuchModelNameException("Model with name " + name + " does not exist.");
    }

    public double getPriceByNameModel(String name) throws NoSuchModelNameException {
        return getModelByName(name).price;
    }

    public void setPriceByNameModel(String name, double newPrice) throws NoSuchModelNameException {
        if (newPrice < 0) {
            throw new ModelPriceOutOfBoundsException("The price cannot be negative");
        }
        getModelByName(name).price = newPrice;
    }

    public double[] getModelsPrices() {
        double[] prices = new double[models.length];
        for (int i = 0; i < models.length; i++) {
            prices[i] = models[i].price;
        }
        return prices;
    }

    public void addModel(String name, double price) throws DuplicateModelNameException, ModelPriceOutOfBoundsException {
        if (price < 0) {
            throw new ModelPriceOutOfBoundsException("The price cannot be negative");
        }
        int i = 0;
        int j = -1;
        while (i < models.length) {
            if (models[i].name.equals(name)) {
                j = i;
                break;
            }
            i++;
        }
        if (j >= 0) {
            throw new DuplicateModelNameException("Model with name " + name + " already exists.");
        }

        models = Arrays.copyOf(models, models.length + 1);
        models[models.length - 1] = new Model(name, price);
    }

    public void removeModel(String name) throws NoSuchModelNameException {
        int deleteIndex = 0;
        while ((deleteIndex < models.length)
                && ((models[deleteIndex].name)).equals(name)) {
            deleteIndex++;
        }
        if (deleteIndex == models.length) {
            throw new NoSuchModelNameException("Model with name " + name + " does not exist.");
        }
        Model[] newModels = new Model[models.length - 1];
        System.arraycopy(models, 0, newModels, 0, deleteIndex);
        System.arraycopy(models, deleteIndex + 1, newModels, deleteIndex, models.length - deleteIndex);
        models = newModels;
    }

    public int getSizeOfModels() {
        return this.models.length;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    private class Model implements Cloneable {
        private String name;
        private double price;

        public Model() {
        }

        public Model(String nameModel, double price) {
            this.name = nameModel;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setNameModel(String nameModel) {
            this.name = nameModel;
        }

        @Override
        public Model clone() {
            try {
                Model clone = (Model) super.clone();
                // TODO: copy mutable state here, so the clone can't change the internals of the original
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }
}
