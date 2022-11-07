# KMM Todo App For Android & iOS
Simple Android and iOS Todo Mobile App using KMM with SqlDelight as local database.

## Working

Update Following line in "shared.podspec" under shared module, before running iOS app:


```podspec
spec.libraries                = 'c++','sqlite3'
```


If you get error related to sqlite while running ios app. Run "pod install" in iosApp folder once and try again
