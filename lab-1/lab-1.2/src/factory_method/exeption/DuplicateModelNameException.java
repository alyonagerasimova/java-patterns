package factory_method.exeption;

public class DuplicateModelNameException extends Exception{
    public DuplicateModelNameException(String message){
        super(message);
    }
}
