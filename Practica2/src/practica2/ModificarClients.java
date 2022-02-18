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
 * @author ausias
 */
public class ModificarClients {

    /**
     * Pregunta la linea que es vol modificar i crida a altres funcions
     * @param c
     * @throws IOException 
     */
    static void Modificar_Client(Practica2.Client c) throws IOException {
        int modificar = utils.LlegirInt("Quina linea vols modificar: ");
        final String ADRECA_AUX = "./aux.txt";
        File f = new File(ADRECA_AUX);
        f.createNewFile();
        FileReader reader = new FileReader(Practica2.ADRECA);
        BufferedReader buffer = new BufferedReader(reader);
        int currentLine = 1;
        String modificacio = null;
        modificarICopiar(buffer, modificar, currentLine, c, ADRECA_AUX);
        Practica2.Copiar_texto(buffer, ADRECA_AUX);
        Practica2.Renombrar(Practica2.ADRECA, f);
    }

    /**
     * Copia tot el text a un arxiu aux.txt exepte la linea que modifiquem, on ens tornarà a preguntar les dades del client
     * @param buffer
     * @param modificar
     * @param currentLine
     * @param c
     * @param ADRECA_AUX
     * @throws IOException 
     */
    static void modificarICopiar(BufferedReader buffer, int modificar, int currentLine, Practica2.Client c, final String ADRECA_AUX) throws IOException {
        String modificacio;
        do {
            modificacio = buffer.readLine();
            if (modificar == currentLine) {
                InserirClients.Dades_Client(c, ADRECA_AUX);
            } else if (modificar != currentLine && modificacio != null) {
                files.FileWriter(ADRECA_AUX, modificacio, true);
            }
            currentLine++;
        } while (modificacio != null);
    }
    
}
