package mainPackage;
public class generadorValoresSimulados {
    public double generarValorSimulado(double pesimista,double probable,double optimista){
        double a=pesimista;
        double b=probable;
        double c=optimista;
        double x=0;
        congruencialMixto generador =new congruencialMixto();
        double R=generador.generarValorAleatorio();
        if( R<=((b-a)/(c-a)) ){
            x=c-Math.sqrt((c-a)*(b-a)*R);
        }
        else{
            x=c-Math.sqrt((c-a)*(c-b)*(1-R));
        }
        return x;
    }
}
