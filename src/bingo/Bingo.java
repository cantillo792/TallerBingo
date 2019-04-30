package bingo;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Bingo {
    protected int bola_Mayor;
    protected int ultima_Bola;
    protected int tamanio_Carton; 
    protected boolean terminado;
    protected ArrayList<Integer> bombo;
    protected ArrayList<Integer> bolas_Extraidas;
    protected ArrayList<Carton> cartones;
    protected ArrayList<Carton> cartones_Bingo;
    
    
    public Bingo() {
        this.bombo = new ArrayList<>();
        for( int i=1;i<=bola_Mayor;i++){
            bombo.add(i);    
        }
        
        bolas_Extraidas = new ArrayList<>();
        cartones = new ArrayList<>();
        cartones_Bingo = new ArrayList<>();
        this.ultima_Bola = 0;
        terminado = false;
    }
    public Carton crearCarton(){
        ArrayList<Integer> numerosPosibles = new ArrayList<>();
        ArrayList<Integer> numeros = new ArrayList<>();
        Carton o;
        do{
            for( int i=1;i<=bola_Mayor;i++){
                numerosPosibles.add(i);    
            }
            Collections.shuffle(numerosPosibles);
            for( int i=1;i<=tamanio_Carton;i++){
                numeros.add(numerosPosibles.get(i));
            }
            o = new Carton(numeros);
            System.out.println(o.toString());
        }while(aceptable(o) && cartones.contains(o));
        cartones.add(o);
        return o;
    }
    public abstract boolean aceptable(Carton o);
    
    public int girar(){
        Collections.shuffle(bombo);
        ultima_Bola = bombo.get(0);
        bolas_Extraidas.add(bombo.get(0));
        bombo.remove(0);
        for(int i = 0; i<cartones.size();i++){
            if(cartones.get(i).comprobar(bolas_Extraidas)){
                cartones_Bingo.add(cartones.get(i));
                this.terminado = true;
            }
        }
        return ultima_Bola;
    }

    public int getBola_Mayor() {
        return bola_Mayor;
    }

    public ArrayList<Integer> getBombo() {
        return bombo;
    }

    public ArrayList<Integer> getBolasExtraidas() {
        return bolas_Extraidas;
    }

    public int getUltima_Bola() {
        return ultima_Bola;
    }

    public int getTamanio_Carton() {
        return tamanio_Carton;
    }

    public ArrayList<Carton> getCartones_Bingo() {
        return cartones_Bingo;
    }
    
}
