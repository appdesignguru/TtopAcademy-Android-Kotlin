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
import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.ui.adapters.SubjectAdapter
import com.ttopacademy.ui.viewmodels.FakeMainViewModel
import dagger.hilt.android.AndroidEntryPoint

/** Fragment for showing subjects. */
@AndroidEntryPoint
class SubjectListFragment : Fragment() {

    private lateinit var mainViewModel: FakeMainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var subjectAdapter: SubjectAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var subjects: MutableList<Subject>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.fragment_subject_list, container, false)
        recyclerView = view.findViewById(R.id.subject_list_recyclerView)
        progressBar = view.findViewById(R.id.subject_list_progressBar)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(this).get(FakeMainViewModel::class.java)
        mainViewModel.getSubjectUiState().observe(viewLifecycleOwner) { result ->
            if (result.isFetchingSubjects) {
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
            }
            subjects = result.subjects
            updateUI()
        }
    }

    private fun updateUI(){
        subjectAdapter = SubjectAdapter(subjects) { subject ->  onItemClick(subject)}
        recyclerView.adapter = subjectAdapter
    }

    private fun onItemClick(subject: Subject){
        mainViewModel.setSelectedSubject(subject)
        navigateToSubjectListFragment()
    }

    private fun navigateToSubjectListFragment(){
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, TopicListFragment::class.java, null)
            .setReorderingAllowed(true)
            .addToBackStack(null)  // name can be null
            .commit()
    }
}