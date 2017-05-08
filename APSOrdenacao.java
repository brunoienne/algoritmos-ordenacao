package aps.ordenacao;

import java.io.IOException;
import java.util.Scanner;

public class APSOrdenacao {

    public static void main(String[] args) throws IOException {
        Scanner tec = new Scanner(System.in);

        int opcao = 0, n = 1, qtd = 1;
        long tempoInicial, tempoFinal;
        String dir;

        System.out.println("Digite o diretório em que trabalharemos (sem aspas): ");
        dir = tec.nextLine();

        do {
            System.out.println("\nQuantos números deseja gerar?");
            System.out.println("\t\t1)     100");
            System.out.println("\t\t2)  10.000");
            System.out.println("\t\t3) 100.000");
            System.out.println("\t\t4) Definido pelo usuário");
            System.out.print("Opção: ");
            opcao = tec.nextInt();
        } while (opcao < 1 || opcao > 4);

        switch (opcao) {
            case 1:
                n = 100;
                break;
            case 2:
                n = 10000;
                break;
            case 3:
                n = 100000;
                break;
            case 4:
                do {
                    System.out.print("\tDigite um valor maior que 1: ");
                    qtd = tec.nextInt();
                } while (qtd < 2);
                n = qtd;
        }
        int[] num = new int[n]; //vetor de tamanho n
        Arquivo.escreverArquivo(num, dir); //metodo de criar arquivo

        int[] vet = Arquivo.lerArquivo(dir);// vetor vet irá receber todos os numeros do arquivo

        opcao = 0;
        do {
            System.out.println("\nDeseja ordenar por qual método?");
            System.out.println("\t\t1) QuickSort");
            System.out.println("\t\t2) InsertionSort");
            System.out.println("\t\t3) SelectionSort");
            System.out.println("\t\t4) Todos");
            System.out.print("Método: ");
            opcao = tec.nextInt();
        } while (opcao < 1 || opcao > 4);

        switch (opcao) {
            case 1: {
                tempoInicial = System.currentTimeMillis(); //tempo inicial da contagem
                Ordenador.quickSort(vet, 0, vet.length - 1);
                tempoFinal = System.currentTimeMillis(); //tempo final da contagem
                System.out.print("\nQuickSort ordeou em " + (tempoFinal - tempoInicial) + " ms\n");
                
                Arquivo.escreverArquivoOrdenado(vet, dir, "QuickSort");
                break;
            }
            case 2: {
                tempoInicial = System.currentTimeMillis();
                Ordenador.insertionSort(vet);
                tempoFinal = System.currentTimeMillis();
                System.out.print("\nInsertionSort ordeou em " + (tempoFinal - tempoInicial) + " ms\n");
                
                Arquivo.escreverArquivoOrdenado(vet, dir, "InsertionSort");
                break;
            }
            case 3: {
                tempoInicial = System.currentTimeMillis();
                Ordenador.selectionSort(vet);
                tempoFinal = System.currentTimeMillis();
                System.out.print("\nSelectionSort ordenou em " + (tempoFinal - tempoInicial) + " ms\n");
                
                Arquivo.escreverArquivoOrdenado(vet, dir, "SelectionSort");
                break;
            }
            case 4: {
                tempoInicial = System.currentTimeMillis(); //tempo inicial da contagem
                Ordenador.quickSort(vet, 0, vet.length - 1);
                tempoFinal = System.currentTimeMillis(); //tempo final da contagem
                System.out.print("\nQuickSort ordeou em " + (tempoFinal - tempoInicial) + " ms. ");
                
                Arquivo.escreverArquivoOrdenado(vet, dir, "QuickSort");

                tempoInicial = System.currentTimeMillis();
                Ordenador.insertionSort(vet);
                tempoFinal = System.currentTimeMillis();
                System.out.print("\nInsertionSort ordeou em " + (tempoFinal - tempoInicial) + " ms. ");
                
                Arquivo.escreverArquivoOrdenado(vet, dir, "InsertionSort");

                tempoInicial = System.currentTimeMillis();
                Ordenador.selectionSort(vet);
                tempoFinal = System.currentTimeMillis();
                System.out.print("\nSelectionSort ordenou em " + (tempoFinal - tempoInicial) + " ms. ");
                
                Arquivo.escreverArquivoOrdenado(vet, dir, "SelectionSort");
                break;
            }
        }
        System.out.println();
    }

}
