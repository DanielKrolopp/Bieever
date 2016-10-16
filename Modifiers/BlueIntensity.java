/**
 *
 * @author Kevin
 */
public class BlueIntensity extends Intensity {
    @Override
    protected int modifyPixel(int pixel, float factor) {
        int pixelValue;
        int[] pixelData = ImageHelper.toByteData(pixel);
        
        int value = (int) (pixelData[3] * factor);
        pixelData[3] = ImageHelper.clamp(value);
        
        pixelValue = ImageHelper.fromByteData(pixelData);
        
        return pixelValue;
    }
}
