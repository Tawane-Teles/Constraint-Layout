package br.com.aneteles.constraintlayout

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ane.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ane)

        button_about.setOnClickListener { navigateToAbout() }
        img_button_face.setOnClickListener { navigateToFacebook() }
        img_button_insta.setOnClickListener { navigateToInstagram() }
        img_button_linkedin.setOnClickListener { navigateToLinkedin() }
        img_button_github.setOnClickListener { navigateToGitHub() }
    }

    private fun navigateToAbout() {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigateToFacebook() {
        openNetwork(
            "com.facebook.katana",
            "fb://facewebmodal/f?href=https://www.facebook.com/tawane.silvabarbosa",
            "https://www.facebook.com/tawane.silvabarbosa/"
        )
    }

    private fun navigateToInstagram() {
        openNetwork(
            "com.instagram.android",
            "http://instagram.com/_u/aneteles",
            "http://instagram.com/aneteles"
        )
    }

    private fun navigateToLinkedin() {
        openNetwork(
            "com.linkedin.android",
            "https://www.linkedin.com/in/tawane-silva-6660b58a/",
            "https://www.linkedin.com/in/tawane-silva-6660b58a/"
        )
    }

    private fun navigateToGitHub() {
        openNetwork(
            "","","https://github.com/Tawane-Teles"
        )
    }

    private fun openNetwork(
        appPackage: String,
        appAddress: String,
        webAddress: String
    ) {

        val uri = Uri.parse(appAddress)
        val intent = Intent(Intent.ACTION_VIEW, uri)

        intent.setPackage(appPackage)

        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            /*
             * Se não houver o aplicativo da rede
             * social acionada, então abra a página
             * no navegador padrão do aparelho, Web.
             * */
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(webAddress)
                )
            )
        }
    }
}

