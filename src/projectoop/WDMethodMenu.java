package projectoop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Personal
 */
public class WDMethodMenu extends javax.swing.JFrame {
    Connection Con = null;
    PreparedStatement pst = null;
    ResultSet Rs = null;
    Statement St = null;    
    ResultSet Rs2 = null;
    Statement St2 = null;
    /**
     * Creates new form RegistersCoba
     */
    public WDMethodMenu() {
        initComponents();
    }

    int idUser;
    public WDMethodMenu(int Id_User){
        initComponents();
        idUser = Id_User;
        setLocationRelativeTo(null);
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
        headerPanel_Menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Bank_MenuDP = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Cash_MenuDP = new javax.swing.JButton();
        BackButton_MenuDPWD = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

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

        headerPanel_Menu.setBackground(new java.awt.Color(247, 247, 247));
        headerPanel_Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setText("Choose Your Withdraw Method");
        headerPanel_Menu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 24));

        jPanel1.add(headerPanel_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 85));

        jLabel20.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectoop/icon/s.png"))); // NOI18N
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 40, 40));

        jLabel19.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectoop/icon/a.png"))); // NOI18N
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 40, 40));

        jLabel17.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        jLabel17.setText("Banking System");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, -1, 20));

        Bank_MenuDP.setBackground(new java.awt.Color(252, 252, 252));
        Bank_MenuDP.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        Bank_MenuDP.setToolTipText("");
        Bank_MenuDP.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Bank_MenuDP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Bank_MenuDPMouseClicked(evt);
            }
        });
        Bank_MenuDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bank_MenuDPActionPerformed(evt);
            }
        });
        jPanel1.add(Bank_MenuDP, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 390, 100));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectoop/icon/Artboard 4.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 640, -1, -1));

        jLabel18.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        jLabel18.setText("Cash");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, -1, 20));

        Cash_MenuDP.setBackground(new java.awt.Color(252, 252, 252));
        Cash_MenuDP.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        Cash_MenuDP.setToolTipText("");
        Cash_MenuDP.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Cash_MenuDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cash_MenuDPActionPerformed(evt);
            }
        });
        jPanel1.add(Cash_MenuDP, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 390, 100));

        BackButton_MenuDPWD.setBackground(new java.awt.Color(248, 248, 248));
        BackButton_MenuDPWD.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        BackButton_MenuDPWD.setToolTipText("");
        BackButton_MenuDPWD.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BackButton_MenuDPWD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackButton_MenuDPWDMouseClicked(evt);
            }
        });
        BackButton_MenuDPWD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButton_MenuDPWDActionPerformed(evt);
            }
        });
        jPanel1.add(BackButton_MenuDPWD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 500, 70));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectoop/icon/Artboard 1.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void Bank_MenuDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bank_MenuDPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Bank_MenuDPActionPerformed

    private void BackButton_MenuDPWDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButton_MenuDPWDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackButton_MenuDPWDActionPerformed

    private void BackButton_MenuDPWDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButton_MenuDPWDMouseClicked
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
    }//GEN-LAST:event_BackButton_MenuDPWDMouseClicked

    private void Cash_MenuDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cash_MenuDPActionPerformed
        new WithdrawCashMenu(idUser).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Cash_MenuDPActionPerformed

    private void Bank_MenuDPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bank_MenuDPMouseClicked
        new WithdrawBankMenu(idUser).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Bank_MenuDPMouseClicked

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
            java.util.logging.Logger.getLogger(WDMethodMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WDMethodMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WDMethodMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WDMethodMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new WDMethodMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BackButton_MenuDPWD;
    public javax.swing.JButton Bank_MenuDP;
    public javax.swing.JButton Cash_MenuDP;
    private javax.swing.JPanel headerPanel_Menu;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel18;
    public javax.swing.JLabel jLabel19;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel20;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
