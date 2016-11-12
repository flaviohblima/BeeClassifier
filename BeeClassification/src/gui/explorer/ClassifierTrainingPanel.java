package gui.explorer;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import gui.explorer.listeners.EvtActivFeatSelTrainingPanel;
import gui.explorer.listeners.EventBuildClassifier;
import gui.explorer.listeners.EventChoosenAlgorithm;
import gui.explorer.listeners.EventChoosenClassifier;
import gui.explorer.listeners.EventClassifierSettings;
import gui.explorer.listeners.EventSaveClassifier;
import gui.explorer.listeners.EventVisualizeFeatureSelection;

/**
 * 
 * @author Flávio
 *
 */
public class ClassifierTrainingPanel extends JPanel implements Tab {

	/**
	 * Serialization number.
	 */
	private static final long serialVersionUID = 1L;

	// panelFeatureSelection components.
	private JPanel panelFeatureSelection;
	private JCheckBox chckbxActivate;
	private JLabel lblAlgorithm;
	private JComboBox<String> comboBoxAlgorithm;
	private JButton btnResults;
	private JLabel lblMaxNumberOf;
	private JTextField maxFeatTextField;

	// panelBuildingClassifier components.
	private JPanel panelBuildingClassifier;
	private JLabel lblClassifier;
	private JComboBox<String> comboBoxClassifier;
	private JButton btnBuildClassifier;
	private JButton btnSave;
	private JButton btnSettings;

	/**
	 * 
	 */
	public ClassifierTrainingPanel() {
		/*
		 * Initializing panelFeatureSelection components.
		 */
		panelFeatureSelection = new JPanel();
		panelFeatureSelection.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Feature Selection"), BorderFactory.createEmptyBorder(0, 5, 5, 5)));
		chckbxActivate = new JCheckBox("Activate");
		lblAlgorithm = new JLabel("Algorithm:");
		DefaultComboBoxModel<String> comboAlgModel = new DefaultComboBoxModel<String>(
				system.Constants.algorithmsClasses);
		comboBoxAlgorithm = new JComboBox<String>(comboAlgModel);
		comboBoxAlgorithm.setBackground(new Color(255, 255, 255));
		btnResults = new JButton("Results");
		lblMaxNumberOf = new JLabel("Max number of features:");
		maxFeatTextField = new JTextField(10);

		/*
		 * Initializing panelBuildingClassifier components.
		 */
		panelBuildingClassifier = new JPanel();
		panelBuildingClassifier.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Building Classifier"), BorderFactory.createEmptyBorder(0, 5, 5, 5)));
		lblClassifier = new JLabel("Classifier:");
		comboAlgModel = new DefaultComboBoxModel<String>(system.Constants.classifiersNames);
		comboBoxClassifier = new JComboBox<String>(comboAlgModel);
		comboBoxClassifier.setBackground(new Color(255, 255, 255));
		btnSettings = new JButton("Settings");
		btnBuildClassifier = new JButton("Build Classifier");
		btnSave = new JButton("Save Classifier");

		buildPanel();
		setListeners();
	}

	/**
	 * 
	 */
	public void buildPanel() {
		// ClassifierTraining layout.
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		/*
		 * panelFeatureSelection settings.
		 */
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panelFeatureSelection, gbc_panel_1);

