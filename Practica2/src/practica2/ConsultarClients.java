/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import Utils.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ausias
 */
public class ConsultarClients {

    /**
     * Pregunta el codi del client que es vol consultar
     * @throws IOException 
     */
    static void Pregunta_Consulta_Codi() throws IOException {
        FileReader reader = new FileReader(Practica2.ADRECA);
        BufferedReader buffer = new BufferedReader(reader);
        String codiConsulta = utils.LlegirString("Quin es el codi que vols consultar: ");
        Consultar_Codi(buffer, codiConsulta);
        System.out.println("");
    }

    /**
     * Busca el codi del client que es volia consultar i l'imprimeix per pantalla
     * @param buffer
     * @param codiConsulta
     * @throws IOException 
     */
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

    
}
