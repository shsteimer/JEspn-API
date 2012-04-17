package org.shsteimer.espn.api.exceptions;

public class JEspnApiException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6620037123538729842L;

	public JEspnApiException() {
		super();
	}

	public JEspnApiException(final String msg) {
		super(msg);
	}

	public JEspnApiException(final Throwable t) {
		super(t);
	}

	public JEspnApiException(final String msg, final Throwable t) {
		super(msg, t);
	}

}
