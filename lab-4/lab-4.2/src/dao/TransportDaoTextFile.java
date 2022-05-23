package dao;

import transport.models.Transport;
import transport.models.TransportUtilitiesMethods;
import java.io.*;
import java.util.Arrays;

public class TransportDaoTextFile extends AccessToData {

    public TransportDaoTextFile(String pathToFile) {
        super(pathToFile);
    }

    @Override
    public void writeTransport(Transport transport) throws Exception{
        try (var writer = new PrintWriter(new FileWriter(pathToFile))) {

            writer.println(transport.getBrand());

            var names = transport.getModelsName();
            writer.println(names.length);

            var builder = new StringBuilder();
            Arrays.stream(names).forEachOrdered(value -> {
                try {
                    var price = transport.getPriceByNameModel(value);
                    writer.println(value);
                    builder.append(price).append("\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            writer.print(builder.toString());
            writer.flush();
        }
    }

    @Override
    public Transport readTransport() {
        Transport transport = null;
        try (var reader = new BufferedReader(new FileReader(pathToFile))) {
            var brand = reader.readLine();
            var modelSize = Integer.parseInt(reader.readLine());
            transport = TransportUtilitiesMethods.createInstance(brand, modelSize);

            if (transport == null) {
                return null;
            }

            var names = readNames(modelSize, reader);
            int j = 0;
            while (reader.ready() && j < modelSize) {
                var price = Double.parseDouble(reader.readLine());
                transport.addModel(names[j], price);
                j++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transport;
    }

    private String[] readNames(int size, BufferedReader reader) throws IOException {
        var names = new String[size];
        int i = 0;
        while (reader.ready() && i < size) {
            names[i] = reader.readLine();
            i++;
        }
        return names;
    }
}
