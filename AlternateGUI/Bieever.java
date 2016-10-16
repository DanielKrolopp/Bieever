/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.Bieever2;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Daniel
 */
public class BieeverUI extends javax.swing.JFrame {

    /**
     * Creates new form BieeverUI
     */
    private static Graphics g;
    
    public BieeverUI() {
        initComponents();
        
        this.setTitle("Bieever");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        SidePanel = new javax.swing.JPanel();
        BrightnessPanel = new javax.swing.JPanel();
        ExposureSlider = new javax.swing.JSlider();
        ExposureLabel = new javax.swing.JLabel();
        ContrastLabel = new javax.swing.JLabel();
        ContrastSlider = new javax.swing.JSlider();
        ConvolutionPanel = new javax.swing.JPanel();
        SharpnessLabel = new javax.swing.JLabel();
        SharpnessSlider = new javax.swing.JSlider();
        BlurLabel = new javax.swing.JLabel();
        BlurSlider = new javax.swing.JSlider();
        SaturationLabel = new javax.swing.JLabel();
        SaturationSlider = new javax.swing.JSlider();
        ExifDataPanel = new javax.swing.JPanel();
        ExifHeaderPanel = new javax.swing.JPanel();
        ExifLabel = new javax.swing.JLabel();
        IntensityPanel = new javax.swing.JPanel();
        RedIntensityLabel = new javax.swing.JLabel();
        RedIntensitySlider = new javax.swing.JSlider();
        GreenIntensityLabel = new javax.swing.JLabel();
        GreenIntensitySlider = new javax.swing.JSlider();
        BlueIntensityLabel = new javax.swing.JLabel();
        BlueIntensitySlider = new javax.swing.JSlider();
        ImageArea = new javax.swing.JPanel();
        MenuBar = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        Open = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SidePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));

        BrightnessPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 180, 180)));

        ExposureLabel.setText("Exposure");

        ContrastLabel.setText("Contrast");

        javax.swing.GroupLayout BrightnessPanelLayout = new javax.swing.GroupLayout(BrightnessPanel);
        BrightnessPanel.setLayout(BrightnessPanelLayout);
        BrightnessPanelLayout.setHorizontalGroup(
            BrightnessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BrightnessPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BrightnessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ContrastSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ExposureSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BrightnessPanelLayout.createSequentialGroup()
                        .addGroup(BrightnessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ContrastLabel)
                            .addComponent(ExposureLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        BrightnessPanelLayout.setVerticalGroup(
            BrightnessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BrightnessPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ExposureLabel)
                .addGap(5, 5, 5)
                .addComponent(ExposureSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContrastLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContrastSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        ConvolutionPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 180, 180)));

        SharpnessLabel.setText("Sharpness");

        BlurLabel.setText("Blur");

        SaturationLabel.setText("Saturation");

        javax.swing.GroupLayout ConvolutionPanelLayout = new javax.swing.GroupLayout(ConvolutionPanel);
        ConvolutionPanel.setLayout(ConvolutionPanelLayout);
        ConvolutionPanelLayout.setHorizontalGroup(
            ConvolutionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConvolutionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConvolutionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SaturationSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BlurSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SharpnessSlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ConvolutionPanelLayout.createSequentialGroup()
                        .addGroup(ConvolutionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SharpnessLabel)
                            .addComponent(BlurLabel)
                            .addComponent(SaturationLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ConvolutionPanelLayout.setVerticalGroup(
            ConvolutionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConvolutionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SharpnessLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SharpnessSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BlurLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BlurSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaturationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaturationSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ExifDataPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 180, 180)));

        ExifHeaderPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 180, 180)), null));

        ExifLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        ExifLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ExifLabel.setText("EXIF Data");

        javax.swing.GroupLayout ExifHeaderPanelLayout = new javax.swing.GroupLayout(ExifHeaderPanel);
        ExifHeaderPanel.setLayout(ExifHeaderPanelLayout);
        ExifHeaderPanelLayout.setHorizontalGroup(
            ExifHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExifHeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ExifLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ExifHeaderPanelLayout.setVerticalGroup(
            ExifHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ExifLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ExifDataPanelLayout = new javax.swing.GroupLayout(ExifDataPanel);
        ExifDataPanel.setLayout(ExifDataPanelLayout);
        ExifDataPanelLayout.setHorizontalGroup(
            ExifDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExifDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ExifHeaderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ExifDataPanelLayout.setVerticalGroup(
            ExifDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExifDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ExifHeaderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );

        IntensityPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 180, 180)));

        RedIntensityLabel.setText("Red Intensity");

        GreenIntensityLabel.setText("Green Intensity");

        BlueIntensityLabel.setText("Blue Intensity");

        javax.swing.GroupLayout IntensityPanelLayout = new javax.swing.GroupLayout(IntensityPanel);
        IntensityPanel.setLayout(IntensityPanelLayout);
        IntensityPanelLayout.setHorizontalGroup(
            IntensityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IntensityPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(IntensityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RedIntensitySlider, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(GreenIntensitySlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(IntensityPanelLayout.createSequentialGroup()
                        .addGroup(IntensityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RedIntensityLabel)
                            .addComponent(GreenIntensityLabel)
                            .addComponent(BlueIntensityLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(BlueIntensitySlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        IntensityPanelLayout.setVerticalGroup(
            IntensityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IntensityPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RedIntensityLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RedIntensitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GreenIntensityLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GreenIntensitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BlueIntensityLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BlueIntensitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(IntensityPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ExifDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BrightnessPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ConvolutionPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addComponent(BrightnessPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConvolutionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IntensityPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExifDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ImageArea.setBackground(new java.awt.Color(250, 250, 250));
        ImageArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100)));

        javax.swing.GroupLayout ImageAreaLayout = new javax.swing.GroupLayout(ImageArea);
        ImageArea.setLayout(ImageAreaLayout);
        ImageAreaLayout.setHorizontalGroup(
            ImageAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1618, Short.MAX_VALUE)
        );
        ImageAreaLayout.setVerticalGroup(
            ImageAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        File.setText("File");

        Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        Open.setText("Open");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        File.add(Open);

        Save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        Save.setText("Save");
        File.add(Save);

        MenuBar.add(File);

        Edit.setText("Edit");
        MenuBar.add(Edit);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImageArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ImageArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {                                     
        final JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter(".jpg, .png, .tif & .bmp", "png", "JPG", "tif", "bmp"));
        int val = chooser.showOpenDialog(Open);
        System.out.println("Approved: "+(val = JFileChooser.APPROVE_OPTION));
        if(val != JFileChooser.APPROVE_OPTION){
            return;
        }
        System.out.println("Made it this far");
        File chosen = chooser.getSelectedFile();
        try {
            BufferedImage image = ImageIO.read(chosen);
            int imageWidth = image.getWidth();
            int imageHeight = image.getHeight();
            int panelWidth = ImageArea.getWidth();
            int panelHeight = ImageArea.getHeight();
            Image smallerImage = image;
            
            if(imageWidth > panelWidth - 10 || imageHeight > panelHeight - 10){
                smallerImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            }
            int xImageDraw = (panelWidth - imageWidth)/2;
            int yImageDraw = (panelHeight - imageHeight)/2;
            BufferedImage draw = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphicsImage = draw.createGraphics();
            graphicsImage.drawImage(smallerImage, 50, 50, null);
            
            //System.out.println("Image drawn at x: "+xImageDraw+" y: "+yImageDraw);
            graphicsImage.dispose();
            image = draw;
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }                                    

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BieeverUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BieeverUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BieeverUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BieeverUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BieeverUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel BlueIntensityLabel;
    private javax.swing.JSlider BlueIntensitySlider;
    private javax.swing.JLabel BlurLabel;
    private javax.swing.JSlider BlurSlider;
    private javax.swing.JPanel BrightnessPanel;
    private javax.swing.JLabel ContrastLabel;
    private javax.swing.JSlider ContrastSlider;
    private javax.swing.JPanel ConvolutionPanel;
    private javax.swing.JMenu Edit;
    private javax.swing.JPanel ExifDataPanel;
    private javax.swing.JPanel ExifHeaderPanel;
    private javax.swing.JLabel ExifLabel;
    private javax.swing.JLabel ExposureLabel;
    private javax.swing.JSlider ExposureSlider;
    private javax.swing.JMenu File;
    private javax.swing.JLabel GreenIntensityLabel;
    private javax.swing.JSlider GreenIntensitySlider;
    private javax.swing.JPanel ImageArea;
    private javax.swing.JPanel IntensityPanel;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem Open;
    private javax.swing.JLabel RedIntensityLabel;
    private javax.swing.JSlider RedIntensitySlider;
    private javax.swing.JLabel SaturationLabel;
    private javax.swing.JSlider SaturationSlider;
    private javax.swing.JMenuItem Save;
    private javax.swing.JLabel SharpnessLabel;
    private javax.swing.JSlider SharpnessSlider;
    private javax.swing.JPanel SidePanel;
    // End of variables declaration                   
}
