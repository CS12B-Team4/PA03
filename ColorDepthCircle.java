package pa03;


/**
 * ColorDepthCircle can change circles' color depth. It can change the transparence of the circles.
   The transparence will change from very dark to light. Then they will change from very light to dark, and
   repeats this process over and over again.
*/
public class ColorDepthCircle extends CircleShape{


  private int depth=20; //the transparence of the circle's color

  public ColorDepthCircle(){
    super();
    this.color = new java.awt.Color(200,150,255,this.depth); // transparent purple
  }

	/**
	 * update the circle as usual, but also change the transparence of the circle
	 * the transparence will go deeper, but it is very deep, the transparence will go to be more transparent.
   The program will repeat this process over and over again.
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
