package nieblas.julio.dclaro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btn_entrar: Button = findViewById(R.id.btn_entrar)
        btn_entrar.setOnClickListener{
            val intent: Intent = Intent(this, DeclaracionesPagadasActivity::class.java)
            startActivity(intent)

        }
    }
}