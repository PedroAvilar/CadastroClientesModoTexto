package model;

public class Pessoa {
    //Campos
    private int id;
    private String nome;
    
    //Construtor padrão
    public Pessoa() {}
    
    //Construtor completo
    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    //Getters e setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    //Método exibir
    public void exibir() {
        System.out.println("Id: " + id);
        System.out.println("Nome: " + nome);
    }
}
