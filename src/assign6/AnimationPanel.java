// Programmer: Noah Miller
// Class: CSCI 470
// Id: z1864020
// Assignment: Assignment 6
// Date due: 4/25/2021

//**************************************************
//* This class handles the ball animation panel
//* and ball object threading. This class also
//* handles the start and stop button methods and
//* are called from the BallAnimation class. When
//* the startBalls method is called, it will create
//* and start a new thread if one has not been
//* defined. This will call the run method and will
//* redraw the balls to the screen every 100ms.
//* The stopBalls method will set the thread to null
//* and will exit the run method.
//**************************************************

package assign6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class AnimationPanel extends JPanel implements Runnable
{
  // sleep interval between redraw calls
  private static int SLEEP_AMT = 100;
  
  // holds ball objects
  private ArrayList<Ball> ballAL = null;
  
  // size of panel
  private Dimension ballPanelDimPtr = null;
  
  // thread that updates balls
  private Thread threadObjPtr = null;
  
  // constructor
  public AnimationPanel()
  {
    Dimension dim = new Dimension(350, 350);
    ballAL = new ArrayList<Ball>();
    this.setPreferredSize(dim);
    this.setBackground(Color.WHITE);
  }
  
  // start the ball thread
  public void startBalls()
  {
	// only start moving objects if not already moving
    if (threadObjPtr == null)
    {
      // create and start thread
      threadObjPtr = new Thread(this);
      threadObjPtr.start();
    }
  }
  
  // stop thread from running by setting to null
  public void stopBalls()
  {
    threadObjPtr = null;
  }
  
  // called when thread is started
  // repaints the panel every 100ms
  @Override
  public void run()
  {
	// repaint while thread exists
    while (threadObjPtr != null)
    {
      this.repaint();
      
      try
      {
        Thread.sleep(SLEEP_AMT);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  // populates ball array list if not populated
  // moves and redraws ball objects in the panel
  @Override
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    
    // define panel dimensions and
    // populate ball array list
    // if first time running
    if (ballPanelDimPtr == null)
    {
      ballPanelDimPtr = this.getSize();
      
      // define ball size and add balls
      Dimension d = new Dimension(20, 20);
      ballAL.add(new Ball(Color.GREEN, (d.width * 2 / 3), (d.height + 28), 20, -4, 20));
      ballAL.add(new Ball(Color.YELLOW, (d.width * 2 / 3), (d.height + 1), 40, -8, 20));
      ballAL.add(new Ball(Color.RED, (d.width * 2 / 3), (d.height + 100), 80, -16, 20));
    }

    // update object locations in ball array list
    // redraw balls on screen
    for (Ball ball: ballAL)
    {
      ball.move(this.getSize());
      ball.draw(g);
    }
  }
}