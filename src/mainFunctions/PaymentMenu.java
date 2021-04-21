/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainFunctions;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 *
 * @author ir4un
 */
public class PaymentMenu extends javax.swing.JFrame {

    /**
     * Creates new form startMenu
     */
    private int mousepX;
    private int mousepY;
    private int currentQuantity;
    private int totalprice;
    private String selectedProductID;
    private String textinsertedpayment;
    private String totalpricedisplay;
    private String transIDAfterPayment;
    private Integer insertedQuantity;
    private Double totalpricevalue;
    private Double changevalue;
    private Double insertedpayment;
    private Double btnvalue;
    final DecimalFormat moneyformat = new DecimalFormat("0.00");
    final DecimalFormat idformat = new DecimalFormat("000");

    public PaymentMenu(String setProdID, Integer quantitybought, Double totalprice) throws IOException {

        initComponents();
        moneyformat.format(insertedpayment = 0.00);
        moneyformat.format(changevalue = 0.00);
        this.insertedQuantity = quantitybought;
        this.selectedProductID = setProdID;
        this.totalpricevalue = totalprice;
        displayprice();
        setLogo();
    }

    private void setLogo() {
        String sourcefolder = System.getProperty("user.dir") + "\\src\\productthumbnail\\";
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(sourcefolder + "logo.png"));
        this.setTitle("PAWG Vending Machine");

    }

    private void displayprice() {
        totalpricedisplay = moneyformat.format(totalpricevalue);
        lblProduct_totalprice.setText("Total Price: RM" + totalpricedisplay);
        String paymenttext = moneyformat.format(insertedpayment);
        String changetext = moneyformat.format(changevalue);
        lblinsertedAmount.setText("Inserted Amount: RM" + paymenttext);
        lblChange_total.setText("Change Received: RM" + changetext);
    }

    private void updatepayment(Double selectedbtnvalue) {
        insertedpayment = insertedpayment + selectedbtnvalue;
        String paymenttext = moneyformat.format(insertedpayment);
        lblinsertedAmount.setText("Inserted Amount: RM" + paymenttext);

        if (insertedpayment > totalpricevalue) {
            changevalue = insertedpayment - totalpricevalue;
            String changetext = moneyformat.format(changevalue);
            lblChange_total.setText("Change Received: RM" + changetext);
        }

    }

    private void resetpayment() {
        insertedpayment = insertedpayment - insertedpayment;
        String paymenttext = moneyformat.format(insertedpayment);
        lblinsertedAmount.setText("Inserted Amount: RM" + paymenttext);

        changevalue = insertedpayment - insertedpayment;
        String changetext = moneyformat.format(changevalue);
        lblChange_total.setText("Change Received: RM" + changetext);
    }

    private void storeTransaction() {

        try {

            String source = System.getProperty("user.dir") + "\\src\\txtdatabase\\itemlist.txt"; 
            File file = new File(source);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String record;

            while ((record = br.readLine()) != null) { 
                String[] fields = record.split("::");
                String product_id = fields[0];
                String product_name = fields[1];
                String product_price = fields[2];
                String product_quantity = fields[3];
                String product_thumbslot = fields[4];

                String lastNum = fields[0];

                if (selectedProductID.equals(product_id)) { 
                    String source2 = System.getProperty("user.dir") + "\\src\\txtdatabase\\transaction.txt"; 
                    File file2 = new File(source2);
                    FileWriter fw = new FileWriter(file2, true);
                    BufferedWriter bf = new BufferedWriter(fw);

                    String source3 = System.getProperty("user.dir") + "\\src\\txtdatabase\\transaction.txt"; 
                    String transid_return;
                    File file3 = new File(source3);
                    FileReader fr3 = new FileReader(file3);
                    BufferedReader br3 = new BufferedReader(fr3);
                    String record3;
                    int countLine = 1;

                    while ((record3 = br3.readLine()) != null) { 
                        countLine++;
                    }

                    transid_return = idformat.format(countLine);
                    DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    DateTimeFormatter time = DateTimeFormatter.ofPattern("hh:mm:ss a");
                    LocalDateTime now = LocalDateTime.now();

                    transIDAfterPayment = transid_return;
                    String trans_id = transid_return;
                    String trans_itemName = product_name;
                    String trans_itemQuantity = String.valueOf(insertedQuantity);
                    String trans_itemPrice = product_price;
                    String trans_itemTotalPrice = moneyformat.format(totalpricevalue);
                    String trans_amount_paid = moneyformat.format(insertedpayment);
                    String trans_date = date.format(now);
                    String trans_time = time.format(now);

                    String datalist = trans_id + "::" + trans_itemName + "::" + trans_itemQuantity + "::" + trans_itemPrice + "::" + trans_itemTotalPrice + "::" + trans_amount_paid + "::" + trans_date + "::" + trans_time + "\n";
                    bf.write(datalist); 
                    br3.close();
                    bf.close();
                    br.close();

                } else {

                }

            }

        } catch (IOException e) {
        }

    }

    private void insertData() {

        try {

            String source = System.getProperty("user.dir") + "\\src\\txtdatabase\\itemlist.txt"; 
            File file = new File(source);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String record;

            while ((record = br.readLine()) != null) {
                String[] fields = record.split("::");
                String product_id = fields[0];
                String product_name = fields[1];
                String product_price = fields[2];
                String product_quantity = fields[3];
                String product_thumbslot = fields[4];
                String product_desc = fields[5];

                String lastNum = fields[0];

                if (selectedProductID.equals(product_id)) { 
                    br.close();
                    deleteData(source, product_id, 1, "::"); 
                    FileWriter fw = new FileWriter(file, true);
                    BufferedWriter bf = new BufferedWriter(fw);

                    currentQuantity = Integer.parseInt(product_quantity) - insertedQuantity;
                    String newproduct_quantity = String.valueOf(currentQuantity); 

                    String datalist = product_id + "::" + product_name + "::" + product_price + "::" + newproduct_quantity + "::" + product_thumbslot + "::" + product_desc + "\n";

                    bf.write(datalist); 
                    bf.close();
                    br.close();
                    sortData(source, source);

                } else {

                }

            }

        } catch (IOException e) {
        }

    }

    private void deleteData(String filepath, String removeterm, int positionOfTerm, String delimiter) throws IOException {

        int position = positionOfTerm - 1; // Integer Value Assigned To Choose Which Column in a Line To Be Selected for Deletion.
        String tempFile = System.getProperty("user.dir") + "\\src\\txtdatabase\\temp.txt"; //Creates A Temporary File Which Will Store the Updated itemlist.txt File.
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        String readData;
        String data[];

        try {

            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            while ((readData = br.readLine()) != null) { //Data in soon deleted text file will Be Inserted into data Array.
                data = readData.split("::");
                if (!(data[position].equalsIgnoreCase(removeterm))) { //Identify Which Line Contains the removeterm Value.
                    pw.println(readData); //Writes to the temp.txt File Without the Data of the Identified Line with the removeterm Value.
                }
            }

            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            oldFile.delete(); //Deletes The Original text file.
            File dump = new File(filepath);
            newFile.renameTo(dump); //Renames The temp.txt File to the original text file name.

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Occured While Trying To Delete Data");
        }

    }

    private void sortData(String filepath, String tofileName) {

        try {

            Path path = Paths.get(filepath);
            Charset charset = Charset.forName("UTF-8");

            List<String> lines = Files.readAllLines(path, charset);
            Collections.sort(lines, new IgnoreCase());

            Path toPath = Paths.get(tofileName);
            Files.write(toPath, lines, charset);

        } catch (IOException ex) {

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
        jPanel2 = new javax.swing.JPanel();
        KbtnLogin = new keeptoo.KButton();
        pnlTotalPrice = new keeptoo.KGradientPanel();
        lblProduct_totalprice = new javax.swing.JLabel();
        pnlTotalPrice1 = new keeptoo.KGradientPanel();
        lblinsertedAmount = new javax.swing.JLabel();
        pnlTotalPrice2 = new keeptoo.KGradientPanel();
        lblChange_total = new javax.swing.JLabel();
        KbtnReset = new keeptoo.KButton();
        pnlMoneybtn = new keeptoo.KGradientPanel();
        btnrm1 = new javax.swing.JButton();
        btnrm5 = new javax.swing.JButton();
        btnrm10 = new javax.swing.JButton();
        btnrm20 = new javax.swing.JButton();
        btnrm50 = new javax.swing.JButton();
        btnrm005 = new javax.swing.JButton();
        btnrm01 = new javax.swing.JButton();
        btnrm02 = new javax.swing.JButton();
        btnrm05 = new javax.swing.JButton();
        btnrm100 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        KbtnBack = new keeptoo.KButton();

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
        lbltitle.setText("Payment Menu");
        lbltitle.setMaximumSize(new java.awt.Dimension(500, 50));
        lbltitle.setMinimumSize(new java.awt.Dimension(50, 50));
        lbltitle.setPreferredSize(new java.awt.Dimension(500, 50));

        javax.swing.GroupLayout windowsButtons2Layout = new javax.swing.GroupLayout(windowsButtons2);
        windowsButtons2.setLayout(windowsButtons2Layout);
        windowsButtons2Layout.setHorizontalGroup(
            windowsButtons2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, windowsButtons2Layout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
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

        getContentPane().add(windowsControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, -1));

        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(28, 167, 236));
        kGradientPanel1.setkStartColor(new java.awt.Color(31, 47, 152));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1024, 600));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(null);

        KbtnLogin.setText("Pay");
        KbtnLogin.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        KbtnLogin.setkEndColor(new java.awt.Color(28, 167, 236));
        KbtnLogin.setkHoverEndColor(new java.awt.Color(31, 47, 152));
        KbtnLogin.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        KbtnLogin.setkHoverStartColor(new java.awt.Color(28, 167, 236));
        KbtnLogin.setkPressedColor(new java.awt.Color(0, 102, 204));
        KbtnLogin.setkStartColor(new java.awt.Color(31, 47, 152));
        KbtnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                KbtnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                KbtnLoginMouseExited(evt);
            }
        });
        KbtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KbtnLoginActionPerformed(evt);
            }
        });
        jPanel2.add(KbtnLogin);
        KbtnLogin.setBounds(690, 380, 260, 50);

        pnlTotalPrice.setkBorderRadius(0);
        pnlTotalPrice.setkEndColor(new java.awt.Color(102, 102, 102));
        pnlTotalPrice.setkStartColor(new java.awt.Color(153, 153, 153));

        lblProduct_totalprice.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        lblProduct_totalprice.setForeground(new java.awt.Color(255, 255, 255));
        lblProduct_totalprice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProduct_totalprice.setText("Total Price: RM0000.00");

        javax.swing.GroupLayout pnlTotalPriceLayout = new javax.swing.GroupLayout(pnlTotalPrice);
        pnlTotalPrice.setLayout(pnlTotalPriceLayout);
        pnlTotalPriceLayout.setHorizontalGroup(
            pnlTotalPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProduct_totalprice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        pnlTotalPriceLayout.setVerticalGroup(
            pnlTotalPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProduct_totalprice, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel2.add(pnlTotalPrice);
        pnlTotalPrice.setBounds(0, 0, 980, 70);

        pnlTotalPrice1.setkBorderRadius(0);
        pnlTotalPrice1.setkEndColor(new java.awt.Color(120, 127, 246));
        pnlTotalPrice1.setkStartColor(new java.awt.Color(123, 213, 245));

        lblinsertedAmount.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        lblinsertedAmount.setForeground(new java.awt.Color(255, 255, 255));
        lblinsertedAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblinsertedAmount.setText("Inserted Amount: RM0000.00");

        javax.swing.GroupLayout pnlTotalPrice1Layout = new javax.swing.GroupLayout(pnlTotalPrice1);
        pnlTotalPrice1.setLayout(pnlTotalPrice1Layout);
        pnlTotalPrice1Layout.setHorizontalGroup(
            pnlTotalPrice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblinsertedAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );
        pnlTotalPrice1Layout.setVerticalGroup(
            pnlTotalPrice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblinsertedAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel2.add(pnlTotalPrice1);
        pnlTotalPrice1.setBounds(0, 70, 490, 80);

        pnlTotalPrice2.setkBorderRadius(0);
        pnlTotalPrice2.setkEndColor(new java.awt.Color(123, 213, 245));
        pnlTotalPrice2.setkStartColor(new java.awt.Color(120, 127, 246));

        lblChange_total.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        lblChange_total.setForeground(new java.awt.Color(255, 255, 255));
        lblChange_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChange_total.setText("Change Received: RM0000.00");

        javax.swing.GroupLayout pnlTotalPrice2Layout = new javax.swing.GroupLayout(pnlTotalPrice2);
        pnlTotalPrice2.setLayout(pnlTotalPrice2Layout);
        pnlTotalPrice2Layout.setHorizontalGroup(
            pnlTotalPrice2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblChange_total, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );
        pnlTotalPrice2Layout.setVerticalGroup(
            pnlTotalPrice2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblChange_total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel2.add(pnlTotalPrice2);
        pnlTotalPrice2.setBounds(490, 70, 490, 80);

        KbtnReset.setText("Reset");
        KbtnReset.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        KbtnReset.setkEndColor(new java.awt.Color(204, 0, 0));
        KbtnReset.setkHoverEndColor(new java.awt.Color(255, 102, 0));
        KbtnReset.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        KbtnReset.setkHoverStartColor(new java.awt.Color(204, 0, 0));
        KbtnReset.setkPressedColor(new java.awt.Color(153, 0, 0));
        KbtnReset.setkStartColor(new java.awt.Color(255, 102, 0));
        KbtnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                KbtnResetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                KbtnResetMouseExited(evt);
            }
        });
        KbtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KbtnResetActionPerformed(evt);
            }
        });
        jPanel2.add(KbtnReset);
        KbtnReset.setBounds(420, 380, 260, 50);

        pnlMoneybtn.setBackground(new java.awt.Color(102, 102, 102));
        pnlMoneybtn.setkEndColor(new java.awt.Color(102, 102, 102));
        pnlMoneybtn.setkStartColor(new java.awt.Color(102, 102, 102));
        pnlMoneybtn.setLayout(new java.awt.GridLayout(2, 5));

        btnrm1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/smolrm1.png"))); // NOI18N
        btnrm1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnrm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrm1ActionPerformed(evt);
            }
        });
        pnlMoneybtn.add(btnrm1);

        btnrm5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/smolrm5.png"))); // NOI18N
        btnrm5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnrm5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrm5ActionPerformed(evt);
            }
        });
        pnlMoneybtn.add(btnrm5);

        btnrm10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/smolrm10.png"))); // NOI18N
        btnrm10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnrm10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrm10ActionPerformed(evt);
            }
        });
        pnlMoneybtn.add(btnrm10);

        btnrm20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/smolrm20.png"))); // NOI18N
        btnrm20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnrm20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrm20ActionPerformed(evt);
            }
        });
        pnlMoneybtn.add(btnrm20);

        btnrm50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/smolrm50.png"))); // NOI18N
        btnrm50.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnrm50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrm50ActionPerformed(evt);
            }
        });
        pnlMoneybtn.add(btnrm50);

        btnrm005.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/smol5cen.png.png"))); // NOI18N
        btnrm005.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnrm005.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrm005ActionPerformed(evt);
            }
        });
        pnlMoneybtn.add(btnrm005);

        btnrm01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/smol10cen.png.png"))); // NOI18N
        btnrm01.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnrm01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrm01ActionPerformed(evt);
            }
        });
        pnlMoneybtn.add(btnrm01);

        btnrm02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/smol20cen.png.png"))); // NOI18N
        btnrm02.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnrm02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrm02ActionPerformed(evt);
            }
        });
        pnlMoneybtn.add(btnrm02);

        btnrm05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/smol50cen.png"))); // NOI18N
        btnrm05.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnrm05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrm05ActionPerformed(evt);
            }
        });
        pnlMoneybtn.add(btnrm05);

        btnrm100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/smolrm100.png"))); // NOI18N
        btnrm100.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnrm100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrm100ActionPerformed(evt);
            }
        });
        pnlMoneybtn.add(btnrm100);

        jPanel2.add(pnlMoneybtn);
        pnlMoneybtn.setBounds(20, 170, 930, 190);

        kGradientPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 980, 450));

        jLabel4.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Insert Payment To Retrieve Purchased Items");
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

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
        kGradientPanel1.add(KbtnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1030, 550));

        setSize(new java.awt.Dimension(1024, 600));
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

    private void btnrm005ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrm005ActionPerformed
        Double insertedbtnvalue;
        moneyformat.format(insertedbtnvalue = 0.05);
        updatepayment(insertedbtnvalue);
    }//GEN-LAST:event_btnrm005ActionPerformed

    private void btnrm01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrm01ActionPerformed
        Double insertedbtnvalue;
        moneyformat.format(insertedbtnvalue = 0.10);
        updatepayment(insertedbtnvalue);
    }//GEN-LAST:event_btnrm01ActionPerformed

    private void btnrm02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrm02ActionPerformed
        Double insertedbtnvalue;
        moneyformat.format(insertedbtnvalue = 0.20);
        updatepayment(insertedbtnvalue);
    }//GEN-LAST:event_btnrm02ActionPerformed

    private void btnrm05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrm05ActionPerformed
        Double insertedbtnvalue;
        moneyformat.format(insertedbtnvalue = 0.50);
        updatepayment(insertedbtnvalue);
    }//GEN-LAST:event_btnrm05ActionPerformed

    private void btnrm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrm1ActionPerformed
        Double insertedbtnvalue;
        moneyformat.format(insertedbtnvalue = 1.00);
        updatepayment(insertedbtnvalue);
    }//GEN-LAST:event_btnrm1ActionPerformed

    private void btnrm5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrm5ActionPerformed
        Double insertedbtnvalue;
        moneyformat.format(insertedbtnvalue = 5.00);
        updatepayment(insertedbtnvalue);
    }//GEN-LAST:event_btnrm5ActionPerformed

    private void btnrm10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrm10ActionPerformed
        Double insertedbtnvalue;
        moneyformat.format(insertedbtnvalue = 10.00);
        updatepayment(insertedbtnvalue);
    }//GEN-LAST:event_btnrm10ActionPerformed

    private void btnrm20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrm20ActionPerformed
        Double insertedbtnvalue;
        moneyformat.format(insertedbtnvalue = 20.00);
        updatepayment(insertedbtnvalue);
    }//GEN-LAST:event_btnrm20ActionPerformed

    private void btnrm50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrm50ActionPerformed
        Double insertedbtnvalue;
        moneyformat.format(insertedbtnvalue = 50.00);
        updatepayment(insertedbtnvalue);
    }//GEN-LAST:event_btnrm50ActionPerformed

    private void KbtnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KbtnLoginMouseEntered
        KbtnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_KbtnLoginMouseEntered

    private void KbtnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KbtnLoginMouseExited
        KbtnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_KbtnLoginMouseExited

    private void KbtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KbtnLoginActionPerformed
        if (insertedpayment >= totalpricevalue) {
            insertData();
            storeTransaction();

            AfterPaymentMenu afterpmenu = new AfterPaymentMenu(selectedProductID, transIDAfterPayment);
            afterpmenu.setVisible(true);
            dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Insufficient Funds Inserted");
        }
    }//GEN-LAST:event_KbtnLoginActionPerformed

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
                new QuantityMenu(selectedProductID, insertedQuantity).setVisible(true);
                dispose();
            } catch (IOException ex) {
            }
        } else {

        }


    }//GEN-LAST:event_KbtnBackActionPerformed

    private void KbtnResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KbtnResetMouseEntered
        KbtnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_KbtnResetMouseEntered

    private void KbtnResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KbtnResetMouseExited
        KbtnReset.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_KbtnResetMouseExited

    private void KbtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KbtnResetActionPerformed
        resetpayment();
    }//GEN-LAST:event_KbtnResetActionPerformed

    private void btnrm100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrm100ActionPerformed
        Double insertedbtnvalue;
        moneyformat.format(insertedbtnvalue = 100.00);
        updatepayment(insertedbtnvalue);
    }//GEN-LAST:event_btnrm100ActionPerformed

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
            java.util.logging.Logger.getLogger(PaymentMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton KbtnBack;
    private keeptoo.KButton KbtnLogin;
    private keeptoo.KButton KbtnReset;
    private javax.swing.JPanel btnclose;
    private javax.swing.JPanel btnminmax;
    private javax.swing.JButton btnrm005;
    private javax.swing.JButton btnrm01;
    private javax.swing.JButton btnrm02;
    private javax.swing.JButton btnrm05;
    private javax.swing.JButton btnrm1;
    private javax.swing.JButton btnrm10;
    private javax.swing.JButton btnrm100;
    private javax.swing.JButton btnrm20;
    private javax.swing.JButton btnrm5;
    private javax.swing.JButton btnrm50;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblChange_total;
    private javax.swing.JLabel lblProduct_totalprice;
    private javax.swing.JLabel lblclose;
    private javax.swing.JLabel lblinsertedAmount;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JLabel lblminmax;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JPanel panellogo;
    private javax.swing.JPanel paneltitle;
    private keeptoo.KGradientPanel pnlMoneybtn;
    private keeptoo.KGradientPanel pnlTotalPrice;
    private keeptoo.KGradientPanel pnlTotalPrice1;
    private keeptoo.KGradientPanel pnlTotalPrice2;
    private javax.swing.JPanel windowsButtons1;
    private javax.swing.JPanel windowsButtons2;
    private javax.swing.JPanel windowsControl;
    private javax.swing.JPanel windowsLogo;
    // End of variables declaration//GEN-END:variables
}
