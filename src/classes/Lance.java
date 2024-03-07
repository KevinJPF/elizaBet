package classes;

enum Status {
    concorrendo,
    venceu,
    perdeu,
}

public class Lance {
    private double _valorApostado;
    private String _horas;
    private String _minutos;
    private Competicao _competicaoAplicada;
    private Status _status;
    private double _premio;

    public double getValorApostado() {
        return _valorApostado;
    }

    public String getHoras() {
        return _horas;
    }

    public String getMinutos() {
        return _minutos;
    }

    public Competicao getCompeticaoAplicada() {
        return _competicaoAplicada;
    }

    public Status getStatus() {
        return _status;
    }

    public double getPremio() {
        return _premio;
    }

    public void setPremio(double premio) {
        if (_status == Status.venceu)
            this._premio = premio;
    }

    public Lance(double valorApostado, String horas, String minutos, Competicao competicaoAplicada) {
        _valorApostado = valorApostado;
        _horas = horas;
        _minutos = minutos;
        _competicaoAplicada = competicaoAplicada;
        _status = Status.concorrendo;
        _premio = 0.0;
    }

    String resultadoLance() {
        if (_status == Status.concorrendo)
            return "Lance concorrendo ao premio.";
        if (_status == Status.venceu)
            return "Lance vencedor da competicao, parabens!";
        if (_status == Status.perdeu)
            return "O lance nao foi o vencedor, mais sorte na proxima.";

        return "Houve um erro com este lance.";
    }

    public void setLanceVencedor() {
        if (_status == Status.concorrendo)
            this._status = Status.venceu;
    }

    public void setLancePerdedor() {
        if (_status == Status.concorrendo)
            this._status = Status.perdeu;
    }
}
