package br.com.denisecastro.androidrunner.game.model

enum class CollectibleType(
    val points: Int,
    val weight: Int
) {
    ANDROID_COIN(100, 30),
    CODE_TOKEN(150, 15),
    DATA_CHIP(200, 12),
    KOTLIN_GEM(300, 7),
    ENERGY_BOLT(150, 15),
    BUG_FIX(250, 9),
    BATTERY(200, 8),
    STAR_XP(500, 4)
}