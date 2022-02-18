/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import Utils.files;
import Utils.utils;
import java.io.IOException;

/**
 *
 * @author SergiMS03
 */
public class InserirClients {

    /**
     * Demana les dades dels clients per afegir
     * @param c
     * @param adreca
     * @throws IOException 
     */
    static void Dades_Client(Practica2.Client c, String adreca) throws  IOException {
        Practica2.Size s = new Practica2.Size();
        c.codi = utils.LlegirStringMaxCaracters("Codi: ", s.Size_codi);
        c.nom = utils.LlegirStringMaxCaracters("Nom: ", s.Size_nom);
        c.cognoms = utils.LlegirStringMaxCaracters("Cognoms: ", s.Size_cognoms);
        c.Data = utils.LlegirDataString("Naixement: ");
        c.adreca_postal = utils.LlegirStringMaxCaracters("Adre\u00e7a: ", s.Size_adreca_postal);
        c.email = utils.LlegirStringMaxCaracters("Email: ", s.Size_email);
        Llamar_Espacios_String(c, s, adreca);
    }

    /**
     * Crea els espais segons els valors que s'hagin pasat
     * @param variablesClients
     * @param Size_Parametre
     * @param adreca
     * @throws IOException 
     */
    static void Espacios_String(String variablesClients, int Size_Parametre, String adreca) throws IOException {
        int numEspacios = Size_Parametre - variablesClients.length();
        for (int i = 0; i < numEspacios; i++) {
            variablesClients += " ";
        }
        files.FileWriterOneLine(adreca, variablesClients, true);
    }

    /**
     * Crida a diferents funcions de crear espais
     * @param c
     * @param s
     * @param adreca
     * @throws IOException 
     */
    private static void Llamar_Espacios_String(Practica2.Client c, Practica2.Size s, String adreca) throws IOException {
        InserirClients.Espacios_String(c.codi, s.Size_codi, adreca);
        InserirClients.Espacios_String(c.nom, s.Size_nom, adreca);
        InserirClients.Espacios_String(c.cognoms, s.Size_cognoms, adreca);
        InserirClients.Espacios_String(c.Data, s.Size_Data, adreca);
        InserirClients.Espacios_String(c.adreca_postal, s.Size_adreca_postal, adreca);
        InserirClients.Espacios_String(c.email, s.Size_email, adreca);
        files.FileWriter(adreca, "", true);
    }
    
}
