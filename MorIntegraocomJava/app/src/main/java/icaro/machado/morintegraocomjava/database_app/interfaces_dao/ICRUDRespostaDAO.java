package icaro.machado.morintegraocomjava.database_app.interfaces_dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;


import icaro.machado.morintegraocomjava.database_app.tabelas.Resposta;

@Dao
public interface ICRUDRespostaDAO {

    @Transaction
    @Insert(entity = Resposta.class, onConflict = OnConflictStrategy.REPLACE)
    void insertResposta(Resposta tblResposta);

    @Query("SELECT id, resposta, perguntaid FROM tbl_resposta WHERE id = 7")
    Resposta getEspecificRespostaByID(Resposta id);

    @Query("SELECT id, resposta, perguntaid FROM tbl_resposta")
    List<Resposta> getAllRespostas();

    @Update(entity = Resposta.class, onConflict = OnConflictStrategy.REPLACE)
    void updateRespostas(Resposta tblResposta);

    @Delete
    void deleteRespostas(Resposta tblResposta);

    @Query("DELETE FROM tbl_resposta WHERE id = 5")
    void deleteRespostaByID(Resposta id);

    @Query("DELETE FROM tbl_resposta")
    void deleteAllRespostas();



}
