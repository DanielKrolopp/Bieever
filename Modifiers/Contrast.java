/**
 *
 * @author Kevin
 */
public class Contrast extends GlobalModifier {

    @Override
    protected int modifyPixel(int pixel, float factor) {
        int value = (int) (factor * (pixel - 128) + 128);
        return ImageHelper.clamp(value);
    }
    
}
