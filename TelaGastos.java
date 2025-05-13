import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TelaGastos extends JFrame {
    private JPanel painelCards;
    private ArrayList<Gasto> listaGastos;

    public TelaGastos() {
        setTitle("Gastos - EASY");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        listaGastos = new ArrayList<>();

        JPanel topo = new JPanel();
        topo.setBackground(Color.WHITE);
        topo.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        topo.setPreferredSize(new Dimension(900, 60));

        JLabel logo = new JLabel("EASY");
        logo.setFont(new Font("Arial", Font.BOLD, 28));
        topo.add(logo);

        String[] menus = {"Geral", "Saldo", "Gastos", "Investimentos", "Calendário"};
        for (String menu : menus) {
            JButton btn = new JButton(menu);
            if (menu.equals("Gastos")) {
                btn.setBackground(new Color(166, 217, 207));
                btn.setForeground(new Color(61, 94, 87));
            } else {
                btn.setBackground(new Color(58, 191, 170));
                btn.setForeground(Color.WHITE);
            }
            btn.setFont(new Font("Arial", Font.BOLD, 16));
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createEmptyBorder(8, 18, 8, 18));
            topo.add(btn);
        }

        add(topo, BorderLayout.NORTH);

        painelCards = new JPanel();
        painelCards.setBackground(new Color(58, 191, 170));
        painelCards.setLayout(new BoxLayout(painelCards, BoxLayout.Y_AXIS));

        JPanel painelCardsWrapper = new JPanel(new BorderLayout());
        painelCardsWrapper.setBackground(new Color(58, 191, 170));
        painelCardsWrapper.add(painelCards, BorderLayout.NORTH);

        JScrollPane scroll = new JScrollPane(painelCardsWrapper);
        scroll.setBorder(null);
        scroll.setPreferredSize(new Dimension(900, 400));
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        add(scroll, BorderLayout.CENTER);

        JButton botaoAdd = new JButton("+");
        botaoAdd.setFont(new Font("Arial", Font.BOLD, 36));
        botaoAdd.setBackground(new Color(44, 102, 97));
        botaoAdd.setForeground(Color.WHITE);
        botaoAdd.setFocusPainted(false);
        botaoAdd.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4, true));
        botaoAdd.setPreferredSize(new Dimension(70, 70));
        botaoAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPanel painelBotao = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 10));
        painelBotao.setBackground(new Color(58, 191, 170));
        painelBotao.add(botaoAdd);
        add(painelBotao, BorderLayout.SOUTH);

        botaoAdd.addActionListener(e -> abrirModalNovoGasto());

        adicionarGasto("RESERVA MENSAL", 400);
        adicionarGasto("ACADEMIA", 120);
        adicionarGasto("CONTA DE ÁGUA", 210);
        adicionarGasto("MERCADO", 1500);
        adicionarGasto("FARMÁCIA", 150);
    }

    private void abrirModalNovoGasto() {
        JDialog modal = new JDialog(this, "Novo Gasto", true);
        modal.setSize(400, 300);
        modal.setLocationRelativeTo(this);
        modal.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("SAÍDA", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(new Color(58, 191, 170));
        modal.add(titulo, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel();
        painelCampos.setLayout(new GridLayout(3, 1, 10, 10));
        painelCampos.setBackground(Color.WHITE);
        painelCampos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField campoNome = new JTextField();
        campoNome.setFont(new Font("Arial", Font.BOLD, 16));
        campoNome.setBackground(Color.WHITE);
        campoNome.setForeground(new Color(44, 102, 97));
        campoNome.setBorder(BorderFactory.createLineBorder(new Color(44, 102, 97), 2));
        painelCampos.add(campoComRotulo("NOME", campoNome));

        JTextField campoDescricao = new JTextField();
        campoDescricao.setFont(new Font("Arial", Font.BOLD, 16));
        campoDescricao.setBackground(Color.WHITE);
        campoDescricao.setForeground(new Color(44, 102, 97));
        campoDescricao.setBorder(BorderFactory.createLineBorder(new Color(44, 102, 97), 2));
        painelCampos.add(campoComRotulo("DESCRIÇÃO", campoDescricao));

        JTextField campoValor = new JTextField();
        campoValor.setFont(new Font("Arial", Font.BOLD, 16));
        campoValor.setBackground(Color.WHITE);
        campoValor.setForeground(new Color(44, 102, 97));
        campoValor.setBorder(BorderFactory.createLineBorder(new Color(44, 102, 97), 2));
        painelCampos.add(campoComRotulo("VALOR", campoValor));

        modal.add(painelCampos, BorderLayout.CENTER);

        JButton botaoCriar = new JButton("CRIAR");
        botaoCriar.setFont(new Font("Arial", Font.BOLD, 16));
        botaoCriar.setBackground(new Color(58, 191, 170));
        botaoCriar.setForeground(Color.WHITE);
        botaoCriar.setFocusPainted(false);
        botaoCriar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        botaoCriar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        botaoCriar.addActionListener(e -> {
            String nome = campoNome.getText().trim();
            String descricao = campoDescricao.getText().trim();
            String valorStr = campoValor.getText().trim();
            if (!nome.isEmpty() && !valorStr.isEmpty()) {
                try {
                    double valor = Double.parseDouble(valorStr.replace(",", "."));
                    adicionarGasto(nome, valor);
                    modal.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(modal, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(modal, "Preencha todos os campos!", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        });

        JPanel painelBotao = new JPanel();
        painelBotao.setBackground(Color.WHITE);
        painelBotao.add(botaoCriar);

        modal.add(painelBotao, BorderLayout.SOUTH);

        modal.setVisible(true);
    }

    private JPanel campoComRotulo(String rotulo, JTextField campo) {
        JPanel painel = new JPanel(new BorderLayout());
        painel.setBackground(Color.WHITE);

        JLabel label = new JLabel(rotulo);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(new Color(58, 191, 170));
        painel.add(label, BorderLayout.NORTH);
        painel.add(campo, BorderLayout.CENTER);

        return painel;
    }

    private void adicionarGasto(String nome, double valor) {
        Gasto gasto = new Gasto(nome, valor);
        listaGastos.add(gasto);
        painelCards.add(Box.createVerticalStrut(10));
        painelCards.add(criarCardGasto(gasto));
        painelCards.add(Box.createVerticalStrut(10)); 
        painelCards.revalidate();
        painelCards.repaint();
    }

    private JPanel criarCardGasto(Gasto gasto) {
        JPanel card = new JPanel();
        card.setBackground(new Color(240, 255, 255));
        card.setMaximumSize(new Dimension(700, 60));
        card.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        card.setLayout(new BorderLayout());

        JLabel nome = new JLabel(gasto.nome);
        nome.setFont(new Font("Arial", Font.BOLD, 20));
        nome.setForeground(new Color(51, 102, 102));

        JLabel valor = new JLabel("R$" + String.format("%.2f", gasto.valor));
        valor.setFont(new Font("Arial", Font.BOLD, 18));
        valor.setForeground(new Color(51, 102, 102));

        card.add(nome, BorderLayout.WEST);
        card.add(valor, BorderLayout.EAST);
        card.setAlignmentX(Component.CENTER_ALIGNMENT);
        return card;
    }

    private static class Gasto {
        String nome;
        double valor;

        public Gasto(String nome, double valor) {
            this.nome = nome;
            this.valor = valor;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaGastos().setVisible(true));
    }
}