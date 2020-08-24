package org.serratec.grupo06.trabalhofinal.exception;

public class PedidosNotFoundException extends Exception{

	private static final long serialVersionUID=1L;
	
	public PedidosNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PedidosNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PedidosNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PedidosNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PedidosNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
