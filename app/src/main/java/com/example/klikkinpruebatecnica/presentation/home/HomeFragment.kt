package com.example.klikkinpruebatecnica.presentation.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.klikkinpruebatecnica.R
import com.example.klikkinpruebatecnica.databinding.HomeFragmentBinding
import com.example.klikkinpruebatecnica.models.categories
import com.example.klikkinpruebatecnica.presentation.home.adapters.CategoryAdapter
import com.example.klikkinpruebatecnica.presentation.home.adapters.CommerceItemAdapter
import com.example.klikkinpruebatecnica.presentation.models.LoadingState
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment(R.layout.home_fragment) {

    private val binding by viewBinding(HomeFragmentBinding::bind)
    private val viewModel by viewModel<HomeFragmentViewModel>()
    private val categoriesAdapter: CategoryAdapter by lazy {
        CategoryAdapter(onClickAction = { onClickOnCategory() })
    }
    private val commerceAdapter: CommerceItemAdapter by lazy {
        CommerceItemAdapter(onClickAction = { onClickOnCategory() })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setAdapters()
        setObservers()
        callViewmodel()
    }

    private fun setAdapters(){
        with(binding){
            categoriesAdapter.setDatabase(categories)
            rvListCategories.adapter = categoriesAdapter
            rvListCommerce.adapter = commerceAdapter
        }
    }

    private fun callViewmodel(){
        val t: Thread = object : Thread() {
            override fun run() {
                viewModel.getCommerces()
            }
        }
        t.start()
    }

    private fun setObservers(){
        viewModel.commerceList.observe(viewLifecycleOwner) {
            commerceAdapter.setDatabase(it)
            commerceAdapter.notifyDataSetChanged()
        }

        viewModel.loadingState.observe(viewLifecycleOwner) { loadingState ->
            when (loadingState.status) {
                LoadingState.Status.RUNNING -> showLoading(true)
                LoadingState.Status.SUCCESS -> showLoading(false)
                LoadingState.Status.FAILED -> showError()
            }
        }
    }

    private fun showError() {
        with(binding) {
            /*progressBar.isVisible = false
            recyclerView.isVisible = false
            searchButton.isVisible = false
            textInputLayout.isVisible = false
            errorText.isVisible = true
            errorText.text = "Load error. Retry again."
            retryButton.setOnClickListener { viewModel.getMovies() }
            retryButton.isVisible = true*/
        }
    }

    private fun showLoading(b: Boolean) {
        with(binding) {
            /*progressBar.isVisible = b
            recyclerView.isVisible = !b
            errorText.isVisible = false
            retryButton.isVisible = false
            searchButton.isVisible = !b
            textInputLayout.isVisible = !b

            if (!b) {
                searchButton.setOnClickListener {
                    textInputLayout.editText?.let {
                        if(it.text.toString() != ""){
                            searchFilm(it.text.toString())
                        }

                    }
                }

                textInputLayout.editText?.setOnKeyListener(
                    View.OnKeyListener { v, keyCode, event ->
                        if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                            textInputLayout.editText?.let {
                                if(it.text.toString() != ""){
                                    searchFilm(it.text.toString())
                                }

                            }
                            Log.d("TECLA ENTER", "Pulsada")
                            return@OnKeyListener true
                        }
                        false
                    })
            }*/
        }
    }

    private fun onClickOnCategory(){
        Toast.makeText(context, "Próximamente", Toast.LENGTH_SHORT).show()
    }

    private fun setListeners(){
        with(binding){

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}