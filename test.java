import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.fazecast.jSerialComm.SerialPort;

public class test {

    public static void main(String[] args) throws IOException {
        // Récupération du port série COM3
        SerialPort comPort = SerialPort.getCommPort("COM3");
        // Configuration du port série
        comPort.setBaudRate(9600);
        comPort.setNumDataBits(8);
        comPort.setNumStopBits(SerialPort.ONE_STOP_BIT);
        comPort.setParity(SerialPort.NO_PARITY);

        // Ouverture du port série
        comPort.openPort();

        // Lecture des données de l'Arduino
        while (comPort.bytesAvailable() == 0) {
        }
        InputStream in = comPort.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String data = reader.readLine();
        System.out.println("Données reçues: " + data);
        String[] values = data.split(";");
        System.out.println("Nombre de données: " + values.length);

        // String[] values = data.split(";");
        float temperature = Float.parseFloat(values[0]);
        float humidity = Float.parseFloat(values[1]);
        int light = Integer.parseInt(values[2]);

        // Affichage des données
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Humidity: " + humidity + "%");
        System.out.println("Light: " + light);
        // Fermeture du port série
        comPort.closePort();

    }
}