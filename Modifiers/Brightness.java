/**
 *
 * @author Kevin
 */
public class Brightness extends GlobalModifier {

    @Override
    protected int modifyPixel(int pixel, float factor) {
        int value = (int) (pixel + factor);
        return ImageHelper.clamp(value);
    }
    
}
