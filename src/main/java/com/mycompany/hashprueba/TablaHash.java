package com.mycompany.hashprueba;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author luisa
 */
import java.util.Arrays;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class TablaHash{

    protected String[] arreglo; // Arreglo para la tabla hash
    private final int tamaño; // Tamaño de la tabla
    private final LinkedList <Pais> paises = new LinkedList<>(); // Lista para almacenar objetos de tipo Pais

    /*
     * Constructor
     */
    public TablaHash(int tamaño){
        this.tamaño = tamaño;
        this.arreglo = new String[tamaño];
        Arrays.fill(arreglo, "-1");
    }

    /*
     * Método para agregar un elemento a la tabla
     */

    public void agregar(String clave, String dato){

        Pais pais = new Pais(clave, dato); // Se crean objetos de tipo Pais
        paises.add(pais); // Y se almacenan en la lista mencionada anteriormente
        String elemento = pais.getClave(); // El elemento a agregar en la tabla es la clave del país (ISO)
        int indice = Integer.parseInt(valorAscii(elemento))%247; // El índice es = elemento % (tamaño-1)
        System.out.println("El índice " + indice + " es para: " + pais.toString() + "."); // Se indica en qué posición irá en caso de que no hayan colisiones

        /*
         * Tratamiento de colisiones
         */
        while(!arreglo[indice].equals("-1")){
            indice++; //Se incrementa el índice (se recorre la tabla buscando un lugar libre)
            System.out.println("Colisión en el índice " + (indice-1) + "." + " Se cambiara a " + pais.toString() + " al indice "+ (indice) + "."); //Se le informa al usuario que hubo una colisión
            indice%=tamaño; //Esta vez, índice = índice % tamaño, ya que estamos buscando una posición adelante, hacerlo con (tamaño-1) causaría un bucle infinito
        }

        // Después de que todas las colisiones se hayan tratado, se agrega el elemento a la tabla
        arreglo[indice] = elemento;
    }

    /*
     * Método para buscar un elemento
     */
    public String buscar(String elemento){
        int contador=0;
        int indice = Integer.parseInt(valorAscii(elemento))%247; // Se busca desde el índice correspondiente
        while(!arreglo[indice].equals("-1")){ //Si es diferente a "-1", hay elementos qué buscar, y procedemos a validar
            if(arreglo[indice].equals(elemento)){ //Validamos si el elemento a buscar es igual al elemento en el índice del arreglo
                for(int i=0;i<arreglo.length;i++){ //Recorremos todo el arreglo
                    /*
                     * Se valida de nuevo, ya que se necesita indicar el dato correpsondiente a esa clave, se hace uso de la lista de países definida globalmente
                     */
                    if(paises.get(i).getClave().equals(elemento)){
                        JOptionPane.showMessageDialog(null, "Se ha encontrado el elemento con clave " + elemento +" en el índice " + indice + "." + " Su dato es: "+paises.get(i).getDato() + ".");
                    }
                }
                return arreglo[indice]; //En caso de encontrar algo, retorna ese elemento, y se muestra un mensaje indicando que el elemento fue encontrado
            }
            /*
             * Se incrementa el índice y se hace su respectivo módoulo, para seguir recorriendo la tabla
             */
            indice++;
            indice%=tamaño;
            contador++;
            /*
             * Si el contador sobrepasa el tamaño-1, significa que la función entra en un bucle infinito, así que lo cortamos
             */
            if(contador>247){
                break;
            }
        }
        JOptionPane.showMessageDialog(null, "No se ha encontrado el elemento. Asegurese de que la clave este escrita correctamente.");
        return null; // En caso de no encontrar el elemento, se retorna "null", y se indica que el elemento no se encontró
    }

    /*
     * Convierte una cadena (ISO) a su valor ascii
     */

    public String valorAscii(String llave){
        int cAscii=0;
        int valor = 0;
        String cadena = "";

        for(int i=0;i<3;i++){
            char letra = llave.charAt(i);
            cAscii=(int)letra;
            valor+=cAscii;
        }
        cadena = Integer.toString(valor);
        return cadena;
    }

    /*
     * Funciones para mostrar la tabla
     */

    public void mostrarTabla(){
        System.out.println();
        System.out.println();
        System.out.println("     Indice            Clave                            Pais");
        System.out.println("|---------------|----------------|------------------------------------------------------|");
        for(int i=0;i<arreglo.length;i++){
            System.out.println("|\t"+ i + "\t|\t" + arreglo[i] + "\t |\t" + dato(i));
            System.out.println("|---------------|----------------|------------------------------------------------------|");
        }
    }

    public String dato(int x){
        for(int i=x;i<arreglo.length;i++){
            for(int j=0;j<arreglo.length;j++){
                if(arreglo[i].equals(paises.get(j).getClave())){
                    return paises.get(j).getDato();
                }
            }
        }
        return null;
    }
}
