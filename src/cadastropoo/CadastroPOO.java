package cadastropoo;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;
import java.util.Scanner;

public class CadastroPOO {

    public static void main(String[] args) {
        //Instâncias
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();
        Scanner scanner = new Scanner(System.in);
        
        //Laço que mantém o programa em execução
        while (true) {
            //Opções do programa
            System.out.println("========================================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Exibir pelo ID");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Salvar Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("========================================");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            //Finalizar o programa
            if (opcao == 0) {
                System.out.println("Programa finalizado.");
                break;
            }
            
            switch (opcao) {
                //Incluir
                case 1:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipoIncluir = scanner.nextLine();
                    if (tipoIncluir.equals("F")) { //Pessoa Fisica
                        System.out.println("Insira os dados da pessoa fisica.");
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine();
                        PessoaFisica pessoaFisica = new PessoaFisica(id, nome, cpf, idade);
                        repoFisica.inserir(pessoaFisica);
                        System.out.println("Pessoa fisica incluida com sucesso.");
                    } else if (tipoIncluir.equals("J")) { //Pessoa Juridica
                        System.out.println("Insira os dados da pessoa juridica.");
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CNPJ: ");
                        String cnpj = scanner.nextLine();
                        PessoaJuridica pessoaJuridica = new PessoaJuridica(id, nome, cnpj);
                        repoJuridica.inserir(pessoaJuridica);
                        System.out.println("Pessoa juridica incluida com sucesso.");
                    } else {
                        System.out.println("Opcao invalida.");
                    }
                    break;
                    
                // Alterar
                case 2:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipoAlterar = scanner.nextLine();
                    if (tipoAlterar.equals("F")) { //Pessoa Fisica
                        System.out.println("Digite o ID da pessoa fisica para alterar: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        PessoaFisica pessoaAtual = repoFisica.obter(id);
                        if (pessoaAtual != null) {
                            System.out.println("Dados atuais: ");
                            pessoaAtual.exibir();
                            System.out.println("Insira os novos dados.");
                            System.out.print("Novo nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("Novo CPF: ");
                            String cpf = scanner.nextLine();
                            System.out.print("Nova idade: ");
                            int idade = scanner.nextInt();
                            scanner.nextLine();
                            PessoaFisica pessoaNova = new PessoaFisica(id, nome, cpf, idade);
                            repoFisica.alterar(pessoaNova);
                            System.out.println("Pessoa fisica alterada com sucesso.");
                        } else {
                            System.out.println("Nao foi encontrada uma pessoa fisica com o ID " + id);
                        }
                    } else if (tipoAlterar.equals("J")) { //Pessoa Juridica
                        System.out.println("Digite o ID da pessoa juridica para alterar: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        PessoaJuridica empresaAtual = repoJuridica.obter(id);
                        if (empresaAtual != null) {
                            System.out.println("Dados atuais: ");
                            empresaAtual.exibir();
                            System.out.println("Insira os novos dados.");
                            System.out.print("Novo nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("Novo CNPJ: ");
                            String cnpj = scanner.nextLine();
                            PessoaJuridica empresaNova = new PessoaJuridica(id, nome, cnpj);
                            repoJuridica.alterar(empresaNova);
                            System.out.println("Pessoa juridica alterada com sucesso.");
                        } else {
                            System.out.println("Nao foi encontrada uma pessoa juridica com o ID " + id);
                        }
                    } else {
                        System.out.println("Opcao invalida.");
                    }
                    break;
                    
                //Excluir
                case 3:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipoExcluir = scanner.nextLine();
                    if (tipoExcluir.equals("F")) { //Pessoa Fisica
                        System.out.print("Digite o ID da pessoa fisica para excluir: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        repoFisica.excluir(id);
                        System.out.println("Pessoa fisica excluida com sucesso.");
                    } else if (tipoExcluir.equals("J")) { //Pessoa Juridica
                        System.out.print("Digite o ID da pessoa juridica para excluir: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        repoJuridica.excluir(id);
                        System.out.println("Pessoa juridica excluída com sucesso.");
                    } else {
                        System.out.println("Opcao invalida.");
                    }
                    break;
                    
                //Buscar pelo ID
                case 4:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipoBuscar = scanner.nextLine();
                    if (tipoBuscar.equals("F")) { //Pessoa Fisica
                        System.out.print("Digite o ID da pessoa fisica para exibir: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        PessoaFisica pessoa = repoFisica.obter(id);
                        if (pessoa != null) {
                            pessoa.exibir();
                        } else {
                            System.out.println("Nao foi encontrada uma pessoa fisica com o ID " + id);
                        }
                    } else if (tipoBuscar.equals("J")) { //Pessoa Juridica
                        System.out.print("Digite o ID da pessoa juridica para exibir: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        PessoaJuridica empresa = repoJuridica.obter(id);
                        if (empresa != null) {
                            empresa.exibir();
                        } else {
                            System.out.println("Nao foi encontrada uma pessoa juridica com o ID " + id);
                        }
                    } else {
                        System.out.println("Opcao invalida.");
                    }
                    break;
                    
                //Exibir todos
                case 5:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipoExibirTodos = scanner.nextLine();
                    if (tipoExibirTodos.equals("F")) { //Pessoas Fisicas
                        repoFisica.obterTodos().forEach(PessoaFisica::exibir);
                    } else if (tipoExibirTodos.equals("J")) { //Pessoas Juridicas
                        repoJuridica.obterTodos().forEach(PessoaJuridica::exibir);
                    } else {
                        System.out.println("Opcao invalida.");
                    }
                    break;
                    
                //Salvar dados
                case 6:
                    System.out.print("Digite o prefixo dos arquivos para salvar: ");
                    String prefixoSalvar = scanner.nextLine();
                    try {
                        repoFisica.persistir(prefixoSalvar + ".fisica.bin");
                        repoJuridica.persistir(prefixoSalvar + ".juridica.bin");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Erro ao salvar os dados: " + e.getMessage());
                    }
                    break;
                    
                //Recuperar dados
                case 7:
                    System.out.print("Digite o prefixo dos arquivos para recuperar: ");
                    String prefixoRecuperar = scanner.nextLine();
                    try {
                        repoFisica.recuperar(prefixoRecuperar + ".fisica.bin");
                        repoJuridica.recuperar(prefixoRecuperar + ".juridica.bin");
                        System.out.println("Dados recuperados com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Erro ao recuperar os dados: " + e.getMessage());
                    }
                    break;
                    
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
