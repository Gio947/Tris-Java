import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Gioco {

	public Gioco() {
		
	}
	
	public String nominativo1() {
		return JOptionPane.showInputDialog(null, "Nome giocatore 1:" , "TRIS", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public String nominativo2() {
		return JOptionPane.showInputDialog(null, "Nome giocatore 2:" , "TRIS", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * eseguo le schermate di fine partite
	 * @param esitoPartita l'esito della partita
	 * @param bottoni i bottoni del tris
	 * @param giocatore1 il nome del giocatore1
	 * @param giocatore2 il nome del giocatore2
	 */
	public void finePartita(int esitoPartita, JButton[] bottoni,String giocatore1, String giocatore2) {
		
		int scelta,i;
	
		/**
		 * controllo che abbia vinto la partita X
		 * chiedo di rigiocare o di uscire
		 */
		if (esitoPartita == 1) {
			JOptionPane.showMessageDialog(null, "" + giocatore1 + " ha vinto la partita!!!!", "TRIS", JOptionPane.INFORMATION_MESSAGE);
			scelta = JOptionPane.showConfirmDialog(null, "Vuoi rigiocare", "TRIS", JOptionPane.YES_NO_OPTION);

			if (scelta == 0) {
				for (i = 0; i < 9; i++) {
					bottoni[i].setText("");
					bottoni[i].setBackground(new Color(2, 220, 140));
				}
			} else {
				System.exit(0);
			}
		}

		/**
		 * controllo che abbia vinto la partita O
		 * chiedo di rigiocare o di uscire
		 */
		if (esitoPartita == 2) {
			JOptionPane.showMessageDialog(null, "" + giocatore2 + " ha vinto la partita!!!!", "TRIS", JOptionPane.INFORMATION_MESSAGE);
			scelta = JOptionPane.showConfirmDialog(null, "Vuoi rigiocare", "TRIS", JOptionPane.YES_NO_OPTION);

			if (scelta == 0) {
				for (i = 0; i < 9; i++) {
					bottoni[i].setText("");
					bottoni[i].setBackground(new Color(2, 220, 140));
				}
			} else {
				System.exit(0);
			}
		}

		/**
		 * controllo che la partita sia finita in pareggio
		 * chiedo di rigiocare o di uscire
		 */
		if (esitoPartita == 4) {
			JOptionPane.showMessageDialog(null, "Partita finita in parità", "TRIS", JOptionPane.INFORMATION_MESSAGE);
			scelta = JOptionPane.showConfirmDialog(null, "Vuoi rigiocare", "TRIS", JOptionPane.YES_NO_OPTION);

			if (scelta == 0) {
				for (i = 0; i < 9; i++)
					bottoni[i].setText("");
			} else {
				System.exit(0);
			}
		}
	}
	
	/**
	 * controllo se la partita è finita
	 * @param bottoni i bottoni del tris
	 * @return indicePartita l'esito della partita
	 */
	public int controlloTris(JButton[] bottoni) {
		int indicePartita = 0;
		/**
		 * controllo che sia avvenuta la combinazioni di tre X consecutive
		 */
		if (bottoni[0].getText().equals("X") && bottoni[1].getText().equals("X") 
				&& bottoni[2].getText().equals("X")) {
			bottoni[0].setBackground(Color.GREEN);
			bottoni[1].setBackground(Color.GREEN);
			bottoni[2].setBackground(Color.GREEN);
			indicePartita = 1;
		}
		else if (bottoni[0].getText().equals("X") && bottoni[3].getText().equals("X")
				&& bottoni[6].getText().equals("X")) {
			bottoni[0].setBackground(Color.GREEN);
			bottoni[3].setBackground(Color.GREEN);
			bottoni[6].setBackground(Color.GREEN);
			indicePartita = 1;
		}
		else if (bottoni[0].getText().equals("X") && bottoni[4].getText().equals("X")
				&& bottoni[8].getText().equals("X")) {
			bottoni[0].setBackground(Color.GREEN);
			bottoni[4].setBackground(Color.GREEN);
			bottoni[8].setBackground(Color.GREEN);
			indicePartita = 1;
		}
		else if (bottoni[1].getText().equals("X") && bottoni[4].getText().equals("X")
				&& bottoni[7].getText().equals("X")) {
			bottoni[1].setBackground(Color.GREEN);
			bottoni[4].setBackground(Color.GREEN);
			bottoni[7].setBackground(Color.GREEN);
			indicePartita = 1;
		}	
		else if (bottoni[2].getText().equals("X") && bottoni[5].getText().equals("X")
				&& bottoni[8].getText().equals("X")) {
			bottoni[2].setBackground(Color.GREEN);
			bottoni[5].setBackground(Color.GREEN);
			bottoni[8].setBackground(Color.GREEN);
			indicePartita = 1;
		}	
		else if (bottoni[2].getText().equals("X") && bottoni[4].getText().equals("X")
				&& bottoni[6].getText().equals("X")) {
			bottoni[2].setBackground(Color.GREEN);
			bottoni[4].setBackground(Color.GREEN);
			bottoni[6].setBackground(Color.GREEN);
			indicePartita = 1;
		}
		else if (bottoni[3].getText().equals("X") && bottoni[4].getText().equals("X")
				&& bottoni[5].getText().equals("X")) {
			bottoni[3].setBackground(Color.GREEN);
			bottoni[4].setBackground(Color.GREEN);
			bottoni[5].setBackground(Color.GREEN);
			indicePartita = 1;
		}	
		else if (bottoni[6].getText().equals("X") && bottoni[7].getText().equals("X")
				&& bottoni[8].getText().equals("X")) {
			bottoni[6].setBackground(Color.GREEN);
			bottoni[7].setBackground(Color.GREEN);
			bottoni[8].setBackground(Color.GREEN);
			indicePartita = 1;
		}
		/**
		 * controllo che sia avvenuta la combinazioni di tre O consecutive
		 */
		else if (bottoni[0].getText().equals("O") && bottoni[1].getText().equals("O")
				&& bottoni[2].getText().equals("O")) {
			bottoni[0].setBackground(Color.RED);
			bottoni[1].setBackground(Color.RED);
			bottoni[2].setBackground(Color.RED);
			indicePartita = 2;
		}
		else if (bottoni[0].getText().equals("O") && bottoni[3].getText().equals("O")
				&& bottoni[6].getText().equals("O")) {
			bottoni[0].setBackground(Color.RED);
			bottoni[3].setBackground(Color.RED);
			bottoni[6].setBackground(Color.RED);
			indicePartita = 2;
		}
		else if (bottoni[0].getText().equals("O") && bottoni[4].getText().equals("O")
				&& bottoni[8].getText().equals("O")) {
			bottoni[0].setBackground(Color.RED);
			bottoni[4].setBackground(Color.RED);
			bottoni[8].setBackground(Color.RED);
			indicePartita = 2;
		}
		else if (bottoni[1].getText().equals("O") && bottoni[4].getText().equals("O")
				&& bottoni[7].getText().equals("O")) {
			bottoni[1].setBackground(Color.RED);
			bottoni[4].setBackground(Color.RED);
			bottoni[7].setBackground(Color.RED);
			indicePartita = 2;
		}		
		else if (bottoni[2].getText().equals("O") && bottoni[5].getText().equals("O")
				&& bottoni[8].getText().equals("O")) {
			bottoni[2].setBackground(Color.RED);
			bottoni[5].setBackground(Color.RED);
			bottoni[8].setBackground(Color.RED);
			indicePartita = 2;
		}	
		else if (bottoni[2].getText().equals("O") && bottoni[4].getText().equals("O")
				&& bottoni[6].getText().equals("O")) {
			bottoni[2].setBackground(Color.RED);
			bottoni[4].setBackground(Color.RED);
			bottoni[6].setBackground(Color.RED);
			indicePartita = 2;
		}		
		else if (bottoni[3].getText().equals("O") && bottoni[4].getText().equals("O")
				&& bottoni[5].getText().equals("O")) {
			bottoni[3].setBackground(Color.RED);
			bottoni[4].setBackground(Color.RED);
			bottoni[5].setBackground(Color.RED);
			indicePartita = 2;
		}	
		else if (bottoni[6].getText().equals("O") && bottoni[7].getText().equals("O")
				&& bottoni[8].getText().equals("O")) {
			bottoni[6].setBackground(Color.RED);
			bottoni[7].setBackground(Color.RED);
			bottoni[8].setBackground(Color.RED);
			indicePartita = 2;
		}
		/** 
		 * controllo il caso in cui la partita finisca in pareggio 
		 */
		else 
			indicePartita = 3;
		
		return indicePartita;
	}
}
