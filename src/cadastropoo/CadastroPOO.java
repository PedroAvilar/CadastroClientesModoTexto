package cadastropoo;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;
import java.util.Scanner;
import java.util.InputMismatchException;

public class CadastroPOO {

    private static Scanner scanner = new Scanner(System.in);
    
    //Método para tratamento de exceção de leitura de números
    private static int lerInt(String mensagem) {
        int valor = -1;
        while (valor == -1) {
            System.out.print(mensagem);
            try {
                valor = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Insira um numero inteiro.");
                scanner.nextLine();
            }
        }
        return valor;
    }
    
    public static void main(String[] args) {
        //Instâncias
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();
        
        //Laço que mantém o programa em execução
        while (true) {
            //Opções do programa
            int opcao = -1;
            while (opcao == -1) {
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
                opcao = lerInt("Digite o numero da opcao: ");
            }
            
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
                    if (tipoIncluir.equalsIgnoreCase("F")) { //Pessoa Física
                        System.out.println("Insira os dados da pessoa fisica.");
                        //Capturando e inserindo pessoa física
                        int id = lerInt("ID: ");
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        int idade = lerInt("Idade: ");
                        PessoaFisica pessoaFisica = new PessoaFisica(id, nome, cpf, idade);
                        repoFisica.inserir(pessoaFisica);
                        System.out.println("Pessoa fisica incluida com sucesso.");
                    } else if (tipoIncluir.equalsIgnoreCase("J")) { //Pessoa Jurídica
                        System.out.println("Insira os dados da pessoa juridica.");
                        //Capturando e inserindo pessoa jurídica
                        int id = lerInt("ID: ");
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
                    if (tipoAlterar.equalsIgnoreCase("F")) { //Pessoa Física
                        int id = lerInt("Digite o ID da pessoa fisica para alterar: ");
                        PessoaFisica pessoaAtual = repoFisica.obter(id);
                        //Exibe os dados atuais e exige os novos
                        if (pessoaAtual != null) {
                            System.out.println("Dados atuais: ");
                            pessoaAtual.exibir();
                            System.out.println("Insira os novos dados.");
                            System.out.print("Novo nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("Novo CPF: ");
                            String cpf = scanner.nextLine();
                            int idade = lerInt("Nova idade: ");
                            PessoaFisica pessoaNova = new PessoaFisica(id, nome, cpf, idade);
                            repoFisica.alterar(pessoaNova);
                            System.out.println("Pessoa fisica alterada com sucesso.");
                        } else {
                            System.out.println("Nao foi encontrada uma pessoa fisica com o ID " + id);
                        }
                    } else if (tipoAlterar.equalsIgnoreCase("J")) { //Pessoa Jurídica
                        int id = lerInt("Digite o ID da pessoa juridica para alterar: ");
                        PessoaJuridica empresaAtual = repoJuridica.obter(id);
                        //Exibe os dados atuais e exige os novos
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
                    if (tipoExcluir.equalsIgnoreCase("F")) { //Pessoa Fisica
                        //Excluindo pessoa física pelo ID
                        int id = lerInt("Digite o ID da pessoa fisica para excluir: ");
                        repoFisica.excluir(id);
                        System.out.println("Pessoa fisica excluida com sucesso.");
                    } else if (tipoExcluir.equalsIgnoreCase("J")) { //Pessoa Juridica
                        //Excluindo pessoa jurídica pelo ID
                        int id = lerInt("Digite o ID da pessoa juridica para excluir: ");
                        repoJuridica.excluir(id);
                        System.out.println("Pessoa juridica excluida com sucesso.");
                    } else {
                        System.out.println("Opcao invalida.");
                    }
                    break;
                    
                //Buscar pelo ID
                case 4:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipoBuscar = scanner.nextLine();
                    if (tipoBuscar.equalsIgnoreCase("F")) { //Pessoa Física
                        //Exibindo pessoa física pelo ID
                        int id = lerInt("Digite o ID da pessoa fisica para exibir: ");
                        PessoaFisica pessoa = repoFisica.obter(id);
                        if (pessoa != null) {
                            pessoa.exibir();
                        } else {
                            System.out.println("Nao foi encontrada uma pessoa fisica com o ID " + id);
                        }
                    } else if (tipoBuscar.equalsIgnoreCase("J")) { //Pessoa Jurídica
                        //Exibindo pessoa jurídica pelo ID
                        int id = lerInt("Digite o ID da pessoa juridica para exibir: ");
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
                    if (tipoExibirTodos.equalsIgnoreCase("F")) { //Pessoas Físicas
                        repoFisica.obterTodos().forEach(PessoaFisica::exibir);
                    } else if (tipoExibirTodos.equalsIgnoreCase("J")) { //Pessoas Jurídicas
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
