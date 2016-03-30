
package gameproject;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

/**
 * wall hit class is a collision that when it hits the wall the ball is destroyed 
 */

public class WallHit implements CollisionListener
{
     private Walls wall;
     
     public WallHit(Walls wall) 
     {
        this.wall = wall;
    }
     
    @Override
    public void collide(CollisionEvent e) 
    {
       if(e.getOtherBody() == wall)
               {
                   e.getReportingBody().destroy();
               }
    }
}
