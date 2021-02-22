package com.malynkina.polishcities.feature.citieswithdetails.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentResultListener
import com.malynkina.polishcities.R
import com.malynkina.polishcities.core.util.getArgument
import com.malynkina.polishcities.databinding.FeatureCitieswithdetailsBinding
import com.malynkina.polishcities.feature.citieslist.ui.CitiesListFragment
import com.malynkina.polishcities.feature.citydetailsmap.ui.CityDetailsMapFragment
import com.malynkina.polishcities.model.CityModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class CitiesWithDetailsFragment : DaggerFragment(R.layout.feature_citieswithdetails) {

    @Inject
    internal lateinit var viewModel: CitiesWithDetailsViewModel

    var twoPanel = false

    private lateinit var binding: FeatureCitieswithdetailsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FeatureCitieswithdetailsBinding.bind(view)
        binding?.run {
            twoPanel = (detailsCardview != null)
        }
        setUpResultListener()
    }

    private fun setUpResultListener() {
        childFragmentManager.setFragmentResultListener(
            CitiesListFragment.REQUEST_KEY,
            this,
            FragmentResultListener { requestKey, result ->
                if (requestKey == CitiesListFragment.REQUEST_KEY) {
                    showDetails(result.getArgument(CitiesListFragment.CITY))
                }
            })
    }

    private fun showDetails(city: CityModel?) {
        city?.let {
            if (twoPanel) {
                binding.detailsFragment?.let {
                    (childFragmentManager.findFragmentById(it.id) as? CityDetailsMapFragment)?.let {
                        it.setCity(city)
                    }
                }
            }else viewModel.showDetails(city)
        }
    }

    override fun onStop() {
        super.onStop()
        viewModel.clear()
    }
}