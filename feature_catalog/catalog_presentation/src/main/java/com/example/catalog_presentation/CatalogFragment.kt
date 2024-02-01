package com.example.catalog_presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.catalog_presentation.databinding.FragmentCatalogBinding
import com.example.navigation.NavigationUtils
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CatalogFragment : Fragment() {
    private var _binding : FragmentCatalogBinding? = null
    private val binding get() = _binding!!
    @Inject
    lateinit var navigationUtils: NavigationUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCatalogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        showBottomNavigationBar()
    }

    @SuppressLint("ResourceType")
    private fun showBottomNavigationBar() {
        navigationUtils = NavigationUtils()
        val bot : BottomNavigationView? = view?.findViewById(2131296353)
        navigationUtils.showBottomNavigationBar(activity as AppCompatActivity, bot)
    }

    companion object {

    }
}