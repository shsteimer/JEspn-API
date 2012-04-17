package org.shsteimer.espn.api.response;

import org.shsteimer.espn.api.response.beans.ResponseDocument.Response;

public class JEspnApiResponseImpl implements JEspnApiResponse {
	Response response;

	@Override
	public Response getResponse() {
		return response;
	}

	@Override
	public void setResponse(final Response response) {
		this.response = response;
	}

	@Override
	public boolean isError() {
		return !response.getStatus().equalsIgnoreCase("success");
	}

	@Override
	public String getErrorMessage() {
		return response.getCode() + " : " + response.getMessage();
	}
}
