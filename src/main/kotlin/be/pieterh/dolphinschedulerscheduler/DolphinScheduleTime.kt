package be.pieterh.dolphinschedulerscheduler

class DolphinScheduleTime(builder: Builder) {
    val complementStartDate: String = builder.complementStartDate!!
    val complementEndDate: String = builder.complementEndDate!!

    class Builder {
        var complementStartDate: String? = null
        var complementEndDate: String? = null

        fun withComplementStartDate(complementStartDate: String?): Builder {
            this.complementStartDate = complementStartDate
            return this
        }

        fun withComplementEndDate(complementEndDate: String?): Builder {
            this.complementEndDate = complementEndDate
            return this
        }

        fun build(): DolphinScheduleTime {
            return DolphinScheduleTime(this)
        }
    }
}
