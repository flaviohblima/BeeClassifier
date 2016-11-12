package classification;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

/**
 * 
 * @author Flávio
 *
 *         ScreenPresenter show the experiment results at a frame.
 *
 */
public class ScreenPresenter extends JFrame implements ResultPresenter {

	private JTextPane pane;

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor set all details of the frame.
	 */
	public ScreenPresenter() {
		Font font = new Font("Consolas", Font.PLAIN, 12);
		pane = new JTextPane();
		pane.setFont(font);
		pane.setEditable(false);
		Dimension dimension = system.Parameters.explorer.getSize();
		double width = dimension.getWidth() - ((double) 100);
		double height = dimension.getHeight() - ((double) 50);
		dimension.setSize(width, height);
		pane.setMinimumSize(dimension);

		JScrollPane sp = new JScrollPane(pane);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		sp.setMinimumSize(dimension);
		this.getContentPane().add(sp);

		this.setLocationRelativeTo(system.Parameters.explorer);
		this.setLocation(50, 25);
		this.setMinimumSize(dimension);

		this.setTitle("Results");
		this.setIconImage(system.Parameters.explorer.getIconImage());
		this.setVisible(true);
	}

	/**
	 * Receives a String and print it on the screen.
	 */
	public void setText(String resultsInText) {
		pane.setText(resultsInText);
	}

}
