/**
 *
 * @author Kevin
 * 
 * The name is terrible. It does not process images.
 * Contains lots of helpful methods.
 */
public class ImageHelper {
    
    /**
    * 
    * @param value integer containing pixel value
    * @return a 4 integer array containing the alpha, red, green, blue channels in that order
    **/
    public static int[] toByteData(int value) {
        return new int[]{
            ((value & 0xFF000000) >> 24), 
            ((value & 0x00FF0000) >> 16), 
            ((value & 0x0000FF00) >> 8), 
            (value & 0x000000FF)};
    }
    /**
    * @param bit the array containing individual color channels
    * @return integer containing pixel value
    */
    public static int fromByteData(int[] bit) {
        return (bit[0]<<24) | (bit[1]<<16) | (bit[2]<<8) | (bit[3]);
    }
    
    /**
    * absolutely useless right now
    */
    public static int changeChannel(int channel, int alpha, int beta) {
        int value = alpha * (channel - 128) + 128 + beta;
        if (value < 0) value = 0;
        else if (value > 255) value = 255;
        return value;
    }
    
    /**
    * 
    * @param value
    * @return an integer clamped between [0, 255]
    * clamps a double to an integer value [0, 255] rounded.
    */
    public static int clamp(double value) {
        value += 0.5;
        if (value < 0) return 0;
        if (value > 255) return 255;
        return (int) (value);
    }
    
    /**
    * 
    * @param img image to be converted to 2 dimension array of pixels
    * @return array[height of image][width of image]
    */
    public static int[][] to2DArray(Image img) {
        int[][] arr2D = new int[img.getHeight()][img.getWidth()];
        for (int y = 0; y < img.height; y++) {
            for (int x = 0; x < img.width; x++) {
                arr2D[y][x] = img.pixels[y * img.width + x];
            }
        }
        return arr2D;
    }
    
    /**
    * 
    * @param arr2D 2 dimension array of pixel values
    * @return 1 dimension array of pixel values starting from top left corner of image reading left to right, then top to bottom
    */
    public static int[] from2DArray(int[][] arr2D) {
        int[] arr1D = new int[arr2D.length * arr2D[0].length];
        for (int y = 0; y < arr2D.length; y++) {
            for (int x = 0; x < arr2D[0].length; x++) {
                arr1D[y * arr2D[0].length + x] = arr2D[y][x];
            }
        }
        return arr1D;
    }
}
