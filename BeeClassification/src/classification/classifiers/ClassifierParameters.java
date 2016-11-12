package classification.classifiers;

public class ClassifierParameters {

	private String[] parametersArray;

	public void setTextParameters(String[] parametersArray) {
		this.parametersArray = parametersArray;
	}

	public String[] getTextParameters() {
		String[] parametersArray = this.parametersArray.clone();
		return parametersArray;
	}

}
