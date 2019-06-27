package india.ajay.viewpagerslideapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.view.ViewPager
import me.relex.circleindicator.CircleIndicator
import java.util.*
import kotlin.concurrent.schedule


class MainActivity : AppCompatActivity() {

    private var toolBar: android.support.v7.widget.Toolbar? = null
    private var viewPager: ViewPager? = null
    private var sliderShowAdapter: SliderShowAdapter? = null
    private var circleIndicator: CircleIndicator? = null
    private var handler: Handler? = null
    private var runnable: Runnable? = null
    private var timer: Timer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
    }

    private fun setupView() {
        circleIndicator = findViewById(R.id.indicator)
        toolBar = findViewById(R.id.tool_bar)
        setSupportActionBar(toolBar)
        viewPager = findViewById(R.id.view_pager)
        sliderShowAdapter = SliderShowAdapter(this)
        viewPager?.adapter = sliderShowAdapter
        circleIndicator?.setViewPager(viewPager)

        handler = Handler()
        runnable = Runnable {
            var iCount = viewPager?.currentItem
            iCount = if(iCount == sliderShowAdapter?.images?.size?.minus(1)){
                0
            } else {
                iCount?.inc()
            }

            iCount?.let {
                viewPager?.setCurrentItem(it, true)
            }
        }
        timer = Timer()
        timer?.schedule(4000,4000) {
            handler?.post(runnable)
        }

    }
}
