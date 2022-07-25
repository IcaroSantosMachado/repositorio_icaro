package icaro.machado.morintegraocomjava.database_app.tabelas;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(tableName = "tbl_alunoprova"
       , primaryKeys = {"alunoid", "provaid"}
       , indices = {@Index(value = {"alunoid"}), @Index(value = {"provaid"})}
       , foreignKeys = {@ForeignKey(entity = Aluno.class, parentColumns = "id",
            childColumns = "alunoid", onDelete = CASCADE, onUpdate = CASCADE)
                    ,  @ForeignKey(entity = Prova.class, parentColumns = "id",
            childColumns = "prova id", onDelete = CASCADE, onUpdate = CASCADE)})

public class AlunoProva {

    private int alunoid;

    private int provaid;

    public AlunoProva(){}

    public AlunoProva(AlunoProva tblAlunoProva) {

        this.alunoid = tblAlunoProva.getAlunoID();
        this.provaid = tblAlunoProva.getProvaID();

    }

    public int getAlunoID() {
        return alunoid;
    }

    public void setAlunoID(int alunoid) {
        this.alunoid = alunoid;
    }

    public int getProvaID() {
        return provaid;
    }

    public void setProvaID(int provaid) {
        this.provaid = provaid;
    }
}
