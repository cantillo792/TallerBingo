package bingo;

import java.util.ArrayList;
import java.util.Collections;

public class Bingo_Clasico extends Bingo {
    private int limite;
    public Bingo_Clasico(int limite) {
        super();
        bola_Mayor = 90;
        this.limite= limite;
        tamanio_Carton = 15;
        cartones.ensureCapacity(limite);
        cartones_Bingo.ensureCapacity(limite);
    }
    @Override
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
        }while(aceptable(o) && cartones.contains(o));
        cartones.add(o);
        return o;
    }
    @Override
    public boolean aceptable(Carton o) {
        int a = o.getNumeros().get(0);
        for(int i = 1;i< o.getNumeros().size();i++){
            if(a + 1 == o.getNumeros().get(i)){
                return false;
            }
            a = o.getNumeros().get(i);
        }
        return true;
    }

    public int getFaltantes() {
        return limite-cartones.size();
    }
    
}
