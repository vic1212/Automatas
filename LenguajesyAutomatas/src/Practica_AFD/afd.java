/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica_AFD;

import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class afd {

    private int Q = 0;
    private String alfabeto = "";
    private int q0 = 0;
    private int F[];
    private int symb = -1;
    private String w;
    int[][] S;

    /**
     *
     * @param QF
     * retorna el valor de Q
     */
    public void getQ(String QF) {
    
        Q = Integer.parseInt(QF);
    }

    /**
     *
     * @param alpha
     * retorna el valor del alfabeto
     */
    public void getAlfabeto(String alpha) {
        
        alfabeto = alpha;
    }

    /**
     *
     * @param Q0
     * retorna el valor dw¿e q0
     */
    public void getQ0(String Q0) {
     
        q0 = Integer.parseInt(Q0);

    }

    /**
     * recibe la cadena a analizar
     */
    public void getW() {
        w = JOptionPane.showInputDialog("Ingresa la cadena a analizar");
    }

    /**
     *obtiene el numero final de la matriz
     */
    public void getF() {
        int numF = 0;
        numF = 1;
        F = new int[numF];

        for (int i = 0; i < numF; i++) {
            String res = "2";
            F[i] = Integer.parseInt(res);

        }

    }

    /**
     * lee el archivo y obtiene los datos de la matriz
     */
    public void populateSec() {
        Scanner archivo = null;
        int tamAlpha = alfabeto.length();

        S = new int[Q][tamAlpha];

        int num[] = new int[8];
  
        try {

            archivo = new Scanner(new File("C:\\Users\\LENOVO\\Documents\\matriz.txt"));
            System.out.println("Datos Obtenidos Del Archivo");
            int i = 0;
            while (archivo.hasNext()) {
                num[i] = archivo.nextInt();
                i++;

            }

        } catch (Exception e) {
            System.out.println("No se encuentra el archivo");

        }
        int incremento = 0;
        for (int i = 0; i < Q; i++) {
            for (int j = 0; j < tamAlpha; j++) {
                S[i][j] = num[incremento];

                incremento++;
            }
        }

        }
    
    /**
     *
     * @return 
     * retorna el valor de q
     */
    public int op() {

        int q = (Q - 1);
        char s;
        int is;

        try {
            s = nextChar();

            while (true) {
                is = w.indexOf("" + s);

                if (is == -1) {
                    error(102);
                }

                q = S[q][is];

                if (q == -1) {
                    error(101);
                }

                s = nextChar();

            }
        } catch (IndexOutOfBoundsException e) {

        }

        return q;

    }

    /**
     *
     * @param q
     * @return vallida 
     */
    public boolean validateStatus(int q) {

        boolean aux = false;
        for (int i = 0; i < F.length; i++) {
            if (F[i] == q) {
                aux = true;
            }
        }

        return aux;

    }

    /**
     *
     * @return
     * @throws IndexOutOfBoundsException
     *  avanza al siguiente caracter
     */
    public char nextChar() throws IndexOutOfBoundsException {
        symb++;
        return w.charAt(symb);

    }

    /**
     *
     * @param i
     *  verfica errores
     */
    public void error(int i) {
        switch (i) {
            case 101:
                System.err.println("Error");
                break;
            case 102:
                System.err.println("Error");
                break;
        }
    }

}
