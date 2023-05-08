package com.brainmentors.game.basics;

import javax.swing.JFrame;

import com.brainmentors.game.settings.GameConstants;

public class GameFrame extends JFrame implements GameConstants {
          public GameFrame() throws Exception {
        	  setDefaultCloseOperation(EXIT_ON_CLOSE);
        	  setSize(BOARD_WIDTH, BOARD_HEIGHT);
              setLocationRelativeTo(null);
              setTitle(" Mohit's Game");
              Board board = new Board();
              add(board);
              setVisible(true); 
          }
	public static void main(String[] args) {
          try {
			GameFrame obj = new GameFrame();
		} catch (Exception e) {
			e.printStackTrace();
		}
         
	}

}
