import java.util.*
import kotlin.collections.ArrayList

class Student(    val name: String,
                  val Id : Int){
    var lessonList : ArrayList<Lesson> = arrayListOf()
    private var gradeList : MutableMap<Lesson,Double> = mutableMapOf()
    fun printLessonList(){
        for (lesson in lessonList){
            println(lesson.name)
        }

    }
    fun addGrade(lesson: Lesson , grade:Double ){
        if (lesson !in lessonList){
            println("invalid lesson")
            return
        }
        gradeList[lesson] = grade

    }
    fun getAverage ():Double{
        var sum = 0.0
        for (grade in gradeList){
            sum+= grade.value
        }

        return  sum / gradeList.size



    }

}
class Lesson(val name : String,
             val Id : Int,
             var teacherName : Teacher,
             val units : Int,
             var examDate : Date? = null){

    var averageOfStudents: Double? = null
    var studentList : ArrayList<Student> = arrayListOf()
    fun addStudent(student: Student){
       this.studentList.add(student)
        student.lessonList.add(this)
    }
}
class Teacher(var name: String,   val Id : Int){}
var sara = Student("Sara" , 25)
var nima = Student("Nima" , 45)
var mina = Student("Mina" , 63)
var behnam = Student("Behnam" , 12)
var teacher1 = Teacher("Behdad Razi" ,32)
var mathLesson = Lesson("RiaziPaye" , 21,teacher1, 2 )
var physicsLesson = Lesson("physics" , 21,teacher1, 2 )

fun main(){
    mathLesson.addStudent(sara)
    mathLesson.addStudent(nima)
    mathLesson.addStudent(mina)
    mathLesson.addStudent(behnam)
    physicsLesson.addStudent(behnam)
    behnam.addGrade(mathLesson,12.0)
    behnam.addGrade(physicsLesson, 15.0)
    println(behnam.getAverage())

    var date1 = Date()
    println(date1)





}