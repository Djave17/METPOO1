import java.util.Scanner; 

public class HolaMundo {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String saluda = saludar();
        System.out.println(saluda);

        System.out.print("Por favor, ingresa algo: ");
        String entrada = scanner.nextLine();
        System.out.println("Has ingresado: " + entrada);
    }

    

    public static String saludar() {
        //Sout para autocompletar el printline 
        //psvm Para autocompletar el public static void main 

        return "¡Hola desde un método!";
    }


}