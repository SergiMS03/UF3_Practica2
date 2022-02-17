/*
Fes un programa que permeti gestionar el fitxer de clients amb les següents
operacions:
x a) Alta d’un client (registrar un client que no existia abans al fitxer)
x b) Consulta d’un client per posició
x c) Consulta d’un client per codi
d) Modificar un client
x e) Esborrar un client
x f) Llistat de tots els clients
 */
package practica2;

import Utils.files;
import Utils.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author ausias
 */
public class Practica2 {

    static final String ADRECA = "./clients.txt";

    static class Client {

        String codi;
        String nom;
        String cognoms;
        String Data;
        String adreca_postal;
        String email;
    }

    static class Size {

        final int Size_codi = 6;
        final int Size_nom = 20;
        final int Size_cognoms = 30;
        final int Size_Data = 8;
        final int Size_adreca_postal = 40;
        final int Size_email = 30;
    }

    public static void main(String[] args) throws ParseException, IOException, oracle.jrockit.jfr.parser.ParseException {
        Client c = new Client();
        Size s = new Size();
        int opc;
        do {
            imprimirMenu();
            opc = elegirOpc(c, s);
        } while (opc != 0);
    }

    private static void imprimirMenu() {
        System.out.println("1- Alta d'un client");
        System.out.println("2- Consulta posició");
        System.out.println("3- Consulta codi");
        System.out.println("4- Modificar un client");
        System.out.println("5- Esborrar client");
        System.out.println("6- Llistar tots els clients");
    }

    private static int elegirOpc(Client c, Size s) throws ParseException, IOException, oracle.jrockit.jfr.parser.ParseException {
        int opc = utils.LlegirIntLimitat("Escull una opció: ", 0, 6);
        switch (opc) {
            case 0:
                System.out.println("Tancant programa...");
                break;
            case 1:
                InserirClients.Dades_Client(c);
                break;
            case 2:
                files.FileLineReader(ADRECA, "Linea que vols llegir: ", "No s'ha trobat la linea que s'ha indicat...");
                break;
            case 3:
                Pregunta_Consulta_Codi();
                break;
            case 4:
                Modificar_Client();
                break;

            case 5:
                EsborrarClients.Esborrar_Client();
                break;

            case 6:
                files.FileReader(ADRECA);
                break;
        }
        return opc;
    }

    private static void Pregunta_Consulta_Codi() throws IOException {
        FileReader reader = new FileReader(ADRECA);
        BufferedReader buffer = new BufferedReader(reader);
        String codiConsulta = utils.LlegirString("Quin es el codi que vols consultar: ");
        Consultar_Codi(buffer, codiConsulta);
        System.out.println("");
    }

    static void Consultar_Codi(BufferedReader buffer, String codiConsulta) throws IOException {
        String lineaActual;
        boolean trobat = false;
        do {
            lineaActual = buffer.readLine();
            if (lineaActual != null) {
                String[] codiActual = lineaActual.split(" ");
                if (codiConsulta.equals(codiActual[0])) {
                    System.out.println(lineaActual);
                }
            }
        } while (!trobat && lineaActual != null);
    }

    private static void Modificar_Client() {

    }


    static void Renombrar(String ADRECA, File f) {
        File EXERCICI_3 = new File(ADRECA);
        f.renameTo(EXERCICI_3);
    }

    static void Copiar_texto(BufferedReader buffer, final String ADRECA_AUX) throws IOException {
        String linea = ("");
        while (linea != null) {
            linea = buffer.readLine();
            if (linea != null) {
                files.FileWriter(ADRECA_AUX, linea, true);
            }
        }
    }
}
