import javax.swing.*;
import java.awt.*;

public class CadastroFaculdade {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro");
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

        JLabel textoCadastre = new JLabel("Cadastre-se");
        textoCadastre.setFont(new Font("Arial", Font.PLAIN, 20));
        textoCadastre.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelEsquerdo.add(Box.createVerticalGlue());
        painelEsquerdo.add(titulo);
        painelEsquerdo.add(Box.createRigidArea(new Dimension(0, 10)));
        painelEsquerdo.add(textoEasy);
        painelEsquerdo.add(Box.createRigidArea(new Dimension(0, 10)));
        painelEsquerdo.add(textoCadastre);
        painelEsquerdo.add(Box.createRigidArea(new Dimension(0, 30)));
        painelEsquerdo.add(botaoVoltar);
        painelEsquerdo.add(Box.createVerticalGlue());

        painelPrincipal.add(painelEsquerdo);

        frame.add(painelPrincipal);
        frame.setVisible(true);
    }  
}