package com.ttopacademy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ttopacademy.R
import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.ui.adapters.CategoryAdapter
import com.ttopacademy.ui.viewmodels.FakeMainViewModel
import dagger.hilt.android.AndroidEntryPoint

/** Fragment for showing categories. */
@AndroidEntryPoint
class CategoryListFragment : Fragment() {

    private lateinit var mainViewModel: FakeMainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var categories: MutableList<Category>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view: View  = inflater.inflate(R.layout.fragment_category_list, container, false)
        recyclerView = view.findViewById(R.id.category_list_recyclerView)
        progressBar = view.findViewById(R.id.category_list_progressBar)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(this).get(FakeMainViewModel::class.java)
        mainViewModel.getCategoryUiState().observe(viewLifecycleOwner) { result ->
            if (result.isFetchingCategories) {
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
            }
            categories = result.categories
            updateUI()
        }
    }

    private fun updateUI(){
        categoryAdapter = CategoryAdapter(categories) { category -> onItemClick(category) }
        recyclerView.adapter = categoryAdapter
    }

    private fun onItemClick(category: Category){
        mainViewModel.setSelectedCategory(category)
        navigateToSubjectListFragment()
    }

    private fun navigateToSubjectListFragment(){
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, SubjectListFragment::class.java, null)
            .setReorderingAllowed(true)
            .addToBackStack(null)  // name can be null
            .commit()
    }
}