
package final_villalbaaxel;

import java.io.*;
import java.util.List;

public class Persistencia {
    public static void guardarFarmacos(List<Farmaco> farmacos, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(farmacos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Farmaco> cargarFarmacos(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Farmaco>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
