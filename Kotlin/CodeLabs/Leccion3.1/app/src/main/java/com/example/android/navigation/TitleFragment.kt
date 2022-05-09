package com.example.android.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.android.navigation.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Creamos el binding para enlazar los datos con la vista
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(
            layoutInflater,
            R.layout.fragment_title, container, false
        )

        return binding.root //retornamos la vista más externa del fichero xml(raíz)

    }
}