/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.GovernmentSecretaryRole;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.SecretaryOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.GovernmentFundRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Dell
 */
public class SecretaryWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SecretaryWorkAreaJPanel
     */
    private JPanel jPanel;
    private UserAccount userAccount;
    private SecretaryOrganization secretaryOrganization;
    private Enterprise enterprise;

    public SecretaryWorkAreaJPanel(JPanel jpanel, UserAccount userAccount, Organization organization, Enterprise enterprise) {
        initComponents();
        this.enterprise = enterprise;
        this.jPanel = jpanel;
        this.secretaryOrganization = (SecretaryOrganization) organization;
        this.userAccount = userAccount;

        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblWorkRequest = new javax.swing.JTable();
        btnAssigntoSelf = new javax.swing.JButton();
        btnProcessRequest = new javax.swing.JButton();
        lblSecretery = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(173, 234, 203));
        setLayout(null);

        tblWorkRequest.setBackground(new java.awt.Color(206, 255, 235));
        tblWorkRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Location", "Sender", "Receiver", "Status", "Amount", "Message"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblWorkRequest);

        add(jScrollPane1);
        jScrollPane1.setBounds(76, 85, 734, 92);

        btnAssigntoSelf.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnAssigntoSelf.setText("Assign to Self");
        btnAssigntoSelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssigntoSelfActionPerformed(evt);
            }
        });
        add(btnAssigntoSelf);
        btnAssigntoSelf.setBounds(76, 211, 142, 34);

        btnProcessRequest.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnProcessRequest.setText("Process Request");
        btnProcessRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessRequestActionPerformed(evt);
            }
        });
        add(btnProcessRequest);
        btnProcessRequest.setBounds(265, 211, 150, 34);

        lblSecretery.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblSecretery.setForeground(new java.awt.Color(204, 0, 0));
        lblSecretery.setText("SECRETERY WORK-AREA");
        add(lblSecretery);
        lblSecretery.setBounds(333, 18, 236, 37);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/secretary work area.jpg"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(410, 180, 610, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssigntoSelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssigntoSelfActionPerformed
        int selectedRow = tblWorkRequest.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row first from the table to view details");
            return;
        } else {
            WorkRequest request = (GovernmentFundRequest) tblWorkRequest.getValueAt(selectedRow, 0);
            if (request.getStatus().equals("Transfered to Secretary")) {
                request.setReceiver(userAccount);
                request.setStatus("Pending on " + request.getReceiver().getEmployee().getEmployeename());
                populateTable();
                JOptionPane.showMessageDialog(null, "Success !! Request is assigned to you ");
            } else {
                JOptionPane.showMessageDialog(null, "Can't assign this work request, as the work request is in " + request.getStatus() + " status", "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAssigntoSelfActionPerformed

    private void btnProcessRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessRequestActionPerformed
        // TODO add your handling code here:

        int selectedRow = tblWorkRequest.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row first from the table to view details");
            return;
        } else {
            GovernmentFundRequest fundRequest = (GovernmentFundRequest) tblWorkRequest.getValueAt(selectedRow, 0);
            if (fundRequest.getStatus().equals("Rejected")) {
                JOptionPane.showMessageDialog(null, "Cannot process a Rejected Request", "Warning!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            if (fundRequest.getStatus().equalsIgnoreCase("Sent to Treasurer")) {
                JOptionPane.showMessageDialog(null, "Request already processed" , "Warning!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (fundRequest.getStatus().equalsIgnoreCase("Sent to Secretary")) {
                JOptionPane.showMessageDialog(null, "Please assign selected request first");
                return;
            }
             if(!userAccount.equals(fundRequest.getReceiver())){
             JOptionPane.showMessageDialog(null, "Not Authorized", "Warning!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!userAccount.getEmployee().equals(fundRequest.getReceiver().getEmployee())) {
                JOptionPane.showMessageDialog(null, "Request assigned to other Officer", "Warning!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            
            SecretaryProcessWorkRequestJPanel panel = new SecretaryProcessWorkRequestJPanel(jPanel, userAccount, fundRequest, enterprise);
            jPanel.add("secretaryProcessWorkRequestJPanel", panel);
            CardLayout layout = (CardLayout) jPanel.getLayout();
            layout.next(jPanel);

        }
    }//GEN-LAST:event_btnProcessRequestActionPerformed

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblWorkRequest.getModel();

        model.setRowCount(0);

        for (WorkRequest request : secretaryOrganization.getWorkQueue().getWorkRequests()) {
            String status = request.getStatus();
            Object[] row = new Object[6];
            row[0] = ((GovernmentFundRequest) request);
            row[1] = request.getSender().getEmployee().getEmployeename();
            if (status.equalsIgnoreCase("Sent to Treasurer") || status.equalsIgnoreCase("Sent to Secretary")) {
                row[2] = null;
            } else {
                row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getEmployeename();
            }
            row[3] = status;
            row[4] = ((GovernmentFundRequest) request).getAmountRequested();
            row[5] = ((GovernmentFundRequest) request).getMessage();

            model.addRow(row);
        }
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tblWorkRequest.setRowSorter(sorter);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssigntoSelf;
    private javax.swing.JButton btnProcessRequest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSecretery;
    private javax.swing.JTable tblWorkRequest;
    // End of variables declaration//GEN-END:variables
}