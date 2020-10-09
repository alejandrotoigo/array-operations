package alejandrotoigo.array.operations.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

public class Util {

	private static final Logger LOG = Logger.getLogger(Util.class.getName());

	public static int[] readFile() {
		int i = 0;
		int[] vector = new int[10000000];

		try (LineReader lineReader = new LineReader(
				new FileInputStream(new File(Class.forName("alejandrotoigo.array.operations.util.Util").getClassLoader()
						.getResource(Constants.FILENAME).getFile())))) {
			while (lineReader.ready()) {
				String line = lineReader.readLine();
				vector[i] = Integer.valueOf(line);
				i++;
			}
			
		} catch (NumberFormatException nfe) {
			LOG.error(nfe.getMessage());
		} catch (IOException ioe) {
			LOG.error(ioe.getMessage());
		} catch (ClassNotFoundException e) {
			LOG.error(e.getMessage());
		}

		return vector;
	}

	public static boolean checkForPrime(int inputNumber) {
		boolean isItPrime = true;

		if (inputNumber <= 1) {
			isItPrime = false;

			return isItPrime;
		} else {
			for (int i = 2; i <= inputNumber / 2; i++) {
				if ((inputNumber % i) == 0) {
					isItPrime = false;

					break;
				}
			}
			return isItPrime;
		}
	}
}
