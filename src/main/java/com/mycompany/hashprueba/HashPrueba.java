/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.hashprueba;

/**
 *
 * @author luisa
 */
import javax.swing.JOptionPane;

public class HashPrueba {

    public static void main(String[] args){

        CSV archivo = new CSV(); // Objeto tipo CSV
        TablaHash tabla = new TablaHash(248); // Objeto tipo TablaHash

        /*
         * Se lee el CSV
         */
        archivo.leer("C:\\Users\\luisa\\OneDrive\\Documents\\NetBeansProjects\\HashPrueba\\src\\main\\java\\com\\mycompany\\hashprueba\\paises.csv");

        /*
         * Se agregan los países a la tabla
         */

        for(int i=0;i<archivo.paises.size();i++){
            tabla.agregar(archivo.isos.get(i), archivo.paises.get(i));
        }

        tabla.mostrarTabla();


        /*
         * Menú para buscar un país con su clave
         */

        String opcion;
        do{
            opcion = JOptionPane.showInputDialog("                       .::Menu de Busqueda::.\n Digite el numero de una de las siguientes opciones:\n 1. Buscar pais.\n 2. Salir.");
            if(opcion.equals("1")){
                String clave = JOptionPane.showInputDialog("Digite la clave del pais en mayuscula a buscar:");
                tabla.buscar(clave);
            }
            if(!opcion.equals("2") && !opcion.equals("1")){
                JOptionPane.showMessageDialog(null, "                                     ¡ERROR!\n Debe digitar el numero de una de las siguientes opciones:\n 1. Buscar pais.\n 2. Salir.");
            }
        }while(!opcion.equals("2"));
        JOptionPane.showMessageDialog(null, "Ha salido del programa con exito.");
    }
}
