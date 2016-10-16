import java.util.Arrays;

/**
*
* @author Kevin
*/
public class Image {
	public int height, width;
	public int[] pixels;
	
    public Image(){}
    public Image(int h, int w) {
       this.height = h;
       this.width = w;
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
	 * @see         Image
	 */
   public void crop(int x1, int y1, int x2, int y2){
	   int greaterX, lesserX, greaterY, lesserY;
	   int[][] img2D = ImageHelper.to2DArray(this);
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
	   this.width = greaterX - lesserX;
	   this.height = greaterY - lesserY;
	   //Image output = new Image(greaterX - lesserX, greaterY - lesserY);
	   this.setPixels(croppedPixels);
   }
   /**
	 * Rotates the image 90 degrees counterclockwise. To rotate 180
	 * or 270 degrees, just call the method two or three times.
	 * DANG IT THIS IS BROKEN PLEASE FIX IT KEVIN
	 * 
	 * @see		Image
	 */
   public void rotate90(){
	   int[][] beforePixels = ImageHelper.to2DArray(this);
	   int[][] afterPixels = new int[width][height];
	   for(int r = 0; r < width; r++){
		   for(int c = 0; c < height; c++){
			   afterPixels[width-c-1][r] = beforePixels[r][c];
			   System.out.println("r: "+r+"   c: "+c+"   afterPixels: "+Arrays.deepToString(afterPixels));
		   }
	   }
	   
   }
   
   public int getHeight(){
	   return height;
   }
   public void setHeight(int h){
	   height = h;
   }
   public int getWidth(){
	   return width;
   }
   public void setWidth(int w){
	   width = w;
   }
   public int[] getPixels(){
	   return pixels;
   }
   public void setPixels(int[] p){
	   pixels = p;
   }
   
}
