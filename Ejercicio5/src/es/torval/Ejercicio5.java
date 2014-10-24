package es.torval;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio5 {
	
	/**
	 * Metodo que dice cuantas palabras que terminan en "tion"
	 * @param ruta
	 * @return
	 */
	public int palabraTerminaEn(String ruta){
		int cantidad=0;
		String termina = "tion",palabra="";
		try {
			FileReader fre = new FileReader(ruta);
			int i;
			try {
				while ((i = fre.read()) != -1) {//para leer caracteres hasta el final del archivo
					if (esLetra((char) i)) {
						palabra = palabra + ((char) i);//si es letra se añade al String para formar la palabra
					}else{
						if (palabra.endsWith(termina)){//si termina en "tion" suma una
							cantidad++;
						}palabra="";//al terminar con la palabra,se pone el String vacio, para recoger la siguiente
					}
					
					
				}
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					fre.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("Error al cerrar el archivo");
				}
			}	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("El archivo no se ha encontrado");
		}
		return cantidad;
		
		
	}
	/**
	 * Metodo que dice cual es la palabra mas larga
	 * @param ruta
	 * @return
	 */
	public String tamanioPalabras(String ruta) {
		int longitud = 0, contadorPalabra = 0, posicion = 0;
		String palabra = "", antigua = "";
		String s = null;

		try {

			FileReader fr = new FileReader(ruta);
			int i;
			try {
				while ((i = fr.read()) != -1) {//para leer caracteres hasta el final del archivo
					if (esLetra((char) i)) {

						palabra = palabra + ((char) i);//si es letra se añade al String para formar la palabra

					} else {

						if (palabra.length() != 0) {
							contadorPalabra++;
						}

						if (palabra.length() > longitud) {//comprueba que la palabra sea mas larga que la anterior mas larga
							antigua = palabra; // si es mas larga se guarda 
							longitud = palabra.length();//guarda la longitud
							posicion = contadorPalabra;// guarda la posicion que tiene en el archivo
						}

						palabra = "";// se inicializa para guardar la siguiente palabra a leer
					}
				}
				s = "La palabra mas larga es: " + antigua;
				s += " Su longitud es: " + antigua.length();

				//fr.close();

			} catch (IOException io) {
				System.out.println("Error de E/S del fichero");
			}finally{
				try {
					fr.close();
				} catch (IOException e) {
					System.out.println("Error al cerrar el fichero");
					//e.printStackTrace();
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println("El fichero no se ha encontrado");
		}
		return s;
	}

	 /*Este Metodo mira si la letra es una vocal y en el caso de serla cuenta
    	** que vocal es.
	 */
  public  int[] esVocal(char letra, int[] arrayVocales) {

        Character.toLowerCase(letra);      
        if (letra == 'a' || letra == 'e' || letra == 'i'|| letra == 'o'|| letra == 'u') {
            if ((char) letra == 'a') {
                arrayVocales[0]++;
            } else if ((char) letra == 'e') {
                arrayVocales[1]++;
            } else if ((char) letra == 'i') {
                arrayVocales[2]++;
            } else if ((char) letra == 'o') {
                arrayVocales[3]++;
            } else if ((char) letra == 'u') {
                arrayVocales[4]++;
            }

        }
        return arrayVocales;
    }

    public String contarVocales(String ruta) {
        File f = new File(ruta);
        FileReader fr = null;
        int[] arrayVocales = new int[5];
        arrayVocales[0] = 0;//Aqui se cuentan todas las vocales que sean a
        arrayVocales[1] = 0;//Aqui se cuentan todas las vocales que sean e
        arrayVocales[2] = 0;//Aqui se cuentan todas las vocales que sean i
        arrayVocales[3] = 0;//Aqui se cuentan todas las vocales que sean o
        arrayVocales[4] = 0;//Aqui se cuentan todas las vocales que sean u
        try {
            int letra;
            fr = new FileReader(f);
            try {
                while ((letra = fr.read()) != -1) {
                    arrayVocales = esVocal((char) letra, arrayVocales);
                }
            } catch (IOException ex) {
                System.err.println("El archivo no se puede abrir");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("El archivo no se encuentra");
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {

                System.err.println("Error E/S");

                Logger.getLogger(Ejercicio5.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
        return "a:" + arrayVocales[0] + "\ne:" + arrayVocales[1] + "\ni:" + arrayVocales[2] + "\no:" + arrayVocales[3] + "\nu:" + arrayVocales[4];
    }

	static String ruta = "the_hunger_games.txt";

	public int numeroPalabras(String ruta) {
		int numDePalabras = 0;
		boolean leoPalabra = false;
		File f = new File(ruta);
		FileReader fr = null;
		try {
			fr = new FileReader(f);
			int i;
			while ((i = fr.read()) != -1) { // Se realiza un lectura caracter a
				// caracter
				if (leoPalabra) {
					if (!esCaracter((char) i)) {
						numDePalabras++;
					}
				} else if (esCaracter((char) i)) {
					leoPalabra = true;
				}
			}// fin while
		} catch (FileNotFoundException ex) {
			System.err.println("Archivo no encontrado");
		} catch (IOException e) {
			System.err.println("No se ha podido leer el archivo");
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				System.err.println("No se ha podido cerrar el archivo");
			}
		}
		return numDePalabras;
	}

	/**
	 *
	 * @param ruta
	 * @return
	 */
	public int calcularNumeroDeCaracteres(String ruta) {
		FileReader fr = null;
		int numDeCaracteres = 0;
		try {
			File f = new File(ruta);
			fr = new FileReader(f);
			int letra;
			while ((letra = fr.read()) != -1) {
				if (esCaracterONumero((char) letra))
					numDeCaracteres++;
			}
		} catch (IOException e) {
			System.err.println("Se ha producido una excepción");
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				System.err.println("Se ha producido una excepción");
			}
		}
		return numDeCaracteres;
	}

	// metodo para contar las lineas de un texto
	public int contarLineas(String ruta) {
		BufferedReader bfr = null;
		int numLineas = 0;
		try {
			bfr = new BufferedReader(new FileReader(ruta));
			while ((bfr.readLine()) != null) {
				numLineas++;
			}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
		} catch (IOException ioe) {
			System.err.println("Error E/S");
		} finally {
			try {
				bfr.close();
			} catch (IOException e) {
				System.err.println("Error de E/S");
			}
		}
		return numLineas;
	}

	/**
	 *
	 * @param letra
	 * @return
	 */
	public boolean esCaracter(char letra) {
		return Character.isLetter(letra);
	}

	/**
	 *
	 * @param letra
	 * @return
	 */
	public boolean esCaracterONumero(char letra) {
		return Character.isLetterOrDigit(letra);
	}

	/**
	 *
	 * @param ruta
	 * @return
	 */
	public int calcularLetras(String ruta) {
		try {
			File f = new File(ruta);
			FileReader fr = new FileReader(f);
			int i;
			int car = 0;
			while ((i = fr.read()) != -1) { // Se lee Todo 1 a 1
				if (esLetra((char) i) || esRara((char) i)) {
					car++;
				}
			}
			fr.close();
			return car;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}

	/**
	 *
	 * @param i
	 * @return
	 */
	private boolean esLetra(char i) {
		if (i >= 'a' && i <= 'z' || i >= 'A' && i <= 'Z') {
			return true;
		} else
			return false;
	}

	/**
	 *
	 * @param i
	 * @return
	 */
	private boolean esRara(char i) {
		boolean rara = false;
		switch (i) {
		case 'á':
			rara = true;
			break;
		case 'é':
			rara = true;
			break;
		case 'í':
			rara = true;
			break;
		case 'ó':
			rara = true;
			break;
		case 'ü':
		case 'ú':
			rara = true;
			break;
		}
		return rara;
	}


	/**
	 * Metodo que cuenta las letras minusculas del archivo
	 */
	public int contarMinusculas(String ruta) {
		FileReader fr = null;
		int cantidad = 0;
		try {
			String fichero = ruta;
			fr = new FileReader(fichero);
			int i;
			while ((i = fr.read()) != -1) {
				if (esMinuscula(i)) {
					cantidad++;
				}
			}
		} catch (IOException e) {
			System.err.println("Error al leer el fichero");
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				System.err.println("Error al cerrar el fichero");
			}
		}
		return cantidad;
	}

	public boolean esMinuscula(int i) {
		// return ('a' <= (char) i) && ('z' >= (char) i);
		return Character.isLowerCase(i);

	}
	
	/**
	 * Metodo que cuenta los capitulos
	 * 
	 * @param ruta
	 * @return
	 */
	public int contarCapitulos(String ruta) {
		int contadorCapitulos = 0;
		int capitulos = 1;
		BufferedReader bfr = null;
		String linea;
		
		try {
			bfr = new BufferedReader(new FileReader(ruta));
			while((linea = bfr.readLine()) != null){
				if(linea.equalsIgnoreCase(capitulos + ".")){
					contadorCapitulos++;
					capitulos++;
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
		} catch (IOException ioe){
			System.err.println("Error E/S");
		}finally{
			try {
				bfr.close();
			} catch (IOException e) {
				System.err.println("Error E/S");
			}
		}
		return contadorCapitulos;

	}
}
