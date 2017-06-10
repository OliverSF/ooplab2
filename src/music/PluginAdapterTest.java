package music;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PluginAdapterTest {
	
	//declaring variables
	PluginAdapter plugin;
	VLCPlayer player;
	
	@Before
	public void setUp() throws Exception {
		
		//initialising varables
		plugin = new PluginAdapter();
		player = new VLCPlayer();
		//calling setter
		player.setPluginAdapter(plugin);
		
		//calling register method
		plugin.register("ogg", new OGGPlugin());
		plugin.register("mp3", new MP3Plugin());
		
	}
	
	@Test
	public void testregister() {
		
		//testing that the register method adds the keys to the HashMap
		assertTrue(plugin.map.containsKey("ogg"));
		assertTrue(plugin.map.containsKey("mp3"));
	}
	
	@Test
	public void testmp3() {
		//test to check that the MP3 plugin will work within the system
		//setting the expected result
		boolean expectedmp3 = true;
		
		//creating new instance of AudioFile
		AudioFile mp3File = new AudioFile("mp3", "C://Music/Vicissitudes.mp3");
		
		//try catch block to try play method
		try{
			 
			player.play(mp3File);
		
		 }catch(UnSupportedAudioFormatException e){
			 System.out.println(e.getMessage());
		 }
		
		//assigning result to the getPlayState method
		boolean resultmp3 = player.getPlayState();
		
		//asserting that the expected 'true' should equal the result to pass
		assertEquals(expectedmp3, resultmp3);
	}
	
	@Test
	public void testogg() {
		
		//test to check that the OGGPlugin will work within the system
		//setting the expected result
		boolean expectedogg = true;
		
		//creating new instance of AudioFile
		AudioFile oggFile = new AudioFile("ogg", "C://Music/Amator_Silenti.ogg");
		
		//try catch block to try play method
		try{
			 
			player.play(oggFile);
		
		 }catch(UnSupportedAudioFormatException e){
			 System.out.println(e.getMessage());
		 }
		
		//assigning result to the getPlayState method
		boolean resultogg = player.getPlayState();
		
		//asserting that the expected 'true' should equal the result to pass
		assertEquals(expectedogg, resultogg);
	}
	
	@Test
	public void testInvalidFormat() {
		//test to test that system will catch an exception
		//setting the expected result
		boolean expectedformat = false;
		
		//creating new instance of AudioFile with invalid format
		AudioFile oggFile = new AudioFile("xyx", "C://Music/Amator_Silenti.ogg");
		
		//try catch block to try play method
		try{
			 
			player.play(oggFile);
		
		//catch to print out exception message	
		 }catch(UnSupportedAudioFormatException e){
			 System.out.println(e.getMessage());
		 }
		
		//assigning result to the getPlayState method
		boolean resultformat = player.getPlayState();
		
		//asserting that the expected 'false' should equal the result to pass
		assertEquals(expectedformat, resultformat);
	}
	
	@Test
	public void testExceptionMessage() {
		//test to check that the appropriate message is shown when exception is thrown
		//creating string variable
		String format = "xyx";
		
		//setting the expected result
		String expectedexception = "unsupported format: " + format;
		
		//creating new instance of AudioFile with invalid format passed
		AudioFile mp3File = new AudioFile( format , "C://Music/Vicissitudes." + format);
		
		//try catch block to try play method
		try{
			 
			player.play(mp3File);
		
		 }catch(UnSupportedAudioFormatException e){
			 System.out.println(e.getMessage());
			//assigning result to the getPlayState method
			 String resultexception = e.getMessage();
			//asserting that the expected message should equal the result message
			 assertEquals(expectedexception, resultexception); 
		 }
	}
}