

package gameproject;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 * The Stopper class is the player, the class just makes a boxshape that is big enough to stop the balls
 */

public class Stopper extends Walker 
{
    private static final Shape shape = new BoxShape(1.75f, 0.125f);
    
    public Stopper(World world) 
    {
        super(world, shape);
        setFillColor(Color.red);
    }
   
}
