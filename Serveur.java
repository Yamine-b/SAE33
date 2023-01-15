import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import com.fazecast.jSerialComm.SerialPort;

public class Serveur {

    public static void main(String[] args) throws IOException, SQLException {
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

        float temperature = Float.parseFloat(values[0]);
        float humidity = Float.parseFloat(values[1]);
        int light = Integer.parseInt(values[2]);

        // Affichage des données
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Humidity: " + humidity + "%");
        System.out.println("Light: " + light);
        // Fermeture du port série
        comPort.closePort();
        insertDataToDb(temperature, humidity, light);

    }

    public static void insertDataToDb(float temperature, float humidity, int light) throws SQLException {

        if (temperature > 10 && temperature < 30) {
            // Connexion à la base de données
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SAE33", "root",
                    "");
            // Préparation de la requête d'insertion
            PreparedStatement statement = connection
                    .prepareStatement(
                            "INSERT INTO donnee (Temperature, Humidite, Luminosite, date) VALUES (?, ?, ?, ?)");
            statement.setFloat(1, temperature);
            statement.setFloat(2, humidity);
            statement.setInt(3, light);
            statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            // Exécution de la requête
            statement.executeUpdate();
            // Fermeture de la connexion
            connection.close();
        } else {
            System.out.println("La temprérature est erroné !");
        }
    }
}