package pa03;


/**
 * RadiusChangingCircles are yellow circles which move at a constant velocity
 * on the board and bounce off the edges, but whose radius grows and shrinks.
*/
public class ColorDepthCircle extends CircleShape{

  
  private int depth=20;
	/**
	 * create a radius changing circle and set the color to yellow
	 */
  public ColorDepthCircle(){
    super();
    this.color = new java.awt.Color(200,150,255,this.depth); // transparent blue
  }

	/**
	 * update the circle as usual, but also change the radius. If it gets too big,
	 * then start it shrinking, if it gets too small then start it growing.
	 */
  public void update(double dt){

    this.color=new java.awt.Color(200,150,255,this.depth);
    if(this.depth<=200&&this.depth>50){
        if(Math.random()>0.5||Math.random()==0.5){
              this.depth=this.depth+10;
        }else{
              this.depth=this.depth-10;
        }
    } else if(this.depth<=100){
      this.depth=this.depth+10;
    } else {
      this.depth=this.depth-10;
    }
		super.update(dt);

  }




}
