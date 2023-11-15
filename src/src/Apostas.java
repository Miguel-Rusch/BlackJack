/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.Scanner;

/**
 *
 * @author 182220058
 */
public class Apostas {
    int SaldoP1;
    int SaldoP2;
    int ApostaP1;
    int ApostaP2;
    int vencedorP1;
    int vencedorP2;
    int numPartidas;
    int numJogador;

    public int getNumJogador() {
        return numJogador;
    }

    public void setNumJogador(int numJogador) {
        this.numJogador = numJogador;
    }
    

    public int getNumPartidas() {
        return numPartidas;
    }

    public void setNumPartidas(int numPartidas) {
        this.numPartidas = numPartidas;
    }

    public int getSaldoP1() {
        return SaldoP1;
    }

    public void setSaldoP1(int SaldoP1) {
        this.SaldoP1 = SaldoP1;
    }

    public int getSaldoP2() {
        return SaldoP2;
    }

    public void setSaldoP2(int SaldoP2) {
        this.SaldoP2 = SaldoP2;
    }

    public int getApostaP1() {
        return ApostaP1;
    }

    public void setApostaP1(int ApostaP1) {
        this.ApostaP1 = ApostaP1;
    }

    public int getApostaP2() {
        return ApostaP2;
    }

    public void setApostaP2(int ApostaP2) {
        this.ApostaP2 = ApostaP2;
    }

    public int getVencedorP1() {
        return vencedorP1;
    }

    public void setVencedorP1(int resultadoP1) {
        this.vencedorP1 = resultadoP1;
    }

    public int getVencedorP2() {
        return vencedorP2;
    }

    public void setVencedorP2(int resultadoP2) {
        this.vencedorP2 = resultadoP2;
    }
    
    public void numPartidas(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Quantas partidas vai jogar:");
        int numPartidas = sc.nextInt();
        setNumPartidas(numPartidas);

    }
    public void quantSaldo(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Quanto vai ser o saldo:");
        int saldo = sc.nextInt();
        setSaldoP1(saldo);
        setSaldoP2(saldo);
    }
    public void apostar(){
        Scanner sc = new Scanner(System.in);
        Executar ex = new Executar();
        int aposta = 0;
        do{
        System.out.println("Quanto vai apostar jogador 1:");
         aposta = sc.nextInt();
        setApostaP1(aposta);
        }while(aposta > getSaldoP1() && aposta >= 0);
        setSaldoP1(getSaldoP1() - aposta);
        System.out.println(getNumJogador());
        if(getNumJogador() == 2){
            do{
            System.out.println("Quanto vai apostar jogador 2:");
         aposta = sc.nextInt();
        setApostaP2(aposta);
        }while(aposta > getSaldoP2() && aposta >= 0);
            setSaldoP2(getSaldoP2() - aposta);

        }
        
        
    }
    public void resultado(){
        Scanner sc = new Scanner(System.in);
        Executar ex = new Executar();
        

        
        if(getVencedorP1() == 1){
            setSaldoP1(getSaldoP1() + (getApostaP1()*2));
            setApostaP1(0);
        }else if(getVencedorP1() == 0){
            setSaldoP1(getSaldoP1() + getApostaP1());
            setApostaP1(0);
        }else{
            setApostaP1(0);
        }
        System.out.println("O saldo atual do jogador 1 é:" + getSaldoP1());
        
        if(getNumJogador() == 2){
            if(getVencedorP2() == 1){
            setSaldoP2(getSaldoP2() + (getApostaP2()*2));
            setApostaP2(0);
        }else if(getVencedorP2() == 0){
            setSaldoP2(getSaldoP2() + getApostaP2());
            setApostaP2(0);
        }else{
            setApostaP2(0);
        }
        System.out.println("O saldo atual do jogador 2 é:" + getSaldoP2());
        }
        
        
    }

}
