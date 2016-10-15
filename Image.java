package io.github.dkrolls.Bieever;

/**
*
* @author Kevin
*/
public class Image {
   public Image(){}
   public Image(int h, int w) {
       this.height = h;
       this.width = w;
   }
   /**
	 * Returns an instance of Kevin's Image object with pixels
	 * corresponding to the desired crop. 
	 *
	 * @param		x1  x-coordinate of an opposing corner
	 * @param		x2  x-coordinate of an opposing corner
	 * @param		y1  y-coordinate of an opposing corner
	 * @param		y2  y-coordinate of an opposing corner
	 * @param		img instance of Kevin's Image to be cropped
	 * 
	 * @return      Image
	 * @see         Image
	 */
   public Image crop(Image img, int x1, int y1, int x2, int y2){
	   int greaterX, lesserX, greaterY, lesserY;
	   int[][] img2D = ImageHelper.to2DArray(img);
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
			   if(c < greaterX && c > lesserX && r < greaterY && r > lesserY){
				   croppedPixels[i] = (img2D[r][c]);
				   i++;
			   }
		   }
	   }
	   Image output = new Image(greaterX - lesserX, greaterY - lesserY);
	   output.setPixels(croppedPixels);
	   return img;
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
   
   public int height, width;
   public int[] pixels;
}
