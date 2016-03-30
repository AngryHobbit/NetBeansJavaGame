
package gameproject;

import city.cs.engine.*;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * my view changes the background depending on what level you are on.
 */

//public class MyView extends UserView 
//{
//    
//   private Image background;
//    
//    public MyView(World world, int width, int height) 
//    {
//        super(world, width, height);
//        background = new ImageIcon("data/level1.jpg").getImage();
//    }
//     
//    @Override
//    protected void paintBackground(Graphics2D g) 
//    {
//        
//        g.drawImage(background, 0, 0, this);
//    }
//}


public class MyView extends UserView 
{ 
   private GameProject game;
   private Image background;
   
   private Image level1 = new ImageIcon("data/level1.jpg").getImage();
   private Image level2 = new ImageIcon("data/level2.jpg").getImage();
   private Image level3 = new ImageIcon("data/level3.jpg").getImage();
   private Image level4 = new ImageIcon("data/level4.jpg").getImage();
    public MyView(World world, int width, int height, GameProject game) 
    {
        super(world, width, height);
        this.game = game;
    }
     
    @Override
    protected void paintBackground(Graphics2D g) 
    {
        if (game.getLevel() == 1) 
        {
            background = level1;
        }
        else if(game.getLevel() == 2)
        {
            background = level2;
        }
        else if(game.getLevel() == 3)
        {
            background = level3;
        }
        else if(game.getLevel() == 4)
        {
            background = level4;
        }
        g.drawImage(background, 0, 0, this);
    }
}