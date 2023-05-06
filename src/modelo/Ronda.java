package modelo;

public class Ronda {

    private int num = 0;
    public Ronda(int num) {
        this.num = num;
    }
    public boolean inhabilitar(){
        if(num>5){
            return true;
        }else{
            return false;
        }
    }
    public int getNum() {
        return num;
    }
}
