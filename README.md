# KMM Todo App For Android & iOS
Simple Android and iOS Todo Mobile App using KMM with SqlDelight as local database.



Update Following line in "shared.podspec" under shared moduel:


```podspec
spec.libraries                = 'c++','sqlite3'
```


If you get error related to sqlite while running ios app. Run "pod install" in iosApp folder once and try again
