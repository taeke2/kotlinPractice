package com.example.kotlinpractice

fun main () {
    println(square(12))
    println(nameAge("taeki", 99))
}

// 1. Lamda
// 람다식은 우리가 마치 value처럼 다룰 수 있는 익명함수이다.
// 1) 메소드의 파라미터로 넘겨줄 수가 있다. fun maxBy(a :Int) 람다를 이용하면 파라미터에 function을 넣을 수 있다는 말임
// 2) return 값으로 사용할 수가 있다.

// 람다의 기본 정의
// val lamdaName : Type = {argumentList -> codeBody}

// ** 수의 제곱을 리턴해주는 람다식
// val : val 또는 var 넣을수있음
// square : 람다식 이름
// (Int) -> (Int) : Int형을 넣어서 Int형으로 반환한다는 뜻임
// number : 앞에 Int 형이라고 말해뒀기 때문에 타입추론으로 number: Int 라고 안써도 됌
//val square : (Int) -> (Int) ={number -> number * number}
val square ={ number: Int -> number * number }  // 타입선언을 안한다면 이렇게 앞에 argumentList에 타입을 명시해줘야함

// ** 이름과 나이가 같이 출력되는 람다식
val nameAge = {name: String, age: Int ->
    "my name is ${name} I'm ${age}"
}
