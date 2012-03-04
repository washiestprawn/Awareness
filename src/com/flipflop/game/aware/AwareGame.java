package com.flipflop.game.aware;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;

import java.util.logging.Logger;

import org.lwjgl.LWJGLException;

import com.flipflop.game.GameComponent;
import com.flipflop.game.graphic.RecPrism;
import com.flipflop.game.graphic.Vec3;

public class AwareGame extends GameComponent {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AwareGame.class.getName());
	private static final String APPNAME = "Awareness";
	
	public AwareGame() throws LWJGLException{
		super(APPNAME);
		init();
	}

	public AwareGame(int width, int height) throws LWJGLException {
		super(APPNAME, width, height);
		init();
	}
	
	public AwareGame(int width, int height, boolean fullscreen) throws LWJGLException {
		super(APPNAME, width, height, fullscreen);
		init();
	}
	
	public void init() {};

	float[] rgb = {0.0f, 0.0f, 0.0f};
	RecPrism[] rec = {new RecPrism(new Vec3(-0.7f,-0.7f,-3.0f), 1.0f, 1.0f, 1.0f), new RecPrism(new Vec3(0.7f,0.7f,-3.0f), 1.0f, 1.0f, 1.0f)};
	float degree = 0.0f;
	Vec3 rot = new Vec3(1.0f, 1.0f, 0.0f);
	@Override
	protected void render() {
		for (int i=0; i<rgb.length; i++) {
			if (Math.random() >= 0.5d) rgb[i] -= .1;
			else rgb[i] += .1;
		}
		//glClearColor(rgb[0], rgb[1], rgb[2], 0.0f);
		//glClear(GL_COLOR_BUFFER_BIT);
		
		degree += (float) 1/6;
		if (degree == 360) degree = 0;
		
		rec[0].rotate(rot, degree);
		rec[1].rotate(rot, degree);
		
		rec[0].render();
		rec[1].render();
	}

}
