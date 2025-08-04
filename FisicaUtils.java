package com.mycompany.projetofisicasegundobimestre;

public class FisicaUtils {
    public static final double k = 8.99e9;
    public static final double e = 1.6e-19;

    public static double distancia(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static double potencial(Carga c, int xCentro, int yCentro, double escala) {
        double r = distancia(c.x, c.y, xCentro, yCentro) * escala; // em metros
        if (r == 0) return 0; // ignora a carga central
        return k * (c.valor * e) / r;
    }

    public static double trabalhoTotal(Carga[] cargas, double q, int xCentro, int yCentro, double escala) {
        double Vtotal = 0;
        for (Carga c : cargas) {
            Vtotal += potencial(c, xCentro, yCentro, escala);
        }
        return q * Vtotal;
    }
}
