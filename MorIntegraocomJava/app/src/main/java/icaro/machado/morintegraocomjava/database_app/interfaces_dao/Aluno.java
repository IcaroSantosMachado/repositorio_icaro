package icaro.machado.morintegraocomjava.database_app.interfaces_dao;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

public interface Aluno {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAluno(Aluno alunotabela);

//    @Query('SELECT id FROM tbl_aluno WHERE id = "id" ')

}
