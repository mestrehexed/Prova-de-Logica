import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*Implementar um programa que receba como parâmetro de entrada as seguintes
informações: data de referência, dia de vencimento e quantidade de dias de corte.
Com essas informações, o método deverá retornar a data de vencimento e a data de
apuração baseado nos parâmetros de entrada. Os parâmetros de entrada deverão
ser solicitados do usuário. Segue exemplo abaixo:*/

public class Questao_06 {
	public static void main(String[] args) throws ParseException {

		Scanner dataler = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();

		System.out.println("DIGITE A DATA DE REFERENCIA" + "  " + "Exemplo:" + " " + "10/03/2020");
		String data1 = dataler.next();
		Date data = sdf.parse(data1);
		cal.setTime(data);
		int soma = cal.get(Calendar.DAY_OF_MONTH);

		System.out.println(soma);

		System.out.println("DIGITE O DIA DE VENCIMENTO" + "  " + "Exemplo:" + " " + "20");
		int datav = dataler.nextInt();

		System.out.println(datav);

		// System.out.println("'"+psql2+"'");

		System.out.println("DIGITE A quantidade de dias de corte" + "  " + "Exemplo:" + " " + "5");
		int qtdcorte = dataler.nextInt();

		System.out.println(qtdcorte);
		int soma2=soma;
		//logica da apuração
		soma=soma+qtdcorte;
		cal.set(Calendar.DAY_OF_MONTH,soma);
		data = cal.getTime();
		System.out.println("A data de apuração é:"+"  "+ sdf.format(data));
		
		//logica do vencimento
		cal.set(Calendar.DAY_OF_MONTH,datav);
		Date data2 = cal.getTime();
		System.out.println("A data do vencimento é:"+"  "+ sdf.format(data2));
	
		
		
		
		
		
		
	}
}
