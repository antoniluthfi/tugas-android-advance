package com.infinite.tugaskotlinadvance.pages.fetchapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.infinite.tugaskotlinadvance.databinding.UserItemBinding
import com.infinite.tugaskotlinadvance.pages.fetchapi.model.UserData

class UserListAdapter() :
    RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {
    private var userList: List<UserData>? = null

    fun setUserList(userList: List<UserData>?) {
        this.userList = userList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if (userList == null) {
            return 0
        }

        return userList?.size!!
    }

    inner class MyViewHolder(itemView: UserItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val binding = itemView

        fun bind(data: UserData) {
            with(binding) {
                Glide.with(itemView)
                    .load(data.avatar)
                    .into(imgUserAvatar)
                binding.tvUsername.text = data.name
            }
        }
    }
}