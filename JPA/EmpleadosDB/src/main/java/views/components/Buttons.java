package views.components;

import javax.swing.*;

public class Buttons {

    private JButton buttonCrearEmpleado;
    private JButton buttonCrearCargo;

    private JButton actualizarEmpleado;
    private JButton actualizarCargo;

    private JButton eliminarEmpleado;
    private JButton eliminarCargo;

    public Buttons() {
        this.buttonCrearEmpleado = new JButton("Crear Empleado");
        this.buttonCrearCargo = new JButton("Crear Cargo");

        this.actualizarEmpleado = new JButton("Actualizar Empleado");
        this.actualizarCargo = new JButton("Actualizar Cargo");

        this.eliminarEmpleado = new JButton("Eliminar Empleado");
        this.eliminarCargo = new JButton("Eliminar Cargo");
    }

    public JButton crearButtonCrearEmpleado() {
        this.buttonCrearEmpleado.setBounds(100, 150, 180, 25);
        return this.buttonCrearEmpleado;
    }

    public JButton crearButtonCrearCargo() {
        this.buttonCrearCargo.setBounds(600, 150, 180, 25);
        return this.buttonCrearCargo;
    }

    public JButton crearButtonActualizarEmpleado() {
        this.actualizarEmpleado.setBounds(100, 180, 180, 25);
        return this.actualizarEmpleado;
    }

    public JButton crearButtonActualizarCargo() {
        this.actualizarCargo.setBounds(600, 180, 180, 25);
        return this.actualizarCargo;
    }


    public JButton crearButtonEliminarEmpleado() {
        this.eliminarEmpleado.setBounds(100, 210, 180, 25);
        return this.eliminarEmpleado;
    }
    public JButton crearButtonEliminarCargo() {
        this.eliminarCargo.setBounds(600, 210, 180, 25);
        return this.eliminarCargo;
    }

}
