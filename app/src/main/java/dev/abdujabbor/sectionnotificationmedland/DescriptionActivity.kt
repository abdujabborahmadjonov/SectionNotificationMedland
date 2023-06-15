package dev.abdujabbor.sectionnotificationmedland

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.abdujabbor.sectionnotificationmedland.databinding.ActivityDescriptionBinding

class DescriptionActivity : AppCompatActivity() {
    val binding by lazy { ActivityDescriptionBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.text.text = Constants.data?.text
    }
}