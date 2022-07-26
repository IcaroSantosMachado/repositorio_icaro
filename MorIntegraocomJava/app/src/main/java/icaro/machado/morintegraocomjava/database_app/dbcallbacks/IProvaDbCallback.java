package icaro.machado.morintegraocomjava.database_app.dbcallbacks;

import java.util.List;

import icaro.machado.morintegraocomjava.database_app.tabelas.Prova;

public interface IProvaDbCallback {
    void getProvaFromDB(List<Prova> tblProva);
}
