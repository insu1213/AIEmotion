package naver.next.aiemotion.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import naver.next.aiemotion.Confidence

@Entity(tableName = "diary")
data class Diary(
    @PrimaryKey(autoGenerate = true)
    var uid: Long = 0,

    @ColumnInfo(name = "content")
    var content: String,

    @ColumnInfo(name = "date")
    var date: String,

    @ColumnInfo(name = "confidence")
    var confidence: String,
)