package com.samhalperin.simpledatabindingexample

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.samhalperin.simpledatabindingexample.databinding.DemoFragmentBinding
import kotlinx.android.synthetic.main.demo_fragment.*

class DemoFragment : Fragment() {
    private lateinit var binding: DemoFragmentBinding

    companion object {
        fun newInstance() = DemoFragment()
    }

    private lateinit var viewModel: DemoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil
            .inflate(inflater,R.layout.demo_fragment, container, false)
        binding.setLifecycleOwner(this)
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(DemoViewModel::class.java)
        binding.viewModel = viewModel

    }

}