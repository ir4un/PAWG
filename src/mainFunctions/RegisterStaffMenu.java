/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainFunctions;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author ir4un
 */
public class RegisterStaffMenu extends javax.swing.JFrame {

    /**
     * Creates new form startMenu
     */
    private int mousepX;
    private int mousepY;
    private String generatedStaffID;
    final DecimalFormat idformat = new DecimalFormat("000");
    private String retrievedDate;
    private Boolean validationCondition;
    private boolean duplicateDetected;
    private int countLine = 1;

    public RegisterStaffMenu() throws IOException {

        initComponents();
        this.jDateDOB.setEnabled(false);
        this.jDateDOB.getCalendarButton().setEnabled(true);
        this.scrollpnl.getVerticalScrollBar().setUnitIncrement(16);
        this.txtfstaffusername.setDocument(new JTextFieldLimit(35));
        this.txtfstaffpassword.setDocument(new JTextFieldLimit(35));
        this.txtfstaffrealname.setDocument(new JTextFieldLimit(50));
        this.txtfstaffemail.setDocument(new JTextFieldLimit(50));
        this.txtfstaffphonenumber.setDocument(new JTextFieldLimit(50));

        this.txtfstaffusername.setText("Username");
        this.txtfstaffpassword.setText("Password");
        this.txtfstaffrealname.setText("Real Name");
        this.txtfstaffemail.setText("Email");
        this.txtfstaffphonenumber.setText("Phone Number");

        setLogo();
    }

