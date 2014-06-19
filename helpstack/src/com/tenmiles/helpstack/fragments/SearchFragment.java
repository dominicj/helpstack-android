package com.tenmiles.helpstack.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.tenmiles.helpstack.R;
import com.tenmiles.helpstack.model.HSKBItem;

/**
 * Search Fragment
 * 
 */
public class SearchFragment extends HSFragmentParent {

	private View rootView;
	private HSKBItem[] searchableKBArticle;

	public SearchFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		rootView =  inflater.inflate(R.layout.fragment_search, container, false);
		
		setVisibility(false);
		
		return rootView;
	}

	public void searchStarted() {
		// TODO Auto-generated method stub
		Log.v("search","started");
	}

	public void doSearchForQuery(String q) {
		// TODO Auto-generated method stub
		Log.v("search","do querry");
	}

	public void setVisibility(boolean visible) {
		if (visible) {
			rootView.setVisibility(View.VISIBLE);
		}
		else {
			rootView.setVisibility(View.GONE);
		}
	}

	public void setKBArticleList(HSKBItem[] fetchedKbArticles) {
		this.searchableKBArticle = fetchedKbArticles;
	}
	
	public void addSearchViewInMenuItem(Context context, MenuItem searchItem) {
		MenuItemCompat.setShowAsAction(searchItem, MenuItemCompat.SHOW_AS_ACTION_ALWAYS|MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
		SearchView searchView = new SearchView(context);
		MenuItemCompat.setActionView(searchItem, searchView);
		searchView.setQueryHint("Search");
		searchView.setSubmitButtonEnabled(true);

		searchView.setOnSearchClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				searchStarted();
			}
		});

		searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

			@Override
			public boolean onQueryTextSubmit(String q) {
				
				doSearchForQuery(q);
				
				return true;
			}

			@Override
			public boolean onQueryTextChange(String newText) {
				doSearchForQuery(newText);
				return true;
			}
		});


		MenuItemCompat.setOnActionExpandListener(searchItem, new OnActionExpandListener() {

			@Override
			public boolean onMenuItemActionExpand(MenuItem item) {
				setVisibility(true);
				return true;
			}

			@Override
			public boolean onMenuItemActionCollapse(MenuItem item) {
				setVisibility(false);
				return true;
			}
		});
	}

	
}
