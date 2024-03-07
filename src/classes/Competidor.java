package classes;

import java.util.ArrayList;
import java.util.List;

public class Competidor {
    private String _nome;
    private List<Lance> _lances;

    public String getNome() {
        return _nome;
    }

    public void setNome(String nome) {
        this._nome = nome;
    }

    public List<Lance> getLances() {
        return _lances;
    }

    public Competidor(String nome) {
        _nome = nome;
        _lances = new ArrayList<>();
    }

    public void cadastrarLance(Lance lance) {
        _lances.add(lance);
    }

    public Lance getLanceDessaCompeticao(Competicao competicao) {
        for (Lance lance : _lances) {
            if (lance.getCompeticaoAplicada().equals(competicao)) {
                return lance;
            }
        }
        return null;
    }
}
