package nieblas.julio.dclaro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import nieblas.julio.dclaro.R.id.btn_agregafactura
import nieblas.julio.dclaro.R.id.btn_buscar

class AcuseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acuse)


        val btn_buscar: Button = findViewById(btn_buscar)
        btn_buscar.setOnClickListener{
            val intent: Intent = Intent(this,SeleccionFacturasActivity  ::class.java)
            startActivity(intent)

        }
    }
}