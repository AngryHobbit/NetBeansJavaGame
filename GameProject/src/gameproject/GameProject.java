/*
 * game project class makes the frame so you can see the game, starts the game and changes level
 */

package gameproject;

import city.cs.engine.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * game project class makes the frame so you can see the game, starts the game and changes level
 */

public class GameProject implements StepListener
{
    /** The World in which the bodies move and interact. */
    private GameLevel world;
   
    /** A graphical display of the world (a specialised JPanel). */
    private UserView view;
    
    public float level;
    
    private Controller controller;
    
    private ControlPanel panel;
    
    public GameProject()
    {
        // make the world
            world = new Level3();
            level = 3;
            world.populate(this);
            view = new MyView(world, 650, 680, this);
            //uncomment to see the Grid
            //view.setGridResolution(1);


            //display the view in a frame
            final JFrame frame = new JFrame("Game Project");
            
            panel = new ControlPanel(world , this);

            // quit the application when the game window is closed
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationByPlatform(true);
            // display the world in the window
            frame.add(view);
            frame.add(panel, BorderLayout.SOUTH);
            frame.setFocusable(true);
            //world.addStepListener(panel);
            
            // don't let the game window be resized
            frame.setResizable(false);
            // size the game window to fit the world view
            frame.pack();
            // make the window visible
            frame.setVisible(true);
            // creates the keylistener for the walker
            controller = new Controller(world.getPlayer(), world);
            frame.addKeyListener(controller);
            // uncomment this to make a debugging view
            //JFrame debugView = new DebugViewer(world, 800, 800);
            
            world.addStepListener(this);
            world.addStepListener(panel);
            world.start();
    }
    
    public Stopper getPlayer()
    {
        return world.getPlayer();
    }
    
    public boolean isCurrentLevelCompleted() 
    {
        return world.scoreLimit();
    }
    
    public float getLevel()
    {
        return level;
    }
  
    public void nextLevel()
    {
        System.out.println("Going to the next level...");
        world.stop();
        if (level == 1)
        {
        level++;
        world = new Level2();
        world.populate(this);
        world.addStepListener(this);
        controller.setBody(world.getPlayer());
        controller.setWorld(world);
        view.setWorld(world);
        world.start();
        }
        else if (level == 2)
        {
        level++;
        world = new Level3();
        world.populate(this);
        world.addStepListener(this);
        controller.setBody(world.getPlayer());
        controller.setWorld(world);
        view.setWorld(world);
        world.start();
        }
        else if (level == 3)
        {
        level++;
        world = new Level4();
        world.populate(this);
        world.addStepListener(this);
        controller.setBody(world.getPlayer());
        controller.setWorld(world);
        view.setWorld(world);
        world.start();
        }
        else if (level == 4){
            System.out.println("Game Over");
            System.exit(0);
        }
    }

    @Override
    public void preStep(StepEvent e) {
        
    }

    @Override
    public void postStep(StepEvent e) {
        panel.scoreLabel(world.getCup());
    }
    
    
    
    /** Run the game. */
    public static void main(String[] args) 
    {
        new GameProject();
    }
}
