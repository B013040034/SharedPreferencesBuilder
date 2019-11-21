# SharedPreferencesBuilder
Easy way to use SharePreferences

# Explain
### 1. create your *Singleton* class
``` kotlin
object Editor {}
```
### 2. add parameter extends below classes  
```
Pref.Int  
Pref.Boolean  
Pref.String  
Pref.Float  
Pref.Long  
Pref.Object<T>
```
### 3. set SharePreferences name  
``` kotlin
@PrefName("NAME")
```
### 4. set defaultValue if you want  
``` kotlin
@PrefDefaultInt(-1)  
@PrefDefaultDouble(5.0)  
@PrefDefaultFloat(0f)  
@PrefDefaultString("stop")  
@PrefDefaultBolean(true)  
```
### 5. init in Application
``` kotlin
PrefBuilder(Editor, context).build()
```
### 6. set and get value
``` kotlin
//int
var books = Editor.books.value
Editor.books.value = 87

//string
var name = Editor.firstName.value
Editor.firstName.value = "Aslan"    

// bool
Editor.isSetUp.value
Editor.isSetUp.value = true
        
//object
Editor.iotData.value = IotData("456", true, "dd", null)
var iotData = Editor.iotData.value
```

# Example
``` kotlin
object Editor {
    @PrefName("SIT")
    @PrefDefaultInt(-1)
    lateinit var sits: Pref.Int

    @PrefName("BOOK")
    @PrefDefaultInt(0)
    lateinit var books: Pref.Int

    @PrefName("FIRST_NAME")
    lateinit var firstName: Pref.String

    @PrefName("LASTNAME")
    @PrefDefaultString("--")
    lateinit var lastName: Pref.String

    @PrefName("IS_SET_UP")
    lateinit var isSetUp: Pref.Boolean

    @PrefName("OBJECT")
    lateinit var iotData: Pref.Object<IotData>
}
```

# Extra
### support more than one classes
``` kotlin
PrefBuilder(Editor, context).build()
PrefBuilder(Editor2, context).build()
PrefBuilder(Editor3, context).build()
```
### *className* below is using the ClassName, so do not use sample name in param
``` kotlin
context.getSharedPreferences(className, 0)
```
do not write below
``` kotlin
object Editor {
    @PrefName("Editor")
    lateinit var sits: Pref.Int
}
```
