package com.sadeghjfr22.covid19.utils

import android.app.Activity
import android.content.Context
import android.os.Build
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import androidx.fragment.app.Fragment
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.sadeghjfr22.covid19.base.App
import com.sadeghjfr22.covid19.base.App.Companion.getContext
import com.sadeghjfr22.covid19.model.Country
import com.sadeghjfr22.covid19.utils.Constants.TAG
import com.sadeghjfr22.covid19.view.fragment.CountryFragment.Companion.allCountries
import java.text.Collator
import java.util.*

object Utils {

    fun fixSomeCountryNames(){

        for (item in allCountries){

            when(item.name){

                "سریر مقدس" -> item.name = "واتیکان"
                "کره شمالی" -> item.name = "کره جنوبی"
                "" -> item.name = "مقدونیه شمالی"
                "پادشاهی هلند" -> item.name = "هلند"
                "جزایر الندفیلیپین" -> item.name = "فیلیپین"
                "وکراین" -> item.name = "اوکراین"
                "بریتانیای کبیر و ایرلند شمالی" -> item.name = "انگلستان"
            }
        }
    }

    fun translateRegion(){

        for (item in allCountries){

            when(item.region){

                "Asia" -> item.region = "آسیا"
                "Europe" -> item.region = "اروپا"
                "Africa" -> item.region = "آفریقا"
                "Americas" -> item.region = "آمریکا"
                "Oceania" -> item.region = "اقیانوسیه"
            }
        }
    }

