import javax.swing.*;
import java.awt.*;

public class login {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setLocationRelativeTo(null);

        JPanel painelPrincipal = new JPanel(new GridLayout(1, 2));

        JPanel painelEsquerdo = new JPanel();
        painelEsquerdo.setBackground(new Color(58, 191, 170));
        painelEsquerdo.setLayout(new BoxLayout(painelEsquerdo, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("EASY");
        titulo.setFont(new Font("Arial", Font.BOLD, 32));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel textoEasy = new JLabel("Transforme seus sonhos em realidade financeira!");
        textoEasy.setFont(new Font("Arial", Font.PLAIN, 20));
        textoEasy.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel textoLogin = new JLabel("Login");
        textoLogin.setFont(new Font("Arial", Font.PLAIN, 20));
        textoLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelEsquerdo.add(Box.createVerticalGlue());
        painelEsquerdo.add(titulo);
        painelEsquerdo.add(Box.createRigidArea(new Dimension(0, 10)));
        painelEsquerdo.add(textoEasy);
        painelEsquerdo.add(Box.createRigidArea(new Dimension(0, 10)));
        painelEsquerdo.add(textoLogin);
        painelEsquerdo.add(Box.createRigidArea(new Dimension(0, 30)));
        painelEsquerdo.add(botaoVoltar);
        painelEsquerdo.add(Box.createVerticalGlue());


        JPanel painelDireito = new JPanel();
        painelDireito.setLayout(new BoxLayout(painelDireito, BoxLayout.Y_AXIS));
        painelDireito.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JLabel entrarConta = new JLabel("ENTRAR");
        entrarConta.setFont(new Font("Arial", Font.BOLD, 22));
        entrarConta.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField campoEmail = new JTextField();
        campoEmail.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        campoEmail.setBorder(BorderFactory.createTitledBorder("Email"));

        JPasswordField campoSenha = new JPasswordField();
        campoSenha.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        campoSenha.setBorder(BorderFactory.createTitledBorder("Senha"));

        JButton botaoEntrar = new JButton("ENTRAR");
        botaoEntrar.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelDireito.add(Box.createVerticalGlue());

        painelDireito.add(entrarConta);
        painelDireito.add(Box.createRigidArea(new Dimension(0, 20)));
        painelDireito.add(campoEmail);
        painelDireito.add(Box.createRigidArea(new Dimension(0, 10)));
        painelDireito.add(campoSenha);
        painelDireito.add(Box.createRigidArea(new Dimension(0, 20)));
        painelDireito.add(botaoEntrar);

        painelDireito.add(Box.createVerticalGlue());

        painelPrincipal.add(painelEsquerdo);
        painelPrincipal.add(painelDireito);

        frame.add(painelPrincipal);
        frame.setVisible(true);

        botaoEntrar.addActionListener(e -> {
            String email = campoEmail.getText();
            String senha = new String(campoSenha.getPassword());
            
            if (email.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Preencha todos os campos!");
            } else {
               
                JOptionPane.showMessageDialog(frame, "Login realizado com sucesso!");
            }
        });

        botaoVoltar.addActionListener(e -> {
            frame.dispose();           
        });
    }
}