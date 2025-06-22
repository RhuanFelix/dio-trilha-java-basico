import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NavegadorWeb implements iPhone{

    private List<String> historicoNavegador = new ArrayList<>();
    private Scanner in = new Scanner(System.in);
    private int aba = 0;

    public void exibirPagina(String url){
        System.out.println("Uma aba foi criada para exibir a página!");
        adicionarNovaAba();
        while (true) {
            System.out.println("A página está sendo exibida!");
            System.out.println("1 - Atualizar página");
            System.out.println("2 - Voltar ao menu do Navegador");
            int escolha = in.nextInt();

            if (escolha == 1) {
                atualizarPagina();
            } else if (escolha == 2){
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
        
        historicoNavegador.add(url);

    }

    public void adicionarNovaAba(){
        ++aba;
    }

    public void atualizarPagina(){
        System.out.println("Recarregando página...");
    }

    @Override
    public void lista() {
        System.out.println("\nHistórico do navegador:");
        int idUrl = 0;
        if (historicoNavegador.size() == 0) {
            System.out.println("O histórico do navegador está vazio!");
            return;
        }
        for (String pagina : historicoNavegador) {
            System.out.printf("%d - %s\n", idUrl, pagina);
        }
    }
    
}