package icaro.machado.morintegraocomjava.database_app.dbcallbacks;

import java.util.List;

import icaro.machado.morintegraocomjava.database_app.tabelas.Pergunta;

public interface IPerguntaDbCallback {
    void getPerguntaFromDB(List<Pergunta> tblPergunta);
}
