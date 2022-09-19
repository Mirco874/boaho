package mainPackage;
public class valorRescate {
    public double calcularVR(double AC, double AF, double T){
        double a=0.2*AF;
        double b=1-T;
        double c=a*b;
        return AC+c;
    }
}
