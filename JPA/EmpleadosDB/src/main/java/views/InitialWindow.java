package views;

import config.JPAUtil;
import views.components.*;

import javax.swing.*;
import java.util.List;

import jakarta.persistence.EntityManager;
import repository.dao.CargoDao;
import repository.dao.EmpleadoDao;
import entities.Cargo;
import entities.Empleado;

public class InitialWindow {

    // --- Atributos DAO/JPA ---
    private final EntityManager em = JPAUtil.getEntityManager(); // crea el EM
    private final CargoDao cargoDao = new CargoDao(em);
    private final EmpleadoDao empleadoDao = new EmpleadoDao(em);

    // --- UI compuesta (tu estilo) ---
    private JFrame ventanaInicial;
    private Labels labels;
    private Buttons buttons;
    private Inputs inputs;
    private Table table;
    private ComboBox comboBox;

    private JComboBox<Cargo> comboCargos;

    public InitialWindow() {
        this.labels = new Labels();
        this.buttons = new Buttons();
        this.inputs = new Inputs();
        this.table = new Table();           // Table ya crea modelo, JTable y Scroll, y llama cargarTabla()
        this.comboBox = new ComboBox();
    }

    public JFrame crearVentanaInicial() {
        this.ventanaInicial = new JFrame("Empleados");
        this.ventanaInicial.setSize(1000, 1000);
        this.ventanaInicial.setLayout(null);
        this.ventanaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels
        this.ventanaInicial.add(this.labels.crearLabelCrearEmpleado());
        this.ventanaInicial.add(this.labels.crearLabelInputNombreEmpleado());
        this.ventanaInicial.add(this.labels.crearLabelInputSalario());
        this.ventanaInicial.add(this.labels.crearLabelInputCargo());
        this.ventanaInicial.add(this.labels.crearLabelInputNombreCargo());
        this.ventanaInicial.add(this.labels.getLabelCrearCargo());

        // Botones
        this.ventanaInicial.add(this.buttons.crearButtonCrearEmpleado());
        this.ventanaInicial.add(this.buttons.crearButtonActualizarEmpleado());
        this.ventanaInicial.add(this.buttons.crearButtonEliminarEmpleado());

        this.ventanaInicial.add(this.buttons.crearButtonCrearCargo());
        this.ventanaInicial.add(this.buttons.crearButtonActualizarCargo());
        this.ventanaInicial.add(this.buttons.crearButtonEliminarCargo());

        // Tabla + Scroll
        this.ventanaInicial.add(this.table.getScroll());

        // Inputs
        this.ventanaInicial.add(this.inputs.getInputNombreEmpleado());
        this.ventanaInicial.add(this.inputs.getInputSalario());
        this.ventanaInicial.add(this.inputs.getInputCargo()); // aquí escribes el ID de Cargo para el empleado

        // Combo (si lo usas más adelante)
        this.ventanaInicial.add(this.comboBox.crearCargoComboBox());

        // === Registrar listeners (tu estilo en métodos separados) ===
        this.guardarCargo();
        this.editarCargo();
        this.eliminarCargo();

        this.guardarEmpleado();
        this.editarEmpleado();
        this.eliminarEmpleado();

        this.comboCargos = this.comboBox.crearCargoComboBox();
        this.ventanaInicial.add(this.comboCargos);
        this.comboCargos.setRenderer(new DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(
                    JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Cargo c) setText(c.getNombreCargo());
                return this;
            }
        });
        this.comboCargos.addActionListener(e -> {
                    Cargo c = (Cargo) this.comboCargos.getSelectedItem();
                    if (c != null) {
                        // nombre del cargo al input “Nombre” (sección Crear Cargo)
                        this.inputs.getInputCargo().setText(c.getNombreCargo());
                        // si quieres mostrar el id en tu input “Cargo” (el de empleados):
                        this.inputs.getInputCargo().setText(String.valueOf(c.getId()));
                    }
        });
        configurarRendererComboCargos();
        // muestra nombreCargo
        cargarCargosEnCombo();

        // llena el combo al inicio
        // Carga inicial de la tabla
        this.table.cargarTabla(); // repinta el modelo
        this.ventanaInicial.setVisible(true);
        return this.ventanaInicial;
    }

    // ===================== CARGOS =====================

    public void guardarCargo() {
        // listener sobre el mismo botón que ya agregaste a la ventana
        this.buttons.crearButtonCrearCargo().addActionListener(e -> {
            // Pedimos nombre del cargo en un input simple
            String nombreCargo = JOptionPane.showInputDialog(this.ventanaInicial, "Nombre del cargo:");
            if (nombreCargo == null || nombreCargo.isBlank()) {
                info("El nombre del cargo es obligatorio.");
                return;
            }
            try {
                this.cargoDao.guardarCargo(new Cargo(nombreCargo.trim())); // crea/guarda
                info("Cargo creado.");
                this.table.cargarTabla(); // refresca tabla
            } catch (Exception ex) {
                error("No se pudo crear el cargo: " + ex.getMessage());
            }
        });
    }

    public void editarCargo() {
        this.buttons.crearButtonActualizarCargo().addActionListener(e -> {
            String idStr = JOptionPane.showInputDialog(this.ventanaInicial, "ID del cargo a actualizar:");
            Long id = parseLong(idStr);
            if (id == null) return;

            Cargo existente = this.cargoDao.buscarCargoPorId(id);
            if (existente == null) { info("Cargo no encontrado."); return; }

            String nuevoNombre = JOptionPane.showInputDialog(this.ventanaInicial, "Nuevo nombre:", existente.getNombreCargo());
            if (nuevoNombre == null || nuevoNombre.isBlank()) return;

            try {
                existente.setNombreCargo(nuevoNombre.trim());   // setter simple
                this.cargoDao.actualizarCargo(existente);        // DAO ya creado
                info("Cargo actualizado.");
                this.table.cargarTabla(); // refresca tabla (por si cambias la FK visible)
            } catch (Exception ex) {
                error("No se pudo actualizar: " + ex.getMessage());
            }
        });
    }

    public void eliminarCargo() {
        this.buttons.crearButtonEliminarCargo().addActionListener(e -> {
            String idStr = JOptionPane.showInputDialog(this.ventanaInicial, "ID del cargo a eliminar:");
            Long id = parseLong(idStr);
            if (id == null) return;
            try {
                this.cargoDao.eliminarCargo(id); // DAO ya creado
                info("Cargo eliminado.");
                this.table.cargarTabla(); // refresca
            } catch (Exception ex) {
                error("No se pudo eliminar: " + ex.getMessage());
            }
        });
    }

    // ==================== EMPLEADOS ====================

    public void guardarEmpleado() {
        this.buttons.crearButtonCrearEmpleado().addActionListener(e -> {
            String nombre = this.inputs.getInputNombreEmpleado().getText();
            Double salario = parseDouble(this.inputs.getInputSalario().getText());
            Cargo cargo = (Cargo) this.comboCargos.getSelectedItem(); // del combo

            if (nombre == null || nombre.isBlank()) { info("Nombre obligatorio."); return; }
            if (salario == null || salario <= 0) { info("Salario debe ser > 0."); return; }
            if (cargo == null) { info("Seleccione un cargo del combo."); return; }

            try {
                this.empleadoDao.guardarEmpleado(new Empleado(nombre.trim(), salario, cargo));
                info("Empleado creado.");
                this.table.cargarTabla(); // refresca
                // limpia inputs
                this.inputs.getInputNombreEmpleado().setText("");
                this.inputs.getInputSalario().setText("");
            } catch (Exception ex) {
                error("No se pudo crear empleado: " + ex.getMessage());
            }
        });
    }


    public void editarEmpleado() {
        this.buttons.crearButtonActualizarEmpleado().addActionListener(e -> {
            String idStr = JOptionPane.showInputDialog(this.ventanaInicial, "ID del empleado a actualizar:");
            Long id = parseLong(idStr);
            if (id == null) return;

            Empleado emp = this.empleadoDao.buscarEmpleadoPorId(id);
            if (emp == null) { info("Empleado no encontrado."); return; }

            String nuevoNombre = JOptionPane.showInputDialog(this.ventanaInicial, "Nuevo nombre (vacío = mantener):", emp.getNombreEmpleado());
            String nuevoSalarioStr = JOptionPane.showInputDialog(this.ventanaInicial, "Nuevo salario (0 = mantener):", emp.getSalario());

            try {
                if (nuevoNombre != null && !nuevoNombre.isBlank()) emp.setNombreEmpleado(nuevoNombre.trim());
                Double nuevoSalario = parseDouble(nuevoSalarioStr);
                if (nuevoSalario != null && nuevoSalario > 0) emp.setSalario(nuevoSalario);

                // cargo del combo (opcional cambiar)
                Cargo nuevoCargo = (Cargo) this.comboCargos.getSelectedItem();
                if (nuevoCargo != null) emp.setCargo(nuevoCargo);

                this.empleadoDao.guardarEmpleado(emp); // upsert (merge si id != null)
                info("Empleado actualizado.");

                // refresca tabla SIEMPRE después de actualizar
                this.table.cargarTabla();
            } catch (Exception ex) {
                error("No se pudo actualizar empleado: " + ex.getMessage());
            }
        });
    }


    public void eliminarEmpleado() {
        this.buttons.crearButtonEliminarEmpleado().addActionListener(e -> {
            String idStr = JOptionPane.showInputDialog(this.ventanaInicial, "ID del empleado a eliminar:");
            Long id = parseLong(idStr);
            if (id == null) return;
            try {
                this.empleadoDao.eliminarEmpleado(id); // método existente
                info("Empleado eliminado.");
                this.table.cargarTabla(); // refresca
            } catch (Exception ex) {
                error("No se pudo eliminar empleado: " + ex.getMessage());
            }
        });
    }

    // ====================== Util ======================

    private void limpiarInputsEmpleado() {
        this.inputs.getInputNombreEmpleado().setText("");
        this.inputs.getInputSalario().setText("");
        this.inputs.getInputCargo().setText("");
    }

    private void info(String msg)  { JOptionPane.showMessageDialog(this.ventanaInicial, msg, "Info", JOptionPane.INFORMATION_MESSAGE); }
    private void error(String msg) { JOptionPane.showMessageDialog(this.ventanaInicial, msg, "Error", JOptionPane.ERROR_MESSAGE); }

    // parseo simple
    private Long parseLong(String s) {
        try { return (s == null || s.isBlank()) ? null : Long.parseLong(s.trim()); }
        catch (Exception ex) { error("Valor numérico inválido."); return null; }
    }
    private Double parseDouble(String s) {
        try { return (s == null || s.isBlank()) ? null : Double.parseDouble(s.trim().replace(",", ".")); }
        catch (Exception ex) { error("Valor decimal inválido."); return null; }
    }

    // ====================== Combo de Cargos ======================


    // Pobla el combo con lista de cargos.
    // Método de apoyo dentro de InitialWindow
    private void cargarCargosEnCombo() {
        DefaultComboBoxModel<Cargo> model = new DefaultComboBoxModel<>();
        List<Cargo> cargos = this.cargoDao.listarCargos();
        if (cargos != null) for (Cargo c : cargos) model.addElement(c);
        this.comboCargos.setModel(model);
    }

    // Renderer: muestra nombreCargo en vez de toString().
    private void configurarRendererComboCargos() {
        this.comboCargos.setRenderer(new DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(
                    JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Cargo c) setText(c.getNombreCargo());
                return this;
            }
        });
    }

    // Helper para reposicionar selección del combo por id
    private void seleccionarCargoEnComboPorId(Long id) {
        ComboBoxModel<Cargo> m = this.comboCargos.getModel();
        for (int i = 0; i < m.getSize(); i++) {
            Cargo c = m.getElementAt(i);
            if (c != null && c.getId() != null && c.getId().equals(id)) {
                this.comboCargos.setSelectedIndex(i);
                break;
            }
        }
    }

}
