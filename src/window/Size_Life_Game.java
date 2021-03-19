package window;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import java.awt.Component;
import javax.swing.Box;
import java.awt.EventQueue;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class Size_Life_Game extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JSpinner spinnerSize;

	/**
	 * Create the dialog.
	 */
	public Size_Life_Game() {
		setTitle("Tama\u00F1o del juego");
		setBounds(500, 300, 450, 300);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.WEST);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				Component horizontalStrut = Box.createHorizontalStrut(20);
				panel.add(horizontalStrut);
			}
			{
				Component horizontalStrut = Box.createHorizontalStrut(20);
				panel.add(horizontalStrut);
			}
			{
				Component horizontalStrut = Box.createHorizontalStrut(20);
				panel.add(horizontalStrut);
			}
			{
				Component horizontalStrut = Box.createHorizontalStrut(20);
				panel.add(horizontalStrut);
			}
			{
				Box verticalBox = Box.createVerticalBox();
				panel.add(verticalBox);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.EAST);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				Component horizontalStrut = Box.createHorizontalStrut(20);
				panel.add(horizontalStrut);
			}
			{
				Component horizontalStrut = Box.createHorizontalStrut(20);
				panel.add(horizontalStrut);
			}
			{
				Component horizontalStrut = Box.createHorizontalStrut(20);
				panel.add(horizontalStrut);
			}
			{
				Component horizontalStrut = Box.createHorizontalStrut(20);
				panel.add(horizontalStrut);
			}
		}
		{
			Box verticalBox = Box.createVerticalBox();
			contentPanel.add(verticalBox, BorderLayout.NORTH);
			{
				Component verticalStrut = Box.createVerticalStrut(20);
				verticalBox.add(verticalStrut);
			}
			{
				Component verticalStrut = Box.createVerticalStrut(20);
				verticalBox.add(verticalStrut);
			}
			{
				JLabel lblNewLabel = new JLabel("   Introduce el valor de las filas y las columas del juego.");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				verticalBox.add(lblNewLabel);
			}
			{
				Component verticalStrut = Box.createVerticalStrut(20);
				verticalBox.add(verticalStrut);
			}
			{
				Component verticalStrut = Box.createVerticalStrut(20);
				verticalBox.add(verticalStrut);
			}
		}
		{
			Box verticalBox = Box.createVerticalBox();
			contentPanel.add(verticalBox, BorderLayout.SOUTH);
			{
				Component verticalStrut = Box.createVerticalStrut(20);
				verticalBox.add(verticalStrut);
			}
			{
				Component verticalStrut = Box.createVerticalStrut(20);
				verticalBox.add(verticalStrut);
			}
			{
				Component verticalStrut = Box.createVerticalStrut(20);
				verticalBox.add(verticalStrut);
			}
			{
				Component verticalStrut = Box.createVerticalStrut(20);
				verticalBox.add(verticalStrut);
			}
		}
		{
			Box horizontalBox_1 = Box.createHorizontalBox();
			contentPanel.add(horizontalBox_1);
			{
				Box verticalBox = Box.createVerticalBox();
				horizontalBox_1.add(verticalBox);
				{
					Box horizontalBox = Box.createHorizontalBox();
					verticalBox.add(horizontalBox);
					{
						JLabel lblNewLabel_1 = new JLabel("Tama\u00F1o");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
						horizontalBox.add(lblNewLabel_1);
					}
				}
				{
					Box horizontalBox = Box.createHorizontalBox();
					verticalBox.add(horizontalBox);
				}
			}
			{
				Box verticalBox = Box.createVerticalBox();
				horizontalBox_1.add(verticalBox);
				{
					Box horizontalBox = Box.createHorizontalBox();
					verticalBox.add(horizontalBox);
					{
						Component horizontalStrut = Box.createHorizontalStrut(20);
						horizontalBox.add(horizontalStrut);
					}
					{
						this.spinnerSize = new JSpinner();
						spinnerSize.setModel(new SpinnerNumberModel(50, 1, 200, 1));
						horizontalBox.add(spinnerSize);
					}
				}
				{
					Box horizontalBox = Box.createHorizontalBox();
					verticalBox.add(horizontalBox);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						startMainWindow((Integer) spinnerSize.getValue());
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	/**
	 * Set visible the dialog
	 */
	public void showWindow() {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * Create the principal window
	 */
	private void startMainWindow(int size) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window_Life_Game window = new Window_Life_Game(size);
					window.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
