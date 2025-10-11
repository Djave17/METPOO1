package views.components;

import javax.swing.*;

public class Labels {

    private JLabel labelCrearEmpleado;
    private JLabel laberlInputNombreEmpleado;
    private JLabel labelInputSalario;
    private JLabel labelInputCargo;

    private JLabel labelCrearCargo;
    private JLabel labelInputNombreCargo;

    public Labels() {

        this.laberlInputNombreEmpleado = new JLabel("Nombre: ");
        this.labelInputSalario = new JLabel("Salario: ");
        this.labelInputCargo = new JLabel("Cargo: ");
        this.labelCrearCargo = new JLabel("Crear Cargo");
        this.labelInputNombreCargo = new JLabel("Nombre: ");

    }


    /*ESTOS METODOS SON PARA CREAR LAS LABELS DE LOS FORMULARIOS DE CREACION DE EMPLEADOS*/
    public JLabel crearLabelCrearEmpleado() {
        this.labelCrearEmpleado = new JLabel("Crear Empleado");
        this.labelCrearEmpleado.setBounds(30, 20, 200, 30);
        this.labelCrearEmpleado.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
        return this.labelCrearEmpleado;
    }
    public JLabel crearLabelInputNombreEmpleado() {
        this.laberlInputNombreEmpleado.setBounds(30, 60, 100, 25);
        this.laberlInputNombreEmpleado.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
        return this.laberlInputNombreEmpleado;
    }


    public JLabel crearLabelInputSalario() {
        this.labelInputSalario.setBounds(30, 90, 100, 25);
        this.labelInputSalario.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
        return this.labelInputSalario;
    }

    public JLabel crearLabelInputCargo() {
        this.labelInputCargo.setBounds(30, 120, 100, 25);
        this.labelInputCargo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
        return this.labelInputCargo;
    }

    /*ESTOS METODOS SON PARA CREAR LAS LABELS DE LOS FORMULARIOS DE CREACION DE CARGOS*/

    public JLabel getLabelCrearCargo() {
        labelCrearCargo = new JLabel("Crear Cargo");
        labelCrearCargo.setBounds(500, 20, 100, 30);
        this.labelCrearCargo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
        return labelCrearCargo;
    }

    public JLabel crearLabelInputNombreCargo() {
        this.labelInputNombreCargo.setBounds(500, 60, 100, 25);
        this.labelInputNombreCargo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
        return this.labelInputNombreCargo;
    }
}
