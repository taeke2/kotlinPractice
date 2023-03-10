package com.example.kotlinpractice

import java.util.*

fun main() {
    nullcheck()
    ignoreNulls(str = "abcde")
}

// ** 함수
// fun 함수명 (파라미터)

// 1. 반환형이 없는 함수
// fun helloWorld() : Unit{         // Unit은 자바에서 void와 같다. 리턴 형식이 없다는 뜻. 없으면 생략 가능
fun helloWorld() {
    println("Hello Kotlin!")
}

// 2. 반환형이 있는 함수
// 타입은 변수 뒤에 써준다. 자바와 다르게 뒤에 온다. 형태 첫번째 글자는 대문자.
fun add(a: Int, b: Int): Int {
    return a + b
}

// ===================================================================================================

// ** var VS val
// val = value 변경 불가능
// var = variable 변경 가능
// 타입 추론이 가능해서 초기화 한다면 타입 생략 가능함
fun varval() {
    val a: Int = 100
    var b: Int = 200
    b = 300
    val c = 100
    var d = 100
    var e: String
}

// ===================================================================================================

// ** String Template
// $표시 사용, $표시만 해도 되지만 괄호 써주는게 좋다. 쓰는거 습관들이자.
fun stringTemplate() {
    val name = "taeki"
    val lastName = "Heo"
    println("my name is ${name + lastName}")
    // 기호 $를 쓰고 싶으면 역슬래쉬 사용
    println("this is 20\$a")
}

// ===================================================================================================

// ** 조건식
// 두 수의 크기 비교 후 큰 수 리턴하는 함수
// 기존
fun maxBy1(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

// 코틀린에선 삼항연산자가 없기 때문에 이렇게 사용한다.
fun maxBy2(a: Int, b: Int) = if (a > b) a else b

// 코틀린에선 when 도 있다. 다른 언어에서 switch문 역할임.
fun checkNum(score: Int){
    when(score){
        0 -> println("this is 0")
        1 -> println("this is 1")
        2,3 -> println("this is 2 or 3")
        else -> println("I don't know") // function일 때는 else가 생략 가능하다.
    }

    var b = when(score) {
        1 -> 1
        2 -> 2
        else -> 3   // 값을 넣어줄 때는 else가 필요하다.
    }

    // 점수에 따른 (범위가 있는)
    when (score){
        in 90..100 -> println("You are genius")
        in 80..90 -> println("not bad")
        else -> println("okay") // 여기서는 else 생략 가능
    }
}

// ===================================================================================================

// ** Expression vs Statement
// 뭔가를 뽀짝뽀짝 해서 값을 만들어내면 Expression
// 위 점수에서 처럼 결과가 값이 아닌 다른 형태로 나오면 Statement 라고 함
// 코틀린에서 모든 function은 Expression이다. 아무것도 안적힌 것도 Unit 타입을 반환하기 때문

// ===================================================================================================

// ** Array and List
// Array : 기본적으로 정해져 있는 사이즈가 있다. 메모리에 할당이 되어서 나와서 처음에 크기를 지정해야한다.
// List >> List & MutableList
// 1. List : 읽기 전용이라 수정 못함
// 2. MutableList : arrayList 생각하면된다. 수정가능
fun array() {
    val array = arrayOf(1,2,3)
    val list = listOf(1,2,3)

    // 타입을 여러개 해도 됨
    val array2 = arrayOf(1, "2", 3.4f)
    val list2 = listOf(1,"2",11L)

    array[0] = 3
    // list[0] = 3  // 오류
    var result = list.get(0)    // 이렇게 가져오는 것만 가능하다.

    // MutableList
    val arrayList = arrayListOf<Int>(1,2,3) // 이렇게 초기화 가능
    val arrayList2 = arrayListOf<Int>()
    arrayList2.add(10)
    arrayList2.add(20)
}

// ===================================================================================================

// ** 반복문 for / while

fun forAndWhile () {

    val students = arrayListOf("taeki", "james", "jenny", "jennifer")

    for( name in students){
        println("${name}")
    }

    var sum: Int = 0
    for(i in 1..10){    // 1부터 10까지 반복해라
        sum += i
    }
    println(sum)

    sum = 0
    for(i in 10 downTo 1){  // 10부터 1까지 (역으로는 downTo)
        sum += i
    }
    println(sum)

    sum = 0
    for(i in 1 until 100) { // until 은 뒤에를 포함하지 않는다 (1~99)
        sum+= i
        println(i)
    }
    println(sum)

    var index = 0
    while(index < 10){  // while
        println("current index : ${index}")
        index++
    }

    for((index, name) in students.withIndex()){ // index와 value값을 같이하고 싶을 때
        println("${index + 1}번째 학생 : ${name}")
    }
}

// ===================================================================================================

// ** Nullable / NonNull
// kotlin의 가장 큰 장점
fun nullcheck() {
    // NPE : Null Pointer Exception

    var name = "taeki"

    //  '?' >> Nullable Type
    var nullName: String? = null    // null을 넣고 싶으면 ?를 넣어주면 된다

    var nameInUpperCase = name.uppercase()

    var nullNameInUpperCase = nullName?.uppercase() // nullName이 null이 아니면 uppercase()를 적용하고 null이면 이 자체를 null로 반환한다.

    // '?:' >> 엘비스 연산자
    val lastName: String? = null
    val fullName = name + " " + (lastName?: "NO lastName")

    println(fullName)



}

// !! >> null일 리가 없어서 그냥 하면돼 라고 알려줌
// 확실하게 null이지 않은 이상 웬만하면 안쓰는게 좋다.
fun ignoreNulls(str: String?){
    val mNotNull: String = str!!
    val upper = mNotNull.uppercase()
    println("upper : ${upper}")

    // let function
    // 리시버 객체를 람다식 내부로 옮겨서 실행하는 구문
    val email: String?= "taekiheoXXXX@nana.vom"    // Nullable인 email 변수
    // email이 null이 아니면 let 함수 내부를 실행한다.
    email?.let{
        println("my email is ${email}") // email 대신에 it 넣어도 가능
    }
}



































