package gameproject;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * pickup class is a collision that when it hits the cup the player gains 1 point but when it hits you get the ball back to use again.
 */

public class Pickup implements CollisionListener
{
     private Cup cup;
     private GameLevel level;
    
    public Pickup(Cup cup, GameLevel level) {
        this.cup = cup;
        this.level = level;
        
    }

    @Override
    public void collide(CollisionEvent e) 
    {
       if(e.getOtherBody() == cup)
               {
                   cup.incrementBallCount();
                   if(cup.getPosition().y!=level.cupPosition().y)
                   {
                        cup.setLinearVelocity(new Vec2(cup.getLinearVelocity().x,0));
                        cup.setPosition(new Vec2(cup.getPosition().x,level.cupPosition().y));
                   }
                   
//                   if (level.scoreLimit() == true)
//                   {
//                       level.getGame().nextLevel();
//                   }
                  e.getReportingBody().setPosition(new Vec2(0,15f));
                   
               
                   //e.getReportingBody().destroy();
               }
    }
    
}
