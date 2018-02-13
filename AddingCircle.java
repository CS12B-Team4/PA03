package pa03;

import java.awt.Color;

import java.awt.Graphics;

public class AddingCircle extends CircleShape{
  private double num;

  public AddingCircle(){
    super();
    this.color = new java.awt.Color(0,155,0,50);
    num = 0.0;
  }

  public void keepOnBoard(){
    // change the properties of the CircleShape after dt seconds have elapsed.
    super.keepOnBoard();
    num = num + 1;
  }

  public void draw( Graphics g ) {
    super.draw(g);
    int u = (int)(x-radius/(num%10));
    int v = (int)(y-radius/(num%10));
    int w = (int)(2*(radius/(num%10)));
    int h = w;
    g.setColor(new java.awt.Color(255,0,0,50) );
    g.fillOval( u,v,w,h );
    g.setColor( Color.BLACK );
    g.drawOval(u,v,w,h );
  }


}
