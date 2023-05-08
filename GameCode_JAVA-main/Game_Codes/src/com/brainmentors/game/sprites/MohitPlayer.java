package com.brainmentors.game.sprites;

public class MohitPlayer extends Player{
      public MohitPlayer() throws Exception {
    	  super(MOHIT_IMAGE);
    	  this.x=200;
      }
      @Override
      protected void kickAction() {
  		isAttacking=true;
      	kick[0] = fullImage.getSubimage(0, 1492, 79, 116);
      	kick[1] = fullImage.getSubimage(78, 1492, 71, 114);
      	kick[2] = fullImage.getSubimage(149, 1491, 103, 120);
      	kick[3] = fullImage.getSubimage(251, 1491, 108, 120);
      	kick[4] = fullImage.getSubimage(358, 1492, 68, 119);
      	kick[5] = fullImage.getSubimage(425, 1491, 68, 118);
      	kick[6] = fullImage.getSubimage(492, 1489, 79, 120);
      	kick[7] = fullImage.getSubimage(62, 1136, 67, 125);
      }
      @Override
      protected void defaultAction() {
    	  isAttacking=false;
      	defaultMove[0] = fullImage.getSubimage(1350, 1135, 82, 120);
      	defaultMove[1] = fullImage.getSubimage(1430, 1135, 81, 120);
      	defaultMove[2] = fullImage.getSubimage(1510, 1134, 96, 121);
      	defaultMove[3] = fullImage.getSubimage(1604, 1135, 87, 119);
      	defaultMove[4] = fullImage.getSubimage(1690, 1134, 95, 123);
      	defaultMove[5] = fullImage.getSubimage(1784, 1134, 69, 122);
      	defaultMove[6] = fullImage.getSubimage(1852, 1133, 69, 123);
      	defaultMove[7] = fullImage.getSubimage(1920, 1133, 69, 125);

      }
	@Override
	protected void hit() {
		 hitMove[0]= fullImage.getSubimage(1316,2368,87,110);
		 hitMove[1]= fullImage.getSubimage(1401,2368,88,113);
		 hitMove[2]= fullImage.getSubimage(2301,2367,88,121);
		 hitMove[3]= fullImage.getSubimage(2387,2366,91,114);
		 hitMove[4]= fullImage.getSubimage(334,2369,91,110);
		 hitMove[5]= fullImage.getSubimage(424,2364,109,104);
		 hitMove[6]= fullImage.getSubimage(532,2371,111,94);
		 hitMove[7]= fullImage.getSubimage(2387,2366,91,114);

	}
  
}
