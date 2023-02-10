package Programa;

import Utilitarios.Utils;

import java.util.Objects;

public class Conta {
    private static int contadorDeContas=1;

    //Controle automatico, toda vez q a conta for criada sera atribuido um valor. 1,2...
      private int numConta;
      private Pessoa pessoa;
      private Double saldo=0.0;

    public Conta(Pessoa pessoa){
        this.numConta=contadorDeContas;
        this.pessoa=pessoa;
        contadorDeContas+=1;   //toda vez que a conta é criada acreccenta mais 1.
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
    public Double getSaldo() {
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
             "\nSaldo: "+ Utils.doubleToString(this.getSaldo()) + //pegou da classe utils
        "\n";
    }
}
