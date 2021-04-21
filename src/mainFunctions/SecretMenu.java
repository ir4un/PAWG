/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainFunctions;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author ir4un
 */
public class SecretMenu extends javax.swing.JFrame {

    /**
     * Creates new form startMenu
     */
    private int mousepX;
    private int mousepY;

    public SecretMenu() {

        initComponents();
        this.chkpass.setVisible(false);
        this.iconNoSee.setVisible(false);
        this.txtfsecretCode.setDocument(new JTextFieldLimit(27));
        this.txtfsecretCode.setText("Secret Code");

        setLogo();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    private void setLogo() {
        String sourcefolder = System.getProperty("user.dir") + "\\src\\productthumbnail\\";
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(sourcefolder + "logo.png"));
                this.setTitle("PAWG Vending Machine");

    }

    private class JTextFieldLimit extends PlainDocument {

        private int limit;

        JTextFieldLimit(int limit) {
            super();
            this.limit = limit;
        }

        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null) {
                return;
            }

            if ((getLength() + str.length()) <= limit) {
                super.insertString(offset, str, attr);
            }
        }
    }
    
    private void checkCode() {

        if (txtfsecretCode.getText().equals("177013")) {
            try {
                RegisterStaffMenu rsmenu = new RegisterStaffMenu();
                rsmenu.setVisible(true);
                dispose();
            } catch (IOException ex) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Beep Boop!!! Access denied!");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        windowsControl = new javax.swing.JPanel();
        windowsLogo = new javax.swing.JPanel();
        panellogo = new javax.swing.JPanel();
        lbllogo = new javax.swing.JLabel();
        windowsButtons1 = new javax.swing.JPanel();
        btnminmax = new javax.swing.JPanel();
        lblminmax = new javax.swing.JLabel();
        btnclose = new javax.swing.JPanel();
        lblclose = new javax.swing.JLabel();
        windowsButtons2 = new javax.swing.JPanel();
        paneltitle = new javax.swing.JPanel();
        lbltitle = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        iconSee = new javax.swing.JLabel();
        iconNoSee = new javax.swing.JLabel();
        btnSecret = new javax.swing.JButton();
        chkpass = new javax.swing.JCheckBox();
        txtfsecretCode = new javax.swing.JPasswordField();
        KbtnBack = new keeptoo.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(670, 320));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        windowsControl.setBackground(new java.awt.Color(51, 51, 51));
        windowsControl.setPreferredSize(new java.awt.Dimension(100, 50));
        windowsControl.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                windowsControlMouseDragged(evt);
            }
        });
        windowsControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                windowsControlMousePressed(evt);
            }
        });
        windowsControl.setLayout(new java.awt.BorderLayout());

        windowsLogo.setBackground(new java.awt.Color(51, 51, 51));
        windowsLogo.setPreferredSize(new java.awt.Dimension(75, 50));

        panellogo.setBackground(new java.awt.Color(51, 51, 51));
        panellogo.setPreferredSize(new java.awt.Dimension(75, 50));
        panellogo.setLayout(new java.awt.BorderLayout());

        lbllogo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbllogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/PAWG.png"))); // NOI18N
        lbllogo.setMaximumSize(new java.awt.Dimension(75, 50));
        lbllogo.setMinimumSize(new java.awt.Dimension(50, 50));
        lbllogo.setPreferredSize(new java.awt.Dimension(75, 50));
        lbllogo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbllogoMouseDragged(evt);
            }
        });
        lbllogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbllogoMousePressed(evt);
            }
        });
        panellogo.add(lbllogo, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout windowsLogoLayout = new javax.swing.GroupLayout(windowsLogo);
        windowsLogo.setLayout(windowsLogoLayout);
        windowsLogoLayout.setHorizontalGroup(
            windowsLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(windowsLogoLayout.createSequentialGroup()
                .addComponent(panellogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        windowsLogoLayout.setVerticalGroup(
            windowsLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, windowsLogoLayout.createSequentialGroup()
                .addComponent(panellogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        windowsControl.add(windowsLogo, java.awt.BorderLayout.LINE_START);

        windowsButtons1.setBackground(new java.awt.Color(51, 51, 51));
        windowsButtons1.setPreferredSize(new java.awt.Dimension(200, 50));

        btnminmax.setBackground(new java.awt.Color(51, 51, 51));
        btnminmax.setLayout(new java.awt.BorderLayout());

        lblminmax.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblminmax.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/minimize.png"))); // NOI18N
        lblminmax.setMaximumSize(new java.awt.Dimension(50, 50));
        lblminmax.setMinimumSize(new java.awt.Dimension(50, 50));
        lblminmax.setPreferredSize(new java.awt.Dimension(50, 50));
        lblminmax.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblminmaxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblminmaxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblminmaxMouseExited(evt);
            }
        });
        btnminmax.add(lblminmax, java.awt.BorderLayout.CENTER);

        btnclose.setBackground(new java.awt.Color(51, 51, 51));
        btnclose.setLayout(new java.awt.BorderLayout());

        lblclose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblclose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/X.png"))); // NOI18N
        lblclose.setMaximumSize(new java.awt.Dimension(50, 50));
        lblclose.setMinimumSize(new java.awt.Dimension(50, 50));
        lblclose.setPreferredSize(new java.awt.Dimension(50, 50));
        lblclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblcloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblcloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblcloseMouseExited(evt);
            }
        });
        btnclose.add(lblclose, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout windowsButtons1Layout = new javax.swing.GroupLayout(windowsButtons1);
        windowsButtons1.setLayout(windowsButtons1Layout);
        windowsButtons1Layout.setHorizontalGroup(
            windowsButtons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(windowsButtons1Layout.createSequentialGroup()
                .addGap(0, 98, Short.MAX_VALUE)
                .addComponent(btnminmax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnclose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        windowsButtons1Layout.setVerticalGroup(
            windowsButtons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, windowsButtons1Layout.createSequentialGroup()
                .addGroup(windowsButtons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnminmax, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnclose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        windowsControl.add(windowsButtons1, java.awt.BorderLayout.LINE_END);

        windowsButtons2.setBackground(new java.awt.Color(51, 51, 51));

        paneltitle.setBackground(new java.awt.Color(51, 51, 51));
        paneltitle.setLayout(new java.awt.BorderLayout());

        lbltitle.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbltitle.setForeground(new java.awt.Color(255, 255, 255));
        lbltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitle.setText("Secret Access Code Required!");
        lbltitle.setMaximumSize(new java.awt.Dimension(500, 50));
        lbltitle.setMinimumSize(new java.awt.Dimension(50, 50));
        lbltitle.setPreferredSize(new java.awt.Dimension(500, 50));

        javax.swing.GroupLayout windowsButtons2Layout = new javax.swing.GroupLayout(windowsButtons2);
        windowsButtons2.setLayout(windowsButtons2Layout);
        windowsButtons2Layout.setHorizontalGroup(
            windowsButtons2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, windowsButtons2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paneltitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(373, 373, 373))
        );
        windowsButtons2Layout.setVerticalGroup(
            windowsButtons2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneltitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, windowsButtons2Layout.createSequentialGroup()
                .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        windowsControl.add(windowsButtons2, java.awt.BorderLayout.CENTER);

        getContentPane().add(windowsControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, -1));

        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(28, 167, 236));
        kGradientPanel1.setkStartColor(new java.awt.Color(31, 47, 152));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Provide the Secret PAWG Code to Continue");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(null);

        iconSee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/see.png"))); // NOI18N
        iconSee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                iconSeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                iconSeeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                iconSeeMousePressed(evt);
            }
        });
        jPanel1.add(iconSee);
        iconSee.setBounds(270, 50, 40, 40);

        iconNoSee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/nosee.png"))); // NOI18N
        iconNoSee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                iconNoSeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                iconNoSeeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                iconNoSeeMousePressed(evt);
            }
        });
        jPanel1.add(iconNoSee);
        iconNoSee.setBounds(270, 50, 40, 40);

        btnSecret.setBackground(new java.awt.Color(204, 0, 0));
        btnSecret.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/lock.png"))); // NOI18N
        btnSecret.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSecret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecretActionPerformed(evt);
            }
        });
        jPanel1.add(btnSecret);
        btnSecret.setBounds(360, 40, 230, 70);

        chkpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkpassActionPerformed(evt);
            }
        });
        jPanel1.add(chkpass);
        chkpass.setBounds(0, 140, 85, 20);

        txtfsecretCode.setBackground(new java.awt.Color(102, 102, 102));
        txtfsecretCode.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        txtfsecretCode.setForeground(new java.awt.Color(255, 255, 255));
        txtfsecretCode.setText("Secret Code");
        txtfsecretCode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtfsecretCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfsecretCodeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfsecretCodeFocusLost(evt);
            }
        });
        jPanel1.add(txtfsecretCode);
        txtfsecretCode.setBounds(30, 40, 280, 60);

        kGradientPanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 620, 160));

        KbtnBack.setText("Back");
        KbtnBack.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        KbtnBack.setkEndColor(new java.awt.Color(255, 51, 255));
        KbtnBack.setkHoverEndColor(new java.awt.Color(204, 0, 0));
        KbtnBack.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        KbtnBack.setkHoverStartColor(new java.awt.Color(204, 0, 204));
        KbtnBack.setkPressedColor(new java.awt.Color(153, 0, 51));
        KbtnBack.setkStartColor(new java.awt.Color(204, 0, 0));
        KbtnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                KbtnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                KbtnBackMouseExited(evt);
            }
        });
        KbtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KbtnBackActionPerformed(evt);
            }
        });
        kGradientPanel1.add(KbtnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 670, 270));

        setSize(new java.awt.Dimension(670, 320));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void changecolor(JPanel hover, Color rand) {
        hover.setBackground(rand);

    }
    private void windowsControlMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_windowsControlMouseDragged
        int kordinatX = evt.getXOnScreen();
        int kordinatY = evt.getYOnScreen();

        this.setLocation(kordinatX - mousepX, kordinatY - mousepY);
    }//GEN-LAST:event_windowsControlMouseDragged

    private void windowsControlMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_windowsControlMousePressed
        mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_windowsControlMousePressed

    private void lblcloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblcloseMouseClicked

    private void lblcloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcloseMouseEntered
        changecolor(btnclose, new Color(93, 93, 93));
        lblclose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));    }//GEN-LAST:event_lblcloseMouseEntered

    private void lblcloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcloseMouseExited
        changecolor(btnclose, new Color(51, 51, 51));
        lblclose.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));    }//GEN-LAST:event_lblcloseMouseExited

    private void lbllogoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogoMousePressed
        mousepX = evt.getX();
        mousepY = evt.getY();    }//GEN-LAST:event_lbllogoMousePressed

    private void lbllogoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogoMouseDragged
        int kordinatX = evt.getXOnScreen();
        int kordinatY = evt.getYOnScreen();

        this.setLocation(kordinatX - mousepX, kordinatY - mousepY);    }//GEN-LAST:event_lbllogoMouseDragged

    private void lblminmaxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblminmaxMouseEntered
        changecolor(btnminmax, new Color(93, 93, 93));
        lblminmax.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));    }//GEN-LAST:event_lblminmaxMouseEntered

    private void lblminmaxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblminmaxMouseExited
        changecolor(btnminmax, new Color(51, 51, 51));
        lblminmax.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));    }//GEN-LAST:event_lblminmaxMouseExited

    private void lblminmaxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblminmaxMouseClicked
        setState(this.ICONIFIED);
    }//GEN-LAST:event_lblminmaxMouseClicked

    private void KbtnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KbtnBackMouseEntered
        KbtnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_KbtnBackMouseEntered

    private void KbtnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KbtnBackMouseExited
        KbtnBack.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_KbtnBackMouseExited

    private void KbtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KbtnBackActionPerformed
        LoginMenu lmenu = new LoginMenu();
        lmenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_KbtnBackActionPerformed

    private void btnSecretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecretActionPerformed
        checkCode();
    }//GEN-LAST:event_btnSecretActionPerformed

    private void chkpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkpassActionPerformed
        if (chkpass.isSelected()) {
            txtfsecretCode.setEchoChar((char) 0);
        } else {
            txtfsecretCode.setEchoChar('*');
        }
    }//GEN-LAST:event_chkpassActionPerformed

    private void txtfsecretCodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfsecretCodeFocusGained
        if ("".equals(txtfsecretCode.getText()) || "Secret Code".equals(txtfsecretCode.getText())) {
            txtfsecretCode.setText("");
            txtfsecretCode.setForeground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtfsecretCodeFocusGained

    private void txtfsecretCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfsecretCodeFocusLost
        if ("".equals(txtfsecretCode.getText())) {
            txtfsecretCode.setForeground(new java.awt.Color(255, 255, 255));
            txtfsecretCode.setText("Secret Code");
        }
    }//GEN-LAST:event_txtfsecretCodeFocusLost

    private void iconNoSeeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconNoSeeMousePressed
        iconNoSee.setVisible(false);
        iconSee.setVisible(true);
        txtfsecretCode.setEchoChar('*');

    }//GEN-LAST:event_iconNoSeeMousePressed

    private void iconSeeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconSeeMousePressed
        iconNoSee.setVisible(true);
        iconSee.setVisible(false);
        txtfsecretCode.setEchoChar((char) 0);
    }//GEN-LAST:event_iconSeeMousePressed

    private void iconSeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconSeeMouseEntered
        iconSee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_iconSeeMouseEntered

    private void iconSeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconSeeMouseExited
        iconSee.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_iconSeeMouseExited

    private void iconNoSeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconNoSeeMouseEntered
        iconNoSee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_iconNoSeeMouseEntered

    private void iconNoSeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconNoSeeMouseExited
        iconNoSee.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_iconNoSeeMouseExited

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
            java.util.logging.Logger.getLogger(SecretMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SecretMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SecretMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SecretMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new SecretMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton KbtnBack;
    private javax.swing.JButton btnSecret;
    private javax.swing.JPanel btnclose;
    private javax.swing.JPanel btnminmax;
    private javax.swing.JCheckBox chkpass;
    private javax.swing.JLabel iconNoSee;
    private javax.swing.JLabel iconSee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblclose;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JLabel lblminmax;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JPanel panellogo;
    private javax.swing.JPanel paneltitle;
    private javax.swing.JPasswordField txtfsecretCode;
    private javax.swing.JPanel windowsButtons1;
    private javax.swing.JPanel windowsButtons2;
    private javax.swing.JPanel windowsControl;
    private javax.swing.JPanel windowsLogo;
    // End of variables declaration//GEN-END:variables
}
