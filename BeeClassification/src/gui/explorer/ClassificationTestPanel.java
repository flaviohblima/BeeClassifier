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

import gui.explorer.listeners.EventChoosenAlgorithm;
import gui.explorer.listeners.EventChoosenEvaluator;
import gui.explorer.listeners.EventClassifierParameters;
import gui.explorer.listeners.EventEvaluateClassifiers;
import gui.explorer.listeners.EventSelectClassifier;
import gui.explorer.listeners.EventVisualizeFeatureSelection;
import gui.explorer.listeners.EvtActivFeatSelTestPanel;

/**
 * 
 * @author Flávio
 *
 */
public class ClassificationTestPanel extends JPanel implements Tab {

	/**
	 * To serialize the class.
	 */
	private static final long serialVersionUID = 1L;

	// panelEvaluator components
	private JPanel panelEvaluator;
	private JTextField foldTextField;
	private JLabel lblEvaluator;
	private JComboBox<String> comboBoxEvaluator;
	private JLabel lblFolds;

	// panelFeatureSelection components.
	private JPanel panelFeatureSelection;
	private JTextField maxFeatTextField;
	private JCheckBox chckbxActivate;
	private JLabel lblAlgorithm;
	private JComboBox<String> comboBoxAlgorithm;
	private JLabel lblMaxNumberOf;
	private JButton btnResults;

	// panelEvaluatingClassifiers components
	private JPanel panelEvaluatingClassifiers;
	private JLabel lblClassifiers;
	private JCheckBox chckbxC45;
	private JCheckBox chckbxNaiveBayes;
	private JCheckBox chckbxKNearestNeighbors;
	private JCheckBox chckbxLda;
	private JCheckBox chckbxSupportVectorMachine;
	private JCheckBox chckbxMultilayerPerceptron;
	private JCheckBox chckbxLogistic;
	private JButton btnEvaluateClassifiers;

	/**
	 * 
	 */
	public ClassificationTestPanel() {
		/*
		 * Initializing panelEvaluator components.
		 */
		panelEvaluator = new JPanel();
		panelEvaluator.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Classifier Evaluator"), BorderFactory.createEmptyBorder(0, 5, 5, 5)));
		foldTextField = new JTextField(8);
		foldTextField.setText(Integer.toString(system.Parameters.kFolds));
		lblEvaluator = new JLabel("Evaluator:");
		DefaultComboBoxModel<String> comboEvalModel = new DefaultComboBoxModel<String>(system.Constants.evaluators);
		comboBoxEvaluator = new JComboBox<String>(comboEvalModel);
		comboBoxEvaluator.setBackground(new Color(255, 255, 255));
		lblFolds = new JLabel("Folds:");

		/*
		 * Initializing panelFeatureSelection components.
		 */
		panelFeatureSelection = new JPanel();
		panelFeatureSelection.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Feature Selection"), BorderFactory.createEmptyBorder(0, 5, 5, 5)));
		maxFeatTextField = new JTextField(8);
		chckbxActivate = new JCheckBox("Activate");
		lblAlgorithm = new JLabel("Algorithm:");
		DefaultComboBoxModel<String> comboAlgModel = new DefaultComboBoxModel<String>(
				system.Constants.algorithmsClasses);
		comboBoxAlgorithm = new JComboBox<String>(comboAlgModel);
		comboBoxAlgorithm.setBackground(new Color(255, 255, 255));
		lblMaxNumberOf = new JLabel("Max number of features:");
		btnResults = new JButton("Results");

		/*
		 * Initializing panelEvaluatingClassifiers components.
		 */
		panelEvaluatingClassifiers = new JPanel();
		panelEvaluatingClassifiers.setBorder(
				BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Evaluating Classifiers"),
						BorderFactory.createEmptyBorder(0, 5, 5, 5)));
		lblClassifiers = new JLabel("Classifiers");
		chckbxC45 = new JCheckBox("C4.5");
		chckbxNaiveBayes = new JCheckBox("Na\u00EFve Bayes");
		chckbxKNearestNeighbors = new JCheckBox("K Nearest Neighbors");
		chckbxLda = new JCheckBox("LDA");
		chckbxSupportVectorMachine = new JCheckBox("Support Vector Machine");
		chckbxMultilayerPerceptron = new JCheckBox("Multilayer Perceptron");
		chckbxLogistic = new JCheckBox("Logistic");
		btnEvaluateClassifiers = new JButton("Evaluate Classifiers");

