/**
 *
 * @author Kevin
 */
public abstract class GlobalModifier {
    public ImageK modify(ImageK img, int factor) {
        ImageK newImg = new ImageK();
        newImg.width = img.width;
        newImg.height = img.height;
        newImg.pixels = new int[img.pixels.length];
        for (int i = 0; i < img.pixels.length; i++) {
            newImg.pixels[i] = modifyPixel(img.pixels[i], factor);
        }
        return newImg;
    }
    
    protected abstract int modifyPixel(int pixel, int factor);
}
