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
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author ir4un
 */
public class UpdateProduct extends javax.swing.JFrame {

    /**
     * Creates new form startMenu
     */
    private int mousepX;
    private int mousepY;
    private String retrievedProdID;
    private String oldFileLocation; //Assigns Location of Selected Image to a Label to Send to insertImage() Method.
    private Boolean validationCondition;
    final DecimalFormat moneyformat = new DecimalFormat("0.00");
    private String setusername;

    public UpdateProduct(String selectedProdID, String retrievedusername) {

        initComponents();
        this.txtfproduct_desc.setLineWrap(true);
        this.txtfproduct_desc.setWrapStyleWord(true);
        this.txtfproduct_desc.setDocument(new JTextAreaLimit(275));
        this.txtfproduct_name.setDocument(new JTextFieldLimit(10));
        this.txtfproduct_quantity.setDocument(new JTextFieldLimit(8));
        this.txtfproduct_price.setDocument(new JTextFieldLimit(11));

        this.txtfproduct_name.setText("Item Name");
        this.txtfproduct_price.setText("Price");
        this.txtfproduct_quantity.setText("Quantity");
        this.txtfproduct_desc.setText("Item Description");

        this.retrievedProdID = selectedProdID;
        retrieveData();
        this.setusername = retrievedusername;
        this.scrollpnl.getVerticalScrollBar().setUnitIncrement(16);
        setLogo();

    }

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

    private class JTextAreaLimit extends PlainDocument {

        private int limit;

        JTextAreaLimit(int limit) {
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

    private void retrieveData() {
        String source = System.getProperty("user.dir");
        File file = new File(source + "\\src\\txtdatabase\\itemlist.txt");

        try {

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
                String product_desc = fields[5];

                if (retrievedProdID.equals(product_id)) { 
                    lblproductID.setText("Slot: " + product_id);
                    txtfproduct_name.setText(product_name);
                    txtfproduct_price.setText(product_price);
                    txtfproduct_quantity.setText(product_quantity);
                    txtfproduct_desc.setText(product_desc);

                    String source2 = System.getProperty("user.dir");
                    String getselectedImage = source2 + "\\src\\productthumbnail\\" + product_thumbslot; //Assigns Variable Containing Directory Where It Was Selected.

                    BufferedImage bufImg = ImageIO.read(new File(getselectedImage));
                    Image imgScale = bufImg.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(imgScale);
                    lblproduct_thumb.setIcon(scaledIcon);
                }
            }
            br.close();
        } catch (Exception e) {

        }

    }

    private void insertData() {

        try {

            String source = System.getProperty("user.dir") + "\\src\\txtdatabase\\itemlist.txt"; //Retrieving Directory of itemlist.txt File.
            File file = new File(source);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String record;

            while ((record = br.readLine()) != null) { //Retrieving All Data itemlist.txt File.
                String[] fields = record.split("::");
                String product_id = fields[0];
                String product_name = fields[1];
                String product_price = fields[2];
                String product_quantity = fields[3];
                String product_thumbslot = fields[4];
                String product_desc = fields[5];

                String lastNum = fields[0];

                if (retrievedProdID.equals(product_id)) { 
                    br.close();
                    deleteData(source, product_id, 1, "::"); //Removes Line of Empty Data.
                    String retrievedExtension = insertImage(product_id, oldFileLocation, product_thumbslot); //Calls insertImage Method with values of product_id and oldFileLocation.

                    if (retrievedExtension == null) {

                    }

                    FileWriter fw = new FileWriter(file, true);
                    BufferedWriter bf = new BufferedWriter(fw);
                    String newproduct_name = txtfproduct_name.getText(); //Assign Variables Values Based on Input of Textboxes.

                    Double priceDouble = Double.parseDouble(txtfproduct_price.getText());
                    String newproduct_price = moneyformat.format(priceDouble);

                    String newproduct_quantity = txtfproduct_quantity.getText();
                    String newproduct_desc = txtfproduct_desc.getText();

                    String datalist = product_id + "::" + newproduct_name + "::" + newproduct_price + "::" + newproduct_quantity + "::" + "thumbslot" + product_id + "." + retrievedExtension + "::" + newproduct_desc + "\n";
                    bf.write(datalist); //Writes the Values From The Variables to the itemlist.txt File.
                    bf.close();
                    br.close();
                    sortData(source, source); //Rearrange the Lines in itemlist.txt Alphabetically.

                }

            }

        } catch (IOException e) {
        }
    }

