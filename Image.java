/**
 *
 * @author Kevin
 */
public class Image {
    public Image(){}
    public Image(int h, int w) {
        this.height = h;
        this.width = w;
    }
    public int height, width;
    public int[] pixels;
    
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
}
