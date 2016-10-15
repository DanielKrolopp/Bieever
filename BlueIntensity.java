/**
 *
 * @author Kevin
 */
public class BlueIntensity extends Intensity {
    @Override
    protected int modifyPixel(int pixel, float factor) {
        int pixelValue;
        int[] pixelData = ImageProcessor.toByteData(pixel);
        
        int value = (int) (pixelData[1] * factor);
        pixelData[3] = (byte) (value > 255 ? 255 : value);
        
        pixelValue = ImageProcessor.fromByteData(pixelData);
        
        return pixelValue;
    }
}
