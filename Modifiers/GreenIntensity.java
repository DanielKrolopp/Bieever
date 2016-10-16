/**
 *
 * @author Kevin
 */
public class GreenIntensity extends Intensity {
    public double damping = 40.0;
    
    @Override
    protected int modifyPixel(int pixel, int factor) {
        double multiplier = Math.pow(Math.E, factor / damping);
        int pixelValue;
        int[] pixelData = ImageHelper.toByteData(pixel);
        
        int value = (int) (pixelData[2] * multiplier);
        pixelData[2] = (byte) (value > 255 ? 255 : value);
        
        pixelValue = ImageHelper.fromByteData(pixelData);
        
        return pixelValue;
    }
}

