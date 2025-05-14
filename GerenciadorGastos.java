import java.util.ArrayList;
import java.util.List;

public class GerenciadorGastos {
    private static GerenciadorGastos instance;
    private List<Gasto> gastos;
    private List<AtualizadorGastos> listeners;

    private GerenciadorGastos() {
        gastos = new ArrayList<>();
        listeners = new ArrayList<>();
    }

    public static GerenciadorGastos getInstance() {
        if (instance == null) {
            instance = new GerenciadorGastos();
        }
        return instance;
    }

    public void adicionarGasto(Gasto gasto) {
        gastos.add(gasto);
        notificarListeners();
    }

    public void removerGasto(Gasto gasto) {
        gastos.remove(gasto);
        notificarListeners();
    }

    public double getTotalGastos() {
        return gastos.stream().mapToDouble(g -> g.valor).sum();
    }

    public void adicionarListener(AtualizadorGastos listener) {
        listeners.add(listener);
    }

    public void removerListener(AtualizadorGastos listener) {
        listeners.remove(listener);
    }

    private void notificarListeners() {
        double total = getTotalGastos();
        for (AtualizadorGastos listener : listeners) {
            listener.atualizarGastos(total);
        }
    }

    public interface AtualizadorGastos {
        void atualizarGastos(double total);
    }
} 