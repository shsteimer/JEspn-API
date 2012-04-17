package org.shsteimer.espn.api.method;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JEspnApiMethodImpl implements JEspnApiMethod {

	private final String methodBaseRelativeUri;
	private Map<String, String> parameters;
	private List<String> requiredParameters;
	private static final String PARAM_REGEX = "__[a-zA-Z0-9]*__";

	public JEspnApiMethodImpl(final String methodBaseRelativeUri) {
		this.methodBaseRelativeUri = methodBaseRelativeUri;
		initRequiredParameters(methodBaseRelativeUri);
	}

	@Override
	public void addMethodParameter(final String key, final String value) {
		if (parameters == null) {
			parameters = new TreeMap<String, String>();
		}
		parameters.put(key, value);

	}

	@Override
	public boolean areParemetersRequired() {
		return requiredParameters != null && requiredParameters.size() > 0;
	}

	@Override
	public List<String> getRequiredParameters() {
		return requiredParameters;
	}

	@Override
	public String toString() {
		String str = methodBaseRelativeUri;
		if (parameters != null && parameters.size() > 0) {
			for (String key : parameters.keySet()) {
				str = str.replaceAll("__" + key + "__", parameters.get(key));
			}
		}
		return str;
	}

	private void initRequiredParameters(final String methodBaseRelativeUri) {
		Pattern pattern = Pattern.compile(PARAM_REGEX);
		Matcher matcher = pattern.matcher(methodBaseRelativeUri);
		while (matcher.find()) {
			int beginIndex = matcher.start();
			int endIndex = matcher.end();
			String param = methodBaseRelativeUri.substring(beginIndex + 2,
					endIndex - 2);
			addRequiredMethodParmeter(param);
		}
	}

	private void addRequiredMethodParmeter(final String param) {
		if (requiredParameters == null) {
			requiredParameters = new LinkedList<String>();
		}
		requiredParameters.add(param);
	}

}
