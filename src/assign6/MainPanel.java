// Programmer: Noah Miller
// Class: CSCI 470
// Id: z1864020
// Assignment: Assignment 5
// Date due: 4/9/2021

//**************************************************
//* This class handles the gif picture buttons and
//* the reset button. It also creates the two panels
//* that hold both the gifs and the reset button.
//**************************************************

package assign6;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class MainPanel extends JPanel implements ActionListener
{
  // gif image names
  String[] imageStringNameA = {"Images/pat1.gif", "Images/pat2.gif",
		  "Images/pat3.gif", "Images/pat4.gif", "Images/pat5.gif"};
  
  final static Image[] imageA = new Image[5]; // holds each gif image                                      
  JToolBar mainPanelToolBar = new JToolBar(); // pointer to top toolbar for main panel
  private JPanel resetPanel = new JPanel(); // panel that holds reset button
  
  //pointer to a panel yellow area where we will “paint” items on a tile Grid
  TileGridPanel tileGridPanelPtr = new TileGridPanel();
  
  // need to declare 5 buttons for tool bar….and a reset button
  JButton patch1B, patch2B, patch3B, patch4B, patch5B, resetB;

  // constructor. creates the toolbar and reset panels
  public MainPanel()
  {
    this.setLayout(new BorderLayout());
    
    // load gifs into image array
    loadImages();
    
    // create each gif image button
    patch1B = new JButton(new ImageIcon(imageA[0]));
    patch2B = new JButton(new ImageIcon(imageA[1]));
    patch3B = new JButton(new ImageIcon(imageA[2]));
    patch4B = new JButton(new ImageIcon(imageA[3]));
    patch5B = new JButton(new ImageIcon(imageA[4]));
    
    // add each button to panel
    mainPanelToolBar.add(patch1B);
    mainPanelToolBar.add(patch2B);
    mainPanelToolBar.add(patch3B);
    mainPanelToolBar.add(patch4B);
    mainPanelToolBar.add(patch5B);
    
    // set up each button listener
    patch1B.addActionListener(this);
    patch2B.addActionListener(this);
    patch3B.addActionListener(this);
    patch4B.addActionListener(this);
    patch5B.addActionListener(this);
    
    this.add(mainPanelToolBar, BorderLayout.NORTH);
    
    // create and add the reset button
    resetB = new JButton("Reset");
    resetPanel.add(resetB);
    
    // add listener to reset button
    resetB.addActionListener(this);
    
    // add the reset panel to the layout
    this.add(resetPanel, BorderLayout.SOUTH);
    
    // add yellow centerPanel to mainPanel
    add(tileGridPanelPtr, BorderLayout.CENTER);

    // reset grid and and paint empty center area
    tileGridPanelPtr.resetGridTile();  
  } // end constructor

  // listens for button clicks
  @Override
  public void actionPerformed(ActionEvent e)
  {
    // gif 1 button
    if (e.getSource() == patch1B)
    {
      // sets the variable in tileGridPanel object
      tileGridPanelPtr.selectedTile = 0;
    }
    
    // gif 2 button
    if (e.getSource() == patch2B)
    {
      tileGridPanelPtr.selectedTile = 1;
    }
    
    // gif 3 button
    if (e.getSource() == patch3B)
    {
      tileGridPanelPtr.selectedTile = 2;
    }
    
    // gif 4 button
    if (e.getSource() == patch4B)
    {
      tileGridPanelPtr.selectedTile = 3;
    }
    
    // gif 5 button
    if (e.getSource() == patch5B)
    {
      tileGridPanelPtr.selectedTile = 4;
    }
    
    // reset button
    if (e.getSource() == resetB)
    {
      tileGridPanelPtr.resetGridTile();
    }
  }
  
  // loads the gif files into the image array
  private void loadImages()
  {
    for (int i = 0; i < imageA.length; i++)
    {
      try
      {
        // load gif into array at specified address
        imageA[i] = ImageIO.read(new File(imageStringNameA[i]));
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  }
}