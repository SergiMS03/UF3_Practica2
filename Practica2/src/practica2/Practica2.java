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

    /**
     * Crida a les altres funcions
     * @param args
     * @throws ParseException
     * @throws IOException 
     */
    public static void main(String[] args) throws ParseException, IOException{
        Client c = new Client();
        Size s = new Size();
        int opc;
        do {
            imprimirMenu();
            opc = elegirOpc(c, s);
        } while (opc != 0);
    }

    /**
     * Menu
     */
    private static void imprimirMenu() {
        System.out.println("1- Alta d'un client");
        System.out.println("2- Consulta posició");
        System.out.println("3- Consulta codi");
        System.out.println("4- Modificar un client");
        System.out.println("5- Esborrar client");
        System.out.println("6- Llistar tots els clients");
    }

    /**
     * Switch que esculleix la opció del menú i crida a les altres funcions
     * @param c
     * @param s
     * @return
     * @throws ParseException
     * @throws IOException 
     */
    private static int elegirOpc(Client c, Size s) throws ParseException, IOException {
        int opc = utils.LlegirIntLimitat("Escull una opció: ", 0, 6);
        switch (opc) {
            case 0:
                System.out.println("Tancant programa...");
                break;
            case 1:
                InserirClients.Dades_Client(c, ADRECA);
                break;
            case 2:
                files.FileLineReader(ADRECA, "Linea que vols llegir: ", "No s'ha trobat la linea que s'ha indicat...");
                break;
            case 3:
                ConsultarClients.Pregunta_Consulta_Codi();
                break;
            case 4:
                ModificarClients.Modificar_Client(c);
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

    /**
     * Cambia els noms dels fitxers que es pasin
     * @param ADRECA
     * @param f 
     */
    static void Renombrar(String ADRECA, File f) {
        File EXERCICI_3 = new File(ADRECA);
        f.renameTo(EXERCICI_3);
    }

    /**
     * Serveix per copiar text d'un fitxer a un altre
     * @param buffer
     * @param ADRECA_AUX
     * @throws IOException 
     */
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
