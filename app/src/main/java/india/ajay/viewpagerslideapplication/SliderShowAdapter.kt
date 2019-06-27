package india.ajay.viewpagerslideapplication

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide

class SliderShowAdapter(private val context: Context): PagerAdapter() {

    var images = intArrayOf(R.drawable.angrybirds,
        R.drawable.asphalt8,
        R.drawable.clashofclans,
        R.drawable.cuttherope,
        R.drawable.fruitninja,
        R.drawable.pou,
        R.drawable.talkingtom,
        R.drawable.wheresmywhater,
        R.drawable.worms3)


    override fun isViewFromObject(view: View, any: Any): Boolean {
        return (view == any as LinearLayout)
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun instantiateItem(viewGroup: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.slide_show_layout, viewGroup, false)
        val imageView = view?.findViewById<ImageView>(R.id.image_view)
        imageView?.let {
            Glide.with(context).load(images[position]).into(it)
            it.setOnClickListener {
                //clicklistener
            }
        }

        //imageView?.setImageResource(images[position])
        viewGroup.addView(view)
        return  view
    }

    override fun destroyItem(container: ViewGroup, position: Int, any: Any) {
        container.removeView(any as LinearLayout)
    }

}