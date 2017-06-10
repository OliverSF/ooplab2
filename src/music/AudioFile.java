package music;

public class AudioFile {
	
	//creating variables
	private String audioType; 
	private String fileName;
	
	//constructor
	public AudioFile (String audioType, String fileName){
		this.audioType = audioType;
		this.fileName = fileName;
	}
	
	//getter for fileName
	public String getFileName() {
		return fileName;
	}
	
	//setter for audioType
	public String getAudioType() {
		return audioType;
	}
}
