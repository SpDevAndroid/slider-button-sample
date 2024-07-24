package com.ncorti.slidetoact.example

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ncorti.slidetoact.SlideToActView
import com.ncorti.slidetoact.SlideToActView.OnSlideCompleteListener
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val TAG = "SLIDE_TEST"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handleSlideButtonView()

        //        ((TextView) findViewById(R.id.welcome_text)).setText("Welcome 😁");

//        findViewById(R.id.button_area_margin).setOnClickListener(this);
//        findViewById(R.id.button_icon_margin).setOnClickListener(this);
//        findViewById(R.id.button_colors).setOnClickListener(this);
//        findViewById(R.id.button_border_radius).setOnClickListener(this);
//        findViewById(R.id.button_elevation).setOnClickListener(this);
//        findViewById(R.id.button_text_size).setOnClickListener(this);
//        findViewById(R.id.button_slider_dimension).setOnClickListener(this);
//        findViewById(R.id.button_event_callbacks).setOnClickListener(this);
//        findViewById(R.id.button_locked_slider).setOnClickListener(this);
//        findViewById(R.id.button_custom_icon).setOnClickListener(this);
//        findViewById(R.id.button_reversed_slider).setOnClickListener(this);
//        findViewById(R.id.button_animation_duration).setOnClickListener(this);
//        findViewById(R.id.button_bump_vibration).setOnClickListener(this);
//        findViewById(R.id.button_completed).setOnClickListener(this);
//        findViewById(R.id.button_bounce).setOnClickListener(this);
    }

    private fun handleSlideButtonView() {
        val slideButtonView = findViewById<SlideToActView>(R.id.slide_button)
        slideButtonView.onSlideCompleteListener = object : OnSlideCompleteListener {
            override fun onSlideComplete(view: SlideToActView) {
                Log.d(TAG, "onSlideComplete()")
                view.sliderIcon = R.drawable.ic_slide_confirm

                lifecycleScope.launch {
                    delay(2000)

                    Log.d(TAG, "setCompleted(false, true) ")
                    view.setCompleted(false, true)
                    view.sliderIcon = R.drawable.ic_generate_slide_icon
                }
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.getItemId() == R.id.reset) {
//            ((SlideToActView) findViewById(R.id.welcome_slider)).setCompleted(false, true);
//        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(view: View) {
//        Intent intent = new Intent(MainActivity.this, SampleActivity.class);
//        intent.putExtra(SampleActivity.EXTRA_PRESSED_BUTTON, view.getId());
//        startActivity(intent);
    }
}
