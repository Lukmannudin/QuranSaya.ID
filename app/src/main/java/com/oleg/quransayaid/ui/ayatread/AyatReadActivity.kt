package com.oleg.quransayaid.ui.ayatread

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.oleg.quransayaid.common.gone
import com.oleg.quransayaid.common.visible
import com.oleg.quransayaid.databinding.ActivityAyatReadBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AyatReadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAyatReadBinding
    private lateinit var adapter: AyatReadAdapter

    private val viewModel: AyatReadViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAyatReadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val surahId = intent.extras?.getInt(SURAH_ID, -1)

        setupAdapter()

        surahId?.let { id ->
            viewModel.fetchAyatList(id)
        }

        subscribeAyat()
    }

    private fun setupAdapter() {
        adapter = AyatReadAdapter()
        with(binding) {
            val layoutManager = StaggeredGridLayoutManager(1, RecyclerView.VERTICAL)
            layoutManager.gapStrategy = StaggeredGridLayoutManager.HORIZONTAL
            rvAyatList.layoutManager = layoutManager
            rvAyatList.adapter = adapter
            rvAyatList.addItemDecoration(
                DividerItemDecoration(this@AyatReadActivity, RecyclerView.VERTICAL)
            )
        }
    }

    private fun subscribeAyat() {
        viewModel.ayatList.observe(this) { state ->
            when (state) {
                is AyatReadViewModel.AyatReadViewState.OnLoading -> {
                    setLoading(true)
                }
                is AyatReadViewModel.AyatReadViewState.OnLoaded -> {
                    setLoading(false)
                    adapter.submitList(state.ayatList)
                }
                is AyatReadViewModel.AyatReadViewState.OnFailure -> {
                    setLoading(false)
                    Toast.makeText(this@AyatReadActivity, state.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setLoading(status: Boolean) {
        if (status) {
            binding.pbAyatRead.visible()
        } else {
            binding.pbAyatRead.gone()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            super.onBackPressed()
        }

        return super.onOptionsItemSelected(item)
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