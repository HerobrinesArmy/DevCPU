package devcpu.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

public class CountingLineReader extends Reader {
	private static int defaultCharBufferSize = 8192;
	private static int defaultExpectedLineLength = 80;
	private Reader in;
	private char cb[];
	private int nChars, nextChar;
	private int offset;
	private int lastLineOffset;
	private boolean skipLF = false;

	public CountingLineReader(Reader in, int bufferSize) {
		super(in);
		if (bufferSize <= 0) {
			throw new IllegalArgumentException("Buffer size <= 0");
		}
		this.in = in;
		cb = new char[bufferSize];
		nextChar = nChars = 0;
	}

	public CountingLineReader(Reader in) {
		this(in, defaultCharBufferSize);
	}

	private void ensureOpen() throws IOException {
		if (in == null) {
			throw new IOException("Stream closed");
		}
	}

	private void fill() throws IOException {
		int n;
		do {
			n = in.read(cb, 0, cb.length);
		} while (n == 0);
		if (n > 0) {
			nChars = n;
			nextChar = 0;
		}
	}

	String readLine(boolean ignoreLF) throws IOException {
		StringBuffer s = null;
		int startChar;
		lastLineOffset = offset;
		synchronized (lock) {
			ensureOpen();
			boolean omitLF = ignoreLF || skipLF;
			for (;;) {
				if (nextChar >= nChars) {
					fill();
				}
				if (nextChar >= nChars) {
					if (s != null && s.length() > 0) {
						offset += s.length();
						return s.toString();
					} else {
						return null;
					}
				}
				boolean eol = false;
				char c = 0;
				int i;
				if (omitLF && (cb[nextChar] == '\n')) {
					offset++;
					nextChar++;
					lastLineOffset = offset;
				}
				skipLF = false;
				omitLF = false;
				for (i = nextChar; i < nChars; i++) {
					offset++;
					c = cb[i];
					if ((c == '\n') || (c == '\r')) {
						eol = true;
						break;
					}
				}
				startChar = nextChar;
				nextChar = i;
				if (eol) {
					String str;
					if (s == null) {
						str = new String(cb, startChar, i - startChar);
					} else {
						s.append(cb, startChar, i - startChar);
						str = s.toString();
					}
					nextChar++;
					if (c == '\r') {
						skipLF = true;
					}
					return str;
				}
				if (s == null) {
					s = new StringBuffer(defaultExpectedLineLength);
				}
				s.append(cb, startChar, i - startChar);
			}
		}
	}

	public String readLine() throws IOException {
		return readLine(false);
	}

	public boolean markSupported() {
		return false;
	}

	public void close() throws IOException {
		synchronized (lock) {
			if (in == null) {
				return;
			}
			in.close();
			in = null;
			cb = null;
		}
	}

	public int getOffset() {
		return offset;
	}

	public int getLastLineOffset() {
		return lastLineOffset;
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		throw new UnsupportedOperationException("Herobrine didn't feel like supporting read(char[], int, int) in this hacked-together line reader.");
	}

	@Override
	public int read() throws IOException {
		throw new UnsupportedOperationException("Herobrine didn't feel like supporting read() in this hacked-together line reader.");
	}

	@Override
	public int read(char[] cbuf) throws IOException {
		throw new UnsupportedOperationException("Herobrine didn't feel like supporting read(char[]) in this hacked-together line reader.");
	}

	@Override
	public int read(CharBuffer target) throws IOException {
		throw new UnsupportedOperationException("Herobrine didn't feel like supporting read(CharBuffer) in this hacked-together line reader.");
	}

	@Override
	public long skip(long n) throws IOException {
		throw new UnsupportedOperationException("Herobrine didn't feel like supporting skip(long) in this hacked-together line reader.");
	}

	@Override
	public void mark(int readAheadLimit) throws IOException {
		throw new UnsupportedOperationException("Herobrine didn't feel like supporting mark(int) in this hacked-together line reader.");
	}

	@Override
	public void reset() throws IOException {
		throw new UnsupportedOperationException("Herobrine didn't feel like supporting reset() in this hacked-together line reader.");
	}
}
