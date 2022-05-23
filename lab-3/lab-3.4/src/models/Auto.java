package models;

import factory_method.exeption.DuplicateModelNameException;
import factory_method.exeption.ModelPriceOutOfBoundsException;
import factory_method.exeption.NoSuchModelNameException;
import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class Auto implements Serializable {

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
        String[] modelsName = new String[getSizeOfNotNullModels()];
        int i = 0;
        for (Model model : this.models) {
                if (model != null) {
                    modelsName[i] = model.name;
                    i++;
                }
        }
        return modelsName;
    }

    public void setModelNameByName(String name, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        checkDuplicatedName(newName);
        for (Model model : this.models) {
            if (model != null && model.name.equals(name)) {
                model.name = newName;
                return;
            }
        }
        throw new NoSuchModelNameException("Model with name " + name + " does not exist.");
    }

    private Model getModelByName(String name) throws NoSuchModelNameException {
        for (Model model : models) {
            if (model != null && Objects.equals(model.name, name)) {
                return model;
            }
        }
        throw new NoSuchModelNameException("Model with name " + name + " does not exist.");
    }

    public double getPriceByNameModel(String name) throws NoSuchModelNameException {
        return getModelByName(name).price;
    }

    public void setPriceByNameModel(String name, double newPrice) throws NoSuchModelNameException {
        checkBoundsOfPrice(newPrice);
        for (Model model : this.models) {
            if (model != null && model.name.equals(name)) {
                model.price = newPrice;
                return;
            }
        }
        throw new NoSuchModelNameException("Model with name " + name + " does not exist.");
    }

    public double[] getModelsPrices() {
        double[] prices = new double[getSizeOfNotNullModels()];
        int i = 0;
        for (Model model : this.models) {
                if (model != null) {
                    prices[i] = model.price;
                    i++;
                }
        }
        return prices;
    }

    public void addModel(String name, double price) throws DuplicateModelNameException {
        checkBoundsOfPrice(price);
        checkDuplicatedName(name);

        Model newModel = new Model(name, price);
        int indexOfNull = getIndexOfNullElement();
        if (indexOfNull == this.models.length) {
            this.models = Arrays.copyOf(this.models, this.models.length + 1);
        }
        this.models[indexOfNull] = newModel;
    }

    public void removeModel(String name) throws NoSuchModelNameException {
        for (int i = 0; i < this.models.length; i++) {
            if(this.models[i] != null && this.models[i].name.equals(name)) {
                if(i != this.models.length - 1) {
                    System.arraycopy(this.models, ++i, this.models, --i, this.models.length - 1 - i);
                }
                this.models = Arrays.copyOf(this.models, this.models.length - 1);
                return;
            }
        }
        throw new NoSuchModelNameException("Model with name '" + name + "' not found!");
    }

    public int getSizeOfModels() {
        return this.models.length;
    }

    public void checkDuplicatedName(String name) throws DuplicateModelNameException {
        for (Model model : models) {
            if (model != null && model.name.equals(name)) {
                throw new DuplicateModelNameException("Model with name " + name + " already exists.");
            }
        }
    }

    public void checkBoundsOfPrice(double price) {
        if (price < 0) {
            throw new ModelPriceOutOfBoundsException("The price cannot be negative");
        }
    }

    private int getIndexOfNullElement() {
        for (int i = 0; i < this.models.length; i++) {
            if (this.models[i] == null) {
                return i;
            }
        }
        return this.models.length;
    }

    public int getSizeOfNotNullModels() {
        int count = this.models.length;
        for (Model model : this.models) {
            if (model == null) {
                count--;
            }
        }
        return count;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Auto clone = (Auto)super.clone();
        var clonedModels =  new Model[models.length];
        int i = 0;
        for (Model model : models) {
            if (model != null) {
                clonedModels[i] = model.clone();
                i++;
            }
        }
        clone.models = clonedModels;
        return clone;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Марка: ").append(this.brand).append("\n");
        for (Model model : models) {
            builder.append(model).append("\n");
        }
        return builder.toString();
    }

    public Memento createMemento() {
        var memento = new Memento();
        memento.setAuto(this);
        return memento;
    }

    public void setMemento(Memento memento) {
        var auto = memento.getAuto();
        if (auto != null) {
            this.brand = auto.brand;
            this.models = auto.models;
        }else {
            throw new NullPointerException("Memento is Empty!");
        }
    }

    private static class Model implements Serializable{
        private String name;
        private double price;

        public Model() {
        }

        public Model(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setNameModel(String name) {
            this.name = name;
        }

        @Override
        public Model clone() throws CloneNotSupportedException {
            Model clone = (Model)super.clone();
            clone.name = this.name;
            clone.price = this.price;
            return clone;
        }

        @Override
        public String toString() {
            return "Модель: " + this.name + "; Цена: "+ this.price;
        }
    }

    public static class Memento {
        private byte[] serializedAuto = null;

        private void setAuto(Auto auto) {
            var outputStream = new ByteArrayOutputStream();
            try (var objectOutputStream = new ObjectOutputStream(outputStream)) {
                objectOutputStream.writeObject(auto);
                objectOutputStream.flush();
                serializedAuto = outputStream.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private Auto getAuto() {
            try (var objectInputStream = new ObjectInputStream(new ByteArrayInputStream(serializedAuto))) {
                return (Auto) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
