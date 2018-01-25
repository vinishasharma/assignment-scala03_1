package edu.knoldus

import java.io.{File, PrintWriter}

import edu.knoldus.OperationCall.{personData, personJsonString}
import org.json4s.DefaultFormats
import org.json4s.jackson.Json

import scala.io.Source

class Operation {

  implicit val formats: DefaultFormats = DefaultFormats
  def toJsonString(person: Person): String = {
    Json.apply(formats).write(person)
  }

  def writeToFile(personString: String): Unit = {
    val fileWriter: PrintWriter = new PrintWriter(new File("PersonInfo.txt"))
    fileWriter.write(personString)
    fileWriter.close()
  }

  def readFromFile(personFile : String): String ={
    Source.fromFile(personFile).getLines.mkString
  }

  def toPersonObject(personString: String) : Person ={
    Json.apply(formats).read[Person](personString)
  }
}
