import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o número da Agência do Banco:");
        String Agencia = in.nextLine();

        System.out.println("Infome o número da conta:");
        int numero = in.nextInt(); in.nextLine();

        System.out.println("Informe seu nome:");
        String nomeCliente = in.nextLine();

        System.out.println("Informe seu saldo:");
        double saldo = in.nextDouble(); in.nextLine();

        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque", nomeCliente, Agencia, numero, saldo);
        in.close();
    }
}