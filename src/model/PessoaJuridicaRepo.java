package model;
import java.io.*;
import java.util.ArrayList;

public class PessoaJuridicaRepo {
    //Lista de PessoaJuridica
    private ArrayList<PessoaJuridica> pessoasJuridicas = new ArrayList<>();
    
    //Método inserir
    public void inserir(PessoaJuridica pessoa) {
        pessoasJuridicas.add(pessoa);
    }
    
    //Método alterar
    public void alterar(PessoaJuridica pessoa) {
        for (int i = 0; i < pessoasJuridicas.size(); i++) {
            if (pessoasJuridicas.get(i).getId() == pessoa.getId()) {
                pessoasJuridicas.set(i, pessoa);
                return;
            }
        }
    }
    
    //Método excluir
    public void excluir(int id) {
        pessoasJuridicas.removeIf(pessoa -> pessoa.getId() == id);
    }
    
    //Método obter
    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pessoa : pessoasJuridicas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }
    
    //Método obterTodos
    public ArrayList<PessoaJuridica> obterTodos() {
        return new ArrayList<>(pessoasJuridicas);
    }
    
    //Método persistir
    public void persistir(String arquivo) throws IOException {
        try (ObjectOutputStream arquivoSaida = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            arquivoSaida.writeObject(pessoasJuridicas);
            System.out.println("Dados de Pessoa Juridica Armazenados.");
        }
    }
    
    //Método recuperar
    public void recuperar(String arquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream arquivoEntrada = new ObjectInputStream(new FileInputStream(arquivo))) {
            pessoasJuridicas = (ArrayList<PessoaJuridica>) arquivoEntrada.readObject();
            System.out.println("Dados de Pessoa Juridica Recuperados.");
        }
    }
}
