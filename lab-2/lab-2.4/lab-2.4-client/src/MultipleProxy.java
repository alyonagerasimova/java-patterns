import configs.Config;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class MultipleProxy implements MultipleInterface {

    @Override
    public double multiple(double a, double b) {
        double result = Double.NaN;
        try (Socket clientSocket = new Socket(Config.HOST, Config.PORT)) {
            var inputStream = new DataInputStream(clientSocket.getInputStream());
            var outputStream = new DataOutputStream(clientSocket.getOutputStream());

            outputStream.writeDouble(a);
            outputStream.writeDouble(b);
            outputStream.flush();

            result = inputStream.readDouble();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return result;
    }
}
