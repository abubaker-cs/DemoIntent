package org.abubaker.demointent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import org.abubaker.demointent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Binding Object
    private lateinit var binding: ActivityMainBinding

    /**
     * It will be used to transfer data
     */
    companion object {
        private const val FIRST_ACTIVITY_REQUEST_CODE = 1
        private const val SECOND_ACTIVITY_REQUEST_CODE = 2

        const val NAME = "name"
        const val EMAIL = "email"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // First Activity (Listener)
        binding.btnLaunchActivityFirst.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            startActivityForResult(intent, FIRST_ACTIVITY_REQUEST_CODE)
        }

        // Second Activity (Listener)
        binding.btnLaunchActivitySecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE)
        }
    }

    // It will allow us to perform actions once the RESULTS will be returned from First/Second Activities
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == FIRST_ACTIVITY_REQUEST_CODE) {
                binding.tvFirstActivityResult.text = "First Activity Result Success"
            } else if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
                // catch the sent data
                if (data != null) {
                    val name = data.getStringExtra(NAME)
                    val email = data.getStringExtra(EMAIL)
                    binding.tvSecondActivityResult.text = "$name => $email"

                }

            }
        } else if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(this@MainActivity, "Result Cancelled", Toast.LENGTH_SHORT).show()
        }

    }

}