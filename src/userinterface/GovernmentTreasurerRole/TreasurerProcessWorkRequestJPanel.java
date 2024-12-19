/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.GovernmentTreasurerRole;

import Business.WorkQueue.GovernmentFundRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Dell
 */
public class TreasurerProcessWorkRequestJPanel extends javax.swing.JPanel {

    private JPanel jPanel;
    private GovernmentFundRequest governmentFundRequest;

    /**
     * Creates new form ProcessWorkRequestJPanel
     */
    public TreasurerProcessWorkRequestJPanel(JPanel jPanel, GovernmentFundRequest fundRequest) {
        initComponents();
        this.jPanel = jPanel;
        this.governmentFundRequest = fundRequest;
        btnAmount.setText(String.valueOf(governmentFundRequest.getAmountRequested()));
        btnLocation.setText(governmentFundRequest.getRegion());
        btnPopulation.setText(String.valueOf(governmentFundRequest.getPopulation()));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSubmit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnReject = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnMessage = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnLocation = new javax.swing.JTextField();
        btnPopulation = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnAmount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblTreasurerTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(173, 234, 203));
        setLayout(null);

        btnSubmit.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnSubmit.setText("Disburse Amount");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit);
        btnSubmit.setBounds(198, 263, 150, 33);

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(6, 6, 99, 29);

        btnReject.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnReject.setText("Reject");
        btnReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectActionPerformed(evt);
            }
        });
        add(btnReject);
        btnReject.setBounds(366, 263, 116, 33);

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel2.setText("Message :");
        add(jLabel2);
        jLabel2.setBounds(219, 189, 72, 17);
        add(btnMessage);
        btnMessage.setBounds(344, 185, 116, 23);

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel4.setText("Location :");
        add(jLabel4);
        jLabel4.setBounds(211, 104, 80, 17);

        btnLocation.setEnabled(false);
        add(btnLocation);
        btnLocation.setBounds(344, 98, 116, 23);

        btnPopulation.setEnabled(false);
        add(btnPopulation);
        btnPopulation.setBounds(344, 156, 116, 23);

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel5.setText("Population :");
        add(jLabel5);
        jLabel5.setBounds(195, 160, 96, 17);

        btnAmount.setEnabled(false);
        add(btnAmount);
        btnAmount.setBounds(344, 127, 116, 23);

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel3.setText("Amount :");
        add(jLabel3);
        jLabel3.setBounds(227, 133, 64, 17);

        lblTreasurerTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTreasurerTitle.setForeground(new java.awt.Color(204, 0, 51));
        lblTreasurerTitle.setText("Treasurer Work-Area");
        add(lblTreasurerTitle);
        lblTreasurerTitle.setBounds(247, 9, 209, 21);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/treasurer workarea.jpg"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(-5, 0, 1400, 980);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        btnSubmit.setEnabled(true);
        String message = btnMessage.getText();
        if (message.equals("")) {
            JOptionPane.showMessageDialog(null, "Message is mandatory!");
            return;
        }
        else
        {
        governmentFundRequest.setMessage(message);
         int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to proceed?");
         if (dialogResult == JOptionPane.YES_OPTION) {
        governmentFundRequest.setStatus("Accepted");
        JOptionPane.showMessageDialog(null, "Funds Disbursed Successfully!!!");
        btnSubmit.setEnabled(false);
        btnMessage.setText("");
        btnReject.setEnabled(false);
        }
         btnMessage.setText("");
        }

    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        jPanel.remove(this);
        Component[] componentArray = jPanel.getComponents();
        Component component = componentArray[componentArray.length - 1];
        TreasurerWorkAreaJPanel dwjp = (TreasurerWorkAreaJPanel) component;
        dwjp.populateTable();
        CardLayout layout = (CardLayout) jPanel.getLayout();
        layout.previous(jPanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed
        String message = btnMessage.getText();
        if (message.equals("")) {
            JOptionPane.showMessageDialog(null, "Message is mandatory!");
            return;
        } else {
        governmentFundRequest.setMessage(message);
        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to proceed?");
            
            
            if (dialogResult == JOptionPane.YES_OPTION) {
        governmentFundRequest.setStatus("Rejected");
         btnMessage.setText("");
            btnReject.setEnabled(false);
            btnSubmit.setEnabled(false);
        }
         btnMessage.setText("");   
        }
    }//GEN-LAST:event_btnRejectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField btnAmount;
    private javax.swing.JButton btnBack;
    private javax.swing.JTextField btnLocation;
    private javax.swing.JTextField btnMessage;
    private javax.swing.JTextField btnPopulation;
    private javax.swing.JButton btnReject;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblTreasurerTitle;
    // End of variables declaration//GEN-END:variables
}