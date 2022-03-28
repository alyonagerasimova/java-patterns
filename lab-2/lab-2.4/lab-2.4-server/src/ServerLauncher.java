import configs.Config;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerLauncher {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(Config.PORT)) {
            System.out.println("Сервер запущен");
            while (!serverSocket.isClosed()) {
                Socket client = serverSocket.accept();
                runTask(client);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void runTask(Socket clientSocket) {
        System.out.println("Соединение с клиентом успешно: " + clientSocket.getLocalAddress() + ":" + clientSocket.getLocalPort());
        try (clientSocket) {
            var inputStream = new DataInputStream(clientSocket.getInputStream());
            var outputStream = new DataOutputStream(clientSocket.getOutputStream());

            double first = inputStream.readDouble();
            double second = inputStream.readDouble();

            System.out.println("Результат: " + first * second);
            outputStream.writeDouble(first * second);

            outputStream.close();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
