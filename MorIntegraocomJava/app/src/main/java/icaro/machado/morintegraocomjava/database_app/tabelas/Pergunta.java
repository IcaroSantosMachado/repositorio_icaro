package icaro.machado.morintegraocomjava.database_app.tabelas;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(    tableName = "tbl_pergunta"
        ,   primaryKeys = {"id"}
        ,   indices   = {@Index(value = "id", unique = true)}
        ,   foreignKeys = {@ForeignKey(entity = Prova.class, parentColumns = "id"
        ,       childColumns = "provaId", onDelete = CASCADE, onUpdate = CASCADE)})

public class Pergunta {

    private int id;

    private int provaId;

    private String pergunta;

    public Pergunta() {}

    public Pergunta(Pergunta tblPergunta){

        this.id         = tblPergunta.getId();
        this.provaId    = tblPergunta.getProvaId();
        this.pergunta   = tblPergunta.getPergunta();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvaId() {
        return provaId;
    }

    public void setProvaId(int provaId) {
        this.provaId = provaId;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
}
