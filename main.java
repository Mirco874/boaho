package mainPackage;
import java.util.ArrayList;
import java.util.List;
public class main {
    public static void main(String[] args) {
        generadorValoresSimulados generador = new generadorValoresSimulados();
        double AF = generador.generarValorSimulado(-100000.0, -70000.0, -60000.0);
        double AC = generador.generarValorSimulado(-40000.0, -30000.0, -25000.0);
        System.out.println("----activo fijo ----");
        System.out.println(AF);
        System.out.println("----activo circulante----");
        System.out.println(AC);
        double x1 = generador.generarValorSimulado(35400.0, 41000.0, 50400.0);
        double x2 = generador.generarValorSimulado(41772.0, 45020.0, 56448.0);
        double x3 = generador.generarValorSimulado(50962.0, 51036.0, 64915.0);
        double x4 = generador.generarValorSimulado(63702.0, 70570.0, 76600.0);
        double x5 = generador.generarValorSimulado(81078.0, 87096.0, 91154.0);
        System.out.println("----valores de flujo de efectuvo antes de impuestos para las 5 gestiones----");
        System.out.println(x1);
        System.out.println(x2);
        System.out.println(x3);
        System.out.println(x4);
        System.out.println(x5);

        double T = 0.5;
        ArrayList<Double> listai = new ArrayList<>();

        double i1 = generador.generarValorSimulado(0.12, 0.15, 0.18);
        double i2 = generador.generarValorSimulado(0.12, 0.15, 0.18);
        double i3 = generador.generarValorSimulado(0.15, 0.18, 0.22);
        double i4 = generador.generarValorSimulado(0.18, 0.20, 0.25);
        double i5 = generador.generarValorSimulado(0.19, 0.22, 0.28);
        listai.add(i1);
        listai.add(i2);
        listai.add(i3);
        listai.add(i4);
        listai.add(i5);
        System.out.println("----tasas de inlfacion para las 5 gestiones----");
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
        System.out.println(i5);

        System.out.println("----valores de flujo de efectuvo despues de impuestos para las 5 gestiones----");
        double s1 = generador.generarValorSimulado(17373.0,20080.0,25179.0);
        double s2 = generador.generarValorSimulado(16080.0,19000.0,24605.0);
        double s3 = generador.generarValorSimulado(14785.0,18000.0,23981.0);
        double s4 = generador.generarValorSimulado(13608.0,16001.0,23346.0);
        double s5 = generador.generarValorSimulado(12577.0,15595.0,22783.0);

        List<Double> sList = new ArrayList<Double>();
        sList.add(s1);
        sList.add(s2);
        sList.add(s3);
        sList.add(s4);
        sList.add(s5);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);

        valorRescate valorResc=new valorRescate();
        double vr=valorResc.calcularVR(AC,AF,T);
        System.out.println("----valor de rescate----");
        System.out.println(vr);

        double tasaSuperior=0.05;
        double tasaInferior=0.01;

        System.out.println("----VAN----");
        double van=calcularVan(sList,listai,AF,AC);
        System.out.println(van);

        System.out.println("----VAN 1----");
        double van1=calcularVanParaHallarTir(sList,vr,tasaInferior,AC+AF);
        System.out.println(van1);
        System.out.println("----VAN 2----");
        double van2=calcularVanParaHallarTir(sList,vr,tasaSuperior,AC+AF);
        System.out.println(van2);

        System.out.println("----TIR----");
        double tir=calcularTIR(van1,van2,tasaInferior,tasaSuperior);
        System.out.println(tir);

        simularTir(10);
    }

    public static void simularTir(int iteraciones){

        for (int i=0;i<=iteraciones; i++){
        generadorValoresSimulados generador = new generadorValoresSimulados();
        double AF = generador.generarValorSimulado(-100000.0, -70000.0, -60000.0);
        double AC = generador.generarValorSimulado(-40000.0, -30000.0, -25000.0);

        double x1 = generador.generarValorSimulado(35400.0, 41000.0, 50400.0);
        double x2 = generador.generarValorSimulado(41772.0, 45020.0, 56448.0);
        double x3 = generador.generarValorSimulado(50962.0, 51036.0, 64915.0);
        double x4 = generador.generarValorSimulado(63702.0, 70570.0, 76600.0);
        double x5 = generador.generarValorSimulado(81078.0, 87096.0, 91154.0);

        double T = 0.5;
        ArrayList<Double> listai = new ArrayList<>();

        double i1 = generador.generarValorSimulado(0.12, 0.15, 0.18);
        double i2 = generador.generarValorSimulado(0.12, 0.15, 0.18);
        double i3 = generador.generarValorSimulado(0.15, 0.18, 0.22);
        double i4 = generador.generarValorSimulado(0.18, 0.20, 0.25);
        double i5 = generador.generarValorSimulado(0.19, 0.22, 0.28);
        listai.add(i1);
        listai.add(i2);
        listai.add(i3);
        listai.add(i4);
        listai.add(i5);

        double s1 = generador.generarValorSimulado(17373.0,20080.0,25179.0);
        double s2 = generador.generarValorSimulado(16080.0,19000.0,24605.0);
        double s3 = generador.generarValorSimulado(14785.0,18000.0,23981.0);
        double s4 = generador.generarValorSimulado(13608.0,16001.0,23346.0);
        double s5 = generador.generarValorSimulado(12577.0,15595.0,22783.0);

        List<Double> sList = new ArrayList<Double>();
        sList.add(s1);
        sList.add(s2);
        sList.add(s3);
        sList.add(s4);
        sList.add(s5);


        valorRescate valorResc=new valorRescate();
        double vr=valorResc.calcularVR(AC,AF,T);

        double tasaSuperior=0.05;
        double tasaInferior=0.01;


        double van=calcularVan(sList,listai,AF,AC);
        double van1=calcularVanParaHallarTir(sList,vr,tasaInferior,AC+AF);
        double van2=calcularVanParaHallarTir(sList,vr,tasaSuperior,AC+AF);
        double tir=calcularTIR(van1,van2,tasaInferior,tasaSuperior);

        System.out.println("TIR para la iteracion "+i+" : "+tir );

        }

    }

    public static double calcularVan(List<Double> flujoList, List<Double> listaInf,double AF, double AC){
        double inversion=-1*(AF+AC);
        double res=0;
        for(int i=0;i<flujoList.size();i++){
            double numerador=flujoList.get(i);
            double denominador= Math.pow(1+listaInf.get(i),i+1);
            res=res+(numerador/denominador);
        }
        return res-inversion;
    }

    public static double calcularVanParaHallarTir(List<Double> lsitaIngresos,double VR, double TIR,double inversion){
        double res=0;
        for(int i=0;i<lsitaIngresos.size();i++){
            double numerador=lsitaIngresos.get(i);
            double denominador= Math.pow(1+TIR,i+1);
            res=res+(numerador/denominador);
        }
        return res-(-1*inversion);
    }

    public static double calcularTIR(double vanPositivo, double vanNegativo, double tir1, double tir2){
        double calculo1=(tir1-tir2)*vanPositivo;
        double calculo2=calculo1/(vanPositivo-vanNegativo);
        return (tir1-(calculo2*tir1))*100;
    }

    private static double flujoEfectDesImp(double x, double primeraMulti, double segundaMulti, double terceraMulti) {
        return (x*primeraMulti*segundaMulti/terceraMulti);
    }

}
