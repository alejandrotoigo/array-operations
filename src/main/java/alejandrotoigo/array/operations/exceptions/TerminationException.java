package alejandrotoigo.array.operations.exceptions;

import java.io.IOException;

public class TerminationException extends IOException {
	private int where;

	public TerminationException(int where) {
		super();
		this.where = where;
	}

	public TerminationException(String s, int where) {
		super(s);
		this.where = where;
	}

	public int position() {
		return where;
	}
}
