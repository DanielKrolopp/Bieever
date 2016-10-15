/**
 *
 * @author Kevin
 */
public class Brightness extends GlobalModifier {

    @Override
    protected int modifyPixel(int pixel, float factor) {
        int value = (int) (pixel + factor);
        if (value < 0) value = 0;
        else if (value > 255) value = 255;
        return value;
    }
    
}
