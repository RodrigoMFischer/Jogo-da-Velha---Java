import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
	
	public static void main (String [] args){
		Scanner teclado = new Scanner(System.in);
		
		Jogador jogador1 = new Jogador(teclado, 'X');
		Jogador jogador2 = new Jogador(teclado, 'O');
		
		System.out.println("\n"+jogador1);
		System.out.println(jogador2+"\n");
		
		while(true){
			System.out.println("Informe o tamanho do tabuleiro:");
			int tamanho = 3;
			try{
				tamanho = teclado.nextInt();
			}catch (InputMismatchException erro){
				System.out.println("Esperamos um número inteiro!! Não sabe o que é??\n"
						+ "Deixa que escolhemos pra você!!"	);
				teclado.nextLine();
			}
			JogoDaVelha jv = new JogoDaVelha(tamanho);
			System.out.println(jv);
						
			jv.iniciaJogo(jogador1, jogador2, jv, teclado);
		
			System.out.println("Vocês gostariam de continuar jogando?\n Digite 1 para SIM e 2 para NÃO");
			int continua = 0;
			try{
			continua = teclado.nextInt();
			}catch (Exception e){
				System.out.println("Digitou algo diferente de 1, entendemos que queira parar\n"
						+ "Obrigado por jogar, esperamos que volte!");
			}
			if (continua != 1)
				break;
		}		
		System.out.println(jogador1);
		System.out.println(jogador2);
}}
	