    public void setLogo() {
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

    private void insertData() {

        try {
            String source = System.getProperty("user.dir") + "\\src\\txtdatabase\\stafflist.txt"; //Retrieving Directory of stafflist.txt File.
            File file = new File(source);
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bf = new BufferedWriter(fw);

            String staff_id = generatedStaffID;
            String staff_username = txtfstaffusername.getText();
            String staff_password = txtfstaffpassword.getText();
            String staff_realName = txtfstaffrealname.getText();

            Date selectedDate = jDateDOB.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            String staff_dob = sdf.format(selectedDate);
            String staff_email = txtfstaffemail.getText();
            String staff_phoneNumber = txtfstaffphonenumber.getText();

            String datalist
                    = staff_id + "::"
                    + staff_username + "::"
                    + staff_password + "::"
                    + staff_realName + "::"
                    + staff_dob + "::"
                    + staff_email + "::"
                    + staff_phoneNumber
                    + "\n";

            bf.write(datalist); //Writes the Values From The Variables to the stafflist.txt File.
            bf.close();
        } catch (IOException e) {
        }

    }

    private void staffIDincrement() {
        try {

            String source = System.getProperty("user.dir") + "\\src\\txtdatabase\\stafflist.txt"; //Retrieving Directory of stafflist.txt File.
            File stafflisttxt = new File(source);
            FileReader fr = new FileReader(stafflisttxt);
            BufferedReader br = new BufferedReader(fr);
            String list;

            while ((list = br.readLine()) != null) { //Counts the total amount of lines in the text file.
                countLine++;
            }

            generatedStaffID = idformat.format(countLine);

        } catch (Exception e) {

        }

    }

    private boolean emptyValidation() {
        Date selectedDate = jDateDOB.getDate();
       if (txtfstaffusername.getText().equals("Username") || txtfstaffusername.getText().equals("")
                || txtfstaffpassword.getText().equals("") || txtfstaffpassword.getText().equals("Password")
                || txtfstaffrealname.getText().equals("") || txtfstaffrealname.getText().equals("Real Name")
                || selectedDate == null
                || txtfstaffemail.getText().equals("") || txtfstaffemail.getText().equals("Email")
                || txtfstaffphonenumber.getText().equals("") || txtfstaffphonenumber.getText().equals("Phone Number")) {
            return false;
        } else {
            return true;
        }
    }

    private void validationMessage() {
        Date selectedDate = jDateDOB.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        if (selectedDate != null) {
            retrievedDate = sdf.format(selectedDate);
        }

        if ((validateUsername(txtfstaffusername.getText())) == true
                && (validatePassword(txtfstaffpassword.getText())) == true
                && (validateRealName(txtfstaffrealname.getText())) == true
                && (validateDOB(retrievedDate)) == true
                && (validateEmail(txtfstaffemail.getText()) == true)
                && (validatePhoneNumber(txtfstaffphonenumber.getText())) == true) {
            validationCondition = true;
        } else if ((validateUsername(txtfstaffusername.getText())) == false) {
            JOptionPane.showMessageDialog(null, "Invalid Username. Make Sure Not To Include Any Special Characters and With At Least 3 Characters!");
            validationCondition = false;
        } else if (validationUsernameDuplicate((txtfstaffusername.getText())) == false) {
            JOptionPane.showMessageDialog(null, "Username Taken! Please Try Another Username. \n Sorry About That. :p.");
            validationCondition = false;
        } else if (validatePassword(txtfstaffpassword.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Incorrect Password Format! Please Try Again with At Least 5 Characters.");
            validationCondition = false;
        } else if (validateRealName(txtfstaffrealname.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Incorrect Real Name Format! Please Try Again and With At Least 3 Characters!");
            validationCondition = false;
        } else if (validateDOB(retrievedDate) == false) {
            JOptionPane.showMessageDialog(null, "Incorrect Date Format! Please Try Again.");
            validationCondition = false;
        } else if (validateEmail(txtfstaffemail.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Incorrect Email Format! Please Try Again.");
            validationCondition = false;
        } else if (validatePhoneNumber(txtfstaffphonenumber.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Incorrect Phone Number Format! Please Try Again.");
            validationCondition = false;
        } else {
        }

    }

    private boolean validationUsernameDuplicate(String retrievedUsername) {

        try {

            String source = System.getProperty("user.dir");
            File file = new File(source + "\\src\\txtdatabase\\stafflist.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String record;
            while ((record = br.readLine()) != null) {

                String[] fields = record.split("::");
                String staff_username = fields[1];

                if (retrievedUsername.equals(staff_username)) { 
                    br.close();
                    duplicateDetected = false;
                } else {
                    duplicateDetected = true;
                }
            }
            br.close();
        } catch (Exception e) {
        }

        return duplicateDetected;

    }

    private boolean validateUsername(String retrievedUsername) {
        String usernameRegex = "^[a-zA-Z0-9!@#$%^&.,<>` ]{3,}$";
        Pattern usernamePattern = Pattern.compile(usernameRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = usernamePattern.matcher(retrievedUsername);
        return matcher.find();
    }

    private boolean validatePassword(String retrievedPassword) {
        String passwordRegex = "^[a-zA-Z0-9!@#$%^&.,<>` ]{5,}$";
        Pattern passwordPattern = Pattern.compile(passwordRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = passwordPattern.matcher(retrievedPassword);
        return matcher.find();
    }

    private boolean validateRealName(String retrievedRealName) {
        String realnameRegex = "^[a-zA-Z ]{3,}$";
        Pattern realnamePattern = Pattern.compile(realnameRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = realnamePattern.matcher(retrievedRealName);
        return matcher.find();
    }

    private boolean validateDOB(String retrievedDOB) {
        String dobRegex = "^[a-zA-Z0-9- ]{3,}$";
        Pattern dobPattern = Pattern.compile(dobRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = dobPattern.matcher(retrievedDOB);
        return matcher.find();
    }

    private boolean validateEmail(String retrievedEmail) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPattern.matcher(retrievedEmail);
        return matcher.find();
    }

    private boolean validatePhoneNumber(String retrievedPhoneNumber) {
        String phonenumberRegex = "^[0-9 -]{3,}$";
        Pattern phonenumberPattern = Pattern.compile(phonenumberRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = phonenumberPattern.matcher(retrievedPhoneNumber);
        return matcher.find();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
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
        pnlContent = new keeptoo.KGradientPanel();
        scrollpnl = new javax.swing.JScrollPane();
        pnlMainContent = new javax.swing.JPanel();
        pnlDisplay = new javax.swing.JPanel();
        txtfstaffusername = new javax.swing.JTextField();
        txtfstaffpassword = new javax.swing.JTextField();
        txtfstaffphonenumber = new javax.swing.JTextField();
        KbtnRegister = new keeptoo.KButton();
        jDateDOB = new com.toedter.calendar.JDateChooser();
        txtfstaffrealname = new javax.swing.JTextField();
        txtfstaffemail = new javax.swing.JTextField();
        KbtnBack = new keeptoo.KButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1024, 600));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1024, 600));
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
        lbltitle.setText("Register New Staff");
        lbltitle.setMaximumSize(new java.awt.Dimension(500, 50));
        lbltitle.setMinimumSize(new java.awt.Dimension(50, 50));
        lbltitle.setPreferredSize(new java.awt.Dimension(500, 50));

        javax.swing.GroupLayout windowsButtons2Layout = new javax.swing.GroupLayout(windowsButtons2);
        windowsButtons2.setLayout(windowsButtons2Layout);
        windowsButtons2Layout.setHorizontalGroup(
            windowsButtons2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, windowsButtons2Layout.createSequentialGroup()
                .addContainerGap(172, Short.MAX_VALUE)
                .addComponent(paneltitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        windowsButtons2Layout.setVerticalGroup(
            windowsButtons2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneltitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(windowsButtons2Layout.createSequentialGroup()
                .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        windowsControl.add(windowsButtons2, java.awt.BorderLayout.CENTER);

        getContentPane().add(windowsControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1025, -1));

        pnlContent.setkBorderRadius(0);
        pnlContent.setkEndColor(new java.awt.Color(28, 167, 236));
        pnlContent.setkStartColor(new java.awt.Color(31, 47, 152));
        pnlContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollpnl.setBorder(null);
        scrollpnl.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpnl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scrollpnl.setPreferredSize(new java.awt.Dimension(553, 670));

        pnlMainContent.setBackground(new java.awt.Color(102, 102, 102));
        pnlMainContent.setMaximumSize(new java.awt.Dimension(1024, 600));
        pnlMainContent.setPreferredSize(new java.awt.Dimension(553, 670));

        pnlDisplay.setBackground(new java.awt.Color(102, 102, 102));
        pnlDisplay.setMaximumSize(new java.awt.Dimension(546, 670));
        pnlDisplay.setPreferredSize(new java.awt.Dimension(546, 670));
        pnlDisplay.setLayout(null);

        txtfstaffusername.setBackground(new java.awt.Color(102, 102, 102));
        txtfstaffusername.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        txtfstaffusername.setForeground(new java.awt.Color(255, 255, 255));
        txtfstaffusername.setText("Username");
        txtfstaffusername.setToolTipText("At Least 35 Characters!");
        txtfstaffusername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtfstaffusername.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        txtfstaffusername.setOpaque(false);
        txtfstaffusername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfstaffusernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfstaffusernameFocusLost(evt);
            }
        });
        txtfstaffusername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfstaffusernameKeyTyped(evt);
            }
        });
        pnlDisplay.add(txtfstaffusername);
        txtfstaffusername.setBounds(40, 30, 450, 60);

        txtfstaffpassword.setBackground(new java.awt.Color(102, 102, 102));
        txtfstaffpassword.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        txtfstaffpassword.setForeground(new java.awt.Color(255, 255, 255));
        txtfstaffpassword.setText("Password");
        txtfstaffpassword.setToolTipText("Must Be At Least 5 Characters!");
        txtfstaffpassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtfstaffpassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfstaffpasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfstaffpasswordFocusLost(evt);
            }
        });
        txtfstaffpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfstaffpasswordActionPerformed(evt);
            }
        });
        pnlDisplay.add(txtfstaffpassword);
        txtfstaffpassword.setBounds(40, 110, 450, 60);

        txtfstaffphonenumber.setBackground(new java.awt.Color(102, 102, 102));
        txtfstaffphonenumber.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        txtfstaffphonenumber.setForeground(new java.awt.Color(255, 255, 255));
        txtfstaffphonenumber.setText("Phone Number");
        txtfstaffphonenumber.setToolTipText("Provide Correct Phone Number Format");
        txtfstaffphonenumber.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtfstaffphonenumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfstaffphonenumberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfstaffphonenumberFocusLost(evt);
            }
        });
        txtfstaffphonenumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfstaffphonenumberActionPerformed(evt);
            }
        });
        pnlDisplay.add(txtfstaffphonenumber);
        txtfstaffphonenumber.setBounds(40, 440, 450, 60);

        KbtnRegister.setText("Register");
        KbtnRegister.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        KbtnRegister.setkEndColor(new java.awt.Color(28, 167, 236));
        KbtnRegister.setkHoverEndColor(new java.awt.Color(31, 47, 152));
        KbtnRegister.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        KbtnRegister.setkHoverStartColor(new java.awt.Color(28, 167, 236));
        KbtnRegister.setkPressedColor(new java.awt.Color(0, 102, 204));
        KbtnRegister.setkStartColor(new java.awt.Color(31, 47, 152));
        KbtnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                KbtnRegisterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                KbtnRegisterMouseExited(evt);
            }
        });
        KbtnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KbtnRegisterActionPerformed(evt);
            }
        });
        pnlDisplay.add(KbtnRegister);
        KbtnRegister.setBounds(120, 550, 300, 70);

        jDateDOB.setBackground(new java.awt.Color(102, 102, 102));
        jDateDOB.setForeground(new java.awt.Color(255, 255, 255));
        jDateDOB.setToolTipText("");
        jDateDOB.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jDateDOB.setOpaque(false);
        jDateDOB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jDateDOBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jDateDOBMouseExited(evt);
            }
        });
        pnlDisplay.add(jDateDOB);
        jDateDOB.setBounds(40, 280, 450, 60);

        txtfstaffrealname.setBackground(new java.awt.Color(102, 102, 102));
        txtfstaffrealname.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        txtfstaffrealname.setForeground(new java.awt.Color(255, 255, 255));
        txtfstaffrealname.setText("Real Name");
        txtfstaffrealname.setToolTipText("At Least 50 Characters!");
        txtfstaffrealname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtfstaffrealname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfstaffrealnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfstaffrealnameFocusLost(evt);
            }
        });
        txtfstaffrealname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfstaffrealnameActionPerformed(evt);
            }
        });
        pnlDisplay.add(txtfstaffrealname);
        txtfstaffrealname.setBounds(40, 190, 450, 60);

        txtfstaffemail.setBackground(new java.awt.Color(102, 102, 102));
        txtfstaffemail.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        txtfstaffemail.setForeground(new java.awt.Color(255, 255, 255));
        txtfstaffemail.setText("Email");
        txtfstaffemail.setToolTipText("Provide Correct Email Format!");
        txtfstaffemail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtfstaffemail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfstaffemailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfstaffemailFocusLost(evt);
            }
        });
        txtfstaffemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfstaffemailActionPerformed(evt);
            }
        });
        pnlDisplay.add(txtfstaffemail);
        txtfstaffemail.setBounds(40, 360, 450, 60);

        javax.swing.GroupLayout pnlMainContentLayout = new javax.swing.GroupLayout(pnlMainContent);
        pnlMainContent.setLayout(pnlMainContentLayout);
        pnlMainContentLayout.setHorizontalGroup(
            pnlMainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlMainContentLayout.setVerticalGroup(
            pnlMainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        scrollpnl.setViewportView(pnlMainContent);

        pnlContent.add(scrollpnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 560, 440));

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
        pnlContent.add(KbtnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Insert Staff Details Into The Vending Machine");
        pnlContent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        getContentPane().add(pnlContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1030, 550));

        setSize(new java.awt.Dimension(1025, 600));
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

    private void txtfstaffusernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfstaffusernameFocusGained
        if ("".equals(txtfstaffusername.getText()) || "Username".equals(txtfstaffusername.getText())) {
            txtfstaffusername.setText("");
            txtfstaffusername.setForeground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtfstaffusernameFocusGained

    private void txtfstaffusernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfstaffusernameFocusLost
        if ("".equals(txtfstaffusername.getText())) {
            txtfstaffusername.setForeground(new java.awt.Color(255, 255, 255));
            txtfstaffusername.setText("Username");
        }
    }//GEN-LAST:event_txtfstaffusernameFocusLost

    private void txtfstaffusernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfstaffusernameKeyTyped

    }//GEN-LAST:event_txtfstaffusernameKeyTyped

    private void txtfstaffpasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfstaffpasswordFocusGained
        if ("".equals(txtfstaffpassword.getText()) || "Password".equals(txtfstaffpassword.getText())) {
            txtfstaffpassword.setText("");
            txtfstaffpassword.setForeground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtfstaffpasswordFocusGained

    private void txtfstaffpasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfstaffpasswordFocusLost
        if ("".equals(txtfstaffpassword.getText())) {
            txtfstaffpassword.setForeground(new java.awt.Color(255, 255, 255));
            txtfstaffpassword.setText("Password");
        }
    }//GEN-LAST:event_txtfstaffpasswordFocusLost

    private void txtfstaffpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfstaffpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfstaffpasswordActionPerformed

    private void txtfstaffphonenumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfstaffphonenumberFocusGained
        if ("".equals(txtfstaffphonenumber.getText()) || "Phone Number".equals(txtfstaffphonenumber.getText())) {
            txtfstaffphonenumber.setText("");
            txtfstaffphonenumber.setForeground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtfstaffphonenumberFocusGained

    private void txtfstaffphonenumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfstaffphonenumberFocusLost
        if ("".equals(txtfstaffphonenumber.getText())) {
            txtfstaffphonenumber.setForeground(new java.awt.Color(255, 255, 255));
            txtfstaffphonenumber.setText("Phone Number");
        }
    }//GEN-LAST:event_txtfstaffphonenumberFocusLost

    private void txtfstaffphonenumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfstaffphonenumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfstaffphonenumberActionPerformed

    private void KbtnRegisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KbtnRegisterMouseEntered
        KbtnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_KbtnRegisterMouseEntered

    private void KbtnRegisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KbtnRegisterMouseExited
        KbtnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_KbtnRegisterMouseExited

    private void KbtnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KbtnRegisterActionPerformed
        if (emptyValidation() == true) {
            validationMessage();
            if (validationCondition == true) {
                staffIDincrement();
                insertData();
                JOptionPane.showMessageDialog(null, txtfstaffusername.getText()
                        + " Has Been Successfully Registered! " + txtfstaffusername.getText()
                        + " Will Now Be Able To Login Into The PAWG Vending Machine System.");
                LoginMenu logmenu = new LoginMenu();
                logmenu.setVisible(true);
                dispose();
            } else {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Insert All of the Neccessary Information!");
        }
    }//GEN-LAST:event_KbtnRegisterActionPerformed

    private void KbtnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KbtnBackMouseEntered
        KbtnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_KbtnBackMouseEntered

    private void KbtnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KbtnBackMouseExited
        KbtnBack.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_KbtnBackMouseExited

    private void KbtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KbtnBackActionPerformed

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Go Back? \n Inserted Information Will Not be Saved!", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {

            try {
                LoginMenu logmenu = new LoginMenu();
                logmenu.setVisible(true);
                dispose();

            } catch (Exception e) {
            }
        } else {

        }


    }//GEN-LAST:event_KbtnBackActionPerformed

    private void txtfstaffrealnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfstaffrealnameFocusGained
        if ("".equals(txtfstaffrealname.getText()) || "Real Name".equals(txtfstaffrealname.getText())) {
            txtfstaffrealname.setText("");
            txtfstaffrealname.setForeground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtfstaffrealnameFocusGained

    private void txtfstaffrealnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfstaffrealnameFocusLost
        if ("".equals(txtfstaffrealname.getText())) {
            txtfstaffrealname.setForeground(new java.awt.Color(255, 255, 255));
            txtfstaffrealname.setText("Real Name");
        }
    }//GEN-LAST:event_txtfstaffrealnameFocusLost

    private void txtfstaffrealnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfstaffrealnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfstaffrealnameActionPerformed

    private void txtfstaffemailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfstaffemailFocusGained
        if ("".equals(txtfstaffemail.getText()) || "Email".equals(txtfstaffemail.getText())) {
            txtfstaffemail.setText("");
            txtfstaffemail.setForeground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtfstaffemailFocusGained

    private void txtfstaffemailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfstaffemailFocusLost
        if ("".equals(txtfstaffemail.getText())) {
            txtfstaffemail.setForeground(new java.awt.Color(255, 255, 255));
            txtfstaffemail.setText("Email");
        }
    }//GEN-LAST:event_txtfstaffemailFocusLost

    private void txtfstaffemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfstaffemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfstaffemailActionPerformed

    private void jDateDOBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateDOBMouseEntered
        jDateDOB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jDateDOBMouseEntered

    private void jDateDOBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateDOBMouseExited
        jDateDOB.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

    }//GEN-LAST:event_jDateDOBMouseExited

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
            java.util.logging.Logger.getLogger(RegisterStaffMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterStaffMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterStaffMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterStaffMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                try {
                    new RegisterStaffMenu().setVisible(true);
                } catch (IOException ex) {
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton KbtnBack;
    private keeptoo.KButton KbtnRegister;
    private javax.swing.JPanel btnclose;
    private javax.swing.JPanel btnminmax;
    private com.toedter.calendar.JDateChooser jDateDOB;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblclose;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JLabel lblminmax;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JPanel panellogo;
    private javax.swing.JPanel paneltitle;
    private keeptoo.KGradientPanel pnlContent;
    private javax.swing.JPanel pnlDisplay;
    private javax.swing.JPanel pnlMainContent;
    private javax.swing.JScrollPane scrollpnl;
    private javax.swing.JTextField txtfstaffemail;
    private javax.swing.JTextField txtfstaffpassword;
    private javax.swing.JTextField txtfstaffphonenumber;
    private javax.swing.JTextField txtfstaffrealname;
    private javax.swing.JTextField txtfstaffusername;
    private javax.swing.JPanel windowsButtons1;
    private javax.swing.JPanel windowsButtons2;
    private javax.swing.JPanel windowsControl;
    private javax.swing.JPanel windowsLogo;
    // End of variables declaration//GEN-END:variables
}
