package com.lightbend.training.scalatrain

case class Time(val hours: Int = 0 , val minutes: Int = 0) extends Ordered[Time]{
  
   require(hours>=0 && hours<24 , "Invalid hours")
   require(minutes>=0 && minutes<60 , "Invalid minutes")
    val  asMinutes: Int = hours*60+minutes

    def minus(that:Time):Int = this.asMinutes-that.asMinutes
    def -(that:Time):Int= minus(that)

  override def toString: String = f"$hours%02d:$minutes%02d"

  override def compare(that: Time): Int = this.asMinutes - that.asMinutes

}

object Time{

  def fromMinutes(m:Int): Time = {
    val hours:Int = m/60
    val minutes:Int = m%60
     Time(hours,minutes)
  }
}