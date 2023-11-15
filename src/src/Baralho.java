/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Miguel
 */
public class Baralho {
    
    List<String> cartasDistribuidas = new LinkedList<>();

    public List<String> getCartasDistribuidas() {
        return cartasDistribuidas;
    }

    public void setCartasDistribuidas(List<String> cartasDistribuidas) {
        this.cartasDistribuidas = cartasDistribuidas;
    }

  
    
    
    public String[][] arrayBaralho(){
        String baralho[][] = new String[13][4];
        int x = 0;
        String numeroCarta = "", corCarta = "";
        for(int i = 0; i <= 12; i++){
            switch(i){
                case 0: numeroCarta = "Ás";
                break;
                case 1: numeroCarta = "Dois";
                break;
                case 2: numeroCarta = "Três";
                break;
                case 3: numeroCarta = "Quatro";
                break;
                case 4: numeroCarta = "Cinco";
                break;
                case 5: numeroCarta = "Seis";
                break;
                case 6: numeroCarta = "Sete";
                break;
                case 7: numeroCarta = "Oito";
                break;
                case 8: numeroCarta = "Nove";
                break;
                case 9: numeroCarta = "Dez";
                break;
                case 10: numeroCarta = "Valete";
                break;
                case 11: numeroCarta = "Rainha";
                break;
                case 12: numeroCarta = "Rei";
                break;
            }
            for(int c = 0; c <= 3; c++){
                switch(c){
                    case 0: corCarta = "ouro";
                    break;
                    case 1: corCarta = "espadas";
                    break;
                    case 2: corCarta = "trevos";
                    break;
                    case 3: corCarta = "coração";
                    break;
                }
                
                x++;
                baralho[i][c] = numeroCarta + " de " + corCarta;
                
            }
        }
        return baralho;
        
    }
    public String distribuir(){
        String baralho[][] = arrayBaralho();
        Random rng = new Random();
        boolean cont = false;
        
        int i =0, c=0,idCarta = 0;
        List<String> cartasDistribuidas = new LinkedList<>();
        cartasDistribuidas = getCartasDistribuidas();
        do{
         i = rng.nextInt(13);
         c = rng.nextInt(4);
        }while(getCartasDistribuidas().contains(baralho[i][c]));
        
        cartasDistribuidas.add(baralho[i][c]);
        setCartasDistribuidas(cartasDistribuidas);
        //Lembrar de resetar SetCartasDistribuidas para novos jogos
        
        
       
        return baralho[i][c];
    }
//    public List cartasDistribuidas(int idCarta){
//        List<Integer> cartasDistribuidas = new LinkedList<>();
//        cartasDistribuidas.add(idCarta);
//        
//        return cartasDistribuidas;
//    }
    public int Transformar(String carta){
        
       String[] result = carta.split(" de ");
       switch(result[0]){
                case  "Ás":  return 11;
                case "Dois": return 2;
                case "Três": return 3 ;
                case "Quatro": return 4;
                case "Cinco": return 5;
                case "Seis": return 6;
                case "Sete": return 7;
                case "Oito": return 8;
                case "Nove": return 9;
                case "Dez":  return 10;
                case "Valete": return  10;
                case "Rainha": return 10;
                case "Rei": return 10;
                default: return 21;
            }
      
    }
}
