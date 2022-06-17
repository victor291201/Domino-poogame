/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Estudiante
 */
public final class Mesa {
    private ArrayList<Domino> dominos= new ArrayList();
    private ArrayList<Domino> juego = new ArrayList();
    private int turno;

    public ArrayList<Domino> getDominos() {
        return dominos;
    }

    public void setDominos(ArrayList<Domino> dominos) {
        this.dominos = dominos;
    }

    public ArrayList<Domino> getJuego() {
        return juego;
    }

    public void setJuego(ArrayList<Domino> juego) {
        this.juego = juego;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getNjugadores() {
        return Njugadores;
    }

    public void setNjugadores(int Njugadores) {
        this.Njugadores = Njugadores;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public Jugador getJugador3() {
        return jugador3;
    }

    public void setJugador3(Jugador jugador3) {
        this.jugador3 = jugador3;
    }

    public Jugador getJugador4() {
        return jugador4;
    }

    public void setJugador4(Jugador jugador4) {
        this.jugador4 = jugador4;
    }
    private int Njugadores;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugador3;
    private Jugador jugador4;
    
    void CrearFichasDomino(){
        for(int i  = 0; i<7;i++){
            for(int e  = i; e<7;e++){
                Domino var = new Domino(i,e);
                dominos.add(var);
            }
            
        }
    }
    void repartir(Jugador ... arg){
        ArrayList <Domino> variable = dominos;
        if(arg.length==2){
            Collections.shuffle(variable);
            jugador1 = arg[0];
            jugador2 = arg[1];
            ArrayList <Domino> var1 =new ArrayList<Domino>(variable.subList(0, 14));
            ArrayList <Domino> var2 =new ArrayList<Domino>(variable.subList(14, 28));
            jugador1.setFichas(var1);
            jugador2.setFichas((var2));
        }else{
            if(arg.length==3){
                ArrayList <Domino> var;
                var = new ArrayList<Domino>(variable.subList(1, 28));
                Collections.shuffle(var);
                jugador1 = arg[0];
                jugador2 = arg[1];
                jugador3 = arg[2];
                ArrayList <Domino> var1 =new ArrayList<Domino>(var.subList(0, 9));
                ArrayList <Domino> var2 =new ArrayList<Domino>(var.subList(9, 18));
                ArrayList <Domino> var3 =new ArrayList<Domino>(var.subList(18, 27));
                jugador1.setFichas(var1);
                jugador2.setFichas(var2);
                jugador3.setFichas(var3);
            }else{
                if(arg.length==4){
                    Collections.shuffle(variable);
                    jugador1 = arg[0];
                    jugador2 = arg[1];
                    jugador3 = arg[2];
                    jugador4 = arg[3];
                    
                    ArrayList <Domino> var1 =new ArrayList<Domino>(variable.subList(0, 7));
                    ArrayList <Domino> var2 =new ArrayList<Domino>(variable.subList(7, 14));
                    ArrayList <Domino> var3 =new ArrayList<Domino>(variable.subList(14, 21));
                    ArrayList <Domino> var4 =new ArrayList<Domino>(variable.subList(21, 28));
                    jugador1.setFichas(var1);
                    jugador2.setFichas(var2);
                    jugador3.setFichas(var3);
                    jugador4.setFichas(var4);
                }else{
                    System.out.println("error en la cantidad de jugadores ingresados");
                }
            }
        }
    }
    
    public Mesa(int Njugadores,Jugador ... arg) {
        CrearFichasDomino();
        if(arg.length==2){
            repartir(arg[0],arg[1]);
        }else{
            if(arg.length==3){
                repartir(arg[0],arg[1],arg[2]);
            }else{
                if(arg.length==4){
                    repartir(arg[0],arg[1],arg[2],arg[3]);
                }else{
                    System.out.println("error en la cantidad de jugadores ingresados");
                }
            }
        }
        this.Njugadores = Njugadores;
    }
    
    boolean tieneNumero(ArrayList<Domino> dom, int numero){
        for(Domino x: dom){
            if(x.getLado1() == numero ||x.getLado1() == numero){
                return true;
            }
        }
        return false;
    }
    
    String mostrarJuego(){
        String res ="";
        for(int i = 0;i<this.juego.size();i++){
            res  = res + this.juego.get(i).mostrar() + " ";
        }
        return res;
    }
    public void jugar(){
        Scanner escan = new Scanner(System.in); 
        while(true){
            if(Njugadores == 2){
                if(turno == 0){
                    if(tieneNumero(jugador1.getFichas(), 6)){
                        this.turno =1;
                    }if(tieneNumero(jugador2.getFichas(), 6)){
                        this.turno = 2;
                    }
                }
                if(turno == 1){
                    if(jugador2.getFichas().isEmpty()){
                        System.out.println("!!Felicidades "+ jugador2.getNombre()+" has ganado¡¡");
                        int var = jugador2.getScore();
                        var = var + 500;
                        jugador2.setScore(var);
                        System.out.println("Juego: "+ this.mostrarJuego());
                        System.out.println("Datos (jugador 1): "+ jugador1.mostrarDatos());
                        System.out.println("Datos (jugador 2): "+ jugador2.mostrarDatos());
                        System.out.println("Quieres seguir jugando?(s para si, n para no)");
                        String seleccion = escan.next();
                        if(seleccion.equals("s")){
                            juego = null;
                            juego = new ArrayList();
                            jugador1.setFichas(null);
                            jugador2.setFichas(null);
                            repartir(jugador1,jugador2);
                            turno= 0;
                        }else{
                            break;
                        }
                    }else{
                        System.out.println("Juego: "+ this.mostrarJuego());
                        System.out.println("Fichas(jugador 1): "+ jugador1.mostrarFichas());
                        System.out.println("Seleccione la ficha: ");
                        int indFicha = 0;
                        try {
                            indFicha = escan.nextInt();
                        }catch(InputMismatchException e){
                            System.out.println("El indice debe ser un numero.");
                        }
                        if(indFicha>0){
                            if(this.tieneNumero(jugador1.getFichas(), 6)){
                                if(jugador1.getFichas().get(indFicha-1).getLado1() == 6
                                    && jugador1.getFichas().get(indFicha-1).getLado2() == 6){
                                    juego.add(jugador1.getFichas().get(indFicha-1));
                                    jugador1.getFichas().remove(indFicha-1);
                                    turno = 2;
                                }else{
                                    System.out.println("Debe ingresar el doble 6");
                                }  
                            }
                            else{
                                if(jugador1.getFichas().get(indFicha-1).getLado2() == juego.get(0).getLado1()){
                                    juego.add(0,jugador1.getFichas().get(indFicha-1));
                                    jugador1.getFichas().remove(indFicha-1);
                                    turno = 2;
                                }else{
                                    if(jugador1.getFichas().get(indFicha-1).getLado1() == juego.get(juego.size()-1).getLado2()){
                                        juego.add(jugador1.getFichas().get(indFicha-1));
                                        jugador1.getFichas().remove(indFicha-1);
                                        turno = 2;
                                    }else{
                                        if(jugador1.getFichas().get(indFicha-1).getLado1() == juego.get(0).getLado1()){
                                            jugador1.getFichas().get(indFicha-1).voltear();
                                            juego.add(0,jugador1.getFichas().get(indFicha-1));
                                            jugador1.getFichas().remove(indFicha-1);
                                            turno = 2;
                                        }else{
                                            if(jugador1.getFichas().get(indFicha-1).getLado2() == juego.get(juego.size()-1).getLado2()){
                                                jugador1.getFichas().get(indFicha-1).voltear();
                                                juego.add(jugador1.getFichas().get(indFicha-1));
                                                jugador1.getFichas().remove(indFicha-1);
                                                turno = 2;
                                            }else{
                                            System.out.println("Ingrese un numero valido");
                                            } 
                                        }
                                    } 
                                }
                            }
                        }
                        if(indFicha == -1){
                            turno = 2;
                        }
                        if(indFicha == -2){
                            System.out.println("!!Han empatado por que el juego se ha ahogado¡¡");
                            int var1 = jugador2.getScore();
                            var1 = var1 + 250;
                            jugador2.setScore(var1);
                            int var2 = jugador1.getScore();
                            var2 = var2 + 250;
                            jugador2.setScore(var2);
                            System.out.println("Juego: "+ this.mostrarJuego());
                            System.out.println("Datos (jugador 1): "+ jugador1.mostrarDatos());
                            System.out.println("Datos (jugador 2): "+ jugador2.mostrarDatos());
                            System.out.println("Quieres seguir jugando?(s para si, n para no)");
                            String seleccion = escan.next();
                            if(seleccion.equals("s")){
                                juego = null;
                                juego = new ArrayList();
                                jugador1.setFichas(null);
                                jugador2.setFichas(null);
                                repartir(jugador1,jugador2);
                                turno= 0;
                            }else{
                                break;
                            }
                        }
                    }
                }if(turno == 2){
                    if(jugador1.getFichas().isEmpty()){
                        System.out.println("!!Felicidades "+ jugador1.getNombre()+" has ganado¡¡");
                        int var = jugador1.getScore();
                        var = var + 500;
                        jugador1.setScore(var);
                        System.out.println("Juego: "+ this.mostrarJuego());
                        System.out.println("Datos (jugador 1): "+ jugador1.mostrarDatos());
                        System.out.println("Datos (jugador 2): "+ jugador2.mostrarDatos());
                        System.out.println("Quieres seguir jugando?(s para si, n para no)");
                        String seleccion = escan.next();
                        if(seleccion.equals("s")){
                            juego = null;
                            juego = new ArrayList();
                            jugador1.setFichas(null);
                            jugador2.setFichas(null);
                            repartir(jugador1,jugador2);
                            turno = 0;
                        }else{
                            break;
                        }
                    }else{
                        System.out.println("Juego: "+ this.mostrarJuego());
                        System.out.println("Fichas (jugador 2): "+ jugador2.mostrarFichas());
                        System.out.println("Seleccione la ficha: ");
                        int indFicha = 0;
                        try {
                            indFicha = escan.nextInt();
                        }catch(InputMismatchException e){
                            System.out.println("El indice debe ser un numero.");
                        }
                        if(indFicha>0){
                            if(this.tieneNumero(jugador2.getFichas(), 6)){
                                if(jugador2.getFichas().get(indFicha-1).getLado1() == 6
                                    && jugador2.getFichas().get(indFicha-1).getLado2() == 6){
                                    juego.add(jugador2.getFichas().get(indFicha-1));
                                    jugador2.getFichas().remove(indFicha-1);
                                    turno = 1;
                                }else{
                                    System.out.println("Debe ingresar el doble 6");
                                }  
                            }
                            else{
                                if(jugador2.getFichas().get(indFicha-1).getLado2() == juego.get(0).getLado1()){
                                    juego.add(0,jugador2.getFichas().get(indFicha-1));
                                    jugador2.getFichas().remove(indFicha-1);
                                    turno = 1;
                                }else{
                                    if(jugador2.getFichas().get(indFicha-1).getLado1() == juego.get(juego.size()-1).getLado2()){
                                        juego.add(jugador2.getFichas().get(indFicha-1));
                                        jugador2.getFichas().remove(indFicha-1);
                                        turno = 1;
                                    }else{
                                        if(jugador2.getFichas().get(indFicha-1).getLado1() == juego.get(0).getLado1()){
                                            jugador2.getFichas().get(indFicha-1).voltear();
                                            juego.add(0,jugador2.getFichas().get(indFicha-1));
                                            jugador2.getFichas().remove(indFicha-1);
                                            turno = 1;
                                        }else{
                                            if(jugador2.getFichas().get(indFicha-1).getLado2() == juego.get(juego.size()-1).getLado2()){
                                                jugador2.getFichas().get(indFicha-1).voltear();
                                                juego.add(jugador2.getFichas().get(indFicha-1));
                                                jugador2.getFichas().remove(indFicha-1);
                                                turno = 1;
                                            }else{
                                            System.out.println("Ingrese un numero valido");
                                            } 
                                        }
                                    } 
                                }
                            }
                        }
                        if(indFicha == -1){
                            turno = 1;
                        }
                        if(indFicha ==-2){
                            System.out.println("!!Han empatado por que el juego se ha ahogado¡¡");
                            int var1 = jugador2.getScore();
                            var1 = var1 + 250;
                            jugador2.setScore(var1);
                            int var2 = jugador1.getScore();
                            var2 = var2 + 250;
                            jugador2.setScore(var2);
                            System.out.println("Juego: "+ this.mostrarJuego());
                            System.out.println("Datos (jugador 1): "+ jugador1.mostrarDatos());
                            System.out.println("Datos (jugador 2): "+ jugador2.mostrarDatos());
                            System.out.println("Quieres seguir jugando?(s para si, n para no)");
                            String seleccion = escan.next();
                            if(seleccion.equals("s")){
                                juego = null;
                                juego = new ArrayList();
                                jugador1.setFichas(null);
                                jugador2.setFichas(null);
                                repartir(jugador1,jugador2);
                                turno= 0;
                            }else{
                                break;
                            }
                        }
                    }
                    
                }
            }
            if(Njugadores == 3){
                if(turno == 0){
                    if(tieneNumero(jugador1.getFichas(), 6)){
                        this.turno = 1;
                    }else{
                            if(tieneNumero(jugador2.getFichas(), 6)){
                            this.turno = 2;
                            }else{
                                if(tieneNumero(jugador3.getFichas(), 6)){
                                    this.turno = 3;
                                }
                            }
                        }    
                    }
                
                if(turno == 1){
                    if(jugador3.getFichas().isEmpty()){
                        System.out.println("!!Felicidades "+ jugador3.getNombre()+" has ganado¡¡");
                        int var = jugador3.getScore();
                        var = var + 500;
                        jugador3.setScore(var);
                        System.out.println("Juego: "+ this.mostrarJuego());
                        System.out.println("Datos (jugador 1): "+ jugador1.mostrarDatos());
                        System.out.println("Datos (jugador 2): "+ jugador2.mostrarDatos());
                        System.out.println("Datos (jugador 3): "+ jugador3.mostrarDatos());
                        System.out.println("Quieres seguir jugando?(s para si, n para no)");
                        String seleccion = escan.next();
                        if(seleccion.equals("s")){
                            juego = null;
                            juego = new ArrayList();
                            jugador1.setFichas(null);
                            jugador2.setFichas(null);
                            jugador3.setFichas(null);
                            repartir(jugador1,jugador2,jugador3);
                            turno= 0;
                        }else{
                            break;
                        }
                    }else{
                        System.out.println("Juego: "+ this.mostrarJuego());
                        System.out.println("Fichas(jugador 1): "+ jugador1.mostrarFichas());
                        System.out.println("Seleccione la ficha: ");
                        int indFicha = 0;
                        try {
                            indFicha = escan.nextInt();
                        }catch(InputMismatchException e){
                            System.out.println("El indice debe ser un numero.");
                        }
                        if(indFicha>0){
                            if(this.tieneNumero(jugador1.getFichas(), 6)){
                                if(jugador1.getFichas().get(indFicha-1).getLado1() == 6
                                    && jugador1.getFichas().get(indFicha-1).getLado2() == 6){
                                    juego.add(jugador1.getFichas().get(indFicha-1));
                                    jugador1.getFichas().remove(indFicha-1);
                                    turno = 2;
                                }else{
                                    System.out.println("Debe ingresar el doble 6");
                                }  
                            }
                            else{
                                if(jugador1.getFichas().get(indFicha-1).getLado2() == juego.get(0).getLado1()){
                                    juego.add(0,jugador1.getFichas().get(indFicha-1));
                                    jugador1.getFichas().remove(indFicha-1);
                                    turno = 2;
                                }else{
                                    if(jugador1.getFichas().get(indFicha-1).getLado1() == juego.get(juego.size()-1).getLado2()){
                                        juego.add(jugador1.getFichas().get(indFicha-1));
                                        jugador1.getFichas().remove(indFicha-1);
                                        turno = 2;
                                    }else{
                                        if(jugador1.getFichas().get(indFicha-1).getLado1() == juego.get(0).getLado1()){
                                            jugador1.getFichas().get(indFicha-1).voltear();
                                            juego.add(0,jugador1.getFichas().get(indFicha-1));
                                            jugador1.getFichas().remove(indFicha-1);
                                            turno = 2;
                                        }else{
                                            if(jugador1.getFichas().get(indFicha-1).getLado2() == juego.get(juego.size()-1).getLado2()){
                                                jugador1.getFichas().get(indFicha-1).voltear();
                                                juego.add(jugador1.getFichas().get(indFicha-1));
                                                jugador1.getFichas().remove(indFicha-1);
                                                turno = 2;
                                            }else{
                                            System.out.println("Ingrese un numero valido");
                                            } 
                                        }
                                    } 
                                }
                            }
                        }
                        if(indFicha == -1){
                            turno = 2;
                        }
                        if(indFicha == -2){
                            System.out.println("!!Han empatado por que el juego se ha ahogado¡¡");
                            int var1 = jugador2.getScore();
                            var1 = var1 + 250;
                            jugador2.setScore(var1);
                            int var2 = jugador1.getScore();
                            var2 = var2 + 250;
                            jugador2.setScore(var2);
                            int var3 = jugador3.getScore();
                            var3 = var3 + 250;
                            jugador2.setScore(var3);
                            System.out.println("Juego: "+ this.mostrarJuego());
                            System.out.println("Datos (jugador 1): "+ jugador1.mostrarDatos());
                            System.out.println("Datos (jugador 2): "+ jugador2.mostrarDatos());
                            System.out.println("Datos (jugador 3): "+ jugador3.mostrarDatos());
                            System.out.println("Quieres seguir jugando?(s para si, n para no)");
                            String seleccion = escan.next();
                            if(seleccion.equals("s")){
                                juego = null;
                                juego = new ArrayList();
                                jugador1.setFichas(null);
                                jugador2.setFichas(null);
                                jugador3.setFichas(null);
                                jugador4.setFichas(null);
                                repartir(jugador1,jugador2,jugador3);
                                turno= 0;
                            }else{
                                break;
                            }
                        }
                    }
                }if(turno == 2){
                    if(jugador1.getFichas().isEmpty()){
                        System.out.println("!!Felicidades "+ jugador1.getNombre()+" has ganado¡¡");
                        int var = jugador1.getScore();
                        var = var + 500;
                        jugador1.setScore(var);
                        System.out.println("Juego: "+ this.mostrarJuego());
                        System.out.println("Datos (jugador 1): "+ jugador1.mostrarDatos());
                        System.out.println("Datos (jugador 2): "+ jugador2.mostrarDatos());
                        System.out.println("Datos (jugador 3): "+ jugador3.mostrarDatos());
                        System.out.println("Quieres seguir jugando?(s para si, n para no)");
                        String seleccion = escan.next();
                        if(seleccion.equals("s")){
                            juego = null;
                            juego = new ArrayList();
                            jugador1.setFichas(null);
                            jugador2.setFichas(null);
                            jugador3.setFichas(null);
                            repartir(jugador1,jugador2,jugador3);
                            turno = 0;
                        }else{
                            break;
                        }
                    }else{
                        System.out.println("Juego: "+ this.mostrarJuego());
                        System.out.println("Fichas (jugador 2): "+ jugador2.mostrarFichas());
                        System.out.println("Seleccione la ficha: ");
                        int indFicha = 0;
                        try {
                            indFicha = escan.nextInt();
                        }catch(InputMismatchException e){
                            System.out.println("El indice debe ser un numero.");
                        }
                        if(indFicha>0){
                            if(this.tieneNumero(jugador2.getFichas(), 6)){
                                if(jugador2.getFichas().get(indFicha-1).getLado1() == 6
                                    && jugador2.getFichas().get(indFicha-1).getLado2() == 6){
                                    juego.add(jugador2.getFichas().get(indFicha-1));
                                    jugador2.getFichas().remove(indFicha-1);
                                    turno = 3;
                                }else{
                                    System.out.println("Debe ingresar el doble 6");
                                }  
                            }
                            else{
                                if(jugador2.getFichas().get(indFicha-1).getLado2() == juego.get(0).getLado1()){
                                    juego.add(0,jugador2.getFichas().get(indFicha-1));
                                    jugador2.getFichas().remove(indFicha-1);
                                    turno = 3;
                                }else{
                                    if(jugador2.getFichas().get(indFicha-1).getLado1() == juego.get(juego.size()-1).getLado2()){
                                        juego.add(jugador2.getFichas().get(indFicha-1));
                                        jugador2.getFichas().remove(indFicha-1);
                                        turno = 3;
                                    }else{
                                        if(jugador2.getFichas().get(indFicha-1).getLado1() == juego.get(0).getLado1()){
                                            jugador2.getFichas().get(indFicha-1).voltear();
                                            juego.add(0,jugador2.getFichas().get(indFicha-1));
                                            jugador2.getFichas().remove(indFicha-1);
                                            turno = 3;
                                        }else{
                                            if(jugador2.getFichas().get(indFicha-1).getLado2() == juego.get(juego.size()-1).getLado2()){
                                                jugador2.getFichas().get(indFicha-1).voltear();
                                                juego.add(jugador2.getFichas().get(indFicha-1));
                                                jugador2.getFichas().remove(indFicha-1);
                                                turno = 3;
                                            }else{
                                            System.out.println("Ingrese un numero valido");
                                            } 
                                        }
                                    } 
                                }
                            }
                        }
                        if(indFicha == -1){
                            turno = 3;
                        }
                        if(indFicha ==-2){
                            System.out.println("!!Han empatado por que el juego se ha ahogado¡¡");
                            int var1 = jugador1.getScore();
                            var1 = var1 + 250;
                            jugador1.setScore(var1);
                            int var2 = jugador2.getScore();
                            var2 = var2 + 250;
                            jugador2.setScore(var2);
                            int var3 = jugador3.getScore();
                            var3 = var3 + 250;
                            jugador3.setScore(var3);
                            System.out.println("Juego: "+ this.mostrarJuego());
                            System.out.println("Datos (jugador 1): "+ jugador1.mostrarDatos());
                            System.out.println("Datos (jugador 2): "+ jugador2.mostrarDatos());
                            System.out.println("Datos (jugador 3): "+ jugador3.mostrarDatos());
                            System.out.println("Quieres seguir jugando?(s para si, n para no)");
                            String seleccion = escan.next();
                            if(seleccion.equals("s")){
                                juego = null;
                                juego = new ArrayList();
                                jugador1.setFichas(null);
                                jugador2.setFichas(null);
                                jugador3.setFichas(null);
                                repartir(jugador1,jugador2,jugador3);
                                turno= 0;
                            }else{
                                break;
                            }
                        }
                    }
                }
                if(turno == 3){
                    if(jugador2.getFichas().isEmpty()){
                        System.out.println("!!Felicidades "+ jugador2.getNombre()+" has ganado¡¡");
                        int var = jugador2.getScore();
                        var = var + 500;
                        jugador2.setScore(var);
                        System.out.println("Juego: "+ this.mostrarJuego());
                        System.out.println("Datos (jugador 1): "+ jugador1.mostrarDatos());
                        System.out.println("Datos (jugador 2): "+ jugador2.mostrarDatos());
                        System.out.println("Datos (jugador 3): "+ jugador3.mostrarDatos());
                        System.out.println("Quieres seguir jugando?(s para si, n para no)");
                        String seleccion = escan.next();
                        if(seleccion.equals("s")){
                            juego = null;
                            juego = new ArrayList();
                            jugador1.setFichas(null);
                            jugador2.setFichas(null);
                            jugador3.setFichas(null);
                            repartir(jugador1,jugador2,jugador3);
                            turno= 0;
                        }else{
                            break;
                        }
                    }else{
                        System.out.println("Juego: "+ this.mostrarJuego());
                        System.out.println("Fichas(jugador 3): "+ jugador3.mostrarFichas());
                        System.out.println("Seleccione la ficha: ");
                        int indFicha = 0;
                        try {
                            indFicha = escan.nextInt();
                        }catch(InputMismatchException e){
                            System.out.println("El indice debe ser un numero.");
                        }
                        if(indFicha>0){
                            if(this.tieneNumero(jugador3.getFichas(), 6)){
                                if(jugador3.getFichas().get(indFicha-1).getLado1() == 6
                                    && jugador3.getFichas().get(indFicha-1).getLado2() == 6){
                                    juego.add(jugador3.getFichas().get(indFicha-1));
                                    jugador3.getFichas().remove(indFicha-1);
                                    turno = 1;
                                }else{
                                    System.out.println("Debe ingresar el doble 6");
                                }  
                            }
                            else{
                                if(jugador3.getFichas().get(indFicha-1).getLado2() == juego.get(0).getLado1()){
                                    juego.add(0,jugador3.getFichas().get(indFicha-1));
                                    jugador3.getFichas().remove(indFicha-1);
                                    turno = 1;
                                }else{
                                    if(jugador3.getFichas().get(indFicha-1).getLado1() == juego.get(juego.size()-1).getLado2()){
                                        juego.add(jugador3.getFichas().get(indFicha-1));
                                        jugador3.getFichas().remove(indFicha-1);
                                        turno = 1;
                                    }else{
                                        if(jugador3.getFichas().get(indFicha-1).getLado1() == juego.get(0).getLado1()){
                                            jugador3.getFichas().get(indFicha-1).voltear();
                                            juego.add(0,jugador3.getFichas().get(indFicha-1));
                                            jugador3.getFichas().remove(indFicha-1);
                                            turno = 1;
                                        }else{
                                            if(jugador3.getFichas().get(indFicha-1).getLado2() == juego.get(juego.size()-1).getLado2()){
                                                jugador3.getFichas().get(indFicha-1).voltear();
                                                juego.add(jugador3.getFichas().get(indFicha-1));
                                                jugador3.getFichas().remove(indFicha-1);
                                                turno = 1;
                                            }else{
                                            System.out.println("Ingrese un numero valido");
                                            } 
                                        }
                                    } 
                                }
                            }
                        }
                        if(indFicha == -1){
                            turno = 1;
                        }
                        if(indFicha == -2){
                            System.out.println("!!Han empatado por que el juego se ha ahogado¡¡");
                            int var1 = jugador2.getScore();
                            var1 = var1 + 250;
                            jugador2.setScore(var1);
                            int var2 = jugador1.getScore();
                            var2 = var2 + 250;
                            jugador1.setScore(var2);
                            int var3= jugador3.getScore();
                            var3 = var3 + 250;
                            jugador3.setScore(var3);
                            System.out.println("Juego: "+ this.mostrarJuego());
                            System.out.println("Datos (jugador 1): "+ jugador1.mostrarDatos());
                            System.out.println("Datos (jugador 2): "+ jugador2.mostrarDatos());
                            System.out.println("Datos (jugador 3): "+ jugador3.mostrarDatos());
                            System.out.println("Quieres seguir jugando?(s para si, n para no)");
                            String seleccion = escan.next();
                            if(seleccion.equals("s")){
                                juego = null;
                                juego = new ArrayList();
                                jugador1.setFichas(null);
                                jugador2.setFichas(null);
                                jugador3.setFichas(null);
                                repartir(jugador1,jugador2,jugador3);
                                turno= 0;
                            }else{
                                break;
                            }
                        }
                    }
                }
            }
            if(Njugadores == 4){
                if(turno == 0){
                    if(tieneNumero(jugador1.getFichas(), 6)){
                        this.turno = 1;
                    }else{
                            if(tieneNumero(jugador2.getFichas(), 6)){
                            this.turno = 2;
                            }else{
                                if(tieneNumero(jugador3.getFichas(), 6)){
                                    this.turno = 3;
                                }else{
                                    if(tieneNumero(jugador4.getFichas(), 6)){
                                        this.turno = 4;
                                    }
                                }
                            }
                        }    
                    }
                
                if(turno == 1){
                    if(jugador4.getFichas().isEmpty()){
                        System.out.println("!!Felicidades "+ jugador4.getNombre()+" has ganado¡¡");
                        int var = jugador4.getScore();
                        var = var + 500;
                        jugador4.setScore(var);
                        System.out.println("Juego: "+ this.mostrarJuego());
                        System.out.println("Datos (jugador 1): "+ jugador1.mostrarDatos());
                        System.out.println("Datos (jugador 2): "+ jugador2.mostrarDatos());
                        System.out.println("Datos (jugador 3): "+ jugador3.mostrarDatos());
                        System.out.println("Datos (jugador 4): "+ jugador4.mostrarDatos());
                        System.out.println("Quieres seguir jugando?(s para si, n para no)");
                        String seleccion = escan.next();
                        if(seleccion.equals("s")){
                            juego = null;
                            juego = new ArrayList();
                            jugador1.setFichas(null);
                            jugador2.setFichas(null);
                            jugador3.setFichas(null);
                            jugador4.setFichas(null);
                            repartir(jugador1,jugador2,jugador3,jugador4);
                            turno= 0;
                        }else{
                            break;
                        }
                    }else{
                        System.out.println("Juego: "+ this.mostrarJuego());
                        System.out.println("Fichas(jugador 1): "+ jugador1.mostrarFichas());
                        System.out.println("Seleccione la ficha: ");
                        int indFicha = 0;
                        try {
                            indFicha = escan.nextInt();
                        }catch(InputMismatchException e){
                            System.out.println("El indice debe ser un numero.");
                        }
                        if(indFicha>0){
                            if(this.tieneNumero(jugador1.getFichas(), 6)){
                                if(jugador1.getFichas().get(indFicha-1).getLado1() == 6
                                    && jugador1.getFichas().get(indFicha-1).getLado2() == 6){
                                    juego.add(jugador1.getFichas().get(indFicha-1));
                                    jugador1.getFichas().remove(indFicha-1);
                                    turno = 2;
                                }else{
                                    System.out.println("Debe ingresar el doble 6");
                                }  
                            }
                            else{
                                if(jugador1.getFichas().get(indFicha-1).getLado2() == juego.get(0).getLado1()){
                                    juego.add(0,jugador1.getFichas().get(indFicha-1));
                                    jugador1.getFichas().remove(indFicha-1);
                                    turno = 2;
                                }else{
                                    if(jugador1.getFichas().get(indFicha-1).getLado1() == juego.get(juego.size()-1).getLado2()){
                                        juego.add(jugador1.getFichas().get(indFicha-1));
                                        jugador1.getFichas().remove(indFicha-1);
                                        turno = 2;
                                    }else{
                                        if(jugador1.getFichas().get(indFicha-1).getLado1() == juego.get(0).getLado1()){
                                            jugador1.getFichas().get(indFicha-1).voltear();
                                            juego.add(0,jugador1.getFichas().get(indFicha-1));
                                            jugador1.getFichas().remove(indFicha-1);
                                            turno = 2;
                                        }else{
                                            if(jugador1.getFichas().get(indFicha-1).getLado2() == juego.get(juego.size()-1).getLado2()){
                                                jugador1.getFichas().get(indFicha-1).voltear();
                                                juego.add(jugador1.getFichas().get(indFicha-1));
                                                jugador1.getFichas().remove(indFicha-1);
                                                turno = 2;
                                            }else{
                                            System.out.println("Ingrese un numero valido");
                                            } 
                                        }
                                    } 
                                }
                            }
                        }
                        if(indFicha == -1){
                            turno = 2;
                        }
                        if(indFicha == -2){
                            System.out.println("!!Han empatado por que el juego se ha ahogado¡¡");
                            int var1 = jugador2.getScore();
                            var1 = var1 + 250;
                            jugador2.setScore(var1);
                            int var2 = jugador1.getScore();
                            var2 = var2 + 250;
                            jugador2.setScore(var2);
                            int var3 = jugador3.getScore();
                            var3 = var3 + 250;
                            jugador2.setScore(var3);
                            int var4 = jugador4.getScore();
                            var4 = var4 + 250;
                            jugador4.setScore(var4);
                            System.out.println("Juego: "+ this.mostrarJuego());
                            System.out.println("Datos (jugador 1): "+ jugador1.mostrarDatos());
                            System.out.println("Datos (jugador 2): "+ jugador2.mostrarDatos());
                            System.out.println("Datos (jugador 3): "+ jugador3.mostrarDatos());
                            System.out.println("Datos (jugador 3): "+ jugador4.mostrarDatos());
                            System.out.println("Quieres seguir jugando?(s para si, n para no)");
                            String seleccion = escan.next();
                            if(seleccion.equals("s")){
                                juego = null;
                                juego = new ArrayList();
                                jugador1.setFichas(null);
                                jugador2.setFichas(null);
                                jugador3.setFichas(null);
                                jugador4.setFichas(null);
                                repartir(jugador1,jugador2,jugador3,jugador4);
                                turno= 0;
                            }else{
                                break;
                            }
                        }
                    }
                }if(turno == 2){
                    if(jugador1.getFichas().isEmpty()){
                        System.out.println("!!Felicidades "+ jugador1.getNombre()+" has ganado¡¡");
                        int var = jugador1.getScore();
                        var = var + 500;
                        jugador1.setScore(var);
                        System.out.println("Juego: "+ this.mostrarJuego());
                        System.out.println("Datos (jugador 1): "+ jugador1.mostrarDatos());
                        System.out.println("Datos (jugador 2): "+ jugador2.mostrarDatos());
                        System.out.println("Datos (jugador 3): "+ jugador3.mostrarDatos());
                        System.out.println("Datos (jugador 4): "+ jugador4.mostrarDatos());
                        System.out.println("Quieres seguir jugando?(s para si, n para no)");
                        String seleccion = escan.next();
                        if(seleccion.equals("s")){
                            juego = null;
                            juego = new ArrayList();
                            jugador1.setFichas(null);
                            jugador2.setFichas(null);
                            jugador3.setFichas(null);
                            jugador4.setFichas(null);
                            repartir(jugador1,jugador2,jugador3,jugador4);
                            turno = 0;
                        }else{
                            break;
                        }
                    }else{
                        System.out.println("Juego: "+ this.mostrarJuego());
                        System.out.println("Fichas (jugador 2): "+ jugador2.mostrarFichas());
                        System.out.println("Seleccione la ficha: ");
                        int indFicha = 0;
                        try {
                            indFicha = escan.nextInt();
                        }catch(InputMismatchException e){
                            System.out.println("El indice debe ser un numero.");
                        }
                        if(indFicha>0){
                            if(this.tieneNumero(jugador2.getFichas(), 6)){
                                if(jugador2.getFichas().get(indFicha-1).getLado1() == 6
                                    && jugador2.getFichas().get(indFicha-1).getLado2() == 6){
                                    juego.add(jugador2.getFichas().get(indFicha-1));
                                    jugador2.getFichas().remove(indFicha-1);
                                    turno = 3;
                                }else{
                                    System.out.println("Debe ingresar el doble 6");
                                }  
                            }
                            else{
                                if(jugador2.getFichas().get(indFicha-1).getLado2() == juego.get(0).getLado1()){
                                    juego.add(0,jugador2.getFichas().get(indFicha-1));
                                    jugador2.getFichas().remove(indFicha-1);
                                    turno = 3;
                                }else{
                                    if(jugador2.getFichas().get(indFicha-1).getLado1() == juego.get(juego.size()-1).getLado2()){
                                        juego.add(jugador2.getFichas().get(indFicha-1));
                                        jugador2.getFichas().remove(indFicha-1);
                                        turno = 3;
                                    }else{
                                        if(jugador2.getFichas().get(indFicha-1).getLado1() == juego.get(0).getLado1()){
                                            jugador2.getFichas().get(indFicha-1).voltear();
                                            juego.add(0,jugador2.getFichas().get(indFicha-1));
                                            jugador2.getFichas().remove(indFicha-1);
                                            turno = 3;
                                        }else{
                                            if(jugador2.getFichas().get(indFicha-1).getLado2() == juego.get(juego.size()-1).getLado2()){
                                                jugador2.getFichas().get(indFicha-1).voltear();
                                                juego.add(jugador2.getFichas().get(indFicha-1));
                                                jugador2.getFichas().remove(indFicha-1);
                                                turno = 3;
                                            }else{
                                            System.out.println("Ingrese un numero valido");
                                            } 
                                        }
                                    } 
                                }
                            }
                        }
                        if(indFicha == -1){
                            turno = 3;
                        }
                        if(indFicha ==-2){
                            System.out.println("!!Han empatado por que el juego se ha ahogado¡¡");
                            int var1 = jugador1.getScore();
                            var1 = var1 + 250;
                            jugador1.setScore(var1);
                            int var2 = jugador2.getScore();
                            var2 = var2 + 250;
                            jugador2.setScore(var2);
                            int var3 = jugador3.getScore();
                            var3 = var3 + 250;
                            jugador3.setScore(var3);
                            int var4 = jugador4.getScore();
                            var4 = var4 + 250;
                            jugador4.setScore(var4);
                            System.out.println("Juego: "+ this.mostrarJuego());
                            System.out.println("Datos (jugador 1): "+ jugador1.mostrarDatos());
                            System.out.println("Datos (jugador 2): "+ jugador2.mostrarDatos());
                            System.out.println("Datos (jugador 3): "+ jugador3.mostrarDatos());
                            System.out.println("Datos (jugador 4): "+ jugador4.mostrarDatos());
                            System.out.println("Quieres seguir jugando?(s para si, n para no)");
                            String seleccion = escan.next();
                            if(seleccion.equals("s")){
                                juego = null;
                                juego = new ArrayList();
                                jugador1.setFichas(null);
                                jugador2.setFichas(null);
                                jugador3.setFichas(null);
                                jugador4.setFichas(null);
                                repartir(jugador1,jugador2,jugador3,jugador4);
                                turno= 0;
                            }else{
                                break;
                            }
                        }
                    }
                }
                if(turno == 3){
                    if(jugador2.getFichas().isEmpty()){
                        System.out.println("!!Felicidades "+ jugador2.getNombre()+" has ganado¡¡");
                        int var = jugador2.getScore();
                        var = var + 500;
                        jugador2.setScore(var);
                        System.out.println("Juego: "+ this.mostrarJuego());
                        System.out.println("Datos (jugador 1): "+ jugador1.mostrarDatos());
                        System.out.println("Datos (jugador 2): "+ jugador2.mostrarDatos());
                        System.out.println("Datos (jugador 3): "+ jugador3.mostrarDatos());
                        System.out.println("Datos (jugador 4): "+ jugador4.mostrarDatos());
                        System.out.println("Quieres seguir jugando?(s para si, n para no)");
                        String seleccion = escan.next();
                        if(seleccion.equals("s")){
                            juego = null;
                            juego = new ArrayList();
                            jugador1.setFichas(null);
                            jugador2.setFichas(null);
                            jugador3.setFichas(null);
                            jugador4.setFichas(null);
                            repartir(jugador1,jugador2,jugador3,jugador4);
                            turno= 0;
                        }else{
                            break;
                        }
                    }else{
                        System.out.println("Juego: "+ this.mostrarJuego());
                        System.out.println("Fichas(jugador 3): "+ jugador3.mostrarFichas());
                        System.out.println("Seleccione la ficha: ");
                        int indFicha = 0;
                        try {
                            indFicha = escan.nextInt();
                        }catch(InputMismatchException e){
                            System.out.println("El indice debe ser un numero.");
                        }
                        if(indFicha>0){
                            if(this.tieneNumero(jugador3.getFichas(), 6)){
                                if(jugador3.getFichas().get(indFicha-1).getLado1() == 6
                                    && jugador3.getFichas().get(indFicha-1).getLado2() == 6){
                                    juego.add(jugador3.getFichas().get(indFicha-1));
                                    jugador3.getFichas().remove(indFicha-1);
                                    turno = 4;
                                }else{
                                    System.out.println("Debe ingresar el doble 6");
                                }  
                            }
                            else{
                                if(jugador3.getFichas().get(indFicha-1).getLado2() == juego.get(0).getLado1()){
                                    juego.add(0,jugador3.getFichas().get(indFicha-1));
                                    jugador3.getFichas().remove(indFicha-1);
                                    turno = 4;
                                }else{
                                    if(jugador3.getFichas().get(indFicha-1).getLado1() == juego.get(juego.size()-1).getLado2()){
                                        juego.add(jugador3.getFichas().get(indFicha-1));
                                        jugador3.getFichas().remove(indFicha-1);
                                        turno = 4;
                                    }else{
                                        if(jugador3.getFichas().get(indFicha-1).getLado1() == juego.get(0).getLado1()){
                                            jugador3.getFichas().get(indFicha-1).voltear();
                                            juego.add(0,jugador3.getFichas().get(indFicha-1));
                                            jugador3.getFichas().remove(indFicha-1);
                                            turno = 4;
                                        }else{
                                            if(jugador3.getFichas().get(indFicha-1).getLado2() == juego.get(juego.size()-1).getLado2()){
                                                jugador3.getFichas().get(indFicha-1).voltear();
                                                juego.add(jugador3.getFichas().get(indFicha-1));
                                                jugador3.getFichas().remove(indFicha-1);
                                                turno = 4;
                                            }else{
                                            System.out.println("Ingrese un numero valido");
                                            } 
                                        }
                                    } 
                                }
                            }
                        }
                        if(indFicha == -1){
                            turno = 4;
                        }
                        if(indFicha == -2){
                            System.out.println("!!Han empatado por que el juego se ha ahogado¡¡");
                            int var1 = jugador2.getScore();
                            var1 = var1 + 250;
                            jugador2.setScore(var1);
                            int var2 = jugador1.getScore();
                            var2 = var2 + 250;
                            jugador1.setScore(var2);
                            int var3= jugador3.getScore();
                            var3 = var3 + 250;
                            jugador3.setScore(var3);
                            int var4= jugador4.getScore();
                            var4 = var4 + 250;
                            jugador3.setScore(var4);
                            System.out.println("Juego: "+ this.mostrarJuego());
                            System.out.println("Datos (jugador 1): "+ jugador1.mostrarDatos());
                            System.out.println("Datos (jugador 2): "+ jugador2.mostrarDatos());
                            System.out.println("Datos (jugador 3): "+ jugador3.mostrarDatos());
                            System.out.println("Datos (jugador 4): "+ jugador4.mostrarDatos());
                            System.out.println("Quieres seguir jugando?(s para si, n para no)");
                            String seleccion = escan.next();
                            if(seleccion.equals("s")){
                                juego = null;
                                juego = new ArrayList();
                                jugador1.setFichas(null);
                                jugador2.setFichas(null);
                                jugador3.setFichas(null);
                                jugador4.setFichas(null);
                                repartir(jugador1,jugador2,jugador3,jugador4);
                                turno= 0;
                            }else{
                                break;
                            }
                        }
                    }
                }
                if(turno == 4){
                    if(jugador3.getFichas().isEmpty()){
                        System.out.println("!!Felicidades "+ jugador3.getNombre()+" has ganado¡¡");
                        int var = jugador3.getScore();
                        var = var + 500;
                        jugador3.setScore(var);
                        System.out.println("Juego: "+ this.mostrarJuego());
                        System.out.println("Datos (jugador 1): "+ jugador1.mostrarDatos());
                        System.out.println("Datos (jugador 2): "+ jugador2.mostrarDatos());
                        System.out.println("Datos (jugador 3): "+ jugador3.mostrarDatos());
                        System.out.println("Datos (jugador 4): "+ jugador4.mostrarDatos());
                        System.out.println("Quieres seguir jugando?(s para si, n para no)");
                        String seleccion = escan.next();
                        if(seleccion.equals("s")){
                            juego = null;
                            juego = new ArrayList();
                            jugador1.setFichas(null);
                            jugador2.setFichas(null);
                            jugador3.setFichas(null);
                            jugador4.setFichas(null);
                            repartir(jugador1,jugador2,jugador3,jugador4);
                            turno= 0;
                        }else{
                            break;
                        }
                    }else{
                        System.out.println("Juego: "+ this.mostrarJuego());
                        System.out.println("Fichas(jugador 4): "+ jugador4.mostrarFichas());
                        System.out.println("Seleccione la ficha: ");
                        int indFicha = 0;
                        try {
                            indFicha = escan.nextInt();
                        }catch(InputMismatchException e){
                            System.out.println("El indice debe ser un numero.");
                        }
                        if(indFicha>0){
                            if(this.tieneNumero(jugador4.getFichas(), 6)){
                                if(jugador4.getFichas().get(indFicha-1).getLado1() == 6
                                    && jugador4.getFichas().get(indFicha-1).getLado2() == 6){
                                    juego.add(jugador4.getFichas().get(indFicha-1));
                                    jugador4.getFichas().remove(indFicha-1);
                                    turno = 1;
                                }else{
                                    System.out.println("Debe ingresar el doble 6");
                                }  
                            }
                            else{
                                if(jugador4.getFichas().get(indFicha-1).getLado2() == juego.get(0).getLado1()){
                                    juego.add(0,jugador4.getFichas().get(indFicha-1));
                                    jugador4.getFichas().remove(indFicha-1);
                                    turno = 1;
                                }else{
                                    if(jugador4.getFichas().get(indFicha-1).getLado1() == juego.get(juego.size()-1).getLado2()){
                                        juego.add(jugador4.getFichas().get(indFicha-1));
                                        jugador4.getFichas().remove(indFicha-1);
                                        turno = 1;
                                    }else{
                                        if(jugador4.getFichas().get(indFicha-1).getLado1() == juego.get(0).getLado1()){
                                            jugador4.getFichas().get(indFicha-1).voltear();
                                            juego.add(0,jugador4.getFichas().get(indFicha-1));
                                            jugador4.getFichas().remove(indFicha-1);
                                            turno = 1;
                                        }else{
                                            if(jugador4.getFichas().get(indFicha-1).getLado2() == juego.get(juego.size()-1).getLado2()){
                                                jugador4.getFichas().get(indFicha-1).voltear();
                                                juego.add(jugador4.getFichas().get(indFicha-1));
                                                jugador4.getFichas().remove(indFicha-1);
                                                turno = 1;
                                            }else{
                                            System.out.println("Ingrese un numero valido");
                                            } 
                                        }
                                    } 
                                }
                            }
                        }
                        if(indFicha == -1){
                            turno = 1;
                        }
                        if(indFicha == -2){
                            System.out.println("!!Han empatado por que el juego se ha ahogado¡¡");
                            int var1 = jugador2.getScore();
                            var1 = var1 + 250;
                            jugador2.setScore(var1);
                            int var2 = jugador1.getScore();
                            var2 = var2 + 250;
                            jugador1.setScore(var2);
                            int var3= jugador3.getScore();
                            var3 = var3 + 250;
                            jugador3.setScore(var3);
                            int var4= jugador4.getScore();
                            var4 = var4 + 250;
                            jugador3.setScore(var4);
                            System.out.println("Juego: "+ this.mostrarJuego());
                            System.out.println("Datos (jugador 1): "+ jugador1.mostrarDatos());
                            System.out.println("Datos (jugador 2): "+ jugador2.mostrarDatos());
                            System.out.println("Datos (jugador 3): "+ jugador3.mostrarDatos());
                            System.out.println("Datos (jugador 4): "+ jugador4.mostrarDatos());
                            System.out.println("Quieres seguir jugando?(s para si, n para no)");
                            String seleccion = escan.next();
                            if(seleccion.equals("s")){
                                juego = null;
                                juego = new ArrayList();
                                jugador1.setFichas(null);
                                jugador2.setFichas(null);
                                jugador3.setFichas(null);
                                jugador4.setFichas(null);
                                repartir(jugador1,jugador2,jugador3,jugador4);
                                turno= 0;
                            }else{
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
}