    fun translateCapital(){

        for (item in allCountries){

            when(item.capital){

                "Kabul" -> item.capital = "کابل"
                "Tirana" -> item.capital = "تیرانا"
                "Algiers" -> item.capital = "الجزیره"
                "Andorra la Vella" -> item.capital = "آندورا لاولا"
                "Luanda" -> item.capital = "لوآندا"
                "Saint John's" -> item.capital = "سینت جانز"
                "Buenos Aires" -> item.capital = "بوئنوس آیرس"
                "Yerevan" -> item.capital = "ایروان"
                "Canberra" -> item.capital = "کانبرا"
                "Vienna" -> item.capital = "وین"
                "Baku" -> item.capital = "باکو"
                "Nassau" -> item.capital = "ناسائو"
                "Manama" -> item.capital = "منامه"
                "Dhaka" -> item.capital = "داکا"
                "Bridgetown" -> item.capital = "بریج تاون"
                "Minsk" -> item.capital = "مینسک"
                "Brussels" -> item.capital = "بروکسل"
                "Belmopan" -> item.capital = "بلموپان"
                "Porto-Novo" -> item.capital = "پورتو نووو"
                "Thimphu" -> item.capital = "تیمفو"
                "Sucre" -> item.capital = "سوکره"
                "Sarajevo" -> item.capital = "سارایوو"
                "Gaborone" -> item.capital = "گابورون"
                "Brasília" -> item.capital = "برازیلیا"
                "Bandar Seri Begawan" -> item.capital = "بندر سری بگاوان"
                "Sofia" -> item.capital = "صوفیه"
                "Ouagadougou" -> item.capital = "آواگادوگو"
                "Bujumbura" -> item.capital = "بوجومبورا"
                "Phnom Penh" -> item.capital = "پنوم پن"
                "Yaoundé" -> item.capital = "یائونده"
                "Ottawa" -> item.capital = "اتاوا"
                "Praia" -> item.capital = "پرایا"
                "Bangui" -> item.capital = "بانگی"
                "N'Djamena" -> item.capital = "انجامنا"
                "Santiago" -> item.capital = "سانتیاگو"
                "Beijing" -> item.capital = "پکن"
                "Bogotá" -> item.capital = "بوگوتا"
                "Moroni" -> item.capital = "مورونی"
                "Brazzaville" -> item.capital = "برازاویل"
                "Kinshasa" -> item.capital = "کینشاسا"
                "San José" -> item.capital = "سان خوزه"
                "Zagreb" -> item.capital = "زاگرب"
                "Havana" -> item.capital = "هاوانا"
                "Nicosia" -> item.capital = "نیکوزیا"
                "Prague" -> item.capital = "پراگ"
                "Yamoussoukro" -> item.capital = "یاموسوکرو"
                "Copenhagen" -> item.capital = "کپنهاگ"
                "Djibouti" -> item.capital = "جیبوتی"
                "Roseau" -> item.capital = "روسو"
                "Santo Domingo" -> item.capital = "سانتو دومینگو"
                "Quito" -> item.capital = "کیتو"
                "Cairo" -> item.capital = "قاهره"
                "San Salvador" -> item.capital = "سان سالوادور"
                "Malabo" -> item.capital = "مالابو"
                "Asmara" -> item.capital = "اسمره"
                "Tallinn" -> item.capital = "تالین"
                "Addis Ababa" -> item.capital = "آدیس آبابا"
                "Suva" -> item.capital = "سووا"
                "Helsinki" -> item.capital = "هلسینکی"
                "Paris" -> item.capital = "پاریس"
                "Libreville" -> item.capital = "لیبرویل"
                "Banjul" -> item.capital = "بانجول"
                "Tbilisi" -> item.capital = "تفلیس"
                "Berlin" -> item.capital = "برلین"
                "Accra" -> item.capital = "آکرا"
                "Athens" -> item.capital = "آتن"
                "St. George's" -> item.capital = "سینت جورجس"
                "Guatemala City" -> item.capital = "گواتمالا سیتی"
                "Conakry" -> item.capital = "کوناکری"
                "Bissau" -> item.capital = "بیسائو"
                "Georgetown" -> item.capital = "جرج تاون"
                "Port-au-Prince" -> item.capital = "پورتو پرنس"
                "Tegucigalpa" -> item.capital = "تگوسیگالپا"
                "Budapest" -> item.capital = "بوداپست"
                "Reykjavík" -> item.capital = "ریکیاویک"
                "New Delhi" -> item.capital = "دهلی نو"
                "Jakarta" -> item.capital = "جاکارتا"
                "Tehran" -> item.capital = "تهران"
                "Baghdad" -> item.capital = "بغداد"
                "Dublin" -> item.capital = "دوبلین"
                "Jerusalem" -> item.capital = "اورشلیم"
                "Rome" -> item.capital = "رم"
                "Kingston" -> item.capital = "کینگستون"
                "Tokyo" -> item.capital = "توکیو"
                "Amman" -> item.capital = "عمان ( امان )"
                "Astana" -> item.capital = "آستانه ( نور سلطان )"
                "Nairobi" -> item.capital = "نایروبی"
                "Seoul" -> item.capital = "سئول"
                "Kuwait City" -> item.capital = "کویت"
                "Bishkek" -> item.capital = "بیشکک"
                "Vientiane" -> item.capital = "وینتیان"
                "Riga" -> item.capital = "ریگا"
                "Beirut" -> item.capital = "بیروت"
                "Maseru" -> item.capital = "ماسرو"
                "Monrovia" -> item.capital = "مونروویا"
                "Tripoli" -> item.capital = "طرابلس"
                "Vaduz" -> item.capital = "فادوتس"
                "Vilnius" -> item.capital = "ویلنیوس"
                "Luxembourg" -> item.capital = "لوکزامبورگ"
                "Skopje" -> item.capital = "اسکوپیه"
                "Antananarivo" -> item.capital = "آنتاناناریوو"
                "Lilongwe" -> item.capital = "لیلونگوه"
                "Kuala Lumpur" -> item.capital = "کوالالامپور"
                "Malé" -> item.capital = "ماله"
                "Bamako" -> item.capital = "باماکو"
                "Valletta" -> item.capital = "والتا"
                "Majuro" -> item.capital = "ماجورو"
                "Nouakchott" -> item.capital = "نواکشوت"
                "Port Louis" -> item.capital = "پورت لوئیس"
                "Mexico City" -> item.capital = "مکزیکو سیتی"
                "Palikir" -> item.capital = "پالیکیر"
                "Chișinău" -> item.capital = "کیشیناو"
                "Monaco" -> item.capital = "موناکو ویل"
                "Ulan Bator" -> item.capital = "اولان باتور"
                "Podgorica" -> item.capital = "پودگوریتسا"
                "Rabat" -> item.capital = "رباط"
                "Maputo" -> item.capital = "ماپوتو"
                "Naypyidaw" -> item.capital = "نایپیداو"
                "Windhoek" -> item.capital = "ویندهوک"
                "Kathmandu" -> item.capital = "کاتماندو"
                "Amsterdam" -> item.capital = "آمستردام"
                "Wellington" -> item.capital = "ولینگتون"
                "Managua" -> item.capital = "ماناگوآ"
                "Niamey" -> item.capital = "نیامی"
                "Abuja" -> item.capital = "آبوجا"
                "Oslo" -> item.capital = "اسلو"
                "Muscat" -> item.capital = "مسقط"
                "Islamabad" -> item.capital = "اسلام آباد"
                "Ramallah" -> item.capital = "رام الله"
                "Panama City" -> item.capital = "پاناما سیتی"
                "Port Moresby" -> item.capital = "پورت مورسبی"
                "Asunción" -> item.capital = "آسونسیون"
                "Lima" -> item.capital = "لیما"
                "Manila" -> item.capital = "مانیل"
                "Warsaw" -> item.capital = "ورشو"
                "Lisbon" -> item.capital = "لیسبون"
                "Doha" -> item.capital = "دوحه"
                "Pristina" -> item.capital = "پریشتینا"
                "Bucharest" -> item.capital = "بخارست"
                "Moscow" -> item.capital = "مسکو"
                "Kigali" -> item.capital = "کیگالی"
                "Basseterre" -> item.capital = "باسه تر"
                "Castries" -> item.capital = "کاستریس"
                "Kingstown" -> item.capital = "کینگستون"
                "Apia" -> item.capital = "آپیا"
                "City of San Marino" -> item.capital = "سن مارینو"
                "São Tomé" -> item.capital = "سائوتومه"
                "Riyadh" -> item.capital = "ریاض"
                "Dakar" -> item.capital = "داکار"
                "Belgrade" -> item.capital = "بلگراد"
                "Victoria" -> item.capital = "ویکتوریا"
                "Freetown" -> item.capital = "فری تاون"
                "Singapore" -> item.capital = "سنگاپور"
                "Bratislava" -> item.capital = "براتیسلاوا"
                "Ljubljana" -> item.capital = "لیوبلیانا"
                "Honiara" -> item.capital = "هونیارا"
                "Mogadishu" -> item.capital = "موگادیشو"
                "Pretoria" -> item.capital = "پرتوریا"
                "Juba" -> item.capital = "جوبا"
                "Madrid" -> item.capital = "مادرید"
                "Colombo" -> item.capital = "کلمبو"
                "Khartoum" -> item.capital = "خارطوم"
                "Paramaribo" -> item.capital = "پاراماریبو"
                "Lobamba" -> item.capital = "لوبامبا"
                "Stockholm" -> item.capital = "استکهلم"
                "Bern" -> item.capital = "برن"
                "Damascus" -> item.capital = "دمشق"
                "Taipei" -> item.capital = "تایپه"
                "Dushanbe" -> item.capital = "دوشنبه"
                "Dodoma" -> item.capital = "دودوما"
                "Bangkok" -> item.capital = "بانکوک"
                "Dili" -> item.capital = "دیلی"
                "Lomé" -> item.capital = "لومه"
                "Port of Spain" -> item.capital = "پرت آو اسپاین ( بندر اسپانیا )"
                "Tunis" -> item.capital = "تونس"
                "Ankara" -> item.capital = "آنکارا"
                "Kampala" -> item.capital = "کامپالا"
                "Kiev" -> item.capital = "کی\u200Cیف"
                "Abu Dhabi" -> item.capital = "ابوظبی"
                "London" -> item.capital = "لندن"
                "Washington, D.C." -> item.capital = "واشینگتن، دی.سی"
                "Montevideo" -> item.capital = "مونته ویدئو"
                "Tashkent" -> item.capital = "تاشکند"
                "Port Vila" -> item.capital = "پورت ویلا"
                "Caracas" -> item.capital = "کاراکاس"
                "Hanoi" -> item.capital = "هانوی"
                "Sana'a" -> item.capital = "صنعا"
                "Lusaka" -> item.capital = "لوساکا"
                "South Tarawa" -> item.capital = "تاراوای جنوبی"
            }
        }

        setVaticanCapital()
    }

    fun setVaticanCapital(){

        for (item in allCountries){

            if (item.name.equals("واتیکان"))
                item.capital = "واتیکان سیتی"
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

        for (item in allCountries){

            items.add(item.name)
        }

        val collator: Collator = Collator.getInstance(Locale("fa", "IR"))
        collator.setStrength(Collator.PRIMARY)
        Collections.sort(items, collator)

        val tmp: MutableList<Country> = ArrayList()
        tmp.addAll(allCountries)
        allCountries.clear()

        for (name in items){

            for (country in tmp){

              if (name.equals(country.name)) {
                  allCountries.add(country)
                  tmp.remove(country)
                  break
              }

            }
        }

        items.clear()
        tmp.clear()

    }

    ///// hide keyboard /////

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

}