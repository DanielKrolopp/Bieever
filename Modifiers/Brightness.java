/**
 *
 * @author Kevin
 */
public class Brightness extends GlobalModifier {

    /**
    * 
    * @param pixel value to be modified
    * @param factor value of pixel's linear increase in brightness
    */
    @Override
    protected int modifyPixel(int pixel, int factor) {
        int[] argb = ImageHelper.toByteData(pixel);
        for (int i = 1; i < argb.length; i++) {
            argb[i] = (int) (pixel + 255 * factor / 100);
        }
        int value = ImageHelper.fromByteData(argb);
        value = ImageHelper.clamp(value);
        return value;
    }
    
}
