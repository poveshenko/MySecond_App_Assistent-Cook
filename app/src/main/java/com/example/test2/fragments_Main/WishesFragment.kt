package com.example.test2.fragments_Main

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.test2.R
import com.example.test2.adapters.CommentAdapter
import com.example.test2.dataBase.CommentModel
import com.example.test2.dataBase.FirebaseService
import com.example.test2.databinding.FragmentWishesBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WishesFragment : Fragment() {
    private lateinit var firebaseService: FirebaseService
    private lateinit var binding: FragmentWishesBinding
    private lateinit var commentAdapter: CommentAdapter
    private var isVisibility = false

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWishesBinding.inflate(inflater, container, false)

        return binding.root
    }
}
//        firebaseService = FirebaseService(requireContext()) // Pass the context
//
//        commentAdapter = CommentAdapter(emptyList(), firebaseService)
//        binding.apply {
//            recyclerViewComments.adapter = commentAdapter
//
//            buttonOpenComment.setOnClickListener {
//                if (!isVisibility) {
//                    val layoutParams2 = cardViewComment.layoutParams
//                    layoutParams2.height = resources.getDimension(R.dimen.new_height_max).toInt()
//                    cardViewComment.layoutParams = layoutParams2
//                    buttonSendComment.visibility = View.VISIBLE
//                    buttonOpenComment.visibility = View.INVISIBLE
//                }
//                isVisibility = !isVisibility
//            }
//
//            binding.buttonSendComment.setOnClickListener {
//                val name = binding.enterTextName.text.toString()
//                val commentText = binding.enterTextComment.text.toString()
//
//                // Проверка заполненности полей
//                if (name.isEmpty() || commentText.isEmpty()) {
//                    Toast.makeText(requireContext(), "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show()
//                } else {
//                    val commentModel = CommentModel(name = name, textComment = commentText)
//                    Log.d("WishesFragment", "Отправка комментария: $commentModel")
//
//                    viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
//                        try {
//                            firebaseService.addComment(commentModel)
//                            Log.d("WishesFragment", "Комментарий добавлен успешно")
//
//                            // Обновляем список комментариев в адаптере
//                            updateComments()
//
//                            // Очистить поля ввода
//                            withContext(Dispatchers.Main) {
//                                binding.enterTextName.text.clear()
//                                binding.enterTextComment.text.clear()
//                            }
//                        } catch (e: Exception) {
//                            Log.e("WishesFragment", "Ошибка при добавлении комментария: ${e.message}")
//                        }
//                    }
//
//                    // Скрыть поле ввода комментариев
//                    val layoutParams = binding.cardViewComment.layoutParams
//                    layoutParams.height = resources.getDimension(R.dimen.new_height_min).toInt()
//                    binding.cardViewComment.layoutParams = layoutParams
//                    binding.buttonSendComment.visibility = View.INVISIBLE
//                    binding.buttonOpenComment.visibility = View.VISIBLE
//                }
//            }
//
//        }
//        return binding.root
//    }
//
//    override fun onStart() {
//        super.onStart()
//
//        // Загружаем комментарии из Firebase при старте фрагмента
//        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
//            try {
//                val comments = firebaseService.getComments()
//                Log.d("WishesFragment", "Загружено ${comments.size} комментариев при старте")
//                withContext(Dispatchers.Main) {
//                    commentAdapter.setData(comments)
//                }
//            } catch (e: Exception) {
//                Log.e("WishesFragment", "Ошибка при загрузке комментариев: ${e.message}")
//            }
//        }
//    }
//
//    // Метод для обновления списка комментариев в адаптере
//    private fun updateComments() {
//        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
//            try {
//                val comments = firebaseService.getComments()
//                Log.d("WishesFragment", "Загружено ${comments.size} комментариев после добавления")
//                withContext(Dispatchers.Main) {
//                    commentAdapter.setData(comments)
//                }
//            } catch (e: Exception) {
//                Log.e("WishesFragment", "Ошибка при обновлении списка комментариев: ${e.message}")
//            }
//        }
//    }
