/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javafx.util.Pair;

/**
 *
 * @author Miguel
 */
public class Executar {
    int numJogador;
    int vencedorP1;
    int vencedorP2;

    public int getVencedorP1() {
        return vencedorP1;
    }

    public void setVencedorP1(int vencedorP1) {
        this.vencedorP1 = vencedorP1;
    }

    public int getVencedorP2() {
        return vencedorP2;
    }

    public void setVencedorP2(int vencedorP2) {
        this.vencedorP2 = vencedorP2;
    }

    public int getNumJogador() {
        return numJogador;
    }

    public void setNumJogador(int numJogador) {
        this.numJogador = numJogador;
    }
    
    public void ex(){
        
        
        Apostas ap = new Apostas();
        
        numJogador();
        ap.setNumJogador(getNumJogador());
        ap.numPartidas();
        ap.quantSaldo();
//       int numPartidas = ap.numPartidas();
       for(int i = 0; i <= ap.getNumPartidas(); i++) {
        if(i > 0){
            System.out.println("====================NOVA PARTIDA=================");
        }
        ap.apostar();
        p1();
        int V1 = getVencedorP1();
        ap.setVencedorP1(V1);
        int V2 = getVencedorP2();
           System.out.println(getVencedorP2());
        ap.setVencedorP2(V2);
        ap.resultado();
        
       }
    }


    public void p1(){
        Apostas ap = new Apostas();
        int numJogador = getNumJogador();
        
        String cartaIncial ="";
        cartaIncial =comeco(true);
        
    
        
    Scanner sc = new Scanner(System.in);
    Baralho bar = new Baralho();
    int pontos  = 0,pontosP2=0;
    boolean p1pont = true, p2pont= true;
    int x = 0;
    String res = "";
    boolean cont = true;
    List<String> cartasDistribuidas = new LinkedList<>();
   cartasDistribuidas.add(cartaIncial);
    do{
    do{
        String carta = bar.distribuir();
        cont = cartasDistribuidas.contains(carta);
        if(cont){
        } else {
            x++;
            System.out.println("A carta do jogador 1 é "+carta);
            pontos = pontos + bar.Transformar(carta);
            cartasDistribuidas.add(carta);
        }
    }while(cont);
//        System.out.println(cartasDistribuidas);
        System.out.println(pontos);
        if(pontos >21){
            p1pont = false;
        }else{
        System.out.println("Quer mais uma carta: ");
        res = sc.next();}
    }while(res.equals("s") && p1pont);
    
    if(numJogador == 2){
    do{
    do{
        String carta = bar.distribuir();
        cont = cartasDistribuidas.contains(carta);
        if(cont){
        } else {
            x++;
            System.out.println("A carta do jogador 2 é "+carta);
            pontosP2 = pontosP2 + bar.Transformar(carta);
            cartasDistribuidas.add(carta);
        }
    }while(cont);
//        System.out.println(cartasDistribuidas);
        System.out.println(pontosP2);
        if(pontosP2 >21){
            p2pont = false;
        }else{
        System.out.println("Quer mais uma carta: ");
        res = sc.next();}
    }while(res.equals("s") && p2pont);
    }
    int pontosMenor= 0;
    if(pontos < pontosP2){
    pontosMenor = pontos;}
    else{
        pontosMenor =pontosP2;
    }
    
    
    int mesaPontos = 0;
        boolean cont1 = true;
        mesaPontos = mesaPontos + bar.Transformar(cartaIncial);
        
        while((mesaPontos < pontosMenor && p1pont && p2pont) && mesaPontos < 18){
        do{
        String carta = bar.distribuir();
        cont1 = cartasDistribuidas.contains(carta);
        if(cont1){
        } else {
            
            System.out.println("A carta da mesa é "+carta);
            mesaPontos = mesaPontos + bar.Transformar(carta);
            cartasDistribuidas.add(carta);
        }
    }while(cont1);
        System.out.println(mesaPontos);
        }
        int vencedorP1 =0;
    if((mesaPontos < pontos && p1pont)|| mesaPontos> 21 && p1pont){
        vencedorP1 = 1;
    }else if((mesaPontos > pontos || !p1pont)&& mesaPontos<= 21){
        vencedorP1 = 2;
    }else{
        vencedorP1 = 0;
    }
        ap.setVencedorP1(vencedorP1);
        setVencedorP1(vencedorP1);
       
        
    switch(vencedorP1){
        case 0: System.out.println("Empate com a mesa");
        break;
        case 1: System.err.println("Jogador 1 venceu da máquina");
        break;
        case 2: System.out.println("Mesa venceu do jogador 1");
    }
    if(numJogador == 2){
        int vencedorP2 =0;
    if((mesaPontos < pontosP2 && p2pont)|| mesaPontos> 21 && p2pont){
        vencedorP2 = 1;
    }else if((mesaPontos > pontosP2 || !p2pont)&& mesaPontos<= 21){
        vencedorP2 = 2;
    }else{
        vencedorP2 = 0;
    }
        ap.setVencedorP2(vencedorP2);
        setVencedorP2(vencedorP2);
    switch(vencedorP2){
        case 0: System.out.println("Empate com a mesa");
        break;
        case 1: System.err.println("Jogador 2 venceu da máquina");
        break;
        case 2: System.out.println("Mesa venceu do jogador 2");
    }
    }
    
    }
    public String comeco(boolean t){
        Baralho bar = new Baralho();
        String carta = bar.distribuir();
        if(t){
        System.out.println("A primeira carta da mesa é: "+carta+ "\n");
        }
        return carta;
    }
    public void mesa(String cartaInicial, List cartasDistribuidas, int pontosP1){
        Baralho bar = new Baralho();
        
        
    }
    public void numJogador(){
         Scanner sc = new Scanner(System.in);
         
         System.out.println("Quantos jogadores vão jogar : (2 ou 1)");
         int num = sc.nextInt();
         setNumJogador(num);
         
         
    }

   
    
    
}
