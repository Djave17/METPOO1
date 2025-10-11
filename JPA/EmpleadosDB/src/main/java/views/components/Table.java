package views.components;

import config.JPAUtil;
import repository.dao.EmpleadoDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.List;
import java.util.Objects;

import entities.Empleado;

public class Table {

    private DefaultTableModel modelo;
    private JTable table;
    private JScrollPane scroll;

    //Instacia de DAO para cargar la tabla
    private EmpleadoDao empleadoDao;

    private String[] columnasEmpleado = {"ID", "Nombre", "Salario", "Cargo"};



    public Table() {
        this.modelo = new DefaultTableModel(columnasEmpleado, 0);
        //Tabla NO editable
        this.modelo = new DefaultTableModel(columnasEmpleado, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Todas las celdas no son editables
            }
        };
        this.empleadoDao = new EmpleadoDao(JPAUtil.getEntityManager());
        this.cargarTabla();
        this.table = new JTable(this.modelo);
        this.scroll = new JScrollPane(this.table);
        this.scroll.setBounds(100, 300, 800, 430);

    }

    public void cargarTabla(){
        this.modelo.setRowCount(0);
        //List<Empleado> empleados = empleadoDao.listarEmpleados();

        this.empleadoDao.listarEmpleados().forEach(e -> {
            Object[] fila = {e.getId(), e.getNombreEmpleado(), e.getSalario(), e.getCargo().getNombreCargo()};
            this.modelo.addRow(fila);
        });


    }
    public JTable getTable() {
        return this.table;
    }
    public JScrollPane getScroll() {
        return this.scroll;
    }


}
