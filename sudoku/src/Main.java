import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
    }

    private static void menu() {  
        while (true) {
            System.out.println("====== Menu =======");
            System.out.println("1 - Iniciar jogo");
            System.out.println("2 - Inserir um número");
            System.out.println("3 - Remover um número");
            System.out.println("4 - Visualizar jogo atual");
            System.out.println("5 - Limpar jogo");
            System.out.println("6 - Sair");
            System.out.println("===================");
            System.out.print("Escolha uma das opções acima: ");
            int escolha;

            try (Scanner scanner = new Scanner(System.in)) {
                escolha = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            switch (escolha) {
                case 1 ->
                case 2 ->
                case 3 ->
                case 4 ->
                case 5 ->
                case 6 ->
            }
        }
    }
}
