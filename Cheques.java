package porcentajeCheques;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import java.math.BigDecimal;

public class Cheques {

	private JFrame frame;
	private JTextField textFieldCantidad;
	private JTextField textFieldTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cheques window = new Cheques();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cheques() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 255, 102));
		frame.setBounds(100, 100, 400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(112, 200, 150, 35);
		frame.getContentPane().add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		JLabel lblBienvenido = new JLabel("Bienvenido a la Calculadora");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setForeground(new Color(0, 0, 0));
		lblBienvenido.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblBienvenido.setBounds(25, 11, 335, 30);
		frame.getContentPane().add(lblBienvenido);
		
		JLabel lblDePorcentajes = new JLabel("de Porcentajes!");
		lblDePorcentajes.setHorizontalAlignment(SwingConstants.CENTER);
		lblDePorcentajes.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblDePorcentajes.setBounds(25, 35, 335, 30);
		frame.getContentPane().add(lblDePorcentajes);
		
		JLabel lblCantidadDelCheque = new JLabel("Cantidad del Cheque");
		lblCantidadDelCheque.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadDelCheque.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCantidadDelCheque.setBounds(10, 175, 350, 30);
		frame.getContentPane().add(lblCantidadDelCheque);
		
		JLabel lblinstructions = new JLabel("Ingresa la cantidad del cheque para descontar 1%.");
		lblinstructions.setHorizontalAlignment(SwingConstants.CENTER);
		lblinstructions.setFont(new Font("Arial", Font.PLAIN, 14));
		lblinstructions.setBounds(25, 75, 335, 35);
		frame.getContentPane().add(lblinstructions);
		
		JButton btnNewButton = new JButton("Listo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Initializes all variables
				BigDecimal cheque = new BigDecimal(textFieldCantidad.getText());
				BigDecimal porcentaje = new BigDecimal("0.01");
				BigDecimal total = new BigDecimal("0.00");
				
				
				try {
					
					//Math to calculate 1% subtracted
					total = (cheque.subtract(cheque.multiply(porcentaje)));
					
					//Rounds total to two decimal places depending on third decimal place
					total = total.setScale(2, BigDecimal.ROUND_HALF_EVEN);
					
					//Sets total to textField for Total
					textFieldTotal.setText(total.toString());
					
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Por favor ingrese un numero valido");
					}
			}
		});
		btnNewButton.setBounds(140, 250, 100, 50);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Arial", Font.BOLD, 16));
		lblTotal.setBounds(10, 325, 50, 30);
		frame.getContentPane().add(lblTotal);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setColumns(10);
		textFieldTotal.setBounds(115, 325, 150, 35);
		frame.getContentPane().add(textFieldTotal);
		
		JLabel lblDollarSign = new JLabel("$");
		lblDollarSign.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblDollarSign.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDollarSign.setBounds(90, 200, 20, 35);
		frame.getContentPane().add(lblDollarSign);
		
		JLabel label = new JLabel("$");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Arial Black", Font.BOLD, 20));
		label.setBounds(90, 325, 20, 35);
		frame.getContentPane().add(label);
	}
}
