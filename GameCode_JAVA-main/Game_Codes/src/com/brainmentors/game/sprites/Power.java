package com.brainmentors.game.sprites;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Power {
   private int x;
   private int y;
   private int w;
   private int h;
   private String playerName;
   final int FIX_WIDTH;
   public Power(int x,String playerName) {
	   this.x=x;
	   this.playerName = playerName;
	   y=70;
	   w=500;
	   FIX_WIDTH = w;
   }
public int getW() {
	return w;
}
public void setW(int w) {
	this.w = w;
}
   public void draw(Graphics g) {
	   g.setColor(Color.RED);
	   g.fillRect(x, 70, FIX_WIDTH, 20);
	   g.setColor(Color.ORANGE);
	   g.fillRect(x, 70, w, 20);
	   g.setColor(Color.WHITE);
	   g.setFont(new Font("Times",Font.BOLD,20));
	   g.drawString(playerName,x, y+72);
   }
}
