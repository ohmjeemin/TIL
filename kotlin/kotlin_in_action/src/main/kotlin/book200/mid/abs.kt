package book200.mid

//추상 클래스

//학생, 교수, 직원 클래스를 하나의 타입으로 묶어주는 클래스
open class Personn {
    open fun getSalary() = 0
}

//학생 클래스, tuition는 한학기 등록금
class Student(private val tuition:Int):Personn() {
    //학생은 등록금을 납부하므로 salary를 음수처리
    override fun getSalary() = -tuition
}
//교수 클래스, classCount는 진행하는 수업의 수
class Professor(private val classCount:Int):Personn(){
    override fun getSalary() = classCount + 120
}

