package gui.explorer;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import gui.explorer.listeners.EventClassify;
import gui.explorer.listeners.EventOpenClassifier;
import gui.explorer.listeners.EventOpenNewCases;
import gui.explorer.listeners.EventSaveClassification;
import gui.explorer.listeners.EventSearch;
import gui.explorer.listeners.EventValidate;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @author Flávio
 *
 */
public class ClassifierUsePanel extends JPanel implements Tab {

	/**
	 * To Serialize the class.
	 */
	private static final long serialVersionUID = 1L;

	// panelBuildedClassifier components.
	private JPanel panelBuildedClassifier;
	private JTextField classifierPathTextField;
	private JLabel lblPathClassifier;
	private JButton btnSearchClassifier;
	private JLabel lblValidatepathclassifier;
	private JButton btnOpenClassifierFile;

	// panelNewCases components.
	private JPanel panelNewCases;
	private JLabel lblPathNewCases;
	private JButton btnSearchNewCases;
	private JTextField newCasesPathTextField;
	private JLabel lblValidatepathnewcases;
	private JButton btnOpenNewCases;

	// panelClassifySave components.
	private JPanel panelClassifySave;
	private JLabel lblApplyClassifier;
	private JButton btnClassify;
	private JButton btnSave;

	public ClassifierUsePanel() {
		/*
		 * Initializing panelBuildedClassifier components.
		 */
		panelBuildedClassifier = new JPanel();
		panelBuildedClassifier.setBorder(
				BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Builded Classifier File"),
						BorderFactory.createEmptyBorder(0, 5, 5, 5)));
		classifierPathTextField = new JTextField(10);
		lblPathClassifier = new JLabel("Path:");
		btnSearchClassifier = new JButton("Search");
		lblValidatepathclassifier = new JLabel("");
		btnOpenClassifierFile = new JButton("Open File");

