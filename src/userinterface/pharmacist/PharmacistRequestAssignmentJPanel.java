/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface.pharmacist;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.DoctorOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.Organization.PharmacyOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PatientTreatmentWorkRequest;
import Business.WorkQueue.PharmacyWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import userinterface.LabAssistantRole.LabAssistantWorkAreaJPanel;


/**
 *
 * @author LENOVO
 */
public class PharmacistRequestAssignmentJPanel extends javax.swing.JPanel {
private JPanel userProcessContainer;
    private PharmacyOrganization pharmacyOrganization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    /**
     * Creates new form PharmacistRequestAssignmentJPanel
     
     */
    public PharmacistRequestAssignmentJPanel(JPanel userProcessContainer, UserAccount account, PharmacyOrganization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
      
        this.enterprise = enterprise;
        this.userAccount = account;
        this.pharmacyOrganization = (PharmacyOrganization) organization;
        
         // Call populateTable to load data when the panel is created
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        requestTable = new javax.swing.JTable();
        assignToSelfButton = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(173, 234, 204));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel1.setText("Assign Medication Requests");

        requestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Request ID", "Patient Name", "Medication", "Status"
            }
        ));
        jScrollPane1.setViewportView(requestTable);

        assignToSelfButton.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        assignToSelfButton.setText("Assign to Self");
        assignToSelfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignToSelfButtonActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(assignToSelfButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(121, 121, 121)
                                .addComponent(jLabel1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(jLabel1))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(assignToSelfButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(247, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

 public void populateTable() {
     DefaultTableModel model = (DefaultTableModel) requestTable.getModel();
    model.setRowCount(0);

    // Iterate through the PharmacyOrganization's WorkQueue
    for (WorkRequest request : pharmacyOrganization.getWorkQueue().getWorkRequests()) {
        if (request instanceof PharmacyWorkRequest) {
            PharmacyWorkRequest pharmacyRequest = (PharmacyWorkRequest) request;

            Object[] row = new Object[4];
            row[0] = pharmacyRequest.getRequestId();
            row[1] = pharmacyRequest.getPatient().getFirstName() + " " + pharmacyRequest.getPatient().getLastName();
            row[2] = pharmacyRequest.getMedication();
            row[3] = pharmacyRequest.getStatus();

            model.addRow(row);
        }
    }

    // Enable sorting
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    requestTable.setRowSorter(sorter);
 }

//}

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        LabAssistantWorkAreaJPanel labassistant = (LabAssistantWorkAreaJPanel) component;
        labassistant.populateTable();

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void assignToSelfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignToSelfButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assignToSelfButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignToSelfButton;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable requestTable;
    // End of variables declaration//GEN-END:variables
}