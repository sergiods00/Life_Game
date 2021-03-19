package main;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTextField;

public class Thread_Operaciones extends Thread{
	
	private boolean inicio;
	private int size;
	private ArrayList<ArrayList<JTextField>> celdas;
	
	public boolean isInicio() {
		return inicio;
	}

	public void setInicio(boolean inicio) {
		this.inicio = inicio;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ArrayList<ArrayList<JTextField>> getCeldas() {
		return celdas;
	}

	public void setCeldas(ArrayList<ArrayList<JTextField>> celdas) {
		this.celdas = celdas;
	}

	
	public Thread_Operaciones(boolean inicio, int size, ArrayList<ArrayList<JTextField>> celdas) {
		this.inicio = inicio;
		this.size = size;
		this.celdas = celdas;
	}
	
	public void run() {
		inicio = true;
		
		
		while(inicio) {
			
			ArrayList<ArrayList<Integer>> colores = new ArrayList<ArrayList<Integer>>();
		
			for (int i = 0; i < size; i++) {
				
				ArrayList<Integer> color = new ArrayList<Integer>();
				
				for (int j = 0; j < size; j++) {
					
					int vecinos = 0;
					int minI = (i-1) % size, minJ = (j-1) % size;
					
					if (minI < 0) {
						minI += size;
					}
					if (minJ < 0) {
						minJ += size;
					}
					
					if (celdas.get(minI).get((j+1) % size).getBackground().getRGB() == Color.WHITE.getRGB()) vecinos++;
					if (celdas.get(minI).get(j).getBackground().getRGB() == Color.WHITE.getRGB()) vecinos++;
					if (celdas.get(minI).get(minJ).getBackground().getRGB() == Color.WHITE.getRGB()) vecinos++;
					if (celdas.get(i).get(minJ).getBackground().getRGB() == Color.WHITE.getRGB()) vecinos++;
					if (celdas.get(i).get((j+1) % size).getBackground().getRGB() == Color.WHITE.getRGB()) vecinos++;
					if (celdas.get((i+1) % size).get((j+1) % size).getBackground().getRGB() == Color.WHITE.getRGB()) vecinos++;
					if (celdas.get((i+1) % size).get(j).getBackground().getRGB() == Color.WHITE.getRGB()) vecinos++;
					if (celdas.get((i+1) % size).get(minJ).getBackground().getRGB() == Color.WHITE.getRGB()) vecinos++;
					
					if (vecinos == 3 && celdas.get(i).get(j).getBackground().getRGB() == Color.BLACK.getRGB()) {
						color.add(1);
					} else if ((vecinos > 3 || vecinos < 2) && celdas.get(i).get(j).getBackground().getRGB() == Color.WHITE.getRGB()) {
						color.add(2);
					} else {
						color.add(0);
					}
				}
				
				colores.add(color);
			}
			
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (colores.get(i).get(j) == 1) {
						celdas.get(i).get(j).setBackground(Color.WHITE);
					} else if (colores.get(i).get(j) == 2) {
						celdas.get(i).get(j).setBackground(Color.BLACK);
					}
				}
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
