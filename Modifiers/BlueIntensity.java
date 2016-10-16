/**
 *
 * @author Kevin
 */
public class BlueIntensity extends Intensity {
    /**
    * 
    * @param pixel value to be changed
    * @param factor value that the pixel's blue channel is multiplied by. factor E [0, 1]
    */
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
