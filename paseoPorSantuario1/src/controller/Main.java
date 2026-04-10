package controller;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		int respuesta = 0;
		int numeroAleatorio;
		int numBatallas = 3;
		
		int numeroSecreto = 67;
		
		int suma = 300;
		
		
		//comentario nuevo

		String clase;
		String armaPrincipal;
		int vidaPersonaje = 0;
		int vidaOriginal = 0;
		int ataquePersonaje = 0;
		int bonusArma = 0;

		String arma1 = "Espada"; // +1
		String arma2 = "Hacha"; // +4
		String arma3 = "Báculo"; // +5
		String arma4 = "Jabalina"; // +2
		String arma5 = "Arco"; // +3

		String enemigo1 = "Goblin";
		String enemigo2 = "Araña";
		String enemigo3 = "Esqueleto";
		String enemigo4 = "Cultista";

		String enemigoElegido;
		int vidaEnemigo = 0;
		int vidaEnemigoOriginal = 0;
		int ataqueEnemigo = 0;

		System.out.println("Bienvenido a Santuario. Elige una clase");

		do {

			System.out.println("CLASES DISPONIBLES (ELIGE EL NÚMERO DE LA CLASE QUE QUIERAS)");
			System.out.println("============================================================");
			System.out.println("1 - Bárbaro");
			System.out.println("2 - Paladín");
			System.out.println("3 - Amazona");
			System.out.println("4 - Hechicero");

			respuesta = sc.nextInt();

			if (respuesta < 1 || respuesta > 4) {
				System.out.println();
				System.out.println("RESPUESTA ERRÓNEA, INTRODUCE UN NÚMERO CORRECTO");
				System.out.println();
			}

		} while (respuesta < 1 || respuesta > 4);

		if (respuesta == 1) {

			clase = "Bárbaro";
			armaPrincipal = arma2;
			vidaPersonaje = 100;
			ataquePersonaje = 6;
			bonusArma = 4;

		} else if (respuesta == 2) {

			clase = "Paladín";
			armaPrincipal = arma1;
			vidaPersonaje = 150;
			ataquePersonaje = 20;
			bonusArma = 1;

		} else if (respuesta == 3) {

			clase = "Amazona";
			armaPrincipal = arma4;
			vidaPersonaje = 80;
			ataquePersonaje = 12;
			bonusArma = 2;

		} else {

			clase = "Hechicero";
			armaPrincipal = arma3;
			vidaPersonaje = 60;
			ataquePersonaje = 25;
			bonusArma = 5;
		}

		System.out.println("La clase elegida es: " + clase);

		System.out.println("Tu arma inicial es: " + armaPrincipal);

		vidaOriginal = vidaPersonaje;

		while (numBatallas > 0 && vidaPersonaje > 0) {
			numeroAleatorio = rd.nextInt(0, 4);

			System.out.println();
			System.out.println("Avanzas por la espesura, y de repente...");
			System.out.println();

			// asignación de stats al enemigo aleatorio
			if (numeroAleatorio == 0) {
				enemigoElegido = enemigo1;
				vidaEnemigo = 25;
				ataqueEnemigo = 4;
			} else if (numeroAleatorio == 1) {
				enemigoElegido = enemigo2;
				vidaEnemigo = 50;
				ataqueEnemigo = 6;
			} else if (numeroAleatorio == 2) {
				enemigoElegido = enemigo3;
				vidaEnemigo = 75;
				ataqueEnemigo = 8;
			} else {
				enemigoElegido = enemigo4;
				vidaEnemigo = 100;
				ataqueEnemigo = 10;
			}

			System.out.println("Te sale al paso el siguiente enemigo: " + enemigoElegido);

			vidaEnemigoOriginal = vidaEnemigo;

			while (vidaPersonaje > 0 && vidaEnemigo > 0) {

				System.out.println();
				System.out.println(clase + " ataca a " + enemigoElegido + " con su " + armaPrincipal);
				int potenciaAtaque = ataquePersonaje + bonusArma;
				System.out.println(enemigoElegido + " recibe un ataque de " + potenciaAtaque + " puntos de daño");
				vidaEnemigo -= potenciaAtaque;

				if (vidaEnemigo > 0) {
					System.out.println();
					System.out.println(enemigoElegido + " ataca a " + clase);
					System.out.println(clase + " recibe un ataque de " + ataqueEnemigo + " puntos de daño");
					vidaPersonaje -= ataqueEnemigo;
				} else {
					vidaEnemigo = 0;
				}

				if (vidaPersonaje < 0) {
					vidaPersonaje = 0;
				}

				System.out.println();
				System.out.println("Puntos de vida de " + clase + ": " + vidaPersonaje + "/" + vidaOriginal);
				System.out.println(
						"Puntos de vida de " + enemigoElegido + ": " + vidaEnemigo + "/" + vidaEnemigoOriginal);

			}

			System.out.println("FIN DEL COMBATE");
			numBatallas--;
		}

		if (vidaPersonaje == 0) {
			System.out.println("GAME OVER");
		} else {
			System.out.println("ENHORABUENA, AVENTURERO, HAS SALVADO SANTUARIO");
		}

	}

}
