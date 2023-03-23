import org.gradle.api.JavaVersion

// App level config constants
object AppConfig {
    const val compileSdk = 31
    const val minSdk = 21
    const val targetSdk = 31
    const val applicationId = "com.exam.randomuser"
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"

    val javaJvmTarget = JavaVersion.VERSION_11.toString()
    val javaCompatibility = JavaVersion.VERSION_11
}