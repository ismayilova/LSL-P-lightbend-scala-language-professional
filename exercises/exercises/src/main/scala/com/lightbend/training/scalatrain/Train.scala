package com.lightbend.training.scalatrain
 import  scala.collection.immutable.Seq

case class Station(name:String )
case class Train(info: TrainInfo , schedule: Seq[(Time , Station)]){
  require(schedule.take(2).size ==2 , "Schedule must contain at least 2 elements")
  val stations: Seq[Station] = schedule.map(_._2) //extract 2 element from tuple

  def timeAt(station: Station):Option[Time] =
    //stations.find(_ == station)
   // schedule.find(timeAndStation =>timeAndStation._2 == station).map(_._1) //map(timeAndStation(time,station))  //VERSION1
    schedule.find {    //VERSION2
      case (_ , s) => s == station

    }.map{
      case (time , _) => time
    }



}

abstract class TrainInfo {
  def number:Int
}
case class InterCityExpress(number: Int , hasWifi:Boolean = false) extends TrainInfo
case class RegionalExpress( number:Int) extends TrainInfo
case class BavarianRegional( number:Int) extends TrainInfo