package window;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import main.Thread_Operaciones;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class Window_Life_Game<TableEditor>{

	private JFrame frame;
	
	private int size = 100;
	
	private boolean live;
	private boolean click;
	private boolean inicio;
	private ArrayList<ArrayList<JTextField>> celdas;
	
	private Thread_Operaciones accion;

	/**
	 * Create the application.
	 */
	public Window_Life_Game(int size) {
		this.size = size;
		initialize();
	}
	
	/**
	 * Set visible the frame
	 */
	public void show() {
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.live = true;
		this.click = false;
		this.inicio = false;
		
		frame = new JFrame();
		//frame.setResizable(false);
		frame.setBounds(500, 0, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Juego");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Tama\u00F1o");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Reinicio");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Pincel");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Vida");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				live = true;
			}
		});
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Muerte");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				live = false;
			}
		});
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Inicio");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (inicio == false) {
					inicio = true;
					accion.start();
				}
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pausa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (inicio == true) {
					inicio = false;
					accion.setInicio(inicio);
					accion = new Thread_Operaciones(inicio, size, celdas);
				}
			}
		});
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new GridLayout(this.size, this.size, 0, 0));
		scrollPane.setViewportView(panel_2);
		
		celdas = new ArrayList<ArrayList<JTextField>>();
		
		for (int i = 0; i < this.size; i++) {
			
			ArrayList<JTextField> celda = new ArrayList<JTextField>();
			
			for (int j= 0; j < this.size; j++) {
				JTextField aux = new JTextField();
				aux.setPreferredSize(new Dimension(1,1));
				aux.setEditable(click);
				aux.setBorder(null);

				aux.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
					}

					@Override
					public void mousePressed(MouseEvent e) {
						click = true;
						
						if (live) {
							aux.setBackground(Color.WHITE);
						} else {
							aux.setBackground(Color.BLACK);
						}
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						click = false;
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						if (click) {
							if (live) {
								aux.setBackground(Color.WHITE);
							} else {
								aux.setBackground(Color.BLACK);
							}
						}
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				
				panel_2.add(aux);
				aux.setBackground(Color.BLACK);
				celda.add(aux);
			}
			
			celdas.add(celda);
		}

		this.accion = new Thread_Operaciones(inicio, size, celdas);
	}
}
