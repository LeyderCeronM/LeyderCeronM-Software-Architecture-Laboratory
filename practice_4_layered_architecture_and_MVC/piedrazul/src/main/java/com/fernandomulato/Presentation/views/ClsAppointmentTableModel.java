package com.fernandomulato.Presentation.views;

import javax.swing.table.AbstractTableModel;

import com.fernandomulato.Domain.entities.ClsAppointment;

import java.util.ArrayList;
import java.util.List;

/**
 * View-model para JTable (Swing).
 */
public class ClsAppointmentTableModel extends AbstractTableModel {
    private final String[] columns = {"id", "Phone Number", "Attention Type", "Citizenship Card", "Medical Staff Id"};
    private List<ClsAppointment> data = new ArrayList<>();

    public void setData(List<ClsAppointment> data) {
        this.data = new ArrayList<>(data);
        fireTableDataChanged();
    }

    public ClsAppointment getAt(int row) {
        return data.get(row);
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ClsAppointment b = data.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> b.getAttId();
            case 1 -> b.getAttPhoneNumberPatient();
            case 2 -> b.getAttAttentionType();
            case 3 -> b.getAttCitizenshipCardPatient();
            case 4 -> b.getAttMedicalStaffId();
            case 5 -> b.getAttDateAndTime();
            default -> "";
        };
    }
}
