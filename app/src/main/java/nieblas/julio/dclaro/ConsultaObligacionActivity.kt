package nieblas.julio.dclaro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ConsultaObligacionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta_obligacion)

        val btn_oregistrada: Button = findViewById(R.id.btn_oregistrada)
        btn_oregistrada.setOnClickListener{
            val intent: Intent = Intent(this,ConsultaObligacionActivity  ::class.java)
            startActivity(intent)

        }
    }
}