package com.tackmobile.spacerocks.models;

import com.tackmobile.spacerocks.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

public class Missile {
	
	public Missile(Context context) {
		bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.player_missile);
	}
	
	public Bitmap bitmap;
	public Point point;

}
