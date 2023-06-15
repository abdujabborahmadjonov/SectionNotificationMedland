package dev.abdujabbor.sectionnotificationmedland.adapters


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import dev.abdujabbor.sectionnotificationmedland.databinding.RvItemNotificationBinding
import dev.abdujabbor.sectionnotificationmedland.models.ModelOfLis

class RvAdapter(var context: Context, var list: ArrayList<ModelOfLis>, var rvClick: RvClick) :
    RecyclerView.Adapter<RvAdapter.VH>() {
    inner class VH(var itemViewBinding: RvItemNotificationBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(list: ModelOfLis, position: Int) {

            if (list.readBolean){
                itemViewBinding.card.setCardBackgroundColor(Color.WHITE)
            }else{
                itemViewBinding.card.setCardBackgroundColor(Color.parseColor("#4CAF50"))
            }
            itemViewBinding.BasicText.text = list.text
            if (list.vidImg) {
                Glide.with(context).load(list.img).into(itemViewBinding.imgNotificationImage)
                itemViewBinding.youtubePlayer.visibility = View.GONE
                itemViewBinding.imgNotificationImage.visibility = View.VISIBLE
            } else {
                itemViewBinding.youtubePlayer.visibility = View.VISIBLE
                itemViewBinding.imgNotificationImage.visibility = View.GONE
                itemViewBinding.youtubePlayer.addYouTubePlayerListener(object :
                    AbstractYouTubePlayerListener() {
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        youTubePlayer.loadVideo(list.video, 0f)
                    }
                })
            }
            itemViewBinding.root.setOnClickListener {
                rvClick.click(list, position)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {

        return VH(
            RvItemNotificationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

interface RvClick {
    fun click(moview: ModelOfLis, position: Int)
}