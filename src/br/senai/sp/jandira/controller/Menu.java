package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Cliente;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    public void executarMenu() throws SQLException {
        boolean continuar = true;

        while (continuar){
            System.out.println(" ------- bem vindo ----------");
            System.out.println("          M E N U            ");
            System.out.println("1- Listar Funcionarios       ");
            System.out.println("2- Cadastrar Funcionarios    ");
            System.out.println("3- Editar Funcionarios       ");
            System.out.println("4- Deletar Funcionarios      ");
            System.out.println("5- Pesquisar Funcionarios    ");
            System.out.println("6- Sair                      ");

            Scanner scanner = new Scanner(System.in);
            ClienteController funcionario = new ClienteController();


            int userOption = scanner.nextInt();
            scanner.nextLine();

            switch (userOption){
                case 1 :
                    funcionario.listarFuncionario();
                    break;
                case 2 :
                    Cliente newCliente = new Cliente();
                    newCliente.cadastrarFuncionario();

                    funcionario.cadastrarFuncionario(newCliente);
                    break;

                case 3 :
                    System.out.println("Informe o nome que deseja atualizar: ");
                    String nomeUpdate  = scanner.nextLine();
                    System.out.println("Informe o novo salário");
                    Double newSalario = scanner.nextDouble();
                    scanner.nextLine();

                    funcionario.editarFuncionario(nomeUpdate, newSalario);
                    break;

                case 4 :
                    System.out.println("Informe o nome que deseja excluir: ");
                    String nome = scanner.nextLine();
                    funcionario.deletarFuncionario(nome);
                    break;

                case 5 :
                    System.out.println("Informe o nome que deseja pesquisar: ");
                    String nomeConsulta = scanner.nextLine();
                    funcionario.consultarFuncionario(nomeConsulta);
                    break;

                case 6 :
                    continuar = false;
                    break;
            }
        }
    }

}