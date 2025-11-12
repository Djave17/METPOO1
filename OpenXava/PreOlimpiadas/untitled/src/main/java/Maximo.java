public class Maximo {

    double maximo;

    public static int calcularMaximo(double a, double b, double c){

        return (int) Math.max(Math.max(a, b), c);
    }
}
