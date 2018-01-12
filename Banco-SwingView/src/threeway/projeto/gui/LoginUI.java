package threeway.projeto.gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import threeway.projeto.service.dao.LoginDao;

public class LoginUI {

	public static void main(String[] args) {
		
		//Criando frame
		final JFrame frame = new JFrame("Livraria - 3Way");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 130);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		
		//icon
		Image icon = Toolkit.getDefaultToolkit().getImage("javalib\\login.gif");
		frame.setIconImage(icon);
		
		frame.validate();
		
		//Criando a label cpf
		JLabel rotuloCpf= new JLabel();
		rotuloCpf.setText("Login:  ");
		panel.add(rotuloCpf);

		final JTextField txtLogin = new JTextField(20);
		panel.add(txtLogin);
		
		//Criando a label senha
		JLabel rotuloSenha = new JLabel();
		rotuloSenha.setText("Senha: ");
		panel.add(rotuloSenha);

		final JTextField txtSenha = new JPasswordField(20);
		panel.add(txtSenha);
		
		JButton btnEntrar = new JButton(" Entrar ");
		panel.add(btnEntrar);
		
		
		btnEntrar.addActionListener(new ActionListener() {

		//Tratamento do bot�o Entrar
		public void actionPerformed(ActionEvent e) {

		LoginDao loginDao = new LoginDao();
		String login;
		String senha;

		try{
			if(txtLogin.getText().isEmpty() || txtSenha.getText().isEmpty()){
				JOptionPane.showMessageDialog(null,"Voc� n�o preencheu todos os campos!");				
			}
			else
			{
				login=txtLogin.getText();
				senha=txtSenha.getText();

				if(loginDao.validarCliente(login, senha)){
					
					frame.dispose();
					PrincipalUI menu = new PrincipalUI();
					menu.menuPrincipal();
					
				}else {
					JOptionPane.showMessageDialog(null, "Login ou senha inv�lidos!");
				}
			}
		}catch (Exception exp2){
			JOptionPane.showMessageDialog(null, "Dados Inv�lidos. N�o foi poss�vel efetuar login!");
				}	
			}
		});
		
		
		
		/*btnEntrar.addActionListener(new ActionListener() {

			//Tratamento do bot�o Entrar
			public void actionPerformed(ActionEvent e) {
	
			LoginDao loginDao = new JDBCLoginDao();
			String cpf;
			String senha;
	
			try{
				if(txtCpf.getText().isEmpty() || txtSenha.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Voc� n�o preencheu todos os campos!");				
				}
				else
				{
					cpf=txtCpf.getText();
					senha=txtSenha.getText();
	
					if(loginDao.validarCliente(cpf, senha)){
						
						frame.dispose();
						PrincipalUI menu = new PrincipalUI();
						menu.menuPrincipal(loginDao.montarCliente(cpf));
						
					}else {
						JOptionPane.showMessageDialog(null, "Login ou senha inv�lidos!");
					}
				}
			}catch (Exception exp2){
				JOptionPane.showMessageDialog(null, "Dados Inv�lidos. N�o foi poss�vel efetuar login!");
					}	
				}
			});
			panel.add(btnEntrar);
			
			JButton btnCadastrar = new JButton(" Efetuar Cadastro ");
			btnCadastrar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					new CadastrarClienteUI();
				}
				//Tratamento do bot�o Entrar
			});
			panel.add(btnCadastrar);
			
			JButton btnSair = new JButton( "Sair ");
			btnSair.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
				
			});
			panel.add(btnSair);
			
			frame.setContentPane(panel);
			panel.setVisible(true);
			frame.setVisible(true);
			frame.setResizable(false);
		}
}*/
		
		frame.setContentPane(panel);
		panel.setVisible(true);
		frame.setVisible(true);
		frame.setResizable(false);
	} }