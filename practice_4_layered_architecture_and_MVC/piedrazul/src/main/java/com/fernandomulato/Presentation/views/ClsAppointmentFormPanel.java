package com.fernandomulato.Presentation.views;

import javax.swing.*;
import java.awt.*;

public class ClsAppointmentFormPanel extends JPanel {
    private final JTextField txtAttentionType = new JTextField(20);
    private final JTextField txtCitizenshipCardPatient = new JTextField(20);
    private final JTextField txtPhoneNumberPatient = new JTextField(20);

    public ClsAppointmentFormPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4,4,4,4);
        c.anchor = GridBagConstraints.WEST;

        int r=0;
        add(new JLabel("Attention Type:"), gbc(c,0,r));
        add(txtAttentionType, gbc(c,1,r++));
        add(new JLabel("Citizenship Card:"), gbc(c,0,r));
        add(txtCitizenshipCardPatient, gbc(c,1,r++));
        add(new JLabel("Phone Number Patient:"), gbc(c,0,r));
        add(txtPhoneNumberPatient, gbc(c,1,r++));
    }

    private GridBagConstraints gbc(GridBagConstraints base, int x, int y) {
        GridBagConstraints c = (GridBagConstraints) base.clone();
        c.gridx = x; c.gridy = y;
        return c;
    }

    public String attentionType() { return txtAttentionType.getText().trim(); }
    public String citizenshipCardPatient() { return txtCitizenshipCardPatient.getText().trim(); }
    public String phoneNumberPatient() { return txtPhoneNumberPatient.getText().trim(); }

    public void setForm(String attentionType, String citizenshipCardPatient, String phoneNumberPatient) {
        txtAttentionType.setText(attentionType);
        txtCitizenshipCardPatient.setText(citizenshipCardPatient);
        txtPhoneNumberPatient.setText(phoneNumberPatient);
    }

    public void clear() {
        setForm("", "", "");
    }
}

