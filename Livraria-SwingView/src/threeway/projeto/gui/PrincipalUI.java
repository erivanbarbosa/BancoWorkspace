package threeway.projeto.gui;



import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.BevelBorder;


public class PrincipalUI {

	public void menuPrincipal(){

		//Criando frame
		final JFrame frame = new JFrame("Livraria - 3way");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 400);
		frame.setLocationRelativeTo(null);
		
		// background image and icon
		
		ImageIcon imgbrackground = new ImageIcon("javalib/background.gif"); 
		JLabel background = new JLabel(imgbrackground);
		frame.add(background);
		
		Image icon = Toolkit.getDefaultToolkit().getImage("javalib\\icon.gif");
		frame.setIconImage(icon);
		
		frame.validate(); 
		
		// Criando barra de menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new BevelBorder(BevelBorder.RAISED));	
				
		//criando menu Compra
		JMenu menuCompra = new JMenu("Compra");
		
		// Pesquisa de Livro
		JMenuItem menuPesquisaLivros = new JMenuItem("Pesquisar Livros");
		menuPesquisaLivros.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {		
				new PesquisarLivroUI();		
			}	
		});
		menuCompra.add(menuPesquisaLivros);
		
		// Cadastrar Autor
		JMenuItem menuVerCarrinho = new JMenuItem("Visualizar Carrinho");
		/*menuVerCarrinho.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {		
				new CarrinhoUI(Carrinho.carro);		
			}	
		});*/
		menuCompra.add(menuVerCarrinho);
		
		//Adicionando Jmenu no JmenuBar
		menuBar.add(menuCompra);
		
		
		//Adicionando o JMenuBar no JFrame
		frame.setJMenuBar(menuBar);
		menuBar.setVisible(true);
		frame.setVisible(true);
		
	}
}