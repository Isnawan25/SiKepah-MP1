package com.example.aplikasisikepah

import android.content.Context

data class DataSource(private val context: Context) {
    fun loadAffirmations(): List<KategoriSampah> {
        return listOf(
            KategoriSampah(context.getString(R.string.KategoriSampah1), R.drawable.gambar1),
            KategoriSampah(context.getString(R.string.KategoriSampah2), R.drawable.gambar2),
            KategoriSampah(context.getString(R.string.KategoriSampah3), R.drawable.gambar3),
            KategoriSampah(context.getString(R.string.KategoriSampah4), R.drawable.gambar4),
            KategoriSampah(context.getString(R.string.KategoriSampah5), R.drawable.gambar5)
        )
    }
}
