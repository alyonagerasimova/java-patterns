
public class ClientLauncher {

    public static void main(String[] args){

        if (args.length < 2) {
            System.out.println("Отсутствуют аргументы!");
            return;
        }
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);

        var multiplyService = new MultipleProxy();
        var result = multiplyService.multiple(a, b);
        System.out.println("Multiple result: " + result);
    }
}
