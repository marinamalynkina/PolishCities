package com.malynkina.polishcities.feature.citieslist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SortedList
import com.malynkina.polishcities.core.util.getColorByName
import com.malynkina.polishcities.databinding.FeatureCitieslistItemBinding
import com.malynkina.polishcities.model.CityModel
import java.text.SimpleDateFormat
import java.util.*

class CitiesAdapter(
    builder: CitiesAdapter.() -> Unit = {}
) : RecyclerView.Adapter<CitiesAdapter.CityViewHolder>() {
    var list: SortedList<CityModel>

    init {
        this.run(builder)
        list = SortedList(CityModel::class.java, object : SortedList.Callback<CityModel>() {
            override fun compare(o1: CityModel, o2: CityModel): Int {
                return o1.name.compareTo(o2.name)
            }

            override fun onInserted(position: Int, count: Int) {
                notifyItemRangeInserted(position, count)
            }

            override fun onRemoved(position: Int, count: Int) {
                notifyItemRangeRemoved(position, count)
            }

            override fun onMoved(fromPosition: Int, toPosition: Int) {
                notifyItemMoved(fromPosition, toPosition)
            }

            override fun onChanged(position: Int, count: Int) {
                notifyItemRangeChanged(position, count)
            }

            override fun areContentsTheSame(oldItem: CityModel, newItem: CityModel): Boolean {
                return oldItem.name == newItem.name
                        && oldItem.color == newItem.color
                        && oldItem.createdTime == newItem.createdTime
            }

            override fun areItemsTheSame(oldItem: CityModel, newItem: CityModel): Boolean {
                return oldItem.name == newItem.name
                        && oldItem.color == newItem.color
                        && oldItem.createdTime == newItem.createdTime
            }

        })
    }

    var onItemClickListener: ((CityModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesAdapter.CityViewHolder {
        return CityViewHolder(
                FeatureCitieslistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CitiesAdapter.CityViewHolder, position: Int) {
        list?.get(position).let { city ->
            holder.binding.root.setOnClickListener { onItemClickListener?.invoke(city) }
            holder.binding.cityName.text = city.name
            holder.binding.cityName.setTextColor(holder.binding.root.context.getColorByName(city.color))
            holder.binding.cityTime.text = SimpleDateFormat("dd MMMM yyyy HH:mm:ss", Locale.getDefault())
                                                .format(city.createdTime)
        }
    }

    override fun getItemCount() = list.size()
    operator fun get(position: Int): CityModel? = list[position]
    override fun getItemViewType(position: Int): Int = 0


    fun addCityModels(cityModels: List<CityModel>) {
        list.beginBatchedUpdates()
        for (i in cityModels.indices) {
            list.add(cityModels.get(i))
        }
        list.endBatchedUpdates()
    }

    class CityViewHolder(val binding: FeatureCitieslistItemBinding) : RecyclerView.ViewHolder(binding.root)
}