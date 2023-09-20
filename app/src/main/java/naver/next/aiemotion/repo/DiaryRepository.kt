package naver.next.aiemotion.repo

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import naver.next.aiemotion.dao.DiaryDao
import naver.next.aiemotion.entity.Diary

class DiaryRepository(private val diaryDao: DiaryDao) {
    val allDiary = MutableLiveData<List<Diary>>()
    val foundDiary = MutableLiveData<Diary>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun addDiary(newDiary: Diary) {
        coroutineScope.launch(Dispatchers.IO) {
            diaryDao.addDiary(newDiary)
        }
    }

    fun updateDiary(newDiary: Diary) {
        coroutineScope.launch(Dispatchers.IO) {
            diaryDao.updateDiary(newDiary)
        }
    }

    fun getAllDiary() {
        coroutineScope.launch(Dispatchers.IO) {
            allDiary.postValue(diaryDao.getAllDiary())
        }
    }

    fun deleteDiary(diary: Diary) {
        coroutineScope.launch(Dispatchers.IO) {
            diaryDao.deleteDiary(diary)
        }
    }

    fun findDiaryById(uid: Long) {
        coroutineScope.launch(Dispatchers.IO) {
            foundDiary.postValue(diaryDao.findDiaryById(uid))
        }
    }
}