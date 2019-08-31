package activity

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.kotlin_fundamental.R
import com.example.android.kotlin_fundamental.databinding.ActivityAboutMeBinding
import entity.MyName

class AboutMeActivity : AppCompatActivity() {
//    private lateinit var editText: EditText
//    private lateinit var nicknameTextView: TextView
//    private lateinit var doneButton: Button

    private lateinit var binding: ActivityAboutMeBinding
    private val myName = MyName(name = "Takuya Yokoyama", nickname = "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_about_me)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_about_me)
        binding.myName = myName

//        editText = findViewById(R.id.nickname_edit)
//        nicknameTextView = findViewById(R.id.nickname_text)
//        doneButton = findViewById(R.id.done_button)

        // XMLで `android:onClick` 属性を指定することでも実現できる
//        doneButton.setOnClickListener { addNickname(it) }
//        nicknameTextView.setOnClickListener { updateNickname(it) }
        binding.apply {
            doneButton.setOnClickListener { addNickname() }
            nicknameText.setOnClickListener { updateNickname() }
        }
    }

    private fun addNickname(/*view: View*/) {
//        nicknameTextView.text = editText.text
//
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        nicknameTextView.visibility = View.VISIBLE
//
//        hideKeyboard(view)

        binding.apply {
            myName?.nickname = binding.nicknameEdit.text.toString()
            invalidateAll() // UIに反映させる必要がある

            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        hideKeyboard(binding.doneButton)
    }

    private fun updateNickname(/*view: View*/) {
//        editText.visibility = View.VISIBLE
//        doneButton.visibility = View.VISIBLE
//        view.visibility = View.GONE
//
//        showKeyboard(editText)

        binding.apply {
            nicknameEdit.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE
            nicknameText.visibility = View.GONE
        }

        showKeyboard(binding.nicknameEdit)
    }

    private fun showKeyboard(view: View) {
        view.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, 0)
    }

    private fun hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
