/**
 *
 * @author Kevin
 */
public class GreenIntensity extends Intensity {
    @Override
    protected int modifyPixel(int pixel, float factor) {
        int pixelValue;
        int[] pixelData = ImageHelper.toByteData(pixel);
        
        int value = (int) (pixelData[2] * factor);
        pixelData[2] = (byte) (value > 255 ? 255 : value);
        
        pixelValue = ImageHelper.fromByteData(pixelData);
        
        return pixelValue;
    }
}

