package mainPackage;

public class congruencialMixto {
    public double generarValor(int semilla,int cmultiplicativa,int modulo){
        int i,numero;
        double numero2=0;
        for(i=0;i<=20;i++){
            numero=(cmultiplicativa*semilla)%modulo;
            numero2=(double) numero/(double)(modulo-1);
            semilla=numero;}
        return numero2;
        }
    public double generarValorAleatorio(){
        double numero=(double) (Math.random());
        return numero;
    }
}


