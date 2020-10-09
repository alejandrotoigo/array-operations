package alejandrotoigo.array.operations;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import alejandrotoigo.array.operations.util.Util;

public class Main {

	private static final Logger LOG = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) throws ClassNotFoundException {
		// Configurar proyecto
		configure();
		
		// Paso 1: Leer archivo y crear vector
		int[] vector = Util.readFile();
		
		// Paso 2: primer numero primo
		for(int i = 0; i < vector.length; i++) {
			if(Util.checkForPrime(vector[i])) {
				LOG.info("Primer numero primo: " + vector[i]);
				break;
			}
		}
		
		// Paso 3: promedio
		double suma = 0;
		for(int i = 0; i < vector.length; i++) {
			suma += vector[i];
		}
		
		LOG.debug("Primer numero: " + vector[0]);
		LOG.debug("Ultimo numero: " + vector[vector.length-1]);

		LOG.info("La suma es: " + suma);
		double promedio = suma / vector.length;
		LOG.info("El promedio es: " + promedio);
		LOG.info("El promedio redondeado es: " + Math.round(promedio));
		
		// Paso 4: calculo de la mediana
		Arrays.parallelSort(vector);
		int mitad = vector.length/2;
		float mediana = (vector[mitad] + vector[mitad -1]) / 2;
		LOG.info("La mediana es: " + mediana);
		LOG.info("La mediana redondeada es: " + Math.round(mediana));
		
		// Paso 5: buscar {2755145, 12873556, 9121687, 1013111, 882943, 923810, 716253, 987235}
		int [] numeros = {0, 0, 0, 0, 0, 0, 0, 0};
		for(int i = 0; i < vector.length; i++) {
			switch(vector[i]) {
				case 2755145:
					numeros[0] = 1;
					break;
				case 12873556:
					numeros[1] = 1;
					break;
				case 9121687:
					numeros[2] = 1;
					break;
				case 1013111:
					numeros[3] = 1;
					break;
				case 882943:
					numeros[4] = 1;
					break;
				case 923810:
					numeros[5] = 1;
					break;
				case 716253:
					numeros[6] = 1;
					break;
				case 987235:
					numeros[7] = 1;
					break;
			}
		}
		
		String str = "";
		for(int i = 0; i < numeros.length; i++) {
			str += String.valueOf(numeros[i]);
		}
		LOG.info("Cadena de numeros: " + str);
		
		LOG.info("El mayor numero es: " + vector[vector.length-1]);
	}
	
	private static void configure() {
		//PropertiesConfigurator is used to configure logger from properties file
        PropertyConfigurator.configure("src/main/resources/log4j.properties");	
	}

}
