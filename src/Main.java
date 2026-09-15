import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("       DETECTOR DE GOLPES DIGITAIS");
        System.out.println("======================================");

        System.out.println("\nDigite a mensagem que deseja analisar:");
        String mensagem = scanner.nextLine();

        // Verifica se o usuário digitou alguma coisa
        if (mensagem.trim().isEmpty()) {
            System.out.println("Nenhuma mensagem foi digitada.");
            scanner.close();
            return;
        }

        // Converte tudo para letras minúsculas
        String texto = mensagem.toLowerCase();

        int sinaisDeRisco = 0;

        System.out.println("\n----------- ANÁLISE -----------");

        // Verifica urgência
        if (temUrgencia(texto)) {
            sinaisDeRisco++;
            System.out.println("✓ Sinal encontrado: mensagem urgente");
        }

        // Verifica senha ou código
        if (pedeSenhaOuCodigo(texto)) {
            sinaisDeRisco++;
            System.out.println("✓ Sinal encontrado: pedido de senha/código");
        }

        // Verifica pedido de dinheiro
        if (pedeDinheiro(texto)) {
            sinaisDeRisco++;
            System.out.println("✓ Sinal encontrado: pedido de dinheiro/Pix");
        }

        // Verifica links
        if (temLink(texto)) {
            sinaisDeRisco++;
            System.out.println("✓ Sinal encontrado: link");
        }

        System.out.println("\n----------- RESULTADO -----------");

        System.out.println("Sinais de risco encontrados: " + sinaisDeRisco);

        if (sinaisDeRisco == 0) {

            System.out.println("Nível de risco: BAIXO");
            System.out.println("Não foram encontrados sinais de risco.");

        } else if (sinaisDeRisco == 1) {

            System.out.println("Nível de risco: ALTO");
            System.out.println("Foi encontrado apenas um sinal de risco.");

        } else if (sinaisDeRisco == 2) {

            System.out.println("Nível de risco: MÉDIO");
            System.out.println("A mensagem possui sinais suspeitos.");

        } else {

            System.out.println("Nível de risco: ALTO");
            System.out.println("ALERTA: possível golpe digital!");
            System.out.println("Não clique em links.");
            System.out.println("Não informe senhas ou códigos.");
            System.out.println("Não realize pagamentos.");
        }
        System.out.println();
        System.out.println("======================================");
        System.out.println("AVISO:");
        System.out.println("Esta analise e baseada em padroes de texto.");
        System.out.println("Nenhuma mensagem pode ser considerada 100% segura.");
        System.out.println("Mesmo com risco baixo, tenha cuidado e");
        System.out.println("não compartilhe dados pessoais ou senhas.");
        System.out.println("======================================");

        scanner.close();
    }

    // Verifica palavras relacionadas à urgência
    public static boolean temUrgencia(String texto) {

        return texto.contains("urgente")
                || texto.contains("agora")
                || texto.contains("imediatamente")
                || texto.contains("última chance")
                || texto.contains("ultima chance");
    }

    // Verifica pedido de senha ou código
    public static boolean pedeSenhaOuCodigo(String texto) {

        return texto.contains("senha")
                || texto.contains("código")
                || texto.contains("codigo")
                || texto.contains("token")
                || texto.contains("código de segurança")
                || texto.contains("codigo de seguranca");
    }

    // Verifica pedido de dinheiro
    public static boolean pedeDinheiro(String texto) {

        return texto.contains("pix")
                || texto.contains("pagamento")
                || texto.contains("transferência")
                || texto.contains("transferencia")
                || texto.contains("dinheiro");
    }

    // Verifica existência de links
    public static boolean temLink(String texto) {

        return texto.contains("http://")
                || texto.contains("https://")
                || texto.contains("www.");
    }
}