		buildPanel();
		setListeners();
	}

	/**
	 * 
	 */
	public void buildPanel() {
		// ClassificationTest layout.
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		/*
		 * panelEvaluator settings.
		 */
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panelEvaluator, gbc_panel_1);

		// panelEvaluator layout.
		GroupLayout gl_panel_1 = new GroupLayout(panelEvaluator);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBoxEvaluator, 0, 147, Short.MAX_VALUE).addComponent(lblEvaluator)
								.addComponent(lblFolds).addComponent(foldTextField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(128, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(lblEvaluator)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(comboBoxEvaluator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblFolds).addPreferredGap(ComponentPlacement.RELATED).addComponent(foldTextField,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(20, Short.MAX_VALUE)));
		panelEvaluator.setLayout(gl_panel_1);

		/*
		 * panelFeatureSelection settings.
		 */
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		add(panelFeatureSelection, gbc_panel_2);

		// panelFeatureSelection layout.
		GroupLayout gl_panel_2 = new GroupLayout(panelFeatureSelection);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addComponent(chckbxActivate)
								.addComponent(lblAlgorithm).addComponent(lblMaxNumberOf)
								.addComponent(maxFeatTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addComponent(btnResults)
								.addComponent(comboBoxAlgorithm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(96, Short.MAX_VALUE)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(chckbxActivate)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblAlgorithm)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(comboBoxAlgorithm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblMaxNumberOf)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(maxFeatTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnResults)
						.addContainerGap(20, Short.MAX_VALUE)));
		panelFeatureSelection.setLayout(gl_panel_2);

		/*
		 * panelEvaluatingClassifiers settings.
		 */
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridheight = 2;
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 0;
		add(panelEvaluatingClassifiers, gbc_panel_3);

		// panelEvaluatingClassifiers layout.
		GroupLayout gl_panel_3 = new GroupLayout(panelEvaluatingClassifiers);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addComponent(chckbxLogistic)
								.addComponent(chckbxMultilayerPerceptron).addComponent(chckbxLda)
								.addComponent(chckbxKNearestNeighbors).addComponent(chckbxNaiveBayes)
								.addComponent(lblClassifiers).addComponent(chckbxC45)
								.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnEvaluateClassifiers).addComponent(chckbxSupportVectorMachine)))
				.addContainerGap(148, Short.MAX_VALUE)));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addContainerGap().addComponent(lblClassifiers)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(chckbxC45)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(chckbxNaiveBayes)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(chckbxKNearestNeighbors)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(chckbxLda)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(chckbxSupportVectorMachine)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(chckbxMultilayerPerceptron)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(chckbxLogistic).addGap(18)
						.addComponent(btnEvaluateClassifiers).addContainerGap(116, Short.MAX_VALUE)));
		panelEvaluatingClassifiers.setLayout(gl_panel_3);
	}

	public void setListeners() {
		/*
		 * 
		 * 
		 * Pensar em cada ação que os components precisam implementar.
		 * 
		 * 
		 * 
		 */

		/**
		 * Mensagens do panelEvaluator:
		 */
		/*
		 * Mouse parado em cima do JComboBox "Evaluator" faz a mensagem seguinte
		 * aparecer: "Choose a algorithm to evaluate the classifier(s)."
		 */
		comboBoxEvaluator.setToolTipText("Choose a algorithm to evaluate the classifier(s).");

		/*
		 * Mouse parado em cima do JTextField "Folds" faz a mensagem seguinte
		 * aparecer: "Set the k number of folds."
		 */
		foldTextField.setToolTipText("Set the integer number k (k>0) of folds.");

		/**
		 * Ações do panelEvaluator:
		 */
		/*
		 * Caso o Evaluator "K fold Cross-Validation" seja escolhido, a JLabel
		 * "K folds" e o JTextField abaixo dela são ativados. Eles devem
		 * permanecer desativados caso seja outro Evaluator.
		 * 
		 * Setar o Evaluator escolhido na Classe "Parameters".
		 */
		EventChoosenEvaluator eventChoosenEval = new EventChoosenEvaluator(comboBoxEvaluator, lblFolds, foldTextField);
		comboBoxEvaluator.addActionListener(eventChoosenEval);

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
		 * Ações do panelFeatureSelection:
		 */
		/*
		 * Caso a JCheckBox "Activate" seja selecionada, todos os JComponents
		 * abaixo dela devem ser acionados.
		 */
		EvtActivFeatSelTestPanel activateFeatSel = new EvtActivFeatSelTestPanel(chckbxActivate, btnResults,
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
		 * Mensagens do panelEvaluatingClassifiers:
		 */
		/*
		 * PARA CADA UM DOS CLASSIFIERS:
		 * 
		 * "Left click to select the JCheckBox to evaluate this classifier. Right click to SetUp the classifier parameters."
		 */
		chckbxC45.setToolTipText(
				"Left click to select this classifier. Right click to set up the classifier parameters.");
		chckbxKNearestNeighbors.setToolTipText(
				"Left click to select this classifier. Right click to set up the classifier parameters.");
		chckbxLda.setToolTipText("Left click to select this classifier.");
		chckbxLogistic.setToolTipText(
				"Left click to select this classifier. Right click to set up the classifier parameters.");
		chckbxMultilayerPerceptron.setToolTipText(
				"Left click to select this classifier. Right click to set up the classifier parameters.");
		chckbxNaiveBayes.setToolTipText(
				"Left click to select this classifier. Right click to set up the classifier parameters.");
		chckbxSupportVectorMachine.setToolTipText(
				"Left click to select this classifier. Right click to set up the classifier parameters.");

		/*
		 * Mouse parado em cima do JButton "Evaluate Classifiers" faz a mensagem
		 * seguinte aparecer: "Evaluate the classifiers and show the results."
		 */
		btnEvaluateClassifiers.setToolTipText("Evaluate the classifiers and show the results.");

		/**
		 * Ações do panelEvaluatingClassifiers:
		 */
		/*
		 * PARA CADA UM DOS CLASSIFIERS:
		 * 
		 * Setar a array de Classifiers da Classe "Parameters".
		 */
		//
		EventSelectClassifier eventSelectClassifier = new EventSelectClassifier(chckbxC45,
				system.Constants.classifiersClassesNames[0]);
		chckbxC45.addItemListener(eventSelectClassifier);
		//
		eventSelectClassifier = new EventSelectClassifier(chckbxNaiveBayes,
				system.Constants.classifiersClassesNames[1]);
		chckbxNaiveBayes.addItemListener(eventSelectClassifier);
		//
		eventSelectClassifier = new EventSelectClassifier(chckbxKNearestNeighbors,
				system.Constants.classifiersClassesNames[2]);
		chckbxKNearestNeighbors.addItemListener(eventSelectClassifier);
		//
		eventSelectClassifier = new EventSelectClassifier(chckbxLda, system.Constants.classifiersClassesNames[3]);
		chckbxLda.addItemListener(eventSelectClassifier);
		//
		eventSelectClassifier = new EventSelectClassifier(chckbxSupportVectorMachine,
				system.Constants.classifiersClassesNames[4]);
		chckbxSupportVectorMachine.addItemListener(eventSelectClassifier);
		//
		eventSelectClassifier = new EventSelectClassifier(chckbxMultilayerPerceptron,
				system.Constants.classifiersClassesNames[5]);
		chckbxMultilayerPerceptron.addItemListener(eventSelectClassifier);
		//
		eventSelectClassifier = new EventSelectClassifier(chckbxLogistic, system.Constants.classifiersClassesNames[6]);
		chckbxLogistic.addItemListener(eventSelectClassifier);

		/*
		 * PARA CADA UM DOS CLASSIFIERS:
		 * 
		 * Ao clicar com o botão direito, aparece uma tela para setar os
		 * parâmetros dos classifiers.
		 */
		EventClassifierParameters parametersPage = new EventClassifierParameters(chckbxC45);
		chckbxC45.addMouseListener(parametersPage);
		parametersPage = new EventClassifierParameters(chckbxNaiveBayes);
		chckbxNaiveBayes.addMouseListener(parametersPage);
		parametersPage = new EventClassifierParameters(chckbxKNearestNeighbors);
		chckbxKNearestNeighbors.addMouseListener(parametersPage);
		/*
		 * O LDA não é uma implementação do weka, então não dá pra usar o mesmo
		 * evento.
		 *
		 * parametersPage = new EventClassifierParameters(chckbxLda);
		 * chckbxLda.addMouseListener(parametersPage);
		 * 
		 */
		parametersPage = new EventClassifierParameters(chckbxSupportVectorMachine);
		chckbxSupportVectorMachine.addMouseListener(parametersPage);
		parametersPage = new EventClassifierParameters(chckbxMultilayerPerceptron);
		chckbxMultilayerPerceptron.addMouseListener(parametersPage);
		parametersPage = new EventClassifierParameters(chckbxLogistic);
		chckbxLogistic.addMouseListener(parametersPage);

		/*
		 * Ao clicar no botão "Compare Classifiers", chamar a classe
		 * "Experiment".
		 * 
		 * O listener do botão "Compare Classifiers" deve testar se ou dados (k
		 * folds e MaxFeat) de entrada são aceitáveis.
		 */
		EventEvaluateClassifiers eventEvaluateClassifiers = new EventEvaluateClassifiers(btnEvaluateClassifiers,
				chckbxActivate, maxFeatTextField, foldTextField);
		btnEvaluateClassifiers.addActionListener(eventEvaluateClassifiers);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JPanel panel = new ClassificationTestPanel();
		JFrame frame = new JFrame();

		frame.getContentPane().add(panel);
		panel.setVisible(true);

		frame.setIconImage((new ImageIcon(System.getProperty("user.dir") + "\\Icon1.png")).getImage());

		frame.setSize(500, 400);
		frame.setLocation(400, 200);

		frame.setTitle("Test to see the Classification Test panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
	}
}
