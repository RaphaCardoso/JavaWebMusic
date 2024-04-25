package br.com.Musics.sistema.models;


	 
	import java.io.BufferedInputStream;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import javazoom.jl.decoder.JavaLayerException;
	import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;
	 
	public class audio {
	     
	    private File file;
	    private FileInputStream fis;
	    private BufferedInputStream bis;
	    private Player player;
	     
	    // Este método pede o endereço absoluto do arquivo a ser reproduzido
	    public void reproduzir(String url){
	        new Thread() {
	            @Override
	            public void run(){
	                try{                
	                    file = new File(url);
	                    fis = new FileInputStream(file);
	                    bis = new BufferedInputStream(fis);
	                }catch(IOException e){}
	                 
	                try{
	                    player = new Player(bis);
	                    player.play();
	                }catch(JavaLayerException ex){}
	            }
	        }.start(); 
	    }
	     
	    public void parar(){
	        player.close();
	    }
	     
	    /*     
	    public void pausar () {
	    
    		int pausedOnFrame = 0;
	    	try {
			    
			    AdvancedPlayer player = new AdvancedPlayer(fis);
			    
			    player.setPlayBackListener(new PlaybackListener() {
			        @Override
			        public void playbackFinished(PlaybackEvent event) {
			          pausedOnFrame = event.getFrame();
			        }
			    });
	    		
			} catch (Exception e) {
	
				System.out.println("Erro Vacilão 3");
				
			}
	    	
	    	
		   // player.play(pausedOnFrame, Integer.MAX_VALUE);
	    	
	    }  
	    */

	}
	

