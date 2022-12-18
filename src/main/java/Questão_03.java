import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.ConsoleAppender;

public class Questão_03 {
	public static void main(String[] args) throws ParseException {

/*Implementar um programa que receba como parâmetro de entrada uma data. Com
essa informação, o método deverá pegar os números que compõem o dia e somar. O
resultado da soma deverá adicionar na quantidade de dias da data informada. Segue
exemplo abaixo:
Exemplo 1:
* Entrada
è Data de referência: 23/08/2020
** Saída
è Nova Data: 28/08/2020*/
		int index= 0;
		int total=0;
		int dia=0;
		double dia2=0;
		int[] array= new int[1];
		
		
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal= Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("       "+"Indique sua Data");
		System.out.print("A data antiga é:"+"  "); Date data = sdf.parse(sc.next());
        
		cal.setTime(data);
		
				
		
		
		dia = cal.get(Calendar.DAY_OF_MONTH);
		dia2= dia;
		dia2 = dia2/10;
		array[index] = (int) dia2;
		String s = String.valueOf(dia2); // converter para String
		String s1 = s.split("\\.")[1]; //quebrar aonde esta o ponto e pegar o valor após
		double x  = Double.valueOf(s1); //converter de volta para double
		
		total =(int) (x+dia2); // soma os dois valores
		cal.add(Calendar.DAY_OF_MONTH,total);
		data = cal.getTime();
		System.out.println("A data nova é:"+"  "+ sdf.format(data));
		
		
		
		
		
		
		
		
	}
}