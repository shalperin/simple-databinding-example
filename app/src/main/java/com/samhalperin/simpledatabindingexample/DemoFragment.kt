package com.samhalperin.simpledatabindingexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.samhalperin.simpledatabindingexample.databinding.DemoFragmentBinding

/**
 * The single Fragment in this project. Loaded via the navigation
 * component, see res/navigation/nav_graph.xml
 */
class DemoFragment : Fragment() {
    private lateinit var binding: DemoFragmentBinding
    private val viewModel:DemoViewModel by viewModels() // see: fragment-ktx

    /**
     * Override onCreateView to generate a data binding for the layout file
     * R.layout.demo_fragment.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil
            .inflate(inflater,R.layout.demo_fragment, container, false)
        binding.lifecycleOwner = this
        return binding.root

    }

    /**
     * After the view is available, pass the viewModel into the binding so we can
     * use it directly in our templates.  See the data section of res/layout/demo_fragment.xml.
     **/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        /*
         * Without passing the viewmodel in directly with data binding, we might have an
         * Observer that looks something like this:

        viewModel.msg.observe(viewLifecycleOwner, Observer {msg ->
            binding.myTextview.text = msg
        })
         */
    }

}