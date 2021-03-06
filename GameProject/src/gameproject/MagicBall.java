/*
 * The magicball class creates a circle shape which is a fixture with a image overlaying it
 * The class also adds sounds when the ball is destroyed
 */

package gameproject;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * The magicball class creates a circle shape which is a fixture with a image overlaying it
 * The class also adds sounds when the ball is destroyed
 */
public class MagicBall extends DynamicBody
{
        private static SoundClip destroySound;
    
    static {
        try {
           destroySound = new SoundClip("data/SFX_Pickup_03.wav");
           System.out.println("Loading destroy Sound");
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }       
    }
   public MagicBall(World world) 
    {
        super(world);
        Shape ball = new CircleShape(0.6f);
        Fixture fixture = new SolidFixture(this, ball);  
        addImage (new BodyImage("data/magicBall.gif", 1.2f));
        fixture.setDensity(10);

    }
       @Override
    public void destroy()
    {
        destroySound.play();
        super.destroy();
    }
}
