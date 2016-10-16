/**
 *
 * @author Kevin
 */
public class Contrast extends GlobalModifier {

    @Override
    protected int modifyPixel(int pixel, int factor) {
        double multiplier = 102 * (factor - 100);
        multiplier /= 100 * (102 - factor);
        int[] argb = ImageHelper.toByteData(pixel);
        for (int i = 1; i < argb.length; i++) {
            argb[i] = (int) (multiplier * (pixel - 128) + 128);
        }
        int value = ImageHelper.fromByteData(argb);
        value = ImageHelper.clamp(value);
        return value;
    } 
    
}
