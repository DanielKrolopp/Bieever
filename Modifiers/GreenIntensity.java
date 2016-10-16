/**
 *
 * @author Kevin
 */
public class GreenIntensity extends Intensity {
    @Override
    protected int modifyPixel(int pixel, float factor) {
        int pixelValue;
        byte[] pixelData = ImageHelper.toByteData(pixel);
        
        int value = (int) (pixelData[2] * factor);
        pixelData[2] = ImageHelper.clamp(value);
        
        pixelValue = ImageHelper.fromByteData(pixelData);
        
        return pixelValue;
    }
}
