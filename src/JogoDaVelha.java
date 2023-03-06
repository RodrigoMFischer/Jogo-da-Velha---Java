import java.util.Scanner;

public class JogoDaVelha {
	private char[][] tabuleiro;
	private int maxJogadas; // calcula o máximo de jogadas do tabuleiro para encerrar a partida quando atingir máximo
	private int jogadasFeitas; // salva o estado do tabuleiro em caso de exceção continua de onde parou se for = maxJogadas encerra partida

	public JogoDaVelha(int tamanho) {
		this.tabuleiro = new char[tamanho][tamanho];
		this.maxJogadas = tamanho*tamanho;
		this.jogadasFeitas = 0;
	}

	public char[][] getTabuleiro() {
		return tabuleiro;
	}
	
	public int getMaxJogadas() {
		return maxJogadas;
	}

	public void setMaxJogadas(int maxJogadas) {
		this.maxJogadas = maxJogadas;
	}

	public void setTabuleiro(int linha, int coluna, char jogada) {
		this.tabuleiro[linha][coluna] = jogada;
	}	
	
	public int getJogadasFeitas() {
		return jogadasFeitas;
	}

	public void setJogadasFeitas(int jogadasFeitas) {
		this.jogadasFeitas = jogadasFeitas;
	}

	public String toString() {
		String tabu = "TABULEIRO\n";
		for (int linha = 0; linha < getTabuleiro().length; linha++){ 
			for(int coluna = 0; coluna < getTabuleiro()[linha].length; coluna++) 
				tabu += " " + getTabuleiro()[linha][coluna];
			tabu += "\n";
		}
		return tabu;
	}
	
	public boolean realizaJogada (int linha, int coluna, char jogada){
		boolean jogadaFeita = false;
		if (getTabuleiro()[linha][coluna] == 0 ){
			setTabuleiro(linha, coluna, jogada);
			jogadaFeita = true;			
		}
		return jogadaFeita;
	}
	
	public boolean verificaLinha (){
		boolean ganhador = false;
		for(int linha = 0; linha < getTabuleiro().length; linha++){
			if(ganhador)
				break;
			for(int coluna = 0; coluna < getTabuleiro().length; coluna++){//apontei o length com menor caminho, pois tanto faz neste caso
				//System.out.println("1");
				if(getTabuleiro()[linha][0] == 0 || getTabuleiro()[linha][0] != getTabuleiro()[linha][coluna]){
					ganhador = false;					
					break;
				}
				else {
					ganhador = true;														
				}					
			}			
		}
		return ganhador;	
	}
	
	public boolean verificaColuna (){
		boolean ganhador = false;
		for(int coluna = 0; coluna < getTabuleiro().length; coluna++ ){
			if(ganhador)
				break;
			for(int linha = 0; linha < getTabuleiro().length; linha++){
				//System.out.println("2");				
				if(getTabuleiro()[0][coluna] == 0 || getTabuleiro()[0][coluna] != getTabuleiro()[linha][coluna]){
					ganhador = false;					
					break;
				}
				else {
					ganhador = true;														
				}					
			}			
		}
		return ganhador;	
	}
	
	public boolean verificaDiagonal(){
		boolean ganhador = false;
		for(int linha = 0; linha < getTabuleiro().length; linha++){
			//System.out.println("3");
			if(getTabuleiro()[0][0] == 0 || getTabuleiro()[0][0] != getTabuleiro()[linha][linha]){
				ganhador = false;					
				break;
			}
			else {
				ganhador = true;												
			}					
		}
		return ganhador;
	}
	
	public boolean verificaDiagonalSec (){
		boolean ganhador = false;
		int linha = getTabuleiro().length - 1;
		for(int coluna = 0; coluna < getTabuleiro().length; coluna++){			
			//System.out.println("4");
			if(getTabuleiro()[getTabuleiro().length - 1][0] == 0 ||
					getTabuleiro()[getTabuleiro().length - 1][0] != getTabuleiro()[linha][coluna]){
				ganhador = false;					
				break;
				}
				else {
					ganhador = true;													
				}			
			linha--;
			}		
		return ganhador;	
	}
	
	public boolean verificaGanhador(){ // metodo agrupa as verificações acima
		boolean ganhador = false;
		if(verificaLinha() || verificaColuna() || verificaDiagonal() || verificaDiagonalSec ())
			ganhador = true;
				
		return ganhador;		
	}
	
	public void iniciaJogo(Jogador um, Jogador dois, JogoDaVelha tabuleiro, Scanner teclado){
		// metodo recebe os jogadores, tabuleiro e scanner e controla toda a partida
		int linha = 0;
		int coluna = 0;
		System.out.println("Que o jogo comece!");
		while (true){
			if(tabuleiro.getJogadasFeitas() == tabuleiro.getMaxJogadas()){
				System.out.println("O jogo terminou sem ganhadores!!");				
				break;
			}
			else if(tabuleiro.verificaGanhador() && tabuleiro.getJogadasFeitas() % 2 != 0){
				System.out.println(um.getNome()+" é o Campeão |o|");
				um.setPontos(um.getPontos()+ 1);
				break;
			}
			else if (tabuleiro.verificaGanhador() && tabuleiro.getJogadasFeitas() % 2 == 0){
				System.out.println(dois.getNome()+" é o Campeão |o|");
				dois.setPontos(dois.getPontos()+ 1);
				break;
			}
			
			try{
			if (tabuleiro.getJogadasFeitas() % 2 == 0){
				System.out.println(um.getNome()+", informe a linha");
				linha = teclado.nextInt();
				System.out.println(um.getNome()+", informe a coluna");
				coluna = teclado.nextInt();
				while (!tabuleiro.realizaJogada(linha, coluna, um.getJogada())){
					System.out.println("Já existe jogada na cordenada.\nVerifique o tabuleiro abaixo");
					System.out.println(tabuleiro);
					System.out.println(um.getNome()+", informe a linha");
					linha = teclado.nextInt();
					System.out.println(um.getNome()+", informe a coluna");
					coluna = teclado.nextInt();
				}				
			}
			else{
				System.out.println(dois.getNome()+", informe a linha");
				linha = teclado.nextInt();
				System.out.println(dois.getNome()+", informe a coluna");
				coluna = teclado.nextInt();
				while (!tabuleiro.realizaJogada(linha, coluna, dois.getJogada())){
					System.out.println("Já existe jogada na cordenada.\nVerifique o tabuleiro abaixo");
					System.out.println(tabuleiro);
					System.out.println(dois.getNome()+", informe a linha");
					linha = teclado.nextInt();
					System.out.println(dois.getNome()+", informe a coluna");
					coluna = teclado.nextInt();
				}				
			}
			System.out.println(tabuleiro);
			tabuleiro.setJogadasFeitas(tabuleiro.getJogadasFeitas()+1);			
			}catch (Exception erro){
				System.out.println("Preste mais atenção, digitou um valor inválido.\n"
						+ "Refaça essa jogada!!");
				teclado.nextLine();//Consome o buffer caso tenha entrado no catch
			}
		}
	}
}
