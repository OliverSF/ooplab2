package music;

//Plugin interface
public interface Plugin {
	
	//method to be instantiated in subclasses
	public void play(AudioFile audio) throws UnSupportedAudioFormatException;
}
