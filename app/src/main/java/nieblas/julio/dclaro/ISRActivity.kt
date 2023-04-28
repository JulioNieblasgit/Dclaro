package nieblas.julio.dclaro

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ISRActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isractivity)


        val btn_isr: Button = findViewById(R.id.btn_isr)
        btn_isr.setOnClickListener{
            val intent: Intent = Intent(this, IVAActivity::class.java)
            startActivity(intent)

        }
    }
}