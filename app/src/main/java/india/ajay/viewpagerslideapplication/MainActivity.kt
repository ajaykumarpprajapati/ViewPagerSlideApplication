package india.ajay.viewpagerslideapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager


class MainActivity : AppCompatActivity() {

    private var toolBar: android.support.v7.widget.Toolbar? = null
    private var viewPager: ViewPager? = null
    private var sliderShowAdapter: SliderShowAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
    }

    private fun setupView() {
        toolBar = findViewById(R.id.tool_bar)
        setSupportActionBar(toolBar)
        viewPager = findViewById(R.id.view_pager)
        sliderShowAdapter = SliderShowAdapter(this)
        viewPager?.adapter = sliderShowAdapter
    }
}
