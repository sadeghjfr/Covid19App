package com.sadeghjfr22.covid19.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.sadeghjfr22.covid19.R
import com.sadeghjfr22.covid19.ui.base.App
import com.sadeghjfr22.covid19.data.model.CountryModel
import java.text.Collator
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

object Utils {

    fun translateCountryNames(countries: ArrayList<CountryModel>): ArrayList<CountryModel>{

       for (item in countries){

           val country = Locale.Builder().setRegion(item.countryInfo.iso2).build()
           val persian = Locale.Builder().setLanguage("fa").build()
           item.country = country.getDisplayCountry(persian)
       }

       val countryItems1 = translateContinent(countries)
       val countryItems2 = persianAlphabetically(countryItems1)

        return countryItems2;
    }

    fun translateContinent(countries: ArrayList<CountryModel>): ArrayList<CountryModel>{

        for (item in countries){

            when(item.continent){

                "Asia" -> item.continent = "آسیا"
                "Europe" -> item.continent = "اروپا"
                "Africa" -> item.continent = "آفریقا"
                "North America" -> item.continent = "آمریکای شمالی"
                "South America" -> item.continent = "آمریکای جنوبی"
                "Australia-Oceania" -> item.continent = "استرالیا و اقیانوسیه"
            }
        }

        return countries;
    }

    fun ImageView.loadImage(url: String) {

        val request = ImageRequest.Builder(this.context)
            .crossfade(true)
            .crossfade(500)
            .transformations(RoundedCornersTransformation(20f))
            .data(url)
            .target(this)
            .error(R.drawable.ic_no_pic)
            .build()

        App.imageLoader.enqueue(request)
    }

    fun persianAlphabetically(countries: ArrayList<CountryModel>): ArrayList<CountryModel>{

        val items: MutableList<String> = ArrayList()

        for (item in countries){

            if(!item.country.equals("")) items.add(item.country)
        }

        val collator: Collator = Collator.getInstance(Locale("fa", "IR"))
        collator.setStrength(Collator.PRIMARY)
        Collections.sort(items, collator)

        val tmp: MutableList<CountryModel> = ArrayList()
        tmp.addAll(countries)
        countries.clear()

        for (name in items){

            for (country in tmp){

              if (name.equals(country.country)) {
                  countries.add(country)
                  tmp.remove(country)
                  break
              }

            }
        }

        items.clear()
        tmp.clear()

        return countries
    }

    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun setLastUpdate(textView:TextView,updated:Long) {

        val formatter = SimpleDateFormat("MMM d  HH:mm");
        val dateString = formatter.format(Date(updated));

        textView.setText("last update :  "+dateString);

    }

    fun decimalFormat() = DecimalFormat("###,###")

}