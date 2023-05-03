package nieblas.julio.dclaro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DeclaracionesCerosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_declaraciones_ceros)
        val btn_confirmar: Button = findViewById(R.id.btn_confirmar)
        btn_confirmar.setOnClickListener{
            val intent: Intent = Intent(this, DeclaracionProvisionalActivity::class.java)
            startActivity(intent)

        }
    }
}