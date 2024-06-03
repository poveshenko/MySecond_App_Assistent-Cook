package com.example.test2.fragments_Main

import android.annotation.SuppressLint
import android.os.Bundle


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.test2.R
import com.example.test2.adapters.CommentAdapter
import com.example.test2.dataBase.CommentDatabase
import com.example.test2.dataBase.CommentModel
import com.example.test2.databinding.FragmentWishesBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WishesFragment : Fragment() {
    private lateinit var commentDatabase: CommentDatabase
    private lateinit var binding: FragmentWishesBinding
    private lateinit var commentAdapter: CommentAdapter
    private var isVisibility = false


    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View  {
        binding = FragmentWishesBinding.inflate(inflater, container, false)
        commentDatabase = CommentDatabase.getCommentDatabase(requireContext())

        commentAdapter = CommentAdapter(emptyList())
        binding.apply {
            recyclerViewComments.adapter = commentAdapter

            buttonCloseComment.setOnClickListener {

                if (isVisibility) {
                    val layoutParams2 = cardViewComment.layoutParams
                    layoutParams2.height = resources.getDimension(R.dimen.new_height_max).toInt()
                    cardViewComment.layoutParams = layoutParams2
                    buttonSendComment.visibility = View.VISIBLE
                    buttonCloseComment.visibility = View.INVISIBLE
                }
                isVisibility = !isVisibility
            }

            buttonSendComment.setOnClickListener {
                val name = editTextName.text.toString()
                val commentText = editTextComment.text.toString()

                val commentModel = CommentModel(name = name, textComment = commentText)


                GlobalScope.launch(Dispatchers.IO) {
                    commentDatabase.getDao().insertComment(commentModel)

                    val comments = commentDatabase.getDao().getAllComments()

                    withContext(Dispatchers.Main) {
                        commentAdapter.setData(comments)
                    }
                }
                val layoutParams = cardViewComment.layoutParams
                layoutParams.height = (R.dimen.new_height_min)
                cardViewComment.layoutParams = layoutParams
                buttonSendComment.visibility = View.INVISIBLE
                buttonCloseComment.visibility = View.VISIBLE


            }
        }
        return binding.root
    }
}