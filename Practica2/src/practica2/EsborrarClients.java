/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import Utils.files;
import Utils.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author SergiMS03
 */
public class EsborrarClients {

    /**
     * Crida a les funcions necessaries per esborrar un client segons la linea del fitxer
     * @throws IOException 
     */
    static void Esborrar_Client() throws IOException {
        int esborrar = utils.LlegirInt("Quina linea vols borrar: ");
        final String ADRECA_AUX = "./aux.txt";
        File f = new File(ADRECA_AUX);
        f.createNewFile();
        FileReader reader = new FileReader(Practica2.ADRECA);
        BufferedReader buffer = new BufferedReader(reader);
        CopiantIEsborrant(buffer, esborrar, ADRECA_AUX);
        Practica2.Copiar_texto(buffer, ADRECA_AUX);
        Practica2.Renombrar(Practica2.ADRECA, f);
    }

    /**
     * Copia totes les lineas a un fitxer aux.txt menys la que volem borrar
     * @param buffer
     * @param esborrar
     * @param ADRECA_AUX
     * @throws IOException 
     */
    private static void CopiantIEsborrant(BufferedReader buffer, int esborrar, final String ADRECA_AUX) throws IOException {
        int currentLine = 1;
        String line = null;
        do {
            line = buffer.readLine();
            if (esborrar != currentLine && line != null) {
                files.FileWriter(ADRECA_AUX, line, true);
            }
            currentLine++;
        } while (line != null);
    }
}
