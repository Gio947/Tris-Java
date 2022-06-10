
/**
 * 
 * Date  21/07/2018
 * Author Giovanni Schianchi
 * Name Tris.java
 * Version 4.0
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Grafica extends JFrame implements ActionListener {

	/** array di bottoni di tipo JButton */
	private JButton bottoni[];
	/** JLabel in cui verranno scritti nomi e punteggi */
	private JLabel nome1, nome2;
	/** variabile per alternare X a O */
	private int valoreSegno = 1;
	/** conteggio dei turni giocati 1 vs 1*/
	public int turno = 0;
	/** conteggio dei turni giocati in 1 vs CPU */
	public int turnoCPU = 0;
	/** variabile per il conteggio delle partite vinte da X */
	private int punteggio1 = 0;
	/** variabile per il conteggio delle partite vinte da O */
	private int punteggio2 = 0;
	/** nome del giocatore */
	private String giocatore1 = "";
	/** nome del giocatore 2 */
	private String giocatore2 = "";
	/** variabile il cui valore dipende da come finisce la partita */
	private int esitoPartita = 0; 
	/** variabile per uso della voce Pause del menu */
	private int valPause = 0;
	/** modalita in cui avviene il gioco */
	private int modalitaGioco = 0;
	
	/**
	 * metodo costruttore in cui chiamo il metodo finestra
	 */
	public Grafica() {
		super();
		finestra();
	}

	/**
	 * metodo in cui istanzio i componenti del gioco
	 */
	public void finestra() {
		
		Gioco gioco = new Gioco();
		
		/** menu di tipo JMenuBar */
		JMenuBar menubar = new JMenuBar();
		this.setJMenuBar(menubar);
		menubar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		/** voce File del menu */
		JMenu file = new JMenu("File");
		menubar.add(file);
		JMenuItem exit = new JMenuItem("Exit");
		file.add(exit);
		JMenuItem ricomincia = new JMenuItem("Restart");
		file.add(ricomincia);
		JMenuItem pausa = new JMenuItem("Pause");
		file.add(pausa);
		
		/** voce Options del menu */
		JMenu opzioni = new JMenu("Options");
		menubar.add(opzioni);
		JMenuItem player1 = new JMenuItem("Players 1 name");
		opzioni.add(player1);
		JMenuItem player2 = new JMenuItem("Players 2 name");
		opzioni.add(player2);
		JMenuItem mode1 = new JMenuItem("1 vs CPU");
		opzioni.add(mode1);
		JMenuItem mode2 = new JMenuItem("1 vs 1");
		opzioni.add(mode2);

		/** voce Help del menu */
		JMenu help = new JMenu("Help");
		menubar.add(help);
		JMenuItem informazioni = new JMenuItem("Informations");
		help.add(informazioni);
		JMenuItem regole = new JMenuItem("Rules");
		help.add(regole);
		
		class uscita implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}
		exit.addActionListener(new uscita());
		
		class modalitaPausa implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(valPause == 0) {
					for (int i = 0; i < 9; i++) {
						bottoni[i].setEnabled(false);
					}
					valPause = 1;
				}
				else {
					for (int i = 0; i < 9; i++) {
						bottoni[i].setEnabled(true);
					}
					valPause = 0;
				}
			}
		}
		pausa.addActionListener(new modalitaPausa());
		
		class restarting implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 9; i++) {
					bottoni[i].setText("");
					bottoni[i].setBackground(new Color(2, 220, 140));
				}
				punteggio1 = 0;
				punteggio2 = 0;
				
				nome1.setText(giocatore1 + ": " + punteggio1);
				nome2.setText(giocatore2 + ": " + punteggio2);
			}
		}
		ricomincia.addActionListener(new restarting());
		
		class voceInformazioni implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Chiamato anche Tris, Tria, Tela o Tavola Mulino, è un gioco antichissimo. "
						+ "\n" + "Ancor prima dei Romani, che lo chiamavano Triodo, veniva giocato in Asia Minore centinaia d'anni prima di Cristo." 
						+ "\n" + "Tavolieri simili a quelli  del moderno Filetto e anche più complessi, sono stati trovati, insieme ad altri giochi, in templi Egizi."
						+ "\n\n" + "Il filetto è un gioco da tavolo astratto tradizionale diffuso in gran parte del mondo. In molte lingue, come in italiano, il nome significa “mulino“,"
						+ "\n" + "in Italia viene chiamato anche mulinello, triplice cinta, tria, tris, tela e filetto; questi ultimi tre nomi vengono usati anche per indicare il gioco"
						+ "\n" + "del tris propriamente detto, che si può considerare una semplificazione del mulino."
						+ "\n\n" + "Dicesi \"partita perfetta\" o \"combinazione perfetta\" o ancora \"combinazione vincente\", la partita nella quale uno dei giocatori posiziona i suoi simboli in modo che,"
						+ "\n" + "nel momento finale, detto anche \"momento ultimo\", l'avversario sia minacciato da due file, cioè, nel momento in cui, qualunque mossa faccia, l'avversario compirà "
						+ "\n" + "sempre e comunque la mossa vincente."
						+ "\n" + "La combinazione vincente può essere considerata come sinonimo dello scacco matto, poiché entrambi bloccano l'avversario terminando con la propria vittoria."
						,"TRIS", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		informazioni.addActionListener(new voceInformazioni());
		
		class voceRegole implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Il gioco del tris consiste nel realizzare una linea composta da tre "
						+ "segni uguali e consecutivi (tris). " + "\n" + "Il tris puo essere disposto solo in verticale, orizzontale o obliquo."
						+"\n" + "Nella tendina file si trovano alcune funzionalita riguardanti il gioco : "
						+"\n" + "- con 'exit' si esce definitivamente dal gioco "
						+"\n" + "- con 'restart' ricominci la partita e si azzera il punteggio "
						+"\n" + "- con 'save' viene salvato il risultato della partita su un file "
						+"\n" + "- con 'pause' il gioco si interrompe e per sbloccarlo bisogna schiacciare un volta ancora su 'pause' ", 
						"TRIS", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		regole.addActionListener(new voceRegole());
		
		class changeName1 implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				giocatore1 = JOptionPane.showInputDialog(null, "Nome giocatore 1:" , "TRIS", JOptionPane.INFORMATION_MESSAGE);
				nome1.setText(giocatore1 + ": " + punteggio1);
			}
		}
		player1.addActionListener(new changeName1());
		
		class changeName2 implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				giocatore2 = JOptionPane.showInputDialog(null, "Nome giocatore 2:" , "TRIS", JOptionPane.INFORMATION_MESSAGE);
				nome2.setText(giocatore2 + ": " + punteggio2);
			}
		}
		player2.addActionListener(new changeName2());
		
		class changeMode1 implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				giocatore2 = "CPU";
				modalitaGioco = 1;
				punteggio1 = 0;
				punteggio2 = 0;
				nome1.setText(giocatore1 + ": " + punteggio1);
				nome2.setText(giocatore2 + ": " + punteggio2);
			}
		}
		mode1.addActionListener(new changeMode1());
		
		class changeMode2 implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				giocatore2 = JOptionPane.showInputDialog(null, "Nome giocatore 2:" , "TRIS", JOptionPane.INFORMATION_MESSAGE);
				modalitaGioco = 0;
				nome2.setText(giocatore2 + ": " + punteggio2);
			}
		}
		mode2.addActionListener(new changeMode2());
		
		JPanel p = new JPanel();

		this.add(p);
		this.setTitle("TRIS");
		p.setLayout(new GridLayout(3, 3));
	
		/**
		 * istanzio i bottoni e li aggiungo al JPanel
		 */
		bottoni = new JButton[9];
		for (int i = 0; i < 9; i++) {
			bottoni[i] = new JButton();
			bottoni[i].setBackground(new Color(2, 220, 140));
			bottoni[i].setFont(new Font("Courier New", Font.BOLD, 45));
			bottoni[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			bottoni[i].addActionListener(this);
			p.add(bottoni[i]);
		}

		nome1 = new JLabel("");
		nome2 = new JLabel("");

		this.add(nome1, "North");
		this.add(nome2, "South");
		
		giocatore1 = gioco.nominativo1();
		giocatore2 = gioco.nominativo2();
		
		nome1.setText(giocatore1 + ": " + punteggio1);
		nome2.setText(giocatore2 + ": " + punteggio2);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(450, 460);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		/** alterno la x con la y */
		valoreSegno = 1 - valoreSegno;
		
		if(valoreSegno == 1) {
			nome1.setForeground(Color.GREEN);
			nome2.setForeground(Color.BLACK);
		}
		else {
			nome2.setForeground(Color.GREEN);
			nome1.setForeground(Color.BLACK);
		}
			
		if(modalitaGioco == 0) {
		    /** stampo sul bottone il segno 'X' o il segno 'O' */ 
			for (int i = 0; i < bottoni.length; i++) {
				if ((JButton) e.getSource() == bottoni[i]) {
					if (bottoni[i].getText().equals("")) {
						if (valoreSegno == 0) {
							bottoni[i].setText("X");
							turno++;
						}
						else {
							bottoni[i].setText("O");
							turno++;
						}
					}
				}
			}
		}
		else {
			
			for (int j = 0; j < bottoni.length; j++) {
				if ((JButton) e.getSource() == bottoni[j]) {
					if (bottoni[j].getText().equals("")) {
							bottoni[j].setText("X");
							turnoCPU++;
					}
				}
			}
			IA ia = new IA();
			/** avvengono le mosse del computer */
			turnoCPU = ia.playCPU(bottoni, turnoCPU);
		}
		
		Gioco gioco = new Gioco();
		/** controllo se è stato realizzato un tris */
		esitoPartita = gioco.controlloTris(bottoni);
		
		if(esitoPartita == 1) {
			punteggio1++;
			turnoCPU = 0;
			turno = 0;
		}
		else if(esitoPartita == 2) {
			punteggio2++;
			turnoCPU = 0;
			turno = 0;
		}
		else if(esitoPartita == 3){
			if (turno == 9 || turnoCPU == 9) {
				turnoCPU = 0;
				turno = 0;
				esitoPartita = 4;
			}
		}
		gioco.finePartita(esitoPartita,bottoni,giocatore1,giocatore2);
		nome1.setText(giocatore1 + ": " + punteggio1);
		nome2.setText(giocatore2 + ": " + punteggio2);
		
		esitoPartita = 0;
	}
}
