
import java.util.Scanner;

/*Implementar um programa que receba como parâmetro de entrada 1 (um) texto e
retorne a quantidade de caracteres, o 1º e último caractere.
Exemplo 1:
* Entrada
è Texto: APTARE TECNOLOGIA
** Saída
è Quantidade de Caracteres: 23
è 1º caractere: A
è Último Caractere: A
*/

public class Questao_01 {

	public static void main(String[] args) {

		// variaveis
		String texto;
		char ultimaletra2;
		int contador = 0;
		char primeiraletra;
	
	
		// mecanismo de captação de dados
		Scanner ler = new Scanner(System.in);

		System.out.println("Digite uma palavra");
		texto = ler.nextLine();
		
	

		// conta a quantidade de caractere
		
		System.out.println("quantidade de caracteres" + ":" + "" + texto.length());
		

		// pega a primeira letra
		primeiraletra = texto.charAt(0);
		System.out.println("Primeiro Caractere" + ":" + "" + primeiraletra);

		// ultimo contador
		contador = texto.length();
		contador = contador - 1;
		ultimaletra2 = texto.charAt(contador);
		System.out.println("Ultimo Caractere" + ":" + "" + ultimaletra2);

	}

}
