/*
 * Copyright 2014 Luuk Willemsen (Twinone)
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.twinone.irremote;

import org.twinone.irremote.ui.SelectRemoteLinearLayout;
import org.twinone.irremote.ui.SelectRemoteLinearLayout.OnSelectListener;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class SelectRemoteDialogFragment extends DialogFragment {

	private SelectRemoteLinearLayout mListView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (!(getActivity() instanceof OnSelectListener)) {
			throw new RuntimeException(
					"This fragment's parent activity must implement OnSelectedListener");
		}
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		AlertDialog.Builder ab = new AlertDialog.Builder(getActivity());
		View view = LayoutInflater.from(getActivity()).inflate(
				R.layout.dialog_select_remote, null, false);
		mListView = (SelectRemoteLinearLayout) view
				.findViewById(R.id.select_remote_listview);
		mListView.setOnSelectListener((OnSelectListener) getActivity());

		ab.setView(view);
		return ab.create();
	}

}