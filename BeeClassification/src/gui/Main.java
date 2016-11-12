package gui;

public class Main {
	GuiBuilder mainGui;

	public Main() {
		mainGui = new GuiBuilder();
		mainGui.run();
	}

	public static void main(String[] args) {
		new Main();
	}
}