package br.univel.cadastro.telalogin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;

public abstract class MolduraAbstrata extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton btnFechar;

	protected abstract void configuraMiolo() throws SQLException;

	public void setCloseAction(ActionListener action) {
		btnFechar.addActionListener(action);
	}

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public MolduraAbstrata() throws SQLException {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblOla = new JLabel("Bem Vindo");
		GridBagConstraints gbc_lblOla = new GridBagConstraints();
		gbc_lblOla.insets = new Insets(0, 0, 0, 5);
		gbc_lblOla.gridx = 0;
		gbc_lblOla.gridy = 0;
		panel.add(lblOla, gbc_lblOla);

		btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnFechar = new GridBagConstraints();
		gbc_btnFechar.anchor = GridBagConstraints.EAST;
		gbc_btnFechar.gridx = 1;
		gbc_btnFechar.gridy = 0;
		panel.add(btnFechar, gbc_btnFechar);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		add(panel_1, BorderLayout.SOUTH);

		configuraMiolo();
	}

}
