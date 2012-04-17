package org.shsteimer.espn.api.exceptions;

public class JEspnApiParseException extends JEspnApiException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6620037123538729842L;

	public JEspnApiParseException() {
		super();
	}

	public JEspnApiParseException(final String msg) {
		super(msg);
	}

	public JEspnApiParseException(final Throwable t) {
		super(t);
	}

	public JEspnApiParseException(final String msg, final Throwable t) {
		super(msg, t);
	}

}
