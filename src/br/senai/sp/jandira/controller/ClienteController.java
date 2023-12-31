package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Conexao;
import br.senai.sp.jandira.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    Conexao conexao = new Conexao();

    Connection connection = conexao.getConnection();

    public void listarClientes() throws SQLException {

        Statement statement = connection.createStatement();
        String queryList = "select * from clientes";

        ResultSet resultSet = statement.executeQuery(queryList);

        Cliente cliente = new Cliente();

        while (resultSet.next()){
            cliente.setCpfCliente(resultSet.getInt("id_cliente"));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setCpf(resultSet.getInt("cpf"));
            cliente.setCpf(resultSet.getInt("telefone"));

            System.out.println(cliente.getCpfCliente());
            System.out.println(cliente.getNome());
            System.out.println(cliente.getEmail());
            System.out.println(cliente.getCpf());
            System.out.println(cliente.getTelefone());
            System.out.println(" ------------------------------ ");

        }

    }

    public void deletarCliente (int cpf) throws SQLException {
        Statement statement = connection.createStatement();

        String queryUpdate = "Delete from clientes where cpf = " + cpf;

        statement.executeUpdate(queryUpdate);
        System.out.println("O cliente que possui o CPF " + cpf + " deletado!!");

    }

    public void cadastrarCliente(Cliente cliente) throws SQLException {
        Statement statement = connection.createStatement();

        String queryCadastro = "INSERT INTO clientes (id_cliente, nome, cpf, email, telefone) values (" +
                cliente.getCpfCliente() + ",'" + cliente.getNome() + "'," + cliente.getCpf() + ",'" +
                cliente.getEmail() + "'," + cliente.getTelefone() + ")";

        statement.executeUpdate(queryCadastro);
        System.out.println(" O cliente foi cadastrado!!");
    }

    public void consultarCliente(int cpf) throws SQLException {
        Statement statement = connection.createStatement();

        String queryConsulta = "SELECT * FROM clientes WHERE cpf = '" + cpf + "'";
        ResultSet resultSet = statement.executeQuery(queryConsulta);

        List<Cliente> listConsulta = new ArrayList<>();

        while (resultSet.next()) {
            Cliente cliente = new Cliente();

            cliente.setCpfCliente(resultSet.getInt("id_cliente"));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setCpf(resultSet.getInt("cpf"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setTelefone(resultSet.getInt("telefone"));

            listConsulta.add(cliente);
        }

        for (Cliente cliente : listConsulta) {
            System.out.println(cliente.getCpfCliente());
            System.out.println(cliente.getNome());
            System.out.println(cliente.getCpf());
            System.out.println(cliente.getEmail());
            System.out.println(cliente.getTelefone());
            System.out.println("/--------------------------------/");

        }
    }
}
