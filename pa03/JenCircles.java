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

	public void KeepOnBoard(){
		super.keepOnBoard();

		if (this.x < this.radius) {
			//it went off the left edge
       		this.vx = -(this.vx*rate);
			this.x = this.radius;

		} else if (this.x > CircleShape.boardWidth-this.radius) {
				// it went off the right edge! do something!
            this.vx = -(this.vx*rate);
			this.x = CircleShape.boardWidth-this.radius;
		}


		if (this.y < this.radius){
				// it went above the top edge!
			this.rate = 10000; 
        	this.vy = -(this.vy* rate);
			this.y = this.radius;

		} else if (this.y > CircleShape.boardHeight-this.radius) {
				// it went below the bottom edge!
			this.rate = 10000; 
        	this.vy = -(this.vy * rate);
			this.y = CircleShape.boardHeight-this.radius;
		}
	}

	public String toString(){
		return "JenCircles: " + super.toString();
	}
}



  		