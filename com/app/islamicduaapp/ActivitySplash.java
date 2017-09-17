package com.app.islamicduaapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;


public class ActivitySplash extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		if(isWorkingInternetPersent())
		{
			splash();
		}

		else
		{
			showAlertDialog(ActivitySplash.this, "Internet Connection", "You don't have internet connection", false);
		}
	}

	public void splash()
	{
		 Thread background = new Thread()
		 {
	            public void run()
				{
	                try
					{
	                    sleep(2 * 1000);
	                    Intent i = new Intent(getBaseContext(), ActivityHome.class);
	                    startActivity(i);
	                    finish();
	                }

					catch (Exception ignored)
					{

	                }
	            }
	        };

	        background.start();
	}

	public boolean isWorkingInternetPersent()
	{
		ConnectivityManager connectivityManager = (ConnectivityManager) getBaseContext().getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivityManager != null)
		{
			NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
			if (info != null)
				for (NetworkInfo anInfo : info)
					if (anInfo.getState() == NetworkInfo.State.CONNECTED)
					{
						return true;
					}
		}

		return false;
	}

	public void showAlertDialog(Context context, String title, String message, Boolean status)
	{
		AlertDialog alertDialog = new AlertDialog.Builder(context).create();
		// Setting Dialog Title
		alertDialog.setTitle(title);
		// Setting Dialog Message
		alertDialog.setMessage(message);
		// Setting OK Button
		alertDialog.setButton("OK", new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int which)
			{
				finish();
				System.exit(0);
			}
		});
		// Showing Alert Message
		alertDialog.show();
	}

	}
