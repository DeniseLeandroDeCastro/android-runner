package br.com.denisecastro.androidrunner.data.ranking.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "game_scores"
)
data class GameScoreEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val score: Int,
    val createdAt: Long
)
