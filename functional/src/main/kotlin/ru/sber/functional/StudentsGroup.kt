package ru.sber.functional

class StudentsGroup {

    var students = listOf(
        Student(firstName = "Бенедикт", lastName = "Кембербетч", averageRate = 5.0),
        Student(firstName = "Бенефис", lastName = "Сабантуй", averageRate = 6.0),
        Student(firstName = "Бергамот", lastName = "Киберскотч", averageRate = 7.0),
        Student(firstName = "Баттелфилд", lastName = "Овервотч", averageRate = 8.0)
    )

    fun filterByPredicate(predicate: (Student) -> Boolean): List<Student> {
        return students.filter(predicate)
    }
}
