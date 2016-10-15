/**
 *
 * @author Kevin
 */
public class Intensity extends GlobalModifier {
    @Override
    protected int modifyPixel(int pixel, float factor) {
        int pixelValue;
        byte[] pixelData = ImageProcessor.toByteData(pixel);
        for (int b = 1; b < pixelData.length; b++) {
            int value = (int) (pixelData[b] * factor);
            pixelData[b] = (byte) (value > Byte.MAX_VALUE ? Byte.MAX_VALUE : value);
        }
        pixelValue = ImageProcessor.fromByteData(pixelData);
        return pixelValue;
    }
}
