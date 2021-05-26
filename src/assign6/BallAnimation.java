// Programmer: Noah Miller
// Class: CSCI 470
// Id: z1864020
// Assignment: Assignment 6
// Date due: 4/25/2021

//**************************************************
//* This class defines the buttons and animation
//* panel for the eastern side of assignment 6.
//* It also listens for clicks of the start
//* and stop buttons and calls the AnimationPanel
//* startBall and stopBall methods.
//**************************************************

package assign6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class BallAnimation extends JPanel implements ActionListener
{
  // start and stop buttons
  private JButton startB, stopB;
  
  // animation panel
  private AnimationPanel animP;
  
  public BallAnimation()
  {
	// create new border layout
    this.setLayout(new BorderLayout());
    
    JPanel ballAnimationPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    
    // init animation panel
    animP = new AnimationPanel();
    
    // add anim panel to ball panel
    ballAnimationPanel.add(animP);
    
    // init buttons
    startB = new JButton("Start");
    stopB = new JButton("Stop");
    
    // add button listeners
    startB.addActionListener(this);
    stopB.addActionListener(this);
    
    // add buttons to button panel
    buttonPanel.add(startB);
    buttonPanel.add(stopB);
    
    // make sure background of button panel doesnt appear white
    buttonPanel.setBackground((Color) UIManager.getColor ( "Panel.background" ));
    
    // add panels to ball panel
    this.add(ballAnimationPanel, BorderLayout.NORTH);
    this.add(buttonPanel, BorderLayout.SOUTH);
  }
  
  // listen for button clicks
  @Override
  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() == startB) // start balls button
    {
      // call start balls in amination panel to start thread
      animP.startBalls();
    }
    
    if (e.getSource() == stopB) // stop balls button
    {
      // call stop balls in amination panel to stop thread
      animP.stopBalls();
    }
  }
}