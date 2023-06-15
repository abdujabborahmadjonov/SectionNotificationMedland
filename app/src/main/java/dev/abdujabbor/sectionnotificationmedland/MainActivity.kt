package dev.abdujabbor.sectionnotificationmedland

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.abdujabbor.sectionnotificationmedland.adapters.RvAdapter
import dev.abdujabbor.sectionnotificationmedland.adapters.RvClick
import dev.abdujabbor.sectionnotificationmedland.databinding.ActivityMainBinding
import dev.abdujabbor.sectionnotificationmedland.databinding.RvItemNotificationBinding
import dev.abdujabbor.sectionnotificationmedland.models.ModelOfLis

class MainActivity : AppCompatActivity(), RvClick {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var adapter: RvAdapter
    lateinit var list: ArrayList<ModelOfLis>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bind = RvItemNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()
        for (i in 0..11) {
            list.add(
                ModelOfLis(
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    "https://live.staticflickr.com/4477/37752661931_fa0fa06fed.jpg", "",
                    vidImg = true, readBolean = false
                )
            )
            list.add(
                ModelOfLis(
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    "",
                    "4Admm5SIkE8",
                    vidImg = false, readBolean = false
                )
            )
        }
        adapter = RvAdapter(this, list, this)

        binding.recylerview.adapter = adapter

    }

    override fun click(moview: ModelOfLis, position: Int) {
        moview.readBolean = true
        Constants.data = moview
        Constants.data!!.readBolean = true
        startActivity(Intent(this, DescriptionActivity::class.java))
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}