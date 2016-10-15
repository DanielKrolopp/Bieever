/**
 *
 * @author Kevin
 */
public class GreenIntensity extends Intensity {
    @Override
    protected int modifyPixel(int pixel, float factor) {
        int pixelValue;
        byte[] pixelData = ImageHelper.toByteData(pixel);
        
        int value = (int) (pixelData[1] * factor);
        pixelData[2] = (byte) (value > Byte.MAX_VALUE ? Byte.MAX_VALUE : value);
        
        pixelValue = ImageHelper.fromByteData(pixelData);
        
        return pixelValue;
    }
}
