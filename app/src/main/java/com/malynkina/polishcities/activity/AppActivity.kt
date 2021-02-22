package com.malynkina.polishcities.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.malynkina.polishcities.Navigator
import com.malynkina.polishcities.R
import com.malynkina.polishcities.core.ui.ToolbarProcessing
import com.malynkina.polishcities.core.util.getColorByName
import com.malynkina.polishcities.databinding.ActivityBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AppActivity : DaggerAppCompatActivity(), ToolbarProcessing {

    @Inject
    internal lateinit var navigator: Navigator
    @Inject
    internal lateinit var viewModel: AppActivityViewModel

    lateinit var binding: ActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityBinding>(this, R.layout.activity)
        setSupportActionBar(binding.toolbar)
        viewModel.startGenerator()
    }

    override fun onResume() {
        super.onResume()
        navigator.bind(findNavController(R.id.nav_host_fragment))
    }

    override fun onPause() {
        navigator.unbind()
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
        viewModel.stopGenerator()
    }

    override fun setToolbarTitleAndColor(title: String, color: String) {
        binding.toolbar.title = title
        binding.toolbar.setBackgroundColor(baseContext.getColorByName(color))
    }

}