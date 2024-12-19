/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface.LabAssistantRole;

import Business.WorkQueue.PatientTreatmentWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author anushaprakash
 */
public class ProcessLabRequestJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    PatientTreatmentWorkRequest patientTreatmentWorkRequest;
    
    /**
     * Creates new form ProcessLabRequestJPanel
     */
    public ProcessLabRequestJPanel(JPanel userProcessContainer, PatientTreatmentWorkRequest patientTreatmentWorkRequest) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.patientTreatmentWorkRequest = patientTreatmentWorkRequest;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        txtResult = new javax.swing.JTextField();
        lblResult = new javax.swing.JLabel();
        btnSubmitResult = new javax.swing.JButton();

        setLayout(null);

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lab Results");
        jLabel2.setToolTipText("");
        jLabel2.setAutoscrolls(true);
        add(jLabel2);
        jLabel2.setBounds(90, 20, 520, 28);

        btnBack.setBackground(new java.awt.Color(173, 234, 203));
        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(10, 20, 86, 30);
        add(txtResult);
        txtResult.setBounds(100, 120, 220, 50);

        lblResult.setBackground(new java.awt.Color(255, 255, 255));
        lblResult.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblResult.setText("Result :");
        add(lblResult);
        lblResult.setBounds(10, 130, 80, 30);

        btnSubmitResult.setBackground(new java.awt.Color(173, 234, 203));
        btnSubmitResult.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnSubmitResult.setText("Submit");
        btnSubmitResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitResultActionPerformed(evt);
            }
        });
        add(btnSubmitResult);
        btnSubmitResult.setBounds(30, 200, 140, 36);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        LabAssistantWorkAreaJPanel labassistant = (LabAssistantWorkAreaJPanel) component;
        labassistant.populateTable();

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSubmitResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitResultActionPerformed
        String labResult ;
        labResult = txtResult.getText().trim();
        if (labResult.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid data !");
            return;
        } else {
            int dialogResult ;
            dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to proceed?");
            if (dialogResult == JOptionPane.YES_OPTION) {
                patientTreatmentWorkRequest.setLabResult(labResult);
                patientTreatmentWorkRequest.setStatus("Lab test is Completed");
                JOptionPane.showMessageDialog(null, "Result submitted successfully");
                txtResult.setText("");
                btnSubmitResult.setEnabled(false);
            }

        }

    }//GEN-LAST:event_btnSubmitResultActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmitResult;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblResult;
    private javax.swing.JTextField txtResult;
    // End of variables declaration//GEN-END:variables
}