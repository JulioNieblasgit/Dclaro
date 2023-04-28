package nieblas.julio.dclaro

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import nieblas.julio.dclaro.R.*

class ObligacionesRegistradasActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_obligaciones_registradas)


        val btn_buscar: Button = findViewById(id.btn_buscar)
        btn_buscar.setOnClickListener{
            val intent: Intent = Intent(this,AcuseActivity  ::class.java)
            startActivity(intent)

        }
    }
}