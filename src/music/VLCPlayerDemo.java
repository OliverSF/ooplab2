package music;

public class VLCPlayerDemo {

	public static void main(String[] args) throws UnSupportedAudioFormatException {
		
		//creating new instance of PluginAdapter
		PluginAdapter plugin = new PluginAdapter();
		
		//creating new instance of VLCPlayer
		VLCPlayer player;

		player = new VLCPlayer();
		
		player.setPluginAdapter(plugin);
		
		//creating new instance of AudioFile
		AudioFile oggFile = new AudioFile("ogg", "C://Music/Amator_Silenti.ogg");
		
		//calling register method to add values to the Hashmap in PluginAdapter
		//it is noted here that it would also be possible to create a getter method for the keys in the plugin
		//and for this to be calling in the register method rather than passing in "ogg" etc.
		plugin.register("ogg", new OGGPlugin());
		
		//try catch block to call play method and through exception if error happens
		try{
			player.play(oggFile);
		} catch(UnSupportedAudioFormatException e){
			System.out.println(e.getMessage());
		}
		
		//output to console
		System.out.println("player playing: " + player.getPlayState());
		player.stop();
		
		//creating new instance of AudioFile
		AudioFile mp3File = new AudioFile("mp3", "C://Music/Vicissitudes.mp3");
		//calling register method to add values to the Hashmap in PluginAdapter
		plugin.register("mp3", new MP3Plugin());
		try{
		 
			player.play(mp3File);
		
		 }catch(UnSupportedAudioFormatException e){
			 System.out.println(e.getMessage());
		 }
		//try catch block to call play method and through exception if error happens
		System.out.println("player playing: " + player.getPlayState());
		player.stop();
		
		
		//creating new instance of AudioFile
		AudioFile wmaFile = new AudioFile("wma", "C://Music/FooFighters.wma");
		//calling register method to add values to the Hashmap in PluginAdapter
		plugin.register("wma", new WMAPlugin());
		try{
				 
			player.play(wmaFile);
				
		 }catch(UnSupportedAudioFormatException e){
			 System.out.println(e.getMessage());
		 }
		//try catch block to call play method and through exception if error happens
		System.out.println("player playing: " + player.getPlayState());
		player.stop();
	}//End main
}//End Class
