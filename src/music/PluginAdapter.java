/*
 * Oliver Faherty
 * ID: 16102532
 */ 
package music;

import java.util.HashMap; //importing hashmap


public class PluginAdapter implements Plugin {

	private Plugin player;
	
	//creating HashMap called map to take a string an a plugin
	HashMap<String, Plugin> map = new HashMap<String, Plugin>();
	
	//method to add key and calue to Hashmap
	public void register (String audioType, Plugin player){
		
		//using put operation to add passed values to Hashmap
		map.put(audioType, player);
		
		//simple if statement to show that the key has been added
		if (map.containsKey(audioType)) {
			System.out.println("registered successfully");
		}
	}
	
	@Override
	public void play(AudioFile audio) throws UnSupportedAudioFormatException {
		
		// Logic: 1 check that the hashmap contains the audiofiletype as a key
		// if true - run the play method
		// else throw unsupported exception.
		
		//if statement to check if the Hashmap contains the necessary key
		if (map.containsKey(audio.getAudioType())) {
			
			//if it does then we create a new plugin type by using map.get and calling the corresponding plugin to the key
			//and set it equal to this.player
			this.player = map.get(audio.getAudioType());
			
			//calling the play method of the appropriate plugin
			this.player.play(audio);
		}
		
		//else method to through exception if unsupported format passed
		else {
			throw new UnSupportedAudioFormatException("unsupported format: "
					+ audio.getAudioType());
				
		}		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Override
	public void play(AudioFile audio) throws UnSupportedAudioFormatException {
		
		switch (audio.getAudioType()) {
		case "ogg":
			this.player = new OGGPlugin();
			break;
		case "wma":
			this.player = new WMAPlugin();
			break;
		case "mp3":
			this.player = new MP3Plugin();
			break;
		default: 
			throw new UnSupportedAudioFormatException("unsupported format: "
			+ audio.getAudioType());
		}
		
		this.player.play(audio);
	}*/
		
}
