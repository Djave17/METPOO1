package views.components;

import entities.Cargo;
import entities.Empleado;

import javax.swing.*;

public class ComboBox {

    private JComboBox<Cargo> empleadoComboBox = new JComboBox<>();

    public ComboBox() {}

    public JComboBox<Cargo> crearCargoComboBox() {
        this.empleadoComboBox.setBounds(100, 120, 150, 25);
        this.empleadoComboBox.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
        return this.empleadoComboBox;
    }





}
