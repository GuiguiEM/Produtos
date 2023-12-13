package br.senai.sp.jandira.model;

import java.util.Scanner;

public class Cliente {

    private String nome, email;
    int cpf, telefone;

    private int cpfCliente = 0;

    public void cadastrarFuncionario(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome: ");
        this.nome = scanner.nextLine();
        System.out.println("Informe o email: ");
        this.email = scanner.nextLine();
        System.out.println("Informe o cpf: ");
        this.cpf = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Informe o telefone: ");
        this.telefone = scanner.nextInt();
        scanner.nextLine();
        System.out.println("-------------------------------");

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(int cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
}