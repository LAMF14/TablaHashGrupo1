package com.mycompany.hashprueba;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author luisa
 */
public class Pais {

    /*
     * Clase Pais, tiene como atributos su su dato, que es el nombre del país, y su clave, que es el ISO
     */

    private String dato;
    private String clave;

    public Pais(String clave, String dato) {
        this.clave = clave;
        this.dato = dato;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String toString(){
        return dato +", con código: " + clave;
    }
}
