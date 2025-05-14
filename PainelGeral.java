import javax.swing.*;
import java.awt.*;

public class PainelGeral extends JFrame {
    public PainelGeral() {
        setTitle("Painel Geral");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        setBackground(new Color(58, 191, 170));
        setLayout(new BorderLayout());

        JPanel topo = new JPanel();
        topo.setBackground(Color.WHITE);
        topo.setLayout(new BorderLayout());
        topo.setPreferredSize(new Dimension(1000, 60));

        JLabel logo = new JLabel("EASY");
        logo.setFont(new Font("Arial", Font.BOLD, 28));
        logo.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        topo.add(logo, BorderLayout.WEST);

        JPanel painelMenus = new JPanel(new GridBagLayout());
        painelMenus.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 12, 0, 12);
        String[] menus = {"Geral", "Saldo", "Gastos", "Investimentos", "Calendário"};
        for (String menu : menus) {
            JButton btn = new JButton(menu);
            if (menu.equals("Geral")) {
                btn.setBackground(new Color(166, 217, 207));
                btn.setForeground(new Color(61, 94, 87));
            } else {
                btn.setBackground(new Color(58, 191, 170));
                btn.setForeground(Color.WHITE);
            }
            btn.setFont(new Font("Arial", Font.BOLD, 16));
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createEmptyBorder(8, 18, 8, 18));
            painelMenus.add(btn, gbc);
        }
        topo.add(painelMenus, BorderLayout.CENTER);

        JPanel espacoDireita = new JPanel();
        espacoDireita.setBackground(Color.WHITE);
        espacoDireita.setPreferredSize(new Dimension(logo.getPreferredSize().width, 10));
        topo.add(espacoDireita, BorderLayout.EAST);

        add(topo, BorderLayout.NORTH);

        JPanel painelCentral = new JPanel();
        painelCentral.setBackground(new Color(58, 191, 170));
        painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.Y_AXIS));

        JPanel painelEntradasSaidas = new JPanel();
        painelEntradasSaidas.setBackground(new Color(58, 191, 170));
        painelEntradasSaidas.setLayout(new BoxLayout(painelEntradasSaidas, BoxLayout.X_AXIS));
        painelEntradasSaidas.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelEntradasSaidas.setMaximumSize(new Dimension(900, 200));
        painelEntradasSaidas.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));

        JPanel cardEntrada = new JPanel();
        cardEntrada.setBackground(new Color(166, 217, 207));
        cardEntrada.setLayout(new BoxLayout(cardEntrada, BoxLayout.Y_AXIS));
        cardEntrada.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        cardEntrada.setMaximumSize(new Dimension(350, 160));
        cardEntrada.setPreferredSize(new Dimension(350, 160));
        cardEntrada.setAlignmentY(Component.TOP_ALIGNMENT);
        cardEntrada.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel painelTituloEntrada = new JPanel();
        painelTituloEntrada.setBackground(new Color(61, 94, 87));
        painelTituloEntrada.setLayout(new BorderLayout());
        painelTituloEntrada.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        painelTituloEntrada.setPreferredSize(new Dimension(350, 40));
        JLabel lblEntradaTitulo = new JLabel("ENTRADA", SwingConstants.CENTER);
        lblEntradaTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        lblEntradaTitulo.setForeground(Color.WHITE);
        lblEntradaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        painelTituloEntrada.add(lblEntradaTitulo, BorderLayout.CENTER);
        cardEntrada.add(painelTituloEntrada);

        JLabel lblEntradaValor = new JLabel("R$0", SwingConstants.CENTER);
        lblEntradaValor.setFont(new Font("Arial", Font.BOLD, 32));
        lblEntradaValor.setForeground(new Color(61, 94, 87));
        lblEntradaValor.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblEntradaValor.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        cardEntrada.add(lblEntradaValor);

        JButton btnAddEntrada = new JButton("ADICIONAR ENTRADA");
        btnAddEntrada.setFont(new Font("Arial", Font.PLAIN, 16));
        btnAddEntrada.setBackground(new Color(166, 217, 207));
        btnAddEntrada.setForeground(new Color(61, 94, 87));
        btnAddEntrada.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        btnAddEntrada.setFocusPainted(false);
        btnAddEntrada.setContentAreaFilled(false);
        btnAddEntrada.setAlignmentX(Component.CENTER_ALIGNMENT);
        cardEntrada.add(btnAddEntrada);

        painelEntradasSaidas.add(Box.createHorizontalGlue());
        painelEntradasSaidas.add(cardEntrada);
        painelEntradasSaidas.add(Box.createHorizontalStrut(60));

        JPanel cardSaida = new JPanel();
        cardSaida.setBackground(new Color(166, 217, 207));
        cardSaida.setLayout(new BoxLayout(cardSaida, BoxLayout.Y_AXIS));
        cardSaida.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        cardSaida.setMaximumSize(new Dimension(350, 160));
        cardSaida.setPreferredSize(new Dimension(350, 160));
        cardSaida.setAlignmentY(Component.TOP_ALIGNMENT);
        cardSaida.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel painelTituloSaida = new JPanel();
        painelTituloSaida.setBackground(new Color(61, 94, 87));
        painelTituloSaida.setLayout(new BorderLayout());
        painelTituloSaida.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        painelTituloSaida.setPreferredSize(new Dimension(350, 40));
        JLabel lblSaidaTitulo = new JLabel("SAÍDA", SwingConstants.CENTER);
        lblSaidaTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        lblSaidaTitulo.setForeground(Color.WHITE);
        lblSaidaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        painelTituloSaida.add(lblSaidaTitulo, BorderLayout.CENTER);
        cardSaida.add(painelTituloSaida);

        JLabel lblSaidaValor = new JLabel("R$0", SwingConstants.CENTER);
        lblSaidaValor.setFont(new Font("Arial", Font.BOLD, 32));
        lblSaidaValor.setForeground(new Color(61, 94, 87));
        lblSaidaValor.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblSaidaValor.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        cardSaida.add(lblSaidaValor);

        JButton btnAddSaida = new JButton("ADICIONAR SAIDA");
        btnAddSaida.setFont(new Font("Arial", Font.PLAIN, 16));
        btnAddSaida.setBackground(new Color(166, 217, 207));
        btnAddSaida.setForeground(new Color(61, 94, 87));
        btnAddSaida.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        btnAddSaida.setFocusPainted(false);
        btnAddSaida.setContentAreaFilled(false);
        btnAddSaida.setAlignmentX(Component.CENTER_ALIGNMENT);
        cardSaida.add(btnAddSaida);

        painelEntradasSaidas.add(cardSaida);
        painelEntradasSaidas.add(Box.createHorizontalGlue());

        painelCentral.add(painelEntradasSaidas);
        painelCentral.add(Box.createVerticalStrut(60));

        JLabel lblSaldoTitulo = new JLabel("SALDO DISPONÍVEL", SwingConstants.CENTER);
        lblSaldoTitulo.setFont(new Font("Arial", Font.BOLD, 36));
        lblSaldoTitulo.setForeground(new Color(44, 102, 97));
        lblSaldoTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelCentral.add(lblSaldoTitulo);

        painelCentral.add(Box.createVerticalStrut(20));

        JPanel painelSaldo = new JPanel();
        painelSaldo.setBackground(new Color(166, 217, 207));
        painelSaldo.setMaximumSize(new Dimension(300, 60));
        painelSaldo.setPreferredSize(new Dimension(300, 60));
        painelSaldo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSaldoValor = new JLabel("R$0", SwingConstants.CENTER);
        lblSaldoValor.setFont(new Font("Arial", Font.BOLD, 32));
        lblSaldoValor.setForeground(new Color(44, 102, 97));
        painelSaldo.add(lblSaldoValor);

        painelCentral.add(painelSaldo);

        add(painelCentral, BorderLayout.CENTER);
    }


}