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
    protected int modifyPixel(int pixel, float factor) {
        int[] argb = ImageHelper.toByteData(pixel);
        for (int i = 1; i < argb.length; i++) {
            argb[i] = (int) (argb[i] + factor + 0.5);
        }
        int value = ImageHelper.fromByteData(argb);
        return ImageHelper.clamp(value);
    }
    
}
