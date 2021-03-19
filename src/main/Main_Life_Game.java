package main;

import java.awt.EventQueue;

import javax.swing.JDialog;

import window.Size_Life_Game;
import window.Window_Life_Game;

public class Main_Life_Game {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Size_Life_Game dialog = new Size_Life_Game();
					dialog.showWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
