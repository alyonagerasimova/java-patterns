package factory_method.exeption;

public class NoSuchModelNameException extends Exception{
    public NoSuchModelNameException(String message){
        super(message);
    }
}
