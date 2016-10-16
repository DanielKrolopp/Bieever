import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//Nameer Qureshi


public class View extends JFrame implements ActionListener{

		private PicPanel imagePanel;
		private String fileName;
		private File currentFile;
		private ArrayList<JSlider> sliders;
		private JButton uploadPre;
		private JPanel toolsPanel;
		private JPanel container;
		
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
			container = new JPanel();
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
			
			//----------makes a tools panel and adds buttons---------------------------
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
				toAdd.addChangeListener(new ChangeListener() {

					@Override
					public void stateChanged(ChangeEvent ce) {
						
						JSlider toCheck = (JSlider)ce.getSource();
						
						//if red slider is changing
						if(toCheck.equals(sliders.get(0)))
						{
							GlobalModifier change = new RedIntensity();
							imagePanel.image = ImageHelper.toBufferedImage(change.modify(ImageHelper.fromBufferedImage(imagePanel.image), (toCheck.getValue()/100)));
						}
						
						//if green slider is changing
						else if(toCheck.equals(sliders.get(1)))
						{
							GlobalModifier change = new GreenIntensity();
							imagePanel.image = ImageHelper.toBufferedImage(change.modify(ImageHelper.fromBufferedImage(imagePanel.image), (toCheck.getValue())));
						}
						
						//if blue slider is changing
						else if(toCheck.equals(sliders.get(2)))
						{
							GlobalModifier change = new BlueIntensity();
							imagePanel.image = ImageHelper.toBufferedImage(change.modify(ImageHelper.fromBufferedImage(imagePanel.image), (toCheck.getValue())));
						}
						
						//if brightness slider is changing
						else if(toCheck.equals(sliders.get(3)))
						{
							GlobalModifier change = new Brightness();
							imagePanel.image = ImageHelper.toBufferedImage(change.modify(ImageHelper.fromBufferedImage(imagePanel.image), (toCheck.getValue())));
						}
						
						//if saturation slider is changing
						else if(toCheck.equals(sliders.get(4)))
						{
							GlobalModifier change = new Saturation();
							imagePanel.image = ImageHelper.toBufferedImage(change.modify(ImageHelper.fromBufferedImage(imagePanel.image), (toCheck.getValue())));
						}
						
						//if sharpness slider is changing
						else if(toCheck.equals(sliders.get(5)))
						{
							GlobalModifier change = new GaussianUnsharp();
							imagePanel.image = ImageHelper.toBufferedImage(change.modify(ImageHelper.fromBufferedImage(imagePanel.image), (toCheck.getValue())));
						}
						
						//if blur slider is changing
						else if(toCheck.equals(sliders.get(6)))
						{
							GlobalModifier change = new GaussianBlur();
							imagePanel.image = ImageHelper.toBufferedImage(change.modify(ImageHelper.fromBufferedImage(imagePanel.image), toCheck.getValue()));
						}
						
					}
					
				});
				
				sliders.add(toAdd);
				toolsPanel.add(toAdd);
			
				JLabel label = new JLabel(sliderNames[i]);
				label.setBounds(horizAlignment, vertAlignment-15, 80, 16);
				label.setLayout(null);
				toolsPanel.add(label);
				
				
				vertAlignment += 70;
			}
			
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
					int boxWidth = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2);
					int boxHeight = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight());
					
					if(image.getWidth() > boxWidth && image.getHeight() > boxHeight)
					{
						image = (BufferedImage) newImage(boxWidth, boxHeight);
					}
					
					else if(image.getWidth() > boxWidth)
					{
						image = (BufferedImage) newImage(boxWidth, image.getHeight());
					}
					
					else if(image.getHeight() > boxHeight)
					{
						image = (BufferedImage) newImage(image.getWidth(), boxHeight);
					}
					
					width = image.getWidth();
					height = image.getHeight();
					repaint();				
				}catch(IOException error)
				{
					System.out.println("Cannot read in that file");
					System.exit(0);
				}
			}
			
			public java.awt.Image newImage(int newWidth, int newHeight)
			{
				java.awt.Image temp = image.getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_SMOOTH);
				BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
				
				Graphics2D g2d = newImage.createGraphics();
				g2d.drawImage(temp, 0, 0, null);
				g2d.dispose();
				
				return newImage;
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
				
				container.removeAll();
				imagePanel = null;
				imagePanel = new PicPanel();
	
				container.add(imagePanel);
				container.add(toolsPanel);
				setVisible(true);
			
				setTitle("BIE-EVER ----------- " + fileName);
			}
			
			
			
			//user wants to save changes
			else if(ae.getActionCommand().equals("Save"))
			{
				saveFile(currentFile);
			}
			
			else if(ae.getActionCommand().equals("Rotate 90 degrees"))
			{
				GlobalModifier change = new Rotator();
				imagePanel.image = ImageHelper.toBufferedImage(change.modify(ImageHelper.fromBufferedImage(imagePanel.image), 1));
				
			}
		}
		
		public static void main(String[] args)
		{
			new View();
		}
}
