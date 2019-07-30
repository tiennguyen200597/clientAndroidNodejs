package com.fox.polyproduct.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fox.polyproduct.R

class SaleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view : View = inflater.inflate(R.layout.fragment_sale,container,false)

        return view
    }

}