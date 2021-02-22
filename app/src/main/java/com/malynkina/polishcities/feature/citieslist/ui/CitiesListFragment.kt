package com.malynkina.polishcities.feature.citieslist.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.malynkina.polishcities.R
import com.malynkina.polishcities.databinding.FeatureCitieslistBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class CitiesListFragment : DaggerFragment(R.layout.feature_citieslist) {

    @Inject
    internal lateinit var viewModel: CitiesListViewModel

    private var citiesAdapter: CitiesAdapter = CitiesAdapter {
        onItemClickListener = { city ->
            setFragmentResult(
                REQUEST_KEY,
                bundleOf(CITY to city)
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FeatureCitieslistBinding.bind(view).run {
            lifecycleOwner = viewLifecycleOwner
            recycleViewCities.adapter = citiesAdapter
            viewModel.cities.observe(viewLifecycleOwner, {
                citiesAdapter.addCityModels(it)
//                cityCount.text = citiesAdapter.list.size().toString()
            })
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getCities()
    }

    override fun onStop() {
        super.onStop()
        viewModel.clear()
    }

    companion object {
        const val REQUEST_KEY = "list_request_key"
        const val CITY = "city"
        const val LOAD_REQUEST_KEY = "load_request_key"
        const val LOADED = "load"
    }

}