import com.fazecast.jSerialComm.*;
import java.sql.*;
import java.util.LinkedList.*;
import java.util.LinkedList;

import javax.print.PrintException;

//import java.lang.String.split;

public class Serveur {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // Ouvrir le port COM4
        SerialPort comPort = SerialPort.getCommPort("COM3");
        comPort.openPort();
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 100, 0);
        int nbbytes = comPort.bytesAvailable();
        byte[] readBuffer = new byte[16];
        int numRead = comPort.readBytes(readBuffer, readBuffer.length);
        String d = new String(readBuffer);
        LinkedList<String> data = new LinkedList<String>();
        try {
            for (int i = 0; i < 1; i++) {
                data.add(d);
                for (String e : data) {
                    if (e.matches("^\\d+.?\\d*")) {
                        System.out.println("Valeur : " + e);
                    }
                }
            }

            System.out.println(data);
        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println(data);
        // try {
        // // Lire les données du port COM4
        // while (nbbytes == 0) {
        // Thread.sleep(50);
        // nbbytes = comPort.bytesAvailable();
        // }
        // // des octets sont arrivés
        // do {
        // nbbytes = comPort.bytesAvailable();
        // Thread.sleep(200);
        // System.out.println("bloqué");
        // System.out.println(comPort.bytesAvailable());
        // } while (nbbytes != 0);
        // {

        // // Fin de transmission data
        // try {
        // byte[] readBuffer = new byte[2048];
        // int numRead = comPort.readBytes(readBuffer, readBuffer.length);
        // String data = new String(readBuffer);

        // // String[] data_array= data.split("/", data);

        // // data_array[0]

        // // float data_array[0] = Float.parseFloat(data_array[0]); // convertir les
        // // données en entier

        // // Fermer le port COM4
        // System.out.println(data);
        // comPort.closePort();
        // } catch (Exception e) {

        // }

        // }

        // } catch (Exception e) {

        // }
    }
}