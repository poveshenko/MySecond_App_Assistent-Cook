package com.example.test2.fragments_Main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.test2.fragments_Recipes_Soup.FragmentSoup
import com.example.test2.fragments_Recipes_lunch.FragmentLunch
import com.example.test2.fragments_Recipes_salad.FragmentSalad
import com.example.test2.fragments_Recipes_snacks.FragmentSnacks
import com.example.test2.R
import com.example.test2.databinding.FragmentRecipesBinding
import com.example.test2.fragments_Recipes_Soup.FragmentSoupNumber1
import com.example.test2.fragments_Recipes_Soup.FragmentSoupNumber2
import com.example.test2.fragments_Recipes_Soup.FragmentSoupNumber3
import com.example.test2.fragments_Recipes_Soup.FragmentSoupNumber4
import com.example.test2.fragments_Recipes_Soup.FragmentSoupNumber5
import com.example.test2.fragments_Recipes_Soup.FragmentSoupNumber6
import com.example.test2.fragments_Recipes_Soup.FragmentSoupNumber7
import com.example.test2.fragments_Recipes_Soup.FragmentSoupNumber8
import com.example.test2.fragments_Recipes_Soup.FragmentSoupNumber9
import com.example.test2.fragments_Recipes_lunch.FragmentLunchNumber1
import com.example.test2.fragments_Recipes_lunch.FragmentLunchNumber2
import com.example.test2.fragments_Recipes_lunch.FragmentLunchNumber3
import com.example.test2.fragments_Recipes_lunch.FragmentLunchNumber4
import com.example.test2.fragments_Recipes_lunch.FragmentLunchNumber5
import com.example.test2.fragments_Recipes_lunch.FragmentLunchNumber6
import com.example.test2.fragments_Recipes_lunch.FragmentLunchNumber7
import com.example.test2.fragments_Recipes_lunch.FragmentLunchNumber8
import com.example.test2.fragments_Recipes_lunch.FragmentLunchNumber9
import com.example.test2.fragments_Recipes_salad.FragmentSaladNumber1
import com.example.test2.fragments_Recipes_salad.FragmentSaladNumber2
import com.example.test2.fragments_Recipes_salad.FragmentSaladNumber3
import com.example.test2.fragments_Recipes_salad.FragmentSaladNumber4
import com.example.test2.fragments_Recipes_salad.FragmentSaladNumber5
import com.example.test2.fragments_Recipes_salad.FragmentSaladNumber6
import com.example.test2.fragments_Recipes_salad.FragmentSaladNumber7
import com.example.test2.fragments_Recipes_salad.FragmentSaladNumber8
import com.example.test2.fragments_Recipes_salad.FragmentSaladNumber9
import com.example.test2.fragments_Recipes_snacks.FragmentSnackNumber1
import com.example.test2.fragments_Recipes_snacks.FragmentSnackNumber2
import com.example.test2.fragments_Recipes_snacks.FragmentSnackNumber3
import com.example.test2.fragments_Recipes_snacks.FragmentSnackNumber4
import com.example.test2.fragments_Recipes_snacks.FragmentSnackNumber5
import com.example.test2.fragments_Recipes_snacks.FragmentSnackNumber6

class RecipesFragment : Fragment() {

    //подключаем binding
    private lateinit var binding: FragmentRecipesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipesBinding.inflate(inflater, container, false)

