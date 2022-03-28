import configs.Config;

public class MultipleProxy implements MultipleInterface {
    private Client clientResult;

    @Override
    public double multiple(double a, double b) {
        if(clientResult == null){
            clientResult = new Client(Config.HOST, Config.PORT);
        }
        return clientResult.multiple(a,b);
    }
}
