package com.example.androidglowroad2


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.androidglowroad2.databinding.FragmentXmlBinding

class fragmentMain : Fragment() {

  var dataBinding : FragmentXmlBinding ? =null

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_xml,container,false)
    return dataBinding!!.root
  }
}