package com.example.android.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.databinding.ListItemSleepNightBinding

/*
*  Esta clase se llama SleepNightAdapter porque adapta un SleepNight objeto
*  a algo que RecyclerView puede usar.
*
* Sleep Adapter nos ayuda a saber si la lista del recyclerView se ha actualizado, ya no necesitaremos
* getItemCount porque listAdapter lo implementa.
*
* Su código debe indicar a ListAdapter cuándo está disponible una lista modificada. ListAdapter
* proporciona un método llamado submitList() para indicar a ListAdapter que hay disponible
* una nueva versión de la lista. Cuando se llama a este método, ListAdapter compara la nueva lista
* con la anterior y detecta los elementos que se agregaron, quitaron, movieron o cambiaron.
* Luego, ListAdapter actualiza los elementos mostrados por RecyclerView.
* */


class SleepNightAdapter :
    ListAdapter<SleepNight, SleepNightAdapter.ViewHolder>(SleepNightDiffCallback()) {

    //Esta función se llama cuando RecyclerView necesita un ViewHolder
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        return ViewHolder.from(parent)
    }

    /*
    * La onBindViewHolder() función es llamada por RecyclerView para mostrar los datos
    *  de un elemento de la lista en la posición especificada.
    * */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder private constructor(val binding: ListItemSleepNightBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SleepNight) {
            binding.sleep = item

            /*  Esta llamada es una optimización que solicita el enlace de datos
                para ejecutar cualquier enlace pendiente de inmediato.*/
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater =
                    LayoutInflater.from(parent.context)
                val binding =
                    ListItemSleepNightBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class SleepNightDiffCallback : DiffUtil.ItemCallback<SleepNight>() {

    //utiliza esta función para ayudar a descubrir si se agregó, eliminó o movió un elemento.
    override fun areItemsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
        return oldItem.nightId == newItem.nightId
    }

    //Esta función verifica si oldItem y newItem contienen los mismos datos; es decir, si son iguales.
    override fun areContentsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
        return oldItem == newItem
    }
}