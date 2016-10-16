/**
 *
 * @author Kevin
 */
public class RedIntensity extends Intensity {
    @Override
    protected int modifyPixel(int pixel, int factor) {
        double multiplier = Math.pow(Math.E, factor);
        int pixelValue;
        int[] pixelData = ImageHelper.toByteData(pixel);
        
        int value = (int) (pixelData[1] * multiplier);
        pixelData[1] = ImageHelper.clamp(value);
        
        pixelValue = ImageHelper.fromByteData(pixelData);
        
        return pixelValue;
    }
}
