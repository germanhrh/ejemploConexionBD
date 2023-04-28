package test.utils;

import java.io.FileWriter;
import java.io.PrintWriter;

public class ManejoArchivos {

    public static void agregarClientesArchivo(String numeroDocumento, String ScoreGenrado, String scoreEsperado, String ruta){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(ruta, true);
            pw = new PrintWriter(fichero);
            pw.println(numeroDocumento +";"+ScoreGenrado +";"+scoreEsperado);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
