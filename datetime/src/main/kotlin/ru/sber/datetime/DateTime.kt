package ru.sber.datetime

import java.time.*
import java.time.format.DateTimeFormatter
import java.util.*


// 1.
fun getZonesWithNonDivisibleByHourOffset(): Set<String> {
    val setZone: MutableSet<String> = mutableSetOf()
    for(i in ZoneId.getAvailableZoneIds()){
        if(TimeZone.getTimeZone(i).rawOffset % 3600000 != 0){
            setZone.add(i)
        }
    }
    return setZone
}

// 2.
fun getLastInMonthDayWeekList(year: Int): List<String> {
    val listLastDay = mutableListOf<String>()
    for( i in Month.values()){
        val month = YearMonth.of(year, i)
        val lastDay = month.atEndOfMonth().dayOfWeek
        listLastDay.add(lastDay.toString())
    }
    return listLastDay
}

// 3.
fun getNumberOfFridayThirteensInYear(year: Int): Int {
    var blackFridayCount = 0
    for( i in Month.values()){
        var date = LocalDate.of(year, i, 13)
        if(date.dayOfWeek == DayOfWeek.FRIDAY ){
            blackFridayCount ++
        }
    }
    return blackFridayCount
}

// 4.
fun getFormattedDateTime(dateTime: LocalDateTime): String {
    val date = dateTime.format(DateTimeFormatter.ofPattern( "dd MMM uuuu, HH:mm" ,  Locale.US ))
    return date
}
