/**
 *
 * @author Kevin
 */
public class GreenIntensity extends Intensity {
    @Override
    protected int modifyPixel(int pixel, int factor) {
        double multiplier = Math.pow(Math.E, factor);
        int pixelValue;
        int[] pixelData = ImageHelper.toByteData(pixel);
        
        int value = (int) (pixelData[2] * multiplier);
        pixelData[2] = (byte) (value > 255 ? 255 : value);
        
        pixelValue = ImageHelper.fromByteData(pixelData);
        
        return pixelValue;
    }
}

