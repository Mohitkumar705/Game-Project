package com.brainmentors.game.basics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.brainmentors.game.settings.GameConstants;
import com.brainmentors.game.sprites.Player;
import com.brainmentors.game.sprites.Power;
import com.brainmentors.game.sprites.MohitPlayer;
import com.brainmentors.game.sprites.SandeepPlayer;

import jaco.mp3.player.MP3Player;

public class Board extends JPanel implements GameConstants,ActionListener,KeyListener{
	BufferedImage backgroundimage;
	Player Mohit;
	Player Sandeep;
	Timer timer;
	MP3Player player;
	Power player1Power;
	Power player2Power;
	boolean isGameOver;
	Board() throws Exception{

		loadbackground();
	    Mohit = new MohitPlayer();
	    Sandeep = new SandeepPlayer();
	    bindEvents();
        setFocusable(true);
	    gameLoop();
	    player = new MP3Player(Board.class.getResource("gamesong.mp3"));
	    player.setRepeat(true);
	    PlayBackGroundMusic();
	    player1Power =new Power(20,"Mohit Kumar");
	    player2Power=new Power(BOARD_WIDTH/2+200,"Sandeep Kumar");
	}
	public void drawPower(Graphics g) {
		player1Power.draw(g);
		player2Power.draw(g);

		
	}
	 void PlayBackGroundMusic() {
		player.play();
	}
	public void bindEvents(){
		this.addKeyListener(this);
	}
	public void gameLoop() {
		timer = new Timer(DELAY,this);
		timer.start();
	}
	void loadbackground() throws Exception {
		backgroundimage=ImageIO.read(Board.class.getResource(BACKGROUND_IMAGE));
	}
    @Override
    protected void paintComponent(Graphics pen) {
    	super.paintComponent(pen);
        pen.drawImage(backgroundimage, 0,0,BOARD_WIDTH,BOARD_HEIGHT,null );
        displayMessage(pen);
        Mohit.draw(pen);
        Sandeep.draw(pen);
        drawPower(pen);
        playerAttackHit();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		Mohit.fall();
		Sandeep.fall();
          repaint();		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	public void displayMessage(Graphics pen){
		if(isGameOver) {
			pen.setFont(new Font("times",Font.BOLD,50));
			pen.setColor(Color.RED);
		pen.drawString("Game Over......",BOARD_HEIGHT/2+55,BOARD_WIDTH/4);                                
			timer.stop();
		}

	}
	public boolean playerAttackHit() {
		if(isCollide()) {
		if(Mohit.isAttacking()) {
			Sandeep.setAction(HIT);
			Sandeep.setPower(Sandeep.getPower()-8);
			player2Power.setW(player2Power.getW()-8);
		}
		else if(Sandeep.isAttacking()) {
			Mohit.setAction(HIT);
			Mohit.setPower(Mohit.getPower()-7);
			player1Power.setW(player1Power.getW()-7);
		}
		else if(Mohit.isAttacking()&& Sandeep.isAttacking()) {
			Sandeep.setAction(HIT);
			Mohit.setAction(HIT);
			Sandeep.setPower(Sandeep.getPower()-8);
			player2Power.setW(player1Power.getW()-8);
			Mohit.setPower(Mohit.getPower()-7);
			player1Power.setW(player1Power.getW()-7);
		}
		if(Mohit.getPower()<=0||Sandeep.getPower()<=0) {
			isGameOver = true;
		}
		return true;
		}
		return false;
	}
	public boolean isCollide() {
		int xDistance= Math.abs(Mohit.getX()-Sandeep.getX());
		int yDistance = Math.abs(Mohit.getY()-Sandeep.getY());
		int maxH = Math.max(Mohit.getH(),Sandeep.getH());
		int maxW = Math.max(Mohit.getW(),Sandeep.getW());
		return xDistance<=maxW-25&& yDistance<=maxH;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_S) {
			Mohit.setAction(KICK);
			Mohit.setAttacking(true);
		}
		else if(e.getKeyCode()==KeyEvent.VK_D) {
			Mohit.setSpeed(SPEED);
			Mohit.move();
		}
		else if(e.getKeyCode()==KeyEvent.VK_A) {
			Mohit.setSpeed(SPEED*-1);
			Mohit.move();
		     }
		else if(e.getKeyCode()==KeyEvent.VK_W) {
			Mohit.jump();
		}
		else if(e.getKeyCode()==KeyEvent.VK_I) {
			Sandeep.jump();
		}
		else if(e.getKeyCode()==KeyEvent.VK_K) {
			Sandeep.setAction(KICK);
			Sandeep.setAttacking(true);
		}
		else if(e.getKeyCode()==KeyEvent.VK_J) {
			Sandeep.setSpeed(SPEED*-1);
			Sandeep.move();
		}
		else if(e.getKeyCode()==KeyEvent.VK_L) {
			Sandeep.setSpeed(SPEED);
			Sandeep.move();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
    
}
