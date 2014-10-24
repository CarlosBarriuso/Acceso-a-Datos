package es.torval.test;

import static org.junit.Assert.*;
import org.junit.Test;
import es.torval.Ejercicio5;

public class TestEjercicio5 {
	Ejercicio5 e = new Ejercicio5();
	String ruta = "./resources/the_hunger_games.txt";
	String ruta2 = "./resources/200000.txt";
	String ruta3 = "./resources/Raro.txt";

	@Test
	public vod palabraTerminaEn() {
		assertEquals(292, e.palabraTerminaEn());
	}

	@Test
	public void contarPalabraLarga() {
		assertEquals(
				"La palabra mas larga es: uncomprehendingly Su longitud es: 17",
				e.tamanioPalabras(ruta));
	}

	@Test
	public void palabraTerminaEn() {
		assertEquals(289, e.palabraTerminaEn(ruta));
	}

	@Test
	public void testesMinuscula() {
		assertFalse("L", e.esMinuscula('L'));
		assertFalse("R", e.esMinuscula('R'));
		assertFalse(e.esMinuscula('Ñ'));
		assertFalse(e.esMinuscula('F'));
		assertFalse(e.esMinuscula('1'));
		assertTrue("ñ", e.esMinuscula('ñ'));
		assertTrue(e.esMinuscula('q'));
		assertTrue("á", e.esMinuscula('á'));
		assertTrue("ü", e.esMinuscula('ü'));
		for (char letra = 'a'; letra < 'z'; letra++)
			assertTrue("letra " + letra, e.esMinuscula(letra));
	}

	public void testContarLineas() {
		assertEquals(1071, e.contarLineas(ruta));
	}

	@Test
	public void testCaracteres() {
		assertFalse(e.esCaracter('@'));
		assertFalse(e.esCaracter('.'));
		assertFalse(e.esCaracter(','));
		assertFalse(e.esCaracter(' '));
		assertTrue(e.esCaracter('a'));
		assertTrue(e.esCaracter('ñ'));
		assertTrue(e.esCaracter('á'));
		assertTrue(e.esCaracter('ü'));
		assertFalse(e.esCaracter('1'));
	}

	@Test
	public void testContarCaracteres() {
		assertEquals(405770, e.calcularNumeroDeCaracteres(ruta));
		assertEquals(200000, e.calcularNumeroDeCaracteres(ruta2));
		assertEquals(1, e.calcularNumeroDeCaracteres(ruta3));
	}

	@Test
	public void testContarLetras() {
		assertEquals(405424, e.calcularLetras(ruta));
		assertEquals(167867, e.calcularLetras(ruta2));
		assertEquals(1, e.calcularLetras(ruta3));
	}

	@Test
	public void testContarMinusculas() {
		assertEquals(391113, e.contarMinusculas(ruta));
	}

	@Test
	public void testContarCapitulos() {
		assertEquals(27, e.contarCapitulos(ruta));
	}
}
