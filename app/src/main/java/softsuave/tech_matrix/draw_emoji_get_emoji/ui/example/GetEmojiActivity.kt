package softsuave.tech_matrix.draw_emoji_get_emoji.ui.example

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import softsuave.tech_matrix.draw_emoji_get_emoji.R
import softsuave.tech_matrix.draw_emoji_get_emoji.databinding.GetEmojiActivityBinding
import softsuave.tech_matrix.draw_emoji_get_emoji.ui.DrawEmojiActivity

class GetEmojiActivity : AppCompatActivity() {
    private var _binding: GetEmojiActivityBinding? = null
    private val binding by lazy { _binding!! }
    private val REQUEST_EMOJI_ICON_CODE = 1234
    private val drawEmojiLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == REQUEST_EMOJI_ICON_CODE) {
                val data: Intent? = result.data
                val selectedEmoji = data?.getStringExtra("selectedEmoji")
                binding.emojiIcon.text = selectedEmoji
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = GetEmojiActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.getEmojiButton.setOnClickListener {
            //From Activity
            val intent = Intent(this, DrawEmojiActivity::class.java)
            drawEmojiLauncher.launch(intent)

            //Call From Fragment
/*            val fragment = GetEmojiFragment()
            val bundle = Bundle()
            fragment.arguments = bundle

            // Add the fragment to the activity
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()*/
        }
    }
}