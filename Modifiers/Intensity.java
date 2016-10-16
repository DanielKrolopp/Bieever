/**
 *
 * @author Kevin
 */
public class Intensity extends GlobalModifier {
    @Override
    protected int modifyPixel(int pixel, float factor) {
        double multiplier = Math.pow(Math.E, factor);
        int pixelValue;
        int[] pixelData = ImageHelper.toByteData(pixel);
        for (int b = 1; b < pixelData.length; b++) {
            int value = (int) (pixelData[b] * multiplier);
            pixelData[b] = ImageHelper.clamp(value);
        }
        pixelValue = ImageHelper.fromByteData(pixelData);
        return pixelValue;
    }
}
