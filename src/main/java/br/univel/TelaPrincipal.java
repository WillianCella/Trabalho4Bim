package br.univel;

/**
 * @author Willian Cella - 29/10/2015 - 19:31:30
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

import br.univel.tela.cliente.TelaCadastroCliente;
import br.univel.tela.cliente.TelaListarCliente;
import br.univel.tela.produto.TelaCadastroProduto;
import br.univel.tela.usuario.TelaCadastroUsuario;
import br.univel.telalogin.BlockPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class TelaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private BlockPanel glass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {

		// blockParaLogin();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 385);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					abrirTelaCliente();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		});
		mnCadastros.add(mntmCliente);

		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					abrirTelaProduto();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		JMenuItem mntmUsurio = new JMenuItem("Usu\u00E1rio");
		mntmUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					abrirTelaUsuario();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		mnCadastros.add(mntmUsurio);
		mnCadastros.add(mntmProduto);

		JMenu mnListar = new JMenu("Listar");
		menuBar.add(mnListar);

		JMenuItem mntmCliente_1 = new JMenuItem("Cliente");
		mntmCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					abrirListarCliente();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnListar.add(mntmCliente_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

	protected void abrirTelaUsuario() throws SQLException {
		TelaCadastroUsuario telaCadastroUsuario = new TelaCadastroUsuario();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroUsuario);
			}
		};
		telaCadastroUsuario.setCloseAction(action);

		tabbedPane.addTab("Usuário ", telaCadastroUsuario);

		ultimaAba();
	}

	private void abrirListarCliente() throws SQLException {
		TelaListarCliente listarcliente = new TelaListarCliente();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(listarcliente);
			}
		};
		listarcliente.setCloseAction(action);

		tabbedPane.addTab("Listar Cliente ", listarcliente);
		ultimaAba();
	}

	// private void blockParaLogin() {
	// Runnable acaoOk = () -> {
	// glass.setVisible(false);
	// glass = new BlockPanel();
	// };
	//
	// PainelLogin painelLogin = new PainelLogin(acaoOk);
	//
	// glass = new BlockPanel(painelLogin);
	//
	// setGlassPane(glass);
	//
	// glass.setVisible(true);
	// }

	protected void abrirTelaProduto() throws SQLException {
		TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroProduto);
			}
		};
		telaCadastroProduto.setCloseAction(action);

		tabbedPane.addTab("Produto ", telaCadastroProduto);
		ultimaAba();
	}

	private void abrirTelaCliente() throws SQLException {
		TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroCliente);
			}
		};
		telaCadastroCliente.setCloseAction(action);

		tabbedPane.addTab("Cliente ", telaCadastroCliente);
		ultimaAba();

	}

	private void ultimaAba() {
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
	}

}
