package com.oleg.quransayaid.ui.ayatread

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.oleg.quransayaid.databinding.ActivityAyatReadBinding

class AyatReadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAyatReadBinding

    private val viewModel: AyatReadViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAyatReadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val surahId = intent.extras?.getInt(SURAH_ID, -1)

        surahId?.let { id ->
            viewModel.fetchAyatList(id)
        }
    }

    private fun setupAdapter() {
        with(binding) {

        }
    }

    companion object {
        private const val SURAH_ID = "surah_id"

        fun start(activity: Activity, id: Int) {
            val intent = Intent(activity, AyatReadActivity::class.java)
            intent.putExtra(SURAH_ID, id)
            activity.startActivity(intent)
        }
    }
}