        binding.apply {
            // Настройка обработчика для текста поиска
            editTextSearch.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    // Выполнение поиска по введенному тексту
                    val searchQuery = s.toString().trim()
                    // Не выполняем поиск автоматически здесь
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            })

            // Настройка обработчика для кнопки поиска
            buttonSearch.setOnClickListener {
                val searchQuery = editTextSearch.text.toString().trim().toLowerCase()
                if (searchQuery.isNotBlank()) {
                    performSearch(searchQuery)
                } else {
                    Toast.makeText(requireContext(), "Введите поисковый запрос", Toast.LENGTH_SHORT).show()
                }
            }

            // Настройка обработчиков для других элементов меню (frameLayoutSoup, frameLayoutSalad и т.д.)
            frameLayoutSoup.setOnClickListener {
                val fragment = FragmentSoup()
                navigateToFragment(fragment)
            }

            frameLayoutSalad.setOnClickListener {
                val fragment = FragmentSalad()
                navigateToFragment(fragment)
            }

            frameLayoutLunch.setOnClickListener {
                val fragment = FragmentLunch()
                navigateToFragment(fragment)
            }

            frameLayoutSnack.setOnClickListener {
                val fragment = FragmentSnacks()
                navigateToFragment(fragment)
            }
        }
        return binding.root
    }

    // Метод для выполнения поиска супов и обедов
    private fun performSearch(query: String) {
        val normalizedQuery = query.toLowerCase()

        val snackFragments = mapOf(
            "француский пирог" to FragmentSnackNumber1(),
            "драники" to FragmentSnackNumber2(),
            "тортилия" to FragmentSnackNumber3(),
            "ростбиф" to FragmentSnackNumber4(),
            "блинчики с курицей" to FragmentSnackNumber5(),
            "пирог" to FragmentSnackNumber6(),
//            "салат с уткой" to FragmentSaladNumber7(),
//            "нисуаз" to FragmentSaladNumber8(),
//            "марокканский" to FragmentSaladNumber9()
        )

        val saladFragments = mapOf(
            "винегрет" to FragmentSaladNumber1(),
            "мимоза" to FragmentSaladNumber2(),
            "салат с курицей" to FragmentSaladNumber3(),
            "вкусный" to FragmentSaladNumber4(),
            "крабовый" to FragmentSaladNumber5(),
            "гармония" to FragmentSaladNumber6(),
            "салат с уткой" to FragmentSaladNumber7(),
            "нисуаз" to FragmentSaladNumber8(),
            "марокканский" to FragmentSaladNumber9()
        )

        val soupFragments = mapOf(
            "литовский борщ" to FragmentSoupNumber4(),
            "харчо" to FragmentSoupNumber5(),
            "суп из фасоли" to FragmentSoupNumber6(),
            "венгерский суп" to FragmentSoupNumber7(),
            "азиатский суп" to FragmentSoupNumber3(),
            "крем суп" to FragmentSoupNumber2(),
            "суп куриный" to FragmentSoupNumber1(),
            "суп огуречный" to FragmentSoupNumber9(),
            "гаспачо" to FragmentSoupNumber8()
        )

        val lunchFragments = mapOf(
            "гречка с тушенкой, гречка" to FragmentLunchNumber1(),
            "Блинчики с курицей" to FragmentLunchNumber2(),
            "Паста с курицей, паста" to FragmentLunchNumber3(),// вывести две пасты
            "Перец фаршированый, перец" to FragmentLunchNumber4(),
            "жаркое из свинины, жаркое" to FragmentLunchNumber5(),
            "баклажаны по китайски, баклажаны" to FragmentLunchNumber6(),
            "Паста с фрикадельками, паста" to FragmentLunchNumber7(), // вывести две пасты
            "рагу" to FragmentLunchNumber8(),
            "Кабачки с начинкой, кабачки" to FragmentLunchNumber9()
        )

        val fragment = saladFragments[normalizedQuery]
            ?: snackFragments[normalizedQuery]
            ?: soupFragments[normalizedQuery]
            ?: lunchFragments.entries.find { entry ->
                val keywords = entry.key.split(", ").map { it.toLowerCase() }
                keywords.any { it == normalizedQuery }
            }?.value

        if (fragment != null) {
            // Найден фрагмент, переходим на него
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        } else {
            // Фрагмент не найден, можно вывести сообщение или обработать иначе
            Toast.makeText(requireContext(), "Ничего не найдено", Toast.LENGTH_SHORT).show()
        }
    }

    // Метод для навигации на фрагмент
    private fun navigateToFragment(fragment: Fragment) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
