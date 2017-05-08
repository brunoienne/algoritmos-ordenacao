package aps.ordenacao;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Arquivo {

    public static void escreverArquivo(int num[], String dir) {
        long tempoInicial, tempoFinal;
        tempoInicial = System.currentTimeMillis();
        
        try {
            FileWriter arq = new FileWriter(dir + "\\original.txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            for (int i = 0; i < num.length; i++) {
                num[i] = (int) (12345678 + Math.random() * 87654321); //salvando numeros aleatorios de 8 digitos no vetor 
                gravarArq.print(num[i] + " ");
            }
            arq.close();
            tempoFinal = System.currentTimeMillis();
            System.out.println("Arquivo '" + dir + "\\original.txt' gerado com sucesso! Levou " + (tempoFinal-tempoInicial) + "ms");
        } catch (Exception e) {
            System.out.println("Arquivo '" + dir + "\\original.txt' não pode ser gerado!");
        }   
    }

    public static int[] lerArquivo(String dir) {
        try {
            File f = new File(dir + "\\original.txt");
            Scanner s = new Scanner(f);
            int ctr = 0;
            while (s.hasNextInt()) {
                ctr++;
                s.nextInt();
            }
            int[] vet = new int[ctr];
            Scanner s1 = new Scanner(f);
            for (int i = 0; i < vet.length; i++) {
                vet[i] = s1.nextInt();
            }
            return vet;
        } catch (Exception e) {
            return null;
        }
    }

    public static void escreverArquivoOrdenado(int vet[], String dir, String tipo) {
        long tempoInicial, tempoFinal;
        tempoInicial = System.currentTimeMillis();
        
        try {
            FileWriter arq = new FileWriter(dir + "\\ordenado_" + tipo + ".txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            for (int i = 0; i < vet.length; i++) {
                gravarArq.print(vet[i] + " ");
            }
            arq.close();
            tempoFinal = System.currentTimeMillis();
            System.out.print("Arquivo gerado em " + (tempoFinal-tempoInicial) + "ms");
        } catch (Exception e) {
            System.out.print("Arquivo não pôde ser gerado!");
        }
    }

}
