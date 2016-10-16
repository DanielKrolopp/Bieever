import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ImageCrop implements MouseListener{
	
	private int radius, x1, x2, y1, y2;
	private ImageK image;
	private boolean clicked = false;
	
	public ImageCrop(ImageK image, int radius){
		this.radius = radius;
		this.image = image;
		clicked = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(!clicked){
			x1 = e.getX();
			y1 = e.getY();
			clicked = true;
		}
		else{
			x2 = e.getX();
			x2 = e.getY();
			clicked = false;
			crop(image, x1, y1, x2, y2);
		}
	}

	/**
	 * Crops the implicit parameter to within the boundaries
	 * specified in the method's arguments. This is inclusive
	 * of the lower value and exclusive of the higher one
	 * [Low value, High value) for X and Y coordinates.
	 *
	 * @param		x1  x-coordinate of an opposing corner
	 * @param		x2  x-coordinate of an opposing corner
	 * @param		y1  y-coordinate of an opposing corner
	 * @param		y2  y-coordinate of an opposing corner
	 * 
	 * @see         ImageK
	 */
   public void crop(ImageK image, int x1, int y1, int x2, int y2){
	   int greaterX, lesserX, greaterY, lesserY;
	   int[][] img2D = ImageHelper.to2DArray(image);
	   if(x1 > x2){
		   greaterX = x1;
		   lesserX = x2;
	   }
	   else{
		   greaterX = x2;
		   lesserX = x1;
	   }
	   if(y1 > y2){
		   greaterY = y1;
		   lesserY = y2;
	   }
	   else{
		   greaterY = y2;
		   lesserY = y1;
	   }
	   int[] croppedPixels = new int[(greaterX-lesserX)*(greaterY-lesserY)];
	   int i = 0;
	   for(int r = 0; r < img2D.length; r++){
		   for(int c = 0; c < img2D[0].length; c++){
			   if(c < greaterX && c >= lesserX && r < greaterY && r >= lesserY){//Optimize this
				   croppedPixels[i] = (img2D[r][c]);
				   i++;
			   }
		   }
	   }
	   image.width = greaterX - lesserX;
	   image.height = greaterY - lesserY;
	   //Image output = new Image(greaterX - lesserX, greaterY - lesserY);
	   image.setPixels(croppedPixels);
   }

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
