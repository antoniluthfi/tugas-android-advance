package com.infinite.tugaskotlinadvance.pages.fetchapi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.infinite.tugaskotlinadvance.R
import com.infinite.tugaskotlinadvance.databinding.ActivityFetchApiBinding
import com.infinite.tugaskotlinadvance.pages.fetchapi.adapter.UserListAdapter
import com.infinite.tugaskotlinadvance.pages.fetchapi.model.UserData
import com.infinite.tugaskotlinadvance.pages.fetchapi.network.NetworkInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FetchApiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFetchApiBinding
    private lateinit var adapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFetchApiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = UserListAdapter()
        binding.usersRecyclerView.adapter = adapter
        binding.usersRecyclerView.layoutManager = LinearLayoutManager(this)

        fetchDataFromApi()
    }

    private fun fetchDataFromApi() {
        binding.progressBar.visibility = View.VISIBLE

        NetworkInstance.apiService.getUsers().enqueue(object : Callback<List<UserData>> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<List<UserData>>, response: Response<List<UserData>>) {
                binding.progressBar.visibility = View.GONE

                if (response.isSuccessful) {
                    val userList = response.body()
                    adapter.setUserList(userList)
                    adapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(this@FetchApiActivity, "Failed to fetch data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<UserData>>, t: Throwable) {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(this@FetchApiActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
