package com.example.androidcapstone.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcapstone.R
import com.example.androidcapstone.model.responseclasses.newsposts.BlogsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_news.view.*
import java.text.SimpleDateFormat
import java.util.*

class NewsListAdapter(var blogsList : List<BlogsItem?>) : RecyclerView.Adapter<NewsListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false))

    override fun getItemCount(): Int = blogsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(blogsList[position])

    fun onNewsUpdate(list : List<BlogsItem?>){
        this.blogsList = list
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

        fun bind(blogsItem: BlogsItem?){
            Picasso.get().load("https:"+blogsItem?.thumbnail?.url).into(itemView.ivThumbnail)
            itemView.tvNewsTitle.text = blogsItem?.title
            itemView.tvAuthor.text = String.format("by %s", blogsItem?.author)
            itemView.tvSummary.text = blogsItem?.summary

            val date = blogsItem?.created
            val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.US)
            itemView.tvDate.text = sdf.format(date)

            itemView.setOnClickListener(this)
        }

        override fun onClick(view : View?) {

        }

    }
}