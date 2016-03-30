
package gameproject;

import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 * game level is a abstract class which makes every class that extends it has to have certain override methords
 */
public abstract class GameLevel extends World
{
     private Stopper stopper;
     private GameProject game;
     
     
    
    public void populate(GameProject game){
        stopper = new Stopper(this);
        stopper.setPosition(startPosition());
        this.game=game;

        
    }
    
    public abstract Vec2 startPosition();
    
    public abstract Vec2 cupPosition();
            
    public abstract boolean scoreLimit();
    
    public abstract Cup getCup();
    
    
    
    
    public Stopper getPlayer()
    {
        return stopper;
    }
    public GameProject getGame()
    {
        return game;
    }
        
}
