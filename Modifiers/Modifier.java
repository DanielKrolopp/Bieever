/**
 *
 * @author Kevin
 */
public enum Modifier {
    RED_INTENSITY(new RedIntensity()),
    GREEN_INTENSITY(new GreenIntensity()),
    BLUE_INTENSITY(new BlueIntensity()),
    BRIGHTNESS(new Brightness()),
    CONTRAST(new Contrast()),
    //INTENSITY(new Intensity()),
    SHARPEN(new GaussianUnsharp()),
    BLUR(new GaussianBlur());
    //SATURATION(new Saturation()),
    
    public GlobalModifier modifier;
    private Modifier(GlobalModifier modifier) {
        this.modifier = modifier;
    }
}
