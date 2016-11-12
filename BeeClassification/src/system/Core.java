package system;

public class Core {

	public final static Constants constants = new Constants();
	public static Parameters parameters = new Parameters();

	public Core() {
	}

	public static Parameters getParameters() {
		return parameters;
	}

	public static void setParameters(Parameters parameters) {
		Core.parameters = parameters;
	}

}
