import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReprodutorMusica implements iPhone{
    private List<String> historicoMusicas = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public void tocar(){
        System.out.println("Tocando música...");
    }

    public void pausar(){
        System.out.println("Música pausada");
    }

    public void selecionarMusica(String musica){
        historicoMusicas.add(musica);
        System.out.println("Música: " + musica);
        while (true) {
            System.out.println("1 - Tocar música");
            System.out.println("2 - Pausar música");
            System.out.println("3 - voltar ao menu do reprodutor de música");
            int escolha = in.nextInt();

            if (escolha == 3) {
                break;
            }

            switch (escolha) {
                case 1 -> tocar();

                case 2 -> pausar();

                default -> System.out.println("Opção inválida!");
            }
        }
    }

    @Override
    public void lista() {
        System.out.println("\nMúsicas tocadas recentemente:");
        int idMusica = 0;
        if (historicoMusicas.size() == 0) {
            System.out.println("Nenhuma música ouvida recentemente");
            return;
        }
        for (String musica : historicoMusicas) {
            System.out.printf("%d - %s\n", ++idMusica, musica);
        }
    }
}