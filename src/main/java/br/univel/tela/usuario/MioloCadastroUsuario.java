package br.univel.tela.usuario;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import br.univel.cliente.Cliente;
import br.univel.cliente.ClienteDAOImpl;
import br.univel.usuario.Usuario;
import br.univel.usuario.UsuarioDAOImpl;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Willian Cella - 29/10/2015 - 20:00:41
 *
 */

public class MioloCadastroUsuario extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txfID;
	private JTextField txfNome;
	private JPasswordField passSenha;
	private JPasswordField passConfirmarSenha;
	protected Usuario usuarioContexto;
	protected Cliente clienteContexto;

	/**
	 * Create the panel.
	 */
	public MioloCadastroUsuario() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 34, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);

		txfID = new JTextField();
		GridBagConstraints gbc_txfID = new GridBagConstraints();
		gbc_txfID.insets = new Insets(0, 0, 5, 5);
		gbc_txfID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfID.gridx = 1;
		gbc_txfID.gridy = 0;
		add(txfID, gbc_txfID);
		txfID.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txfID.setEnabled(false);
				txfNome.setEnabled(false);
				UsuarioDAOImpl udao = new UsuarioDAOImpl();
				ClienteDAOImpl cdao = new ClienteDAOImpl();

				int id = 0;
				if ((txfID.getText() == null) || (txfID.getText() == "")
						|| (txfID.getText().equals(0))) {
					JOptionPane.showMessageDialog(null,
							"ID inválido, Informe outro ID");
					return;
				}
				id = Integer.parseInt(txfID.getText());
				clienteContexto = cdao.buscar(id);
				usuarioContexto = udao.buscar(id);
				txfNome.setText(clienteContexto.getNome());
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 2;
		gbc_btnBuscar.gridy = 0;
		add(btnBuscar, gbc_btnBuscar);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		add(lblNome, gbc_lblNome);

		txfNome = new JTextField();
		GridBagConstraints gbc_txfNome = new GridBagConstraints();
		gbc_txfNome.insets = new Insets(0, 0, 5, 0);
		gbc_txfNome.gridwidth = 8;
		gbc_txfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfNome.gridx = 1;
		gbc_txfNome.gridy = 1;
		add(txfNome, gbc_txfNome);
		txfNome.setColumns(10);

		JLabel lblCriarSenha = new JLabel("Criar Senha");
		lblCriarSenha.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCriarSenha = new GridBagConstraints();
		gbc_lblCriarSenha.insets = new Insets(0, 0, 5, 0);
		gbc_lblCriarSenha.gridwidth = 9;
		gbc_lblCriarSenha.gridx = 0;
		gbc_lblCriarSenha.gridy = 3;
		add(lblCriarSenha, gbc_lblCriarSenha);

		JLabel lblSenha = new JLabel("Senha");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 4;
		add(lblSenha, gbc_lblSenha);

		passSenha = new JPasswordField();
		GridBagConstraints gbc_passSenha = new GridBagConstraints();
		gbc_passSenha.gridwidth = 2;
		gbc_passSenha.insets = new Insets(0, 0, 5, 5);
		gbc_passSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_passSenha.gridx = 1;
		gbc_passSenha.gridy = 4;
		add(passSenha, gbc_passSenha);

		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha");
		GridBagConstraints gbc_lblConfirmarSenha = new GridBagConstraints();
		gbc_lblConfirmarSenha.anchor = GridBagConstraints.EAST;
		gbc_lblConfirmarSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmarSenha.gridx = 0;
		gbc_lblConfirmarSenha.gridy = 5;
		add(lblConfirmarSenha, gbc_lblConfirmarSenha);

		passConfirmarSenha = new JPasswordField();
		GridBagConstraints gbc_passConfirmarSenha = new GridBagConstraints();
		gbc_passConfirmarSenha.gridwidth = 2;
		gbc_passConfirmarSenha.insets = new Insets(0, 0, 5, 5);
		gbc_passConfirmarSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_passConfirmarSenha.gridx = 1;
		gbc_passConfirmarSenha.gridy = 5;
		add(passConfirmarSenha, gbc_passConfirmarSenha);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDAOImpl udao = new UsuarioDAOImpl();
				udao.inserir(usuarioContexto);
				return;
			}

		});
		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
		gbc_btnConfirmar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnConfirmar.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfirmar.gridx = 1;
		gbc_btnConfirmar.gridy = 7;
		add(btnConfirmar, gbc_btnConfirmar);

	}

}
