package cadastropoo;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class CadastroPOO {

    public static void main(String[] args) {
        //Instancia de pessoas físicas - repo1
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        
        //Pessoas físicas com construtor completo
        PessoaFisica pessoaFisica1 = new PessoaFisica(1, "Ana", "11111111111", 25);
        PessoaFisica pessoaFisica2 = new PessoaFisica(2, "Carlos", "22222222222", 52);
        repo1.inserir(pessoaFisica1);
        repo1.inserir(pessoaFisica2);
        
        //Persistência em repo1
        try {
            repo1.persistir("ListaPessoasFísicas.dat");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Instancia de pesssoas físicas - repo2
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        
        //Recuperação e exibição de pessoas físicas em repo2
        try {
            repo2.recuperar("ListaPessoasFísicas.dat");
            repo2.obterTodos().forEach(pessoaFisica -> {
                pessoaFisica.exibir();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Instancia de pessoas jurídicas - repo3
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        
        //Pessoas jurídicas com construtor completo
        PessoaJuridica pessoaJuridica1 = new PessoaJuridica(3, "XPTO Sales", "33333333333333");
        PessoaJuridica pessoaJuridica2 = new PessoaJuridica(4, "XPTO Solutions", "44444444444444");
        repo3.inserir(pessoaJuridica1);
        repo3.inserir(pessoaJuridica2);
        
        //Persistência em repo 3
        try {
            repo3.persistir("ListaPessoasJurídicas.dat");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Intancia de pessoasjurídicas - repo4
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        
        //Recuperação e exibição de pessoas jurídicas em repo4
        try {
            repo4.recuperar("ListaPessoasJurídicas.dat");
            repo4.obterTodos().forEach(pessoaJuridica -> {
                pessoaJuridica.exibir();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
