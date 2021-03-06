package threeway.projeto.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import threeway.projeto.modelo.Livro;
import threeway.projeto.service.dao.LivroDao;

public class PesquisarLivroUI {

	public PesquisarLivroUI() {

		// Criando o Frame para pesquisa de livros
		final JFrame framePesquisaLivro = new JFrame("Pesquisa de Livros");
		framePesquisaLivro.setSize(550, 540);
		framePesquisaLivro.setVisible(true);
		framePesquisaLivro.setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		// crianado combobox para escolha da pesquisa com titulo ou autor
		JComboBox combo = new JComboBox();
		combo.addItem("Escolha uma Op��o");
		combo.addItem("Listar Todos");

		combo.setPreferredSize(new Dimension(195, 18));
		panel.add(combo);

		// CRIAR TABELA
		// ************************************************************************
		String[] colunas = new String[] { "T�tulo", "Autor", "Pre�o" };
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(colunas);

		JTable tabela = new JTable(modelo);
		JScrollPane barraRolagem = new JScrollPane(tabela);
		panel.add(barraRolagem);

		// Criando bot�o pesquisar
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// pesquisando livro por autor
				if (combo.getSelectedItem() == "Listar Todos") {
					LivroDao dao = new LivroDao();
					ArrayList<Livro> livros = new ArrayList<Livro>();
					livros = (ArrayList<Livro>) dao.listar();

					limpaTable(modelo);

					for (Livro livro : livros) {
						Object[] linha = new Object[] { livro.getTitulo(), livro.getAutor(), livro.getPreco() };
						modelo.addRow(linha);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Voc� deve selecionar uma op��o");
				}

			}
		});
		panel.add(btnPesquisar);

		// adicionando painel na janela
		framePesquisaLivro.setContentPane(panel);
	}

	private void limpaTable(DefaultTableModel modelo) {
		int limitRow = modelo.getRowCount();
		if (limitRow != 0) {
			for (int i = 0; i < limitRow; i++) {
				modelo.removeRow(0);
			}
		}
	}
}
