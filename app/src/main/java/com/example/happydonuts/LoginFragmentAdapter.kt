package com.example.happydonuts

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class LoginFragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2 //Retorna 2, porque son dos vistas las que vamos a mostrar. La de login y la de registro
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            LoginFragment()
        } else {
            RegisterFragment()
        }
    }
}