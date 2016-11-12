package gui.explorer;

import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import gui.explorer.listeners.EventVisualizeData;
import system.Constants;
import system.Parameters;

public class Explorer extends JFrame implements Observer {

	/**
	 * Serialization number.
	 */
	private static final long serialVersionUID = 1L;

	private JTabbedPane tabbedPane;
	private DataSetPanel dataSetPanel;
	private ClassificationTestPanel classificationTestPanel;
	private ClassifierTrainingPanel classifierTrainingPanel;
	private ClassifierUsePanel classifierUsePanel;
	private EventVisualizeData eventVisualizeData;

	public Explorer() {
		this.setSize(700, 500);
		this.setLocation(10, 10);
		this.setIconImage((new ImageIcon(System.getProperty("user.dir") + "\\Icon1.png")).getImage());

		setTabbedPane();
		addTabsListener();
	}

	public void setTabbedPane() {
		tabbedPane = new JTabbedPane();

		dataSetPanel = system.Parameters.dataSetPanel;
		classificationTestPanel = system.Parameters.classificationTestPanel;
		classifierTrainingPanel = system.Parameters.classifierTrainingPanel;
		classifierUsePanel = system.Parameters.classifierUsePanel;

		tabbedPane.addTab("DataSet", dataSetPanel);
		tabbedPane.addTab("Classification Test", classificationTestPanel);
		tabbedPane.addTab("Classifier Training", classifierTrainingPanel);
		tabbedPane.addTab("Classifier Use", classifierUsePanel);
		this.add(tabbedPane);
	}

	public void addTabsListener() {
		eventVisualizeData = dataSetPanel.getEventVisualizeData();
		eventVisualizeData.addObserver(this);
		update(eventVisualizeData, eventVisualizeData.getDataSetOpened());
	}

	@Override
	public void update(Observable o, Object arg) {
		boolean dataSetOpened = (boolean) arg;
		system.Parameters.dataSetOpened = dataSetOpened;
		tabbedPane.setEnabledAt(1, dataSetOpened);
		tabbedPane.setEnabledAt(2, dataSetOpened);
		tabbedPane.setEnabledAt(3, dataSetOpened);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Constants cts = new Constants();
		Parameters param = new Parameters();

		JFrame frame = new Explorer();
		frame.setVisible(true);

		frame.setTitle("Test to view the Data Set panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
