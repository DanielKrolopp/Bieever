/**
 *
 * @author Kevin
 */
public class Contrast extends GlobalModifier {

    @Override
    protected int modifyPixel(int pixel, float factor) {
        int value = (int) (factor * (pixel - 128) + 128);
        if (value < 0) value = 0;
        else if (value > 255) value = 255;
        return value;
    }
    
}
