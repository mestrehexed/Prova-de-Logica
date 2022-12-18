
import java.util.Scanner;

/*

Implementar um programa que receba como parâmetro de entrada 4 números inteiros
diversos e a ordem de exibi-los, crescente ou decrescentes. Além disso, informar
quantos e quais números são pares e ímpares. Exibir também na mesma ordem
definida pelo usuário.
Exemplo 1:
* Entrada
è Números: 10, 109, 864, 88
è Ordem de Exibição: Crescente
** Saída
è Números ordenados: 10, 88, 109, 864
è Quantidade de Números Pares: 3
è Exibindo Números Pares: 10, 88, 864
è Quantidade de Números Ímpares: 1
è Exibindo Números Ímpares: 109

*/
public class Questao_02 {
	public static void main(String[] args) {

		//Ordem de Exibição: Crescente
		int[] array = new int[] {10, 7, 1, 8};
		int[] arraypar =  new int[3];
		int[] arrayimpar =  new int[3];
		int index1 = 0;
		int indexpar=0;
		int indeximpar=0;
		int index1count=0;
		int a1 = 0;
		int a2 = 0;
		int count=0;
		int par=0;
		int impar=0;
		
		
		while(count != 16) {
			count++;
			index1=0;
		for (int i = 0; i < 3; i++) {
			a1=array[index1];
			index1count=index1;
			index1++;
				
			
		for (int j = 0; j < 3; j++) {
			if(a1>array[index1]) {
				a2=array[index1];
				array[index1]=a1;
				array[index1count]=a2;
			}
	    
		
		}	
		}
		}
		
		System.out.print("Ordem de Exibição: Crescente");
		System.out.println("");
		System.out.print("Numeros Ordenados:");
		for (int i22 = 0; i22 < 4; i22++) {
			
			System.out.print("  "+array[i22]);	
		}
		
		
		
	
				
		
		for (int i21 = 0; i21 < 4; i21++) {
		if((array[i21]  % 2) == 0) {
			par++;
		   arraypar[indexpar++]=array[i21];
	     	
		}
		}
		System.out.println("");
		System.out.println("quantidade de pares:"+" "+par );
		System.out.print("Exibindo Números pares:");
		for (int i = 0; i < 3; i++) {
			if(arraypar[i]!=0) {
			System.out.print(" "+arraypar[i]);
			}
		}
		System.out.println("");
		
		
		
		for (int i25 = 0; i25 < 4; i25++) {
		if((array[i25]  % 2) != 0){ 
		   	impar++;
		   	arrayimpar[indeximpar++]=array[i25];
	   	}
		
		}
		System.out.println("");
		System.out.println("quantidade de impares:"+" "+impar);
		System.out.print("Exibindo Números ímpares:");
		for (int i = 0; i < 3; i++) {
			if(arrayimpar[i]!=0) {
			System.out.print(" "+arrayimpar[i]);
			}
		}
		System.out.println("");
		
		
	
	}
}
