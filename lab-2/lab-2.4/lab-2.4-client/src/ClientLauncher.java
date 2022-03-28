import configs.Config;

public class ClientLauncher {

    public static void main(String[] args){

        if (args.length < 2) {
            System.out.println("Отсутствуют аргументы!");
            return;
        }
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        var helper = new MultipleProxy();
        var result = helper.multiple(a, b);
        var client = new Client(Config.HOST, Config.PORT);
        System.out.println("First Multiple result through a proxy: " + result);
        System.out.println("Second Multiple result from client: " + client.multiple(a, b));
    }
}
