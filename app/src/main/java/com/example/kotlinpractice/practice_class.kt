package com.example.kotlinpractice

// 코틀린 자바와 다른점은 파일이름이랑 클래스 이름 달라도된다. 안 파일안에 여러 클래스 넣어도 된다.


class Human {

    val name = "taeki"

    fun eatingCake() {
        println("This is so good~~~")
    }
}

// 주 생성자, 부 생성자
class Human2 (val name: String = "Anonymous") {

    // 부 생성자
    constructor(name: String, age: Int) : this(name) {
        println("my name is ${name}, ${age} years old")
    }

    init {
        println("New human has been born!!")
    }

    fun printName() {
        println("Human's name is ${name}")
    }

}

fun main() {
    // 코틀린에선 자바처럼 new 키워드 필요없이 그냥 클래스 생성하면 됨
    val human = Human()
    human.eatingCake()
    println("this human's name is ${human.name}")

    val human2 = Human2()
    val human3 = Human2("taeki")
    val human4 = Human2("taeki", 29)
}
