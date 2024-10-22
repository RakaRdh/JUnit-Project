package projectoop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Personal
 */
public class AddBalanceBankMenu extends javax.swing.JFrame {

    Connection Con = null;
    PreparedStatement pst = null;
    ResultSet Rs = null;
    Statement St = null;
        ResultSet Rs2 = null;
    Statement St2 = null;
    /**
     * Creates new form RegistersCoba
     */
    public AddBalanceBankMenu() {
        initComponents();
    }

    String PhoneNumber;
    Double OldBalance;
    int idUser;
    
    public AddBalanceBankMenu(int id_user) {
        idUser = id_user;
        GetBalance();
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void GetBalance(){
    String Query = "select * from account where id_account="+idUser;
            try{
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/primodb-test","root","");
                St = Con.createStatement();
                Rs = St.executeQuery(Query);
                if(Rs.next()){
                    OldBalance = Rs.getDouble(5);
                } else {
                    //JOptionPane.showMessageDialog(this, "Wrong Account Number Or Password");
                }
        
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e);
            }
    }
    
        public void backMenu(){
           String Query = "select * from account where id_account=" + idUser;

        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/primodb-test", "root", "");
            St = Con.createStatement();
            Rs = St.executeQuery(Query);

            // Move the cursor to the first row and check if there are results
            if (Rs.next()) {

                String Query2 = "select * from accountdetails where id_account=" + idUser;
                St2 = Con.createStatement();
                Rs2 = St2.executeQuery(Query2);

                if (Rs2.next()) {
                    // Now, launch the main menu with the relevant data
                    new MainMenu(Rs.getInt(1), Rs.getString(3), Rs.getDouble(5), Rs2.getString(4)).setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Account details not found.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Wrong Username or Password");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            System.out.println(e.getMessage());
        }
    }
        
        public void SaveTransaction(){
        String QueryDepoBank = "insert into transaction(id_transaction, id_account, transaction, amount) values(?,?,?,?)";
    try { 
             Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/primodb-test","root","");
             PreparedStatement His = Con.prepareStatement(QueryDepoBank);
             His.setString(1, null);
             His.setInt(2, idUser);
             His.setString(3, "Deposit - Bank");
             His.setString(4, depoTextField_AddBalance.getText());   
             int row = His.executeUpdate();
         } catch (Exception e) {
             JOptionPane.showMessageDialog(this, e.getMessage());
         }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        continueButton_AddBalance = new javax.swing.JButton();
        depoTextField_AddBalance = new javax.swing.JTextField();
        BankNumberTextField_AddBalance = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        backButton_AddBalance = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(247, 247, 247));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectoop/icon/Artboard 4 copy 2.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("Bank Deposit Balance");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, 24));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 85));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter Nominal to Deposit");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        continueButton_AddBalance.setBackground(new java.awt.Color(0, 204, 255));
        continueButton_AddBalance.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        continueButton_AddBalance.setText("Continue");
        continueButton_AddBalance.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        continueButton_AddBalance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                continueButton_AddBalanceMouseClicked(evt);
            }
        });
        jPanel1.add(continueButton_AddBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 185, 45));

        depoTextField_AddBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depoTextField_AddBalanceActionPerformed(evt);
            }
        });
        jPanel1.add(depoTextField_AddBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 425, 30));

        BankNumberTextField_AddBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BankNumberTextField_AddBalanceActionPerformed(evt);
            }
        });
        jPanel1.add(BankNumberTextField_AddBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 425, 30));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Enter Your Card Number");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        backButton_AddBalance.setBackground(new java.awt.Color(0, 204, 255));
        backButton_AddBalance.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        backButton_AddBalance.setText("Back");
        backButton_AddBalance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButton_AddBalanceMouseClicked(evt);
            }
        });
        backButton_AddBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton_AddBalanceActionPerformed(evt);
            }
        });
        jPanel1.add(backButton_AddBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 185, 45));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectoop/icon/Artboard 1 copy.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void depoTextField_AddBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depoTextField_AddBalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depoTextField_AddBalanceActionPerformed

    private void continueButton_AddBalanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continueButton_AddBalanceMouseClicked
        if(BankNumberTextField_AddBalance.getText().isEmpty() || depoTextField_AddBalance.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Missing information", "Message", JOptionPane.WARNING_MESSAGE);
        } else if (!Validation.isValidBalance(depoTextField_AddBalance.getText())){
            JOptionPane.showMessageDialog(this, "Invalid balance format", "Message", JOptionPane.WARNING_MESSAGE);
        } else if (!Validation.isValidBalance(BankNumberTextField_AddBalance.getText())){
            JOptionPane.showMessageDialog(this, "Invalid bank number format", "Message", JOptionPane.WARNING_MESSAGE);
        
        } else {
            GetBalance();
            try{
                String Query = "Update account set balance=? where id_account=?";
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/primodb-test","root","");
                PreparedStatement ps = Con.prepareStatement(Query);
                ps.setDouble(1, OldBalance+Double.valueOf(depoTextField_AddBalance.getText()));
                ps.setInt(2, idUser);
                if(ps.executeUpdate()==1){
                    JOptionPane.showMessageDialog(this, "Deposit Succesful");
                    SaveTransaction();
                    backMenu();
                } else {
                    JOptionPane.showMessageDialog(this, "Deposit Failed");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }//GEN-LAST:event_continueButton_AddBalanceMouseClicked

    private void backButton_AddBalanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButton_AddBalanceMouseClicked
        new AddMethodMenu(idUser).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButton_AddBalanceMouseClicked

    private void BankNumberTextField_AddBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BankNumberTextField_AddBalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BankNumberTextField_AddBalanceActionPerformed

    private void backButton_AddBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton_AddBalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButton_AddBalanceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddBalanceBankMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddBalanceBankMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddBalanceBankMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddBalanceBankMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddBalanceBankMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField BankNumberTextField_AddBalance;
    public javax.swing.JButton backButton_AddBalance;
    public javax.swing.JButton continueButton_AddBalance;
    public javax.swing.JTextField depoTextField_AddBalance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
