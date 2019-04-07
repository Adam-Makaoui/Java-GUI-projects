import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuessingGameGUI extends JFrame {
	private JTextField txtGuess; // text field for user's guess
	private JLabel lblOutput; // output to user for too high/low
	private JLabel lblOutput2; // output to user for too high/low
	private int RandomNumber;
	private int numTries = 7;

	/**
	 * Method to check if guess is too high or low calls getText method for txt
	 * boxes on our textbox object
	 */
	public void checkGuess() {
		String guessText = txtGuess.getText(); // get user text from the text box (object)
		numTries--;

		try {
			int theGuess = Integer.parseInt(guessText); // converting the input from string (getText) to an integer
			lblOutput2.setText(""); // empty the out label 2 after we start round 2 of guessing

			if (theGuess > RandomNumber) // too high
				lblOutput.setText(theGuess + " is too large, guess again. (" + numTries + " tries remaining)");

			else if (theGuess < RandomNumber) // too low
				lblOutput.setText(theGuess + " is too low, guess again. (" + numTries + " tries remaining)");

			else { // guessed correctly
				lblOutput.setText(theGuess + " is correct! You win! You only needed " + (7 - numTries) + " tries!");
				lblOutput2.setText("Guess to play again!");
				newGame();
				numTries = 7;
			}
			if (numTries <= 0) { // lose or not?
				javax.swing.JOptionPane.showConfirmDialog(null,
						"Sorry, you ran out of tries " + RandomNumber + " was the correct number. Play Again?");
				lblOutput.setText("GAME OVER, you ran out of tries. The number was " + RandomNumber);
				lblOutput2.setText("Guess to play again!");
				newGame();
				numTries = 7;
			}
		} catch (Exception e) { // Exception is the master classs of all exceptions
			lblOutput.setText("Error, wrong input. Enter an int number between 1 to 100 ");
		} finally { // always done
			txtGuess.requestFocus();// button has focus again
			txtGuess.selectAll(); // UX to auto highlight text for us
		}
	} // end checkGuess

	/**
	 * Starts the game again by generating a new random num between 1-100
	 */
	public void newGame() {
		this.RandomNumber = (int) (Math.random() * 100 + 1); // cast to convert from double to int
	}

	public GuessingGameGUI() {
		getContentPane().setBackground(new Color(255, 204, 204));
		setBackground(new Color(51, 204, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default constructor for GUI (auto-gen)
		getContentPane().setLayout(null);

		JLabel lblAdamsGuessingGame = new JLabel("Adam's Guessing Game");
		lblAdamsGuessingGame.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		lblAdamsGuessingGame.setBounds(0, 23, 434, 27);
		lblAdamsGuessingGame.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblAdamsGuessingGame);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 232, 170));
		panel.setBounds(10, 74, 414, 27);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100: ");
		lblGuessANumber.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGuessANumber.setBounds(22, 8, 237, 14);
		panel.add(lblGuessANumber);
		lblGuessANumber.setHorizontalAlignment(SwingConstants.RIGHT);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // added to check for action //most common is enter key
				checkGuess(); // when action is performed, check guess
			}
		});
		txtGuess.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuess.setBounds(265, 5, 43, 20);
		panel.add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnGuess = new JButton("Guess");
		btnGuess.setFont(new Font("Script MT Bold", Font.BOLD, 16));
		btnGuess.setBackground(new Color(255, 192, 203));
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess(); // event listener to check to see if they entered a guess (button click)
			}
		});
		btnGuess.setBounds(173, 125, 89, 23);
		getContentPane().add(btnGuess);

		lblOutput = new JLabel("Enter a number above and click \"Guess\"");
		lblOutput.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblOutput.setForeground(new Color(255, 0, 0));
		lblOutput.setBackground(new Color(255, 102, 102));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(0, 172, 434, 23);
		getContentPane().add(lblOutput);

		lblOutput2 = new JLabel("");
		lblOutput2.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOutput2.setBounds(148, 219, 138, 17);
		getContentPane().add(lblOutput2);
	}

	public static void main(String[] args) {
		GuessingGameGUI newGame = new GuessingGameGUI(); // creates the GUI and all other class components
		newGame.newGame(); // generates the value in the randomNumber variable
		newGame.setSize(new Dimension(430, 330)); // Without the setSize, it will be display super tiny
		newGame.setVisible(true); // setting the GUI to true to show it
	}
}
