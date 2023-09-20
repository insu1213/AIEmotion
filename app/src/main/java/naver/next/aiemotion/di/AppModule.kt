package naver.next.aiemotion.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import naver.next.aiemotion.dao.DiaryDao
import naver.next.aiemotion.repo.DiaryRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDiaryRepository(diaryDao: DiaryDao): DiaryRepository {
        return DiaryRepository(diaryDao)
    }
}