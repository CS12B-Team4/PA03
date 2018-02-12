package pa03;
import java.awt.Color;


/**
*go fast when reached a corner and go slow again when reached another corner
*/
public class JenCircles extends CircleShape{

	private double rate; // multiply by 

	public JenCircles(){
		super(); //calls the constructor from CircleShape before coming back to this class!!!! 
			this.color = new java.awt.Color(0,255,80,80); //transparent green
			this.rate = 0.00001;

	}

	public void keepOnBoard(){

		if (this.x < this.radius) {
			//it went off the left edge
			this.rate = 1.5;
       		this.vx = -(this.vx*rate);
			this.x = this.radius;
	

		} else if (this.x > CircleShape.boardWidth-this.radius) {
				// it went off the right edge! do something!
			this.rate = 1.5;
            this.vx = -(this.vx*rate);
			this.x = CircleShape.boardWidth-this.radius;
		}


		if (this.y < this.radius){
				// it went above the top edge!
			this.rate = 0.5; 
        	this.vy = -(this.vy* rate);
			this.y = this.radius;

		} else if (this.y > CircleShape.boardHeight-this.radius) {
				// it went below the bottom edge!
			this.rate = 0.5; 
        	this.vy = -(this.vy * rate);
			this.y = CircleShape.boardHeight-this.radius;
		}
		this.vx = Math.min(100,Math.max(-100,this.vx));
		this.vy = Math.min(100,Math.max(-100,this.vy));
	}

	public String toString(){
		return "JenCircles: " + super.toString();
	}
}



  		