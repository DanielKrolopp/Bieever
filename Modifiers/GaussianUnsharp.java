/**
 *
 * @author Kevin
 */
public class GaussianUnsharp extends GlobalModifier {
    
    @Override
    public ImageK modify(ImageK img, int factor) {
        if (factor <= 0) return img;
        
        ImageK newImg = new ImageK();
        newImg.width = img.width;
        newImg.height = img.height;
        
        GaussianBlur blurFilter = new GaussianBlur();
        ImageK blurNegative = blurFilter.modify(img, factor);
        
        int[] newPixels = new int[img.pixels.length];
        
        for (int i = 0; i < img.pixels.length; i++) {
            int[] channels = ImageHelper.toByteData(img.pixels[i]);
            int[] channelNegs = ImageHelper.toByteData(blurNegative.pixels[i]);
            int[] newChannels = new int[4];
            newChannels[0] = 2 * channels[0] - channelNegs[0];
            newChannels[1] = 2 * channels[1] - channelNegs[1];
            newChannels[2] = 2 * channels[2] - channelNegs[2];
            newChannels[3] = 2 * channels[3] - channelNegs[3];
            
            newPixels[i] = ImageHelper.fromByteData(newChannels);
        }
        
        newImg.pixels = newPixels;
        return newImg;
    }
    
    @Override
    protected int modifyPixel(int pixel, int factor) {
        System.out.println("GaussianUnsharp IS BUGGED HAHAHAHAHAHA #helpful");
        return 0;
    }
    
}
