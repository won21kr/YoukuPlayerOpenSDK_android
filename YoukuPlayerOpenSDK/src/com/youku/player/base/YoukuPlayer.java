package com.youku.player.base;

import android.util.Log;

import com.youku.player.apiservice.ICacheInfo;
import com.youku.player.apiservice.IUserInfo;
import com.youku.player.apiservice.IVideoHistoryInfo;
import com.youku.player.goplay.Profile;
import com.youku.player.ui.interf.IMediaPlayerDelegate;
import com.youku.player.util.PlayerUtil;

public class YoukuPlayer {

	public IMediaPlayerDelegate mMediaPlayerDelegate;
	YoukuBasePlayerActivity activity;

	public YoukuPlayer(YoukuBasePlayerActivity mYoukuBaseActivity) {
		super();
		activity = mYoukuBaseActivity;
		mMediaPlayerDelegate = mYoukuBaseActivity.getMediaPlayerDelegate();

	}

	public IMediaPlayerDelegate getmMediaPlayerDelegate() {
		return this.mMediaPlayerDelegate;
	}

	/**
	 * 通过vid播放视频
	 * 
	 * @param vid
	 */
	public void playVideo(final String vid) {
		Log.d("sgh","[YoukuPlayer] playVideo(final String vid)");
		mMediaPlayerDelegate.playVideo(vid);
	}

	/**
	 * 通过vid和playlist_id播放视频
	 * 
	 * @param vid
	 * @param playlistId
	 */
	public void playVideo(final String vid, final String playlistId) {
		Log.d("sgh","[YoukuPlayer] playVideo(final String vid, final String playlistId)");
		mMediaPlayerDelegate.playVideo(vid, playlistId);
	}

	/**
	 * 通过vid和视频的password播放加密视频
	 * @param vid
	 * @param password
	 */
	public void playVideoWithPassword(final String vid, final String password) {
		Log.d("sgh","[YoukuPlayer] playVideoWithPassword");
		mMediaPlayerDelegate.playVideoWithPassword(vid, password);
	}


}
