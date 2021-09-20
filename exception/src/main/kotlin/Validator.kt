abstract class Validator<T> {
    abstract fun validate(value: T?): List<ErrorCode>
}

class FioValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val reg = "[аА-яЯёЁ]+$".toRegex()
        value?.let {
            if(it.length == 0) return listOf(ErrorCode.INVALID_ZERO)
            if(it.length > 16) return listOf(ErrorCode.INVALID_LENGTH)
            if(!it.matches(reg)) return listOf(ErrorCode.INVALID_LANGUAGE)
        } ?: return listOf(ErrorCode.INVALID_ZERO)
        return listOf()
    }
}

class PhoneValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val reg = "(7|8)[0-9]{10}$".toRegex()
        value?.let {
            if(it.length == 0) return listOf(ErrorCode.INVALID_ZERO)
            if(it.length != 11) return listOf(ErrorCode.INVALID_LENGTH)
            if(!it.matches(reg)) return listOf(ErrorCode.INVALID_PHONE)
        } ?: return listOf(ErrorCode.INVALID_ZERO)
        return listOf()
    }
}

class MailValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val reg = "^([a-zA-Z0-9_-]+\\.)*[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)*\\.[a-zA-Z]{2,6}\$".toRegex()
        value?.let {
            if(it.length == 0) return listOf(ErrorCode.INVALID_ZERO)
            if(it.length > 32) return listOf(ErrorCode.INVALID_LENGTH)
            if(!it.matches(reg)) return listOf(ErrorCode.INVALID_MAIL)
        } ?: return listOf(ErrorCode.INVALID_ZERO)
        return listOf()
    }
}

class SnilsValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val reg = "[0-9]+".toRegex()
        value?.let {
            if(it.length == 0) return listOf(ErrorCode.INVALID_ZERO)
            if(it.length != 11) return listOf(ErrorCode.INVALID_LENGTH)
            if(!it.matches(reg)) return listOf(ErrorCode.INVALID_SNILS)

            var sum = 0
            var checkDigit = 0
            var controlNumber = it.substring(9,11).toInt()

            for (i in 0 .. 9) {
                sum += (it[i] - '0') * (9 - i);
            }
            if (sum < 100) {
                checkDigit = sum;
            } else if (sum > 101) {
                checkDigit = sum % 101
                if (checkDigit == 100) {
                    checkDigit = 0;
                }
            }
            if(controlNumber != checkDigit)
                return listOf(ErrorCode.INVALID_CHECK_SNILS)
            } ?: return listOf(ErrorCode.INVALID_ZERO)
        return listOf()
    }
}

