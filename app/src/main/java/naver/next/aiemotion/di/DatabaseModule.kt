package naver.next.aiemotion.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import naver.next.aiemotion.dao.DiaryDao
import naver.next.aiemotion.db.DiaryRoomDatabase
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
private object DatabaseModule {

    @Provides
    fun provideDiary(appDatabase: DiaryRoomDatabase): DiaryDao {
        return appDatabase.diaryDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): DiaryRoomDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            DiaryRoomDatabase::class.java,
            "appDB"
        ).build()
    }
}