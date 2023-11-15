package aplication;

import java.util.*;

public class program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numerosSorteados = new ArrayList<>();
        Random geradorSorteio = new Random();
        int[] vetorNumero = new int[7];

        //System.out.print(imprimirMegasena(vetorNumero));

        boolean condicao = true;
        System.out.println();
        while (condicao == true) {
            try {
                System.out.println("informe um numero de (0 a 100): ");

                for (int i = 0; i < vetorNumero.length; i++) {
                    int escolhaNumero = scan.nextInt();
                    vetorNumero[i] = escolhaNumero;

                    while (vetorNumero[i] < 0 || vetorNumero[i] > 100) {
                        System.err.println("erro, informe um numero de (0 a 100): ");
                        vetorNumero[i] = scan.nextInt();
                    }
                }
                condicao = false;
            } catch (StringIndexOutOfBoundsException e) {
                System.err.println("erro:" + e.getMessage());
                condicao = true;
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("error: " + e.getMessage());
                condicao = true;
                scan.nextLine();
            }
        }
        System.out.print("Seus numeros: "+ numerosEscolhidos(vetorNumero));

        for (int i = 0; i < 6; i++) {
            numerosSorteados.add(geradorSorteio.nextInt(100));
        }

        System.out.println();
        for(int i : numerosSorteados ) {
            System.out.print("Numeros sorteados:" + numerosSorteados);
        }
        System.out.println("acertos: " + imprimirAcertos(vetorNumero, numerosSorteados));


    }

    public static int[][] imprimirMegasena(int[] vetor) {
        int tamanho = 10;
        int[][] cartela = new int[tamanho][tamanho];

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                for (int k : vetor) {
                    if (k == cartela[i][j])
                        System.out.print("(" + cartela[i][j] + ")");
                    else {
                        System.out.print(cartela[i][j] + "");
                    }
                    System.out.println();

                }
            }
        }
        return cartela;
    }

    public static int imprimirAcertos(int[] vetor, List<Integer> numerosSorteados) {
        // int[] vetorNumero = new int[7];
        int acertos = 0;
        for (int i = 0; i < vetor.length; i++) {
            for (Integer ns : numerosSorteados)
                if (vetor[i] == ns) {
                    acertos++;
                }
        }
        if (acertos == 5) {
            System.out.print("Parabéns seu premio foi de R$ 10 mil reais");
        } else if (acertos == 6) {
            System.out.print("Parabéns seu premio foi de R$ 50 mil reais");
        } else if (acertos == 7) {
            System.out.print("Parabéns seu premio foi de R$ 200 mil reais");
        }
        return acertos;
    }

    public static int[] numerosEscolhidos(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        return vetor;
    }
}