		/*
		 * Initializing panelNewCases components.
		 */
		panelNewCases = new JPanel();
		panelNewCases.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("New case(s)"),
				BorderFactory.createEmptyBorder(0, 5, 5, 5)));
		lblPathNewCases = new JLabel("Path:");
		btnSearchNewCases = new JButton("Search");
		newCasesPathTextField = new JTextField(10);
		lblValidatepathnewcases = new JLabel("");
		btnOpenNewCases = new JButton("Open File");

		/*
		 * Initializing panelClassifySave components.
		 */
		panelClassifySave = new JPanel();
		panelClassifySave.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Classify and Save"), BorderFactory.createEmptyBorder(0, 5, 5, 5)));
		lblApplyClassifier = new JLabel("Applying the classifier builded to new case(s).");
		btnClassify = new JButton("Classify");
		btnSave = new JButton("Save");

		buildPanel();
		setListeners();
	}

	public void buildPanel() {
		// ClassifierUse layout.
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		/*
		 * panelBuildedClassifier settings.
		 */
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panelBuildedClassifier, gbc_panel_1);

		// panelBuildedClassifier layout.
		GroupLayout gl_panel_1 = new GroupLayout(panelBuildedClassifier);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(lblPathClassifier)
								.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(classifierPathTextField, GroupLayout.PREFERRED_SIZE, 275,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnSearchClassifier)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnOpenClassifierFile))
								.addComponent(lblValidatepathclassifier))
						.addContainerGap(22, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addComponent(lblPathClassifier).addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(classifierPathTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearchClassifier).addComponent(btnOpenClassifierFile))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblValidatepathclassifier)
				.addContainerGap(47, Short.MAX_VALUE)));
		panelBuildedClassifier.setLayout(gl_panel_1);

		/*
		 * panelNewCases settings.
		 */
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		add(panelNewCases, gbc_panel_2);

		// panelNewCases layout.
		GroupLayout gl_panel_2 = new GroupLayout(panelNewCases);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addComponent(lblPathNewCases)
								.addGroup(gl_panel_2.createSequentialGroup()
										.addComponent(newCasesPathTextField, GroupLayout.PREFERRED_SIZE, 275,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnSearchNewCases)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnOpenNewCases))
						.addComponent(lblValidatepathnewcases)).addContainerGap(22, Short.MAX_VALUE)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(lblPathNewCases)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(newCasesPathTextField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSearchNewCases).addComponent(btnOpenNewCases))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblValidatepathnewcases)
				.addContainerGap(47, Short.MAX_VALUE)));
		panelNewCases.setLayout(gl_panel_2);

		/*
		 * panelClassifySave settings.
		 */
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		add(panelClassifySave, gbc_panel_3);

		// panelClassifySave layout.
		GroupLayout gl_panel_3 = new GroupLayout(panelClassifySave);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(lblApplyClassifier).addGroup(gl_panel_3.createSequentialGroup()
										.addComponent(btnClassify).addGap(18).addComponent(btnSave)))
				.addContainerGap(264, Short.MAX_VALUE)));
		gl_panel_3
				.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup().addContainerGap().addComponent(lblApplyClassifier)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE).addComponent(btnClassify)
										.addComponent(btnSave))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelClassifySave.setLayout(gl_panel_3);
	}

	public void setListeners() {
		/**
		 * Mensagens do panelBuildedClassifier.
		 */
		/*
		 * Mouse parado em cima do JTextField faz a mensagem seguinte aparecer:
		 * "Type a path to file that contains the builded Classifier. The file must be SER type."
		 */
		classifierPathTextField
				.setToolTipText("Type a path to file that contains the builded Classifier. The file must be SER type.");

		/*
		 * Mouse parado em cima do botão Search faz a mensagem seguinte
		 * aparecer: "Click to search a SER file."
		 */
		btnSearchClassifier.setToolTipText("Click to search a SER file.");

		/*
		 * Mouse parado em cima do botão OpenFile faz a mensagem seguinte
		 * aparecer: "Click to open the classifier."
		 */
		btnOpenClassifierFile.setToolTipText("Click to open the Classifier.");

		/**
		 * Ações do panelBuildedClassifier.
		 */
		/*
		 * Ao apertar o botão "Search", abrir uma tela para o usuário procurar o
		 * arquivo desejado.
		 */
		EventSearch eventSearchSer = new EventSearch(btnSearchClassifier, classifierPathTextField, "SER", "ser");
		btnSearchClassifier.addActionListener(eventSearchSer);
		classifierPathTextField.addActionListener(eventSearchSer);

		/*
		 * Se o caminho para o arquivo for inválido (não existir), aparece a
		 * mensagem ao lado do botão Search: "Invalid Path."
		 * 
		 *
		 * Se o arquivo não for do tipo .ser, aparece a mensagem ao lado do
		 * botão Search: "File isn't SER type."
		 *
		 *
		 * Se o caminho para o arquivo for válido e o arquivo for do tipo .ser:
		 * -> aparece a mensagem ao lado do botão Search: "Valid file."
		 *
		 */
		EventValidate eventValidateFile = new EventValidate(classifierPathTextField, lblValidatepathclassifier, "SER",
				btnOpenClassifierFile);
		classifierPathTextField.getDocument().addDocumentListener(eventValidateFile);

		/*
		 * O classificador do predictor dentro da Classe "Parameters" deve ser
		 * setado ao apertarmos o botão btnOpenClassifierFile.
		 */
		EventOpenClassifier eventOpenClassifier = new EventOpenClassifier(btnOpenClassifierFile,
				classifierPathTextField);
		btnOpenClassifierFile.addActionListener(eventOpenClassifier);

		/**
		 * Mensagens do panelNewCases.
		 */
		/*
		 * Mouse parado em cima do JTextField faz a mensagem seguinte aparecer:
		 * "Type a path to file that contains new case(s). The file must be CSV type."
		 */
		newCasesPathTextField
				.setToolTipText("Type a path to file that contains new case(s). The file must be CSV type.");

		/*
		 * Mouse parado em cima do botão Search faz a mensagem seguinte
		 * aparecer: "Click to search a CSV file."
		 */
		btnSearchNewCases.setToolTipText("Click to search a CSV file.");

		/*
		 * Mouse parado em cima do botão OpenFile faz a mensagem seguinte
		 * aparecer: "Click to open New Case(s)."
		 */
		btnOpenNewCases.setToolTipText("Click to open New Case(s).");

		/**
		 * Ações do panelNewCases.
		 */
		/*
		 * Ao apertar o botão "Search", abrir uma tela para o usuário procurar o
		 * arquivo desejado.
		 */
		EventSearch eventSearchCsv = new EventSearch(btnSearchNewCases, newCasesPathTextField, "CSV", "csv");
		btnSearchNewCases.addActionListener(eventSearchCsv);
		newCasesPathTextField.addActionListener(eventSearchCsv);

		/*
		 * Se o caminho para o arquivo for inválido (não existir), aparece a
		 * mensagem ao lado do botão Search: "Invalid Path."
		 * 
		 * Se o arquivo não for do tipo .ser, aparece a mensagem ao lado do
		 * botão Search: "File isn't CSV type."
		 * 
		 * Se o caminho para o arquivo for válido e o arquivo for do tipo CSV:
		 * -> aparece a mensagem ao lado do botão Search: "Valid file."
		 */
		eventValidateFile = new EventValidate(newCasesPathTextField, lblValidatepathnewcases, "CSV", btnOpenNewCases);
		newCasesPathTextField.getDocument().addDocumentListener(eventValidateFile);

		/*
		 * Novas instâncias da Classe "Parameters" deve ser setado quando
		 * apertarmos o botão btnOpenNewCases.
		 */
		EventOpenNewCases eventOpenNewCases = new EventOpenNewCases(btnOpenNewCases, newCasesPathTextField);
		btnOpenNewCases.addActionListener(eventOpenNewCases);

		/**
		 * Mensagens do panelClassifySave.
		 */
		/*
		 * Mouse parado em cima do botão Classify faz a mensagem seguinte
		 * aparecer: "Click to use the classifier at the new case(s)."
		 */
		btnClassify.setToolTipText("Click to use the classifier at the new case(s).");

		/*
		 * Mouse parado em cima do botão Save faz a mensagem seguinte aparecer:
		 * "Click to save the new case(s) classification in a CSV file."
		 */
		btnSave.setToolTipText("Click to save the new case(s) classification in a CSV file.");

		/**
		 * Ações do panelClassifySave.
		 */
		/*
		 * Ao apertar o botão "Classify", chamar a classe "InstacePredictor".
		 */
		EventClassify eventClassify = new EventClassify(btnClassify);
		btnClassify.addActionListener(eventClassify);

		/*
		 * Ao apertar o botão "Save", abrir uma tela para o usuário procurar a
		 * pasta desejada para salvar o arquivo.
		 */
		EventSaveClassification eventSaveClassification = new EventSaveClassification(btnSave);
		btnSave.addActionListener(eventSaveClassification);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JPanel panel = new ClassifierUsePanel();
		JFrame frame = new JFrame();

		frame.getContentPane().add(panel);
		panel.setVisible(true);

		frame.setIconImage((new ImageIcon(System.getProperty("user.dir") + "\\Icon1.png")).getImage());
		frame.setVisible(true);

		frame.setSize(500, 400);
		frame.setLocation(400, 200);

		frame.setTitle("Test to view the Classifier Use panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
