package run;

public class PruebaEncapsulacion {

    private String name;

    public String getName() {
        //Validar que esté en mayuscula
        name = name.toUpperCase();
        //Sin Espacios
        name = name.replace(" ", "");
        return name; //Getter
    }

    public String setName(String name) {

        this.name = name; //Setter
        return name;

    }



}
