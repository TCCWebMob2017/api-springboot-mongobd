package com.appmed.app.domain.perfil;

public class TipoSanguineo {

    private Tipo tipo;
    private Rh rh;
    static int m[][] = new int[8][8];
    static TipoSanguineo tipos[] = new TipoSanguineo[8];

    private TipoSanguineo() {

        tipos[0] = new TipoSanguineo(Tipo.O, Rh.NEGATIVO);
        m[0][0] = 1;
        tipos[1] = new TipoSanguineo(Tipo.O, Rh.POSITIVO);
        m[1][0] = 1;
        m[1][1] = 1;

        tipos[2] = new TipoSanguineo(Tipo.A, Rh.NEGATIVO);
        m[2][0] = 1;
        m[2][2] = 1;

        tipos[3] = new TipoSanguineo(Tipo.A, Rh.POSITIVO);
        m[3][0] = 1;
        m[3][1] = 1;
        m[3][2] = 1;
        m[3][3] = 1;
        tipos[4] = new TipoSanguineo(Tipo.B, Rh.NEGATIVO);
        m[4][0] = 1;
        m[4][4] = 1;
        tipos[5] = new TipoSanguineo(Tipo.B, Rh.POSITIVO);
        m[5][0] = 1;
        m[5][1] = 1;
        m[5][4] = 1;
        m[5][5] = 1;
        tipos[6] = new TipoSanguineo(Tipo.AB, Rh.NEGATIVO);
        m[6][0] = 1;
        m[6][2] = 1;
        m[6][4] = 1;
        m[6][6] = 1;
        tipos[7] = new TipoSanguineo(Tipo.AB, Rh.POSITIVO);
        m[7][0] = 1;
        m[7][1] = 1;
        m[7][2] = 1;
        m[7][3] = 1;
        m[7][4] = 1;
        m[7][5] = 1;
        m[7][6] = 1;
        m[7][7] = 1;
    }

    public TipoSanguineo(Tipo tipo, Rh rh) {
        this.tipo = tipo;
        this.rh = rh;

    }

    enum Tipo {
        O, A, B, AB
    }

    enum Rh {
        POSITIVO, NEGATIVO
    }

    @Override
    public String toString() {
        return tipo + " " + rh;
    }

    public static void main(String[] args) {
        new TipoSanguineo();
        for (int i = 0; i < 8; i++) {

            System.out.println(">" + tipos[i] + " recebe:");
            for (int j = 0; j < 8; j++) {
                if (m[i][j] > 0) {
                    System.out.print(tipos[j] + ", ");
                }
            }
            System.out.println();

        }

        for (int i = 0; i < 8; i++) {

            System.out.println(">" + tipos[i] + " doa: ");
            for (int j = 0; j < 8; j++) {
                if (m[j][i] > 0) {
                    System.out.print(tipos[i] + ", ");
                }
            }
            System.out.println();

        }

    }

}
