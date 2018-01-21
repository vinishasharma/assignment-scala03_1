package edu.knoldus

@SerialVersionUID(12)
class Person(val name: String,
             val age: Int,
             @transient val day: String = "Default day is sunday",
             val address: Address,
             val salary: Double,
             @transient val luckyNo: Int = 0){

  override def toString: String = {
    s"\nName: $name\nAge: $age\nDay: $day\nAddress: $address" +
      s"\nSalary: $salary\nLucky No:$luckyNo"
  }
}




