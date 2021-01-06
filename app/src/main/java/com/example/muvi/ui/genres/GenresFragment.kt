package com.example.muvi.ui.genres

import androidx.navigation.fragment.findNavController
import com.example.muvi.R
import com.example.muvi.base.BaseFragment
import com.example.muvi.data.model.Genre
import com.example.muvi.databinding.FragmentGenreBinding
import com.example.muvi.ui.adpater.GenresAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class GenresFragment : BaseFragment<FragmentGenreBinding>() {

    override val layoutResource: Int
        get() = R.layout.fragment_genre

    override val viewModel by sharedViewModel<GenresViewModel>()

    private val genresAdapter = GenresAdapter(::onItemGenreClick)

    override fun initData() {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            genresVM = viewModel
            recyclerGenres.adapter = genresAdapter
        }
    }

    private fun onItemGenreClick(itemGenre: Genre) {
        binding.apply {
            viewModel.getMovies(itemGenre.id)
            navigateToList(itemGenre.name)
        }
    }

    private fun navigateToList(title: String) {
        val action = GenresFragmentDirections.actionGenresFragmentToMovieTypeFragment(title)
        findNavController().navigate(action)
    }
}
