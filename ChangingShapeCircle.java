package pa03;

import java.awt.Color;

import java.awt.Graphics;

/**
 * RadiusChangingCircles are yellow circles which move at a constant velocity
 * on the board and bounce off the edges, but whose radius grows and shrinks.
*/
public class ChangingShapeCircle extends CircleShape{

  private double ovalrx;
  private double ovalry;
  private double RadiusDecreasePercentage=0.5;
  private double RadiusIncreasePercentage=2;
  private int bouncingTimeX=0;
  private int bouncingTimeY=0;

	/**
	 * create a radius changing circle and set the color to yellow
	 */
  public ChangingShapeCircle(){
    super();
		this.color = new java.awt.Color(255,0,0,100); // transparent blue
    this.ovalrx=this.radius;
    this.ovalry=this.radius;
  }

  /**
   * Draw the disk in graphics context g, with a black outline.
   * Its posiion is given by doubles so we have to convert them to integers!
   * Remember that the draw/fillOval methods take the upper left corner (u,v)
   * and the width (w) and height (h) of the smallest box enclosing the oval.
   */
  public void draw( Graphics g ) {
      int u = (int)(x-ovalrx);
      int v = (int)(y-ovalry);
      int w = (int)(2*ovalrx);
      int h = (int)(2*ovalry);
      g.setColor( color );
      g.fillOval( u,v,w,h );
      g.setColor( Color.BLACK );
      g.drawOval(u,v,w,h );

  }

  public void keepOnBoard(){
    if (this.x < this.ovalrx) {
      // it went off the left edge! do something!
      if (bouncingTimeX%2==0){
        this.ovalrx = RadiusDecreasePercentage*this.ovalrx;
        this.vx = -this.vx;
        this.x = this.ovalrx;
      } else {
        this.ovalrx = RadiusIncreasePercentage*this.ovalrx;
        this.vx = -this.vx;
        this.x = this.ovalrx;
      }
      bouncingTimeX++;

    } else if (this.x > CircleShape.boardWidth-this.ovalrx) {
      // it went off the right edge! do something!
      if (bouncingTimeX%2==0){
        this.ovalrx = RadiusDecreasePercentage*this.ovalrx;
        this.vx = -this.vx;
        this.x = CircleShape.boardWidth-this.ovalrx;
      } else {
        this.ovalrx = RadiusIncreasePercentage*this.ovalrx;
        this.vx = -this.vx;
        this.x = CircleShape.boardWidth-this.ovalrx;
      }
      bouncingTimeX++;
    }

    if (this.y < this.ovalry){
      // it went above the top edge!
      if (bouncingTimeY%2==0){
        this.ovalry = RadiusDecreasePercentage*this.ovalry;
        this.vy = -this.vy;
        this.y = this.ovalry;
      } else {
        this.ovalry = RadiusIncreasePercentage*this.ovalry;
        this.vy = -this.vy;
        this.y = this.ovalry;
      }
      bouncingTimeY++;

    } else if (this.y > CircleShape.boardHeight-this.ovalry) {
      // it went below the bottom edge!
      if (bouncingTimeY%2==0){
        this.ovalry = RadiusDecreasePercentage*this.ovalry;
        this.vy = -this.vy;
        this.y = CircleShape.boardHeight-this.ovalry;
      } else {
        this.ovalry = RadiusIncreasePercentage*this.ovalry;
        this.vy = -this.vy;
        this.y = CircleShape.boardHeight-this.ovalry;
      }
      bouncingTimeY++;
    }
  }




}
