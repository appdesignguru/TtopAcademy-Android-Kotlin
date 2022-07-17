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
import com.ttopacademy.localdatasources.entities.Topic
import com.ttopacademy.ui.adapters.TopicAdapter
import com.ttopacademy.ui.viewmodels.FakeMainViewModel
import dagger.hilt.android.AndroidEntryPoint

/** Fragment for showing topics. */
@AndroidEntryPoint
class TopicListFragment : Fragment() {

    private lateinit var mainViewModel: FakeMainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var topicAdapter: TopicAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var topics: MutableList<Topic>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.fragment_topic_list, container, false)
        recyclerView = view.findViewById(R.id.topic_list_recyclerView)
        progressBar = view.findViewById(R.id.topic_list_progressBar)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(this).get(FakeMainViewModel::class.java)
        mainViewModel.getTopicUiState().observe(viewLifecycleOwner) { result ->
            if (result.isFetchingTopics) {
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
            }
            topics = result.topics
            updateUI()
        }
    }

    private fun updateUI(){
        topicAdapter = TopicAdapter(topics) { topic ->  onItemClick(topic)}
        recyclerView.adapter = topicAdapter
    }

    private fun onItemClick(topic: Topic){
        mainViewModel.setSelectedTopic(topic)
        navigateToSubjectListFragment()
    }

    private fun navigateToSubjectListFragment(){
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, VideoListFragment::class.java, null)
            .setReorderingAllowed(true)
            .addToBackStack(null)  // name can be null
            .commit()
    }
}