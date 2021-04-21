/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainFunctions;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ir4un
 */
public class ProductList extends javax.swing.JFrame {

    /**
     * Creates new form startMenu
     */
    private int mousepX;
    private int mousepY;
    private int selectedQuantity = 1;
    private String setusername;
    private String selectedProductID;

    public ProductList(String retrievedusername) throws IOException {

        initComponents();
        retrieveData();
        this.scrollpnl.getVerticalScrollBar().setUnitIncrement(16);
        this.setusername = retrievedusername;
        setLogo();

    }

    private void setLogo() {
        String sourcefolder = System.getProperty("user.dir") + "\\src\\productthumbnail\\";
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(sourcefolder + "logo.png"));
        this.setTitle("PAWG Vending Machine");

    }

    private void retrieveData() throws IOException {
        String source = System.getProperty("user.dir");
        File file = new File(source + "\\src\\txtdatabase\\itemlist.txt");

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String record;
        int count = 1;

        while ((record = br.readLine()) != null) {

            String[] fields = record.split("::");
            String product_id = fields[0];
            String product_name = fields[1];
            String product_price = fields[2];
            String product_quantity = fields[3];
            String product_thumbslot = fields[4];

            if ("*".equals(product_name)) { //Checks if Data are empty, then new values will be displayed.
                product_name = "-";
                product_price = "-";
                product_quantity = "N/A";
                product_thumbslot = "defaultempty.png";
            } else {

            }
            setLabel(count, product_id, product_name, product_price, product_quantity, product_thumbslot);

            ++count;
        }
        br.close();

    }

    private void setLabel(int count, String product_id, String product_name, String product_price, String product_quantity, String product_thumbslot) {

        try {

            String source = System.getProperty("user.dir");
            File file = new File(source + "\\src\\txtdatabase\\itemlist.txt");
            String thumbimg = source + "\\src\\productthumbnail\\" + product_thumbslot;
            BufferedImage bufImg = ImageIO.read(new File(thumbimg));
            Image imgScale = bufImg.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imgScale);

            switch (count) {
                case 1:

                    selectedProductID = "01";
                    lblproduct_id1.setText("Slot " + product_id);
                    lblproduct_name1.setText(product_name);
                    lblproduct_price1.setText("RM" + product_price);
                    lblproduct_quantity1.setText(product_quantity);
                    lblproduct_thumb1.setIcon(scaledIcon);
                    if ("-".equals(product_name)) {
                        btnUpdate1.setEnabled(false);
                        btnRemove1.setEnabled(false);
                    }
                    break;
                case 2:
                    selectedProductID = "02";
                    lblproduct_id2.setText("Slot " + product_id);
                    lblproduct_name2.setText(product_name);
                    lblproduct_price2.setText("RM" + product_price);
                    lblproduct_quantity2.setText(product_quantity);
                    lblproduct_thumb2.setIcon(scaledIcon);
                    if ("-".equals(product_name)) {
                        btnUpdate2.setEnabled(false);
                        btnRemove2.setEnabled(false);
                    }
                    break;
                case 3:
                    selectedProductID = "03";
                    lblproduct_id3.setText("Slot " + product_id);
                    lblproduct_name3.setText(product_name);
                    lblproduct_price3.setText("RM" + product_price);
                    lblproduct_quantity3.setText(product_quantity);
                    lblproduct_thumb3.setIcon(scaledIcon);
                    if ("-".equals(product_name)) {
                        btnUpdate3.setEnabled(false);
                        btnRemove3.setEnabled(false);
                    }
                    break;
                case 4:
                    selectedProductID = "04";
                    lblproduct_id4.setText("Slot " + product_id);
                    lblproduct_name4.setText(product_name);
                    lblproduct_price4.setText("RM" + product_price);
                    lblproduct_quantity4.setText(product_quantity);
                    lblproduct_thumb4.setIcon(scaledIcon);
                    if ("-".equals(product_name)) {
                        btnUpdate4.setEnabled(false);
                        btnRemove4.setEnabled(false);
                    }
                    break;
                case 5:
                    selectedProductID = "05";
                    lblproduct_id5.setText("Slot " + product_id);
                    lblproduct_name5.setText(product_name);
                    lblproduct_price5.setText("RM" + product_price);
                    lblproduct_quantity5.setText(product_quantity);
                    lblproduct_thumb5.setIcon(scaledIcon);
                    if ("-".equals(product_name)) {
                        btnUpdate5.setEnabled(false);
                        btnRemove5.setEnabled(false);
                    }
                    break;
                case 6:
                    selectedProductID = "06";
                    lblproduct_id6.setText("Slot " + product_id);
                    lblproduct_name6.setText(product_name);
                    lblproduct_price6.setText("RM" + product_price);
                    lblproduct_quantity6.setText(product_quantity);
                    lblproduct_thumb6.setIcon(scaledIcon);
                    if ("-".equals(product_name)) {
                        btnUpdate6.setEnabled(false);
                        btnRemove6.setEnabled(false);
                    }
                    break;
                case 7:
                    selectedProductID = "07";
                    lblproduct_id7.setText("Slot " + product_id);
                    lblproduct_name7.setText(product_name);
                    lblproduct_price7.setText("RM" + product_price);
                    lblproduct_quantity7.setText(product_quantity);
                    lblproduct_thumb7.setIcon(scaledIcon);
                    if ("-".equals(product_name)) {
                        btnUpdate7.setEnabled(false);
                        btnRemove7.setEnabled(false);
                    }
                    break;
                case 8:
                    selectedProductID = "08";
                    lblproduct_id8.setText("Slot " + product_id);
                    lblproduct_name8.setText(product_name);
                    lblproduct_price8.setText("RM" + product_price);
                    lblproduct_quantity8.setText(product_quantity);
                    lblproduct_thumb8.setIcon(scaledIcon);
                    if ("-".equals(product_name)) {
                        btnUpdate8.setEnabled(false);
                        btnRemove8.setEnabled(false);
                    }
                    break;
                case 9:
                    selectedProductID = "09";
                    lblproduct_id9.setText("Slot " + product_id);
                    lblproduct_name9.setText(product_name);
                    lblproduct_price9.setText("RM" + product_price);
                    lblproduct_quantity9.setText(product_quantity);
                    lblproduct_thumb9.setIcon(scaledIcon);
                    if ("-".equals(product_name)) {
                        btnUpdate9.setEnabled(false);
                        btnRemove9.setEnabled(false);
                    }
                    break;
                case 10:
                    selectedProductID = "10";
                    lblproduct_id10.setText("Slot " + product_id);
                    lblproduct_name10.setText(product_name);
                    lblproduct_price10.setText("RM" + product_price);
                    lblproduct_quantity10.setText(product_quantity);
                    lblproduct_thumb10.setIcon(scaledIcon);
                    if ("-".equals(product_name)) {
                        btnUpdate10.setEnabled(false);
                        btnRemove10.setEnabled(false);
                    }
                    break;

            }

        } catch (Exception e) {

        }

    }

    private void setProductID(String prodID) {

        this.selectedProductID = prodID;

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

            while ((readData = br.readLine()) != null) { //Data in itemlist.txt Will Be Inserted into data Array.
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

            oldFile.delete(); //Deletes The Original itemlist.txt File.
            File dump = new File(filepath);
            newFile.renameTo(dump); //Renames The temp.txt File to itemlist.txt.

        } catch (Exception e) {

            JFrame parent = new JFrame(); //Display Error Message.
            JOptionPane.showMessageDialog(parent, "Error Occured While Trying To Delete Data");
        }

    }

    private void removeData(String selecteditemid) {

        try {

            String source = System.getProperty("user.dir") + "\\src\\txtdatabase\\itemlist.txt"; //Retrieving Directory of itemlist.txt File.
            File file = new File(source);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String record;

            while ((record = br.readLine()) != null) { //Retrieving All Data itemlist.txt File.
                String[] fields = record.split("::");
                String product_id = fields[0];

                if (selecteditemid.equals(product_id)) { //Checks if Data are empty, then Data will be inserted.
                    br.close();
                    deleteData(source, product_id, 1, "::"); //Removes Line of Empty Data.
                    FileWriter fw = new FileWriter(file, true);
                    BufferedWriter bf = new BufferedWriter(fw);
                    String datalist = selecteditemid + "::*::*::*::*::*" + "\n";
                    bf.write(datalist); //Writes the Values From The Variables to the itemlist.txt File.
                    bf.close();
                    br.close();
                    sortData(source, source); //Rearrange the Lines in itemlist.txt Alphabetically.
                }
            }

        } catch (IOException e) {
        }

    }

    private void dataDeletion(String prodID) {

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this item from this slot?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {

            try {
                removeData(prodID);
                dispose();
                ProductList plmenu = new ProductList(setusername);
                plmenu.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error Occured While Trying To Redirect To Insert Item Menu!");
            }
        }

    }

    private void sortData(String filepath, String tofileName) {

        try { //What in the sauerkraut is going on here?.

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
        pnlContent = new keeptoo.KGradientPanel();
        KbtnBack = new keeptoo.KButton();
        scrollpnl = new javax.swing.JScrollPane();
        pnlMainContent = new javax.swing.JPanel();
        pnlContent1 = new javax.swing.JPanel();
        pnlQuantity1 = new keeptoo.KGradientPanel();
        lblproduct_quantity1 = new javax.swing.JLabel();
        lbltitle1 = new javax.swing.JLabel();
        pnlPrice1 = new keeptoo.KGradientPanel();
        lblproduct_price1 = new javax.swing.JLabel();
        pnlSlot1 = new keeptoo.KGradientPanel();
        lblproduct_id1 = new javax.swing.JLabel();
        pnlName1 = new keeptoo.KGradientPanel();
        lblproduct_name1 = new javax.swing.JLabel();
        pnlThumb1 = new keeptoo.KGradientPanel();
        lblproduct_thumb1 = new javax.swing.JLabel();
        pnlBuy1 = new javax.swing.JPanel();
        btnRemove1 = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        pnlContent2 = new javax.swing.JPanel();
        pnlQuantity2 = new keeptoo.KGradientPanel();
        lblproduct_quantity2 = new javax.swing.JLabel();
        lbltitle2 = new javax.swing.JLabel();
        pnlPrice2 = new keeptoo.KGradientPanel();
        lblproduct_price2 = new javax.swing.JLabel();
        pnlSlot2 = new keeptoo.KGradientPanel();
        lblproduct_id2 = new javax.swing.JLabel();
        pnlName2 = new keeptoo.KGradientPanel();
        lblproduct_name2 = new javax.swing.JLabel();
        pnlThumb2 = new keeptoo.KGradientPanel();
        lblproduct_thumb2 = new javax.swing.JLabel();
        pnlBuy2 = new javax.swing.JPanel();
        btnRemove2 = new javax.swing.JButton();
        btnUpdate2 = new javax.swing.JButton();
        pnlContent3 = new javax.swing.JPanel();
        pnlQuantity3 = new keeptoo.KGradientPanel();
        lblproduct_quantity3 = new javax.swing.JLabel();
        lbltitle3 = new javax.swing.JLabel();
        pnlPrice3 = new keeptoo.KGradientPanel();
        lblproduct_price3 = new javax.swing.JLabel();
        pnlSlot3 = new keeptoo.KGradientPanel();
        lblproduct_id3 = new javax.swing.JLabel();
        pnlName3 = new keeptoo.KGradientPanel();
        lblproduct_name3 = new javax.swing.JLabel();
        pnlThumb3 = new keeptoo.KGradientPanel();
        lblproduct_thumb3 = new javax.swing.JLabel();
        pnlBuy3 = new javax.swing.JPanel();
        btnRemove3 = new javax.swing.JButton();
        btnUpdate3 = new javax.swing.JButton();
        pnlContent4 = new javax.swing.JPanel();
        pnlQuantity4 = new keeptoo.KGradientPanel();
        lblproduct_quantity4 = new javax.swing.JLabel();
        lbltitle4 = new javax.swing.JLabel();
        pnlPrice4 = new keeptoo.KGradientPanel();
        lblproduct_price4 = new javax.swing.JLabel();
        pnlSlot4 = new keeptoo.KGradientPanel();
        lblproduct_id4 = new javax.swing.JLabel();
        pnlName4 = new keeptoo.KGradientPanel();
        lblproduct_name4 = new javax.swing.JLabel();
        pnlThumb4 = new keeptoo.KGradientPanel();
        lblproduct_thumb4 = new javax.swing.JLabel();
        pnlBuy4 = new javax.swing.JPanel();
        btnRemove4 = new javax.swing.JButton();
        btnUpdate4 = new javax.swing.JButton();
        pnlContent5 = new javax.swing.JPanel();
        pnlQuantity5 = new keeptoo.KGradientPanel();
        lblproduct_quantity5 = new javax.swing.JLabel();
        lbltitle5 = new javax.swing.JLabel();
        pnlPrice5 = new keeptoo.KGradientPanel();
        lblproduct_price5 = new javax.swing.JLabel();
        pnlSlot5 = new keeptoo.KGradientPanel();
        lblproduct_id5 = new javax.swing.JLabel();
        pnlName5 = new keeptoo.KGradientPanel();
        lblproduct_name5 = new javax.swing.JLabel();
        pnlThumb5 = new keeptoo.KGradientPanel();
        lblproduct_thumb5 = new javax.swing.JLabel();
        pnlBuy5 = new javax.swing.JPanel();
        btnRemove5 = new javax.swing.JButton();
        btnUpdate5 = new javax.swing.JButton();
        pnlContent6 = new javax.swing.JPanel();
        pnlQuantity6 = new keeptoo.KGradientPanel();
        lblproduct_quantity6 = new javax.swing.JLabel();
        lbltitle6 = new javax.swing.JLabel();
        pnlPrice6 = new keeptoo.KGradientPanel();
        lblproduct_price6 = new javax.swing.JLabel();
        pnlSlot6 = new keeptoo.KGradientPanel();
        lblproduct_id6 = new javax.swing.JLabel();
        pnlName6 = new keeptoo.KGradientPanel();
        lblproduct_name6 = new javax.swing.JLabel();
        pnlThumb6 = new keeptoo.KGradientPanel();
        lblproduct_thumb6 = new javax.swing.JLabel();
        pnlBuy6 = new javax.swing.JPanel();
        btnRemove6 = new javax.swing.JButton();
        btnUpdate6 = new javax.swing.JButton();
        pnlContent7 = new javax.swing.JPanel();
        pnlQuantity7 = new keeptoo.KGradientPanel();
        lblproduct_quantity7 = new javax.swing.JLabel();
        lbltitle7 = new javax.swing.JLabel();
        pnlPrice7 = new keeptoo.KGradientPanel();
        lblproduct_price7 = new javax.swing.JLabel();
        pnlSlot7 = new keeptoo.KGradientPanel();
        lblproduct_id7 = new javax.swing.JLabel();
        pnlName7 = new keeptoo.KGradientPanel();
        lblproduct_name7 = new javax.swing.JLabel();
        pnlThumb7 = new keeptoo.KGradientPanel();
        lblproduct_thumb7 = new javax.swing.JLabel();
        pnlBuy7 = new javax.swing.JPanel();
        btnRemove7 = new javax.swing.JButton();
        btnUpdate7 = new javax.swing.JButton();
        pnlContent8 = new javax.swing.JPanel();
        pnlQuantity8 = new keeptoo.KGradientPanel();
        lblproduct_quantity8 = new javax.swing.JLabel();
        lbltitle8 = new javax.swing.JLabel();
        pnlPrice8 = new keeptoo.KGradientPanel();
        lblproduct_price8 = new javax.swing.JLabel();
        pnlSlot8 = new keeptoo.KGradientPanel();
        lblproduct_id8 = new javax.swing.JLabel();
        pnlName8 = new keeptoo.KGradientPanel();
        lblproduct_name8 = new javax.swing.JLabel();
        pnlThumb8 = new keeptoo.KGradientPanel();
        lblproduct_thumb8 = new javax.swing.JLabel();
        pnlBuy8 = new javax.swing.JPanel();
        btnRemove8 = new javax.swing.JButton();
        btnUpdate8 = new javax.swing.JButton();
        pnlContent9 = new javax.swing.JPanel();
        pnlQuantity9 = new keeptoo.KGradientPanel();
        lblproduct_quantity9 = new javax.swing.JLabel();
        lbltitle9 = new javax.swing.JLabel();
        pnlPrice9 = new keeptoo.KGradientPanel();
        lblproduct_price9 = new javax.swing.JLabel();
        pnlSlot9 = new keeptoo.KGradientPanel();
        lblproduct_id9 = new javax.swing.JLabel();
        pnlName9 = new keeptoo.KGradientPanel();
        lblproduct_name9 = new javax.swing.JLabel();
        pnlThumb9 = new keeptoo.KGradientPanel();
        lblproduct_thumb9 = new javax.swing.JLabel();
        pnlBuy9 = new javax.swing.JPanel();
        btnRemove9 = new javax.swing.JButton();
        btnUpdate9 = new javax.swing.JButton();
        pnlContent10 = new javax.swing.JPanel();
        pnlQuantity10 = new keeptoo.KGradientPanel();
        lblproduct_quantity10 = new javax.swing.JLabel();
        lbltitle10 = new javax.swing.JLabel();
        pnlPrice10 = new keeptoo.KGradientPanel();
        lblproduct_price10 = new javax.swing.JLabel();
        pnlSlot10 = new keeptoo.KGradientPanel();
        lblproduct_id10 = new javax.swing.JLabel();
        pnlName10 = new keeptoo.KGradientPanel();
        lblproduct_name10 = new javax.swing.JLabel();
        pnlThumb10 = new keeptoo.KGradientPanel();
        lblproduct_thumb10 = new javax.swing.JLabel();
        pnlBuy10 = new javax.swing.JPanel();
        btnRemove10 = new javax.swing.JButton();
        btnUpdate10 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1092, 600));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1092, 600));
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
        lbltitle.setText("Item List");
        lbltitle.setMaximumSize(new java.awt.Dimension(500, 50));
        lbltitle.setMinimumSize(new java.awt.Dimension(50, 50));
        lbltitle.setPreferredSize(new java.awt.Dimension(500, 50));

        javax.swing.GroupLayout windowsButtons2Layout = new javax.swing.GroupLayout(windowsButtons2);
        windowsButtons2.setLayout(windowsButtons2Layout);
        windowsButtons2Layout.setHorizontalGroup(
            windowsButtons2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, windowsButtons2Layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addComponent(paneltitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
        );
        windowsButtons2Layout.setVerticalGroup(
            windowsButtons2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneltitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(windowsButtons2Layout.createSequentialGroup()
                .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        windowsControl.add(windowsButtons2, java.awt.BorderLayout.CENTER);

        getContentPane().add(windowsControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, -1));

        pnlContent.setkBorderRadius(0);
        pnlContent.setkEndColor(new java.awt.Color(28, 167, 236));
        pnlContent.setkStartColor(new java.awt.Color(31, 47, 152));
        pnlContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        scrollpnl.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(102, 102, 102)));
        scrollpnl.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlMainContent.setBackground(new java.awt.Color(102, 102, 102));
        pnlMainContent.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        pnlMainContent.setForeground(new java.awt.Color(102, 102, 102));
        pnlMainContent.setPreferredSize(new java.awt.Dimension(1000, 1953));
        pnlMainContent.setLayout(new java.awt.GridLayout(5, 0, 15, 25));

        pnlContent1.setLayout(null);

        pnlQuantity1.setkBorderRadius(0);
        pnlQuantity1.setkStartColor(new java.awt.Color(123, 213, 245));
        pnlQuantity1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblproduct_quantity1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblproduct_quantity1.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_quantity1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_quantity1.setText("000");
        pnlQuantity1.add(lblproduct_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 220, 100));

        lbltitle1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbltitle1.setForeground(new java.awt.Color(255, 255, 255));
        lbltitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitle1.setText("Amount Available:");
        pnlQuantity1.add(lbltitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 6, 175, 40));

        pnlContent1.add(pnlQuantity1);
        pnlQuantity1.setBounds(280, 120, 220, 160);

        pnlPrice1.setkBorderRadius(0);
        pnlPrice1.setkEndColor(new java.awt.Color(153, 0, 153));
        pnlPrice1.setkStartColor(new java.awt.Color(102, 0, 102));

        lblproduct_price1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblproduct_price1.setForeground(new java.awt.Color(204, 204, 204));
        lblproduct_price1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_price1.setText("RM000.00");

        javax.swing.GroupLayout pnlPrice1Layout = new javax.swing.GroupLayout(pnlPrice1);
        pnlPrice1.setLayout(pnlPrice1Layout);
        pnlPrice1Layout.setHorizontalGroup(
            pnlPrice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_price1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        pnlPrice1Layout.setVerticalGroup(
            pnlPrice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_price1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        pnlContent1.add(pnlPrice1);
        pnlPrice1.setBounds(0, 280, 280, 100);

        pnlSlot1.setkBorderRadius(0);
        pnlSlot1.setkEndColor(new java.awt.Color(31, 47, 152));
        pnlSlot1.setkGradientFocus(1000);
        pnlSlot1.setkStartColor(new java.awt.Color(31, 47, 152));

        lblproduct_id1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblproduct_id1.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_id1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_id1.setText("Slot 01");

        javax.swing.GroupLayout pnlSlot1Layout = new javax.swing.GroupLayout(pnlSlot1);
        pnlSlot1.setLayout(pnlSlot1Layout);
        pnlSlot1Layout.setHorizontalGroup(
            pnlSlot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSlot1Layout.createSequentialGroup()
                .addComponent(lblproduct_id1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSlot1Layout.setVerticalGroup(
            pnlSlot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSlot1Layout.createSequentialGroup()
                .addGap(0, 49, Short.MAX_VALUE)
                .addComponent(lblproduct_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlContent1.add(pnlSlot1);
        pnlSlot1.setBounds(280, -50, 220, 110);

        pnlName1.setkBorderRadius(0);
        pnlName1.setkEndColor(new java.awt.Color(28, 167, 236));
        pnlName1.setkStartColor(new java.awt.Color(28, 167, 236));
        pnlName1.setkTransparentControls(false);

        lblproduct_name1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblproduct_name1.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_name1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_name1.setText("Item Name");

        javax.swing.GroupLayout pnlName1Layout = new javax.swing.GroupLayout(pnlName1);
        pnlName1.setLayout(pnlName1Layout);
        pnlName1Layout.setHorizontalGroup(
            pnlName1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_name1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );
        pnlName1Layout.setVerticalGroup(
            pnlName1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_name1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnlContent1.add(pnlName1);
        pnlName1.setBounds(280, 60, 220, 60);

        pnlThumb1.setkBorderRadius(0);
        pnlThumb1.setkEndColor(new java.awt.Color(51, 51, 51));
        pnlThumb1.setkStartColor(new java.awt.Color(204, 204, 204));

        lblproduct_thumb1.setMaximumSize(new java.awt.Dimension(250, 250));
        lblproduct_thumb1.setPreferredSize(new java.awt.Dimension(250, 250));

        javax.swing.GroupLayout pnlThumb1Layout = new javax.swing.GroupLayout(pnlThumb1);
        pnlThumb1.setLayout(pnlThumb1Layout);
        pnlThumb1Layout.setHorizontalGroup(
            pnlThumb1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThumb1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(lblproduct_thumb1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        pnlThumb1Layout.setVerticalGroup(
            pnlThumb1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThumb1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblproduct_thumb1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlContent1.add(pnlThumb1);
        pnlThumb1.setBounds(0, 0, 280, 280);

        pnlBuy1.setBackground(new java.awt.Color(51, 51, 51));
        pnlBuy1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRemove1.setBackground(new java.awt.Color(26, 26, 26));
        btnRemove1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/trash.png"))); // NOI18N
        btnRemove1.setBorderPainted(false);
        btnRemove1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemove1ActionPerformed(evt);
            }
        });
        pnlBuy1.add(btnRemove1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, -10, 120, 110));

        btnUpdate1.setBackground(new java.awt.Color(26, 26, 26));
        btnUpdate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/update.png"))); // NOI18N
        btnUpdate1.setBorderPainted(false);
        btnUpdate1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate1.setMaximumSize(new java.awt.Dimension(120, 56));
        btnUpdate1.setPreferredSize(new java.awt.Dimension(110, 56));
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });
        pnlBuy1.add(btnUpdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 130, 110));

        pnlContent1.add(pnlBuy1);
        pnlBuy1.setBounds(280, 280, 220, 100);

        pnlMainContent.add(pnlContent1);

        pnlContent2.setLayout(null);

        pnlQuantity2.setkBorderRadius(0);
        pnlQuantity2.setkStartColor(new java.awt.Color(123, 213, 245));
        pnlQuantity2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblproduct_quantity2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblproduct_quantity2.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_quantity2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_quantity2.setText("000");
        pnlQuantity2.add(lblproduct_quantity2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 40, 220, 100));

        lbltitle2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbltitle2.setForeground(new java.awt.Color(255, 255, 255));
        lbltitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitle2.setText("Amount Available:");
        pnlQuantity2.add(lbltitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 6, 175, 40));

        pnlContent2.add(pnlQuantity2);
        pnlQuantity2.setBounds(280, 120, 220, 160);

        pnlPrice2.setkBorderRadius(0);
        pnlPrice2.setkEndColor(new java.awt.Color(153, 0, 153));
        pnlPrice2.setkStartColor(new java.awt.Color(102, 0, 102));

        lblproduct_price2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblproduct_price2.setForeground(new java.awt.Color(204, 204, 204));
        lblproduct_price2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_price2.setText("RM000.00");

        javax.swing.GroupLayout pnlPrice2Layout = new javax.swing.GroupLayout(pnlPrice2);
        pnlPrice2.setLayout(pnlPrice2Layout);
        pnlPrice2Layout.setHorizontalGroup(
            pnlPrice2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_price2, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        pnlPrice2Layout.setVerticalGroup(
            pnlPrice2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_price2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        pnlContent2.add(pnlPrice2);
        pnlPrice2.setBounds(0, 280, 280, 100);

        pnlSlot2.setkBorderRadius(0);
        pnlSlot2.setkEndColor(new java.awt.Color(31, 47, 152));
        pnlSlot2.setkGradientFocus(1000);
        pnlSlot2.setkStartColor(new java.awt.Color(31, 47, 152));

        lblproduct_id2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblproduct_id2.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_id2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_id2.setText("Slot 01");

        javax.swing.GroupLayout pnlSlot2Layout = new javax.swing.GroupLayout(pnlSlot2);
        pnlSlot2.setLayout(pnlSlot2Layout);
        pnlSlot2Layout.setHorizontalGroup(
            pnlSlot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSlot2Layout.createSequentialGroup()
                .addComponent(lblproduct_id2, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSlot2Layout.setVerticalGroup(
            pnlSlot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSlot2Layout.createSequentialGroup()
                .addGap(0, 49, Short.MAX_VALUE)
                .addComponent(lblproduct_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlContent2.add(pnlSlot2);
        pnlSlot2.setBounds(280, -50, 220, 110);

        pnlName2.setkBorderRadius(0);
        pnlName2.setkEndColor(new java.awt.Color(28, 167, 236));
        pnlName2.setkStartColor(new java.awt.Color(28, 167, 236));
        pnlName2.setkTransparentControls(false);

        lblproduct_name2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblproduct_name2.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_name2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_name2.setText("Item Name");

        javax.swing.GroupLayout pnlName2Layout = new javax.swing.GroupLayout(pnlName2);
        pnlName2.setLayout(pnlName2Layout);
        pnlName2Layout.setHorizontalGroup(
            pnlName2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_name2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );
        pnlName2Layout.setVerticalGroup(
            pnlName2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_name2, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnlContent2.add(pnlName2);
        pnlName2.setBounds(280, 60, 220, 60);

        pnlThumb2.setkBorderRadius(0);
        pnlThumb2.setkEndColor(new java.awt.Color(51, 51, 51));
        pnlThumb2.setkStartColor(new java.awt.Color(204, 204, 204));

        lblproduct_thumb2.setMaximumSize(new java.awt.Dimension(250, 250));
        lblproduct_thumb2.setPreferredSize(new java.awt.Dimension(250, 250));

        javax.swing.GroupLayout pnlThumb2Layout = new javax.swing.GroupLayout(pnlThumb2);
        pnlThumb2.setLayout(pnlThumb2Layout);
        pnlThumb2Layout.setHorizontalGroup(
            pnlThumb2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThumb2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(lblproduct_thumb2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        pnlThumb2Layout.setVerticalGroup(
            pnlThumb2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThumb2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblproduct_thumb2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlContent2.add(pnlThumb2);
        pnlThumb2.setBounds(0, 0, 280, 280);

        pnlBuy2.setBackground(new java.awt.Color(51, 51, 51));
        pnlBuy2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRemove2.setBackground(new java.awt.Color(26, 26, 26));
        btnRemove2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/trash.png"))); // NOI18N
        btnRemove2.setBorderPainted(false);
        btnRemove2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemove2ActionPerformed(evt);
            }
        });
        pnlBuy2.add(btnRemove2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, -10, 120, 110));

        btnUpdate2.setBackground(new java.awt.Color(26, 26, 26));
        btnUpdate2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/update.png"))); // NOI18N
        btnUpdate2.setBorderPainted(false);
        btnUpdate2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate2.setMaximumSize(new java.awt.Dimension(120, 56));
        btnUpdate2.setPreferredSize(new java.awt.Dimension(110, 56));
        btnUpdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate2ActionPerformed(evt);
            }
        });
        pnlBuy2.add(btnUpdate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 130, 110));

        pnlContent2.add(pnlBuy2);
        pnlBuy2.setBounds(280, 280, 220, 100);

        pnlMainContent.add(pnlContent2);

        pnlContent3.setLayout(null);

        pnlQuantity3.setkBorderRadius(0);
        pnlQuantity3.setkStartColor(new java.awt.Color(123, 213, 245));
        pnlQuantity3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblproduct_quantity3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblproduct_quantity3.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_quantity3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_quantity3.setText("000");
        pnlQuantity3.add(lblproduct_quantity3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 40, 220, 100));

        lbltitle3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbltitle3.setForeground(new java.awt.Color(255, 255, 255));
        lbltitle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitle3.setText("Amount Available:");
        pnlQuantity3.add(lbltitle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 6, 175, 40));

        pnlContent3.add(pnlQuantity3);
        pnlQuantity3.setBounds(280, 120, 220, 160);

        pnlPrice3.setkBorderRadius(0);
        pnlPrice3.setkEndColor(new java.awt.Color(153, 0, 153));
        pnlPrice3.setkStartColor(new java.awt.Color(102, 0, 102));

        lblproduct_price3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblproduct_price3.setForeground(new java.awt.Color(204, 204, 204));
        lblproduct_price3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_price3.setText("RM000.00");

        javax.swing.GroupLayout pnlPrice3Layout = new javax.swing.GroupLayout(pnlPrice3);
        pnlPrice3.setLayout(pnlPrice3Layout);
        pnlPrice3Layout.setHorizontalGroup(
            pnlPrice3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_price3, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        pnlPrice3Layout.setVerticalGroup(
            pnlPrice3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_price3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        pnlContent3.add(pnlPrice3);
        pnlPrice3.setBounds(0, 280, 280, 100);

        pnlSlot3.setkBorderRadius(0);
        pnlSlot3.setkEndColor(new java.awt.Color(31, 47, 152));
        pnlSlot3.setkGradientFocus(1000);
        pnlSlot3.setkStartColor(new java.awt.Color(31, 47, 152));

        lblproduct_id3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblproduct_id3.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_id3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_id3.setText("Slot 01");

        javax.swing.GroupLayout pnlSlot3Layout = new javax.swing.GroupLayout(pnlSlot3);
        pnlSlot3.setLayout(pnlSlot3Layout);
        pnlSlot3Layout.setHorizontalGroup(
            pnlSlot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSlot3Layout.createSequentialGroup()
                .addComponent(lblproduct_id3, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSlot3Layout.setVerticalGroup(
            pnlSlot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSlot3Layout.createSequentialGroup()
                .addGap(0, 49, Short.MAX_VALUE)
                .addComponent(lblproduct_id3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlContent3.add(pnlSlot3);
        pnlSlot3.setBounds(280, -50, 220, 110);

        pnlName3.setkBorderRadius(0);
        pnlName3.setkEndColor(new java.awt.Color(28, 167, 236));
        pnlName3.setkStartColor(new java.awt.Color(28, 167, 236));
        pnlName3.setkTransparentControls(false);

        lblproduct_name3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblproduct_name3.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_name3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_name3.setText("Item Name");

        javax.swing.GroupLayout pnlName3Layout = new javax.swing.GroupLayout(pnlName3);
        pnlName3.setLayout(pnlName3Layout);
        pnlName3Layout.setHorizontalGroup(
            pnlName3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlName3Layout.createSequentialGroup()
                .addComponent(lblproduct_name3, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlName3Layout.setVerticalGroup(
            pnlName3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_name3, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnlContent3.add(pnlName3);
        pnlName3.setBounds(280, 60, 220, 60);

        pnlThumb3.setkBorderRadius(0);
        pnlThumb3.setkEndColor(new java.awt.Color(51, 51, 51));
        pnlThumb3.setkStartColor(new java.awt.Color(204, 204, 204));

        lblproduct_thumb3.setMaximumSize(new java.awt.Dimension(250, 250));
        lblproduct_thumb3.setPreferredSize(new java.awt.Dimension(250, 250));

        javax.swing.GroupLayout pnlThumb3Layout = new javax.swing.GroupLayout(pnlThumb3);
        pnlThumb3.setLayout(pnlThumb3Layout);
        pnlThumb3Layout.setHorizontalGroup(
            pnlThumb3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThumb3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(lblproduct_thumb3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        pnlThumb3Layout.setVerticalGroup(
            pnlThumb3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThumb3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblproduct_thumb3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlContent3.add(pnlThumb3);
        pnlThumb3.setBounds(0, 0, 280, 280);

        pnlBuy3.setBackground(new java.awt.Color(51, 51, 51));
        pnlBuy3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRemove3.setBackground(new java.awt.Color(26, 26, 26));
        btnRemove3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/trash.png"))); // NOI18N
        btnRemove3.setBorderPainted(false);
        btnRemove3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemove3ActionPerformed(evt);
            }
        });
        pnlBuy3.add(btnRemove3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, -10, 120, 110));

        btnUpdate3.setBackground(new java.awt.Color(26, 26, 26));
        btnUpdate3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/update.png"))); // NOI18N
        btnUpdate3.setBorderPainted(false);
        btnUpdate3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate3.setMaximumSize(new java.awt.Dimension(120, 56));
        btnUpdate3.setPreferredSize(new java.awt.Dimension(110, 56));
        btnUpdate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate3ActionPerformed(evt);
            }
        });
        pnlBuy3.add(btnUpdate3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 130, 110));

        pnlContent3.add(pnlBuy3);
        pnlBuy3.setBounds(280, 280, 220, 100);

        pnlMainContent.add(pnlContent3);

        pnlContent4.setLayout(null);

        pnlQuantity4.setkBorderRadius(0);
        pnlQuantity4.setkStartColor(new java.awt.Color(123, 213, 245));
        pnlQuantity4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblproduct_quantity4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblproduct_quantity4.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_quantity4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_quantity4.setText("000");
        pnlQuantity4.add(lblproduct_quantity4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 40, 220, 100));

        lbltitle4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbltitle4.setForeground(new java.awt.Color(255, 255, 255));
        lbltitle4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitle4.setText("Amount Available:");
        pnlQuantity4.add(lbltitle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 6, 175, 40));

        pnlContent4.add(pnlQuantity4);
        pnlQuantity4.setBounds(280, 120, 220, 160);

        pnlPrice4.setkBorderRadius(0);
        pnlPrice4.setkEndColor(new java.awt.Color(153, 0, 153));
        pnlPrice4.setkStartColor(new java.awt.Color(102, 0, 102));

        lblproduct_price4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblproduct_price4.setForeground(new java.awt.Color(204, 204, 204));
        lblproduct_price4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_price4.setText("RM000.00");

        javax.swing.GroupLayout pnlPrice4Layout = new javax.swing.GroupLayout(pnlPrice4);
        pnlPrice4.setLayout(pnlPrice4Layout);
        pnlPrice4Layout.setHorizontalGroup(
            pnlPrice4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_price4, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        pnlPrice4Layout.setVerticalGroup(
            pnlPrice4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_price4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        pnlContent4.add(pnlPrice4);
        pnlPrice4.setBounds(0, 280, 280, 100);

        pnlSlot4.setkBorderRadius(0);
        pnlSlot4.setkEndColor(new java.awt.Color(31, 47, 152));
        pnlSlot4.setkGradientFocus(1000);
        pnlSlot4.setkStartColor(new java.awt.Color(31, 47, 152));

        lblproduct_id4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblproduct_id4.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_id4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_id4.setText("Slot 01");

        javax.swing.GroupLayout pnlSlot4Layout = new javax.swing.GroupLayout(pnlSlot4);
        pnlSlot4.setLayout(pnlSlot4Layout);
        pnlSlot4Layout.setHorizontalGroup(
            pnlSlot4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSlot4Layout.createSequentialGroup()
                .addComponent(lblproduct_id4, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSlot4Layout.setVerticalGroup(
            pnlSlot4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSlot4Layout.createSequentialGroup()
                .addGap(0, 49, Short.MAX_VALUE)
                .addComponent(lblproduct_id4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlContent4.add(pnlSlot4);
        pnlSlot4.setBounds(280, -50, 220, 110);

        pnlName4.setkBorderRadius(0);
        pnlName4.setkEndColor(new java.awt.Color(28, 167, 236));
        pnlName4.setkStartColor(new java.awt.Color(28, 167, 236));
        pnlName4.setkTransparentControls(false);

        lblproduct_name4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblproduct_name4.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_name4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_name4.setText("Item Name");

        javax.swing.GroupLayout pnlName4Layout = new javax.swing.GroupLayout(pnlName4);
        pnlName4.setLayout(pnlName4Layout);
        pnlName4Layout.setHorizontalGroup(
            pnlName4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlName4Layout.createSequentialGroup()
                .addComponent(lblproduct_name4, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlName4Layout.setVerticalGroup(
            pnlName4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_name4, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnlContent4.add(pnlName4);
        pnlName4.setBounds(280, 60, 220, 60);

        pnlThumb4.setkBorderRadius(0);
        pnlThumb4.setkEndColor(new java.awt.Color(51, 51, 51));
        pnlThumb4.setkStartColor(new java.awt.Color(204, 204, 204));

        lblproduct_thumb4.setMaximumSize(new java.awt.Dimension(250, 250));
        lblproduct_thumb4.setPreferredSize(new java.awt.Dimension(250, 250));

        javax.swing.GroupLayout pnlThumb4Layout = new javax.swing.GroupLayout(pnlThumb4);
        pnlThumb4.setLayout(pnlThumb4Layout);
        pnlThumb4Layout.setHorizontalGroup(
            pnlThumb4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThumb4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(lblproduct_thumb4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        pnlThumb4Layout.setVerticalGroup(
            pnlThumb4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThumb4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblproduct_thumb4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlContent4.add(pnlThumb4);
        pnlThumb4.setBounds(0, 0, 280, 280);

        pnlBuy4.setBackground(new java.awt.Color(51, 51, 51));
        pnlBuy4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRemove4.setBackground(new java.awt.Color(26, 26, 26));
        btnRemove4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/trash.png"))); // NOI18N
        btnRemove4.setBorderPainted(false);
        btnRemove4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemove4ActionPerformed(evt);
            }
        });
        pnlBuy4.add(btnRemove4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, -10, 120, 110));

        btnUpdate4.setBackground(new java.awt.Color(26, 26, 26));
        btnUpdate4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/update.png"))); // NOI18N
        btnUpdate4.setBorderPainted(false);
        btnUpdate4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate4.setMaximumSize(new java.awt.Dimension(120, 56));
        btnUpdate4.setPreferredSize(new java.awt.Dimension(110, 56));
        btnUpdate4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate4ActionPerformed(evt);
            }
        });
        pnlBuy4.add(btnUpdate4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 130, 110));

        pnlContent4.add(pnlBuy4);
        pnlBuy4.setBounds(280, 280, 220, 100);

        pnlMainContent.add(pnlContent4);

        pnlContent5.setLayout(null);

        pnlQuantity5.setkBorderRadius(0);
        pnlQuantity5.setkStartColor(new java.awt.Color(123, 213, 245));
        pnlQuantity5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblproduct_quantity5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblproduct_quantity5.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_quantity5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_quantity5.setText("000");
        pnlQuantity5.add(lblproduct_quantity5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 40, 220, 100));

        lbltitle5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbltitle5.setForeground(new java.awt.Color(255, 255, 255));
        lbltitle5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitle5.setText("Amount Available:");
        pnlQuantity5.add(lbltitle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 6, 175, 40));

        pnlContent5.add(pnlQuantity5);
        pnlQuantity5.setBounds(280, 120, 220, 160);

        pnlPrice5.setkBorderRadius(0);
        pnlPrice5.setkEndColor(new java.awt.Color(153, 0, 153));
        pnlPrice5.setkStartColor(new java.awt.Color(102, 0, 102));

        lblproduct_price5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblproduct_price5.setForeground(new java.awt.Color(204, 204, 204));
        lblproduct_price5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_price5.setText("RM000.00");

        javax.swing.GroupLayout pnlPrice5Layout = new javax.swing.GroupLayout(pnlPrice5);
        pnlPrice5.setLayout(pnlPrice5Layout);
        pnlPrice5Layout.setHorizontalGroup(
            pnlPrice5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_price5, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        pnlPrice5Layout.setVerticalGroup(
            pnlPrice5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_price5, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        pnlContent5.add(pnlPrice5);
        pnlPrice5.setBounds(0, 280, 280, 100);

        pnlSlot5.setkBorderRadius(0);
        pnlSlot5.setkEndColor(new java.awt.Color(31, 47, 152));
        pnlSlot5.setkGradientFocus(1000);
        pnlSlot5.setkStartColor(new java.awt.Color(31, 47, 152));

        lblproduct_id5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblproduct_id5.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_id5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_id5.setText("Slot 01");

        javax.swing.GroupLayout pnlSlot5Layout = new javax.swing.GroupLayout(pnlSlot5);
        pnlSlot5.setLayout(pnlSlot5Layout);
        pnlSlot5Layout.setHorizontalGroup(
            pnlSlot5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSlot5Layout.createSequentialGroup()
                .addComponent(lblproduct_id5, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSlot5Layout.setVerticalGroup(
            pnlSlot5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSlot5Layout.createSequentialGroup()
                .addGap(0, 49, Short.MAX_VALUE)
                .addComponent(lblproduct_id5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlContent5.add(pnlSlot5);
        pnlSlot5.setBounds(280, -50, 220, 110);

        pnlName5.setkBorderRadius(0);
        pnlName5.setkEndColor(new java.awt.Color(28, 167, 236));
        pnlName5.setkStartColor(new java.awt.Color(28, 167, 236));
        pnlName5.setkTransparentControls(false);

        lblproduct_name5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblproduct_name5.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_name5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_name5.setText("Item Name");

        javax.swing.GroupLayout pnlName5Layout = new javax.swing.GroupLayout(pnlName5);
        pnlName5.setLayout(pnlName5Layout);
        pnlName5Layout.setHorizontalGroup(
            pnlName5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlName5Layout.createSequentialGroup()
                .addComponent(lblproduct_name5, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlName5Layout.setVerticalGroup(
            pnlName5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_name5, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnlContent5.add(pnlName5);
        pnlName5.setBounds(280, 60, 220, 60);

        pnlThumb5.setkBorderRadius(0);
        pnlThumb5.setkEndColor(new java.awt.Color(51, 51, 51));
        pnlThumb5.setkStartColor(new java.awt.Color(204, 204, 204));

        lblproduct_thumb5.setMaximumSize(new java.awt.Dimension(250, 250));
        lblproduct_thumb5.setPreferredSize(new java.awt.Dimension(250, 250));

        javax.swing.GroupLayout pnlThumb5Layout = new javax.swing.GroupLayout(pnlThumb5);
        pnlThumb5.setLayout(pnlThumb5Layout);
        pnlThumb5Layout.setHorizontalGroup(
            pnlThumb5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThumb5Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(lblproduct_thumb5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        pnlThumb5Layout.setVerticalGroup(
            pnlThumb5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThumb5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblproduct_thumb5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlContent5.add(pnlThumb5);
        pnlThumb5.setBounds(0, 0, 280, 280);

        pnlBuy5.setBackground(new java.awt.Color(51, 51, 51));
        pnlBuy5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRemove5.setBackground(new java.awt.Color(26, 26, 26));
        btnRemove5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/trash.png"))); // NOI18N
        btnRemove5.setBorderPainted(false);
        btnRemove5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemove5ActionPerformed(evt);
            }
        });
        pnlBuy5.add(btnRemove5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, -10, 120, 110));

        btnUpdate5.setBackground(new java.awt.Color(26, 26, 26));
        btnUpdate5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/update.png"))); // NOI18N
        btnUpdate5.setBorderPainted(false);
        btnUpdate5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate5.setMaximumSize(new java.awt.Dimension(120, 56));
        btnUpdate5.setPreferredSize(new java.awt.Dimension(110, 56));
        btnUpdate5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate5ActionPerformed(evt);
            }
        });
        pnlBuy5.add(btnUpdate5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 130, 110));

        pnlContent5.add(pnlBuy5);
        pnlBuy5.setBounds(280, 280, 220, 100);

        pnlMainContent.add(pnlContent5);

        pnlContent6.setLayout(null);

        pnlQuantity6.setkBorderRadius(0);
        pnlQuantity6.setkStartColor(new java.awt.Color(123, 213, 245));
        pnlQuantity6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblproduct_quantity6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblproduct_quantity6.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_quantity6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_quantity6.setText("000");
        pnlQuantity6.add(lblproduct_quantity6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 40, 220, 100));

        lbltitle6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbltitle6.setForeground(new java.awt.Color(255, 255, 255));
        lbltitle6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitle6.setText("Amount Available:");
        pnlQuantity6.add(lbltitle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 6, 175, 40));

        pnlContent6.add(pnlQuantity6);
        pnlQuantity6.setBounds(280, 120, 220, 160);

        pnlPrice6.setkBorderRadius(0);
        pnlPrice6.setkEndColor(new java.awt.Color(153, 0, 153));
        pnlPrice6.setkStartColor(new java.awt.Color(102, 0, 102));

        lblproduct_price6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblproduct_price6.setForeground(new java.awt.Color(204, 204, 204));
        lblproduct_price6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_price6.setText("RM000.00");

        javax.swing.GroupLayout pnlPrice6Layout = new javax.swing.GroupLayout(pnlPrice6);
        pnlPrice6.setLayout(pnlPrice6Layout);
        pnlPrice6Layout.setHorizontalGroup(
            pnlPrice6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_price6, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        pnlPrice6Layout.setVerticalGroup(
            pnlPrice6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_price6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        pnlContent6.add(pnlPrice6);
        pnlPrice6.setBounds(0, 280, 280, 100);

        pnlSlot6.setkBorderRadius(0);
        pnlSlot6.setkEndColor(new java.awt.Color(31, 47, 152));
        pnlSlot6.setkGradientFocus(1000);
        pnlSlot6.setkStartColor(new java.awt.Color(31, 47, 152));

        lblproduct_id6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblproduct_id6.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_id6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_id6.setText("Slot 01");

        javax.swing.GroupLayout pnlSlot6Layout = new javax.swing.GroupLayout(pnlSlot6);
        pnlSlot6.setLayout(pnlSlot6Layout);
        pnlSlot6Layout.setHorizontalGroup(
            pnlSlot6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSlot6Layout.createSequentialGroup()
                .addComponent(lblproduct_id6, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSlot6Layout.setVerticalGroup(
            pnlSlot6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSlot6Layout.createSequentialGroup()
                .addGap(0, 49, Short.MAX_VALUE)
                .addComponent(lblproduct_id6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlContent6.add(pnlSlot6);
        pnlSlot6.setBounds(280, -50, 220, 110);

        pnlName6.setkBorderRadius(0);
        pnlName6.setkEndColor(new java.awt.Color(28, 167, 236));
        pnlName6.setkStartColor(new java.awt.Color(28, 167, 236));
        pnlName6.setkTransparentControls(false);

        lblproduct_name6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblproduct_name6.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_name6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_name6.setText("Item Name");

        javax.swing.GroupLayout pnlName6Layout = new javax.swing.GroupLayout(pnlName6);
        pnlName6.setLayout(pnlName6Layout);
        pnlName6Layout.setHorizontalGroup(
            pnlName6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlName6Layout.createSequentialGroup()
                .addComponent(lblproduct_name6, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlName6Layout.setVerticalGroup(
            pnlName6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_name6, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnlContent6.add(pnlName6);
        pnlName6.setBounds(280, 60, 220, 60);

        pnlThumb6.setkBorderRadius(0);
        pnlThumb6.setkEndColor(new java.awt.Color(51, 51, 51));
        pnlThumb6.setkStartColor(new java.awt.Color(204, 204, 204));

        lblproduct_thumb6.setMaximumSize(new java.awt.Dimension(250, 250));
        lblproduct_thumb6.setPreferredSize(new java.awt.Dimension(250, 250));

        javax.swing.GroupLayout pnlThumb6Layout = new javax.swing.GroupLayout(pnlThumb6);
        pnlThumb6.setLayout(pnlThumb6Layout);
        pnlThumb6Layout.setHorizontalGroup(
            pnlThumb6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThumb6Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(lblproduct_thumb6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        pnlThumb6Layout.setVerticalGroup(
            pnlThumb6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThumb6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblproduct_thumb6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlContent6.add(pnlThumb6);
        pnlThumb6.setBounds(0, 0, 280, 280);

        pnlBuy6.setBackground(new java.awt.Color(51, 51, 51));
        pnlBuy6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRemove6.setBackground(new java.awt.Color(26, 26, 26));
        btnRemove6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/trash.png"))); // NOI18N
        btnRemove6.setBorderPainted(false);
        btnRemove6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemove6ActionPerformed(evt);
            }
        });
        pnlBuy6.add(btnRemove6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, -10, 120, 110));

        btnUpdate6.setBackground(new java.awt.Color(26, 26, 26));
        btnUpdate6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/update.png"))); // NOI18N
        btnUpdate6.setBorderPainted(false);
        btnUpdate6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate6.setMaximumSize(new java.awt.Dimension(120, 56));
        btnUpdate6.setPreferredSize(new java.awt.Dimension(110, 56));
        btnUpdate6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate6ActionPerformed(evt);
            }
        });
        pnlBuy6.add(btnUpdate6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 130, 110));

        pnlContent6.add(pnlBuy6);
        pnlBuy6.setBounds(280, 280, 220, 100);

        pnlMainContent.add(pnlContent6);

        pnlContent7.setLayout(null);

        pnlQuantity7.setkBorderRadius(0);
        pnlQuantity7.setkStartColor(new java.awt.Color(123, 213, 245));
        pnlQuantity7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblproduct_quantity7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblproduct_quantity7.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_quantity7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_quantity7.setText("000");
        pnlQuantity7.add(lblproduct_quantity7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 40, 220, 100));

        lbltitle7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbltitle7.setForeground(new java.awt.Color(255, 255, 255));
        lbltitle7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitle7.setText("Amount Available:");
        pnlQuantity7.add(lbltitle7, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 6, 175, 40));

        pnlContent7.add(pnlQuantity7);
        pnlQuantity7.setBounds(280, 120, 220, 160);

        pnlPrice7.setkBorderRadius(0);
        pnlPrice7.setkEndColor(new java.awt.Color(153, 0, 153));
        pnlPrice7.setkStartColor(new java.awt.Color(102, 0, 102));

        lblproduct_price7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblproduct_price7.setForeground(new java.awt.Color(204, 204, 204));
        lblproduct_price7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_price7.setText("RM000.00");

        javax.swing.GroupLayout pnlPrice7Layout = new javax.swing.GroupLayout(pnlPrice7);
        pnlPrice7.setLayout(pnlPrice7Layout);
        pnlPrice7Layout.setHorizontalGroup(
            pnlPrice7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_price7, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        pnlPrice7Layout.setVerticalGroup(
            pnlPrice7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_price7, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        pnlContent7.add(pnlPrice7);
        pnlPrice7.setBounds(0, 280, 280, 100);

        pnlSlot7.setkBorderRadius(0);
        pnlSlot7.setkEndColor(new java.awt.Color(31, 47, 152));
        pnlSlot7.setkGradientFocus(1000);
        pnlSlot7.setkStartColor(new java.awt.Color(31, 47, 152));

        lblproduct_id7.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblproduct_id7.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_id7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_id7.setText("Slot 01");

        javax.swing.GroupLayout pnlSlot7Layout = new javax.swing.GroupLayout(pnlSlot7);
        pnlSlot7.setLayout(pnlSlot7Layout);
        pnlSlot7Layout.setHorizontalGroup(
            pnlSlot7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSlot7Layout.createSequentialGroup()
                .addComponent(lblproduct_id7, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSlot7Layout.setVerticalGroup(
            pnlSlot7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSlot7Layout.createSequentialGroup()
                .addGap(0, 49, Short.MAX_VALUE)
                .addComponent(lblproduct_id7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlContent7.add(pnlSlot7);
        pnlSlot7.setBounds(280, -50, 220, 110);

        pnlName7.setkBorderRadius(0);
        pnlName7.setkEndColor(new java.awt.Color(28, 167, 236));
        pnlName7.setkStartColor(new java.awt.Color(28, 167, 236));
        pnlName7.setkTransparentControls(false);

        lblproduct_name7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblproduct_name7.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_name7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_name7.setText("Item Name");

        javax.swing.GroupLayout pnlName7Layout = new javax.swing.GroupLayout(pnlName7);
        pnlName7.setLayout(pnlName7Layout);
        pnlName7Layout.setHorizontalGroup(
            pnlName7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlName7Layout.createSequentialGroup()
                .addComponent(lblproduct_name7, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlName7Layout.setVerticalGroup(
            pnlName7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_name7, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnlContent7.add(pnlName7);
        pnlName7.setBounds(280, 60, 220, 60);

        pnlThumb7.setkBorderRadius(0);
        pnlThumb7.setkEndColor(new java.awt.Color(51, 51, 51));
        pnlThumb7.setkStartColor(new java.awt.Color(204, 204, 204));

        lblproduct_thumb7.setMaximumSize(new java.awt.Dimension(250, 250));
        lblproduct_thumb7.setPreferredSize(new java.awt.Dimension(250, 250));

        javax.swing.GroupLayout pnlThumb7Layout = new javax.swing.GroupLayout(pnlThumb7);
        pnlThumb7.setLayout(pnlThumb7Layout);
        pnlThumb7Layout.setHorizontalGroup(
            pnlThumb7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThumb7Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(lblproduct_thumb7, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        pnlThumb7Layout.setVerticalGroup(
            pnlThumb7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThumb7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblproduct_thumb7, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlContent7.add(pnlThumb7);
        pnlThumb7.setBounds(0, 0, 280, 280);

        pnlBuy7.setBackground(new java.awt.Color(51, 51, 51));
        pnlBuy7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRemove7.setBackground(new java.awt.Color(26, 26, 26));
        btnRemove7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/trash.png"))); // NOI18N
        btnRemove7.setBorderPainted(false);
        btnRemove7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemove7ActionPerformed(evt);
            }
        });
        pnlBuy7.add(btnRemove7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, -10, 120, 110));

        btnUpdate7.setBackground(new java.awt.Color(26, 26, 26));
        btnUpdate7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/update.png"))); // NOI18N
        btnUpdate7.setBorderPainted(false);
        btnUpdate7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate7.setMaximumSize(new java.awt.Dimension(120, 56));
        btnUpdate7.setPreferredSize(new java.awt.Dimension(110, 56));
        btnUpdate7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate7ActionPerformed(evt);
            }
        });
        pnlBuy7.add(btnUpdate7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 130, 110));

        pnlContent7.add(pnlBuy7);
        pnlBuy7.setBounds(280, 280, 220, 100);

        pnlMainContent.add(pnlContent7);

        pnlContent8.setLayout(null);

        pnlQuantity8.setkBorderRadius(0);
        pnlQuantity8.setkStartColor(new java.awt.Color(123, 213, 245));
        pnlQuantity8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblproduct_quantity8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblproduct_quantity8.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_quantity8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_quantity8.setText("000");
        pnlQuantity8.add(lblproduct_quantity8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 40, 220, 100));

        lbltitle8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbltitle8.setForeground(new java.awt.Color(255, 255, 255));
        lbltitle8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitle8.setText("Amount Available:");
        pnlQuantity8.add(lbltitle8, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 6, 175, 40));

        pnlContent8.add(pnlQuantity8);
        pnlQuantity8.setBounds(280, 120, 220, 160);

        pnlPrice8.setkBorderRadius(0);
        pnlPrice8.setkEndColor(new java.awt.Color(153, 0, 153));
        pnlPrice8.setkStartColor(new java.awt.Color(102, 0, 102));

        lblproduct_price8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblproduct_price8.setForeground(new java.awt.Color(204, 204, 204));
        lblproduct_price8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_price8.setText("RM000.00");

        javax.swing.GroupLayout pnlPrice8Layout = new javax.swing.GroupLayout(pnlPrice8);
        pnlPrice8.setLayout(pnlPrice8Layout);
        pnlPrice8Layout.setHorizontalGroup(
            pnlPrice8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_price8, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        pnlPrice8Layout.setVerticalGroup(
            pnlPrice8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_price8, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        pnlContent8.add(pnlPrice8);
        pnlPrice8.setBounds(0, 280, 280, 100);

        pnlSlot8.setkBorderRadius(0);
        pnlSlot8.setkEndColor(new java.awt.Color(31, 47, 152));
        pnlSlot8.setkGradientFocus(1000);
        pnlSlot8.setkStartColor(new java.awt.Color(31, 47, 152));

        lblproduct_id8.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblproduct_id8.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_id8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_id8.setText("Slot 01");

        javax.swing.GroupLayout pnlSlot8Layout = new javax.swing.GroupLayout(pnlSlot8);
        pnlSlot8.setLayout(pnlSlot8Layout);
        pnlSlot8Layout.setHorizontalGroup(
            pnlSlot8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSlot8Layout.createSequentialGroup()
                .addComponent(lblproduct_id8, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSlot8Layout.setVerticalGroup(
            pnlSlot8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSlot8Layout.createSequentialGroup()
                .addGap(0, 49, Short.MAX_VALUE)
                .addComponent(lblproduct_id8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlContent8.add(pnlSlot8);
        pnlSlot8.setBounds(280, -50, 220, 110);

        pnlName8.setkBorderRadius(0);
        pnlName8.setkEndColor(new java.awt.Color(28, 167, 236));
        pnlName8.setkStartColor(new java.awt.Color(28, 167, 236));
        pnlName8.setkTransparentControls(false);

        lblproduct_name8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblproduct_name8.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_name8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_name8.setText("Item Name");

        javax.swing.GroupLayout pnlName8Layout = new javax.swing.GroupLayout(pnlName8);
        pnlName8.setLayout(pnlName8Layout);
        pnlName8Layout.setHorizontalGroup(
            pnlName8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlName8Layout.createSequentialGroup()
                .addComponent(lblproduct_name8, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlName8Layout.setVerticalGroup(
            pnlName8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_name8, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnlContent8.add(pnlName8);
        pnlName8.setBounds(280, 60, 220, 60);

        pnlThumb8.setkBorderRadius(0);
        pnlThumb8.setkEndColor(new java.awt.Color(51, 51, 51));
        pnlThumb8.setkStartColor(new java.awt.Color(204, 204, 204));

        lblproduct_thumb8.setMaximumSize(new java.awt.Dimension(250, 250));
        lblproduct_thumb8.setPreferredSize(new java.awt.Dimension(250, 250));

        javax.swing.GroupLayout pnlThumb8Layout = new javax.swing.GroupLayout(pnlThumb8);
        pnlThumb8.setLayout(pnlThumb8Layout);
        pnlThumb8Layout.setHorizontalGroup(
            pnlThumb8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThumb8Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(lblproduct_thumb8, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        pnlThumb8Layout.setVerticalGroup(
            pnlThumb8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThumb8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblproduct_thumb8, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlContent8.add(pnlThumb8);
        pnlThumb8.setBounds(0, 0, 280, 280);

        pnlBuy8.setBackground(new java.awt.Color(51, 51, 51));
        pnlBuy8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRemove8.setBackground(new java.awt.Color(26, 26, 26));
        btnRemove8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/trash.png"))); // NOI18N
        btnRemove8.setBorderPainted(false);
        btnRemove8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemove8ActionPerformed(evt);
            }
        });
        pnlBuy8.add(btnRemove8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, -10, 120, 110));

        btnUpdate8.setBackground(new java.awt.Color(26, 26, 26));
        btnUpdate8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/update.png"))); // NOI18N
        btnUpdate8.setBorderPainted(false);
        btnUpdate8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate8.setMaximumSize(new java.awt.Dimension(120, 56));
        btnUpdate8.setPreferredSize(new java.awt.Dimension(110, 56));
        btnUpdate8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate8ActionPerformed(evt);
            }
        });
        pnlBuy8.add(btnUpdate8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 130, 110));

        pnlContent8.add(pnlBuy8);
        pnlBuy8.setBounds(280, 280, 220, 100);

        pnlMainContent.add(pnlContent8);

        pnlContent9.setLayout(null);

        pnlQuantity9.setkBorderRadius(0);
        pnlQuantity9.setkStartColor(new java.awt.Color(123, 213, 245));
        pnlQuantity9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblproduct_quantity9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblproduct_quantity9.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_quantity9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_quantity9.setText("000");
        pnlQuantity9.add(lblproduct_quantity9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 40, 220, 100));

        lbltitle9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbltitle9.setForeground(new java.awt.Color(255, 255, 255));
        lbltitle9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitle9.setText("Amount Available:");
        pnlQuantity9.add(lbltitle9, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 6, 175, 40));

        pnlContent9.add(pnlQuantity9);
        pnlQuantity9.setBounds(280, 120, 220, 160);

        pnlPrice9.setkBorderRadius(0);
        pnlPrice9.setkEndColor(new java.awt.Color(153, 0, 153));
        pnlPrice9.setkStartColor(new java.awt.Color(102, 0, 102));

        lblproduct_price9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblproduct_price9.setForeground(new java.awt.Color(204, 204, 204));
        lblproduct_price9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_price9.setText("RM000.00");

        javax.swing.GroupLayout pnlPrice9Layout = new javax.swing.GroupLayout(pnlPrice9);
        pnlPrice9.setLayout(pnlPrice9Layout);
        pnlPrice9Layout.setHorizontalGroup(
            pnlPrice9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_price9, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        pnlPrice9Layout.setVerticalGroup(
            pnlPrice9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_price9, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        pnlContent9.add(pnlPrice9);
        pnlPrice9.setBounds(0, 280, 280, 100);

        pnlSlot9.setkBorderRadius(0);
        pnlSlot9.setkEndColor(new java.awt.Color(31, 47, 152));
        pnlSlot9.setkGradientFocus(1000);
        pnlSlot9.setkStartColor(new java.awt.Color(31, 47, 152));

        lblproduct_id9.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblproduct_id9.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_id9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_id9.setText("Slot 01");

        javax.swing.GroupLayout pnlSlot9Layout = new javax.swing.GroupLayout(pnlSlot9);
        pnlSlot9.setLayout(pnlSlot9Layout);
        pnlSlot9Layout.setHorizontalGroup(
            pnlSlot9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSlot9Layout.createSequentialGroup()
                .addComponent(lblproduct_id9, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSlot9Layout.setVerticalGroup(
            pnlSlot9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSlot9Layout.createSequentialGroup()
                .addGap(0, 49, Short.MAX_VALUE)
                .addComponent(lblproduct_id9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlContent9.add(pnlSlot9);
        pnlSlot9.setBounds(280, -50, 220, 110);

        pnlName9.setkBorderRadius(0);
        pnlName9.setkEndColor(new java.awt.Color(28, 167, 236));
        pnlName9.setkStartColor(new java.awt.Color(28, 167, 236));
        pnlName9.setkTransparentControls(false);

        lblproduct_name9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblproduct_name9.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_name9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_name9.setText("Item Name");

        javax.swing.GroupLayout pnlName9Layout = new javax.swing.GroupLayout(pnlName9);
        pnlName9.setLayout(pnlName9Layout);
        pnlName9Layout.setHorizontalGroup(
            pnlName9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlName9Layout.createSequentialGroup()
                .addComponent(lblproduct_name9, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlName9Layout.setVerticalGroup(
            pnlName9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_name9, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnlContent9.add(pnlName9);
        pnlName9.setBounds(280, 60, 220, 60);

        pnlThumb9.setkBorderRadius(0);
        pnlThumb9.setkEndColor(new java.awt.Color(51, 51, 51));
        pnlThumb9.setkStartColor(new java.awt.Color(204, 204, 204));

        lblproduct_thumb9.setMaximumSize(new java.awt.Dimension(250, 250));
        lblproduct_thumb9.setPreferredSize(new java.awt.Dimension(250, 250));

        javax.swing.GroupLayout pnlThumb9Layout = new javax.swing.GroupLayout(pnlThumb9);
        pnlThumb9.setLayout(pnlThumb9Layout);
        pnlThumb9Layout.setHorizontalGroup(
            pnlThumb9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThumb9Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(lblproduct_thumb9, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        pnlThumb9Layout.setVerticalGroup(
            pnlThumb9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThumb9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblproduct_thumb9, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlContent9.add(pnlThumb9);
        pnlThumb9.setBounds(0, 0, 280, 280);

        pnlBuy9.setBackground(new java.awt.Color(51, 51, 51));
        pnlBuy9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRemove9.setBackground(new java.awt.Color(26, 26, 26));
        btnRemove9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/trash.png"))); // NOI18N
        btnRemove9.setBorderPainted(false);
        btnRemove9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemove9ActionPerformed(evt);
            }
        });
        pnlBuy9.add(btnRemove9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, -10, 120, 110));

        btnUpdate9.setBackground(new java.awt.Color(26, 26, 26));
        btnUpdate9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/update.png"))); // NOI18N
        btnUpdate9.setBorderPainted(false);
        btnUpdate9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate9.setMaximumSize(new java.awt.Dimension(120, 56));
        btnUpdate9.setPreferredSize(new java.awt.Dimension(110, 56));
        btnUpdate9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate9ActionPerformed(evt);
            }
        });
        pnlBuy9.add(btnUpdate9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 130, 110));

        pnlContent9.add(pnlBuy9);
        pnlBuy9.setBounds(280, 280, 220, 100);

        pnlMainContent.add(pnlContent9);

        pnlContent10.setLayout(null);

        pnlQuantity10.setkBorderRadius(0);
        pnlQuantity10.setkStartColor(new java.awt.Color(123, 213, 245));
        pnlQuantity10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblproduct_quantity10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblproduct_quantity10.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_quantity10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_quantity10.setText("000");
        pnlQuantity10.add(lblproduct_quantity10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 40, 220, 100));

        lbltitle10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbltitle10.setForeground(new java.awt.Color(255, 255, 255));
        lbltitle10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitle10.setText("Amount Available:");
        pnlQuantity10.add(lbltitle10, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 6, 175, 40));

        pnlContent10.add(pnlQuantity10);
        pnlQuantity10.setBounds(280, 120, 220, 160);

        pnlPrice10.setkBorderRadius(0);
        pnlPrice10.setkEndColor(new java.awt.Color(153, 0, 153));
        pnlPrice10.setkStartColor(new java.awt.Color(102, 0, 102));

        lblproduct_price10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblproduct_price10.setForeground(new java.awt.Color(204, 204, 204));
        lblproduct_price10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_price10.setText("RM000.00");

        javax.swing.GroupLayout pnlPrice10Layout = new javax.swing.GroupLayout(pnlPrice10);
        pnlPrice10.setLayout(pnlPrice10Layout);
        pnlPrice10Layout.setHorizontalGroup(
            pnlPrice10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_price10, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        pnlPrice10Layout.setVerticalGroup(
            pnlPrice10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_price10, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        pnlContent10.add(pnlPrice10);
        pnlPrice10.setBounds(0, 280, 280, 100);

        pnlSlot10.setkBorderRadius(0);
        pnlSlot10.setkEndColor(new java.awt.Color(31, 47, 152));
        pnlSlot10.setkGradientFocus(1000);
        pnlSlot10.setkStartColor(new java.awt.Color(31, 47, 152));

        lblproduct_id10.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblproduct_id10.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_id10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_id10.setText("Slot 01");

        javax.swing.GroupLayout pnlSlot10Layout = new javax.swing.GroupLayout(pnlSlot10);
        pnlSlot10.setLayout(pnlSlot10Layout);
        pnlSlot10Layout.setHorizontalGroup(
            pnlSlot10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSlot10Layout.createSequentialGroup()
                .addComponent(lblproduct_id10, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSlot10Layout.setVerticalGroup(
            pnlSlot10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSlot10Layout.createSequentialGroup()
                .addGap(0, 49, Short.MAX_VALUE)
                .addComponent(lblproduct_id10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlContent10.add(pnlSlot10);
        pnlSlot10.setBounds(280, -50, 220, 110);

        pnlName10.setkBorderRadius(0);
        pnlName10.setkEndColor(new java.awt.Color(28, 167, 236));
        pnlName10.setkStartColor(new java.awt.Color(28, 167, 236));
        pnlName10.setkTransparentControls(false);

        lblproduct_name10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblproduct_name10.setForeground(new java.awt.Color(255, 255, 255));
        lblproduct_name10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblproduct_name10.setText("Item Name");

        javax.swing.GroupLayout pnlName10Layout = new javax.swing.GroupLayout(pnlName10);
        pnlName10.setLayout(pnlName10Layout);
        pnlName10Layout.setHorizontalGroup(
            pnlName10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlName10Layout.createSequentialGroup()
                .addComponent(lblproduct_name10, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlName10Layout.setVerticalGroup(
            pnlName10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblproduct_name10, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnlContent10.add(pnlName10);
        pnlName10.setBounds(280, 60, 220, 60);

        pnlThumb10.setkBorderRadius(0);
        pnlThumb10.setkEndColor(new java.awt.Color(51, 51, 51));
        pnlThumb10.setkStartColor(new java.awt.Color(204, 204, 204));

        lblproduct_thumb10.setMaximumSize(new java.awt.Dimension(250, 250));
        lblproduct_thumb10.setPreferredSize(new java.awt.Dimension(250, 250));

        javax.swing.GroupLayout pnlThumb10Layout = new javax.swing.GroupLayout(pnlThumb10);
        pnlThumb10.setLayout(pnlThumb10Layout);
        pnlThumb10Layout.setHorizontalGroup(
            pnlThumb10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThumb10Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(lblproduct_thumb10, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        pnlThumb10Layout.setVerticalGroup(
            pnlThumb10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThumb10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblproduct_thumb10, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlContent10.add(pnlThumb10);
        pnlThumb10.setBounds(0, 0, 280, 280);

        pnlBuy10.setBackground(new java.awt.Color(51, 51, 51));
        pnlBuy10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRemove10.setBackground(new java.awt.Color(26, 26, 26));
        btnRemove10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/trash.png"))); // NOI18N
        btnRemove10.setBorderPainted(false);
        btnRemove10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemove10ActionPerformed(evt);
            }
        });
        pnlBuy10.add(btnRemove10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, -10, 120, 110));

        btnUpdate10.setBackground(new java.awt.Color(26, 26, 26));
        btnUpdate10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/update.png"))); // NOI18N
        btnUpdate10.setBorderPainted(false);
        btnUpdate10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate10.setMaximumSize(new java.awt.Dimension(120, 56));
        btnUpdate10.setPreferredSize(new java.awt.Dimension(110, 56));
        btnUpdate10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate10ActionPerformed(evt);
            }
        });
        pnlBuy10.add(btnUpdate10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 130, 110));

        pnlContent10.add(pnlBuy10);
        pnlBuy10.setBounds(280, 280, 220, 100);

        pnlMainContent.add(pnlContent10);

        scrollpnl.setViewportView(pnlMainContent);

        pnlContent.add(scrollpnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1050, 450));

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Select An Item Update or Delete An From The Vending Machine");
        pnlContent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        getContentPane().add(pnlContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1100, 550));

        setSize(new java.awt.Dimension(1099, 600));
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
        StaffMenu smenu = new StaffMenu(setusername);
        smenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_KbtnBackActionPerformed

    private void btnRemove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemove1ActionPerformed
        dataDeletion("01");
    }//GEN-LAST:event_btnRemove1ActionPerformed

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
        try {
            selectedProductID = "01";
            UpdateProduct Udmenu = new UpdateProduct(selectedProductID, setusername);
            Udmenu.setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Occured While Trying To Redirect To Insert Item Menu!");
        }
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void btnRemove2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemove2ActionPerformed
        dataDeletion("02");
    }//GEN-LAST:event_btnRemove2ActionPerformed

    private void btnUpdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate2ActionPerformed
        try {
            selectedProductID = "02";
            UpdateProduct Udmenu = new UpdateProduct(selectedProductID, setusername);
            Udmenu.setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Occured While Trying To Redirect To Insert Item Menu!");
        }    }//GEN-LAST:event_btnUpdate2ActionPerformed

    private void btnRemove3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemove3ActionPerformed
        dataDeletion("03");
    }//GEN-LAST:event_btnRemove3ActionPerformed

    private void btnUpdate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate3ActionPerformed
        try {
            selectedProductID = "03";
            UpdateProduct Udmenu = new UpdateProduct(selectedProductID, setusername);
            Udmenu.setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Occured While Trying To Redirect To Insert Item Menu!");
        }
    }//GEN-LAST:event_btnUpdate3ActionPerformed

    private void btnRemove4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemove4ActionPerformed
        dataDeletion("04");
    }//GEN-LAST:event_btnRemove4ActionPerformed

    private void btnUpdate4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate4ActionPerformed
        try {
            selectedProductID = "04";
            UpdateProduct Udmenu = new UpdateProduct(selectedProductID, setusername);
            Udmenu.setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Occured While Trying To Redirect To Insert Item Menu!");
        }
    }//GEN-LAST:event_btnUpdate4ActionPerformed

    private void btnRemove5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemove5ActionPerformed
        dataDeletion("05");
    }//GEN-LAST:event_btnRemove5ActionPerformed

    private void btnUpdate5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate5ActionPerformed
        try {
            selectedProductID = "05";
            UpdateProduct Udmenu = new UpdateProduct(selectedProductID, setusername);
            Udmenu.setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Occured While Trying To Redirect To Insert Item Menu!");
        }
    }//GEN-LAST:event_btnUpdate5ActionPerformed

    private void btnRemove6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemove6ActionPerformed
        dataDeletion("06");
    }//GEN-LAST:event_btnRemove6ActionPerformed

    private void btnUpdate6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate6ActionPerformed
        try {
            selectedProductID = "06";
            UpdateProduct Udmenu = new UpdateProduct(selectedProductID, setusername);
            Udmenu.setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Occured While Trying To Redirect To Insert Item Menu!");
        }
    }//GEN-LAST:event_btnUpdate6ActionPerformed

    private void btnRemove7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemove7ActionPerformed
        dataDeletion("07");
    }//GEN-LAST:event_btnRemove7ActionPerformed

    private void btnUpdate7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate7ActionPerformed
        try {
            selectedProductID = "07";
            UpdateProduct Udmenu = new UpdateProduct(selectedProductID, setusername);
            Udmenu.setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Occured While Trying To Redirect To Insert Item Menu!");
        }
    }//GEN-LAST:event_btnUpdate7ActionPerformed

    private void btnRemove8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemove8ActionPerformed
        dataDeletion("08");
    }//GEN-LAST:event_btnRemove8ActionPerformed

    private void btnUpdate8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate8ActionPerformed
        try {
            selectedProductID = "08";
            UpdateProduct Udmenu = new UpdateProduct(selectedProductID, setusername);
            Udmenu.setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Occured While Trying To Redirect To Insert Item Menu!");
        }
    }//GEN-LAST:event_btnUpdate8ActionPerformed

    private void btnRemove9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemove9ActionPerformed
        dataDeletion("09");
    }//GEN-LAST:event_btnRemove9ActionPerformed

    private void btnUpdate9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate9ActionPerformed
        try {
            selectedProductID = "09";
            UpdateProduct Udmenu = new UpdateProduct(selectedProductID, setusername);
            Udmenu.setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Occured While Trying To Redirect To Insert Item Menu!");
        }
    }//GEN-LAST:event_btnUpdate9ActionPerformed

    private void btnRemove10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemove10ActionPerformed
        dataDeletion("10");
    }//GEN-LAST:event_btnRemove10ActionPerformed

    private void btnUpdate10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate10ActionPerformed
        try {
            selectedProductID = "10";
            UpdateProduct Udmenu = new UpdateProduct(selectedProductID, setusername);
            Udmenu.setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Occured While Trying To Redirect To Insert Item Menu!");
        }
    }//GEN-LAST:event_btnUpdate10ActionPerformed

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
            java.util.logging.Logger.getLogger(ProductList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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

    private javax.swing.JLabel displaytext;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton KbtnBack;
    private javax.swing.JButton btnRemove1;
    private javax.swing.JButton btnRemove10;
    private javax.swing.JButton btnRemove2;
    private javax.swing.JButton btnRemove3;
    private javax.swing.JButton btnRemove4;
    private javax.swing.JButton btnRemove5;
    private javax.swing.JButton btnRemove6;
    private javax.swing.JButton btnRemove7;
    private javax.swing.JButton btnRemove8;
    private javax.swing.JButton btnRemove9;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JButton btnUpdate10;
    private javax.swing.JButton btnUpdate2;
    private javax.swing.JButton btnUpdate3;
    private javax.swing.JButton btnUpdate4;
    private javax.swing.JButton btnUpdate5;
    private javax.swing.JButton btnUpdate6;
    private javax.swing.JButton btnUpdate7;
    private javax.swing.JButton btnUpdate8;
    private javax.swing.JButton btnUpdate9;
    private javax.swing.JPanel btnclose;
    private javax.swing.JPanel btnminmax;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblclose;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JLabel lblminmax;
    private javax.swing.JLabel lblproduct_id1;
    private javax.swing.JLabel lblproduct_id10;
    private javax.swing.JLabel lblproduct_id2;
    private javax.swing.JLabel lblproduct_id3;
    private javax.swing.JLabel lblproduct_id4;
    private javax.swing.JLabel lblproduct_id5;
    private javax.swing.JLabel lblproduct_id6;
    private javax.swing.JLabel lblproduct_id7;
    private javax.swing.JLabel lblproduct_id8;
    private javax.swing.JLabel lblproduct_id9;
    private javax.swing.JLabel lblproduct_name1;
    private javax.swing.JLabel lblproduct_name10;
    private javax.swing.JLabel lblproduct_name2;
    private javax.swing.JLabel lblproduct_name3;
    private javax.swing.JLabel lblproduct_name4;
    private javax.swing.JLabel lblproduct_name5;
    private javax.swing.JLabel lblproduct_name6;
    private javax.swing.JLabel lblproduct_name7;
    private javax.swing.JLabel lblproduct_name8;
    private javax.swing.JLabel lblproduct_name9;
    private javax.swing.JLabel lblproduct_price1;
    private javax.swing.JLabel lblproduct_price10;
    private javax.swing.JLabel lblproduct_price2;
    private javax.swing.JLabel lblproduct_price3;
    private javax.swing.JLabel lblproduct_price4;
    private javax.swing.JLabel lblproduct_price5;
    private javax.swing.JLabel lblproduct_price6;
    private javax.swing.JLabel lblproduct_price7;
    private javax.swing.JLabel lblproduct_price8;
    private javax.swing.JLabel lblproduct_price9;
    private javax.swing.JLabel lblproduct_quantity1;
    private javax.swing.JLabel lblproduct_quantity10;
    private javax.swing.JLabel lblproduct_quantity2;
    private javax.swing.JLabel lblproduct_quantity3;
    private javax.swing.JLabel lblproduct_quantity4;
    private javax.swing.JLabel lblproduct_quantity5;
    private javax.swing.JLabel lblproduct_quantity6;
    private javax.swing.JLabel lblproduct_quantity7;
    private javax.swing.JLabel lblproduct_quantity8;
    private javax.swing.JLabel lblproduct_quantity9;
    private javax.swing.JLabel lblproduct_thumb1;
    private javax.swing.JLabel lblproduct_thumb10;
    private javax.swing.JLabel lblproduct_thumb2;
    private javax.swing.JLabel lblproduct_thumb3;
    private javax.swing.JLabel lblproduct_thumb4;
    private javax.swing.JLabel lblproduct_thumb5;
    private javax.swing.JLabel lblproduct_thumb6;
    private javax.swing.JLabel lblproduct_thumb7;
    private javax.swing.JLabel lblproduct_thumb8;
    private javax.swing.JLabel lblproduct_thumb9;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JLabel lbltitle1;
    private javax.swing.JLabel lbltitle10;
    private javax.swing.JLabel lbltitle2;
    private javax.swing.JLabel lbltitle3;
    private javax.swing.JLabel lbltitle4;
    private javax.swing.JLabel lbltitle5;
    private javax.swing.JLabel lbltitle6;
    private javax.swing.JLabel lbltitle7;
    private javax.swing.JLabel lbltitle8;
    private javax.swing.JLabel lbltitle9;
    private javax.swing.JPanel panellogo;
    private javax.swing.JPanel paneltitle;
    private javax.swing.JPanel pnlBuy1;
    private javax.swing.JPanel pnlBuy10;
    private javax.swing.JPanel pnlBuy2;
    private javax.swing.JPanel pnlBuy3;
    private javax.swing.JPanel pnlBuy4;
    private javax.swing.JPanel pnlBuy5;
    private javax.swing.JPanel pnlBuy6;
    private javax.swing.JPanel pnlBuy7;
    private javax.swing.JPanel pnlBuy8;
    private javax.swing.JPanel pnlBuy9;
    private keeptoo.KGradientPanel pnlContent;
    private javax.swing.JPanel pnlContent1;
    private javax.swing.JPanel pnlContent10;
    private javax.swing.JPanel pnlContent2;
    private javax.swing.JPanel pnlContent3;
    private javax.swing.JPanel pnlContent4;
    private javax.swing.JPanel pnlContent5;
    private javax.swing.JPanel pnlContent6;
    private javax.swing.JPanel pnlContent7;
    private javax.swing.JPanel pnlContent8;
    private javax.swing.JPanel pnlContent9;
    private javax.swing.JPanel pnlMainContent;
    private keeptoo.KGradientPanel pnlName1;
    private keeptoo.KGradientPanel pnlName10;
    private keeptoo.KGradientPanel pnlName2;
    private keeptoo.KGradientPanel pnlName3;
    private keeptoo.KGradientPanel pnlName4;
    private keeptoo.KGradientPanel pnlName5;
    private keeptoo.KGradientPanel pnlName6;
    private keeptoo.KGradientPanel pnlName7;
    private keeptoo.KGradientPanel pnlName8;
    private keeptoo.KGradientPanel pnlName9;
    private keeptoo.KGradientPanel pnlPrice1;
    private keeptoo.KGradientPanel pnlPrice10;
    private keeptoo.KGradientPanel pnlPrice2;
    private keeptoo.KGradientPanel pnlPrice3;
    private keeptoo.KGradientPanel pnlPrice4;
    private keeptoo.KGradientPanel pnlPrice5;
    private keeptoo.KGradientPanel pnlPrice6;
    private keeptoo.KGradientPanel pnlPrice7;
    private keeptoo.KGradientPanel pnlPrice8;
    private keeptoo.KGradientPanel pnlPrice9;
    private keeptoo.KGradientPanel pnlQuantity1;
    private keeptoo.KGradientPanel pnlQuantity10;
    private keeptoo.KGradientPanel pnlQuantity2;
    private keeptoo.KGradientPanel pnlQuantity3;
    private keeptoo.KGradientPanel pnlQuantity4;
    private keeptoo.KGradientPanel pnlQuantity5;
    private keeptoo.KGradientPanel pnlQuantity6;
    private keeptoo.KGradientPanel pnlQuantity7;
    private keeptoo.KGradientPanel pnlQuantity8;
    private keeptoo.KGradientPanel pnlQuantity9;
    private keeptoo.KGradientPanel pnlSlot1;
    private keeptoo.KGradientPanel pnlSlot10;
    private keeptoo.KGradientPanel pnlSlot2;
    private keeptoo.KGradientPanel pnlSlot3;
    private keeptoo.KGradientPanel pnlSlot4;
    private keeptoo.KGradientPanel pnlSlot5;
    private keeptoo.KGradientPanel pnlSlot6;
    private keeptoo.KGradientPanel pnlSlot7;
    private keeptoo.KGradientPanel pnlSlot8;
    private keeptoo.KGradientPanel pnlSlot9;
    private keeptoo.KGradientPanel pnlThumb1;
    private keeptoo.KGradientPanel pnlThumb10;
    private keeptoo.KGradientPanel pnlThumb2;
    private keeptoo.KGradientPanel pnlThumb3;
    private keeptoo.KGradientPanel pnlThumb4;
    private keeptoo.KGradientPanel pnlThumb5;
    private keeptoo.KGradientPanel pnlThumb6;
    private keeptoo.KGradientPanel pnlThumb7;
    private keeptoo.KGradientPanel pnlThumb8;
    private keeptoo.KGradientPanel pnlThumb9;
    private javax.swing.JScrollPane scrollpnl;
    private javax.swing.JPanel windowsButtons1;
    private javax.swing.JPanel windowsButtons2;
    private javax.swing.JPanel windowsControl;
    private javax.swing.JPanel windowsLogo;
    // End of variables declaration//GEN-END:variables
}
