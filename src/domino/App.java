/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

import java.util.Scanner;

/**
 *
 * @author Estudiante
 */
public class App {
    public static void main (String [ ] args) {
        Scanner escan = new Scanner(System.in); 
        System.out.println("Ingrese la cantidad de jugadores (2, 3 o 4)");
        int cant = escan.nextInt();
        Mesa juego = new Mesa(2,new Jugador(" "),new Jugador(" "));
        String var1;
        String var2;
        String var3;
        String var4;
        Jugador p1;
        Jugador p2;
        Jugador p3;
        Jugador p4;
        switch(cant){
            case 2:
                System.out.println("Ingrese el nombre del jugador 1: ");
                var1 = escan.next();
                System.out.println("Ingrese el nombre del jugador 2: ");
                var2 = escan.next();
                p1 = new Jugador(var1);
                p2 = new Jugador(var2);
                juego = new Mesa(2,p1,p2);
                break;
            case 3:
                System.out.println("Ingrese el nombre del jugador 1: ");
                var1 = escan.next();
                System.out.println("Ingrese el nombre del jugador 2: ");
                var2 = escan.next();
                System.out.println("Ingrese el nombre del jugador 3: ");
                var3 = escan.next();
                p1 = new Jugador(var1);
                p2 = new Jugador(var2);
                p3 = new Jugador(var3);
                juego = new Mesa(3,p1,p2,p3);
                break;
            case 4:
                System.out.println("Ingrese el nombre del jugador 1: ");
                var1 = escan.next();
                System.out.println("Ingrese el nombre del jugador 2: ");
                var2 = escan.next();
                System.out.println("Ingrese el nombre del jugador 3: ");
                var3 = escan.next();
                System.out.println("Ingrese el nombre del jugador 4: ");
                var4 = escan.next();
                p1 = new Jugador(var1);
                p2 = new Jugador(var2);
                p3 = new Jugador(var3);
                p4 = new Jugador(var4);
                juego = new Mesa(4,p1,p2,p3,p4);
                break;
        }
        System.out.println("¡¡El juego comenzara!!");
        boolean opt = true;
        while(opt){
            System.out.print("Seleccione una opcion: \n1.- Instrucciones \n2.- Comenzar \n3.- Salir \n");
            cant = escan.nextInt();
            switch(cant){
                case 1:
                    System.out.println("las fichas se seleccionaran por indice iniciando por 1 de \nforma ascendente de izquierda a derecha, puede seleccionar el -1 para pasar o el -2 \npara declarar el ahogado, el resto del juego es intuitivo y facil de usar");
                    break;
                case 2:
                    System.out.println("¡¡El juego comenzo!!");
                    juego.jugar();
                    break;
                case 3:
                    opt = false;
                    break; 
                default:
                    System.out.print("Seleccione una opcion valida (1, 2 o 3)");
                    break;
            }
        }
    }
}
