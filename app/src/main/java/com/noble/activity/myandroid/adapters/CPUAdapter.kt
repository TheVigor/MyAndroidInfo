package com.noble.activity.myandroid.adapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.noble.activity.myandroid.MainActivity
import com.noble.activity.myandroid.R
import com.noble.activity.myandroid.models.FeaturesHW

class CPUAdapter(private var appsList: ArrayList<FeaturesHW>, internal var mActivity: MainActivity) : RecyclerView.Adapter<CPUAdapter.DeviceVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceVH {
        val itemView = LayoutInflater.from(mActivity).inflate(R.layout.row_cpu_item, parent, false)
        return DeviceVH(itemView)
    }

    override fun onBindViewHolder(holder: DeviceVH, position: Int) {
        holder.bindData(appsList[position], position)

    }

    override fun getItemCount(): Int = appsList.size

    inner class DeviceVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bindData(featureHW: FeaturesHW, position: Int) {

            val tvFeatureName: TextView = itemView.findViewById(R.id.tv_cpu_feature_name)
            val tvFeatureValue: TextView = itemView.findViewById(R.id.tv_cpu_feature_value)
            val llCoreGrouper: LinearLayout = itemView.findViewById(R.id.llCoreGrouper)
            val tvCoreTitle: TextView = itemView.findViewById(R.id.tvCoreTitle)

            tvFeatureName.text = featureHW.featureLabel
            tvFeatureValue.text = featureHW.featureValue

            if (featureHW.featureLabel.equals("processor", true) && position >= 0) {
                try {
                    if (featureHW.featureValue.toInt() >= 0) {
                        llCoreGrouper.visibility = View.VISIBLE
                        tvCoreTitle.text = mActivity.resources.getString(R.string.core) +"\u0020"+ featureHW.featureValue
                    }
                } catch (e: Exception) {
                    llCoreGrouper.visibility = View.GONE
                }
            } else llCoreGrouper.visibility = View.GONE
        }
    }
}