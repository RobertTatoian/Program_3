package program3;

import processing.core.PApplet;

public class Arm {
	
	public final static float ANGLE_INCR = 0.1f;
	public final static int JOINT_COLOR = 0xFFFF0000;
	public final static int LINK_COLOR = 0xFF0000FF;
	private final float JOINT_DIAM = 0.1f;
	private float[] theta = {0, 0.1f, -0.3f, 0.2f, -0.2f, 0, 0.1f, -0.3f, 0.2f, -0.2f};
	//	Right now I have reduced this because the mathematics of inverse
	//	kinematics so far can only handle a 2x2 Jacobian matrix
	private final int NUM_JOINTS = 6;
	//				index 0 is for padding
	private float[] L = {0, 1.f, 0.5f, 0.70f, 0.60f, 0, 1.f, 0.5f, 0.70f, 0.60f};
	private float H = 1.0f;
	
	
	public void draw(PApplet app) {
		// draw the arm		
		app.stroke(LINK_COLOR);
		app.strokeWeight(0.1f);
		app.line(0, 0, 0, H);
		app.noStroke();
		app.fill(JOINT_COLOR);
		app.ellipse(0, 0, JOINT_DIAM, JOINT_DIAM);
		app.translate(0, H);
		
		for (int k=1; k<=NUM_JOINTS; k++) 
		{
			Joint j = new Joint(JOINT_COLOR,LINK_COLOR,JOINT_DIAM);
			j.draw(app, theta[k], L[k]);
		}
	}
}