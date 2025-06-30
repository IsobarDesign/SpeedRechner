package speed;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

public class SpeedCalculator extends JFrame  {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtSpeed1 = new JTextField(5);
	private JTextField txtSpeed2 = new JTextField(5);
	private JTextField txtSpeed3 = new JTextField(5);
	private JTextField txtSpeed4 = new JTextField(5);
	private JLabel lblResult = new JLabel("Ergebnis: ");
	
	private JRadioButton rAdd = new JRadioButton("Addieren");
	private JRadioButton rSub = new JRadioButton("Subtrahieren");
	private JRadioButton rMul = new JRadioButton("Multiplizieren");
	private JRadioButton rDiv = new JRadioButton("Dividieren");
	
	private ButtonGroup group = new ButtonGroup();
	private JButton btnCalculate = new JButton("Berechnen");
	
	public SpeedCalculator() {
		setTitle("Internet-Geschwindigkeitsrechner");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,300);
		setLayout(new GridLayout(7,2));
		
		
		
		//Eingabefelder 
		add(new JLabel ("Geschwindigkeit 1 (Mbit/s):"));
		add(txtSpeed1);
		add(new JLabel ("Geschwindigkeit 2 (Mbit/s):"));
		add(txtSpeed2);
		add(new JLabel("Geschwindigkeit 3 (Mbit/S):"));
		add(txtSpeed3);
		add(new JLabel("Geschwindigkeit 3 (Mbit/s): "));
		add(txtSpeed4);
		
		
		//Radio Buttons
		
		group.add(rAdd);
		group.add(rSub);
		group.add(rMul);
		group.add(rDiv);
		
		rAdd.setSelected(true);
		
		add(rAdd);
		add(rSub);
		add(rMul);
		add(rDiv);
		
		//Berechnen-Button
		
		add(btnCalculate);
		add(lblResult);
		
		btnCalculate.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				berechne();
			}
		});
			setVisible(true);

		}
		
		private void berechne() {
			try {
				double s1 = Double.parseDouble(txtSpeed1.getText());
				double s2 = Double.parseDouble(txtSpeed2.getText());
				double s3 = Double.parseDouble(txtSpeed3.getText());
				double s4 = Double.parseDouble(txtSpeed4.getText());
				
				double result = 0;
				
				if (rAdd.isSelected()) {
					result = s1 + s2 + s3 + s4;
				}else if(rSub.isSelected()) {
					result = s1 - s2 - s3 - s4;
				}else if (rMul.isSelected()) {
					result = s1* s2 * s3 * s4;
					
				}else if(rDiv.isSelected()) {
					if(s2 == 0 || s3 == 0 || s4 == 0) {
						throw new ArithmeticException("Division durch 0");
					}
					result = s1/s2/s3/s4 ;
				}
				
			lblResult.setText("Ergebnis: " + result);
			
			} catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(this, "Bitte gültige Zahlen eingeben!", "Fehler", JOptionPane.ERROR_MESSAGE);
	        } catch (ArithmeticException ex) {
	            JOptionPane.showMessageDialog(this, ex.getMessage(), "Rechenfehler", JOptionPane.ERROR_MESSAGE);
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(this, "Unbekannter Fehler: " + ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    public static void main(String[] args) {
	        new SpeedCalculator();
	    }
	}
