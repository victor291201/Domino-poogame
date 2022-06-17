/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

/**
 *
 * @author Estudiante
 */
public class Domino {
     private int lado1;
     private int lado2;

    public Domino(int lado1, int lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public int getLado1() {
        return lado1;
    }

    public int getLado2() {
        return lado2;
    }
    /**
     * @param args the command line arguments
     */
   public void voltear(){
       int var = this.lado1;
       this.lado1 = this.lado2;
       this.lado2 = var;
   }
    public String mostrar(){
        return String.valueOf(this.lado1)+"|"+String.valueOf(this.lado2);
    }
}

