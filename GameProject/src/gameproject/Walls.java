package gameproject;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 * The walls class makes a fixture in the shape of a "U"
 * The class is to clean up the balls that didnt hit the cup to help with performance as well as to activate the sounds effects.
 */

public class Walls extends StaticBody
{
    
    private static final float wallWidth = 0.5f;
    private static final float wallHeight = 30.2f;
    private static final float groundWidth = 20.0f;
    private static final float groundHeight = 0.5f;
    
    public Walls(World world)
    { 
        super(world);
        Shape groundShape = new BoxShape(groundWidth, groundHeight, 
                new Vec2(0,0.1f));
        SolidFixture ground = new SolidFixture(this, groundShape);
        
        Shape lwallShape = new BoxShape(wallWidth, wallHeight, 
                new Vec2(-19.5f, 0.2f));
        SolidFixture leftWall = new SolidFixture(this, lwallShape);
        
        Shape rwallShape = new BoxShape(wallWidth, wallHeight, 
                new Vec2(19.5f, 0.2f));
        SolidFixture RightWall = new SolidFixture(this, rwallShape);
        
        
        leftWall.setRestitution(1.1f);
        RightWall.setRestitution(1.1f);
    }
}
