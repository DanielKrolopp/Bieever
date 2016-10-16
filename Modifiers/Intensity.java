/**
 *
 * @author Kevin
 */
public class Intensity extends GlobalModifier {
    @Override
    protected int modifyPixel(int pixel, float factor) {
        int pixelValue;
        int[] pixelData = ImageHelper.toByteData(pixel);
        for (int b = 1; b < pixelData.length; b++) {
            int value = (int) (pixelData[b] * factor);
            pixelData[b] = ImageHelper.clamp(value);
        }
        pixelValue = ImageHelper.fromByteData(pixelData);
        return pixelValue;
    }
}
