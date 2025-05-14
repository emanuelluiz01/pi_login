import java.awt.*;
import javax.swing.*;

public class registro {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
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

        JLabel textoCadastre = new JLabel("Cadastre-se");
        textoCadastre.setFont(new Font("Arial", Font.PLAIN, 20));
        textoCadastre.setAlignmentX(Component.CENTER_ALIGNMENT);

        // JButton botaoVoltar = new JButton("Voltar");
        // botaoVoltar.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelEsquerdo.add(Box.createVerticalGlue());
        painelEsquerdo.add(titulo);
        painelEsquerdo.add(Box.createRigidArea(new Dimension(0, 10)));
        painelEsquerdo.add(textoEasy);
        painelEsquerdo.add(Box.createRigidArea(new Dimension(0, 10)));
        painelEsquerdo.add(textoCadastre);
        painelEsquerdo.add(Box.createRigidArea(new Dimension(0, 30)));
        // painelEsquerdo.add(botaoVoltar);
        painelEsquerdo.add(Box.createVerticalGlue());

        JPanel painelDireito = new JPanel();
        painelDireito.setLayout(new BoxLayout(painelDireito, BoxLayout.Y_AXIS));
        painelDireito.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        painelDireito.add(Box.createVerticalGlue()); 

        JLabel criarConta = new JLabel("CRIAR CONTA");
        criarConta.setFont(new Font("Arial", Font.BOLD, 22));
        criarConta.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelDireito.add(criarConta);

        painelDireito.add(Box.createRigidArea(new Dimension(0, 20)));

        JTextField campoNome = new JTextField();
        campoNome.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        campoNome.setBorder(BorderFactory.createTitledBorder("Nome"));
        painelDireito.add(campoNome);

        painelDireito.add(Box.createRigidArea(new Dimension(0, 10)));

        JTextField campoEmail = new JTextField();
        campoEmail.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        campoEmail.setBorder(BorderFactory.createTitledBorder("Email"));
        painelDireito.add(campoEmail);

        painelDireito.add(Box.createRigidArea(new Dimension(0, 10)));

        JPasswordField campoSenha = new JPasswordField();
        campoSenha.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        campoSenha.setBorder(BorderFactory.createTitledBorder("Senha"));
        painelDireito.add(campoSenha);

        painelDireito.add(Box.createRigidArea(new Dimension(0, 10)));

        JPasswordField campoConfirma = new JPasswordField();
        campoConfirma.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        campoConfirma.setBorder(BorderFactory.createTitledBorder("Confirmar senha"));
        painelDireito.add(campoConfirma);

        painelDireito.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton botaoCriar = new JButton("CRIAR");
        botaoCriar.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelDireito.add(botaoCriar);

        painelDireito.add(Box.createVerticalGlue());

        painelPrincipal.add(painelEsquerdo);
        painelPrincipal.add(painelDireito);

        frame.add(painelPrincipal);
        frame.setVisible(true);

        botaoCriar.addActionListener(e -> {
            String senha = new String(campoSenha.getPassword());
            String confirma = new String(campoConfirma.getPassword());
            if (!senha.equals(confirma)) {
                JOptionPane.showMessageDialog(frame, "As senhas não coincidem!");
            } else {
                JOptionPane.showMessageDialog(frame, "Cadastro realizado com sucesso!");
                frame.dispose(); 
                login.main(null);
            }
        });

        // botaoVoltar.addActionListener(e -> {
        //     JOptionPane.showMessageDialog(frame, "Voltando...");
        // });
    }
}