import java.util.List;

import classes.Competicao;
import classes.Competidor;
import classes.Lance;

public class App {
    public static void main(String[] args) throws Exception {
        // Cadastrar competição
        Competicao competicao = new Competicao("Competição 1", "01/01/2022");

        // Cadastrar competidores
        Competidor competidor1 = new Competidor("Competidor 1");
        Competidor competidor2 = new Competidor("Competidor 2");
        Competidor competidor3 = new Competidor("Competidor 3");

        // Cadastrar lances dos competidores
        competidor1.cadastrarLance(new Lance(100.0, "12", "30", competicao));
        competidor2.cadastrarLance(new Lance(150.0, "12", "44", competicao));
        competidor3.cadastrarLance(new Lance(120.0, "12", "41", competicao));

        // Adicionar competidores à competição
        competicao.adicionarCompetidor(competidor1);
        competicao.adicionarCompetidor(competidor2);
        competicao.adicionarCompetidor(competidor3);

        // Definir resultado da competição
        competicao.definirResultado("12", "40");

        // Premiar vencedores
        boolean premiado = competicao.premiarVencedores();
        if (premiado) {
            System.out.println("Vencedores premiados com sucesso! Os premiados " + listaDePremiados(competicao) + " receberam o premio no valor de: R$" + competicao.premioIndividual());
        } else {
            System.out.println("Nenhum vencedor encontrado para premiação, Eliza ficou com o prêmio total de: R$" + competicao.totalApostas());
        }
    }

    static String listaDePremiados(Competicao competicao) {
        StringBuilder vencedoresBuilder = new StringBuilder("(");
        List<Competidor> vencedores = competicao.verificarVencedores();
        for (int i = 0; i < vencedores.size(); i++) {
            vencedoresBuilder.append(vencedores.get(i).getNome());
            if (i < vencedores.size() - 1) {
                vencedoresBuilder.append(", ");
            }
        }
        vencedoresBuilder.append(")");

        return vencedoresBuilder.toString();
    }
}
