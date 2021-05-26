// Programmer: Instructor
// Class: CSCI 470
// Assignment: Assignment 6
// Date due: 4/25/2021

//**************************************************
//* This class handles the movement and drawing of
//* a ball object. The ball object will float around
//* within the given dimension and will change
//* direction when meeting the max dimension value.
//**************************************************

package assign6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

class Ball
{
  Color color;
  
  // Color, radius, coordinates, and movement.
  int radius;
  int x, y;
  int dx, dy;
  
  // Constructor statement.
  Ball(Color col, int rad, int x, int y, int dx, int dy)
  {
    this.color = col;
    this.radius = rad;
    this.x = x;
    this.y = y;
    this.dx = dx;
    this.dy = dy;
  }
  
  // Move function.
  public void move(Dimension dPanel)
  {
    // Checks to see if ball has hit the edge of the panel.
    if (x <= radius || x >= (dPanel.width - ( 2 * radius)))
    {
      dx = -dx; // If so, switch direction.
    }
    
    // Same for y direction.
    if (y <= radius || y >= (dPanel.height - (2 * radius)))
    {
      dy = -dy;
    }
    
    x += dx; // If not, continue moving the ball in the direction and modify the coordinates to reflect the move.
    
    y += dy;
  }
  
  // Draws the ball in its new location, changing x and y each time.
  public void draw(Graphics g)
  {
    g.setColor(color); // Sets the color to whatever the balls color was.
    g.fillOval(x, y, 2 * radius, 2 * radius); // Draws the ball in the new location.
  }
}