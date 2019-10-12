package com.example.androidcapstone.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcapstone.R
import com.example.androidcapstone.model.responseclasses.newsposts.BlogsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_news.view.*

class NewsListAdapter(var blogsList : List<BlogsItem?>) : RecyclerView.Adapter<NewsListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false))

    override fun getItemCount(): Int = blogsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(blogsList[position])

    fun onNewsUpdate(list : List<BlogsItem?>){
        this.blogsList = list
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(blogsItem: BlogsItem?){
            Picasso.get().load("https:"+blogsItem?.thumbnail?.url).into(itemView.ivThumbnail)
            itemView.tvNewsTitle.text = blogsItem?.title
            itemView.tvAuthor.text = "by ${blogsItem?.author}"
            itemView.tvSummary.text = blogsItem?.summary
        }

    }
}