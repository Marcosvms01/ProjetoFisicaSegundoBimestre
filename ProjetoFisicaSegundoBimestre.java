package com.mycompany.projetofisicasegundobimestre;

 import javax.swing.*;

public class ProjetoFisicaSegundoBimestre {

   
    public static void main(String[] args) {
        JFrame frame = new JFrame("Trabalho Elétrico - Quadrado de Cargas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        frame.add(new PainelQuadrado());
        frame.setVisible(true);
    }
}
