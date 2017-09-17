package com.app.islamicduaapp;

import com.google.android.gms.ads.AdSize;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ActivityHome extends Activity
{

	private LinearLayout list_names;
	private String[] arrData = new String[]
			{
			"1. For Morning & Evening" , 
			"2. At the time of difficulty when Sleeping" ,
			"3. After having a nightmare",
			"4. On awakening from sleep",
			"5. When entering the toilet",
			"6. When coming out of the toilet",
			"7. At the begining of making wudu",
			"8. On completion of wudu",
			"9. When going for Fajr Prayer",
			"10. When entering the Masjid",
			"11. After completion of prayer in Masjid",
			"12. On hearing the Athan",
			"13. Upon hearing the Muazzin give Athan",
			"14. After Witr Prayer",
			"15. After Chasht",
			"16. After Fajr",
			"17. When entering ones home",
			"18. When leaving the house",
			"19. When entering the Market",
			"20. When buying or selling at the Market",
			"21. Before meals",
			"22. After Meals",
			"23. At the time of lifting the table cloth",
			"24. When drinking milk",
			"25. At meal times when visiting someone",
			"26. When leaving the residence of the host",
			"27. When drinking water",
			"28. Drinking Zam Zam water",
			"29. When breaking fast",
			"30. After Iftaar",
			"31. Making Iftaar at someone's place",
			"32. When dressing",
			"33. When wearing new clothes",
			"34. When seeing a muslim in new clothes",
			"35. When looking in the mirror",
			"36. Arrival of a bride or a new animal",
			"37. Congratulating the bridegroom",
			"38. Intention of having relation with wife",
			"39. At the time of emission of sperm",
			"40. When the child begins to talk",
			"41. When sighting the new moon",
			"42. When Beginnig the Journey",
			"43. When someone is in a difficulty",
			"44. When one sees a muslim laughing",
			"45. When fearing the enemy",
			"46. When the enemy surrounds",
			"47. Before rising from a gathering",
			"48. When in any difficult",
			"49. For the progression of wealth",
			"fifty. Dua For the Night of Qadr",
			"51. Loving someone or when one helps",
			"52. When one sees the things one loves",
			"53. When one's heart is filled with emotion",
			"54. When something is lost",
			"55. When one talks too fast",
			"56. When eating new fruit of the season",
			"57. At the time of anger or when hearing a donkey or a dog",
			"58. Dua For Rain",
			"59. When one sees heavy clouds",
			"60. At the time of rain",
			"61. When rain exceeds the limits",
			"62. At the time of thunder",
			"63. At the time of heavy winds",
			"64. Talbiya of Hajj",
			"65. Dua to be read at Arafat",
			"66. While making Tawaaf",
			"67. When making Qurbani",
			"68. When meeting another Muslim",
			"69. Returning Salaam",
			"70. Dua when sneezing",
			"71. When hearing someone sneeze",
			"72. Upon the thought of a bad omen",
			"73. Dua to pay off debts",
			"74. Dua after salaat of need",
			"75. Istikhara",
			"76. When visiting the sick",
			"77. For any calamity",
			"78. For the cure of any illness",
			"79. To soothe ill children",
			"80. Dua by an ill person",
			"81. When death is eminent",
			"82. When the soul is leaving the body",
			"83. When the soul has left the body",
			"84. When going to the deceased house",
			"85. When someone child die",
			"86. When burying the dead",
			"87. When entering the cemetry",
			"88. When consoling someone",
			"89. At the time of fire",
			"90. For any animal",
			"91. For pain of the eye",
			"92. For kidney stone or urination problems",
			"93. When fever or pain increases",
			"94. Dua on a burn injury",
			"95. When tired of life",
			"96. During wudu",
			"97. Istikhara for Marriage",
	};

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		list_names = (LinearLayout) findViewById(R.id.list_names);
		TextView txtHeader = (TextView) findViewById(R.id.txtHeader);
		setFontTextView(txtHeader , "Hobo.ttf");

		for(int i = 0 ; i < arrData.length ; i++){

			TextView txtHeading = new TextView(this);
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 70);
			txtHeading.setLayoutParams(lp);
			txtHeading.setGravity(Gravity.CENTER_VERTICAL);

			txtHeading.setText(arrData[i]);
			txtHeading.setTextSize(17);
			txtHeading.setTag(i);
			txtHeading.setTextColor(getResources().getColor(android.R.color.black));
			txtHeading.setBackgroundResource(R.drawable.namzlist_back);
			txtHeading.setPadding(10,0,10,0);
			setFontTextView(txtHeading , "Hobo.ttf");

			
			txtHeading.setOnClickListener(new View.OnClickListener() {				
				@Override
				public void onClick(final View v) {
					((TextView) v).setTextColor(getResources().getColor(R.color.blue));
					 Thread background = new Thread() {
				            public void run() {
				                try {
				                    sleep((long) (0.1 * 1000));
				                    int tag = (Integer) v.getTag();
									Intent i = new Intent(ActivityHome.this , ActivityImage.class);
									i.putExtra("ImageNumber", tag);
									startActivity(i);
									((TextView) v).setTextColor(getResources().getColor(android.R.color.black));
				                } catch (Exception ignored) {
				                }
				            }
				        };
				        background.start();
				}
			});
			list_names.addView(txtHeading);
		}



		InternetDetector cd = new InternetDetector(getApplicationContext());
		if(cd.isConnectingToInternet())
		{
		/*showAdd();*/
		}
	}


	 public static void setFontTextView(TextView txtView, String fontName)
	 {
	        Typeface tf = Typeface.createFromAsset(txtView.getContext().getAssets(), fontName);
	        txtView.setTypeface(tf);
	    }
}

