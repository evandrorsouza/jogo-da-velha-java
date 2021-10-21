package application;

import java.util.Random;
import java.util.Scanner;

import entities.Jogador;
import entities.Tabuleiro;

public class Program{

	static Scanner scanner;

	public static void main(String[] args) {
		
		int velha = 0;		
		
		String nome1 = null;
		String nome2 = null; 
		
		scanner = new Scanner(System.in);
		
		Tabuleiro tabuleiro = new Tabuleiro(3, 3);
		
		System.out.print("Jogador 1 insira seu nome: ");
		
		Jogador jogador_1 = new Jogador(scanner.nextLine());
		
		System.out.print("Jogador 2 insira seu nome: ");
		
		Jogador jogador_2 = new Jogador(scanner.nextLine());		
		
		Jogador turno = sortear(jogador_1, jogador_2);
		
		boolean game_over = false;
		
		do {
			
			System.out.println("Jogador " + turno.getNome() + ", faça sua jogada!");
			System.out.println("");
			
			System.out.println("Tabuleiro:  ");
			tabuleiro.imprimirTabuleiro();
			System.out.println("");
			
			
			int linha;
			int coluna = 0;
			
				
			System.out.print("Escolha a linha: ");	
			
		
			 linha = validaValor(scanner.nextInt());
			
			
			System.out.println("");
			System.out.print("Escolha a coluna: ");	
			
		
			 coluna = validaValor(scanner.nextInt());			
		
			
			if(tabuleiro.validaCampo(linha, coluna, turno.getMarca())) {
				
				velha++;
				
				for (int i = 0; i < 100; i++) {
					System.out.println("");
				}
				
				game_over = tabuleiro.gameOver();
				
				if (!game_over) {
					
					System.out.println("Jogada realizada: ");
					System.out.println("");
					tabuleiro.imprimirTabuleiro();
					System.out.println("");
					
					if(turno.getNome().equals(jogador_1.getNome())) {					
						turno = jogador_2;
					}else {					
						turno = jogador_1;					
					}
					
					if (velha >= 9) {
						game_over = true;
					}
					
				}				
				
			}else {
				
				/*for (int i = 0; i < 100; i++) {
					System.out.println("");
				}*/
				
				System.out.println("Esta jogada não pode ser realizada! ");
				System.out.println("");
				System.out.println("Escolha outro campo: ");
				System.out.println("");
				tabuleiro.imprimirTabuleiro();
				
			}							
			
		} while (!game_over);
		
		if (velha >= 9) {
			for (int i = 0; i < 100; i++) {
				System.out.println("");
			}
			System.out.println("DEU VELHA! ");
			System.out.println("");
			System.out.println("Tabuleiro: ");
			System.out.println("");
			tabuleiro.imprimirTabuleiro();
		}else {
			System.out.println("PARABÉNS " + turno.getNome() + "! ");
			System.out.println("");
			System.out.println("VOCÊ VENCEU! ");
			System.out.println("");
			System.out.println("Tabuleiro: ");
			System.out.println("");
			tabuleiro.imprimirTabuleiro();
		}		
		
		scanner.close();
	}
	
	
	

	public static Jogador sortear(Jogador cara, Jogador coroa ){

		Random lancar = new Random();		
		int sorteado = lancar.nextInt( 2 );		
		Jogador retorno = new Jogador("");
		
		switch( sorteado )
		{
			case 0:				
				retorno = cara;		
				break;
			case 1:				
				retorno = coroa;
				break;
		}
		
		retorno.setMarca("X");
		
		if(retorno.getNome().equals(cara.getNome())) {
			cara.setMarca("X");	
			coroa.setMarca("O");	
		}else {			
			cara.setMarca("O");
			coroa.setMarca("X");
		}		
		
		return retorno;	
	}
	
	/*public static int validaString(String string) {
				
		int valor = 0;
		
		try {
			
			valor = Integer.parseInt(string);			
						
			validaValor(valor);
			
		} catch (Exception e) {
			
			System.out.println("Valor inválido! \n");			
			System.out.print("Digite um valor entre 0 e 2 : ");
			
			validaString(scanner.nextLine());
		}
		
		return valor;
				
	}*/
	
	public static int validaValor(int valor) {
		
		while(valor > 2 || valor < 0) {
		
			
			System.out.println("Valor inválido! \n");			
			System.out.print("Digite um valor entre 0 e 2 : ");
			
			validaValor(scanner.nextInt());

		}
		
		return valor;		
		
	}
}
