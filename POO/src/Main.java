import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);
    private static ReprodutorMusica iPod = new ReprodutorMusica();
    private static Telefone telefone = new Telefone();
    private static NavegadorWeb safari = new NavegadorWeb();

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("\nBem vindo ao menu inicial do iPhone! Escolha uma das opções para usar:");
            menu();
            int escolha = in.nextInt();
            switch (escolha) {
                case 1 -> menuReprodutorMusica();
                case 2 -> menuTelefone();
                case 3 -> menuNavegadorWeb();
                case 4 -> System.exit(0);
            }
        }
    }


    public static void menu(){
        System.out.println("1 - Reprodutor de música");
        System.out.println("2 - Telefone");
        System.out.println("3 - Navegador Web");
        System.out.println("4 - Desligar iPhone");
    }

    public static void menuReprodutorMusica(){
        while (true) {
            System.out.println("\nEste é o menu do reprodutor de música do iPhone, use uma das opções:");
            System.out.println("1 - Selecionar música");
            System.out.println("2 - Histórico de músicas");
            System.out.println("3 - Voltar ao menu inicial");
            int escolha = in.nextInt(); in.nextLine();

            if (escolha == 3) {
                break;
            }

            switch (escolha) {
                case 1 -> {
                    System.out.println("Digite o nome da música:");
                    String musica = in.nextLine();
                    iPod.selecionarMusica(musica);
                }

                case 2 -> iPod.lista();

                default -> System.out.println("Opção Inválida!");
            }
        }
    }

    public static void menuTelefone(){
        while (true) {
            System.out.println("\nEste é o meu de telefone do iPhone, use uma das opções:");
            System.out.println("1 - Ligar");
            System.out.println("2 - Atender");
            System.out.println("3 - Iniciar Correio de Voz");
            System.out.println("4 - Mostrar histórico de ligações");
            System.out.println("5 - Voltar ao menu inicial");
            int escolha = in.nextInt(); in.nextLine();

            if (escolha == 5) {
                break;
            }

            switch (escolha) {
                case 1 -> {
                    System.out.println("Digite o número no seguinte formato para fazer a ligação (xx) xxxxx-xxxx:");
                    String numero = in.nextLine();
                    telefone.ligar(numero);
                }

                case 2 -> telefone.atender();

                case 3 -> {
                    System.out.println("Fale a mensagem que você quer dizer:");
                    String mensagem = in.nextLine();
                    telefone.iniciarCorreioVoz(mensagem);
                }

                case 4 -> telefone.lista();

                default -> System.out.println("Opção inválida");
            }
        }
    }

    public static void menuNavegadorWeb(){
        System.out.println("Este é o menu do navegador, use uma das opções:");
        System.out.println("1 - Exibir página");
        System.out.println("2 - Histórico do navegador");
        int escolha = in.nextInt(); in.nextLine();
        
        if (escolha == 1) {
            System.out.println("Digite a url da paágina que você quer exibir");
            String url = in.nextLine();
            safari.exibirPagina(url);
        } else if (escolha == 2) {
            safari.lista();
        } else {
            System.out.println("Opção inválida!");
        }
    }
}