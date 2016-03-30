/*
 * magic hit class is a collision that when it hits the cup the player gains 5 points then the ball is destroyed
 */
package gameproject;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * magic hit class is a collision that when it hits the cup the player gains 5 points then the ball is destroyed
 */
public class MagicHit implements CollisionListener
{
     private Cup cup;
     private GameLevel level; 
     
     public MagicHit(Cup cup, GameLevel level) 
     {
        this.cup = cup;
        this.level = level;
    }
     
    @Override
    public void collide(CollisionEvent e) 
    {
       if(e.getOtherBody() == cup)
               {
                   cup.addFive();
                   if(cup.getPosition().y!=level.cupPosition().y)
                   {
                       cup.setLinearVelocity(new Vec2(cup.getLinearVelocity().x,0));
                        cup.setPosition(new Vec2(cup.getPosition().x,level.cupPosition().y));
                   }
                   
//                   if (level.scoreLimit() == true)
//                   {
//                       level.getGame().nextLevel();
//                   }
                   e.getReportingBody().destroy();
               }
    }
}
