package com.mycompany.hashprueba;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author luisa
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class CSV{

    /*
     * Se lee el archivo correspondiente, y se almacenan los ISOS y los países en dos listas diferentes
     */

    protected LinkedList <String> isos = new LinkedList<>();
    protected LinkedList <String> paises = new LinkedList<>();

    public void leer (String archivo){

        try {

            BufferedReader lector = null;
            lector = new BufferedReader(new FileReader(archivo));
            String verificador;
            while((verificador=lector.readLine())!=null){
                String separador[] = verificador.split(",");
                String codigo = (separador[1]);
                isos.add(codigo);
                paises.add(separador[0]);
            }

            lector.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}