package br.com.denisecastro.androidrunner.game.model

enum class CollectibleType(
    val points: Int
) {
    ANDROID_COIN(100),
    CODE_TOKEN(150),
    DATA_CHIP(200),
    KOTLIN_GEM(300),
    ENERGY_BOLT(150),
    BUG_FIX(250),
    BATTERY(200),
    STAR_XP(500)
}