package naver.next.aiemotion.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import naver.next.aiemotion.entity.Diary

@Dao
interface DiaryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addDiary(diary: Diary)

    @Query("SELECT * FROM diary WHERE uid = :uid")
    fun findDiaryById(uid: Long): Diary

    @Query("SELECT * FROM diary")
    fun getAllDiary(): List<Diary>

    @Update
    suspend fun updateDiary(diary: Diary)

    @Delete
    suspend fun deleteDiary(diary: Diary)
}