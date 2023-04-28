package nieblas.julio.dclaro

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import nieblas.julio.dclaro.R.*
import nieblas.julio.dclaro.R.id.*

class InicioActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_inicio)
        //se ocupa hacer algo
        val btn_inicio: Button = findViewById(btn_inicio)
        btn_inicio.setOnClickListener{
            val intent: Intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }
    }
}