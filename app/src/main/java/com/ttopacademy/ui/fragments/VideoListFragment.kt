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
import com.ttopacademy.localdatasources.entities.Video
import com.ttopacademy.ui.adapters.VideoAdapter
import com.ttopacademy.ui.viewmodels.MainViewModel
import com.ttopacademy.ui.viewmodels.MainViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

/** Fragment for showing list of videos. */
@AndroidEntryPoint
class VideoListFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var videoAdapter: VideoAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var videos: MutableList<Video>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.fragment_video_list, container, false)
        recyclerView = view.findViewById(R.id.video_list_recyclerView)
        progressBar = view.findViewById(R.id.video_list_progressBar)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(this)[MainViewModelImpl::class.java]
        mainViewModel.getVideoUiState().observe(viewLifecycleOwner) { result ->
            if (result.isFetchingVideos) {
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
            }
            videos = result.videos
            updateUI()
        }
    }

    private fun updateUI(){
        videoAdapter = VideoAdapter(videos) { video ->  onItemClick(video)}
        recyclerView.adapter = videoAdapter
    }

    private fun onItemClick(video: Video){
        mainViewModel.setSelectedVideo(video)
        navigateToSubjectListFragment()
    }

    private fun navigateToSubjectListFragment(){
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, VideoFragment::class.java, null)
            .setReorderingAllowed(true)
            .addToBackStack(null)  // name can be null
            .commit()
    }
}