package transport;

import exeption.DuplicateModelNameException;
import exeption.ModelPriceOutOfBoundsException;
import exeption.NoSuchModelNameException;

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
        String[] modelsName = new String[getSizeOfNotNullModels()];
        Model currentModel = head;
        int count = 0;
        while(currentModel.next != head){
            modelsName[count] = currentModel.next.name;
            currentModel = currentModel.next;
            count++;
        }

        return modelsName;
    }

    public void setModelNameByName(String name, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        checkDuplicatedName(newName);
        Model currentModel = head;
        while(currentModel.next != head){
            if(currentModel.next.name.equals(name)){
                currentModel.next.name = newName;
                return;
            }
            currentModel = currentModel.next;
        }
        throw new NoSuchModelNameException("Model with name " + name + " does not exist.");
    }

    public double getPriceByNameModel(String name) throws NoSuchModelNameException {
        Model currentModel = head;
        while(currentModel.next != head){
            if(currentModel.next.name.equals(name)){
                return currentModel.next.price;
            }
            currentModel = currentModel.next;
        }
        throw new NoSuchModelNameException("Model with name " + name + " does not exist.");
    }

    public void setPriceByNameModel(String name, double newPrice) throws NoSuchModelNameException, ModelPriceOutOfBoundsException {
        checkBoundsOfPrice(newPrice);

        Model currentModel = head;
        while(currentModel.next != head){
            if(currentModel.next.name.equals(name)){
                currentModel.next.setPrice(newPrice);
                return;
            }
            currentModel = currentModel.next;
        }
        throw new NoSuchModelNameException("Model with name " + name + " does not exist.");
    }

    public double[] getModelsPrices() {
        double[] price = new double[getSizeOfNotNullModels()];
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
        checkBoundsOfPrice(price);
        checkDuplicatedName(name);
        Model newModel = new Model(name, price);
        Model lastModel = head.prev;

        lastModel.next = newModel;
        newModel.next = head;
        head.prev = newModel;
        newModel.prev = lastModel;
        if(getSizeOfNotNullModels() == size) {
            size++;
        }
    }

    public int getSizeOfNotNullModels() {
        int count = 0;
        Model currentModel = head.next;
        while (currentModel != head) {
            if(currentModel.name != null) {
                count++;
            }
            currentModel = currentModel.next;
        }
        return count;
    }

    public void removeModel(String name) throws NoSuchModelNameException {
        Model currentModel = head;
        while (currentModel.next != head) {
            if (currentModel.next.name.equals(name)) {
                currentModel.next.prev = currentModel.prev;
                currentModel.prev.next = currentModel.next;
                size--;
                return;
            }
            currentModel = currentModel.next;
        }
        throw new NoSuchModelNameException("Model with name " + name + " does not exist.");
    }

    public int getSizeOfModels(){
        return this.size;
    }

    public void checkBoundsOfPrice(double price) {
        if (price < 0) {
            throw new ModelPriceOutOfBoundsException("The price cannot be negative");
        }
    }

    private void checkDuplicatedName(String name) throws DuplicateModelNameException {
        Model currentModel = head;
        while (currentModel.next != head) {
            if (currentModel.next.name.equals(name)) {
                throw new DuplicateModelNameException("Model with name " + name + " already exists.");
            }
            currentModel = currentModel.next;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        var clone = (Motorcycle)super.clone();
        clone.head = head.clone();
        clone.head.prev = clone.head;
        clone.head.next = clone.head;

        Model currentModel = head;
        while (currentModel.next != head) {
            try {
                clone.addModel(currentModel.next.name, currentModel.next.price);
            } catch (DuplicateModelNameException e) {
                e.printStackTrace();
            }
            currentModel = currentModel.next;
        }
        return clone;
    }

    private class Model implements Cloneable{
        String name = null;
        double price = Double.NaN;
        Model prev = null;
        Model next = null;

        public Model() {}

        public Model(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public Model getPrev() {
            return prev;
        }

        public void setPrev(Model prev) {
            this.prev = prev;
        }

        public Model getNext() {
            return next;
        }

        public void setNext(Model next) {
            this.next = next;
        }

        @Override
        public Model clone() {
            try {
                Model clone = (Model) super.clone();
                clone.next = next;
                clone.prev = prev;
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }

}
