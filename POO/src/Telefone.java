import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Telefone implements iPhone{

    private Scanner in = new Scanner(System.in);
    private Random random = new Random();
    private List<String> historicoTelefonico = new ArrayList<>();

    public void ligar(String numero){
        int ligacaoAtendida = random.nextInt(2);
        historicoTelefonico.add(numero);
        if (ligacaoAtendida == 0) {
            System.out.println("A ligação não foi atendida, deseja iniciar um correio de voz (s/n)?");
            while (true) {
                String escolha = in.nextLine();
                if (escolha.equalsIgnoreCase("s")) {
                    System.out.println("Fale a mensagem que você quer dizer:");
                    String mensagem = in.nextLine();
                    iniciarCorreioVoz(mensagem);
                    break;
                } else if (escolha.equalsIgnoreCase("n")) {
                    System.out.println("Ligação encerrada");
                    break;
                } else {
                    System.out.println("Digite uma opção válida (s/n)!");
                }
            }
        } else {
            System.out.println("Ligação atendida, converse à vontade...");
        }
    }

    public void atender(){
        // gera um número aleatório para simular uma ligação para ir para o histórico:
        int ddd = random.nextInt(89) + 11;
        int prefixo = 90000 + random.nextInt(10000);
        int sufixo = 1000 + random.nextInt(9000);
        String numero = String.format("(%02d) %d-%04d", ddd, prefixo, sufixo);
        historicoTelefonico.add(numero);

        System.out.printf("Você atendeu uma ligação do número: %s, converse à vontade...", numero);
    }

    public void iniciarCorreioVoz(String mensagem){
        System.out.println("Você enviou a seguinte mensagem: " + mensagem);
    }

    @Override
    public void lista() {
        System.out.println("\nHistórico de ligações:");
        if (historicoTelefonico.size() == 0) {
            System.out.println("Nenhuma ligação foi feita recentemente");
            return;
        }
        for (String numero : historicoTelefonico) {
            System.out.println(numero);
        }
    }
}