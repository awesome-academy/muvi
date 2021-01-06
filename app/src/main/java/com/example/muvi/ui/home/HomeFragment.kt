package com.example.muvi.ui.home

import androidx.recyclerview.widget.PagerSnapHelper
import com.example.muvi.R
import com.example.muvi.base.BaseFragment
import com.example.muvi.data.model.Movie
import com.example.muvi.databinding.FragmentHomeBinding
import com.example.muvi.ui.adpater.DiscoveryAdapter
import com.example.muvi.ui.adpater.PosterAdapter
import com.example.muvi.ui.adpater.BannerAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val layoutResource: Int = R.layout.fragment_home
    override val viewModel by sharedViewModel<HomeViewModel>()
    private val discoveryAdapter = DiscoveryAdapter(::onItemPosterClick)
    private val trendingAdapter = PosterAdapter(::onItemPosterClick)
    private val topRateAdapter = PosterAdapter(::onItemPosterClick)
    private val topPopularAdapter = PosterAdapter(::onItemPosterClick)
    private val bannerAdapter = BannerAdapter(::onItemPosterClick)

    override fun initData() {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            homeVM = viewModel
            recyclerDiscovery.adapter = discoveryAdapter
            recyclerTrending.adapter = trendingAdapter
            recyclerTopRate.adapter = topRateAdapter
            recyclerPopular.adapter = topPopularAdapter
            recyclerBanner.adapter = bannerAdapter
            PagerSnapHelper().attachToRecyclerView(recyclerBanner)
            pageIndicatorBanner.attachToRecyclerView(recyclerBanner)
        }
    }

    private fun onItemPosterClick(movie: Movie) {

    }
}
