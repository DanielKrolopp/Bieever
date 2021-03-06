/**
 *
 * @author Kevin
 */
public class GaussianBlur extends GlobalModifier {

    
    /**
     * 
     * @param img image to be modified
     * @param stdDev higher values of this makes image more blurry/smooth
     * @return modified Image object
     */
    @Override
    public ImageK modify(ImageK img, int stdDev) {
        if (stdDev <= 0) return img;
        
        stdDev += 100;
        stdDev /= 20;
        ImageK newImg = new ImageK();
        newImg.width = img.width;
        newImg.height = img.height;
        
        double[] convMatrix = this.generateMatrix(6.0 * stdDev);
        int origin = convMatrix.length / 2;
        
        int[] newPixels = new int[img.pixels.length];
        
        for (int p = 0; p < img.pixels.length; p++) {
            int x = p % img.width, y = p / img.width;
            double rSum = 0, gSum = 0, bSum = 0; 
            for (int i = 0; i < convMatrix.length; i++) {
                int deltaX = i - origin;
                if (x + deltaX < 0 || x + deltaX >= img.width) {
                } else {
                    int[] channels = ImageHelper.toByteData(img.pixels[img.width * y + x + deltaX]);
                    rSum += channels[1] * convMatrix[i];
                    gSum += channels[2] * convMatrix[i];
                    bSum += channels[3] * convMatrix[i];
                    
                }
            }
            int[] newChannels = ImageHelper.toByteData(img.pixels[p]);
            newChannels[1] = ImageHelper.clamp(rSum);
            newChannels[2] = ImageHelper.clamp(gSum);
            newChannels[3] = ImageHelper.clamp(bSum);
            newPixels[p] = ImageHelper.fromByteData(newChannels);
        }
        
        int[] tempPixels = new int[img.pixels.length];
        System.arraycopy(newPixels, 0, tempPixels, 0, tempPixels.length);
        
        for (int p = 0; p < img.pixels.length; p++) {
            int x = p % img.width, y = p / img.width;
            double rSum = 0, gSum = 0, bSum = 0; 
            for (int i = 0; i < convMatrix.length; i++) {
                int deltaY = i - origin;
                
                if (x + deltaY < 0 || x + deltaY >= img.height) {
                } else {
                    int[] channels = ImageHelper.toByteData(tempPixels[(y + deltaY) * img.width + x]);
                    rSum += channels[1] * convMatrix[i];
                    gSum += channels[2] * convMatrix[i];
                    bSum += channels[3] * convMatrix[i];
                    
                }
            }
            int[] newChannels = ImageHelper.toByteData(img.pixels[p]);
            newChannels[1] = ImageHelper.clamp(rSum);
            newChannels[2] = ImageHelper.clamp(gSum);
            newChannels[3] = ImageHelper.clamp(bSum);
            newPixels[p] = ImageHelper.fromByteData(newChannels);
        }
        
        
        newImg.pixels = newPixels;
        
        return newImg;
    }
    
    public double[] generateMatrix(double radius) {
        int numElements = (int) (radius * 2 + 0.5) + 1;
        double[] convMatrix = new double[numElements];
        int origin = numElements / 2;
        for (int i = 0; i < convMatrix.length; i++) {
            double g = Math.pow(Math.E, - (((i - origin) * (i - origin))/ (2 * radius * radius))) 
                    / Math.sqrt(2 * Math.PI * radius * radius);
            convMatrix[i] = g;
        }
        
        return convMatrix;
    }
    
    @Override
    protected int modifyPixel(int pixel, int factor) {
        System.out.println("Bug in GaussianBlur function tee hee :P");
        return 0;
    }
    
}
