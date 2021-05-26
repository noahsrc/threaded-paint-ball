// Programmer: Noah Miller
// Class: CSCI 470
// Id: z1864020
// Assignment: Assignment 5
// Date due: 4/9/2021

//**************************************************
//* This class keeps track of the selected gif and
//* paints the grid area with the selected gif when
//* ready. This class also resets the grid area.
//**************************************************

package assign6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

class TileGridPanel extends JPanel implements MouseListener
{
  // this is set to 0-4 when user clicks on a button in toolbar in mainpanel
  int selectedTile = -1;
  static final int squareSide = 25; 
  int GridRow = 5, GridCol = 5;
  
  // we take gifs in here and draw in tilegrid
  Image[][] gif2dArray = new Image[GridRow][GridCol]; 

  // constructor
  public TileGridPanel()
  {
    // tells this panel we have routines for mousevents interface
    this.addMouseListener(this);
    this.setBackground(Color.yellow);
  }

  // listen for mouse click in grid area
  public void mouseClicked(MouseEvent event)
  {
    if (selectedTile >= 0)
    {
      setImage(MainPanel.imageA[selectedTile]);
    }
  }

  // reset grid images. called when reset button clicked
  public void resetGridTile()
  {
    selectedTile = -1;
    setImage(null);
  }

  // paints the center panel with elements in 2darray
  @Override
  public void paintComponent(Graphics g)
  { 
    super.paintComponent(g);
    
    // find center of panel
    int gridWidth = GridCol * squareSide;
    int gridHeight = GridRow * squareSide;
    int panelWidth = getWidth();
    int panelHeight = getHeight();
      
    // finding center and get starting points to draw grid
    int startX = (panelWidth - gridWidth) / 2;
    int startY = (panelHeight - gridHeight) / 2;

    // copy gif image array over to the drawing grid with inner/ outer loop
    for (int x = 0; x < GridRow; x++)
    {
      for (int y = 0; y < GridCol; y++)
      {
        // 'x' pattern
        if (x == y || x == y - 4 || x == y + 4 || (x == 3 && y == 1) || (x == 1 && y == 3))
        {
          // draw images in grid
          g.drawImage(gif2dArray[x][y], startX + (squareSide * x), startY + (squareSide * y), this);
        }
      }
    }
  }

  @Override
  public void mousePressed(MouseEvent e)
  {
    
  }

  @Override
  public void mouseReleased(MouseEvent e)
  {
    
  }

  @Override
  public void mouseEntered(MouseEvent e)
  {
    
  }

  @Override
  public void mouseExited(MouseEvent e)
  {
    
  }
  
  // set images in gif2dArray
  private void setImage(Image img)
  {
    for (int x = 0; x < GridRow; x++)
    {
      for (int y = 0; y < GridCol; y++)
      {
        gif2dArray[x][y] = img;
      }
    }
    
    this.repaint(); // draw new grid
  }
}