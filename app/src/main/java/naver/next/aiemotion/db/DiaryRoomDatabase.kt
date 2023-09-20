package naver.next.aiemotion.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import naver.next.aiemotion.dao.DiaryDao
import naver.next.aiemotion.entity.Diary

@Database(entities = [Diary::class], version = 1, exportSchema = false)
abstract class DiaryRoomDatabase : RoomDatabase() {
    abstract fun diaryDao(): DiaryDao

    companion object {
        @Volatile
        private var INSTANCE: DiaryRoomDatabase? = null

        fun getInstance(context: Context): DiaryRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DiaryRoomDatabase::class.java,
                        "diary_database"
                    ).fallbackToDestructiveMigration().build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}