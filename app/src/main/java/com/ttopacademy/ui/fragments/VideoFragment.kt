package com.ttopacademy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ttopacademy.R
import com.ttopacademy.localdatasources.entities.Video
import com.ttopacademy.ui.viewmodels.FakeMainViewModel
import dagger.hilt.android.AndroidEntryPoint

/** Fragment for watching video. */
@AndroidEntryPoint
class VideoFragment : Fragment() {

    private lateinit var mainViewModel: FakeMainViewModel
    private lateinit var youtubeID: TextView
    private lateinit var videoTitle: TextView
    private lateinit var videoSize: TextView
    private lateinit var takePracticeQuestion: Button
    private lateinit var video: Video

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.fragment_video, container, false)
        youtubeID = view.findViewById(R.id.video_youtube_ID)
        videoTitle = view.findViewById(R.id.video_title)
        videoSize = view.findViewById(R.id.video_size)
        takePracticeQuestion = view.findViewById(R.id.take_practice_question)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(this).get(FakeMainViewModel::class.java)
        mainViewModel.getVideoItemUiState().observe(viewLifecycleOwner) { result ->
            video = result.selectedVideo
            updateUI()
        }
    }

    private fun updateUI() {
        val title: String = "Video Title: " + video.title
        val size: String = "Video Size: " + video.size + "MB"
        youtubeID.text = video.youtubeID
        videoTitle.text = title
        videoSize.text = size
    }
}