package music;

//This is a Concrete Music Player
public class VLCPlayer{
	
	//creating new PluginAdater
	private PluginAdapter adapter; 
	private boolean playState = false;
	
	//play method
	public void play(AudioFile audio) throws UnSupportedAudioFormatException{		

			this.adapter.play(audio);
			this.playState = true;
	}  
	
	
	public boolean getPlayState(){
		return playState;
	}
	
	public void stop(){
		this.playState =false;
	}
	
	//setter for the above PluginAdapter, called in main
	public void setPluginAdapter(PluginAdapter p) {
		this.adapter = p;
	}
}