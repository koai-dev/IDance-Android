package com.idance.hocnhayonline.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.idance.hocnhayonline.databinding.FragmentFaBinding

abstract class FaFragment : Fragment() {
    private var binding: ViewBinding? = null
    private lateinit var faBinding: FragmentFaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        faBinding = FragmentFaBinding.inflate(layoutInflater)
        binding = getBindingView() ?: getBindingView(container)
        if (binding != null) {
            faBinding.container.addView(binding!!.root)
        }
        return faBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (binding != null) {
            initView(savedInstanceState, binding!!)
        }
    }

    abstract fun getBindingView(): ViewBinding?

    abstract fun getBindingView(container: ViewGroup?): ViewBinding?

    abstract fun initView(savedInstanceState: Bundle?, binding: ViewBinding)

    fun showProgressbar(visible: Boolean) {
        faBinding.progressBar.visibility = if (visible) View.VISIBLE else View.GONE
    }
}