    private void retrieveImage() {

        String source = System.getProperty("user.dir");
        String destination = source + "\\src\\productthumbnail\\"; //Sets the Directory Folder Containing Thumbnail Image Files.

        try {

            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("3 Extensions Supported", "Jpg", "png", "jpeg");
            fileChooser.setFileFilter(filter);
            int selected = fileChooser.showOpenDialog(null);
            if (selected == JFileChooser.APPROVE_OPTION) { //Opens Window To Select Image File To Upload As Thumbnail Image.

                File file = fileChooser.getSelectedFile(); //Store Image as File Object.
                String getselectedImage = file.getAbsolutePath(); //Assigns Variable Containing Directory Where It Was Selected.

                BufferedImage bufImg = ImageIO.read(new File(getselectedImage));
                Image imgScale = bufImg.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(imgScale);

                this.lblproduct_thumb.setIcon(scaledIcon); //Sets Icon Image on Label As A Preview.
                this.oldFileLocation = getselectedImage; //Sets Directory of Selected Image Which Will Be Sent To the insertData() Method.

            }
        } catch (Exception e) {

            JFrame parent = new JFrame(); //Display Error Message.
            JOptionPane.showMessageDialog(parent, "Error Occured While Trying To Retrieve Image");
        }

    }

    private String insertImage(String insertedProductID, String imageFileSelected, String currentImageName) {

        String source = System.getProperty("user.dir"); //Retrieving Directory of The Source Files.
        String destination = source + "\\src\\productthumbnail\\"; //Retrieving Directory of The Folder Containing Thumbnail Image Files.

        if (imageFileSelected == null) {
            String newFileofImage = destination + currentImageName;

            String OldFileExtensionName = FilenameUtils.getExtension(newFileofImage); // Retrieve File Extension of Selected File.

            imageFileSelected = destination + "thumbslot" + insertedProductID + "." + OldFileExtensionName;

        }

        File file = new File(imageFileSelected); //Create A File Object With The Directory of the Selected Image.

        String extensionName = FilenameUtils.getExtension(imageFileSelected); // Retrieve File Extension of Selected File.
        String newFileName = destination + "thumbslot" + insertedProductID + "." + extensionName; // Assigning New Directory and New Image Filename.

        File newFile = new File(newFileName);  // Create File Objects of the Image File That Will Be Transfered To The Source Folder.
        File oriFileName = new File(destination);

//        if (newFile.exists()) { //Checks If An Image With The Same Name Already Exist.
//            Path imagesPath = Paths.get(newFileName);
//            System.out.println("destination " + imagesPath);
//            try {
//                Files.delete(imagesPath);
//            } catch (IOException ex) {
//
//            }
//        }

        try {

            Files.copy(file.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING); //Copies File To The Thumbnail Image Folder.
            boolean success = oriFileName.renameTo(newFile); //After Copying, The Image Will Be Renamed.

            if (!success) {
                // File was not successfully renamed
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return extensionName;
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

    private boolean emptyValidation() {
        if (txtfproduct_name.getText().equals("") || txtfproduct_name.getText().equals("Item Name")
                || txtfproduct_price.getText().equals("") || txtfproduct_price.getText().equals("Price")
                || txtfproduct_quantity.getText().equals("") || txtfproduct_quantity.getText().equals("Quantity")
                || txtfproduct_desc.getText().equals("") || txtfproduct_desc.getText().equals("Item Description")) {
            return false;
        } else {
            return true;
        }
    }

    private void validationMessage() {

        if ((validateName(txtfproduct_name.getText())) == true
                && (validatePrice(txtfproduct_price.getText())) == true
                && (validateQuantity(txtfproduct_quantity.getText())) == true) {
            validationCondition = true;
        } else if ((validateName(txtfproduct_name.getText())) == false) {
            JOptionPane.showMessageDialog(null, "Invalid Item Name! Make Sure Not To Include Any Special Characters!");
            validationCondition = false;
        } else if (validatePrice(txtfproduct_price.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Invalid Item Price! Please Try Again.");
            validationCondition = false;
        } else if (validateQuantity(txtfproduct_quantity.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Invalid Item Quantity! Please Try Again.");
            validationCondition = false;
        } else if (validateDescription(txtfproduct_desc.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Description Contains Illegal Characters! \n Please Try Again!.");
            validationCondition = false;
        } else if (oldFileLocation == null) {
            JOptionPane.showMessageDialog(null, "Please Insert An Image and Try Again!");
            validationCondition = false;
        } else {
        }

    }

    private boolean validateName(String retrievedName) {
        String nameRegex = "^[a-zA-Z0-9! @#$%^&.,<>`-]{3,}$";
        Pattern namePattern = Pattern.compile(nameRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = namePattern.matcher(retrievedName);
        return matcher.find();
    }

    private boolean validatePrice(String retrievedPrice) {
        String priceRegex = "^(0|([1-9]\\d{0,2}(,\\d{3})*)|(([1-9]\\d*)?\\d))(\\.\\d\\d)+\\.{0,7}?$";
        Pattern pricePattern = Pattern.compile(priceRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pricePattern.matcher(retrievedPrice);
        if (txtfproduct_price.getText().equals("0") || txtfproduct_price.getText().equals("0.00")) {
            return false;
        } else {
            return matcher.find();
        }

    }

    private boolean validateQuantity(String retrievedQuantity) {
        String quantityRegex = "^(0|[1-9][0-9]{0,})$";
        Pattern quantityPattern = Pattern.compile(quantityRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = quantityPattern.matcher(retrievedQuantity);
        return matcher.find();
    }

    private boolean validateDescription(String retrievedDesc) {
        String descRegex = "^[a-zA-Z0-9!@#$%^&.,<>` ]{3,275}$";
        Pattern descPattern = Pattern.compile(descRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = descPattern.matcher(retrievedDesc);
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

        jLabel3 = new javax.swing.JLabel();
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
        txtfproduct_name = new javax.swing.JTextField();
        txtfproduct_price = new javax.swing.JTextField();
        txtfproduct_quantity = new javax.swing.JTextField();
        txtfproduct_desc = new javax.swing.JTextArea();
        KbtnSelectImage = new keeptoo.KButton();
        pnlPreviewImage = new keeptoo.KGradientPanel();
        lblproduct_thumb = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        KbtnUpdate = new keeptoo.KButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        KbtnBack = new keeptoo.KButton();
        pnlSlotID = new keeptoo.KGradientPanel();
        lblproductID = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Update Staff Details Into The Vending Machine");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1024, 600));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1024, 600));

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
        lbltitle.setText("Update Product Details and Quantity");
        lbltitle.setMaximumSize(new java.awt.Dimension(500, 50));
        lbltitle.setMinimumSize(new java.awt.Dimension(50, 50));
        lbltitle.setPreferredSize(new java.awt.Dimension(500, 50));

        javax.swing.GroupLayout windowsButtons2Layout = new javax.swing.GroupLayout(windowsButtons2);
        windowsButtons2.setLayout(windowsButtons2Layout);
        windowsButtons2Layout.setHorizontalGroup(
            windowsButtons2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, windowsButtons2Layout.createSequentialGroup()
                .addContainerGap(177, Short.MAX_VALUE)
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

        pnlContent.setkBorderRadius(0);
        pnlContent.setkEndColor(new java.awt.Color(28, 167, 236));
        pnlContent.setkStartColor(new java.awt.Color(31, 47, 152));
        pnlContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollpnl.setBorder(null);
        scrollpnl.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpnl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pnlMainContent.setBackground(new java.awt.Color(102, 102, 102));
        pnlMainContent.setMaximumSize(new java.awt.Dimension(1024, 600));
        pnlMainContent.setPreferredSize(new java.awt.Dimension(553, 755));

        pnlDisplay.setBackground(new java.awt.Color(102, 102, 102));
        pnlDisplay.setLayout(null);

        txtfproduct_name.setBackground(new java.awt.Color(102, 102, 102));
        txtfproduct_name.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        txtfproduct_name.setForeground(new java.awt.Color(255, 255, 255));
        txtfproduct_name.setText("Item Name");
        txtfproduct_name.setToolTipText("At Least 10 Characters!");
        txtfproduct_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtfproduct_name.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        txtfproduct_name.setOpaque(false);
        txtfproduct_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfproduct_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfproduct_nameFocusLost(evt);
            }
        });
        txtfproduct_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfproduct_nameKeyTyped(evt);
            }
        });
        pnlDisplay.add(txtfproduct_name);
        txtfproduct_name.setBounds(40, 30, 450, 60);

        txtfproduct_price.setBackground(new java.awt.Color(102, 102, 102));
        txtfproduct_price.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        txtfproduct_price.setForeground(new java.awt.Color(255, 255, 255));
        txtfproduct_price.setText("Item Price");
        txtfproduct_price.setToolTipText("Provide Correct Price Format! Ex: 1.00");
        txtfproduct_price.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtfproduct_price.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfproduct_priceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfproduct_priceFocusLost(evt);
            }
        });
        txtfproduct_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfproduct_priceActionPerformed(evt);
            }
        });
        pnlDisplay.add(txtfproduct_price);
        txtfproduct_price.setBounds(80, 110, 410, 60);

