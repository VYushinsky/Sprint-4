class ValidationException(val errorCode: Array<ErrorCode>) : RuntimeException(errorCode.joinToString(",") { it.msg })

enum class ErrorCode(val code: Int, val msg: String) {
    INVALID_CHARACTER(100, "Недопустимый символ"),
    INVALID_LENGTH(101, "Недопустимая длина"),
    INVALID_ZERO(102, "Пустая строка"),
    INVALID_LANGUAGE (103, "Используется только кириллица"),
    INVALID_PHONE(104, "Номер начинается с 7 или 8"),
    INVALID_MAIL(105, "Адрес почты введен некорректно"),
    INVALID_SNILS(106, "Номер СНИЛС состоит из цифр"),
    INVALID_CHECK_SNILS(107, "Валидация СНИЛС не пройдена")
}