package icaro.machado.morintegraocomjava.database_app.tabelas;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(    tableName = "tbl_resposta"
        ,   primaryKeys = {"id"}
        ,   indices   = {@Index(value = "id", unique = true)}
        ,   foreignKeys = {@ForeignKey(entity = Pergunta.class, parentColumns = "id"
        ,         childColumns = "perguntaId", onDelete = CASCADE, onUpdate = CASCADE)})
public class Resposta {

    private int id;

    private int perguntaid;

    private String resposta;

    public Resposta(){}

    public Resposta(Resposta tblResposta) {

        this.id         = tblResposta.getId();
        this.resposta   = tblResposta.getResposta();
        this.perguntaid = tblResposta.getperguntaid();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getperguntaid() {
        return perguntaid;
    }

    public void setperguntaid(int perguntaid) {
        this.perguntaid = perguntaid;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
