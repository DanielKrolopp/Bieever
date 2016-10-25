import java.awt.BorderLayout;
import java.awt.Color;
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
	private int cropButtonHit = 0;
	private ImageCrop cropTool = null;
	private int brushButtonHit = 0;
	private Paintbrush brush = null;

	public View()
	{
		//----------makes the default image--------------------------
		fileName = "Beaver.jpg";
		currentFile = new File(fileName);
		int screenWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int screenHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();

		setTitle("BIEEVER ----------- " + fileName);
		setSize(screenWidth, screenHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		imagePanel = new PicPanel();
		imagePanel.setLayout(null);
		imagePanel.setBounds(0, 0, (int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3) * 2), screenHeight);
		imagePanel.setBackground(Color.PINK);

		ImageModifications.INSTANCE.setBaseImage(ImageHelper.fromBufferedImage(imagePanel.image));

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
		toolsPanel.setBounds((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3) * 2), 0, screenWidth/3, screenHeight);
		toolsPanel.setLayout(null);
		toolsPanel.setBackground(Color.YELLOW);

		int vertAlignment = 50;
		int horizAlignment = toolsPanel.getWidth()/4;			

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

		JButton savePresetButton = new JButton("Save Preset");
		savePresetButton.setBounds(horizAlignment, screenHeight-300, 140, 30);
		savePresetButton.addActionListener(this);

		toolsPanel.add(uploadPre);
		toolsPanel.add(cropButton);
		toolsPanel.add(rotateButton);
		toolsPanel.add(paintBrushButton);
		toolsPanel.add(savePresetButton);

		sliders = new ArrayList<JSlider>();

		String[] sliderNames = {"Red", "Green", "Blue", "Brightness", "Contrast", "Sharpness", "Blur"};

		for(int i = 0; i < 7; i++)
		{
			JSlider toAdd = new JSlider(-100, 100, 0); 
			toAdd.setBounds(horizAlignment, vertAlignment, 200, 50);
			toAdd.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent ce) {


					JSlider toCheck = (JSlider)ce.getSource();

					if(!toCheck.getValueIsAdjusting())
					{
						//if red slider is changing
						if(toCheck.equals(sliders.get(0)))
						{
							ImageModifications.INSTANCE.addModification(Modifier.RED_INTENSITY.toString(), toCheck.getValue());
							ImageK modifiedImage = ImageModifications.INSTANCE.modifiedImage();
							imagePanel.image = ImageHelper.toBufferedImage(modifiedImage);
						}

						//if green slider is changing
						else if(toCheck.equals(sliders.get(1)))
						{
							ImageModifications.INSTANCE.addModification(Modifier.GREEN_INTENSITY.toString(), toCheck.getValue());
							ImageK modifiedImage = ImageModifications.INSTANCE.modifiedImage();
							imagePanel.image = ImageHelper.toBufferedImage(modifiedImage);
						}

						//if blue slider is changing
						else if(toCheck.equals(sliders.get(2)))
						{
							ImageModifications.INSTANCE.addModification(Modifier.BLUE_INTENSITY.toString(), toCheck.getValue());
							ImageK modifiedImage = ImageModifications.INSTANCE.modifiedImage();
							imagePanel.image = ImageHelper.toBufferedImage(modifiedImage);
						}

						//if brightness slider is changing
						else if(toCheck.equals(sliders.get(3)))
						{
							ImageModifications.INSTANCE.addModification(Modifier.BRIGHTNESS.toString(), toCheck.getValue());
							ImageK modifiedImage = ImageModifications.INSTANCE.modifiedImage();
							imagePanel.image = ImageHelper.toBufferedImage(modifiedImage);
						}

						//if contrast slider is changing
						else if(toCheck.equals(sliders.get(4)))
						{
							ImageModifications.INSTANCE.addModification(Modifier.CONTRAST.toString(), toCheck.getValue());
							ImageK modifiedImage = ImageModifications.INSTANCE.modifiedImage();
							imagePanel.image = ImageHelper.toBufferedImage(modifiedImage);
						}

						//if sharpness slider is changing
						else if(toCheck.equals(sliders.get(5)))
						{
							ImageModifications.INSTANCE.addModification(Modifier.SHARPEN.toString(), toCheck.getValue());
							ImageK modifiedImage = ImageModifications.INSTANCE.modifiedImage();
							imagePanel.image = ImageHelper.toBufferedImage(modifiedImage);
						}

						//if blur slider is changing
						else if(toCheck.equals(sliders.get(6)))
						{
							ImageModifications.INSTANCE.addModification(Modifier.BLUR.toString(), toCheck.getValue());
							ImageK modifiedImage = ImageModifications.INSTANCE.modifiedImage();
							imagePanel.image = ImageHelper.toBufferedImage(modifiedImage);
						}
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
		add(imagePanel);
		add(toolsPanel);

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
				int boxWidth = (int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3) * 2);
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

			remove(imagePanel);
			imagePanel = null;
			imagePanel = new PicPanel();
			imagePanel.setBounds(0, 0, (int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3) * 2), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
			add(imagePanel);

			ImageModifications.INSTANCE.setBaseImage(ImageHelper.fromBufferedImage(imagePanel.image));
			setVisible(true);
			repaint();

			setTitle("BIEEVER ----------- " + fileName);
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

		else if(ae.getActionCommand().equals("Crop"))
		{

			if(cropButtonHit == 0)
			{
				System.out.println("Reached");
				cropTool = new ImageCrop(ImageHelper.fromBufferedImage(imagePanel.image));
				imagePanel.addMouseListener(cropTool);
				cropButtonHit = 1;
			}


			if(cropTool.getClicked() == 2)
			{
				System.out.println("got");
				System.out.println(cropTool.getX1() + " " + cropTool.getY1() + "," + cropTool.getX2() + " " + cropTool.getY2());

				cropTool.crop(ImageHelper.fromBufferedImage(imagePanel.image));
				System.out.println(cropTool.getX1() + " " + cropTool.getY1() + "," + cropTool.getX2() + " " + cropTool.getY2());
				imagePanel.image = ImageHelper.toBufferedImage(cropTool.getImage());		
				repaint();
				imagePanel.removeMouseListener(imagePanel.getMouseListeners()[0]);
				repaint();
				cropButtonHit = 0;
			}

			/*
			cropTool = new ImageCrop(ImageHelper.fromBufferedImage(imagePanel.image));
			imagePanel.addMouseListener(cropTool);

			while(cropTool.getClicked() != 2)
			{
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}


			cropTool.crop(ImageHelper.fromBufferedImage(imagePanel.image));
			//System.out.println(cropTool.getX1() + " " + cropTool.getY1() + "," + cropTool.getX2() + " " + cropTool.getY2());
			imagePanel.image = ImageHelper.toBufferedImage(cropTool.getImage());
			imagePanel.removeMouseListener(imagePanel.getMouseListeners()[0]);
			 */
		}

		else if(ae.getActionCommand().equals("Upload Preset"))
		{
			File preFile = null;
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showOpenDialog(null);

			if(result == JFileChooser.APPROVE_OPTION)
			{
				preFile = fileChooser.getSelectedFile();
			}

			Preset preObject = new Preset(preFile.getName());
			preObject.load(preFile.getName());

			String[] sliderNames = {"Red", "Green", "Blue", "Brightness", "Contrast", "Sharpness", "Blur"};

			sliders.get(0).setValue(preObject.getRedIntensity());
			sliders.get(1).setValue(preObject.getGreenIntensity());
			sliders.get(2).setValue(preObject.getBlueIntensity());
			sliders.get(3).setValue(preObject.getBrightness());
			sliders.get(4).setValue(preObject.getContrast());
			sliders.get(5).setValue(preObject.getSharpen());
			sliders.get(6).setValue(preObject.getBlur());
		}

		else if(ae.getActionCommand().equals("Save Preset"))
		{
			Preset preObject = new Preset(sliders.get(0).getValue(), sliders.get(1).getValue(), sliders.get(2).getValue(), sliders.get(3).getValue(), sliders.get(4).getValue(), sliders.get(5).getValue(), sliders.get(6).getValue());
			String toSave = JOptionPane.showInputDialog("Enter the name of the file to save to");
			preObject.save(toSave);
		}

		else if(ae.getActionCommand().equals("PaintBrush"))
		{
			if(brushButtonHit == 0)
			{
				int radi = Integer.parseInt(JOptionPane.showInputDialog("Enter radius of brush"));
				brush = new Paintbrush(ImageHelper.fromBufferedImage(imagePanel.image), radi);
				imagePanel.addMouseListener(brush);
				brushButtonHit = 1;
				System.out.println("Hit");
			}
			
			else if(brushButtonHit == 1)
			{
				imagePanel.removeMouseListener(imagePanel.getMouseListeners()[0]);
				brushButtonHit = 0;
				System.out.println("Unhit");
			}

		}
	}

	public static void main(String[] args)
	{
		new View();
	}
}
