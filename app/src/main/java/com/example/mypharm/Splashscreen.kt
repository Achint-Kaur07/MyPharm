import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import com.example.mypharm.Login
import com.example.mypharm.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val logoImage: ImageView = findViewById(R.id.logoImage)
        val fadeOut = AlphaAnimation(1.0f, 0.0f)
        fadeOut.duration = 1500 // 1.5 seconds fade-out effect
        fadeOut.fillAfter = true

        fadeOut.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                startActivity(Intent(this@SplashScreenActivity, Login::class.java))
                finish()
            }
            override fun onAnimationRepeat(animation: Animation?) {}
        })

        Handler().postDelayed({
            logoImage.startAnimation(fadeOut)
        }, 1500) // Show splash screen for 1.5 seconds before fade-out starts
    }
}
