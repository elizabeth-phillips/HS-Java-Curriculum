import javax.sound.sampled.*;
import java.io.*;
import java.net.*;

public class SoundClip
{
	private AudioInputStream sample;

	private Clip clip;
	public Clip getClip(){return clip;}

	private boolean looping = false;
	public void setLooping(boolean looping){this.looping = looping;}
	public boolean getLooping(){return looping;}

	private int repeat = 0;
	public void setRepeat(int repeat){this.repeat = repeat;}
	public int getRepeat(){return repeat;}

	private String filename = "";
	public void setFilename(String filename){this.filename = filename;}
	public String getFilename(){return filename;}

	public boolean isLoaded(){return (boolean)(sample != null);}

    public SoundClip()
    {
    	try
    	{
    		clip = AudioSystem.getClip();
    	}
    	catch(Exception e)
    	{
    	}
    }

    public SoundClip(String audiofile)
    {
    	this();
    	load(audiofile);
    }

    private URL getURL(String filename)
    {
    	URL url = null;
    	try
    	{
    		url = this.getClass().getResource(filename);
    	}
    	catch(Exception e)
    	{
    	}
    	return url;
    }

    public boolean load(String audiofile)
    {
    	try
    	{
    		setFilename(audiofile);
    		sample = AudioSystem.getAudioInputStream(getURL(filename));
    		clip.open(sample);
    		return true;
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    }

    public void play()
    {
    	if(!isLoaded())
    	{
    		return;
    	}
    	clip.setFramePosition(0);
    	if(looping)
    	{
    		clip.loop(Clip.LOOP_CONTINUOUSLY);
    	}
    	else
    	{
    		clip.loop(repeat);
    	}
    }

    public void stop()
    {
    	clip.stop();
    }
}