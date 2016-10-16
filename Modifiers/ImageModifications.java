import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public enum ImageModifications {
    INSTANCE;
    private class Modification {
        String type;
        int factor;
    }
    
    private ImageModifications(){}
    
    private ImageK baseImage;
    private final ArrayList<Modification> modifications = new ArrayList<>();
    
    public int[] factors;
    
    public static ImageModifications getInstance() {
        return INSTANCE;
    }
    
    public ImageK getBaseImage() { return this.baseImage; }
    public void setBaseImage(ImageK baseImage) { this.baseImage = baseImage; }
    
    public ImageK modifiedImage() {
        
        factors = new int[Modifier.values().length];
        for (int i = 0; i < factors.length; i++)
            factors[i] = 0;
        
        ImageK modified = new ImageK();
        for (int i = 0; i < modifications.size(); i++) {
            int ordinal = Modifier.valueOf(modifications.get(i).type).ordinal();
            factors[ordinal] =
                    modifications.get(i).factor;
        }
        
        modified.pixels = new int[baseImage.pixels.length];
        System.arraycopy(baseImage.pixels, 0, modified.pixels, 0, modified.pixels.length);
        
        for (int i = 0; i < factors.length; i ++) {
            modified = Modifier.values()[i].modifier.modify(modified, factors[i]);
        }
        
        return modified;
    }
    
    public void addModification(String name, int factor) {
        Modification nextMod = new Modification();
        nextMod.type = name;
        nextMod.factor = factor;
        modifications.add(nextMod);
    }
}
