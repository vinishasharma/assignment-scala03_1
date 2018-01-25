package edu.knoldus

import java.io.PrintWriter
import org.apache.log4j.Logger
import scala.io.Source
import java.io.File
import org.json4s.DefaultFormats
import org.json4s.jackson.Json

object OperationCall extends App {

  val log = Logger.getLogger(this.getClass)
  val address = new Address("wall street", 21)
  val person = new Person("vinisha", 23, "wednesday", address, 50000, 2)
  log.info(s"Person object value: \n $person")

  val operation = new Operation
  val personJsonString = operation.toJsonString(person)
  log.info(s"\nJson String: \n$personJsonString")

  operation.writeToFile(personJsonString)

  val personData = operation.readFromFile("PersonInfo.Txt")
  val personObject = operation.toPersonObject(personData)
  log.info(s"\nperson object read from file: \n $personObject")

}
