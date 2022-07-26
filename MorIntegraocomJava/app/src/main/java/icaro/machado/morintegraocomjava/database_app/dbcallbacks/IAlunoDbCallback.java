package icaro.machado.morintegraocomjava.database_app.dbcallbacks;

import java.util.List;


import icaro.machado.morintegraocomjava.database_app.tabelas.Aluno;

public interface IAlunoDbCallback {
    void getAlunoFromDB(List<Aluno> tblAluno);
}
