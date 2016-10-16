import java.awt.image.BufferedImage;

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
    
    public Image fromBufferedImage(BufferedImage bufferedImage) {
        Image img = new Image(bufferedImage.getHeight(), bufferedImage.getWidth());
        img.setPixels(bufferedImage.getRGB(0, 0, img.width, img.height, null, 0, img.width * img.height));
        return img;
    }
    
    public BufferedImage toBufferedImage(Image img) {
        BufferedImage bImg = new BufferedImage(img.width, img.height, BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < img.height; y++) {
            for (int x = 0; x < img.width; x++) {
                bImg.setRGB(x, y, img.pixels[y * img.width + x]);
            }
        }
        return bImg;
    }
       
    public static int cMaxIndex(int[] argb) {
        int bigIndex = 1;
        for (int i = 1; i < argb.length; i++) {
            if (argb[bigIndex] < argb[i]) {
                bigIndex = i;
            }
        }
        return bigIndex;
    }
    /**
     * 
     * @param argb
     * @return double value of highest RGB value
     */
    public static double cMax(int[] argb) {
        return argb[cMaxIndex(argb)] / 255.0;
    }
    
    public static int cMinIndex(int[] argb) {
        int smallIndex = 1;
        for (int i = 1; i < argb.length; i++) {
            if (argb[smallIndex] > argb[i]) {
                smallIndex = i;
            }
        }
        return smallIndex;
    }
    /**
     * 
     * @param argb
     * @return double value of lowest RGB value E [0, 1]
     */
    public static double cMin(int[] argb) {
        return argb[cMinIndex(argb)] / 255.0;
    }
    
    /**
     * 
     * @param argb
     * @return chroma E [0, 1]
     */
    public static double getChroma(int[] argb) {
        return cMax(argb) - cMin(argb);
    }
    
    /**
     * 
     * @param argb
     * @return hue of RGB values, hue E [0, 360]. if hue == -1, hue is undefined
     */
    public static double getHue(int[] argb) {
        double[] rgb = new double[]{argb[1] / 255.0, argb[2] / 255.0, argb[3] / 255.0};
        double cMaxIndex = cMaxIndex(argb) - 1;
        double chroma = getChroma(argb);
        double hue;
        if (chroma == 0) return 0;
        else if (cMaxIndex == 0) {
            hue = (rgb[1] - rgb[2]) / chroma;
            hue %= 6;
        } else if (cMaxIndex == 1) {
            hue = (rgb[2] - rgb[0]) / chroma + 2;
        } else {
            hue = (rgb[0] - rgb[1]) / chroma + 4;
        }
        return hue * 60;
    }
    
    public static double getSaturation(int[] argb) {
        return getChroma(argb) / (cMax(argb));
    }
    
    /** 
     * 
     * @param argb
     * @return {h E [0, 360], s E [0, 1], v E [0, 1]}
     */
    public static double[] toHSV(int[] argb) {
        double[] hsv = new double[]{getHue(argb), getSaturation(argb), cMax(argb)};
        return hsv;
    }
    
    /**
     * 
     * @param hsv {h E [0, 360], s E [0, 1], v E [0, 1]}
     * @return RGB values from HSV
     */
    public static int[] toRGB(double[] hsv) {
        int[] rgb = new int[3];
        double[] rgbPrime;
        
        double h = hsv[0] / 60;
        double c = hsv[2] * hsv[1];
        double x = c * (1 - Math.abs((h % 2) - 1));
        System.out.println(h + " " + c + " " + x);
        
        if (hsv[0] < 0) {
            rgbPrime = new double[]{0,0,0};
        } else if (h < 1) {
            rgbPrime = new double[]{c, x, 0};
        } else if (h < 2) {
            rgbPrime = new double[]{x, c, 0};
        } else if (h < 3) {
            rgbPrime = new double[]{0, c, x};
        } else if (h < 4) {
            rgbPrime = new double[]{0, x, c};
        } else if (h < 5) {
            rgbPrime = new double[]{x, 0, c};
        } else if (h < 6) {
            rgbPrime = new double[]{c, 0, x};
        } else {
            System.out.println("We have a problem in the ImageHelper :3");
            rgbPrime = null;
        }
        
        rgbPrime[0] += hsv[2] - c;
        rgbPrime[1] += hsv[2] - c;
        rgbPrime[2] += hsv[2] - c;
        
        System.out.println(rgbPrime[0] + " " + rgbPrime[1] + " " + rgbPrime[2]);
        
        rgb[0] = (int) (rgbPrime[0] * 255 + 0.5);
        rgb[1] = (int) (rgbPrime[1] * 255 + 0.5);
        rgb[2] = (int) (rgbPrime[2] * 255 + 0.5);
        
        return rgb;
    }
}
