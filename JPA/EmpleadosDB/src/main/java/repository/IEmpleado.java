package repository;
import entities.Empleado;

import java.util.List;


public interface IEmpleado {

    Empleado guardarEmpleado(Empleado empleado);
    List<Empleado> listarEmpleados();
    void actualizarEmpleado(Empleado empleado);
    void eliminarEmpleado(Long id);
    Empleado buscarEmpleadoPorId(Long id);
}
