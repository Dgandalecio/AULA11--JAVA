/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.josephusproblem;
import java.util.LinkedList;
import java.util.Random;
/**
 *
 * @author diogo
 */
class Pessoa {
    int numero;
    String nome;
    String telefone;
    String endereco;
    String cpf;

    public Pessoa(int numero, String nome, String telefone, String endereco, String cpf) {
        this.numero = numero;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Número: " + numero +
                ", Nome: " + nome +
                ", Telefone: " + telefone +
                ", Endereço: " + endereco +
                ", CPF: " + cpf;
    }
}

public class JosephusProblem {

    private static final Random random = new Random();

    private static String gerarNome() {
        String[] nomes = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry", "Ivy", "Jack"};
        return nomes[random.nextInt(nomes.length)];
    }

    private static String gerarTelefone() {
        return "9" + (10000000 + random.nextInt(90000000));
    }

    private static String gerarEndereco() {
        String[] enderecos = {"Rua A", "Avenida B", "Travessa C", "Alameda D", "Praça E"};
        return enderecos[random.nextInt(enderecos.length)] + ", " + (random.nextInt(100) + 1);
    }

    private static String gerarCPF() {
        return String.format("%03d.%03d.%03d-%02d", random.nextInt(1000), random.nextInt(1000), random.nextInt(1000), random.nextInt(100));
    }

    public static Pessoa encontrarSobrevivente(int n) {
        LinkedList<Pessoa> roda = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            Pessoa pessoa = new Pessoa(i, gerarNome(), gerarTelefone(), gerarEndereco(), gerarCPF());
            roda.add(pessoa);
        }

        int indice = 0;
        while (roda.size() > 1) {
            int m = random.nextInt(roda.size());
            indice = (indice + m) % roda.size();
            System.out.println("Eliminada: " + roda.remove(indice));
        }

        return roda.get(0);
    }

    public static void main(String[] args) {
        int n = 20;

        Pessoa sobrevivente = encontrarSobrevivente(n);

        System.out.println("A pessoa sobrevivente é:\n" + sobrevivente);
    }
}