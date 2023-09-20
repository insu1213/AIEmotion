package naver.next.aiemotion.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import naver.next.aiemotion.entity.Diary
import naver.next.aiemotion.repo.DiaryRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val diaryRepository: DiaryRepository
    ) : ViewModel() {

    val diaryList: LiveData<List<Diary>> = diaryRepository.allDiary
    val foundDiary: LiveData<Diary> = diaryRepository.foundDiary

    fun getAllDiary() {
        diaryRepository.getAllDiary()
    }

    fun addDiary(diary: Diary) {
        diaryRepository.addDiary(diary)
        getAllDiary()
    }

    fun updateDiary(diary: Diary) {
        diaryRepository.updateDiary(diary)
        getAllDiary()
    }

    fun findDiaryById(uid: Long) {
        diaryRepository.findDiaryById(uid)
    }

    fun deleteDiary(diary: Diary) {
        diaryRepository.deleteDiary(diary)
        getAllDiary()
    }
}