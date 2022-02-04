# CryptoApp

CryptoApp is an app to view Crypto coins with their details.

### Screenshots

![Screenshot 1](screenshots/1.png)
![Screenshot 2](screenshots/2.png)

### Dependencies

    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.4.1'
    implementation 'com.google.android.material:material:1.5.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.3'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    implementation 'androidx.recyclerview:recyclerview:1.2.1'

    //Coroutines Dependencies
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.7"
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.2.1'

    // Coroutine Lifecycle Scopes
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"

    // Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation "com.squareup.okhttp3:okhttp:5.0.0-alpha.2"
    implementation "com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2"

    // Navigation Components
    implementation "androidx.navigation:navigation-fragment-ktx:2.2.1"
    implementation "androidx.navigation:navigation-ui-ktx:2.2.1"

    //Koin
    implementation "org.koin:koin-core:2.2.0"
    implementation 'org.koin:koin-android:2.2.0'
    implementation 'org.koin:koin-android-viewmodel:2.2.0'
    implementation 'org.koin:koin-androidx-scope:2.0.1'

    //Room
    implementation "androidx.room:room-ktx:2.4.1"
    kapt "androidx.room:room-compiler:2.4.1"


The most important dependencies used are:
- Retrofit to download the data from the Internet.
- RecyclerView to display the asteroids in a list.
- Koin for dependency injection. 

The following components from the Jetpack library are used:
- ViewModel
- Room
- LiveData
- View Binding
- Navigation


The application:
- Includes the Main screen with a list of clickable coins
- Includes a Details screen that displays the selected coin data once it’s clicked in the Main screen
- Downloads and parses data from CoinPaprika API.


## Built With

To build this project the CoinPaprika API is used, which can be found here:
https://api.coinpaprika.com/
