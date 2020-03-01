/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica_AFD;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class main {

    Scanner reader = new Scanner(System.in);
    // Variables 

    /**
     *
     * @param args
     * metodo principal de ejecucion
     */
    public static void main(String[] args) {
        afd a = new afd();
        main app = new main();
        String opcion;
        try {

            JFileChooser buscar = new JFileChooser();
            buscar.showOpenDialog(buscar);
            String select = buscar.getSelectedFile().getAbsolutePath();

            FileInputStream arch = new FileInputStream(select);

            DataInputStream entrada = new DataInputStream(arch);

            BufferedReader archivoLeer = new BufferedReader(new InputStreamReader(entrada));

            String lineaLeida;
            int dato1, dato3;
            String cadena;

            if ((lineaLeida = archivoLeer.readLine()) != null) {
                a.getQ(lineaLeida);
            }
            if ((lineaLeida = archivoLeer.readLine()) != null) {
                a.getAlfabeto(lineaLeida);

            }

            if ((lineaLeida = archivoLeer.readLine()) != null) {

                a.getQ0(lineaLeida);

            }

           
            archivoLeer.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        do {
            a.getF();

          
            a.populateSec();
            a.getW();

            if (a.validateStatus(a.op())) {
                System.out.println("Cadena aceptada");
            } else {
                System.out.println("Cadena rechazada");
            }

            opcion = JOptionPane.showInputDialog(null, "¿Desea Continuar?");

        } while (opcion.equalsIgnoreCase("si"));

    }
}