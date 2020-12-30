package com.example.muvi.base

import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.example.muvi.data.model.GeneralEntity

abstract class BaseAdapter<T : GeneralEntity, B : ViewBinding>
    : ListAdapter<T, BaseViewHolder<T, B>>(BaseDiffUtil<T>()), BindDataAdapter<List<T>> {

    override fun onBindViewHolder(holder: BaseViewHolder<T, B>, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun setData(data: List<T>?) {
        submitList(data)
    }
}
