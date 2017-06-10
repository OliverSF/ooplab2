package music;

public class WMAPlugin implements Plugin{

	   @Override
	   public void play(AudioFile audio) { //play method for WMAPlugin
	      System.out.println("Playing wma file: "+ audio.getFileName());		
	   }
	}
