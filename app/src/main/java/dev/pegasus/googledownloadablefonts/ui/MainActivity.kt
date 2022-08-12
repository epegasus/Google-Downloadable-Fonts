package dev.pegasus.googledownloadablefonts.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.pegasus.googledownloadablefonts.databinding.ActivityMainBinding
import dev.pegasus.googledownloadablefonts.helper.FontManager

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val fontManager by lazy { FontManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Replace the Query Tag, "Alex Brush" with your font name..
        // Get Font name:
        //  - res > font > alex_brush > Line # 5
        fontManager.applyFont("Alex Brush", binding.tvNameMain)
    }
}