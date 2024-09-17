package model;
import java.io.*;
import java.util.ArrayList;

public class PessoaFisicaRepo {
    //Lista de PessoaFisica
    private ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<>();
    
    //Método inserir
    public void inserir(PessoaFisica pessoa) {
        pessoasFisicas.add(pessoa);
    }
    
    //Método alterar
    public void alterar(PessoaFisica pessoa) {
        for (int i = 0; i < pessoasFisicas.size(); i++) {
            if (pessoasFisicas.get(i).getId() == pessoa.getId()) {
                pessoasFisicas.set(i, pessoa);
                return;
            }
        }
    }
    
    //Método excluir
    public void excluir(int id) {
        pessoasFisicas.removeIf(pessoa -> pessoa.getId() == id);
    }
    
    //Método obter
    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoa : pessoasFisicas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }
    
    //Método obter todas
    public ArrayList<PessoaFisica> obterTodos() {
        return new ArrayList<>(pessoasFisicas);
    }
    
    //Método persistir
    public void persistir(String arquivo) throws IOException {
        try (ObjectOutputStream arquivoSaida = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            arquivoSaida.writeObject(pessoasFisicas);
            System.out.println("Dados de Pessoa Fisica Armazenados.");
        }
    }
    
    //Método recuperar
    public void recuperar(String arquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream arquivoEntrada = new ObjectInputStream(new FileInputStream(arquivo))) {
            pessoasFisicas = (ArrayList<PessoaFisica>) arquivoEntrada.readObject();
            System.out.println("Dados de Pessoa Fisica Recuperados.");
        }
    }
}
