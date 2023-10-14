package com.example.projectone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import com.example.projectone.databinding.ActivityVideoPlayerBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import java.util.regex.Pattern

class VideoPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoPlayerBinding
    private val link = "https://youtu.be/xmIXi-G3k9g?si=Cwy73KrtacvoBCch"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.youtubePlayerView.addYouTubePlayerListener(object : YouTubePlayerListener {
            override fun onApiChange(youTubePlayer: YouTubePlayer) {
                // Handle API changes (if needed)
            }

            override fun onCurrentSecond(youTubePlayer: YouTubePlayer, second: Float) {
                // Handle current playback time (if needed)
            }

            override fun onError(youTubePlayer: YouTubePlayer, error: PlayerConstants.PlayerError) {

                d("ERROR",error.toString())            }

            override fun onPlaybackQualityChange(
                youTubePlayer: YouTubePlayer,
                playbackQuality: PlayerConstants.PlaybackQuality
            ) {
                // Handle playback quality change (if needed)
            }

            override fun onPlaybackRateChange(
                youTubePlayer: YouTubePlayer,
                playbackRate: PlayerConstants.PlaybackRate
            ) {
                // Handle playback rate change (if needed)
            }

            override fun onReady(youTubePlayer: YouTubePlayer) {
                // The player is ready, so load and play the video
                youTubePlayer.loadVideo(getVideoIdFromUrl(link), 0f)
            }

            override fun onStateChange(
                youTubePlayer: YouTubePlayer,
                state: PlayerConstants.PlayerState
            ) {
                // Handle player state changes (if needed)
            }

            override fun onVideoDuration(youTubePlayer: YouTubePlayer, duration: Float) {
                // Handle video duration (if needed)
            }

            override fun onVideoId(youTubePlayer: YouTubePlayer, videoId: String) {
                // Handle video ID (if needed)
            }

            override fun onVideoLoadedFraction(
                youTubePlayer: YouTubePlayer,
                loadedFraction: Float
            ) {
                // Handle video loaded fraction (if needed)
            }
        })
    }

    private fun getVideoIdFromUrl(url: String): String {
        // Extract the video ID from the YouTube URL
        val pattern = "(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%\u200C\u200B2F|youtu.be%2F|%2Fv%2F)[^#\\&\\?\\n]*"
        val compiledPattern = Pattern.compile(pattern)
        val matcher = compiledPattern.matcher(url)
        return if (matcher.find()) {
            matcher.group()
        } else {
            // Return a default video ID or handle errors as needed
            ""
        }
    }
}
