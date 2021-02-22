package com.malynkina.polishcities.feature.citydetailsmap.ui

import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.malynkina.polishcities.R
import com.malynkina.polishcities.core.ui.setToolbarTitle
import com.malynkina.polishcities.core.util.addFragment
import com.malynkina.polishcities.core.util.getArgument
import com.malynkina.polishcities.model.CityEnum
import com.malynkina.polishcities.model.CityModel
import dagger.android.support.DaggerFragment

class CityDetailsMapFragment : DaggerFragment(R.layout.feature_city_details_map), OnMapReadyCallback {

    private var mMap: GoogleMap? = null

    private var city: CityModel? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setCity(getArgument<CityModel?>("city"))
    }

    private fun initMap() {
        if (city != null) {
            val mapFragment = addFragment(R.id.map, SupportMapFragment::class) as SupportMapFragment
            mapFragment.getMapAsync(this)
        }
    }

    fun setCity(city: CityModel?) {
        this.city = city
        updateToolbar()
        if (city != null && mMap == null) {
            initMap()
        }else
            updateMap()
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        updateMap()
    }

    private fun updateToolbar() {
        city?.let {
            setToolbarTitle(it.name, it.color)
        }
    }

    private fun updateMap() {
        // Add a marker in Sydney and move the camera
        CityEnum.getValueByTitle(city?.name)?.let {
            val location = LatLng(it.lat, it.lng)
            mMap?.addMarker(MarkerOptions().position(location).title(it.title))
            mMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12f))
        }
    }

}