package factory_method.models;

import factory_method.exeption.DuplicateModelNameException;
import factory_method.exeption.ModelPriceOutOfBoundsException;
import factory_method.exeption.NoSuchModelNameException;

public class Motorcycle implements Transport {

    private String motoBrand;
    private int size;
    private Model head = new Model();
    {
        head.prev = head;
        head.next = head;
    }

    public Motorcycle(String motoBrand, int size){
        this.motoBrand = motoBrand;
        this.size = size;
    }

    public String getBrand(){
        return motoBrand;
    }

    public void setBrand(String newMotoBrand){
        this.motoBrand = newMotoBrand;
    }

    public String[] getModelsName() {
        String[] modelsName = new String[getSizeOfModels()];
        Model currentModel = head;
        int count = 0;
        while(currentModel.next != head){
            modelsName[count] = currentModel.next.nameModel;
            currentModel = currentModel.next;
            count++;
        }

        return modelsName;
    }

    public void setModelsName(String name, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        if (isModelNameExist(newName)) {
            throw new DuplicateModelNameException("Model with name " + name + " already exists.");
        }
        Model currentModel = head;
        while(currentModel.next != head){
            if(currentModel.next.nameModel.equals(name)){
                currentModel.next.nameModel = newName;
                return;
            }
            currentModel = currentModel.next;
        }
        throw new NoSuchModelNameException("Model with name " + name + " does not exist.");
    }

    public double getPriceByNameModel(String name) throws NoSuchModelNameException {
        Model currentModel = head;
        while(currentModel.next != head){
            if(currentModel.next.nameModel.equals(name)){
                return currentModel.next.price;
            }
            currentModel = currentModel.next;
        }
        throw new NoSuchModelNameException("Model with name " + name + " does not exist.");
    }

    public void setPriceByNameModel(String name, double newPrice) throws NoSuchModelNameException, ModelPriceOutOfBoundsException {
        if (newPrice < 0) {
            throw new ModelPriceOutOfBoundsException("The price cannot be negative");
        }
        Model currentModel = head;
        while(currentModel.next != head){
            if(currentModel.next.nameModel.equals(name)){
                currentModel.next.setPrice(newPrice);
                return;
            }
            currentModel = currentModel.next;
        }
        throw new NoSuchModelNameException("Model with name " + name + " does not exist.");
    }

    public double[] getModelsPrices() {
        double[] price = new double[getSizeOfModels()];
        Model currentModel = head;
        int count = 0;
        while(currentModel.next != head){
            price[count] = currentModel.next.price;
            currentModel = currentModel.next;
            count++;
        }
        return price;
    }

    public void addModel(String name, double price) throws ModelPriceOutOfBoundsException, DuplicateModelNameException {
        if (price < 0) {
            throw new ModelPriceOutOfBoundsException("The price cannot be negative");
        }
        if (isModelNameExist(name)) {
            throw new DuplicateModelNameException("Model with name " + name + " already exists.");
        }
        Model newModel = new Model(name, price);
        Model lastModel = head.prev;

        lastModel.next = newModel;
        newModel.next = head;
        head.prev = newModel;
        newModel.prev = lastModel;
        size++;
    }

    public void removeModel(String name) throws NoSuchModelNameException {
        Model currentModel = head;
        while (currentModel.next != head) {
            if (currentModel.next.nameModel.equals(name)) {
                currentModel.next.prev = currentModel.prev;
                currentModel.prev.next = currentModel.next;
                size--;
                return;
            }
            currentModel = currentModel.next;
        }
        throw new NoSuchModelNameException("Model with name " + name + " does not exist.");
    }

    private boolean isEmpty(){
        return size == 0;
    }

    public int getSizeOfModels(){
        return size;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    private boolean isModelNameExist(String name) {
        Model currentModel = head;
        while (currentModel.next != head) {
            if (currentModel.next.nameModel.equals(name)) {
                return true;
            }
            currentModel = currentModel.next;
        }
        return false;
    }

    private class Model implements Cloneable{
        String nameModel = null;
        double price = Double.NaN;
        Model prev = null;
        Model next = null;

        public Model(String name, double price) {
            this.nameModel = name;
            this.price = price;
        }

        public Model() {
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

}
