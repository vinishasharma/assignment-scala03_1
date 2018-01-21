package edu.knoldus

import java.io.PrintWriter
import org.apache.log4j.Logger
import scala.io.Source
import java.io.File
import org.json4s.DefaultFormats
import org.json4s.jackson.Json

object OperationCall extends App {

  val logger = Logger.getLogger(this.getClass)
  val address = new Address("wall street", 12)
  val person = new Person("vinisha", 23, "wednesday", address, 50000, 2)
  
  implicit val formats = DefaultFormats
  val personJsonString = Json.apply(formats).write(person)
  logger.info(s"Person object value: \n $person")
  logger.info(s"Json String: \n$personJsonString")
  val fileWriter: PrintWriter = new PrintWriter(new File("PersonInfo.txt"))
  fileWriter.write(personJsonString)
  fileWriter.close()

  val personData = Source.fromFile("PersonInfo.txt").getLines.mkString
  val personObject= Json.apply(formats).read[Person](personData)
  logger.info(s"\nperson object read from file: \n $personObject")

}
