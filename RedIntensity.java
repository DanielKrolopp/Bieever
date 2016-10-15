/**
 *
 * @author Kevin
 */
public class RedIntensity extends Intensity {
    @Override
    protected int modifyPixel(int pixel, float factor) {
        int pixelValue;
        byte[] pixelData = ImageProcessor.toByteData(pixel);
        
        int value = (int) (pixelData[1] * factor);
        pixelData[1] = (byte) (value > Byte.MAX_VALUE ? Byte.MAX_VALUE : value);
        
        pixelValue = ImageProcessor.fromByteData(pixelData);
        
        return pixelValue;
    }
}
