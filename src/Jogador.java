import java.util.Scanner;

public class Jogador {
	private String nome;
	private int pontos;
	private char jogada; //atributo que determina se jogador joga com X ou O
	
	public Jogador(Scanner teclado, char jogada) {
		System.out.println("Digite o nome do Jogador");
		this.nome = teclado.nextLine();
		this.pontos = 0;
		this.jogada = jogada;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}	
	public char getJogada() {
		return jogada;
	}
	public void setJogada(char jogada) {
		this.jogada = jogada;
	}
	public String toString() {
		return "Jogador = " + nome + ", pontos = " + pontos + ", joga com = "
				+ jogada + "]";
	}
	
	
	
	
}
