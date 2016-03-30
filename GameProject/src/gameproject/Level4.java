
package gameproject;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Fixture;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

/**
 * Level4 extends GameLevel to make sure that it overrides everything it needs to such as the getCup to return the score
 */

public class Level4 extends GameLevel implements ActionListener
{
  private static final int NUM_balls = 15;
    private Cup cup;
    private Walls walls;
    private Ball ball;
    private BallH ballh;
    private MagicBall magicBall;
    private Bomb bomb;
    public float x = -14f;
    public float y = -17.0f;
    public float vx = 4.0f;
    private Timer timer;
    
    @Override
    public Vec2 cupPosition()
    {
        return new Vec2(x,y);
    }
    
    @Override
    public Vec2 startPosition() 
    {
        return new Vec2(-14,8.3f);
    }
    
    @Override
    public boolean scoreLimit() 
    {
        return cup.getBallCount() >= NUM_balls;
    }
    
    @Override
    public Cup getCup(){
        return cup;
    }
    
    @Override
    public void populate(GameProject game)
    {
        super.populate(game);
                timer = new Timer(60000, this);
        timer.start();
        { 
            Shape shape = new BoxShape(8.0f, 0.5f);
            Body slopeLeft = new StaticBody(this, shape);
            slopeLeft.setPosition(new Vec2(-23.5f, 12f));
            slopeLeft.setAngleDegrees(-25);

            Body slopeRight = new StaticBody(this, shape);
            slopeRight.setPosition(new Vec2(-4.5f, 12f));
            slopeRight.setAngleDegrees(25);
            

            Shape slopeRightEndShape = new BoxShape(0.5f, 0.125f, new Vec2(-8.4f,-0.37f));
            Fixture slopeRightEnd =  new SolidFixture(slopeRight, slopeRightEndShape);

            Shape slopeRightEndShape2 = new BoxShape(0.5f, 0.125f, new Vec2(-8.4f,0.37f));
            Fixture slopeRightEnd2 =  new SolidFixture(slopeRight, slopeRightEndShape2);

            Shape slopeLeftEndShape = new BoxShape(0.5f, 0.125f, new Vec2(8.4f,-0.37f));
            Fixture slopeLeftEnd =  new SolidFixture(slopeLeft, slopeLeftEndShape);

            Shape slopeLeftEndShape2 = new BoxShape(0.5f, 0.125f, new Vec2(8.4f,0.37f));
            Fixture slopeLeftEnd2 =  new SolidFixture(slopeLeft, slopeLeftEndShape2);

            Shape wallLeftShape = new BoxShape(0.5f, 2f, new Vec2(-7.5f, 2f));
            Fixture wallLeft = new SolidFixture(slopeLeft, wallLeftShape);

            Shape wallRightShape = new BoxShape(0.5f, 2f, new Vec2(7.5f, 2f));
            Fixture wallRight = new SolidFixture(slopeRight, wallRightShape);
            
          
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
 
            for (int i = 0; i < 5; i++) 
            {//makes Bombs 
                magicBall = new MagicBall(this);
                magicBall.setPosition(new Vec2(i*2-10, 17.5f));
                magicBall.addCollisionListener(new MagicHit(cup,this));
                magicBall.addCollisionListener(new WallHit(walls));
                magicBall.setGravityScale(2);
            }   
            for (int i = 0; i < 3; i++) 
            {//makes Bombs    
                bomb = new Bomb(this);
                bomb.setPosition(new Vec2(i*2-7, 20.5f));
                bomb.addCollisionListener(new BombHit(cup,this));
                bomb.addCollisionListener(new WallHit(walls));
                bomb.setGravityScale(4);
            } 
            
                ball = new Ball(this);
                ball.setPosition(new Vec2(-3.5f , 17.5f));
                ball.addCollisionListener(new Pickup(cup,this));
                ball.addCollisionListener(new WallHit(walls));
                
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

