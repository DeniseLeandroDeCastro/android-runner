package br.com.denisecastro.androidrunner.game.model

enum class CollectibleType(
    val points: Int
) {
    ANDROID_COIN(100),
    CODE_TOKEN(250),
    DATA_CHIP(500),
    KOTLIN_GEM(500),
    ENERGY_BOLT(250),
    BUG_FIX(300),
    BATTERY(100),
    STAR_XP(200)
}