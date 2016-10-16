/**
 *
 * @author Kevin
 */
public class Saturation extends GlobalModifier {

    /**
     * 
     * @param pixel
     * @param factor [0,1]
     * @return 
     */
    @Override
    protected int modifyPixel(int pixel, int factor) {
        int[] argb = ImageHelper.toByteData(pixel);
        double[] hsv = ImageHelper.toHSV(argb);
        hsv[1] = factor;
        int[] rgb = ImageHelper.toRGB(hsv);
        argb[1] = rgb[0];
        argb[2] = rgb[1];
        argb[3] = rgb[2];
        
        int value = ImageHelper.fromByteData(argb);
        
        return value;
    }
    
}
