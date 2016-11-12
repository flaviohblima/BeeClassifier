package gui.explorer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import gui.explorer.listeners.EventSearch;
import gui.explorer.listeners.EventValidate;
import gui.explorer.listeners.EventVisualizeData;
import system.Constants;
import system.Parameters;

/**
 * 
 * @author Flávio
 *
 */
public class DataSetPanel extends JPanel implements Tab {

	/**
	 * Serialization number.
	 */
	private static final long serialVersionUID = 1L;
	private boolean dataSetOpened;
	public EventVisualizeData eventVisualizeData;

	// panelDataSetFile components.
	private JPanel panelDataSetFile;
	private JLabel lblPath;
	private JTextField pathTextField;
	private JButton btnSearch;
	private JLabel lblValidatePath;
	private JButton btnOpenFile;

	// panelVisualizeData components.
	private JPanel panelVisualizeData;
	private JScrollPane tableScrollPane;

	public EventVisualizeData getEventVisualizeData() {
		return eventVisualizeData;
	}

	/**
	 * 
	 */
	public DataSetPanel() {

		dataSetOpened = system.Parameters.dataSetOpened;
		/*
		 * Initializing panelDataSetFile components.
		 */
		panelDataSetFile = new JPanel();
		panelDataSetFile.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("DataSet file"),
				BorderFactory.createEmptyBorder(0, 5, 5, 5)));
		lblPath = new JLabel("Path:");
		pathTextField = new JTextField(10);
		btnSearch = new JButton("Search");
		lblValidatePath = new JLabel("");
		btnOpenFile = new JButton("Open file");

		/*
		 * Initializing panelVisualizeData components.
		 */
		panelVisualizeData = new JPanel();
		panelVisualizeData.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Visualize DataSet"), BorderFactory.createEmptyBorder(0, 5, 5, 5)));
		tableScrollPane = new JScrollPane();

		buildPanel();
		setListeners();

	}

	/**
	 * 
	 */
	public void buildPanel() {
		// DataSet layout.
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { Double.MIN_VALUE, 1.0 };
		setLayout(gridBagLayout);

		/*
		 * panelDataSetFile settings.
		 */
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panelDataSetFile, gbc_panel_1);

		// panelDataSetFile layout.
		GroupLayout gl_panel_1 = new GroupLayout(panelDataSetFile);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(pathTextField, GroupLayout.PREFERRED_SIZE, 341,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnSearch)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnOpenFile))
						.addComponent(lblPath).addComponent(lblValidatePath))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(lblPath)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(pathTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSearch).addComponent(btnOpenFile))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblValidatePath)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelDataSetFile.setLayout(gl_panel_1);

		/*
		 * panelVisualizeData settings.
		 */
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		add(panelVisualizeData, gbc_panel_2);

		// panelVisualizeData layout.
		GroupLayout gl_panel_2 = new GroupLayout(panelVisualizeData);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addComponent(tableScrollPane,
				GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addComponent(tableScrollPane,
				GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE));
		panelVisualizeData.setLayout(gl_panel_2);
	}

	public void setListeners() {
		/**
		 * Mensagens do panelDataSetFile.
		 */
		/*
		 * Mouse parado em cima do JTextField faz a mensagem seguinte aparecer:
		 * "Type a path to file that contains the data set. The file must be CSV
		 * type."
		 */
		pathTextField.setToolTipText("Type a path to file that contains the data set. The file must be CSV type.");

		/*
		 * Mouse parado em cima do botão Search faz a mensagem seguinte
		 * aparecer: "Click to search a CSV file."
		 */
		btnSearch.setToolTipText("Click to search a CSV file.");

		/*
		 * Mouse parado em cima do botão OpenFile faz a mensagem seguinte
		 * aparecer: "Click to open the data set."
		 */
		btnOpenFile.setToolTipText("Click to open the data set.");

		/**
		 * Ações do panelDataSetFile.
		 */
		/*
		 * Ao apertar o botão "Search", abrir uma tela para o usuário procurar o
		 * arquivo desejado.
		 */
		EventSearch eventSearchCsv = new EventSearch(btnSearch, pathTextField, "CSV", "csv");
		btnSearch.addActionListener(eventSearchCsv);

		/*
		 * Se o caminho para o arquivo for inválido (não existir), aparece a
		 * mensagem: "Invalid Path."
		 *
		 * Se o arquivo não for do tipo CSV, aparece a mensagem ao lado do botão
		 * Search: "File isn't CSV type."
		 * 
		 * Se o caminho para o arquivo for válido e o arquivo for do tipo CSV:
		 * ------> aparece a mensagem ao lado do botão Search: "Valid file."
		 * --------> O botão OpenFile deve ser ativado.
		 * 
		 * -> As outras guias na página principal devem ser ativadas com o
		 * dataSetOpened.
		 * 
		 * -> O DataSet da Classe "Parameters" deve ser setado.
		 */
		EventValidate eventValidateFile = new EventValidate(pathTextField, lblValidatePath, "CSV", btnOpenFile);
		pathTextField.getDocument().addDocumentListener(eventValidateFile);

		/*
		 * Ao apertar o botão OpenFile, o data set deve aparecer no panel
		 * "Visualize DataSet".
		 */
		eventVisualizeData = new EventVisualizeData(btnOpenFile, tableScrollPane, pathTextField);
		eventVisualizeData.setDataSetOpened(dataSetOpened);
		btnOpenFile.addActionListener(eventVisualizeData);

		/**
		 * Mensagens do panelVisualizeData.
		 */
		/*
		 * Mouse parado em cima da JTable faz a mensagem seguinte aparecer:
		 * "Data Set file chosen above."
		 */
		tableScrollPane.setToolTipText("Data Set file chosen above.");
	}

	/**
	 * 
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		JPanel panel = new DataSetPanel();
		JFrame frame = new JFrame();

		frame.getContentPane().add(panel);
		panel.setVisible(true);

		frame.setIconImage((new ImageIcon(System.getProperty("user.dir") + "\\Icon1.png")).getImage());
		frame.setVisible(true);

		frame.setSize(600, 400);
		frame.setLocation(400, 200);

		frame.setTitle("Test to view the Data Set panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Parameters param = new Parameters();
		Constants cts = new Constants();
	}
}