package br.univel.cadastro.telalogin;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

		blockParaLogin();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirTela();
			}

		});
		mnCadastros.add(mntmCliente);

		JMenuItem mntmBloquear = new JMenuItem("BLOQUEAR");
		mntmBloquear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				block();
			}
		});
		
		JMenuItem mntmUsurio = new JMenuItem("Usu\u00E1rio");
		mnCadastros.add(mntmUsurio);
		
		JMenuItem mntmProduto = new JMenuItem("Produto");
		mnCadastros.add(mntmProduto);
		mnCadastros.add(mntmBloquear);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

	protected void block() {
		setGlassPane(glass);
		glass.setVisible(true);

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				glass.setVisible(false);
			}
		}).start();
	}

	private void blockParaLogin() {
		Runnable acaoOk = () -> {
			glass.setVisible(false);
			glass = new BlockPanel();
		};

		PainelLogin painelLogin = new PainelLogin(acaoOk);

		glass = new BlockPanel(painelLogin);

		setGlassPane(glass);

		glass.setVisible(true);
	}

	private void abrirTela() {
		TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroCliente);
			}
		};
		telaCadastroCliente.setCloseAction(action);

		tabbedPane.addTab("Tela ", telaCadastroCliente);
	}

}
