package Programa;

public class Pessoa {
    private static int counter=1; //contador, conta o num de clientes.

    private String nome;
    private String cpf;
    private String email;

    public Pessoa() { //FOI CONSTRUIDO PARA A CLASSE BANCO//
    }

    public Pessoa(String nome, String cpf, String email){//contrutor
        this.nome=nome;
        this.cpf=cpf;
        this.email=email;
        counter =+1; //para cada vez que uma nova pessoa for cria recebe 1...
    }
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
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
    //apresentar os dados

    @Override
    public String toString() {
        return "\nNome:" + this.getNome() +
                "\nCPF: "+ this.getCpf() +
                "\nEmail: "+ this.getEmail();
    }
}
