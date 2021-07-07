package com.example.androidglowroad2


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment

import com.example.androidglowroad2.databinding.FragmentXmlBinding
import com.squareup.okhttp.OkHttpClient
import androidx.lifecycle.ViewModelProviders
import com.squareup.okhttp.Request


class fragmentMain : Fragment() {

  var dataBinding : FragmentXmlBinding ? =null
  var viewModel : ViewModelMain?=null

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_xml,container,false)
    viewModel = ViewModelProviders.of(this).get(ViewModelMain::class.java)
    init()
    return dataBinding!!.root
  }

  private fun init() {
    viewModel!!.CallApi().observe(this,androidx.lifecycle.Observer {

      Log.d("RESPONSE FROM FIRST API",""+it.toString())

    })
  }


}