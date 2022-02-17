/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import Utils.files;
import Utils.utils;
import java.io.IOException;
import oracle.jrockit.jfr.parser.ParseException;

/**
 *
 * @author SergiMS03
 */
public class InserirClients {

    static void Dades_Client(Practica2.Client c) throws ParseException, IOException, java.text.ParseException {
        Practica2.Size s = new Practica2.Size();
        c.codi = utils.LlegirStringMaxCaracters("Codi: ", s.Size_codi);
        c.nom = utils.LlegirStringMaxCaracters("Nom: ", s.Size_nom);
        c.cognoms = utils.LlegirStringMaxCaracters("Cognoms: ", s.Size_cognoms);
        c.Data = utils.LlegirDataString("Naixement: ");
        c.adreca_postal = utils.LlegirStringMaxCaracters("Adre\u00e7a: ", s.Size_adreca_postal);
        c.email = utils.LlegirStringMaxCaracters("Email: ", s.Size_email);
        Llamar_Espacios_String(c, s);
    }

    static void Espacios_String(String variablesClients, int Size_Parametre) throws IOException {
        int numEspacios = Size_Parametre - variablesClients.length();
        for (int i = 0; i < numEspacios; i++) {
            variablesClients += " ";
        }
        files.FileWriterOneLine(Practica2.ADRECA, variablesClients, true);
    }

    private static void Llamar_Espacios_String(Practica2.Client c, Practica2.Size s) throws IOException {
        InserirClients.Espacios_String(c.codi, s.Size_codi);
        InserirClients.Espacios_String(c.nom, s.Size_nom);
        InserirClients.Espacios_String(c.cognoms, s.Size_cognoms);
        InserirClients.Espacios_String(c.Data, s.Size_Data);
        InserirClients.Espacios_String(c.adreca_postal, s.Size_adreca_postal);
        InserirClients.Espacios_String(c.email, s.Size_email);
        files.FileWriter(Practica2.ADRECA, "", true);
    }
    
}
