import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Paintbrush implements MouseListener{
	
	private int x, y, radius;
	private ImageK image;
	
	public Paintbrush(ImageK image, int radius){
		this.radius = radius;
		this.image = image;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
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
		x = e.getX();
		y = e.getY();
		int[][] image2D = ImageHelper.to2DArray(image);
		for(int r = x - (radius/2); r < x + (radius/2); r++){
			for(int c = y - (radius/2); c < y + radius/2; c++){
				image2D[r][c] = 0;
			}
		}
		image.setPixels(ImageHelper.from2DArray(image2D));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
