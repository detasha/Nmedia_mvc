package ru.netology.nmedia.activity

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.dto.countFormat
import ru.netology.nmediaproject.R
import ru.netology.nmediaproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась " +
                    "с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, " +
                    "разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: " +
                    "от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим," +
                    "что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее." +
                    "Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая 2020",
            likesCount = 0,
            sharesCount = 0,
            viewsCount = 7,
            likedByMe = false
        )

        with(binding) {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            likeCount.text = countFormat(post.likesCount)
            shareCount.text = countFormat(post.sharesCount)
            viewsCount.text = countFormat(post.viewsCount)

            if (post.likedByMe) {
                like?.setImageResource(R.drawable.ic_baseline_favorite_24)
            }

            like?.setOnClickListener {
                post.likedByMe = !post.likedByMe
                if (post.likedByMe) {
                    like.setImageResource(R.drawable.ic_baseline_favorite_24)
                    likeCount.text = countFormat(post.likesCount + 1)
                } else {
                    like.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                    likeCount.text = countFormat(post.likesCount)
                }
            }

                share?.setOnClickListener {
                    shareCount.text = countFormat(post.sharesCount + 1)
                }


        }
    }
}