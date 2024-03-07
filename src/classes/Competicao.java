package classes;

import java.util.ArrayList;
import java.util.List;

public class Competicao {
    private String _nome;
    private String _data;
    private List<Competidor> _competidores;
    private String _resultadoHoras;
    private String _resultadoMinutos;
    private List<Competidor> _competidoresVencedores;

    public String getNome() {
        return _nome;
    }

    public String getData() {
        return _data;
    }

    public List<Competidor> getCompetidores() {
        return _competidores;
    }

    public String getResultadoHoras() {
        return _resultadoHoras;
    }

    public void setResultadoHoras(String resultadoHoras) {
        this._resultadoHoras = resultadoHoras;
    }

    public String getResultadoMinutos() {
        return _resultadoMinutos;
    }

    public void setResultadoMinutos(String resultadoMinutos) {
        this._resultadoMinutos = resultadoMinutos;
    }

    public Competicao(String nome, String data) {
        _nome = nome;
        _data = data;
        _competidores = new ArrayList<>();
        _resultadoHoras = "";
        _resultadoMinutos = "";
        _competidoresVencedores = new ArrayList<>();
    }

    public void adicionarCompetidor(Competidor competidor) {
        _competidores.add(competidor);
    }

    public boolean definirResultado(String resultadoHoras, String resultadoMinutos) {
        if (!_resultadoHoras.isEmpty() || !_resultadoMinutos.isEmpty())
            return false;

        _resultadoHoras = resultadoHoras;
        _resultadoMinutos = resultadoMinutos;

        return true;
    }

    public List<Competidor> verificarVencedores() {
        if (_resultadoHoras.isEmpty() || _resultadoMinutos.isEmpty())
            return null;

        for (Competidor competidor : _competidores) {
            if (competidor.getLanceDessaCompeticao(this).getHoras() == _resultadoHoras
                    && competidor.getLanceDessaCompeticao(this).getMinutos() == _resultadoMinutos) {
                _competidoresVencedores.add(competidor);
                competidor.getLanceDessaCompeticao(this).setLanceVencedor();
            } else {
                competidor.getLanceDessaCompeticao(this).setLancePerdedor();
            }
        }

        return _competidoresVencedores;
    }

    public double totalApostas() {
        double totalApostado = 0;

        for (Competidor competidor : _competidores) {
            totalApostado += competidor.getLanceDessaCompeticao(this).getValorApostado();
        }

        return totalApostado;
    }

    public double premioIndividual() {
        double totalApostado = totalApostas();

        return totalApostado / _competidoresVencedores.size();
    }

    public boolean premiarVencedores() {
        if (_competidoresVencedores.isEmpty())
            return false;

        double premiacaoIndividual = premioIndividual();

        for (Competidor competidor : _competidores) {
            competidor.getLanceDessaCompeticao(this).setPremio(premiacaoIndividual);
        }

        return true;
    }
}
