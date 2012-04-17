package org.shsteimer.espn.api.method;

import java.util.List;

public interface JEspnApiMethod {

	void addMethodParameter(String key, String value);

	boolean areParemetersRequired();

	List<String> getRequiredParameters();

}
