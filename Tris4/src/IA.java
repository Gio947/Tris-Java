import javax.swing.JButton;

public class IA {
	
	public IA() {
		
	}
	/**
	 * controllo se i due bottoni passati come parametro hanno lo stesso segno
	 * @param b1 il bottone
	 * @param b2 il bottone
	 * @return true or false
	 */
	public boolean confrontaBottone(JButton b1, JButton b2) {
		if(b1.getText().equals(b2.getText()) && !(b1.getText().equals("")))
			return true;
		return false;
	}
	/**
	 * controllo che il giocatore avversario non faccia tris
	 * e che la cpu svolga la sua mossa
	 * @param bottoni
	 */
	public void mossaCPU(JButton bottoni[]) {
		if(confrontaBottone(bottoni[0], bottoni[8]) && bottoni[5].getText().equals(""))
			bottoni[5].setText("O");
		else if(confrontaBottone(bottoni[2], bottoni[6]) && bottoni[3].getText().equals(""))
			bottoni[3].setText("O");
	    else if(confrontaBottone(bottoni[0], bottoni[2]) && bottoni[1].getText().equals(""))
			bottoni[1].setText("O");
		else if(confrontaBottone(bottoni[0], bottoni[6]) && bottoni[3].getText().equals(""))
			bottoni[3].setText("O");
		else if(confrontaBottone(bottoni[3], bottoni[6]) && bottoni[5].getText().equals(""))
			bottoni[5].setText("O");
		else if(confrontaBottone(bottoni[6], bottoni[8]) && bottoni[7].getText().equals(""))
			bottoni[7].setText("O");
		else if(confrontaBottone(bottoni[1], bottoni[7]) && bottoni[4].getText().equals(""))
			bottoni[4].setText("O");
		else if(confrontaBottone(bottoni[2], bottoni[8]) && bottoni[5].getText().equals(""))
			bottoni[5].setText("O");
		else if(confrontaBottone(bottoni[0], bottoni[8]) && bottoni[4].getText().equals(""))
			bottoni[4].setText("O");
		else if(confrontaBottone(bottoni[2], bottoni[6]) && bottoni[4].getText().equals(""))
			bottoni[4].setText("O");
		else if(confrontaBottone(bottoni[2], bottoni[5]) && bottoni[8].getText().equals(""))
			bottoni[8].setText("O");
		else if(confrontaBottone(bottoni[0], bottoni[1]) && bottoni[2].getText().equals(""))
			bottoni[2].setText("O");
		else if(confrontaBottone(bottoni[0], bottoni[3]) && bottoni[6].getText().equals(""))
			bottoni[6].setText("O");
		else if(confrontaBottone(bottoni[3], bottoni[4]) && bottoni[5].getText().equals(""))
			bottoni[5].setText("O");
		else if(confrontaBottone(bottoni[1], bottoni[4]) && bottoni[7].getText().equals(""))
			bottoni[7].setText("O");
		else if(confrontaBottone(bottoni[6], bottoni[4]) && bottoni[2].getText().equals(""))
			bottoni[2].setText("O");
		else if(confrontaBottone(bottoni[8], bottoni[4]) && bottoni[0].getText().equals(""))
			bottoni[0].setText("O");
		else if(confrontaBottone(bottoni[5], bottoni[4]) && bottoni[3].getText().equals(""))
			bottoni[3].setText("O");
		else if(confrontaBottone(bottoni[2], bottoni[1]) && bottoni[0].getText().equals(""))
			bottoni[0].setText("O");
		else if(confrontaBottone(bottoni[0], bottoni[4]) && bottoni[8].getText().equals(""))
			bottoni[8].setText("O");
		else if(confrontaBottone(bottoni[6], bottoni[7]) && bottoni[8].getText().equals(""))
			bottoni[8].setText("O");
		else if(confrontaBottone(bottoni[6], bottoni[3]) && bottoni[0].getText().equals(""))
			bottoni[0].setText("O");
		else if(confrontaBottone(bottoni[8], bottoni[5]) && bottoni[2].getText().equals(""))
			bottoni[2].setText("O");
		else if(confrontaBottone(bottoni[6], bottoni[8]) && bottoni[7].getText().equals(""))
			bottoni[7].setText("O");
		else if(bottoni[0].getText().equals(""))
			bottoni[0].setText("O");
		else if(bottoni[6].getText().equals(""))
			bottoni[6].setText("O");
		else if(bottoni[8].getText().equals(""))
			bottoni[8].setText("O");
		else if(bottoni[2].getText().equals(""))
			bottoni[2].setText("O");
	}
	
	/**
	 * faccio eseguire al computer le sue mosse
	 * @param bottoni i bottoni del tris
	 * @param turnoCPU il turno della partita
	 * @return turnoCPU il turno della partita
	 */
	public int playCPU(JButton bottoni[] , int turnoCPU) {
			
		int i,turno = 0;
		/** prima giocata del computer */
		if(turnoCPU == 1) {
			if(bottoni[4].getText().equals(""))
				bottoni[4].setText("O");
			else if(bottoni[6].getText().equals(""))
				bottoni[6].setText("O");
			turnoCPU++;
		}
		if(turnoCPU == 3) {
			this.mossaCPU(bottoni);
			turnoCPU++;
		}
		if(turnoCPU == 5) {
		    this.mossaCPU(bottoni);
        	turnoCPU++;
		}
		if(turnoCPU == 7) {
			this.mossaCPU(bottoni);
			for(i = 0; i<bottoni.length; i++) {
				if(turno > 0) {
					if(bottoni[i].getText().equals("")) {
						bottoni[i].setText("O");
						turno++;
					}
				}
			}
			turno = 0;
			turnoCPU++;
		}
		return turnoCPU;
	}
}
