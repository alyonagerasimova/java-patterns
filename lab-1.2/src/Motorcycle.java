import java.util.Objects;

public class Motorcycle {

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

    public String getMotoBrand(){
        return motoBrand;
    }

    public void setMotoBrand(String newMotoBrand){
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

    public void setModelsNameByName(String name, String newName){
        Model currentModel = head;
        while(currentModel.next != head){
            if(currentModel.next.nameModel.equals(name)){
                currentModel.next.nameModel = newName;
                return;
            }
            currentModel = currentModel.next;
        }
    }

    public double getPriceByName(String name) throws Exception {
        Model currentModel = head;
        while(currentModel.next != head){
            if(currentModel.next.nameModel.equals(name)){
                return currentModel.next.price;
            }
            currentModel = currentModel.next;
        }
        throw new Exception("Model with name '" + name + "' not found!");
    }

    public void setPriceByName(String name, double newPrice) throws Exception {
        Model currentModel = head;
        while(currentModel.next != head){
            if(currentModel.next.nameModel.equals(name)){
                currentModel.next.setPrice(newPrice);
                return;
            }
            currentModel = currentModel.next;
        }
        throw new Exception("Model with name '" + name + "' not found!");
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

    public void addModel(String name, double price){
        Model newModel = new Model(name, price);
        Model lastModel = head.prev;

        lastModel.next = newModel;
        newModel.next = head;
        head.prev = newModel;
        newModel.prev = lastModel;
        size++;
    }

    public void removeModel(String name) throws Exception {
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
        throw new Exception("Model with name '" + name + "' not found!");
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private int getSizeOfModels(){
        return size;
    }

    private class Model{
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
