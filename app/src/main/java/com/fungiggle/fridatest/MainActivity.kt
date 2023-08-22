package com.fungiggle.fridatest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect

import com.fungiggle.fridatest.ui.theme.FridaTestTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.Request
import supercaller.Supercaller

const val TAG = "Frida Test"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FridaTestTheme {
                LaunchedEffect(Unit){
                    CoroutineScope(Dispatchers.IO).launch {

                        val pinner = CertificatePinner.Builder()
                            .add("search5-noneu.truecaller.com","sha256/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=")
                            .build()

                        val client = OkHttpClient()
                        val number = "923149494094"
                        val countrycode = "92"
                        var url = "https://s.callapp.com"
                        url += "/callapp-server/csrch?cpn=%2B${number}&myp=gp.109248288895753790064&ibs=1&cid=1&tk=0018125492&cvc=2100"

                        val request = Request.Builder()
                            .url(url)
                            .addHeader("Host", "s.callapp.com")
                            .addHeader("User-Agent", "Truecaller/13.29.6 (Android;10)")
                            .build()

//                        try {
//                            val response: Response = client.newCall(request).execute()
//
//                            if (response.isSuccessful) {
//                                val responseBody = response.body?.string()
//                                Log.e(TAG,"Response Code: ${response.code}: $responseBody")
//                            } else {
//                                Log.e(TAG,"Request failed with code: ${response.code}")
//                            }
//                        } catch (e: Exception) {
//                            Log.e(TAG,"An error occurred: ${e.message}")
//                        }

                        //12155909700
                        val type1 = Supercaller.getPhoneDetailsType1(
                            "2155909700",
                            "US"
                        )
                        Log.e(TAG,"Type1: ${type1}")

                        val phone = "12155909700"
                        val type2 = Supercaller.getPhoneDetailsType2(phone)
                        Log.e(TAG,"Type2: ${type2}")

                        val type3 = Supercaller.getPhoneDetailsType3(phone)
                        Log.e(TAG,"Type3: ${type3}")

                    }

                }
            }
        }

    }
}
