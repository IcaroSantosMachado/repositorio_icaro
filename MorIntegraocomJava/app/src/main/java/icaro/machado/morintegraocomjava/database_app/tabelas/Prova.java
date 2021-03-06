package icaro.machado.morintegraocomjava.database_app.tabelas;

import androidx.room.Entity;
import androidx.room.Index;

@Entity(    tableName = "tbl_prova"
        ,   primaryKeys = {"id"}
        ,   indices = {@Index(value = "id", unique = true)})

public class Prova {

    private int id;

    private String disciplina;

    public Prova(){}

    public Prova(Prova tblProva) {
        this.id = tblProva.getId();
        this.disciplina = tblProva.disciplina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}
