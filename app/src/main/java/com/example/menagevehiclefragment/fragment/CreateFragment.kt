package com.example.menagevehiclefragment.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.menagevehiclefragment.R
import com.example.menagevehiclefragment.interfaces.IFragmentCommunication

/**
 * A simple [Fragment] subclass.
 * Use the [CreateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateFragment(val navigation: IFragmentCommunication) : Fragment(R.layout.fragment_create) {
}