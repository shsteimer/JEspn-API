package org.shsteimer.espn.api.exceptions;

public class JEspnApiHttpException extends JEspnApiException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6620037123538729842L;

	public JEspnApiHttpException() {
		super();
	}

	public JEspnApiHttpException(final String msg) {
		super(msg);
	}

	public JEspnApiHttpException(final Throwable t) {
		super(t);
	}

	public JEspnApiHttpException(final String msg, final Throwable t) {
		super(msg, t);
	}

}
