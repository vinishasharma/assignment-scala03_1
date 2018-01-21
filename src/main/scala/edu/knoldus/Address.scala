package edu.knoldus

@SerialVersionUID(100)
class Address(val street: String, val houseNo: Int) {

  override def toString: String = s"Street: $street House No.: $houseNo"
}