```kotlin
suspend fun sub(k:String, factory: (suspend () -> T)?, block:(suspend (eView<T>)->Unit)?):eView<T> {
    val view = k.split(".").fold(this){acc, curr -> 
    if(acc.subViews == null) acc.subViews = hashMapOf()
    if(curr in acc.subViews!!) acc.subViews!![surr]!!
    else {
        val view = eView(factory)
        acc.subViews?.put(k, view)
        view
    }
  }
    block?.invoke(view)
    return view
}

```

1. 인자를 스트링 k, 아무것도 받지않고 T를 리턴하는 람다인 factory, eView<T>를 받고 아무것도 리턴하지 않는 block을 인자로 받고, eView<T>를 리턴한다.

2. 인자로 받은 k를 .으로 split하여 배열을 만들고, fold함수를 돌면서, acc (누적된 것)이 null이면 acc.subViews에 hashMapOf()를 할당합니다.

   만약 현재 요소가 acc.subViews 있다면, acc.subViews에서 현재 요소로 키 이름이 저장된 값을 리턴합니다. 그게 아니라면,  factory로 eView를 만들고, acc.subView에 그 키 이름으로 view를 저장하고 view를 리턴합니다. 

