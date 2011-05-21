package pl.edu.pw.elka.www.proz.tetris.view;

import java.awt.Dialog;

import javax.swing.JDialog;

import pl.edu.pw.elka.www.proz.tetris.fake.FakeScore;

class SaveScoreDialog{
	
	private FakeScore score;
	private JDialog scoreDialog;

	public SaveScoreDialog(FakeScore score){
		this.score = score;
		scoreDialog = new JDialog();
	}
	
	
}
