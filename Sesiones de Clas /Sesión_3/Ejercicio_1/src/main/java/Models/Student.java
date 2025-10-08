package Models;

/**
 * Modelo inmutable-controlado de Estudiante.
 * Buenas prácticas aplicadas:
 * - Encapsulamiento: atributos privados + getters.
 * - Validación centralizada en constructores/setters.
 * - Sin lógica de entrada/salida (I/O) aquí.
 */
public class Student {
    private String name;
    private String career;
    private String id; // 8 dígitos

    // Constructor vacío (útil para frameworks / creación gradual)
    public Student() { }

    // Constructor con validación reutilizando los setters
    public Student(String name, String career, String id) {
        setName(name);
        setCareer(career);
        setId(id);
    }

    // ---- Getters ----
    public String getName()   { return name; }
    public String getCareer() { return career; }
    public String getId()     { return id; }

    // ---- Setters con validación ----
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.name = name.trim();
    }

    public void setCareer(String career) {
        if (career == null || career.trim().isEmpty()) {
            throw new IllegalArgumentException("La carrera no puede estar vacía.");
        }
        this.career = career.trim();
    }

    /** Reglas: exactamente 8 dígitos numéricos. */
    public void setId(String id) {
        if (id == null || !id.matches("\\d{8}")) {
            throw new IllegalArgumentException("El id debe tener exactamente 8 dígitos numéricos.");
        }
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student {name='" + name + "', career='" + career + "', id='" + id + "'}";
    }
}
