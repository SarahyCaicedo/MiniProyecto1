package controlador;

import modelo.Ronda;
public class ControlRonda  {

    private Ronda num;
    public ControlRonda(){

    }
    public boolean rondas(int ron){
        num = new Ronda(ron);
        if(num.inhabilitar()==true){
            return true;
        }else{
            return false;
        }

    }

}
