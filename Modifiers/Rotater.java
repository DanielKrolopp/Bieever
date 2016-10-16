/**
 *
 * @author Kevin
 */
public class Rotater extends GlobalModifier {

    @Override
    public ImageK modify(ImageK img, int factor) {
        if (factor == 0) return img;
        
        ImageK newImg = new ImageK();
        newImg.height = img.width;
        newImg.width = img.height;
        
        int[][] arr2D = new int[img.width][img.height];
        
        for (int y = 0; y < img.height; y++) {
            for (int x = 0; x < img.width; x++) {
                arr2D[x][y] = img.pixels[y * img.width + x];
            }
        }
        return modify(img, factor - 1);
    }
    
    @Override
    protected int modifyPixel(int pixel, int factor) {
        System.out.println("THERE ARE PROBLEMS HERE. Method should not be called. Blah blah blah. Rotater.");
        return -1;
    }
    
}
