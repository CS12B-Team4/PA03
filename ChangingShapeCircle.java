package pa03;

import java.awt.Color;

import java.awt.Graphics;

/**
 * ChangingShapeCircle are red circles which would change into ovals when
 * hitting the borders and would change back into circles when hitting the
 * borders again. The shapes would bounce back after hitting the borders
 * and they move at a constant velocity.
 *
*/
public class ChangingShapeCircle extends CircleShape{

  private double ovalrx; // radius of the oval along x-axis
  private double ovalry; // radius of the oval along y-axis
  private double RadiusShrink=0.5; // one of the radius shrinks by 1/2 times when hitting the border
  private double RadiusStretch=2; // one of the radius stretches by 2 times when hitting the border
  private int bouncingTimeX=0; // the number of times that a single shape hits the left and right borders
  private int bouncingTimeY=0; // the number of times that a single shape hits the top and bottom borders

	/**
	 * Create a shape changing circle and set the color to red.
	 */
  public ChangingShapeCircle(){
    super();
		this.color = new java.awt.Color(255,0,0,100); // transparent red
    this.ovalrx=this.radius;
    this.ovalry=this.radius;
  }

  /**
   * Draw the disk in graphics context g, with a black outline.
   * Its posiion is given by doubles so we have to convert them to integers!
   * Remember that the draw/fillOval methods take the upper left corner (u,v)
   * and the width (w) and height (h) of the smallest box enclosing the oval.
   * @param g the Graphics object used to draw the objects in the model
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


  /**
   * Changes the values of x,y,vx,vy to keep the circle or oval on the board.
   * Shrinks or strectches radius to make the shape change between circle and oval.
  */
  public void keepOnBoard(){
    if (this.x < this.ovalrx) {
      // it hits the left border
      if (bouncingTimeX%2==0){
        // the radius of oval along the x-axis shrinks if the number of times it hits the left and right borders is even
        this.ovalrx = RadiusShrink*this.ovalrx;
        this.vx = -this.vx;
        this.x = this.ovalrx;
      } else {
        // the radius of oval along the x-axis shretches if the number of times it hits the left and right borders is odd
        this.ovalrx = RadiusStretch*this.ovalrx;
        this.vx = -this.vx;
        this.x = this.ovalrx;
      }
      bouncingTimeX++; // the number of times this shape hits the left and right borders increases by 1

    } else if (this.x > CircleShape.boardWidth-this.ovalrx) {
      // it hits the right border
      if (bouncingTimeX%2==0){
        this.ovalrx = RadiusShrink*this.ovalrx;
        this.vx = -this.vx;
        this.x = CircleShape.boardWidth-this.ovalrx;
      } else {
        this.ovalrx = RadiusStretch*this.ovalrx;
        this.vx = -this.vx;
        this.x = CircleShape.boardWidth-this.ovalrx;
      }
      bouncingTimeX++;
    }

    if (this.y < this.ovalry){
      // it hits the top border
      if (bouncingTimeY%2==0){
        // the radius of oval along the y-axis shrinks if the number of times it hits the top and bottom borders is even
        this.ovalry = RadiusShrink*this.ovalry;
        this.vy = -this.vy;
        this.y = this.ovalry;
      } else {
        // the radius of oval along the y-axis shretches if the number of times it hits the top and bottom borders is odd
        this.ovalry = RadiusStretch*this.ovalry;
        this.vy = -this.vy;
        this.y = this.ovalry;
      }
      bouncingTimeY++; // the number of times this shape hits the top and bottom borders increases by 1

    } else if (this.y > CircleShape.boardHeight-this.ovalry) {
      // it hits the bottom border
      if (bouncingTimeY%2==0){
        this.ovalry = RadiusShrink*this.ovalry;
        this.vy = -this.vy;
        this.y = CircleShape.boardHeight-this.ovalry;
      } else {
        this.ovalry = RadiusStretch*this.ovalry;
        this.vy = -this.vy;
        this.y = CircleShape.boardHeight-this.ovalry;
      }
      bouncingTimeY++;
    }
  }

}
