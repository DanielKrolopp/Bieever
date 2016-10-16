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
        
        ImageK newImg = new ImageK();
        newImg.width = img.width;
        newImg.height = img.height;
        
        int matrixSize = (int) (6 * stdDev + 0.5f);
        double[] convMatrix = new double[matrixSize];
        int origin = (int) (stdDev + 0.5f);
        for (int i = 0; i < matrixSize; i++) {
            double g = Math.pow(Math.E, - (((i - origin) * (i - origin))/ (2 * stdDev * stdDev))) 
                    / Math.sqrt(2 * Math.PI * stdDev * stdDev);
            convMatrix[i] = g;
        }
        
        int[] newPixels = new int[img.pixels.length];
        
        for (int p = 0; p < img.pixels.length; p++) {
            int x = p % img.width, y = p / img.width;
            double rSum = 0, gSum = 0, bSum = 0; 
            for (int i = 0; i < matrixSize; i++) {
                int[] channels = ImageHelper.toByteData(img.pixels[img.width * y + i]);
                int deltaX = i - origin;
                if (x + deltaX < 0 || x + deltaX >= img.width) {
                } else {
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
        for (int p = 0; p < img.pixels.length; p++) {
            int x = p % img.width, y = p / img.width;
            double rSum = 0, gSum = 0, bSum = 0; 
            for (int i = 0; i < matrixSize; i++) {
                int[] channels = ImageHelper.toByteData(img.pixels[i * img.width + x]);
                int deltaY = i - origin;
                if (x + deltaY < 0 || x + deltaY >= img.height) {
                } else {
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
    
    @Override
    protected int modifyPixel(int pixel, int factor) {
        System.out.println("Bug in GaussianBlur function tee hee :P");
        return 0;
    }
    
}
