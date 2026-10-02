package br.com.denisecastro.androidrunner.core.formatter

import java.text.NumberFormat
import java.util.Locale

object ScoreFormatter {

    private val formatter = NumberFormat.getIntegerInstance(
        Locale.forLanguageTag("pt-BR")
    )

    fun format(score: Int): String {
        return formatter.format(score)
    }
}