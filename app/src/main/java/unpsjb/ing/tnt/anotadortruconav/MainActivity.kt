package unpsjb.ing.tnt.anotadortruconav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import unpsjb.ing.tnt.anotadortruconav.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        drawerLayout = binding.drawerLayout
        // val navController = this.findNavController(R.id.theNavHostFragment)  // <-- no funciona acá como en onSupportNavigateUp
        val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.theNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.navView, navController)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        setContentView(view)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.theNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
        //return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    }
}