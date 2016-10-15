//Nameer Qureshi
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.text.*;
import java.util.*;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.table.*;

public class View extends JFrame implements ActionListener{

		private PicPanel imagePanel;
		private String fileName;
		private File currentFile;
		private ArrayList<JSlider> sliders;
		private JButton uploadPre;
		private JPanel toolsPanel;
		
		public View()
		{
			//----------makes the default image--------------------------
			fileName = "Beaver.jpg";
			currentFile = new File(fileName);
			int screenWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
			int screenHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
			
			setTitle("BIE-EVER ----------- " + fileName);
			setSize(screenWidth, screenHeight);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new BorderLayout());
			JPanel container = new JPanel();
			container.setLayout(new GridLayout(1,2));
			
			imagePanel = new PicPanel();
			
			//---------makes the menu bar options------------------------
			JMenuBar options = new JMenuBar();
			JMenu file = new JMenu("File");
			
			String[] fileOptions = {"Open", "Save"};
			
			for(int i = 0; i < 2; i++)
			{
				JMenuItem item = new JMenuItem(fileOptions[i]);
				item.addActionListener(this);
				file.add(item);
			}
			
			options.add(file);
			setJMenuBar(options);
			
			toolsPanel = new JPanel();
			toolsPanel.setBounds(0, 0, screenWidth/2, screenHeight);
			toolsPanel.setLayout(null);
			
			int vertAlignment = 50;
			int horizAlignment = toolsPanel.getWidth()/2;
			
			uploadPre = new JButton("Upload Preset");
			uploadPre.setBounds(horizAlignment, screenHeight-500, 140, 30);
			uploadPre.addActionListener(this);
			
			JButton cropButton = new JButton("Crop");
			cropButton.setBounds(horizAlignment, screenHeight-450, 140, 30);
			cropButton.addActionListener(this);
			
			JButton rotateButton = new JButton("Rotate 90 degrees");
			rotateButton.setBounds(horizAlignment, screenHeight-400, 140, 30);
			rotateButton.addActionListener(this);
			
			JButton paintBrushButton = new JButton("PaintBrush");
			paintBrushButton.setBounds(horizAlignment, screenHeight-350, 140, 30);
			paintBrushButton.addActionListener(this);
			
			toolsPanel.add(uploadPre);
			toolsPanel.add(cropButton);
			toolsPanel.add(rotateButton);
			toolsPanel.add(paintBrushButton);
			
			sliders = new ArrayList<JSlider>();
			
			String[] sliderNames = {"Red", "Green", "Blue", "Brightness", "Saturation", "Sharpness", "Blur"};

			
			for(int i = 0; i < 7; i++)
			{
				JSlider toAdd = new JSlider(-100, 100, 0); 
				toAdd.setBounds(horizAlignment, vertAlignment, 200, 50);
				//toAdd.addChangeListener(this);
				
				sliders.add(toAdd);
				toolsPanel.add(toAdd);
			
				JLabel label = new JLabel(sliderNames[i]);
				label.setBounds(horizAlignment, vertAlignment-15, 80, 16);
				label.setLayout(null);
				toolsPanel.add(label);
				
				
				vertAlignment += 70;
			}
			repaint();
			
			
			//-----------adds to the JFrame---------------------
			container.add(imagePanel);
			container.add(toolsPanel);
			add(container);
			
			setVisible(true);
		}
		
		//makes the panel with only the picture in it
		class PicPanel extends JPanel
		{
			private BufferedImage image;
			private int width;
			private int height;
			
			public PicPanel()
			{	
				//read in Image
				try
				{
					image = ImageIO.read(currentFile);
					
					Image temp = image.getScaledInstance((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()), Image.SCALE_DEFAULT);
					BufferedImage newImage = new BufferedImage((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()), BufferedImage.TYPE_INT_ARGB);
					
					Graphics2D g2d = newImage.createGraphics();
					g2d.drawImage(temp, 0, 0, null);
					g2d.dispose();
					
					image = newImage;
					
					width = image.getWidth();
					height = image.getHeight();
					repaint();				
				}catch(IOException error)
				{
					System.out.println("Cannot read in that file");
					System.exit(0);
				}
			}
			
			public Dimension getPreferredSize()
			{
				return new Dimension(width, height);
			}
			
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(image, 0, 0, this);
				this.repaint();
			}
		}
		
		private boolean fileIsChanged()
		{
			if(fileName.indexOf("*") != -1)
				return true;
			
			else
				return false;
		}
		
		private void fileChanged()
		{
			if(fileName.indexOf("*") == -1)
			{
				fileName += "*";
			}
		}
		
		private void removeAsterisk()
		{
			if(fileIsChanged() == true)
			{
				fileName = fileName.substring(0,  fileName.length()-1);
			}
		}
		
		private void promptSave()
		{
			if(fileIsChanged() == true)
			{
				int result = JOptionPane.showConfirmDialog(null, "Do you want to save your image?");
				
				if(result == JOptionPane.YES_OPTION)
				{
					saveFile(currentFile);
				}
			}
		}
		
		private void saveFile(File toSave)
		{
			try {
				
				ImageIO.write(imagePanel.image, "JPG", new File(fileName));
			
			} catch (IOException e) {
				System.out.println("Unable to save, sucks.");
				System.exit(0);
			}
		}

		//performs actions based on whats clicked 
		public void actionPerformed(ActionEvent ae) {
			
			//user uploads new image
			if(ae.getActionCommand().equals("Open"))
			{
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(null);
				
				if(result == JFileChooser.APPROVE_OPTION)
				{
					currentFile = fileChooser.getSelectedFile();
				}
						
				fileName = currentFile.getName();
				
				remove(imagePanel);
				imagePanel = null;
				imagePanel = new PicPanel();
				imagePanel.setLayout(null);
	
				add(imagePanel);
				setVisible(true);
				repaint();
			
				setTitle("BIE-EVER ----------- " + fileName);
			}
			
			//user wants to save changes
			else if(ae.getActionCommand().equals("Save"))
			{
				saveFile(currentFile);
			}
		}
		
		public static void main(String[] args)
		{
			new View();
		}
}
