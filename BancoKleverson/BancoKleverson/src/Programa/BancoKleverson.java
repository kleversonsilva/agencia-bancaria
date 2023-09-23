package Programa;

import javax.swing.*;
import java.util.ArrayList;   //CLASSE DE TODAS AS CONTAS
import java.util.Scanner;

public class BancoKleverson {
    static Scanner input = new Scanner(System.in);
    //Pegar dados do user
    static ArrayList<Conta> contasBancarias;  //Lista de varias contas

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();  //estanciar nossa lista
        operacoes();
    }

    public static void operacoes() {

        int operacao= Integer.parseInt(JOptionPane.showInputDialog("Digite uma opcao:"+
        //System.out.println("---------------------");
        //System.out.println("---------Bem Vindos ao Nosso Banco!-----------");
        //System.out.println("----------------------------------------------");
        //System.out.println("*****Selecione Uma Operação Disponivel*****");
        //System.out.println("----------------------------------------------");
        "|   Opção 1 - Criar Conta   |"+
        "|   Opção 2 - Depositar     |"+
        "|   Opção 3 - Sacar         |"+
        "|   Opção 4 - Transferir    |"+
        "|   Opção 5 - Listar        |"+
        "|   Opção  - Sair           |"));

        //int operacao = input.nextInt();
        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                JOptionPane.showMessageDialog(null,"Obg por usar nossos serviços!");
                System.exit(0); //saio do Programa.
                break;

            default:
                JOptionPane.showMessageDialog(null,"opcao invalida!");
                //se o user digitar funcao q nao existe
                operacoes();//chama menu operaçoes novamente.
                break;
        }
    }

    //private static void listar() {


    //CRIAR CONTA: precisa de Nome, cpf e Email.
    public static void criarConta() {
        Pessoa pessoa = new Pessoa(); //ESSE CONSTRUTOR FOI CRIADO NA CLASSpESSOA
        pessoa.setNome(JOptionPane.showInputDialog("Nome: "));

        pessoa.setCpf(JOptionPane.showInputDialog("CPF: "));

        pessoa.setEmail(JOptionPane.showInputDialog("Email: "));

        Conta conta = new Conta(pessoa);  //Add a Pessoa a conta, OU seja passa a pessoa criada para conta.

        contasBancarias.add(conta);  //ADD A LISTAdeCONTAS
        JOptionPane.showMessageDialog(null,"SUA CONTA FOI CRIADA");
        //System.out.println("Sua conta foi Criada!!");
        operacoes();

    }
    //ENCONTRAR CONTA:
    private static Conta encotrarConta(int numConta) { //Criar conta nula para comprar se a conta que o usuario digitar existe memo
        Conta conta = null;
        if (contasBancarias.size() > 0) {   //conferir na listadeContas se conta existe
            for(Conta c: contasBancarias){//ver se para cada conta "c" dentro de contasbancaria tem a conta do usuario
                if (c.getNumConta()==numConta);//Se existe conta==numconta q o User digitou
                conta=c;//Recebe a conta c
        }
    }
    return conta;
    }

    //DEPOSITAR:
    public static void depositar(){
    int numConta=
            Integer.parseInt(JOptionPane.showInputDialog("NUMERO DA CONTA PARA DEPOSITO?"));

        Conta conta= encotrarConta(numConta); //VERIFICA SE A CONTA EXXISTE
        if(conta != null){
            Double valorDeposito=
                    Double.parseDouble(JOptionPane.showInputDialog("QUANTO DESEJA DEPOSITAR?"));

            conta.depositar(valorDeposito);
            JOptionPane.showMessageDialog(null,"VALOR DEPOSITADO COM SUCESSO!");
            //System.out.println("Valor Depositado com sucesso!!");
        }else{
            JOptionPane.showMessageDialog(null,"SUA CONTA NÃO FOI ENCONTRADA.");
            //System.out.println("Conta Não Encontrada.");
        }
        operacoes();//mostra menu de Usuarios
    }

    //SACAR
    public static void sacar(){
        int numConta=
                Integer.parseInt(JOptionPane.showInputDialog("NUMERO DA CONTA PARA SAQUE:"));
        //System.out.println("Numero da sua conta?");
        //int numConta= input.nextInt();

        Conta conta= encotrarConta(numConta);//encontrar a coonta
        if(conta != null) {
            Double valorSaque=
                    Double.parseDouble(JOptionPane.showInputDialog("QUANTO DESEJA SACAR?"));
            conta.sacar(valorSaque);

        }else{

            JOptionPane.showMessageDialog(null,"CONTA NÃO ENCONTRADA.");
            //System.out.println("Conta Não Encontrada.");;
        }
        operacoes();
        }

        //TRANSFERIR, precisa da conta q vai enviar e conta q vai receber.. 12:05
    public static void transferir(){
        int numContaRemetente=
                Integer.parseInt(JOptionPane.showInputDialog("CONTA DO REMETENTE?"));

        //System.out.println("Conta do remetente?");
        //int numContaRemetente= input.nextInt();

        Conta contaRemetente= encotrarConta(numContaRemetente);//Ver se a conta existe
        if(contaRemetente != null) { //se a conta existe
            int numContaDestinatario=
                    Integer.parseInt(JOptionPane.showInputDialog("CONTA DO DESTINATARIO?"));
            //System.out.println("Numero da conta do destinatario");
            //int numContaDestinatario = input.nextInt();

            Conta contaDestinatario = encotrarConta(numContaDestinatario);//mesmoJeito encontrar conta destinatario
            if (contaDestinatario != null) { //se existe contaDetino
                Double valor=
                        Double.parseDouble(JOptionPane.showInputDialog("QUANTO DESEJA TRANSFERIR?"));

                contaRemetente.tranferir(contaDestinatario, valor);
            } else {
                JOptionPane.showMessageDialog(null, "A CONTA PARA DEPOSITO NÃO FOI ENCONTRADA.");

            }
        }else{
            JOptionPane.showMessageDialog(null,"A CONTA PARA TRANFERENCIA NÃO FOI ENCONTRADA.");
        }
        operacoes();
    }

    //VER CONTA
    public static void listarContas(){
        if(contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias){
                System.out.println(conta);
        }
        }else{
            JOptionPane.showMessageDialog(null,"NÃO EXISTE CONTA CADASTRADA.");

        }
        operacoes();
    }
}






