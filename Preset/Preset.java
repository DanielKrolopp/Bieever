import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Preset {
	private float contrast;
	private float brightness;
	private float saturation;
	private float redIntensity;
	private float greenIntensity;
	private float blueIntensity;
	private float sharpen;
	private float blur;
	
	private String name;
	
	public Preset(String name){
		contrast = 1;
		brightness = 1;
		saturation = 1;
		redIntensity = 1;
		greenIntensity = 1;
		blueIntensity = 1;
		sharpen = 1;
		blur = 1;
		this.name = name;
	}
	public Preset(float contrast, float brightness, float saturation, float redIntensity, float greenIntensity,
			float blueIntensity, float sharpen, float blur){
		this.contrast = contrast;
		this.brightness = brightness;
		this.saturation = saturation;
		this.redIntensity = redIntensity;
		this.greenIntensity = greenIntensity;
		this.blueIntensity = blueIntensity;
		this.sharpen = sharpen;
		this.blur = blur;
	}
	
	public float getContrast() {
		return contrast;
	}
	public void setContrast(float contrast) {
		this.contrast = contrast;
	}
	public float getBrightness() {
		return brightness;
	}
	public void setBrightness(float brightness) {
		this.brightness = brightness;
	}
	public float getSaturation() {
		return saturation;
	}
	public void setSaturation(float saturation) {
		this.saturation = saturation;
	}
	public float getRedIntensity() {
		return redIntensity;
	}
	public void setRedIntensity(float redIntensity) {
		this.redIntensity = redIntensity;
	}
	public float getGreenIntensity() {
		return greenIntensity;
	}
	public void setGreenIntensity(float greenIntensity) {
		this.greenIntensity = greenIntensity;
	}
	public float getBlueIntensity() {
		return blueIntensity;
	}
	public void setBlueIntensity(float blueIntensity) {
		this.blueIntensity = blueIntensity;
	}
	public float getSharpen() {
		return sharpen;
	}
	public void setSharpen(float sharpen) {
		this.sharpen = sharpen;
	}
	public float getBlur() {
		return blur;
	}
	public void setBlur(float blur) {
		this.blur = blur;
	}
	//Write/read
	
	
	/**
	 * Saves a preset as a .pre file that can then be loaded by the
	 * load() method.
	 *
	 * @return      0 if successful, -1 otherwise
	 */
	public int save(){
		List<Float> lines = Arrays.asList(contrast, brightness, saturation, redIntensity, greenIntensity, blueIntensity,
				sharpen, blur);
		String data = "";
		for(int i = 0; i < lines.size(); i++){
			data += lines.get(i);
			if(i < lines.size()-1){
				data += "\n";
			}
		}
		try{
			System.out.println(Preset.class.getProtectionDomain().getCodeSource().getLocation().getPath()+name+".pre");
			File file = new File(Preset.class.getProtectionDomain().getCodeSource().getLocation().getPath()+name+".pre");
			if(!file.exists()){
				file.createNewFile();
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
			writer.write(data);
			writer.close();
			return 0;
		}catch(IOException e){
			e.printStackTrace();
			return -1;
		}
	}
	/**
	 * Loads preset settings from a .pre file. Called on a preset to
	 *  
	 *
	 * @param  preset the name of the preset (not including the extension)
	 * @return        0 if successful, -1 otherwise
	 */
	public int load(String preset){
		File file = new File(Preset.class.getProtectionDomain().getCodeSource().getLocation().getPath()+preset+".pre");
		if(!file.exists()){
			return -1;
		}
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
			try {
				contrast = Float.parseFloat(reader.readLine());
				brightness = Float.parseFloat(reader.readLine());
				saturation = Float.parseFloat(reader.readLine());
				redIntensity = Float.parseFloat(reader.readLine());
				greenIntensity = Float.parseFloat(reader.readLine());
				blueIntensity = Float.parseFloat(reader.readLine());
				sharpen = Float.parseFloat(reader.readLine());
				blur = Float.parseFloat(reader.readLine());
			} catch (NumberFormatException e) {
				e.printStackTrace();
				return -1;
			} catch (IOException e) {
				e.printStackTrace();
				return -1;
			}
		} catch (FileNotFoundException e) {
			return -1;
		}
		
		return 0;
		
	}
}
