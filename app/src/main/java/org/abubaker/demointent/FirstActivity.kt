package org.abubaker.demointent

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.abubaker.demointent.databinding.ActivityFirstBinding
import org.abubaker.demointent.databinding.ActivitySecondBinding

class FirstActivity : AppCompatActivity() {

    // Binding Object
    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)


    }
}