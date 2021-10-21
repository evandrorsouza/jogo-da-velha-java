package entities;

public class Tabuleiro {
	
	private String[][] tabuleiro;

	public Tabuleiro(int linha, int coluna) {
		
		this.tabuleiro = new String[linha][coluna];
		
		for (int i = 0; i < linha; i++) {					
			for (int j = 0; j < coluna; j++) {				
				tabuleiro[i][j] = " ";				
			}			
		}		
		
	}

	public String[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(String[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}	
	
	
	public void imprimirTabuleiro() {
		
		System.out.println("  0 1 2 "); 
		System.out.println("0|" + tabuleiro[0][0] + "|" + tabuleiro[0][1] + "|" + tabuleiro[0][2]);
		System.out.println("1|" + tabuleiro[1][0] + "|" + tabuleiro[1][1] + "|" + tabuleiro[1][2]);
		System.out.println("2|" + tabuleiro[2][0] + "|" + tabuleiro[2][1] + "|" + tabuleiro[2][2]);

		 
	}

	public boolean validaCampo(int linha, int coluna, String marca) {

		boolean retorno = true;
		
		if (tabuleiro[linha][coluna].equals(" ")) {
			marcarJogada(linha, coluna, marca);
		}else {
			retorno = false;
		}

		return retorno;
	}
	
	public void marcarJogada(int linha, int coluna, String marca) {		
		tabuleiro[linha][coluna] = marca;		
	}

	public boolean gameOver() {		
		
		if (gameOverHorizontal()) {
			return true;
		}
		
		if (gameOverVertical()) {
			return true;
		}
		
		if (gameOverDiagonal()) {
			return true;
		}
		
		return false;
	}

	private boolean gameOverHorizontal() {
		boolean retorno = false;
		
		for (int i = 0; i < 3; i++) {
			
			if (!tabuleiro[i][0].equals(" ")) {
				if (tabuleiro[i][0].equals(tabuleiro[i][1])) {				
					if (tabuleiro[i][0].equals(tabuleiro[i][2])) {
						retorno = true;
						break;
					}
				}
			}
						
		}
				
		return retorno;
	}
	
	private boolean gameOverVertical() {
		boolean retorno = false;
		
		for (int i = 0; i < 3; i++) {
			
			if (!tabuleiro[0][i].equals(" ")) {
				if (tabuleiro[0][i].equals(tabuleiro[1][i])) {				
					if (tabuleiro[0][i].equals(tabuleiro[2][i])) {
						retorno = true;
						break;
					}
				}
			}
						
		}

		return retorno;
	}
	
	private boolean gameOverDiagonal() {
		boolean retorno = false;
		
		if (!tabuleiro[0][0].equals(" ")) {
			if (tabuleiro[0][0].equals(tabuleiro[1][1])) {				
				if (tabuleiro[0][0].equals(tabuleiro[2][2])) {
					return true;
				}
			}
		}
		
		if (!tabuleiro[0][2].equals(" ")) {
			if (tabuleiro[0][2].equals(tabuleiro[1][1])) {				
				if (tabuleiro[0][2].equals(tabuleiro[2][0])) {
					return true;
				}
			}
		}
		
		return retorno;
	}
	
	

}
