import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

public class textEditor extends JFrame implements ActionListener {
	JTabbedPane tab;
	JComboBox fontName, fontColour;
	JSlider fontSize;
	JTextArea txtArea;
	JFrame frame;
	JLabel lbl1, lbl2, lbl3;
	JPanel pnl1, pnl2;
	HashMap<String, Color> map;

//JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);	
	public textEditor() {
		super("Text Editor");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 300);

		frame = new JFrame("Tabbed text editor");
		tab = new JTabbedPane();
		fontName = new JComboBox<>();
		fontColour = new JComboBox<>();
		fontSize = new JSlider(JSlider.HORIZONTAL, 5, 25, 10);
		txtArea = new JTextArea(10, 30);
		pnl1 = new JPanel(new GridLayout(2, 3));
		pnl2 = new JPanel();
		lbl1 = new JLabel("Select a font name:");
		lbl2 = new JLabel("Select a font colour:");
		lbl3 = new JLabel("Select a font size:");

		// setting tab
		// Add components to pnl1 (Settings tab)
		pnl1.add(lbl1);
		pnl1.add(lbl2);
		pnl1.add(lbl3);
		pnl1.add(fontName);
		pnl1.add(fontColour);
		pnl1.add(fontSize);

		fontName.addItem("Algerian");
		fontName.addItem("Times New Roman");
		fontName.addItem("Calibri");
		fontName.addItem("Arial");
		fontName.addItem("Calibri Light");

		fontColour.addItem("Red");
		fontColour.addItem("Black");
		fontColour.addItem("Blue");
		fontColour.addItem("Pink");

		fontSize.setMajorTickSpacing(5);
		fontSize.setMinorTickSpacing(1);
		fontSize.setPaintTicks(true);
		fontSize.setPaintLabels(true);

		// edit text tab
		pnl2.add(txtArea);

		tab.addTab("settings", pnl1);
		tab.addTab("Edit Text", pnl2);

		map = new HashMap();
		map.put("Black", Color.BLACK);
		map.put("Blue", Color.BLUE);
		map.put("Red", Color.RED);
		map.put("Pink", Color.PINK);

		// Add listeners
		fontName.addActionListener(this);
		fontColour.addActionListener(this);
		fontSize.addChangeListener(e -> updateTextAreaFont());
		updateTextAreaFont();

		this.add(tab);

		this.setVisible(true);
	}

	// Update the font of the text area based on user selections
	private void updateTextAreaFont() {
		// Get selected font name, size, and color
		String selectedFontName = (String) fontName.getSelectedItem();
		int selectedFontSize = fontSize.getValue();
		String colorName = (String) fontColour.getSelectedItem();
		Color selectedColor = map.get(colorName);

		// Set the font and color of the text area
		txtArea.setFont(new Font(selectedFontName, Font.PLAIN, selectedFontSize));
		txtArea.setForeground(selectedColor);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Update the text area font when a combo box value changes
		updateTextAreaFont();
	}

	public static void main(String[] args) {
		new textEditor();
	}
}
