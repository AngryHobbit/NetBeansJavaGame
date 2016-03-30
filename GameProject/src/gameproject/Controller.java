
package gameproject;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * The controller class allows you to move the player to release the balls
 * The class also looks at what level you are on for the return possession of the player
 */


public class Controller extends KeyAdapter
{
    
    private Walker body;
    private GameLevel world;
    
        public Controller(Walker body, GameLevel world)
        {
        this.body = body;
        this.world = world;
        }
        public void setBody(Walker w)
        {
            this.body = w;
        }
        public void setWorld(GameLevel world)
        {
            this.world = world;
        }
        
    @Override
    public void keyPressed(KeyEvent e)//creates key presses
    {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_SPACE) // press space
        {   
            body.jump(1f);
            body.setPosition(new Vec2(200,200));
        }  
    } 
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_SPACE) 
        {
            body.setPosition(world.startPosition());
        }
    }
}
