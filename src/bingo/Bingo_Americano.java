package bingo;

import java.util.Collections;

public class Bingo_Americano extends Bingo{
    public Bingo_Americano() {
        super();
        
        bola_Mayor = 75;
        tamanio_Carton = 25;
    }
    @Override
    public int girar(){
        int bola;
        do{
            Collections.shuffle(bombo);
            bola = ultima_Bola;
            ultima_Bola = bombo.get(0);
        }while(bola+1 != ultima_Bola);
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
    @Override
    public boolean aceptable(Carton o) {
        Integer suma = 0;
        for(int i = 0 ; i < o.getNumeros().size();i++){
            suma += o.getNumeros().get(i);
        }
        suma = suma/o.getNumeros().size();
        return (suma <=50);
    }
}