		// panelFeatureSelection layout.
		GroupLayout gl_panel_1 = new GroupLayout(panelFeatureSelection);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(chckbxActivate)
								.addComponent(lblAlgorithm)
								.addComponent(maxFeatTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxAlgorithm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addComponent(btnResults)
								.addComponent(lblMaxNumberOf)))
						.addContainerGap(16, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(chckbxActivate)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblAlgorithm)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(comboBoxAlgorithm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblMaxNumberOf)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(maxFeatTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnResults)
						.addContainerGap(119, Short.MAX_VALUE)));
		panelFeatureSelection.setLayout(gl_panel_1);

		/*
		 * panelBuildingClassifier settings.
		 */
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 2;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		add(panelBuildingClassifier, gbc_panel_2);

		// panelBuildingClassifier layout.
		GroupLayout gl_panel_2 = new GroupLayout(panelBuildingClassifier);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblClassifier)
						.addComponent(comboBoxClassifier, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(btnSettings)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSave)
								.addComponent(btnBuildClassifier))))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblClassifier)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBoxClassifier, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSettings)
						.addComponent(btnBuildClassifier))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSave)
					.addContainerGap(147, Short.MAX_VALUE))
		);
		panelBuildingClassifier.setLayout(gl_panel_2);
	}

	public void setListeners() {
		/**
		 * Ações do panelFeatureSelection:
		 */
		/*
		 * Caso a JCheckBox "Activate" seja selecionada, todos os JComponents
		 * abaixo dela devem ser acionados.
		 */
		EvtActivFeatSelTrainingPanel activateFeatSel = new EvtActivFeatSelTrainingPanel(chckbxActivate, btnResults,
				comboBoxAlgorithm, lblAlgorithm, maxFeatTextField, lblMaxNumberOf);
		chckbxActivate.addItemListener(activateFeatSel);

		/*
		 * Setar o Algorithm escolhido na Classe "Parameters".
		 */
		EventChoosenAlgorithm eventChoosenAlgorithm = new EventChoosenAlgorithm(comboBoxAlgorithm,
				this.getClass().getSimpleName());
		comboBoxAlgorithm.addActionListener(eventChoosenAlgorithm);

		/*
		 * Ao apertar o botão "Results" fazer uma tela nova aparecer com os
		 * dados da "Feature Selection".
		 * 
		 * Setar o número MaxFeat na Classe "Parameters".
		 */
		EventVisualizeFeatureSelection eventVisualizeResults = new EventVisualizeFeatureSelection(btnResults,
				maxFeatTextField, this.getClass().getSimpleName());
		btnResults.addActionListener(eventVisualizeResults);

		/**
		 * Mensagens do panelFeatureSelection:
		 */
		/*
		 * Mouse parado em cima do JCheckBox "Activate" faz a mensagem seguinte
		 * aparecer:
		 * "Activates the feature selection on classifiers evaluation."
		 */
		chckbxActivate.setToolTipText("Activates the feature selection on classifiers evaluation.");

		/*
		 * Mouse parado em cima do JComboBox "Algorithm" faz a mensagem seguinte
		 * aparecer:
		 * "Choose a algorithm to evaluate the most important features in the classification."
		 */
		comboBoxAlgorithm
				.setToolTipText("Choose a algorithm to evaluate the most important features in the classification.");

		/*
		 * Mouse parado em cima do JTextFiled "MaxFeat" faz a mensagem seguinte
		 * aparecer: "Limits a maximum number of features to be selected."
		 */
		maxFeatTextField.setToolTipText("Limits a maximum number of features to be selected.");

		/*
		 * Mouse parado em cima do JButton "Results" faz a mensagem seguinte
		 * aparecer: "Show the Feature Selection."
		 */
		btnResults.setToolTipText("Show the Feature Selection.");

		/**
		 * Mensagens do panelBuildingClassifier:
		 */
		/*
		 * Mouse parado em cima do JComboBox "Classifier" faz a mensagem
		 * seguinte aparecer: "Choose a Classifier to build."
		 */
		comboBoxClassifier.setToolTipText("Choose a Classifier to build.");

		/*
		 * Mouse parado em cima do botão "Settings" faz a mensagem seguinte
		 * aparecer: "Change the classifier settings."
		 */
		btnSettings.setToolTipText("Change the classifier settings.");

		/*
		 * Mouse parado em cima do botão "Build Classifier" faz a mensagem
		 * seguinte aparecer:
		 * "Build the classifier using the Data Set previously chosen."
		 */
		btnBuildClassifier.setToolTipText("Build the classifier using the Data Set previously chosen.");

		/*
		 * Mouse parado em cima do botão "Save" faz a mensagem seguinte
		 * aparecer: "Save the classifier builded."
		 */
		btnSave.setToolTipText("Save the classifier builded.");

		/**
		 * Ações do panelBuildingClassifier:
		 */
		/*
		 * Setar o Classifier escolhido na classe "Parameters".
		 */
		EventChoosenClassifier eventChoosenClassifier = new EventChoosenClassifier(comboBoxClassifier);
		comboBoxClassifier.addActionListener(eventChoosenClassifier);

		/*
		 * Ao clicar no Botão "Build Classifier", chamar a classe "Trainer".
		 * 
		 * Chamar uma JOptionPane para informar que o classificador foi
		 * construído.
		 */
		EventBuildClassifier eventBuildClassifier = new EventBuildClassifier(btnBuildClassifier, chckbxActivate,
				maxFeatTextField);
		btnBuildClassifier.addActionListener(eventBuildClassifier);

		/*
		 * Ao clicar no Botão "Settings", chamar uma página para mudar os
		 * parametros do classificador.
		 */
		EventClassifierSettings eventClassifierSettings = new EventClassifierSettings(btnSettings, comboBoxClassifier);
		btnSettings.addActionListener(eventClassifierSettings);

		/*
		 * Ao clicar no botão "Save" chamar uma tela para salvar o Classifier em
		 * um arquivo ".ser". Tentar fazer isso de uma forma bonita.
		 */
		EventSaveClassifier eventSaveClassifier = new EventSaveClassifier(btnSave);
		btnSave.addActionListener(eventSaveClassifier);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JPanel panel = new ClassifierTrainingPanel();
		JFrame frame = new JFrame();

		frame.getContentPane().add(panel);
		panel.setVisible(true);

		frame.setIconImage((new ImageIcon(System.getProperty("user.dir") + "\\Icon1.png")).getImage());
		frame.setVisible(true);

		frame.setSize(500, 400);
		frame.setLocation(400, 200);

		frame.setTitle("Test to view the Classifier Training panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
