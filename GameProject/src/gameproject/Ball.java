
package gameproject;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * The ball class creates a circle shape which is a fixture with a red image overlaying it
 * The class also adds sounds when the ball is destroyed
 */

public class Ball extends DynamicBody
{
    private static SoundClip destroySound;
//    private static SoundClip pickupSound;
    
    static {
        try 
        {
           destroySound = new SoundClip("data/SFX_Pickup_04.wav");
           System.out.println("Loading destroy Sound");
        } 
        catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) 
         {
           System.out.println(e);
         }       
    }
    
//    static {
//        try {
//           pickupSound = new SoundClip("data/SFX_Pickup_03.wav");
//           System.out.println("Loading pickup Sound");
//         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
//           System.out.println(e);
//         }       
//    }
    
   public Ball(World world) 
    {
        super(world);
        Shape ball = new CircleShape(0.5f);
        SolidFixture fixture = new SolidFixture(this, ball);  
        addImage (new BodyImage("data/RedBall.png", 1.2f));
        fixture.setDensity(0);
        fixture.setFriction(0.01f);
        fixture.setRestitution(0.5f);
        this.setGravityScale(1f);
    }
   
    @Override
    public void destroy()
    {
        destroySound.play();
        super.destroy();
    }
    
//    @Override
//    public void setPosition()
//    {
//        pickupSound.play();
//        super.;
//    }

}
        
        
        