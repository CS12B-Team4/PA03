package pa03;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * RotateCircles are yellow circles which move at a constant velocity
 * on the board and bounce off the edges, but whose radius grows and shrinks.
*/
public class RotateCircle extends CircleShape{
  
  public static int myFrame=0;
  private double count=1;
  private int startX;
  private int endX;
  private int startY;
  private int endY;
  private double angleNum;


	/**
	 * create a radius changing circle and set the color to yellow
	 */
  public RotateCircle(){
    super();
		this.color = new java.awt.Color(255,0,102,100);
  }

  public void keepOnBoard(){

    if (this.x < this.radius) {
      this.count*=-1;
    }else if (this.x > CircleShape.boardWidth-this.radius) {
      this.count*=-1;
    }

    if (this.y < this.radius){
      this.count*=-1;
    } else if (this.y > CircleShape.boardHeight-this.radius) {
      this.count*=-1;
    }
    super.keepOnBoard();
  }

  public void update(double dt){
    myFrame++;
    this.angleNum=(double)(((myFrame/this.vx/3)%360)/180*Math.PI);
    this.startX=(int)(this.x+this.count*this.radius*Math.cos(this.angleNum));
    this.endX=(int)(this.x-this.count*this.radius*Math.cos(this.angleNum));
    this.startY=(int)(this.y-this.count*this.radius*Math.sin(this.angleNum));
    this.endY=(int)(this.y+this.count*this.radius*Math.sin(this.angleNum));

    super.update(dt);

  }

  public void draw(Graphics g){
    g.setColor(new Color(0,0,0));
    g.drawLine(this.startX,this.startY,this.endX,this.endY);
    super.draw(g);
  }


}
