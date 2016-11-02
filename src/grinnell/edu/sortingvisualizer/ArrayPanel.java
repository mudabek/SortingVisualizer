package grinnell.edu.sortingvisualizer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ArrayPanel extends JPanel {

	private NoteIndices notes;
	private int  width;
	private int height;

	/**
	 * Constructs a new ArrayPanel that renders the given note indices to
	 * the screen.
	 * @param notes the indices to render
	 * @param width the width of the panel
	 * @param height the height of the panel
	 */
	public ArrayPanel(NoteIndices notes, int width, int height) {
		this.notes = notes;
		this.setPreferredSize(new Dimension(width, height));
		this.width = width;
		this.height = height;
	}

	@Override
	public void paintComponent(Graphics g) {
		Integer[] noteIndices = notes.getNotes();
		int barWidth = width/notes.arr.length;
		int barHeight = height/notes.arr.length;
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		for(int i = 0; i < notes.arr.length;i++){
			if(notes.isHighlighted(i)){
				g.setColor(Color.red);
			}else{
				if(1 == i%2){
					g.setColor(Color.blue);
				} else {
					g.setColor(Color.yellow);
				}
				
			} 
			g.fillRect(barWidth*i, 300-barHeight*noteIndices[i], barWidth, barHeight*(1 + noteIndices[i]));
		}
	}
}