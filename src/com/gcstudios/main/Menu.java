package com.gcstudios.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Menu {

	public String[] options = {"INICIAR JOGO","CARREGAR JOGO","FECHAR"};
	
	public int currentOption = 0;
	public int maxOption = options.length - 1;
	
	public boolean up,down,enter;
	
	public boolean pause = false;
	
	
	public void tick() {
		if(up) {
			up = false;
			currentOption--;
			if(currentOption < 0)
				currentOption = maxOption;
		}
		if(down) {
			down = false;
			currentOption++;
			if(currentOption > maxOption)
				currentOption = 0;
		}
		if(enter) {
			enter = false;
			if(options[currentOption] == "INICIAR JOGO" || options[currentOption] == "CONTINUAR") {
				Game.gameState = "NORMAL";
				pause = false;
			}else if(options[currentOption] == "FECHAR") {
				System.exit(1);
			}
		}
	}
	
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		//g2.setColor(new Color(0,0,0,100));
		//g2.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial",Font.BOLD,36));
		
		g.drawString("« SaileZ »", (Game.WIDTH*Game.SCALE) / 2 - 55, (Game.HEIGHT*Game.SCALE) / 2 - 160);
		
		//Opcoes de menu
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.BOLD,24));
		if(pause == false)
			g.drawString("INICIAR JOGO", (Game.WIDTH*Game.SCALE) / 2 - 55, 160);
		else
			g.drawString("RESUMIR", (Game.WIDTH*Game.SCALE) / 2 - 40, 160);
		g.drawString("CARREGAR JOGO", (Game.WIDTH*Game.SCALE) / 2 - 80, 200);
		g.drawString("FECHAR", (Game.WIDTH*Game.SCALE) / 2 - 15, 240);
		
		if(options[currentOption] == "INICIAR JOGO") {
			g.drawString("➦", (Game.WIDTH*Game.SCALE) / 2 - 90, 160);
		}else if(options[currentOption] == "CARREGAR JOGO") {
			g.drawString("➦", (Game.WIDTH*Game.SCALE) / 2 - 90, 200);
		}else if(options[currentOption] == "FECHAR") {
			g.drawString("➦", (Game.WIDTH*Game.SCALE) / 2 - 40, 240);
		}
	}
	
}
