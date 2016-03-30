/*
 * The cup class makes a fixture in the shape of a "U"
 * The class also counts how many balls have hit it
 */

package gameproject;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * The cup class makes a fixture in the shape of a "U"
 * The class also counts how many balls have hit it
 */
public class Cup extends Walker
{
    private static final float wallWidth = 0.5f;
    private static final float wallHeight = 2.2f;
    private static final float groundWidth = 3.0f;
    private static final float groundHeight = 0.5f;
    
    private int BallCount;
        
    public Cup(World world)
    { 
        super(world);
        Shape groundShape = new BoxShape(groundWidth, groundHeight, 
                new Vec2(0,1.5f));
        SolidFixture ground = new SolidFixture(this, groundShape);
        
        Shape lwallShape = new BoxShape(wallWidth, wallHeight, 
                new Vec2(-2.5f, 4));
        SolidFixture leftWall = new SolidFixture(this, lwallShape);
        
        Shape rwallShape = new BoxShape(wallWidth, wallHeight, 
                new Vec2(2.5f, 4));
        SolidFixture rightWall = new SolidFixture(this, rwallShape);
        
        this.setGravityScale(0);
        
        
        BallCount = 0;    
    }
    
    public int getBallCount() {
        return BallCount;
    }

    public void incrementBallCount() 
    {
        BallCount++;
        System.out.println("Ball count = " + BallCount);
        
    }
    
    public void decreaseBallCount()
    {
        BallCount--;
        System.out.println("bomb hit");
        System.out.println("Ball count = " + BallCount);
    }
    
     public void addFive()
     {
        BallCount = BallCount +5;
        System.out.println("MAGIC BALL");
        System.out.println("Ball count = " + BallCount);
     }
}
