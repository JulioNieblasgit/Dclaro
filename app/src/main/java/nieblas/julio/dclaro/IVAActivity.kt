package nieblas.julio.dclaro

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import nieblas.julio.dclaro.R.id.btn_iva

class IVAActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ivaactivity)

        val btn_iva: Button = findViewById(btn_iva)
        btn_iva.setOnClickListener{
            val intent: Intent = Intent(this, ObligacionesRegistradasActivity::class.java)
            startActivity(intent)

        }
    }
}