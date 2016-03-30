
package gameproject;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * bombhit class is a collision that when it hits the cup the player looses 5 points as well as if they are over the score limit it will force them to the next level
 */
public class BombHit implements CollisionListener
{
     private Cup cup;
     private GameLevel level; 
     
     public BombHit(Cup cup, GameLevel level) 
     {
        this.cup = cup;
        this.level = level;
    }
     
    @Override
    public void collide(CollisionEvent e) 
    {
       if(e.getOtherBody() == cup)
               {
                   cup.decreaseBallCount();
                   if(cup.getPosition().y!=level.cupPosition().y)
                   {
                       cup.setLinearVelocity(new Vec2(cup.getLinearVelocity().x,0));
                        cup.setPosition(new Vec2(cup.getPosition().x,level.cupPosition().y));
                   }
                   
                   if (level.scoreLimit() == true)
                   {
                       level.getGame().nextLevel();
                   }
                   e.getReportingBody().destroy();
               }
    }
    
}
