package com.gastos.ui;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;

import com.gastos.dao.GastoDAO;

public class InterfazGastos extends JFrame {

    private GastoDAO gastoDAO;

    public InterfazGastos() {
        super("Gestión de Gastos");

        gastoDAO = new GastoDAO();

        JButton btnInsertar = new JButton("Insertar gasto");
        JButton btnEliminar = new JButton("Eliminar gasto");

        btnInsertar.addActionListener(e -> mostrarFormularioInsertar());
        btnEliminar.addActionListener(e -> mostrarFormularioEliminar());

        setLayout(new GridLayout(2, 1, 10, 10));
        add(btnInsertar);
        add(btnEliminar);

        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void mostrarFormularioInsertar() {
        JTextField txtConcepto = new JTextField();
        JTextField txtCantidad = new JTextField();
        JTextField txtFecha = new JTextField();

        Object[] campos = {
                "Concepto:", txtConcepto,
                "Cantidad:", txtCantidad,
                "Fecha (YYYY-MM-DD):", txtFecha
        };

        int opcion = JOptionPane.showConfirmDialog(
                this,
                campos,
                "Insertar gasto",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (opcion == JOptionPane.OK_OPTION) {
            try {
                String concepto = txtConcepto.getText();
                double cantidad = Double.parseDouble(txtCantidad.getText());
                Date fecha = Date.valueOf(txtFecha.getText());

                boolean ok = gastoDAO.insertarGasto(concepto, cantidad, fecha);

                if (ok) {
                    JOptionPane.showMessageDialog(this, "Gasto insertado correctamente");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al insertar gasto");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Datos inválidos: " + ex.getMessage());
            }
        }
    }

    private void mostrarFormularioEliminar() {
        String idStr = JOptionPane.showInputDialog(this, "ID del gasto a eliminar:");

        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);

                boolean ok = gastoDAO.eliminarGasto(id);

                if (ok) {
                    JOptionPane.showMessageDialog(this, "Gasto eliminado correctamente");
                } else {
                    JOptionPane.showMessageDialog(this, "No existe un gasto con ese ID");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "ID inválido");
            }
        }
    }
}