package com.oleg.quransayaid.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oleg.quransayaid.common.gone
import com.oleg.quransayaid.common.visible
import com.oleg.quransayaid.databinding.ActivityHomeBinding
import com.oleg.quransayaid.ui.ayatread.AyatReadActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.fetchSurahList()

        setupAdapter()


        subscribeSurahList()
    }

    private fun subscribeSurahList() {
        viewModel.surahList.observe(this) { state ->
            when (state) {
                is HomeViewModel.HomeViewState.OnLoaded -> {
                    setLoading(false)
                    adapter.submitList(state.surahList)
                }
                is HomeViewModel.HomeViewState.OnFailure -> {
                    Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
                    setLoading(false)
                }
                is HomeViewModel.HomeViewState.OnLoading -> {
                    setLoading(true)
                }
                else -> {
                    setLoading(false)
                    Toast.makeText(this, "Something went a wrong", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setLoading(status: Boolean) {
        if (status) {
            binding.pbHome.visible()
        } else {
            binding.pbHome.gone()
        }
    }

    private fun setupAdapter() {
        adapter = HomeAdapter().apply {
            onItemClick = { surahId ->
                AyatReadActivity.start(this@HomeActivity, surahId)
            }
        }
        binding.rvSurahList.layoutManager = LinearLayoutManager(this@HomeActivity)
        binding.rvSurahList.adapter = adapter
        binding.rvSurahList.addItemDecoration(
            DividerItemDecoration(this@HomeActivity, RecyclerView.VERTICAL)
        )
    }
}