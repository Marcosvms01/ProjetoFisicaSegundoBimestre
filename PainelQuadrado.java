package com.mycompany.projetofisicasegundobimestre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PainelQuadrado extends JPanel {
    private final JTextArea output;
    private final JButton calcularBtn;
    private final JButton adicionarBtn;
    private final JTextField campoValor, campoX, campoY;
    private final ArrayList<Carga> cargas;
    private final int centroX = 300, centroY = 300;
    private final double escala = 0.0002;

    public PainelQuadrado() {
        setLayout(new BorderLayout());

        // Campos de entrada
        JPanel entrada = new JPanel(new FlowLayout());
        campoValor = new JTextField(5);
        campoX = new JTextField(5);
        campoY = new JTextField(5);

        entrada.add(new JLabel("Carga (e):"));
        entrada.add(campoValor);
        entrada.add(new JLabel("x:"));
        entrada.add(campoX);
        entrada.add(new JLabel("y:"));
        entrada.add(campoY);

        adicionarBtn = new JButton("Adicionar carga");
        entrada.add(adicionarBtn);

        calcularBtn = new JButton("Calcular Trabalho");
        entrada.add(calcularBtn);

        output = new JTextArea(10, 50);
        output.setEditable(false);
        JScrollPane scroll = new JScrollPane(output);

        add(entrada, BorderLayout.NORTH);
        add(scroll, BorderLayout.SOUTH);

        cargas = new ArrayList<>();

        adicionarBtn.addActionListener(e -> adicionarCarga());
        calcularBtn.addActionListener(e -> calcularTrabalho());
    }

    private void adicionarCarga() {
        try {
            double valor = Double.parseDouble(campoValor.getText());
            int x = Integer.parseInt(campoX.getText());
            int y = Integer.parseInt(campoY.getText());
            cargas.add(new Carga(valor, x, y));
            repaint();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Entrada inválida.");
        }
    }

    private void calcularTrabalho() {
        double q = 6 * FisicaUtils.e;
        double trabalho = FisicaUtils.trabalhoTotal(cargas.toArray(new Carga[0]), q, centroX, centroY, escala);

        output.setText("Resolução passo a passo:\n");
        double Vtotal = 0;
        for (Carga c : cargas) {
            double Vi = FisicaUtils.potencial(c, centroX, centroY, escala);
            Vtotal += Vi;
            output.append(String.format("Carga %.1fe em (%d,%d): V = %.2f V\n", c.valor, c.x, c.y, Vi));
        }
        output.append(String.format("\nPotencial total no centro: %.2f V", Vtotal));
        output.append(String.format("\nTrabalho = q * V = %.2e J", trabalho));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(centroX - 100, centroY - 100, 200, 200);
        g.setColor(Color.GREEN);
        g.fillOval(centroX - 6, centroY - 6, 12, 12);
        g.drawString("Centro", centroX + 10, centroY + 4);

        for (Carga c : cargas) {
            if (c.valor > 0) g.setColor(Color.RED);
            else if (c.valor < 0) g.setColor(Color.BLUE);
            else g.setColor(Color.GRAY);

            g.fillOval(c.x - 10, c.y - 10, 20, 20);
            g.setColor(Color.BLACK);
            g.drawString((c.valor > 0 ? "+" : "") + c.valor + "e", c.x - 12, c.y - 15);
        }
    }
}