package com.fernandomulato.Presentation.views;

import javax.swing.*;

import com.fernandomulato.Domain.core.events.ClsLibraryEvent;
import com.fernandomulato.Domain.core.events.ILibraryObserver;
import com.fernandomulato.Domain.core.events.LibraryEventType;
import com.fernandomulato.Domain.core.kernel.ClsKernel;
import com.fernandomulato.Domain.enums.AttentionType;
import com.fernandomulato.Presentation.controller.ClsAppointmentController;

import java.awt.*;
import java.io.File;
import java.sql.Date;

public class ClsMainFrame extends JFrame implements ILibraryObserver {
  private final ClsAppointmentController appointmentController;
  private final ClsKernel kernel;

  private final ClsAppointmentTableModel tableModel = new ClsAppointmentTableModel();
  private final JTable table = new JTable(tableModel);
  private final ClsAppointmentFormPanel form = new ClsAppointmentFormPanel();
  private final JLabel lblStatus = new JLabel("Listo.");

  private long selectedId = 0;

  public ClsMainFrame(ClsAppointmentController controller, ClsKernel kernel) {
    super("Piedrazul - Appointment CRUD (Swing + MVC + SOLID + Observer + Microkernel)");
    this.appointmentController = controller;
    this.kernel = kernel;

    kernel.getEventBus().subscribe(this);

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(980, 520);
    setLocationRelativeTo(null);

    setLayout(new BorderLayout(8, 8));
    add(buildLeft(), BorderLayout.CENTER);
    add(buildRight(), BorderLayout.EAST);
    add(buildBottom(), BorderLayout.SOUTH);

    refreshTable();
  }

  private JComponent buildLeft() {
    JPanel p = new JPanel(new BorderLayout(6, 6));
    p.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    table.getSelectionModel().addListSelectionListener(e -> {
      if (!e.getValueIsAdjusting() && table.getSelectedRow() >= 0) {
        var b = tableModel.getAt(table.getSelectedRow());
        selectedId = b.getAttId();
        form.setForm(
            b.getAttAttentionType().name(),
            Long.toString(b.getAttCitizenshipCardPatient()),
            b.getAttPhoneNumberPatient());
      }
    });

    p.add(new JScrollPane(table), BorderLayout.CENTER);

    JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JButton btnNew = new JButton("Nuevo");
    btnNew.addActionListener(e -> {
      selectedId = 0;
      form.clear();
      lblStatus.setText("Nuevo registro.");
    });
    JButton btnDelete = new JButton("Eliminar");
    btnDelete.addActionListener(e -> onDelete());
    top.add(btnNew);
    top.add(btnDelete);

    p.add(top, BorderLayout.NORTH);
    return p;
  }

  private JComponent buildRight() {
    JPanel p = new JPanel(new BorderLayout(6, 6));
    p.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

    p.add(form, BorderLayout.CENTER);

    JPanel actions = new JPanel(new GridLayout(0, 1, 6, 6));
    JButton btnSave = new JButton("Guardar");
    btnSave.addActionListener(e -> onSave());
    JButton btnExport = new JButton("Exportar reporte");
    btnExport.addActionListener(e -> onExportReport());

    actions.add(btnSave);
    actions.add(btnExport);

    p.add(actions, BorderLayout.SOUTH);
    return p;
  }

  private JComponent buildBottom() {
    JPanel p = new JPanel(new BorderLayout());
    p.setBorder(BorderFactory.createEmptyBorder(4, 8, 8, 8));
    p.add(lblStatus, BorderLayout.CENTER);
    return p;
  }

  private void onSave() {
    try {
      String citizenshipCardPatient = form.citizenshipCardPatient();
      String phoneNumberPatient = form.phoneNumberPatient();
      String attentionTypeStr = form.attentionType();
      AttentionType attentionType = AttentionType.valueOf(attentionTypeStr);

      if (citizenshipCardPatient.isBlank() || phoneNumberPatient.isBlank() || attentionTypeStr.isBlank()) {
        JOptionPane.showMessageDialog(this, "Citizenship Card,Phone Number Patient and Attention Type are mandatory.");
        return;
      }

      if (selectedId == 0) {
        appointmentController.create(
            Long.parseLong(citizenshipCardPatient),
            phoneNumberPatient,
            1,
            Date.valueOf("2026-03-06"),
            attentionType);
      } else {
        appointmentController.update(
            1,
            Long.parseLong(citizenshipCardPatient),
            phoneNumberPatient,
            1,
            Date.valueOf("2026-03-06"),
            attentionType);
      }
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void onDelete() {
    if (selectedId == 0) {
      JOptionPane.showMessageDialog(this, "Select an appointment to delete.");
      return;
    }
    int ok = JOptionPane.showConfirmDialog(this, "Remove ID " + selectedId + "?", "Ok",
        JOptionPane.YES_NO_OPTION);
    if (ok == JOptionPane.YES_OPTION) {
      try {
        appointmentController.delete(selectedId);
        selectedId = 0;
        form.clear();
      } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  private void onExportReport() {
    var opt = kernel.getServices().getReportProvider();
    if (opt.isEmpty()) {
      JOptionPane.showMessageDialog(this, "No reporting plugin loaded.");
      return;
    }
    try {
      File f = opt.get().generateReport(appointmentController.list());
      JOptionPane.showMessageDialog(this, "Report generated: " + f.getAbsolutePath());
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void refreshTable() {
    tableModel.setData(appointmentController.list());
  }

  @Override
  public void onEvent(ClsLibraryEvent event) {
    if (event.getType() == LibraryEventType.APPOINTMENT_CHANGED) {
      refreshTable();
    }
    lblStatus.setText(event.getMessage());
  }
}