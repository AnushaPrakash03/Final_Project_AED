/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.InsuranceAgentRole;

import Business.Enterprise.Enterprise;
import Business.Organization.InsuranceAgentOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.UUID;
import javax.swing.JPanel;

/**
 *
 * @author Dell
 */
public class InsuranceAgentWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form InsuranceAgentWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private InsuranceAgentOrganization insuranceAgentOrganization;
    private Enterprise enterprise;

    public InsuranceAgentWorkAreaJPanel(JPanel jpanel, UserAccount userAccount, Organization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = jpanel;
        this.userAccount = userAccount;
        this.insuranceAgentOrganization = (InsuranceAgentOrganization) organization;
        this.enterprise = enterprise;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddNewMember = new javax.swing.JButton();
        btnProcessRequests = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        btnAddNewMember.setBackground(new java.awt.Color(204, 204, 255));
        btnAddNewMember.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnAddNewMember.setText("Create New Member");
        btnAddNewMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewMemberActionPerformed(evt);
            }
        });
        add(btnAddNewMember);
        btnAddNewMember.setBounds(420, 100, 184, 41);

        btnProcessRequests.setBackground(new java.awt.Color(204, 204, 255));
        btnProcessRequests.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        btnProcessRequests.setText("Process Insurance Requests");
        btnProcessRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessRequestsActionPerformed(evt);
            }
        });
        add(btnProcessRequests);
        btnProcessRequests.setBounds(400, 260, 220, 39);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("\n\n\n\n\nCustomer submits insurance \nrequests and is processed by the \ninsurer");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.darkGray, java.awt.Color.gray));
        jScrollPane1.setViewportView(jTextArea1);

        add(jScrollPane1);
        jScrollPane1.setBounds(390, 250, 240, 140);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setText("\n\n\n\n\nAdd new member in the insurance\ncompany and add them to insurance\npolicy");
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.darkGray, java.awt.Color.gray));
        jScrollPane2.setViewportView(jTextArea2);

        add(jScrollPane2);
        jScrollPane2.setBounds(390, 90, 240, 140);

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Insurance Agent Work Area");
        add(jLabel1);
        jLabel1.setBounds(2, 20, 690, 21);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/insurance_Agent.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(12, 57, 330, 340);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewMemberActionPerformed
        String policyNumber = UUID.randomUUID().toString().substring(0, 7);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("AddNewPolicyHolderJPanel", new AddNewPolicyHolderJPanel(userProcessContainer, userAccount, enterprise, policyNumber));
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btnAddNewMemberActionPerformed

    private void btnProcessRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessRequestsActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("ProcessInsuranceRequestsJPanel", new AllInsuranceRequestsJPanel(userProcessContainer, userAccount, enterprise, insuranceAgentOrganization));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnProcessRequestsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewMember;
    private javax.swing.JButton btnProcessRequests;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}