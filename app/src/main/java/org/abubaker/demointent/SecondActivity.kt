package org.abubaker.demointent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.abubaker.demointent.databinding.ActivityMainBinding
import org.abubaker.demointent.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    // Binding Object
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)

        // Send back some info to the MAIN Activity
        binding.btnSubmit.setOnClickListener {

            val intent = Intent()

            // Key, Value
            intent.putExtra(MainActivity.NAME, binding.etName.text.toString())
            intent.putExtra(MainActivity.EMAIL, binding.etEmail.text.toString())

            // Send data back to the Main Activity
            setResult(Activity.RESULT_OK, intent)
         
        }

    }


}