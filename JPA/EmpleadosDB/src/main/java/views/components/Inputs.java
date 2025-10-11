package views.components;

import javax.swing.*;
import java.awt.*;

public class Inputs {

    private JTextField inputNombreEmpleado;
    private JTextField inputSalario;
    private JTextField inputCargo;

    //private JComboBox<String> comboBoxCargo;

    public Inputs() {
        this.inputNombreEmpleado = new JTextField();
        this.inputSalario = new JTextField();
        this.inputCargo = new JTextField();
    }

    public JTextField getInputNombreEmpleado() {
        this.inputNombreEmpleado.setBounds(100, 60, 150, 25);
        this.inputNombreEmpleado.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        return this.inputNombreEmpleado;
    }

    public JTextField getInputSalario() {
        this.inputSalario.setBounds(100, 90, 150, 25);
        this.inputSalario.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        return this.inputSalario;
    }

    public JTextField getInputCargo() {
        this.inputCargo.setBounds(600, 60, 180, 25);
        this.inputCargo.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        return this.inputCargo;
    }






}
