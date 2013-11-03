package com.tackmobile.androidpiano.view;

import com.tackmobile.androidpiano.audio.PdInterface;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;

public class KeysView extends ViewGroup implements OnTouchListener {

	private Key[] whiteKeys;
	private Key[] blackKeys;

	public KeysView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setBackgroundColor(context.getResources().getColor(android.R.color.black));
		blackKeys = new Key[5];
		whiteKeys = new Key[7];
		for (int i = 0; i < 7; i++) {
			whiteKeys[i] = new Key(context, 60, false);
			whiteKeys[i].setOnTouchListener(this);
			addView(whiteKeys[i]);
		}
		for (int i = 0; i < 5; i++) {
			blackKeys[i] = new Key(context, 66, true);
			blackKeys[i].setOnTouchListener(this);
			addView(blackKeys[i]);
		}
		whiteKeys[0].setMidiNote(60);
		blackKeys[0].setMidiNote(61);
		whiteKeys[1].setMidiNote(62);
		blackKeys[1].setMidiNote(63);
		whiteKeys[2].setMidiNote(64);
		whiteKeys[3].setMidiNote(65);
		blackKeys[2].setMidiNote(66);
		whiteKeys[4].setMidiNote(67);
		blackKeys[3].setMidiNote(68);
		whiteKeys[5].setMidiNote(69);
		blackKeys[4].setMidiNote(70);
		whiteKeys[6].setMidiNote(71);
	}
	
	@Override public boolean onTouch(View v, MotionEvent event) {
		Key key = (Key)v;
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			int note = key.getMidiNote();
			PdInterface.getInstance().gateOn(note);
			return true;
		} else if (event.getAction() == MotionEvent.ACTION_UP) {
			PdInterface.getInstance().gateOff();
			return true;
		}
		return false;
	}

	@Override protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		int height  = getHeight();
		int whiteKeyHeight = height/7;
		int currentKeyBottom = getBottom();
		for (int i = 0; i < whiteKeys.length; i++) {
			whiteKeys[i].setLeft(0);
			whiteKeys[i].setRight(getRight());
			whiteKeys[i].setTop(currentKeyBottom - whiteKeyHeight - i);
			whiteKeys[i].setBottom(currentKeyBottom - i);
			currentKeyBottom -= whiteKeyHeight;
		}
		int t, b;
		int r = getRight() - (int)(getWidth()*0.3);
		Key whiteKey = whiteKeys[0];
		b = whiteKey.getBottom() - (int)(whiteKey.getHeight()/1.5);
		whiteKey = whiteKeys[1];
		t = whiteKey.getTop() + (int)(whiteKey.getHeight()/1.5);
		blackKeys[0].setTop(t);
		blackKeys[0].setBottom(b);
		blackKeys[0].setLeft(0);
		blackKeys[0].setRight(r);
		b = whiteKey.getBottom() - (int)(whiteKey.getHeight()/1.5);
		whiteKey = whiteKeys[2];
		t = whiteKey.getTop() + (int)(whiteKey.getHeight()/1.5);
		blackKeys[1].setTop(t);
		blackKeys[1].setBottom(b);
		blackKeys[1].setLeft(0);
		blackKeys[1].setRight(r);
		whiteKey = whiteKeys[3];
		b = whiteKey.getBottom() - (int)(whiteKey.getHeight()/1.5);
		whiteKey = whiteKeys[4];
		t = whiteKey.getTop() + (int)(whiteKey.getHeight()/1.5);
		blackKeys[2].setTop(t);
		blackKeys[2].setBottom(b);
		blackKeys[2].setLeft(0);
		blackKeys[2].setRight(r);
		b = whiteKey.getBottom() - (int)(whiteKey.getHeight()/1.5);
		whiteKey = whiteKeys[5];
		t = whiteKey.getTop() + (int)(whiteKey.getHeight()/1.5);
		blackKeys[3].setTop(t);
		blackKeys[3].setBottom(b);
		blackKeys[3].setLeft(0);
		blackKeys[3].setRight(r);
		b = whiteKey.getBottom() - (int)(whiteKey.getHeight()/1.5);
		whiteKey = whiteKeys[6];
		t = whiteKey.getTop() + (int)(whiteKey.getHeight()/1.5);
		blackKeys[4].setTop(t);
		blackKeys[4].setBottom(b);
		blackKeys[4].setLeft(0);
		blackKeys[4].setRight(r);
	}



}