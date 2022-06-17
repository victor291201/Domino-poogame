/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class Jugador {
    private int score;
    private String nombre;
    private ArrayList<Domino> fichas= new ArrayList();

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Domino> getFichas() {
        return fichas;
    }

    public void setFichas(ArrayList<Domino> fichas) {
        this.fichas = fichas;
    }
    public String mostrarFichas(){
        String res ="";
        for(int i = 0;i<this.fichas.size();i++){
            res  = res + this.fichas.get(i).mostrar() + "    ";
        }
        return res;
    }
    public String mostrarDatos(){
        return "nombre: "+this.nombre+", puntuacion: "+String.valueOf(this.score)+", Fichas: "+this.mostrarFichas()+"\n";
    }
}
