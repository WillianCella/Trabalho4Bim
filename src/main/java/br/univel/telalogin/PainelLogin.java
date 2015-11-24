package br.univel.telalogin;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JButton;

public class PainelLogin extends JPanel {
	private static final long serialVersionUID = 1L;

	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnEntrar;

	public PainelLogin() {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblUsuario = new JLabel("Usu\u00E1rio");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(20, 20, 5, 5);
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 0;
		add(lblUsuario, gbc_lblUsuario);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(20, 0, 5, 20);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Senha");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 20, 20, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 20, 20);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 1;
		add(passwordField, gbc_passwordField);

		btnEntrar = new JButton("Entrar");
		GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
		gbc_btnEntrar.insets = new Insets(0, 0, 20, 0);
		gbc_btnEntrar.gridx = 1;
		gbc_btnEntrar.gridy = 2;
		add(btnEntrar, gbc_btnEntrar);
	}

	public PainelLogin(Runnable acaoOk) {
		this();
		btnEntrar
				.addActionListener(e -> {
					if ((textField.getText().trim().equals("willian") && new String(
							passwordField.getPassword()).equals("123"))
							|| (textField.getText().trim().equals("root") && new String(
									passwordField.getPassword()).equals("root"))) {
						acaoOk.run();
					} else {
						JOptionPane.showMessageDialog(PainelLogin.this,
								"Usuário e/ou senha inválidos!");
					}
				});

	}

}
