package com.example.roomwordsample2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.roomwordsample2.databinding.ActivityNewWordBinding

class NewWordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewWordBinding
    private lateinit var editWordView: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewWordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        editWordView = binding.etWord

        val button = binding.btnSave
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = editWordView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}