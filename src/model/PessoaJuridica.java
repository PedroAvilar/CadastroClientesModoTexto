package model;

public class PessoaJuridica extends Pessoa {
    //Campo
    private String cnpj;
    
    //Construtor padrão
    public PessoaJuridica() {
        super();
    }
    
    //Construtor completo
    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }
    
    //Getter e setter
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    //Método exibir polimórfico
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CNPJ: " + cnpj);
    }
}
