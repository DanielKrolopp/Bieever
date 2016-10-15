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
		
		public View()
		{
			//----------makes the default image--------------------------
			fileName = "Beaver.jpg";
			currentFile = new File(fileName);
			
			setTitle("BIE-EVER ----------- " + fileName);
			setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
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
			
			
			//-----------adds to the JFrame---------------------
			add(imagePanel);
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
				try {
					
					ImageIO.write(imagePanel.image, "JPG", new File(fileName));
				
				} catch (IOException e) {
					System.out.println("Unable to save, sucks.");
					System.exit(0);
				}
			}
		}
		
		public static void main(String[] args)
		{
			new View();
		}
}
