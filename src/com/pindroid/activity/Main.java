/*
 * PinDroid - http://code.google.com/p/PinDroid/
 *
 * Copyright (C) 2010 Matt Schmidt
 *
 * PinDroid is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation; either version 3 of the License,
 * or (at your option) any later version.
 *
 * PinDroid is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PinDroid; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 */

package com.pindroid.activity;

import com.pindroid.R;
import com.pindroid.action.IntentHelper;
import com.pindroid.fragment.MainFragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

public class Main extends FragmentBaseActivity implements MainFragment.OnMainActionListener {

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedState);
		setContentView(R.layout.main);
	}

	public void onMyBookmarksSelected() {
		startActivity(IntentHelper.ViewBookmarks("", null, null, this));	
	}

	public void onMyUnreadSelected() {
		startActivity(IntentHelper.ViewUnread(null, this));
	}

	public void onMyTagsSelected() {
		if(getResources().getBoolean(R.bool.has_two_panes)){
			startActivity(IntentHelper.ViewTabletTags(null, this));
		} else {
			startActivity(IntentHelper.ViewTags(null, this));
		}	
	}
	
	public void onMyNotesSelected() {
		startActivity(IntentHelper.ViewNotes(null, this));	
	}

	public void onMyNetworkSelected() {
		startActivity(IntentHelper.ViewBookmarks("", null, "network", this));	
	}

	public void onRecentSelected() {
		startActivity(IntentHelper.ViewBookmarks("", null, "recent", this));	
	}
	
	public void onPopularSelected() {
		startActivity(IntentHelper.ViewBookmarks("", null, "popular", this));	
	}
	
	@Override
	protected void changeAccount(){}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);

	    setupSearch(menu);
	    return true;
	}
}