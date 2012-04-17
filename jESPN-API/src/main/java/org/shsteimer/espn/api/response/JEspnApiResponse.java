package org.shsteimer.espn.api.response;

import org.shsteimer.espn.api.response.beans.ResponseDocument.Response;

public interface JEspnApiResponse {

	void setResponse(Response response);

	Response getResponse();

	boolean isError();

	String getErrorMessage();

}
