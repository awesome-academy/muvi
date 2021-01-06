package com.example.muvi.base

import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.example.muvi.data.model.GeneralEntity

abstract class BaseAdapter<T : GeneralEntity, B : ViewBinding>(
    private val listener: (T) -> Unit,
    private val loadMore: () -> Unit
) : ListAdapter<T, BaseViewHolder<T, B>>(BaseDiffUtil<T>()), BindDataAdapter<List<T>> {

    override fun onBindViewHolder(holder: BaseViewHolder<T, B>, position: Int) {
        holder.onBind(getItem(position))
        if (position == currentList.size - NUMBER_OF_ITEM_SHOW) {
            loadMore()
        }
    }

    override fun setData(data: List<T>?) {
        submitList(data)
    }

    companion object {
        const val NUMBER_OF_ITEM_SHOW = 10
    }
}
