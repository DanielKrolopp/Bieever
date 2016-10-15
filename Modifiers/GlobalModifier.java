/**
 *
 * @author Kevin
 */
public abstract class GlobalModifier {
    public Image modify(Image img, float factor) {
        Image newImg = new Image();
        for (int i = 0; i < img.pixels.length; i++) {
            newImg.pixels[i] = modifyPixel(img.pixels[i], factor);
        }
        return newImg;
    }
    
    protected abstract int modifyPixel(int pixel, float factor);
}
