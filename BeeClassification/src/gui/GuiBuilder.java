package gui;

import javax.swing.JFrame;

import gui.explorer.Explorer;
import system.Constants;
import system.Parameters;

public class GuiBuilder extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7007404454290775965L;
	private Explorer explorer;

	@SuppressWarnings("unused")
	public GuiBuilder() {
		Constants constants = new Constants();
		Parameters parameters = new Parameters();
		explorer = new Explorer();
	}

	public void run() {
		explorer.setVisible(true);
		explorer.setTitle("Bee Classifier - LTI - Escola Politécnica");
		explorer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		system.Parameters.explorer = explorer;
	}

	public static void main(String[] args) {
		GuiBuilder mainGui = new GuiBuilder();
		mainGui.run();
	}

}
