package Programa;

import Utilitarios.Utils;
import javax.swing.*;

public class Conta {
    private static int contadorDeContas=1;

    //Controle automatico, toda vez q a conta for criada sera atribuido um valor. 1,2...
      private int numConta;
      private Pessoa pessoa;
      private Double saldo=0.0;

    public Conta(Pessoa pessoa){
        this.numConta=contadorDeContas;
        this.pessoa=pessoa;
        contadorDeContas+=1;   //toda vez que a conta é criada acreccenta mais 1 aqui.
    }
    public int getNumConta() {
        return numConta;
    }
    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }
    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public String toString(){ //pegar atributos da classe (Pessoa)

        return "\nNumero da conta:"+ this.getNumConta() +
            "\nNome: "+ this.pessoa.getNome() +
            "\nCpf: "+ this.pessoa.getCpf() +
            "\nEmail: "+ this.pessoa.getEmail() +
             "\nSaldo: "+ Utils.doubleToString(this.getSaldo()) + //pegou da classe utils...
        "\n";
    }
    //Depositar
    public void depositar(Double valor){
        if(valor > 0){
            setSaldo(getSaldo() + valor);//Mostra saldo+valor em conta
            JOptionPane.showMessageDialog(null,"SEU DEPOSITO FOI FEITO!");
            //System.out.println("Deposito realizado!");
        }else{
           JOptionPane.showMessageDialog(null,"NÃO FOI POSSIVEL DEPOSITAR");
            //System.out.println("Deeposito nao foi possivel!");
        }
    }
    //Sacar
    public void sacar(Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor); //PegaSaldoQue tem em conta - Valor a sacar
            JOptionPane.showMessageDialog(null,"SAQUE FEITO!");
            //System.out.println("SAque Realizado!");
        }else{
            JOptionPane.showMessageDialog(null,"NÃO FOI POSSIVEL REALIZAR O SAQUE.");
            //System.out.println("Saque não relizado!");
        }
    }
    //transferir
    public void tranferir(Conta contaParaDepositar, Double valor){
        if(valor >0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);

            contaParaDepositar.saldo = contaParaDepositar.getSaldo()+valor;  //contaParaDepositar vai pegar o valor da conta dela e somarAoValor que eu Transferi
            JOptionPane.showMessageDialog(null,"SUA TRANSFERENCIA FOI REALIZADA");
            //System.out.println("Transferencia feita.!");
        }else{
            JOptionPane.showMessageDialog(null,"NÃO É POSSIVEL TRANSFERIR");
           // System.out.println("Transferencia não concluida!");
        }
        }
    }




