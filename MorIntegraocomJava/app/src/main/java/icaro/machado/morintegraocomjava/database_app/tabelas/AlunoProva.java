package icaro.machado.morintegraocomjava.database_app.tabelas;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(    tableName = "tbl_alunoprova"
       ,    primaryKeys = {"alunoid", "provaid"}
       ,    indices = {@Index(value = {"alunoid"}), @Index(value = {"provaid"})}
       ,    foreignKeys = {@ForeignKey(entity = Aluno.class, parentColumns = "id",
                childColumns = "alunoid", onDelete = CASCADE, onUpdate = CASCADE)
                    ,  @ForeignKey(entity = Prova.class, parentColumns = "id",
                childColumns = "provaid", onDelete = CASCADE, onUpdate = CASCADE)})

public class AlunoProva {

    private int alunoid;

    private int provaid;

    public AlunoProva(){}

    public AlunoProva(AlunoProva tblAlunoProva) {

        this.alunoid = tblAlunoProva.getAlunoid();
        this.provaid = tblAlunoProva.getProvaid();

    }

    public int getAlunoid() {
        return alunoid;
    }

    public void setAlunoid(int alunoid) {
        this.alunoid = alunoid;
    }

    public int getProvaid() {
        return provaid;
    }

    public void setProvaid(int provaid) {
        this.provaid = provaid;
    }
}
