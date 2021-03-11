package com.lightbend.training.scalatrain

class JourneyPlanner(trains: Set[Train]) {
   val stations : Set[Station] = trains.flatMap(_.stations)
   def trainsAt(station: Station): Set[Train] = trains.filter(train => train.stations.contains(station))
   def stopsAt(station: Station): Set[(Time , Train)] =
      for{
         train <-trains
         //timeAndStation <- train.schedule if timeAndStation._2 == station
        //  (time,s)<- train.schedule if s ==station
         time <-train.timeAt(station)
      } yield time -> train



   def isShortTripF(from:Station , to:Station):Boolean = {
      //val train: Train = ???
      trains.exists(train => //will iterate
      train.stations.dropWhile(station => station!=from).drop(1).take(2).contains(to)
      )
      //will drop every element  till reached from
      // and then drop the from too --so we will have at most two elements
      //and if one of that 2 element is = to then its a short trip
   }


   def isShortTrip(from:Station , to:Station):Boolean = {
      //iterate each train  -- and searches for pattern
      trains.exists(train => train.stations.dropWhile(_ !=from) match {
         case `from` +: `to` +: _ => true
         case `from` +: _ +: `to` +: _ => true
         case _ => false
      }

      )

   }



}
