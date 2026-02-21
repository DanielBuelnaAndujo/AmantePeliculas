package buelna.daniel.amantepeliculas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etUsuario = findViewById<EditText>(R.id.etCuentaLogin)
        val etContraseña = findViewById<EditText>(R.id.etContraseñaLogin)
        val bEntrar = findViewById<Button>(R.id.bEntrarLogin)

        var usuario : String
        var contraseña : String
        bEntrar.setOnClickListener {
            usuario = etUsuario.getText().toString()
            contraseña = etContraseña.getText().toString()
            if (!usuario.isBlank() and !contraseña.isBlank()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Campos Invalidos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}