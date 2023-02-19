package com.example.kotlinpractice

// 코틀린 자바와 다른점은 파일이름이랑 클래스 이름 달라도된다. 안 파일안에 여러 클래스 넣어도 된다.


open class Human(val name: String = "Anonymous") {

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

    open fun singASong() {
        println("lalala")
    }
}

// 상속 : open을 써줘야한다
class Korean : Human() {

    // 오버라이딩 해주려면 그 메서드도 open을 해줘야한다.
    override fun singASong(){
        // 부모 클래스의 메서드를 사용하고 싶으면 super 를 쓰면 된다.
        super.singASong()
        println("라라라")
        println("korean name is ${name}")   // name 사용이 가능한 이유는 생성자에서 Anonymous라는 기본값을 설정해줬기 때문.
    }
}

fun main() {
    // 코틀린에선 자바처럼 new 키워드 필요없이 그냥 클래스 생성하면 됨
//    val human = Human()
//    human.printName()
//    println("this human's name is ${human.name}")
//
//    val human2 = Human("taeki")
//    val human3 = Human("taeki", 29)

    val korean = Korean()
    korean.singASong()
}
