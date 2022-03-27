package factory_method.exeption;

public class ModelPriceOutOfBoundsException extends RuntimeException{
    public ModelPriceOutOfBoundsException (String message){
        super(message);
    }
}
