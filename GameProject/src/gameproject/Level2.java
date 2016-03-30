
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
 *  Level2 extends GameLevel to make sure that it overrides everything it needs to such as the cup position
 */
public class Level2 extends GameLevel implements ActionListener
{
    private static final int NUM_balls = 10;
    private Cup cup;
    private Walls walls;
    private Ball ball;
    private BallH ballh;
    public float x = 0;
    public float y = -10.0f;
    public float vx = 3.0f;
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
    @Override
    public Cup getCup(){
        return cup;
    }
    
    @Override
    public void populate(GameProject game)
    {
        super.populate(game);
        timer = new Timer(120000, this);
        timer.start();
        { 
            Shape shape = new BoxShape(8.0f, 0.5f);
            Body slopeLeft = new StaticBody(this, shape);
            slopeLeft.setPosition(new Vec2(-9.5f, 12f));
            slopeLeft.setAngleDegrees(-25);

            Body slopeRight = new StaticBody(this, shape);
            slopeRight.setPosition(new Vec2(9.5f, 12f));
            slopeRight.setAngleDegrees(25);

            Shape slopeRightEndShape = new BoxShape(0.5f, 0.125f, new Vec2(-8.4f,-0.37f));
            Fixture slopeRightEnd =  new SolidFixture(slopeRight, slopeRightEndShape);

            Shape slopeRightEndShape2 = new BoxShape(0.5f, 0.125f, new Vec2(-8.4f,0.37f));
            Fixture slopeRightEnd2 =  new SolidFixture(slopeRight, slopeRightEndShape2);

            Shape slopeLeftEndShape = new BoxShape(0.5f, 0.125f, new Vec2(8.4f,-0.37f));
            Fixture slopeLeftEnd =  new SolidFixture(slopeLeft, slopeLeftEndShape);

            Shape slopeLeftEndShape2 = new BoxShape(0.5f, 0.125f, new Vec2(8.4f,0.37f));
            Fixture slopeLeftEn2d =  new SolidFixture(slopeLeft, slopeLeftEndShape2);



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
            float numberBalls = 8;
            for (int y = 0; y < numberBalls; y++) 
            {
                for (int x = y; x < numberBalls; x++) 
                {
                    ball = new Ball(this);
                    ball.setPosition(new Vec2(x - y/ 4.0f - 3.5f , y + 17.5f));
                    ball.addCollisionListener(new Pickup(cup,this));
                    ball.setGravityScale(1f);
                    ball.addCollisionListener(new WallHit(walls));
                }
            }
            for (int i = 0; i < 10; i++) 
            {//makes heavy balls
                ballh = new BallH(this);
                ballh.setPosition(new Vec2(i*2-10, 17.5f));
                ballh.addCollisionListener(new Pickup(cup,this));
                ballh.setGravityScale(3);
                ballh.addCollisionListener(new WallHit(walls));
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
