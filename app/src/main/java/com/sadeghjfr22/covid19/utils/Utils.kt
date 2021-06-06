package com.sadeghjfr22.covid19.utils

import android.app.Activity
import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.sadeghjfr22.covid19.base.App
import com.sadeghjfr22.covid19.base.App.Companion.getContext
import com.sadeghjfr22.covid19.model.Country
import com.sadeghjfr22.covid19.utils.Constants.TAG
import com.sadeghjfr22.covid19.view.fragment.CountryFragment.Companion.countries
import java.text.Collator
import java.text.SimpleDateFormat
import java.util.*

object Utils {

    fun translateCountryNames(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            for (item in countries){

                val country = Locale.Builder().setRegion(item.countryInfo.iso2).build()
                val persian = Locale.Builder().setLanguage("fa").build()
                item.country = country.getDisplayCountry(persian)
            }

            translateContinent()
            persianAlphabetically()
        }

        else fixSomeCountryNames()

    }

    fun fixSomeCountryNames(){

        for (item in countries){

            when(item.country){

                "Antigua and Barbuda" -> item.country = "Antigua & Barbuda"
                "British Virgin Islands" -> item.country = "Virgin Islands"
                "Caribbean Netherlands" -> item.country = "Caribbean"
                "Central African Republic" -> item.country = "Central African"
                "Falkland Islands (Malvinas)" -> item.country = "Falkland Islands"
                "Holy See (Vatican City State)" -> item.country = "Vatican"
                "Lao People's Democratic Republic" -> item.country = "Laos"
                "Libyan Arab Jamahiriya" -> item.country = "Libya"
                "Saint Vincent and the Grenadines" -> item.country = "Saint Vincent"
                "Saint Pierre Miquelon" -> item.country = "Saint Pierre"
                "Sao Tome and Principe" -> item.country = "Sao Tome"
                "Syrian Arab Republic" -> item.country = "Syria"
                "Turks and Caicos Islands" -> item.country = "Caicos Islands"

            }
        }
    }

    fun translateContinent(){

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
    }

    fun ImageView.loadImage(url: String) {

        val request = ImageRequest.Builder(this.context)
            .crossfade(true)
            .crossfade(500)
            .transformations(RoundedCornersTransformation(20f))
            .data(url)
            .target(this)
            .build()

        App.imageLoader.enqueue(request)
    }

    fun persianAlphabetically(){

        val items: MutableList<String> = ArrayList()

        for (item in countries){

            if(!item.country.equals("")) items.add(item.country)
        }

        val collator: Collator = Collator.getInstance(Locale("fa", "IR"))
        collator.setStrength(Collator.PRIMARY)
        Collections.sort(items, collator)

        val tmp: MutableList<Country> = ArrayList()
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

    }

    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(getContext()))
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun setLastUpdate(textView:TextView,updated:Long) {

        val formatter = SimpleDateFormat("MMM d  HH:mm");
        val dateString = formatter.format(Date(updated));

        textView.setText("last update :  "+dateString);
        val font = Typeface.createFromAsset(App.currentActivity.assets, "fonts/font_lalezar.ttf")
        textView.setTypeface(font)

    }

}