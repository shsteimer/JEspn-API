package org.shsteimer.espn.api;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.xmlbeans.XmlException;
import org.shsteimer.espn.api.exceptions.JEspnApiException;
import org.shsteimer.espn.api.exceptions.JEspnApiHttpException;
import org.shsteimer.espn.api.exceptions.JEspnApiParseException;
import org.shsteimer.espn.api.method.JEspnApiMethod;
import org.shsteimer.espn.api.resource.JEspnApiResouce;
import org.shsteimer.espn.api.response.JEspnApiResponse;
import org.shsteimer.espn.api.response.JEspnApiResponseImpl;
import org.shsteimer.espn.api.response.beans.ResponseDocument;
import org.shsteimer.espn.api.version.JEspnApiVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class JEspnApi<E> {

	public static final String BASE_API_URL = "http://api.espn.com";
	private static final Logger log = LoggerFactory.getLogger(JEspnApi.class);
	protected static final String SLASH = "/";
	protected static final String QUESTION_MARK = "?";
	protected static final String AMPERSAND = "&";
	protected static final String EQUAL_SIGN = "=";

	protected Map<String, String> parameters;
	protected JEspnApiResouce resource;
	protected JEspnApiMethod method;
	protected JEspnApiVersion version;

	public String getBaseUrl() {
		String baseUrl = System.getProperty("jespn.api.baseurl");
		if (baseUrl != null && baseUrl.trim().length() > 0) {
			return baseUrl;
		}

		return BASE_API_URL;
	}

	public E limit(final long limit) {
		return addParameter("limit", String.valueOf(limit));
	}

	public E offset(final long offset) {
		return addParameter("offset", String.valueOf(offset));
	}

	public E addParameter(final String name, final String value) {
		parameters.put(name, value);
		return (E) this;
	}

	public E with(final JEspnApiResouce resource) {
		this.resource = resource;
		return (E) this;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public JEspnApiResponse execute() throws JEspnApiException {
		String callUrl = buildCallUrl();
		try {
			HttpResponse httpResponse = getHttpResponse(callUrl);
			String xmlString = getResponseAsXmlString(httpResponse);
			JEspnApiResponse response = new JEspnApiResponseImpl();
			ResponseDocument rDoc = ResponseDocument.Factory.parse(xmlString);
			response.setResponse(rDoc.getResponse());
			if (response.isError()) {
				throw new JEspnApiHttpException(response.getErrorMessage());
			}
			return response;
		} catch (JEspnApiHttpException e) {
			throw e;
		} catch (XmlException e) {
			throw new JEspnApiParseException(e);
		}
	}

	private String buildCallUrl() {
		StringBuilder builder = new StringBuilder();
		builder.append(getBaseUrl()).append(SLASH).append(version.value())
				.append(SLASH).append(resource.value()).append(SLASH)
				.append(method.toString());

		if (parameters != null && parameters.size() > 0) {
			builder.append(QUESTION_MARK);

			int count = 0;
			int len = parameters.size();
			for (String key : parameters.keySet()) {
				builder.append(key).append(EQUAL_SIGN)
						.append(parameters.get(key));
				if (count < len - 1) {
					builder.append(AMPERSAND);
				}

			}
		}

		return builder.toString();
	}

	protected String getResponseAsXmlString(final HttpResponse response)
			throws JEspnApiHttpException {

		HttpEntity entity = response.getEntity();
		try {
			return EntityUtils.toString(entity);
		} catch (ParseException e) {
			throw new JEspnApiHttpException(e);
		} catch (IOException e) {
			throw new JEspnApiHttpException(e);
		}

	}

	protected HttpResponse getHttpResponse(final String apiCallUrl)
			throws JEspnApiHttpException {
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(apiCallUrl);
		httpget.addHeader("Accept", "text/xml");

		try {
			if (log.isInfoEnabled()) {
				log.info("Executing HTTP Call to ESPN API at {}", httpget
						.getURI().toString());
			}
			return httpclient.execute(httpget);
		} catch (ClientProtocolException e) {
			throw new JEspnApiHttpException(e);
		} catch (IOException e) {
			throw new JEspnApiHttpException(e);
		}

	}

}
