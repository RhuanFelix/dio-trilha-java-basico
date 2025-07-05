import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Banco> bancosContaCorrente = new ArrayList<>();
    private static List<Banco> bancosContaPoupanca = new ArrayList<>();
    private static List<Banco> bancos = new ArrayList<>();
    private static String tipoConta = "corrente";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu();
            System.out.println("Escolha uma das opções:");
            int escolha = scanner.nextInt(); scanner.nextLine();

            if (escolha == 0) {
                scanner.close();
                break;
            } else {
                switch (escolha) {
                    case 1 -> {
                        System.out.println("Informe o nome do banco:");
                        String nomeBanco = scanner.nextLine();
                        System.out.println("Informe seu nome:");
                        String nomeCliente = scanner.nextLine();
                        Banco contaCriada = adicionarContaCorrente(nomeBanco, nomeCliente);
                        bancosContaCorrente.add(contaCriada);
                        bancos.add(contaCriada);
                    }

                    case 2 -> {
                        System.out.println("Informe o nome do banco:");
                        String nomeBanco = scanner.nextLine();
                        System.out.println("Informe seu nome:");
                        String nomeCliente = scanner.nextLine();
                        Banco contaCriada = adicionarContaPoupanca(nomeBanco, nomeCliente);
                        bancosContaPoupanca.add(contaCriada);
                        bancos.add(contaCriada);
                    }

                    case 3 -> {
                        System.out.println("Digite seu nome:");
                        String nome = scanner.nextLine();
                        System.out.println("Digite o número da sua conta corrente:");
                        int numConta = scanner.nextInt(); scanner.nextLine();
                        System.out.println("Digite o valor para depositar:");
                        double valor = scanner.nextDouble();
                        depositarDinheiro(nome, numConta, valor, tipoConta);
                    }

                    case 4 -> {
                        System.out.println("Digite seu nome:");
                        String nome = scanner.nextLine();
                        System.out.println("Digite o número da sua conta:");
                        int numConta = scanner.nextInt(); scanner.nextLine();
                        System.out.println("Digite o valor para sacar:");
                        double valor = scanner.nextDouble();
                        sacarDinheiro(nome, numConta, valor);
                    }

                    case 5 -> {
                        System.out.println("Digite seu nome:");
                        String nome = scanner.nextLine();
                        System.out.println("Digite o número da sua conta:");
                        int numConta = scanner.nextInt(); scanner.nextLine();

                        System.out.println("Você quer transferir dinheiro para uma conta (corrente ou poupança)?");
                        tipoConta = scanner.nextLine();

                        if (tipoConta.equalsIgnoreCase("corrente")) {
                            listarContas(tipoConta);
                        } else {
                            listarContas(tipoConta);
                        }

                        System.out.println("Digite o nome do titular da conta:");
                        String nomeDestino = scanner.nextLine();
                        System.out.println("Digite o número da conta do titular:");
                        int numContaDestino = scanner.nextInt(); scanner.nextLine();
                        System.out.println("Digite o valor para transferir:");
                        double valorParaTransferir = scanner.nextDouble();

                        transferirDinheiro(nome, numConta, nomeDestino, numContaDestino, valorParaTransferir);
                    }

                    case 6 -> {
                        listarContas("corrente");
                        listarContas("poupanca");
                    }

                    case 7 -> {
                        System.out.println("Preencha as informações abaixo para exibir seu extrato da conta Corrente\n");
                        System.out.println("Digite seu nome:");
                        String nome = scanner.nextLine();
                        System.out.println("Digite o número da sua conta:");
                        int numConta = scanner.nextInt(); scanner.nextLine();
                        exibirExtrato(nome, numConta, "corrente");
                    }

                    case 8 -> {
                        System.out.println("Preencha as informações abaixo para exibir seu extrato da conta Poupança\n");
                        System.out.println("Digite seu nome:");
                        String nome = scanner.nextLine();
                        System.out.println("Digite o número da sua conta:");
                        int numConta = scanner.nextInt(); scanner.nextLine();
                        exibirExtrato(nome, numConta, "poupanca");
                    }

                    default -> System.out.println("Opção inválida!");
                }
            }
        }
        System.exit(0);
    }

    private static void menu() {
        System.out.println("===== Menu =====");
        System.out.println("0 - Sair do programa");
        System.out.println("1 - Adicionar conta corrente");
        System.out.println("2 - Adicionar conta poupança");
        System.out.println("3 - Depositar dinheiro");
        System.out.println("4 - sacar dinheiro");
        System.out.println("5 - Transferir dinheiro");
        System.out.println("6 - Listar todas as contas");
        System.out.println("7 - Ver o extrato da conta corrente");
        System.out.println("8 - Ver o extrato da conta poupança");
        System.out.println("================");
    }

    private static Banco adicionarContaCorrente(String nomeBanco, String nomeCliente) {
        return new Banco(nomeBanco, new ContaCorrente(new Cliente(nomeCliente)));
    }

    private static Banco adicionarContaPoupanca(String nomeBanco, String nomeCliente) {
        return new Banco(nomeBanco, new ContaPoupanca(new Cliente(nomeCliente)));
    }

    private static void depositarDinheiro(String nomeCliente, int numeroConta, double valor, String tipoConta) {
        boolean contaEncontrada = false;
        if (tipoConta.equalsIgnoreCase("corrente")) {
            for (Banco banco : bancosContaCorrente) {
                if (nomeCliente.equals(banco.getConta().getCliente().getNome()) && numeroConta == banco.getConta().getNumero()) {
                    banco.getConta().depositar(valor);
                    contaEncontrada = true;
                    break;
                } else {
                    contaEncontrada = false;
                }
            }
        } else {
            for (Banco banco : bancosContaPoupanca) {
                if (nomeCliente.equals(banco.getConta().getCliente().getNome()) && numeroConta == banco.getConta().getNumero()) {
                    banco.getConta().depositar(valor);
                    contaEncontrada = true;
                    break;
                } else {
                    contaEncontrada = false;
                }
            }
        }

        if (!contaEncontrada) {
            System.out.println("Conta não encontrada!");
        }
    }

    private static void sacarDinheiro(String nomeCliente, int numeroConta, double valor){
        boolean contaEncontrada = false;
        for (Banco banco : bancos) {
            if (nomeCliente.equals(banco.getConta().getCliente().getNome()) && numeroConta == banco.getConta().getNumero()) {
                contaEncontrada = true;
                if (banco.getConta().getSaldo() == 0 || banco.getConta().getSaldo() < valor) {
                    System.out.println("Saldo insuficiente!");
                    break;
                } else {
                    banco.getConta().sacar(valor);
                    break;
                }
                
            } else {
                contaEncontrada = false;
            }
        }

        if (!contaEncontrada) {
            System.out.println("Conta não encontrada");
        }
    }

    private static void transferirDinheiro(String nomeCliente, int numeroConta, String nomeClienteDestino, int numeroContaDestino, double valor) {
        sacarDinheiro(nomeCliente, numeroConta, valor);
        depositarDinheiro(nomeClienteDestino, numeroContaDestino, valor, tipoConta);
    }

    private static void listarContas(String tipoConta) {
        int contador = 0;
        if (tipoConta.equalsIgnoreCase("corrente")) {
            System.out.println("Contas correntes:");
            if (!bancosContaCorrente.isEmpty()) {
                for (Banco banco : bancosContaCorrente) {
                    System.out.println(String.format("===== Conta %d =====", ++contador));
                    banco.getConta().imprimirInfosComuns();
                    System.out.println("====================");
                }
            } else {
                System.out.println("Não há registro de conta corrente!");
            }
        } else {
            contador = 0;
            System.out.println("\nContas poupanças:");
            if (!bancosContaPoupanca.isEmpty()) {
                for (Banco banco : bancosContaPoupanca) {
                    System.out.println(String.format("===== Conta %d =====", ++contador));
                    banco.getConta().imprimirInfosComuns();
                    System.out.println("====================");
                }
            } else {
                System.out.println("Não há registro de conta poupança!");
            }
        }
    }

    private static void exibirExtrato(String nomeCliente, int numeroConta, String tipoConta) {
        boolean contaEncontrada = false;
        if (tipoConta.equalsIgnoreCase("corrente")) {
            if (!bancosContaCorrente.isEmpty()) {
                for (Banco banco : bancosContaCorrente) {
                    if (nomeCliente.equals(banco.getConta().getCliente().getNome()) && numeroConta == banco.getConta().getNumero()) {
                        banco.getConta().imprimirExtrato();
                        contaEncontrada = true;
                        break;
                    } else {
                        contaEncontrada = false;
                    }
                }
            } else {
                System.out.println("Não há registro de conta corrente!");
            }
        } else {
            if (!bancosContaPoupanca.isEmpty()) {
                for (Banco banco : bancosContaPoupanca) {
                    if (nomeCliente.equals(banco.getConta().getCliente().getNome()) && numeroConta == banco.getConta().getNumero()) {
                        banco.getConta().imprimirExtrato();
                        contaEncontrada = true;
                        break;
                    } else {
                        contaEncontrada = false;
                    }
                }
            } else {
                System.out.println("Não há registro de conta poupança!");
            }
        }

        if (!contaEncontrada) {
            System.out.println("Não existe esta conta!");
        }
    }
}