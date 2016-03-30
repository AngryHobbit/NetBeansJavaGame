package gameproject;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * The ballh class creates a circle shape which is a fixture with a purple image overlaying it
 * The class also adds sounds when the ball is destroyed
 */

public class BallH extends DynamicBody
{
        private static SoundClip destroySound;
    
    static {
        try {
           destroySound = new SoundClip("data/SFX_Pickup_04.wav");
           System.out.println("Loading destroy Sound");
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }       
    }
   public BallH(World world) 
    {
        super(world);
        Shape ball = new CircleShape(0.6f);
        SolidFixture fixture = new SolidFixture(this, ball);  
        addImage (new BodyImage("data/PurpleOrb.png", 1.2f));
        //fixture.setDensity(15);
        fixture.setFriction(0.01f);

    }
       @Override
    public void destroy()
    {
        destroySound.play();
        super.destroy();
    }
}
        
        
        