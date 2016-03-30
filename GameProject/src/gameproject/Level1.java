/*
 * Level1 extends GameLevel to make sure that it overrides everything it needs to such as the player start
 */
package gameproject;

import city.cs.engine.*;
import java.awt.event.*;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

/**
 * Level1 extends GameLevel to make sure that it overrides everything it needs to such as the player start
 */

public class Level1 extends GameLevel implements ActionListener
{
    private static final int NUM_balls = 5;
    private Cup cup;
    private Walls walls;
    private Ball ball;
    public float x = 0;
    public float y = -5.0f;
    public float vx = 5.5f;
    private Timer timer;
    
     @Override
        public Vec2 cupPosition()
        {
            return new Vec2(x,y);
        }
    
    @Override
    public Vec2 startPosition() 
         {
             return new Vec2(0,8.3f);
         }
    
    @Override
    public boolean scoreLimit() 
    {
        return cup.getBallCount() >= NUM_balls;
    }
    
    
    public Cup getCup()
    {
        return cup;
    }
    
    
    
    @Override
    public void populate(GameProject game)
    {
        timer = new Timer(60000, this);
        timer.start();
        
        super.populate(game);
        { //makes the Container
            Shape shape = new BoxShape(8.0f, 0.5f);
            Body slopeLeft = new StaticBody(this, shape);
            slopeLeft.setPosition(new Vec2(-9.5f, 12f));
            slopeLeft.setAngleDegrees(-25);

            Body slopeRight = new StaticBody(this, shape);
            slopeRight.setPosition(new Vec2(9.5f, 12f));
            slopeRight.setAngleDegrees(25);

            Shape slopeRightEndShape = new BoxShape(0.5f, 0.125f, new Vec2(-8.4f,-0.37f));
            SolidFixture slopeRightEnd =  new SolidFixture(slopeRight, slopeRightEndShape);
            
            Shape slopeRightEndShape2 = new BoxShape(0.5f, 0.125f, new Vec2(-8.4f,0.37f));
            SolidFixture slopeRightEnd2 =  new SolidFixture(slopeRight, slopeRightEndShape2);
            
            Shape slopeLeftEndShape = new BoxShape(0.5f, 0.125f, new Vec2(8.4f,-0.37f));
            SolidFixture slopeLeftEnd =  new SolidFixture(slopeLeft, slopeLeftEndShape);
            
            Shape slopeLeftEndShape2 = new BoxShape(0.5f, 0.125f, new Vec2(8.4f,0.37f));
            SolidFixture slopeLeftEn2d =  new SolidFixture(slopeLeft, slopeLeftEndShape2);


            Shape wallLeftShape = new BoxShape(0.5f, 2f, new Vec2(-7.5f, 2f));
            SolidFixture wallLeft = new SolidFixture(slopeLeft, wallLeftShape);
            
            Shape wallRightShape = new BoxShape(0.5f, 2f, new Vec2(7.5f, 2f));
            SolidFixture wallRight = new SolidFixture(slopeRight, wallRightShape);
        }
        
        {//makes walls
            walls = new Walls(this);
            walls.setPosition(new Vec2(0f,-20)); 
        }
        
        
        {//makes the Cups
        
            
            cup = new Cup(this);
            cup.setPosition(new Vec2(cupPosition()));
            cup.setLinearVelocity(new Vec2(vx,0));
           
            
        }
        
        {//makes the Balls
            
            //makes redballs number is doubled
            float numberBalls = 6;
            for (int y = 0; y < numberBalls; y++) 
            {
                for (int x = y; x < numberBalls; x++) 
                {
                    ball = new Ball(this);
                    ball.setPosition(new Vec2(x - y/ 7.0f - 3.5f , y + 17.5f));
                    ball.addCollisionListener(new Pickup(cup,this));
                    ball.addCollisionListener(new WallHit(walls));
                }
            }
        }
 
    }
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        System.out.println("Time Up!");
        super.stop();
    }
}
