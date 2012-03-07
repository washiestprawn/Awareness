package com.flipflop.game.aware;

import java.util.logging.Logger;

import com.flipflop.utility.logging.LogUtil;

import org.lwjgl.LWJGLException;

public class AwareEntry {
	
	public static final Logger logger = Logger.getLogger("com.flipflop");
	
	
	public static void main(String[] args) {
		LogUtil.initRootLogger(logger);
		try {
			AwareGame game = new AwareGame(1024, 800);
			game.start();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
}
