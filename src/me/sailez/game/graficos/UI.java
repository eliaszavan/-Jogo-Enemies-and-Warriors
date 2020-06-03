package me.sailez.game.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import me.sailez.game.entities.Enemy;
import me.sailez.game.main.Game;

public class UI {

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(8, 4, 70, 8);
		g.setColor(Color.green);
		g.fillRect(8, 4, (int) ((Game.player.life / Game.player.maxlife) * 70), 8);
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.PLAIN, 8));
		g.drawString((int) Game.player.life + "/" + (int) Game.player.maxlife, 30, 11);
	}

	public void ER(Graphics g) {
		if ((Game.gameState == "NORMAL")) {
			g.setColor(Color.YELLOW);
			g.setFont(new Font("arial", Font.BOLD, 10));
			g.drawString("Munição: " + Game.player.ammo, 180, 10);
			g.setColor(Color.ORANGE);
			g.setFont(new Font("arial", Font.BOLD, 10));
			g.drawString("Inimigos restantes: " + Enemy.enemys, 75, 155);
		}
	}
}