        txtfproduct_quantity.setBackground(new java.awt.Color(102, 102, 102));
        txtfproduct_quantity.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        txtfproduct_quantity.setForeground(new java.awt.Color(255, 255, 255));
        txtfproduct_quantity.setText("Item Quantity");
        txtfproduct_quantity.setToolTipText("Only Insert Numbers!");
        txtfproduct_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtfproduct_quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfproduct_quantityFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfproduct_quantityFocusLost(evt);
            }
        });
        txtfproduct_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfproduct_quantityActionPerformed(evt);
            }
        });
        pnlDisplay.add(txtfproduct_quantity);
        txtfproduct_quantity.setBounds(40, 190, 450, 60);

        txtfproduct_desc.setBackground(new java.awt.Color(102, 102, 102));
        txtfproduct_desc.setColumns(20);
        txtfproduct_desc.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        txtfproduct_desc.setForeground(new java.awt.Color(255, 255, 255));
        txtfproduct_desc.setRows(3);
        txtfproduct_desc.setText("Item Description");
        txtfproduct_desc.setToolTipText("Less Than 275 Characters!");
        txtfproduct_desc.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtfproduct_desc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfproduct_descFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfproduct_descFocusLost(evt);
            }
        });
        pnlDisplay.add(txtfproduct_desc);
        txtfproduct_desc.setBounds(40, 280, 450, 130);

        KbtnSelectImage.setText("Choose Image");
        KbtnSelectImage.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        KbtnSelectImage.setkEndColor(new java.awt.Color(28, 167, 236));
        KbtnSelectImage.setkHoverEndColor(new java.awt.Color(31, 47, 152));
        KbtnSelectImage.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        KbtnSelectImage.setkHoverStartColor(new java.awt.Color(28, 167, 236));
        KbtnSelectImage.setkPressedColor(new java.awt.Color(0, 102, 204));
        KbtnSelectImage.setkStartColor(new java.awt.Color(31, 47, 152));
        KbtnSelectImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                KbtnSelectImageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                KbtnSelectImageMouseExited(evt);
            }
        });
        KbtnSelectImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KbtnSelectImageActionPerformed(evt);
            }
        });
        pnlDisplay.add(KbtnSelectImage);
        KbtnSelectImage.setBounds(370, 460, 140, 50);

        pnlPreviewImage.setkBorderRadius(0);
        pnlPreviewImage.setkEndColor(new java.awt.Color(51, 51, 51));
        pnlPreviewImage.setkStartColor(new java.awt.Color(204, 204, 204));
        pnlPreviewImage.setMaximumSize(new java.awt.Dimension(150, 150));
        pnlPreviewImage.setPreferredSize(new java.awt.Dimension(150, 150));

        lblproduct_thumb.setBackground(new java.awt.Color(153, 153, 153));
        lblproduct_thumb.setMaximumSize(new java.awt.Dimension(50, 50));
        lblproduct_thumb.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout pnlPreviewImageLayout = new javax.swing.GroupLayout(pnlPreviewImage);
        pnlPreviewImage.setLayout(pnlPreviewImageLayout);
        pnlPreviewImageLayout.setHorizontalGroup(
            pnlPreviewImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPreviewImageLayout.createSequentialGroup()
                .addComponent(lblproduct_thumb, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlPreviewImageLayout.setVerticalGroup(
            pnlPreviewImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPreviewImageLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblproduct_thumb, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlDisplay.add(pnlPreviewImage);
        pnlPreviewImage.setBounds(210, 460, 150, 150);

        jLabel5.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Item Thumnail Image:");
        pnlDisplay.add(jLabel5);
        jLabel5.setBounds(40, 460, 170, 20);

        KbtnUpdate.setText("Update Item");
        KbtnUpdate.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        KbtnUpdate.setkEndColor(new java.awt.Color(28, 167, 236));
        KbtnUpdate.setkHoverEndColor(new java.awt.Color(31, 47, 152));
        KbtnUpdate.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        KbtnUpdate.setkHoverStartColor(new java.awt.Color(28, 167, 236));
        KbtnUpdate.setkPressedColor(new java.awt.Color(0, 102, 204));
        KbtnUpdate.setkStartColor(new java.awt.Color(31, 47, 152));
        KbtnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                KbtnUpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                KbtnUpdateMouseExited(evt);
            }
        });
        KbtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KbtnUpdateActionPerformed(evt);
            }
        });
        pnlDisplay.add(KbtnUpdate);
        KbtnUpdate.setBounds(130, 660, 300, 70);

        jLabel6.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("RM");
        pnlDisplay.add(jLabel6);
        jLabel6.setBounds(40, 130, 30, 20);

        jLabel7.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Only .png and .jpg are supported!");
        pnlDisplay.add(jLabel7);
        jLabel7.setBounds(370, 520, 170, 20);

        javax.swing.GroupLayout pnlMainContentLayout = new javax.swing.GroupLayout(pnlMainContent);
        pnlMainContent.setLayout(pnlMainContentLayout);
        pnlMainContentLayout.setHorizontalGroup(
            pnlMainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlMainContentLayout.setVerticalGroup(
            pnlMainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainContentLayout.createSequentialGroup()
                .addComponent(pnlDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

        pnlSlotID.setkBorderRadius(0);
        pnlSlotID.setkEndColor(new java.awt.Color(204, 204, 204));
        pnlSlotID.setkStartColor(new java.awt.Color(51, 51, 51));
        pnlSlotID.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblproductID.setFont(new java.awt.Font("Gill Sans MT", 3, 24)); // NOI18N
        lblproductID.setForeground(new java.awt.Color(255, 255, 255));
        lblproductID.setText("Slot: 00");
        pnlSlotID.add(lblproductID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        pnlContent.add(pnlSlotID, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 170, 50));

        jLabel4.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Update Item Details Into The Vending Machine");
        pnlContent.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(windowsControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlContent, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(windowsControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlContent, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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

    private void txtfproduct_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfproduct_nameFocusGained
        if ("".equals(txtfproduct_name.getText()) || "Item Name".equals(txtfproduct_name.getText())) {
            txtfproduct_name.setText("");
            txtfproduct_name.setForeground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtfproduct_nameFocusGained

    private void txtfproduct_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfproduct_nameFocusLost
        if ("".equals(txtfproduct_name.getText())) {
            txtfproduct_name.setForeground(new java.awt.Color(255, 255, 255));
            txtfproduct_name.setText("Item Name");
        }
    }//GEN-LAST:event_txtfproduct_nameFocusLost

    private void txtfproduct_nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfproduct_nameKeyTyped

    }//GEN-LAST:event_txtfproduct_nameKeyTyped

    private void txtfproduct_priceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfproduct_priceFocusGained
        if ("".equals(txtfproduct_price.getText()) || "Price".equals(txtfproduct_price.getText())) {
            txtfproduct_price.setText("");
            txtfproduct_price.setForeground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtfproduct_priceFocusGained

    private void txtfproduct_priceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfproduct_priceFocusLost
        if ("".equals(txtfproduct_price.getText())) {
            txtfproduct_price.setForeground(new java.awt.Color(255, 255, 255));
            txtfproduct_price.setText("Price");
        }
    }//GEN-LAST:event_txtfproduct_priceFocusLost

    private void txtfproduct_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfproduct_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfproduct_priceActionPerformed

    private void txtfproduct_quantityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfproduct_quantityFocusGained
        if ("".equals(txtfproduct_quantity.getText()) || "Quantity".equals(txtfproduct_quantity.getText())) {
            txtfproduct_quantity.setText("");
            txtfproduct_quantity.setForeground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtfproduct_quantityFocusGained

    private void txtfproduct_quantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfproduct_quantityFocusLost
        if ("".equals(txtfproduct_quantity.getText())) {
            txtfproduct_quantity.setForeground(new java.awt.Color(255, 255, 255));
            txtfproduct_quantity.setText("Quantity");
        }
    }//GEN-LAST:event_txtfproduct_quantityFocusLost

    private void txtfproduct_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfproduct_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfproduct_quantityActionPerformed

    private void txtfproduct_descFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfproduct_descFocusGained
        if ("".equals(txtfproduct_desc.getText()) || "Item Description".equals(txtfproduct_desc.getText())) {
            txtfproduct_desc.setText("");
            txtfproduct_desc.setForeground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtfproduct_descFocusGained

    private void txtfproduct_descFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfproduct_descFocusLost
        if ("".equals(txtfproduct_desc.getText())) {
            txtfproduct_desc.setForeground(new java.awt.Color(255, 255, 255));
            txtfproduct_desc.setText("Item Description");
        }
    }//GEN-LAST:event_txtfproduct_descFocusLost

    private void KbtnSelectImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KbtnSelectImageMouseEntered
        KbtnSelectImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_KbtnSelectImageMouseEntered

    private void KbtnSelectImageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KbtnSelectImageMouseExited
        KbtnSelectImage.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_KbtnSelectImageMouseExited

    private void KbtnSelectImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KbtnSelectImageActionPerformed
        retrieveImage();
    }//GEN-LAST:event_KbtnSelectImageActionPerformed

    private void KbtnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KbtnUpdateMouseEntered
        KbtnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_KbtnUpdateMouseEntered

    private void KbtnUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KbtnUpdateMouseExited
        KbtnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_KbtnUpdateMouseExited

    private void KbtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KbtnUpdateActionPerformed
        if (emptyValidation() == true) {
            validationMessage();
            if (validationCondition == true) {
                try {
                    insertData();
                    JOptionPane.showMessageDialog(null, "Product Has Been Successfully Updated!");
                    ProductList lmenu = new ProductList(setusername);
                    lmenu.setVisible(true);
                    dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error Occured While Trying To Redirect To Product List Menu!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Insert All of the Neccessary Information!");
        }
    }//GEN-LAST:event_KbtnUpdateActionPerformed

    private void KbtnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KbtnBackMouseEntered
        KbtnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_KbtnBackMouseEntered

    private void KbtnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KbtnBackMouseExited
        KbtnBack.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_KbtnBackMouseExited

    private void KbtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KbtnBackActionPerformed

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Go Back? \n Updated Information Will Not be Saved!", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {

            try {
                ProductList lmenu = new ProductList(setusername);
                lmenu.setVisible(true);
                dispose();
            } catch (Exception e) {
                JFrame parent = new JFrame(); //Display Error Message.
                JOptionPane.showMessageDialog(parent, "Error Occured While Trying To Redirect To Product List Menu!");
            }
        } else {

        }


    }//GEN-LAST:event_KbtnBackActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private keeptoo.KButton KbtnSelectImage;
    private keeptoo.KButton KbtnUpdate;
    private javax.swing.JPanel btnclose;
    private javax.swing.JPanel btnminmax;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblclose;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JLabel lblminmax;
    private javax.swing.JLabel lblproductID;
    private javax.swing.JLabel lblproduct_thumb;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JPanel panellogo;
    private javax.swing.JPanel paneltitle;
    private keeptoo.KGradientPanel pnlContent;
    private javax.swing.JPanel pnlDisplay;
    private javax.swing.JPanel pnlMainContent;
    private keeptoo.KGradientPanel pnlPreviewImage;
    private keeptoo.KGradientPanel pnlSlotID;
    private javax.swing.JScrollPane scrollpnl;
    private javax.swing.JTextArea txtfproduct_desc;
    private javax.swing.JTextField txtfproduct_name;
    private javax.swing.JTextField txtfproduct_price;
    private javax.swing.JTextField txtfproduct_quantity;
    private javax.swing.JPanel windowsButtons1;
    private javax.swing.JPanel windowsButtons2;
    private javax.swing.JPanel windowsControl;
    private javax.swing.JPanel windowsLogo;
    // End of variables declaration//GEN-END:variables
}
