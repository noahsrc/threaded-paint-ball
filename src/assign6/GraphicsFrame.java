// Programmer: Noah Miller
// Class: CSCI 470
// Id: z1864020
// Assignment: Assignment 5
// Date due: 4/9/2021

//**************************************************
//* This program paints gifs on a grid within the
//* frame. A user is able to select from different
//* gifs and they are painted in an 'x' shape when
//* the yellow area in the frame is clicked. The
//* yellow area can be cleared of gifs by clicking
//* reset. This class creates the main program gui 
//* frame and calls the MainPanel class to initialize
//* the program.
//**************************************************

//
// Note: Extra credit was done by drawing an 'x'
//       on the grid.
//

//**************************************************
//* New additions in pgm6:
//* Added a ball animation panel to the eastern
//* frame border. Moved the main panel to the western
//* border.
//**************************************************

package assign6;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class GraphicsFrame extends JFrame
{
   // main method that sets up the frame
   public static void main(String[] args)
   {
     // create our frame and constructor puts large
     GraphicsFrame frame = new GraphicsFrame();
      
     // main panel over the entire frame
     frame.setName("Frame");
     frame.setSize(600, 430);    
     frame.setTitle("Assignment 6 - Thread / Ball Application by Noah Miller");
     frame.setVisible(true); 
   }

   // constructor
   public GraphicsFrame()
   { 
     super();
     MainPanel mainPanelPtr = new MainPanel();
     
     // main panel covers west side of frame
     this.add(mainPanelPtr, BorderLayout.WEST);
     
     // new in pgm6
     // ball animation object
     BallAnimation ballAnimPtr = new BallAnimation();
     
     // ball panel covers east side of frame
     this.add(ballAnimPtr, BorderLayout.EAST);
   }
}